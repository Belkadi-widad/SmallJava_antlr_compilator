import org.antlr.v4.runtime.tree.TerminalNode;

import javax.script.ScriptException;
import java.util.*;

public class Expr_Visitor extends Expr_arithmBaseVisitor<Object>  {
    /* erreur sémantiques + quadruplets + TS  !! */
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public  Errors_and_warnings erreurs; // erreurs and warnings
    Quadruplets quads;
    String current_Type="";
    Stack<String> Aff_quad = new Stack<String>();
    boolean import_lang = false;
    boolean import_io = false;
    TableSymbol TableSymbol ;
    ArrayList<String> id_dans_expression = new ArrayList<>();

    public Expr_Visitor(TableSymbol table,Quadruplets quads , Errors_and_warnings  errors ) {
        this.TableSymbol = table;
        this.quads= quads;
        this.erreurs = errors ;
    }
    @Override public Object visitInst_lecture(Expr_arithmParser.Inst_lectureContext ctx)
    {

        if(import_io==false)
        {
            Erreur err ;
            err= new Erreur("1","bib non importé " , ctx.getStart().getLine() , ctx.getStart().getCharPositionInLine() ,"Bibliothéque output-input non importé");
            erreurs.AddErrorWarning(err);
        }
        return visitChildren(ctx);
    }


    @Override public Object visitInst_ecriture(Expr_arithmParser.Inst_ecritureContext ctx)
    {
        if(import_io==false)
        {
            Erreur err ;
            err= new Erreur("1","bib non importé " , ctx.getStart().getLine() , ctx.getStart().getCharPositionInLine() ,"Bibliothéque output-input non importé");
            erreurs.AddErrorWarning(err);
        }
        return visitChildren(ctx);
    }


    @Override public Object visitImport_bib_lang(Expr_arithmParser.Import_bib_langContext ctx)
    {
        if(ctx.start.getText().equals("import Small_Java.lang"))
        {

            import_lang=true;
        }
        else
        {
            import_lang=false;
        }
        return visitChildren(ctx);
    }

    @Override public Object visitImport_bib_io(Expr_arithmParser.Import_bib_ioContext ctx)
    {

        if(ctx.start.getText().equals("import Small_Java.io"))
        {
            import_io=true;
        }
        else
        {
            import_io=false;
        }
        return visitChildren(ctx);
    }



    public Expr_Visitor() { }
    @Override public Object visitR(Expr_arithmParser.RContext ctx)
    {
        return visitChildren(ctx);

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitInst(Expr_arithmParser.InstContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitInst_af(Expr_arithmParser.Inst_afContext ctx)  {
        // vérifier que l 'ID  a été déclaré  !
        // ici nous allons évaluer l'expression
        // nous devons avant faire appelle à une fonction qui remplace les valeurs des ids si il existe !

        Evaluation_Expression expression = new Evaluation_Expression(ctx.exp().getText());
        Elmt_TableSymbol elm = this.TableSymbol.TableSymbol.get(ctx.ID().getText());
        if(elm!=null && expression.Taille_expr()==1 )
        {
            // une seule constante  ou variable !!

            if(expression.RemplacerValeurID(TableSymbol) || ctx.exp().chaine()!=null )
            {
                elm.setValue(expression.expr);
                elm.initialized=true;
            }
        }
        else {
            // cas expression !
            if (expression.RemplacerValeurID(TableSymbol)) {

                expression.RemplacerValeurID(TableSymbol);

                try {
                    Object evaluation = expression.EvaluateExpr();

                    if (elm != null && evaluation != null) {
                        if (evaluation.toString().toLowerCase().equals("infinity") || evaluation.toString().toLowerCase().equals("nan")) {
                            Erreur err;
                            err = new Erreur("1", "division par zero \t \t  \t ", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "Division par zero  \t \t \t \t \t  ");
                            erreurs.AddErrorWarning(err);
                        }

                        elm.setValue(String.valueOf(evaluation));
                        elm.initialized = true;

                    }
                } catch (ScriptException e) {
                    e.printStackTrace();
                }

            }
        }
        //

        Type_Expression T= new Type_Expression(ctx.getText(),this.TableSymbol,ctx.getStart().getLine() , ctx.getStart().getCharPositionInLine(),erreurs);
        if(import_lang==false)
        {
            Erreur err ;
            err= new Erreur("1","bib non importé" , ctx.getStart().getLine() , ctx.getStart().getCharPositionInLine() , " Bibliothéque arithmétique non importé ");
            erreurs.AddErrorWarning(err);

        }
        else {
            if (!this.TableSymbol.TableSymbol.containsKey(ctx.start.getText())) {

                Erreur err ;
                err= new Erreur("1","non déclaré" , ctx.getStart().getLine() , ctx.getStart().getCharPositionInLine() , "la variable: " + ctx.start.getText() + " non déclaré  \t\t\t");
                erreurs.AddErrorWarning(err);


            } else {
                Elmt_TableSymbol elmt = this.TableSymbol.TableSymbol.get(ctx.start.getText());
                elmt.initialized = true;
                this.TableSymbol.TableSymbol.put(ctx.start.getText(), elmt);
                this.Aff_quad.push(ctx.start.getText());
            }
        }
        return visitChildren(ctx); }

    @Override public Object visitCondition(Expr_arithmParser.ConditionContext ctx)
    {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code cObjectx}.</p>
     */
    @Override public Object  visitExp(Expr_arithmParser.ExpContext ctx)
    {
        if(import_lang==false)
        {
            Erreur err ;
            err= new Erreur("1","bib non  importé" , ctx.getStart().getLine() ,
                    ctx.getStart().getCharPositionInLine() , " Bibliothéque arithmétique non importé ");
            erreurs.AddErrorWarning(err);
        }
        return visitChildren(ctx);
    }
    @Override public Object visitRout_som_sous(Expr_arithmParser.Rout_som_sousContext ctx)

    {

        return visitChildren(ctx); }


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExp_par(Expr_arithmParser.Exp_parContext ctx)
    { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitM_d(Expr_arithmParser.M_dContext ctx)
    {
        if(ctx.ID()!=null) {
            if (!this.TableSymbol.TableSymbol.containsKey(ctx.ID().getText())) {

                Erreur err ;
                err= new Erreur("1"," non déclaré " , ctx.getStart().getLine() ,
                        ctx.getStart().getCharPositionInLine() ,   "la variable : " + ctx.ID().getText() + " non declaré  ! \t\t  ");
                erreurs.AddErrorWarning(err);
            }
            else {
                this.Aff_quad.push(ctx.ID().getText());
            }
        }
        else if(ctx.Cst()!=null)
        {
            this.Aff_quad.push(ctx.Cst().getText());
        }
        return visitChildren(ctx);
    }

    /* afecter le type ! */
    @Override public Object visitDec(Expr_arithmParser.DecContext ctx)
    {
        if(import_lang==false) {
            Erreur err;
            err = new Erreur("1", "bib non importé", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), " Bibliothéque arithmétique non importé ");
            erreurs.AddErrorWarning(err);
        }
        if(ctx.start.getText().equals("int_SJ") | ctx.start.getText().equals("float_SJ") | ctx.start.getText().equals("string_SJ"))
        {
            this.current_Type=ctx.start.getText();}
        return visitChildren(ctx);
    }
    /* ajouter dans la ts  */
    @Override public Object visitEns_var(Expr_arithmParser.Ens_varContext ctx)
    {

        if(ctx.start.getText().length()>10)
        {

            Erreur err ;
            err= new Erreur("1","grande taille de nom " , ctx.getStart().getLine() , ctx.getStart().getCharPositionInLine() , " Taille de variable dépase 10 !  --veuillez diminuer la taille de la variable :  "+ ctx.start.getText() );
            erreurs.AddErrorWarning(err);
        }
        else {
            if(!this.TableSymbol.TableSymbol.containsKey(ctx.getStart().getText()))
            {
                Elmt_TableSymbol element = new Elmt_TableSymbol(this.current_Type,true , false);
                this.TableSymbol.TableSymbol.put(ctx.start.getText(),element);
            }
            // voir  l'existance dans la TS
            else {

                Erreur err ;
                err= new Erreur("1","double déclaration" , ctx.getStart().getLine() , ctx.getStart().getCharPositionInLine() , " Double decalaration de la variable :  "+ ctx.getStart().getText() );
                erreurs.AddErrorWarning(err);

            }

        }

        return visitChildren(ctx); }

    /* routine division */
    @Override public Object visitRoutine_div(Expr_arithmParser.Routine_divContext ctx) {

        if (ctx.start.getText().equals("/")) {

            if (ctx.exp().m_d() != null)
            {
                if (ctx.exp().m_d().Cst() != null) {
                    if (ctx.exp().m_d().Cst().getText().startsWith("0")) {
                        Erreur err;
                        err = new Erreur("1", "division par 0", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), " Division par zero  \t \t \t \t \t " + ctx.getStart().getText());
                        erreurs.AddErrorWarning(err);
                    }
                }
                if (ctx.exp().m_d().Cst_reel() != null) {
                    if (Float.valueOf(ctx.exp().m_d().Cst_reel().getText())==0) {
                        Erreur err;
                        err = new Erreur("1", "division par 0", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), " Division par zero  \t \t \t \t \t " + ctx.getStart().getText());
                        erreurs.AddErrorWarning(err);
                    }
                }
             else {
                if (ctx.exp().m_d().ID() != null)
                // Ajouter valeur ID
                {
                    if (this.TableSymbol.TableSymbol.containsKey(ctx.exp().m_d().ID().getText())) {
                        String Val = this.TableSymbol.TableSymbol.get(ctx.exp().m_d().ID().getText()).getValue();
                        boolean initialized = this.TableSymbol.TableSymbol.get(ctx.exp().m_d().ID().getText()).isInitialized();
                        if (Val.equals("0") && initialized == true)  // si sa valeur est egale à 0 lors de la compilation !
                        {
                            Erreur err;
                            err = new Erreur("1", "division par 0", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), " Division par 0    \t \t \t \t \t \t  ");
                            erreurs.AddErrorWarning(err);
                        }
                    }
                }
            }
        }

        }

        return visitChildren(ctx);


    }

}

