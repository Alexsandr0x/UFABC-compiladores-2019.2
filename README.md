## Projeto de Compiladores
### Prof. Isidro, 2019.2

## Como Usar

Modifique o arquivo ```source.gr``` para deixa-lo com o código que preferir na linguagem ```gramatica```. Ao executar ```GramaticaCompiler.java``` devera ser gerado um arquivo ```result.java``` com o resultado.

Para cada um dos itens, gere um exemplo em código. Para validar seu compilador, seu projeto deve transformar da Linguagem Especificada para uma linguagem específica (C, Java, outros). Valide seu compilador, procedendo com a compilação do programa-objeto gerado.

## Items obrigatorios:
1. Possui dois tipos de variaveis

Como a linguagem criada é fracamente tipada, o compilador, na transformação de ```gramatica``` para Java define o tipo na atribuição.

Exemplo de código original:

```
teste = 1;
teste2 = 2.3;
teste3 = "ola!";
teste4 = false;
```

código Java resultante:

```java
public static void main (String[] args) { 
	int teste = 1;
	float teste2 = 2.3f;
	String teste3 = "ola!";
	boolean teste4 = false;
}
```

2. Possui a estrutura If.. else

A linguagem permite a construção da forma ```if() {...} elif () {...} else {}```.

Exemplo do código original:
```
nota1 = 3.5;
nota2 = 7.3;
nota3 = 2;

media = (nota1 + nota2 + nota3)/3;

if (media >= 5) {
    print "passou!";
} elif (media >= 3) {
    print "talvez a REC salve!";
} else {
    print "vai ter que refazer a materia kkkkk";
}

print media;
```

código Java resultante:
```
public static void main (String[] args) { 
	float nota1 = 3.5f;
	float nota2 = 7.3f;
	int nota3 = 2;
	float media = 4.266666730244954f;
if (0.0==1) {
	System.out.println("passou!");
 
}
else if (1.0==1) {
	System.out.println("talvez a REC salve!");
 
}
else  {
	System.out.println("vai ter que refazer a materia kkkkk");
 
}
System.out.println(4.266666730244954f);

}
```

4. Operações Aritméticas executadas corretamente

Como pode ser visto no item 2. operações de soma e divisão estão contempladas na linguagem, bem como expressões usando de parenteses para evidenciar precedência.

5. Atribuições realizadas corretamente

Como pode ser visto no item 1, atribuições são feitas com diferentes tipos.

6. Possui operações de Entrada e Saída
O compilador reconhece se o código irá precisar de entrada e insere um scanner para leitura _limitado apenas para float_:

Código origem:
```
nota1 = input;
nota2 = input;
nota3 = input;

media = (nota1 + nota2 + nota3)/3;

print media;
```

Código Java resultante:
```
public static void main (String[] args) { 
Scanner __myGrammarScanner = new Scanner(System.in);

float nota1 = nota1;
float nota2 = nota2;
float nota3 = nota3;
float media = (nota1+nota2+nota3)/3;
System.out.println((nota1+nota2+nota3)/3);

}
```

7. Aceita números decimais

A linguagem aceita os tipos numéricos e os interpreta como ```float``` ou ```int```.

8. Verificar se a variável já foi previamente declarada

A linguagem, quando é necessário fazer atribuições ou operações lógicas faz um _evaluation_ da variável. Nesse momento, caso a variavel nao tenha sido declarada (e consequentemente, armazenada num dicionario interno de variáveis declaradas) então um erro ocorre na compilação.

Exemplo de código original: 
```
nota1 = 3.5;
nota2 = 7.3;
nota3 = 2;

media = (nota1 + nota2 + nota3 + nota4)/4;
```

output da execução:
```
Exception in thread "main" java.lang.IllegalArgumentException: nota4 not instanciated!!
	at GramaticaEvaluationVisitor.visitValue(GramaticaEvaluationVisitor.java:95)
	at GramaticaEvaluationVisitor.visitValue(GramaticaEvaluationVisitor.java:1)
	at gramaticaParser$ValueContext.accept(gramaticaParser.java:922)
	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visit(AbstractParseTreeVisitor.java:18)
	at GramaticaEvaluationVisitor.visitExpr(GramaticaEvaluationVisitor.java:28)
	at GramaticaEvaluationVisitor.visitExpr(GramaticaEvaluationVisitor.java:1)
	at gramaticaParser$ExprContext.accept(gramaticaParser.java:645)
	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visit(AbstractParseTreeVisitor.java:18)
	at GramaticaEvaluationVisitor.visitExpr(GramaticaEvaluationVisitor.java:32)
	at GramaticaEvaluationVisitor.visitExpr(GramaticaEvaluationVisitor.java:1)
	at gramaticaParser$ExprContext.accept(gramaticaParser.java:645)
	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visit(AbstractParseTreeVisitor.java:18)
	at GramaticaEvaluationVisitor.visitValue(GramaticaEvaluationVisitor.java:72)
	at GramaticaEvaluationVisitor.visitValue(GramaticaEvaluationVisitor.java:1)
	at gramaticaParser$ValueContext.accept(gramaticaParser.java:922)
	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visit(AbstractParseTreeVisitor.java:18)
	at GramaticaEvaluationVisitor.visitExpr(GramaticaEvaluationVisitor.java:28)
	at GramaticaEvaluationVisitor.visitExpr(GramaticaEvaluationVisitor.java:1)
	at gramaticaParser$ExprContext.accept(gramaticaParser.java:645)
	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visit(AbstractParseTreeVisitor.java:18)
	at GramaticaEvaluationVisitor.visitExpr(GramaticaEvaluationVisitor.java:31)
	at GramaticaEvaluationVisitor.visitExpr(GramaticaEvaluationVisitor.java:1)
	at gramaticaParser$ExprContext.accept(gramaticaParser.java:645)
	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visit(AbstractParseTreeVisitor.java:18)
	at GramaticaEvaluationVisitor.visitAttribution(GramaticaEvaluationVisitor.java:16)
	at GramaticaEvaluationVisitor.visitAttribution(GramaticaEvaluationVisitor.java:1)
	at gramaticaParser$AttributionContext.accept(gramaticaParser.java:313)
	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visitChildren(AbstractParseTreeVisitor.java:46)
	at gramaticaBaseVisitor.visitStatement(gramaticaBaseVisitor.java:33)
	at gramaticaParser$StatementContext.accept(gramaticaParser.java:237)
	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visitChildren(AbstractParseTreeVisitor.java:46)
	at gramaticaBaseVisitor.visitBlock(gramaticaBaseVisitor.java:26)
	at gramaticaParser$BlockContext.accept(gramaticaParser.java:171)
	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visitChildren(AbstractParseTreeVisitor.java:46)
	at gramaticaBaseVisitor.visitProgram(gramaticaBaseVisitor.java:19)
	at gramaticaParser$ProgramContext.accept(gramaticaParser.java:122)
	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visit(AbstractParseTreeVisitor.java:18)
	at gramaticaCompiler.main(gramaticaCompiler.java:18)
```