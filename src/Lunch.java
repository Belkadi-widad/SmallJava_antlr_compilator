import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import static  org.antlr.v4.runtime.CharStreams.fromFileName;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Lunch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String source = "./test.txt";
            CharStream input = fromFileName(source);
            Expr_arithmLexer lexer = new Expr_arithmLexer(input);
            Expr_arithmParser parser = new Expr_arithmParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.r();
            TableSymbol TableSymbol = new TableSymbol();
            Quadruplets Quads = new Quadruplets();
            Errors_and_warnings erreurs = new Errors_and_warnings();
            Expr_Visitor visitor = new Expr_Visitor(TableSymbol,Quads,erreurs);
            Expr_Listner listner = new Expr_Listner(TableSymbol,Quads,visitor);
            visitor.visit(tree);
            ParseTreeWalker walker=new ParseTreeWalker();
            walker.walk(listner,tree);
            TableSymbol.afficherTS();
            if(erreurs.Errors.size()==0)
            {
                listner.quad.afficherQuad();
                Code_Objet code = new Code_Objet(Quads);
                code.Parcourir_quads();
                code.afficherTS();
            } else {
                erreurs.AffichageErrors();
            }
            TableSymbol.GettingWarnings();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

}
