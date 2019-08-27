public class GramaticaEvaluationVisitor extends gramaticaBaseVisitor<GRValue> {

    private Scope scope;
    private String javaCode = "";
    private boolean hasInput = false;

    public String getCode() {
        String imports = "";
        if (hasInput) {
            imports += "import java.util.Scanner\n";
            javaCode = "Scanner __myGrammarScanner = new Scanner(System.in);\n\n" + javaCode;
        }
        return imports + "\n\n public class result {\n public static void main (String[] args) { \n" + javaCode + "\n}\n}";
    }

    GramaticaEvaluationVisitor(Scope scope) {
        this.scope = scope;
    }

    @Override
    public GRValue visitAttribution(gramaticaParser.AttributionContext ctx) {
        GRValue newVal = this.visit(ctx.expr());
        String id = ctx.ID().getText();
        scope.assign(id, newVal);
        if (newVal.getType().equals("input")) {
            if(!hasInput) {
                hasInput = true;
            }
            if (newVal.equals("")) {
                javaCode += "float " + id + " = __myGrammarScanner.nextFloat();\n";
            } else {
                javaCode += "float " + id + " = " + newVal + ";" + "\n";
            }

        } else {
            javaCode += newVal.getType() + " " + id + " = " + newVal + ";" + "\n";
        }

        return GRValue.VOID;
    }

    @Override
    public GRValue visitExpr(gramaticaParser.ExprContext ctx) {
        GRValue leftVal;
        GRValue rightVal;
        if (ctx.value() != null) {
            return visit(ctx.value());
        }

        leftVal = visit(ctx.left);
        rightVal = visit(ctx.right);
        if (leftVal.getType().equals("input") || rightVal.getType().equals("input")) {
            // Não determinado
            return new GRValue(ctx.getText(), "input");
        } else {
            double left = leftVal.asDouble();
            double right = rightVal.asDouble();
            String op = ctx.op.getText();

            double result = 0;
            switch (op) {
                case "*":
                    result =  left * right;
                    break;
                case "/":
                    if (right == 0) {
                        throw new IllegalArgumentException("Ta dividindo por zero maluco ?! on: " + ctx.getText());
                    }
                    result =  left / right;
                    break;
                case "+":
                    result =  left + right;
                    break;
                case "-":
                    result =  left - right;
                    break;
                case ">=":
                    result = (left >= right)? 1: 0;
                    break;
                default:
                    throw new IllegalArgumentException("operador desconhecido " + op);
            }

            if (result == (int)result) {
                return new GRValue(result, "int");
            } else {
                return new GRValue(result, "float");
            }
        }
    }

    @Override
    public GRValue visitValue(gramaticaParser.ValueContext ctx) {
        if (ctx.expr() != null) {
            return visit(ctx.expr());
        }
        if (ctx.INT() != null) {
            return new GRValue(Integer.parseInt(ctx.INT().getText()), "int");
        }
        if (ctx.FLOAT() != null) {
            return new GRValue(Float.parseFloat(ctx.FLOAT().getText()), "float");
        }
        if (ctx.TRUE() != null) {
            return new GRValue(true, "boolean");
        }
        if (ctx.FALSE() != null) {
            return new GRValue(false, "boolean");
        }
        if (ctx.STRING() != null) {
            return new GRValue(ctx.STRING().getText());
        }
        if (ctx.NULL() != null) {
            return GRValue.NULL;
        }
        if (ctx.RAW_INPUT() != null) {
            return new GRValue(((gramaticaParser.AttributionContext) ctx.getParent().getParent()).ID().getText(), "input");
        }
        if (ctx.ID() != null) {
            GRValue v = scope.resolve(ctx.ID().getText());
            if(v == null) {
                throw new IllegalArgumentException(ctx.ID().getText() + " not instanciated!!");
            }else {
                return v;
            }
        }else {
            throw new IllegalArgumentException(ctx.toString() + "Type note recognizeble!");
        }

    }

    public GRValue visitPrint(gramaticaParser.PrintContext ctx) {
        GRValue message = visit(ctx.expr());
        javaCode += "System.out.println(" + message + ");\n";
        return GRValue.VOID;
    }

    @Override
    public GRValue visitStatement_block(gramaticaParser.Statement_blockContext ctx) {
        if (ctx.statement() != null) {
            visit(ctx.statement());
        } else if (ctx.block() != null) {
            javaCode += " {\n";
            visit(ctx.block());
            javaCode += " \n}\n";
        }
        return GRValue.VOID;
    }

    @Override
    public GRValue visitCondition_block(gramaticaParser.Condition_blockContext ctx) {
        GRValue exprValue = visit(ctx.expr());
        javaCode += "(" + exprValue.asDouble() + "==1)";
        visit(ctx.statement_block());

        return GRValue.VOID;
    }

    @Override
    public GRValue visitIf_exp(gramaticaParser.If_expContext ctx) {
        javaCode += "if ";
        visit(ctx.condition_block(0));

        if (ctx.condition_block().size() > 1) {
            for (int i = 1; i < ctx.condition_block().size(); i++) {
                javaCode += "else if ";
                visit(ctx.condition_block(i));
            }
        }

        if (ctx.statement_block() != null) {
            javaCode += "else ";
            visit(ctx.statement_block());
        }
        return GRValue.VOID;
    }

}
