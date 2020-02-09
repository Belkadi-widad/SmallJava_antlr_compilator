import org.antlr.v4.codegen.model.chunk.LabelRef;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;


public class Expr_Listner extends Expr_arithmBaseListener {
    int i = 0;
    int  dernier_ou ;
    ArrayList<String> type_ecriture= new ArrayList<String>();
    ArrayList<String> type_lecture= new ArrayList<String>();
    boolean premier = true  ;
    boolean neg = false;
    String  last_comp ;
    Stack<String> pile_affectation = new Stack<String>();
    Stack<ElementQuad> pile_condition = new Stack<ElementQuad>();
    ElementQuad sauv_bz;
    Quadruplets quad = new Quadruplets();
    int num_quad_sinon = 0, num_quad_fin = 0;
    String rout_som_sous;
    Stack<ElementQuad> Liste_sauv_bz=new Stack<ElementQuad>();
    Stack<Integer> Liste_num_quad_fin = new Stack<Integer>();
    Stack<Integer> Liste_num_quad_sinon=new Stack<Integer>();
    String sauv_op_par;
    boolean pop = false;
    boolean or_and = true ; // true si ou , else false
    TableSymbol TableSymbol;
    ArrayList<ElementQuad> list_ou = new ArrayList<ElementQuad>();
    ArrayList<ElementQuad> list_et = new ArrayList<ElementQuad>();
    ArrayList<ElementQuad> list_et_avec_ou = new ArrayList<ElementQuad>();
    ElementQuad last_quad ;
    Expr_Visitor Un_visitor;
    int cpt=0;
    public Expr_Listner(TableSymbol table, Quadruplets quads , Expr_Visitor visitor ) {
        this.TableSymbol = table;
        this.quad = quads;
        this.Un_visitor= visitor;
    }

    @Override
    public void enterR(Expr_arithmParser.RContext ctx) {
    }

    @Override
    public void exitR(Expr_arithmParser.RContext ctx) {
    }

    @Override
    public void enterImport_bib(Expr_arithmParser.Import_bibContext ctx) {
    }

    @Override
    public void exitImport_bib(Expr_arithmParser.Import_bibContext ctx) {
    }

    @Override
    public void enterImport_bib_lang(Expr_arithmParser.Import_bib_langContext ctx) {
    }

    @Override
    public void exitImport_bib_lang(Expr_arithmParser.Import_bib_langContext ctx) {
    }

    @Override
    public void enterImport_bib_io(Expr_arithmParser.Import_bib_ioContext ctx) {
    }

    @Override
    public void exitImport_bib_io(Expr_arithmParser.Import_bib_ioContext ctx) {
    }

    @Override
    public void enterModificat(Expr_arithmParser.ModificatContext ctx) {
    }

    @Override
    public void exitModificat(Expr_arithmParser.ModificatContext ctx) {
    }

    @Override
    public void enterDec(Expr_arithmParser.DecContext ctx) {
    }

    @Override
    public void exitDec(Expr_arithmParser.DecContext ctx) {
    }

    @Override
    public void enterEns_var(Expr_arithmParser.Ens_varContext ctx) {
    }

    @Override
    public void exitEns_var(Expr_arithmParser.Ens_varContext ctx) {
    }

    @Override
    public void enterInst(Expr_arithmParser.InstContext ctx) {
    }

    @Override
    public void exitInst(Expr_arithmParser.InstContext ctx) {
    }

    @Override
    public void enterInst_af(Expr_arithmParser.Inst_afContext ctx) {
    }

    @Override
    public void exitInst_af(Expr_arithmParser.Inst_afContext ctx) {

        if (!this.pile_affectation.isEmpty()) {
            ElementQuad qc = new ElementQuad(0, "=", this.pile_affectation.pop(), "", ctx.ID().getText());
            this.quad.Quads.add(qc);
        } else {
            if(ctx.exp().chaine().getText().isEmpty()) {
                ElementQuad qc = new ElementQuad(0, "=", ctx.exp().m_d().getText(), "", ctx.ID().getText());
                this.quad.Quads.add(qc);
            }
            else {
                ElementQuad qc = new ElementQuad(0, "=", ctx.exp().chaine().getText(), "", ctx.ID().getText());
                this.quad.Quads.add(qc);
            }
        }

    }

    @Override public void enterDerier_comp(Expr_arithmParser.Derier_compContext ctx) { }

    @Override public void exitDerier_comp(Expr_arithmParser.Derier_compContext ctx) {

        this.last_comp = ctx.Comparateur().getText();
    }

    @Override
    public void enterExp(Expr_arithmParser.ExpContext ctx) {

    }


    @Override
    public void exitExp(Expr_arithmParser.ExpContext ctx) {


    }

    @Override
    public void enterExp_par(Expr_arithmParser.Exp_parContext ctx) {
        sauv_op_par = rout_som_sous;
    }


    @Override
    public void exitExp_s_m(Expr_arithmParser.Exp_s_mContext ctx) {

        if ((pile_affectation.size() >= 2) && (ctx.rout_som_sous() != null)) {
            String operande1 = this.pile_affectation.pop();
            String operande2 = this.pile_affectation.pop();
            this.pile_affectation.push("temp" + i);
            ElementQuad qc = new ElementQuad(1, ctx.rout_som_sous().getText(), operande2, operande1, "temp" + i);
            i++;
            this.quad.Quads.add(qc);

        }
    }


    @Override
    public void exitExp_d_m(Expr_arithmParser.Exp_d_mContext ctx) {


        if ((pile_affectation.size() >= 2) && (ctx.routine_div() != null)) {

            String operande1 = this.pile_affectation.pop();
            String operande2 = this.pile_affectation.pop();

            this.pile_affectation.push("temp" + i);
            ElementQuad qc = new ElementQuad(1, ctx.routine_div().start.getText(), operande2, operande1, "temp" + i);

            i++;
            this.quad.Quads.add(qc);

        }


    }

    @Override public void enterRout_vrai_ou(Expr_arithmParser.Rout_vrai_ouContext ctx) {
        if(!this.pile_condition.isEmpty())
        {
            ElementQuad qc_prec = this.pile_condition.pop();
            qc_prec.setOperande1((ElementQuad.num_global +2)+"");

        }
        String op_br;
        if(!this.neg)
        {
            op_br = this.GetJumpComp(this.last_comp);
        }
        else
        {
            op_br = this.GetJumpCompNOT(this.last_comp);

        }



        ElementQuad qc = new ElementQuad(2, op_br,"",this.pile_affectation.pop(),this.pile_affectation.pop());
        this.pile_condition.push(qc);
        this.quad.Quads.add(qc);


    }

    @Override public void exitRout_vrai_ou(Expr_arithmParser.Rout_vrai_ouContext ctx) {

    }

    @Override public void enterRout_faux_ou(Expr_arithmParser.Rout_faux_ouContext ctx) {

    }

    @Override public void exitRout_faux_ou(Expr_arithmParser.Rout_faux_ouContext ctx) {




        if(!this.pile_condition.isEmpty())
        {
            ElementQuad qc_prec = this.pile_condition.pop();
            qc_prec.setOperande1((ElementQuad.num_global +2)+"");

            this.num_quad_sinon = qc_prec.num_quad;

        }
    }

    @Override public void enterRout_vrai_et(Expr_arithmParser.Rout_vrai_etContext ctx) {

    }

    @Override public void exitRout_vrai_et(Expr_arithmParser.Rout_vrai_etContext ctx) {

        if(!this.pile_condition.isEmpty())
        {
            ElementQuad qc_prec = this.pile_condition.pop();
            qc_prec.setOperande1((ElementQuad.num_global +2)+"");

            this.num_quad_sinon = qc_prec.num_quad;


        }

    }

    @Override public void enterRout_faux_et(Expr_arithmParser.Rout_faux_etContext ctx) { }

    @Override public void exitRout_faux_et(Expr_arithmParser.Rout_faux_etContext ctx) {
        if(!this.pile_condition.isEmpty())
        {
            ElementQuad qc_prec = this.pile_condition.pop();
            qc_prec.setOperande1((ElementQuad.num_global +2)+"");

        }


        String op_br;
        if(!this.neg)
        {
            op_br = this.GetJumpCompNOT(this.last_comp);
        }
        else
        {
            op_br = this.GetJumpComp(this.last_comp);

        }

        ElementQuad qc = new ElementQuad(2, op_br,"",this.pile_affectation.pop(),this.pile_affectation.pop());
        this.pile_condition.push(qc);
        this.quad.Quads.add(qc);


    }
    @Override
    public void enterCondition_ou(Expr_arithmParser.Condition_ouContext ctx) {

    }
    @Override public void exitChaine(Expr_arithmParser.ChaineContext ctx) {
        this.pile_affectation.push(ctx.getText());
    }
    @Override
    public void exitCondition_ou(Expr_arithmParser.Condition_ouContext ctx) {

        if ((pile_affectation.size() >= 2) && (ctx.OU() != null)) {

        }
    }

    @Override
    public void enterCondition_et(Expr_arithmParser.Condition_etContext ctx) {
    }


    public String GetJumpComp(String comp) {

        if(comp!=null){
            switch (comp) {
                case "=":
                    return "BE";
                case "!=":
                    return "BNE";
                case ">=":
                    return "BGE";
                case ">":
                    return "BG";
                case "<=":
                    return "BLE";
                case "<":
                    return "BL";
                case "" :
                    return "BNZ";
                default: return  null ; // pour les idf seul dans la condition

            }
        }
        else return "BNZ";
    }


    public String GetJumpCompNOT(String comp) {

        if(comp!=null) {
            switch (comp) {
                case "=":
                    return "BNE";
                case "!=":
                    return "BE";
                case ">=":
                    return "BL";
                case ">":
                    return "BLE";
                case "<=":
                    return "BG";
                case "<":
                    return "BGE";
                case "" :
                    return "BZ";
                default:
                    return null;

            }
        }
        else return "BZ";
    }

    // cette fonction permet de regler le dernier quad de condition

    public String GetJumDenierBr (String comp) {

        if(comp!=null) {
            switch (comp) {
                case "BE":
                    return "BNE";
                case "BNE":
                    return "BE";
                case "BGE":
                    return "BL";
                case "BG":
                    return "BLE";
                case "BLE":
                    return "BG";
                case "BL":
                    return "BGE";
                case "BNZ":
                    return "BZ";
                case "BZ":
                    return "BNZ";

                default:
                    return null;

            }
        }
        else return "BZ";
    }

    //cette fonction permet de regler le branchement du derier branchement de et vers ou
    // exemple : b & c | a  de c vers le alors non pas vers le sinon

    @Override public void exitCondition_et(Expr_arithmParser.Condition_etContext ctx) { }

    @Override public void enterCondition_neg(Expr_arithmParser.Condition_negContext ctx) {


    }
    @Override public void enterNeg(Expr_arithmParser.NegContext ctx) {

        if(ctx.Neg()!=null) {
            if (this.neg == true) {
                this.neg = false;

            }
            else  {
                this.neg = true;

            }
        }

    }

    @Override public void exitCondition_neg(Expr_arithmParser.Condition_negContext ctx) { }

    @Override public void enterCondition_comparateur(Expr_arithmParser.Condition_comparateurContext ctx) { }


    @Override public void exitCondition_comparateur(Expr_arithmParser.Condition_comparateurContext ctx) {

        if(last_comp!=null) {
            Type_Expression type_exp= new Type_Expression();
            type_exp.type_condition(ctx.getText(),TableSymbol,ctx.start.getLine(),ctx.start.getCharPositionInLine(),last_comp,Un_visitor.erreurs);
        }
        this.neg=false;

    }

    @Override public void exitRout_signe_formatage_ecrit(Expr_arithmParser.Rout_signe_formatage_ecritContext ctx) {

        type_ecriture.add(this.type_formatage(ctx.getText()));

    }
    @Override public void enterRout_signe_formatage_lecture(Expr_arithmParser.Rout_signe_formatage_lectureContext ctx) {
        this.type_lecture.add(this.type_formatage(ctx.Signe_formatage().getText()));

    }



    @Override public void enterRoutine_div(Expr_arithmParser.Routine_divContext ctx) {

        rout_som_sous=ctx.start.getText();


    }

    @Override public void exitRoutine_div(Expr_arithmParser.Routine_divContext ctx) { }

    @Override public void enterRout_som_sous(Expr_arithmParser.Rout_som_sousContext ctx) {

    }

    @Override public void exitRout_som_sous(Expr_arithmParser.Rout_som_sousContext ctx) {
        rout_som_sous=ctx.getRuleContext().getText();
    }


    @Override public void enterM_d(Expr_arithmParser.M_dContext ctx) {

    }

    @Override public void exitM_d(Expr_arithmParser.M_dContext ctx) {
        this.pile_affectation.push(ctx.getText());

    }

    @Override public void enterInst_if(Expr_arithmParser.Inst_ifContext ctx) { }



    @Override public void enterCondition(Expr_arithmParser.ConditionContext ctx) { }

    @Override public void exitCondition(Expr_arithmParser.ConditionContext ctx) {

    }
    @Override
    public void enterRout_condition_if(Expr_arithmParser.Rout_condition_ifContext ctx){


        ElementQuad sauv_bz = this.quad.Quads.get(this.quad.Quads.size()-1);
        String op_br;


        for (ElementQuad e : this.list_ou
        ) {
            e.setOperande1(ElementQuad.num_global + 1 + "");

        }
        list_ou.clear();


    }

    @Override
    public void exitRout_condition_if(Expr_arithmParser.Rout_condition_ifContext ctx){}


    @Override public void enterRout_sinon(Expr_arithmParser.Rout_sinonContext ctx) {




    }


    @Override public void exitRout_sinon(Expr_arithmParser.Rout_sinonContext ctx) { }


    @Override public void enterRout_fin_sinon(Expr_arithmParser.Rout_fin_sinonContext ctx)
    {
        num_quad_fin=Liste_num_quad_fin.pop();
        ElementQuad quad_sinon = this.quad.Quads.get(this.num_quad_fin - 1);
        if(quad_sinon.getOperande1().equals("")) {
            quad_sinon.setOperande1((ElementQuad.num_global + 1) + "");
        }



    }


    @Override public void enterInst_sinon(Expr_arithmParser.Inst_sinonContext ctx)
    {


        if (this.last_quad!=null) {
            {
                if(or_and == true) // c'est un ou
                {
                    if(premier== true ) // le seul
                    {

                        String neg_ou_pas = last_quad.getOperateur();

                        String cmp;
                        // on doit voir si il  y a un !
                        if(neg_ou_pas.contains("non")==false)
                        { // ya pas

                            cmp = this.GetJumpCompNOT(this.last_quad.operateur);
                        }
                        else
                        { // y a
                            cmp = last_quad.getOperateur().substring(3);

                            cmp = this.GetJumpComp(cmp);

                        }
                        this.last_quad.setOperateur(cmp);

                    }
                    else {

                        this.last_quad.setOperateur(GetJumDenierBr(this.last_quad.operateur));
                    }
                }


                if (ctx.getText().equals(""))  // if sans else
                {
                    last_quad.setOperande1((ElementQuad.num_global + 1) + "");
                } else //if avec else
                {
                    last_quad.setOperande1((ElementQuad.num_global + 2) + "");
                }


            }

        }


    }

    @Override public void enterPas_sinon(Expr_arithmParser.Pas_sinonContext ctx) {

        if(!list_et.isEmpty())
        {
            for ( ElementQuad e : this.list_et
            ) {
                if(e.getOperande1().equals("")) {

                    e.setOperande1(ElementQuad.num_global + 1 + "");
                }
            }
            list_et.clear();
        }

    }

    @Override public void exitInst_sinon(Expr_arithmParser.Inst_sinonContext ctx) {

    }

    @Override public void enterRout_if_br(Expr_arithmParser.Rout_if_brContext ctx)
    {
        // dans le cas ou y a un sinon
        ElementQuad quad_fin= new ElementQuad(5,"BR","","","");
        this.quad.Quads.add(quad_fin);

        num_quad_fin=quad_fin.getNumQuad();
        Liste_num_quad_fin.push(num_quad_fin);



        if(!list_et.isEmpty())
        {
            for ( ElementQuad e : this.list_et
            ) {
                if(e.getOperande1().equals("")) {

                    e.setOperande1(ElementQuad.num_global + 1 + "");
                }
            }
            list_et.clear();
        }

        if(this.last_quad!=null) {
            this.last_quad.setOperande1((ElementQuad.num_global + 1) + "");

        }


    }

    @Override public void exitRout_if_br(Expr_arithmParser.Rout_if_brContext ctx)
    {

    }


    @Override public void enterInst_lecture(Expr_arithmParser.Inst_lectureContext ctx) { }

    @Override public void exitInst_lecture(Expr_arithmParser.Inst_lectureContext ctx) { }

    @Override public void enterSuite_lecture(Expr_arithmParser.Suite_lectureContext ctx) { }

    @Override public void exitSuite_lecture(Expr_arithmParser.Suite_lectureContext ctx) { }

    @Override public void enterInst_ecriture(Expr_arithmParser.Inst_ecritureContext ctx) { }

    @Override public void exitInst_ecriture(Expr_arithmParser.Inst_ecritureContext ctx) { }

    @Override public void enterSuite_ecriture(Expr_arithmParser.Suite_ecritureContext ctx) {
        if (ctx.debut_chaine() != null) {
            if (!ctx.debut_chaine().getText().equals("")) {



                ElementQuad qc = new ElementQuad(3,"Write", "Chaine_cst", "", ctx.debut_chaine().getText());
                this.quad.Quads.add(qc);

            }
        }
    }


    public String   type_formatage(String signe)
    {

        switch (signe )
        {
            case "%d"  :{ return "int_SJ";
            }
            case "%f"  : {return "float_SJ";
            }
            case "%s"  : {return "string_SJ";
            }
            default: {return "";
            }
        }

    }
    @Override public void exitSuite_ecriture(Expr_arithmParser.Suite_ecritureContext ctx) {

    }

    @Override public void enterSuite_ecriture_suite(Expr_arithmParser.Suite_ecriture_suiteContext ctx) {

        if (ctx.debut_chaine() != null)
        { if(!ctx.debut_chaine().getText().equals(""))
        {
            ElementQuad  qc =  new ElementQuad(3,"Write","Chaine_cst","",ctx.debut_chaine().getText());
            this.quad.Quads.add(qc);

        }}
    }


    @Override 	public void exitQuad_read(Expr_arithmParser.Quad_readContext ctx){
        if(ctx.ID()!=null)
        {
            String txt_erreur="";
            System.out.println(ctx.ID());
            if(this.TableSymbol.TableSymbol.get(ctx.ID())!=null)
            {
                String type = this.TableSymbol.TableSymbol.get(ctx.ID().getText()).getType();
                String type_lect = type_lecture.get(0);
                if (!type.equals(type_lect)) {

                    if ((type.equals("int_SJ") && !type_lect.equals("float_SJ")) || (type.equals("float_SJ") && !type_lect.equals("int_SJ"))) {
                        txt_erreur = "Incompatibilité de type  dans la lecture de la variable :\n \t\t\t " + ctx.ID().getText() + " qui est de type :  " + type + " \n \t\t\t et non pas de type : " + type_lect + " .! \t";
                        Erreur err;
                        err = new Erreur("1", "incompatibilité", ctx.start.getLine(), ctx.start.getCharPositionInLine(), txt_erreur);
                        this.Un_visitor.erreurs.AddErrorWarning(err);
                    } else {
                        if (type.equals("string_SJ") && !type_lect.equals("string_SJ")) {
                            txt_erreur = "Incompatibilité de type  dans la lecture de la variable :\n \t\t\t " + ctx.ID().getText() + " qui est de type :  " + type + " \n \t\t\t et non pas de type : " + type_lect + " .! \t";
                            Erreur err;
                            err = new Erreur("1", "incompatibilité", ctx.start.getLine(), ctx.start.getCharPositionInLine(), txt_erreur);
                            this.Un_visitor.erreurs.AddErrorWarning(err);
                        }
                    }

                }

            this.type_lecture.remove(0);
            ElementQuad  qc =  new ElementQuad(4,"Read",this.TableSymbol.TableSymbol.get(ctx.ID().getText()).getType(),"",ctx.ID().getText());
            this.quad.Quads.add(qc);
        }
        }

    }

    @Override public void exitInst_if(Expr_arithmParser.Inst_ifContext ctx) {

        this.list_et_avec_ou.clear();
        this.list_et.clear();
        this.Liste_sauv_bz.clear();
        this.list_ou.clear();
        i = 0;
        dernier_ou = 0 ;
        this.premier = true  ;
        this.neg = false;
        last_comp = null ;
        sauv_bz = null ;
        num_quad_sinon = 0;
        num_quad_fin = 0;
        Liste_num_quad_fin.clear();
        Liste_num_quad_sinon.clear();
        pop = false;
        or_and = true ; // true si ou , else false



    }
    @Override 	public void exitQuad_write(Expr_arithmParser.Quad_writeContext ctx){
        String txt_erreur="";
        if((ctx.ID()!=null) && (this.TableSymbol.TableSymbol.containsKey(ctx.ID().getText())))
        {

            String type=this.TableSymbol.TableSymbol.get(ctx.ID().getText()).getType();
            String type_ecrit = type_ecriture.get(0);
            if(!type.equals(type_ecrit))
            {

                if((type.equals("int_SJ")&&!type_ecrit.equals("float_SJ"))||(type.equals("float_SJ")&&!type_ecrit.equals("int_SJ")))
                {
                    txt_erreur="Incompatibilité de type  dans l'écriture \n \t\t\t de la variable :  "+ctx.ID().getText()+" qui est de type : \n \t\t\t "+type+" et non pas de type : "+type_ecrit+" .! \t";
                    Erreur err ;
                    err= new Erreur("1","incompatibilité" , ctx.start.getLine() , ctx.start.getCharPositionInLine() , txt_erreur);
                    this.Un_visitor.erreurs.AddErrorWarning(err);
                }
                else
                {
                    if(type.equals("string_SJ")&&!type_ecrit.equals("string_SJ"))
                    {
                        txt_erreur="Incompatibilité de type  dans l'écriture  \n \t\t\t de la variable : "+ctx.ID().getText()+" qui est de type : \n \t\t\t  "+type+" et non pas de type : "+type_ecrit+" .! \t";
                        Erreur err ;
                        err= new Erreur("1","incompatibilité" , ctx.start.getLine() , ctx.start.getCharPositionInLine() , txt_erreur);
                        this.Un_visitor.erreurs.AddErrorWarning(err);
                    }
                }

            }
            this.type_ecriture.remove(0);

            ElementQuad  qc =  new ElementQuad(3,"Write",this.TableSymbol.TableSymbol.get(ctx.ID().getText()).getType(),"",ctx.ID().getText());
            this.quad.Quads.add(qc);

        }
    }




    @Override public void exitSuite_ecriture_suite(Expr_arithmParser.Suite_ecriture_suiteContext ctx) {


    }


    @Override public void enterEveryRule(ParserRuleContext ctx) { }

    @Override public void exitEveryRule(ParserRuleContext ctx) { }

    @Override public void visitTerminal(TerminalNode node) { }

    @Override public void visitErrorNode(ErrorNode node) { }

    @Override public void exitRout_cmp(Expr_arithmParser.Rout_cmpContext ctx) {

        if(this.pile_affectation.size()>=2) {
            ElementQuad q = new ElementQuad(5, last_comp, "", this.pile_affectation.pop(), this.pile_affectation.pop());
            quad.Quads.add(q);

            if(this.neg== true )
            {
                q.setOperateur("non"+q.getOperateur());


            }
            this.Liste_sauv_bz.push(q);
            this.last_quad = q; // dernier quad

        }
    }

    @Override public void enterRout_ou(Expr_arithmParser.Rout_ouContext ctx) {
        int cpt =0;
        premier = false ;
        while(Liste_sauv_bz.size()>=1 &&  Liste_sauv_bz.size()<=2 )
        {

            sauv_bz = Liste_sauv_bz.pop();

            String cmp;
            String neg_ou_pas = sauv_bz.getOperateur();

            if(neg_ou_pas.contains("non")==false)
            {

                cmp = this.GetJumpComp(sauv_bz.getOperateur());


            }
            else
            {
                cmp = sauv_bz.getOperateur().substring(3);

                cmp = this.GetJumpCompNOT(cmp);

            }


            sauv_bz.setOperateur(cmp);
            this.list_ou.add(this.sauv_bz);

            cpt++;
        }
    }

    @Override public void exitIci(Expr_arithmParser.IciContext ctx) {

        or_and = true ;
        dernier_ou=ElementQuad.num_global;

        if(!list_et_avec_ou.isEmpty()) {
            int indice=0;

            if(this.list_et_avec_ou.size()>2)
            {
                indice=  this.list_et_avec_ou.size()-1;
            }
            ElementQuad qc_dernier = list_et_avec_ou.remove(indice);

            qc_dernier.setOperateur(this.GetJumDenierBr(qc_dernier.getOperateur()));

            list_ou.add(qc_dernier);

            for (ElementQuad elmt_ou : list_et_avec_ou) {
                elmt_ou.setOperande1(dernier_ou + 1 + "");

            }
            list_et_avec_ou.clear();
        }
    }
    @Override public void enterIci_et(Expr_arithmParser.Ici_etContext ctx)
    {
        or_and= false ;

    }


    @Override public void enterRout_et(Expr_arithmParser.Rout_etContext ctx)
    {

    }

    @Override public void exitRout_et(Expr_arithmParser.Rout_etContext ctx) {

        premier = false ;

        cpt=0 ;
        while(Liste_sauv_bz.size()>=1 && cpt <=1 )
        {
            String cmp;

            sauv_bz = Liste_sauv_bz.pop();

            String neg_ou_pas = sauv_bz.getOperateur();

            if(neg_ou_pas.contains("non")==false)
            {

                cmp = this.GetJumpCompNOT(sauv_bz.getOperateur());


            }
            else // starts with ! donc negatif
            {

                cmp = sauv_bz.getOperateur().substring(3);

                cmp = this.GetJumpComp(cmp);


            }
            sauv_bz.setOperateur(cmp);
            this.list_et_avec_ou.add(sauv_bz);


            this.list_et.add(this.sauv_bz);
            cpt=cpt+1;
        }

    }

    @Override public void enterNon_cmp(Expr_arithmParser.Non_cmpContext ctx)
    {

    }

    @Override public void exitNon_cmp(Expr_arithmParser.Non_cmpContext ctx)
    {
        last_comp=null;

        ElementQuad q = new ElementQuad(5, "", "", "", this.pile_affectation.pop());
        if(this.neg== true )
        {

            q.setOperateur("non");
        }
        this.neg= false ;
        quad.Quads.add(q);
        this.Liste_sauv_bz.push(q);
        this.last_quad = q;

    }
}
