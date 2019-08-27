import java.io.FileWriter;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class gramaticaCompiler {
    public static void main(String[] args) throws IOException {
        gramaticaLexer lexer = new gramaticaLexer(new ANTLRFileStream("src/source.gr"));
        gramaticaParser parser = new gramaticaParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.program();

        Scope scope = new Scope();
        GramaticaEvaluationVisitor visitor = new GramaticaEvaluationVisitor(scope);

        visitor.visit(tree);

        FileWriter fw = new FileWriter("result.java");
        fw.write(visitor.getCode());
        fw.close();

    }
}
