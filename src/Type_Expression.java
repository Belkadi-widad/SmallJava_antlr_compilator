import java.util.ArrayList;
import java.util.Stack;

public class Type_Expression {
    String expression;
    String type_result;
    String type_exp;
    boolean compatibilite;
    int line ;
    int colonne ;

    public  Type_Expression()
    {
        expression="";
        type_result="";
        type_exp="";
        this.colonne = 0 ;
        this.line = 0;
    }
    public  String evaluation_type_exp(String exp, TableSymbol T) {
        int i;
        String tab[] = exp.split("/", 2);

        if (exp.startsWith("\"") && exp.endsWith("\""))
        {
            return "string_SJ";
        }
        else
        {
            if (tab.length > 1) {
                return "float_SJ";
            }
            else {
                String type = "", type_tmp = "";
                tab = exp.split("[-+*()]+");
                if (tab.length == 1)
                {
                    if (T.TableSymbol.containsKey(exp))
                    {
                        return T.getType_elemt_TS(exp);
                    }
                    else
                    {
                        String tab2[]= exp.split(".",2);
                        if(tab2.length>1)
                        {
                            type_tmp="float_SJ";
                        }
                        else
                        {
                            type_tmp="int_SJ";
                        }
                    }

                }
                else {
                    i = 0;

                    while ((this.compatibilite) && (i < tab.length)) {
                        if (T.TableSymbol.containsKey(tab[i])) {
                            type_tmp = T.getType_elemt_TS(tab[i]);
                        }
                        else
                        {
                            String tab2[]= tab[i].split(".",2);
                            if(tab2.length>1)
                            {
                                type_tmp="float_SJ";
                            }
                            else
                            {
                                type_tmp="int_SJ";
                            }
                        }
                        if (!type.equals(type_tmp)) {
                            if (type.equals("int_SJ")) {
                                if (type_tmp.equals("float_SJ")) {
                                    type = "float_SJ";
                                } else {
                                    if (type.equals("int_SJ")) {
                                        type = "int_SJ";
                                    } else {
                                        if (type.equals("string_SJ")) {
                                            return "string_SJ_ERROR";
                                        }
                                    }
                                }
                            }
                        }
                        i++;
                    }
                    return type;
                }
            }
        }
        return "";
    }

    public void type_condition(String condition,TableSymbol T,int line , int colonne ,String cmp , Errors_and_warnings errors )
    {
        String[] exp = condition.split(cmp,3);
        String txt_erreur="";
        this.line = line ;
        this.colonne = colonne ;
        String type_exp1 = "", type_exp2="";
        type_exp1 = this.evaluation_type_exp(exp[0],T);
        type_exp2 = this.evaluation_type_exp(exp[1],T);
        if(type_exp1.equals("string_SJ_ERROR"))
        {
            Erreur err ;
            err= new Erreur("1","incompatibilité" , this.line ,this.colonne , "incompatibilité de type avec une variable de type String dans l'expression : "+exp[0]);
            errors.AddErrorWarning(err);

        }
        else
        {

            if(type_exp2.equals("string_SJ_ERROR"))
            {
                Erreur err ;
                err= new Erreur("1","incompatibilité" , this.line ,this.colonne ,  "Incompatibilité de type avec une variable de type String dans l'expression : "+exp[1]);
                errors.AddErrorWarning(err);
            }
            else
            {
                switch (type_exp1) {
                    case "string_SJ":
                        if(!type_exp2.equals("string_SJ"))
                        {
                            //JPC
                            txt_erreur="Incompatibilité de type de l'expression : \n \t\t\t"+exp[0]+"est de type  String_SJ avec l'expression : \n \t\t\t" +exp[1]+" de type : "+type_exp2 +"\t\t\t";
                            Erreur err ;
                            err= new Erreur("1","incompatibilité" , this.line ,this.colonne , txt_erreur);
                            errors.AddErrorWarning(err);
                        }
                        break;
                    case "float_SJ":
                        if(type_exp2.equals("string_SJ"))
                        {

                            txt_erreur="Incompatibilité de type de l'expression : \n \t\t\t\t"+exp[0]+"est de type  float_SJ avec l'expression : \n \t\t\t\t"+exp[1]+" de type : String_SJ" +"\t\t\t";
                            Erreur err ;
                            err= new Erreur("1","incompatibilité" , this.line ,this.colonne , txt_erreur);
                            errors.AddErrorWarning(err);
                        }
                        break;
                    case "int_SJ":
                        if(type_exp2.equals("string_SJ"))
                        {

                            txt_erreur="Incompatibilité de type de l'expression : \n \t\t\t\t"+exp[0]+"est de type  int_SJ avec l'expression : \n \t\t\t\t"+exp[1]+" de type : String_SJ" +"\t\t\t";
                            Erreur err ;
                            err= new Erreur("1","incompatibilité" , this.line ,this.colonne , txt_erreur);
                            errors.AddErrorWarning(err);
                        }
                        break;
                }

            }
        }


    }

    public Type_Expression(String exp,TableSymbol T , int line , int colonne , Errors_and_warnings  errors ) {
        this.expression = exp;
        this.compatibilite = false;
        this.line = line ;
        this.colonne = colonne ;
        int j,i=0;
        String id_result;
        String txt_erreur;
        String separateur = "=+-*/;";
        String[] tab = this.expression.split("[:=;]+",3);
        String[] sous_exp;
        id_result = tab[0];
        type_result=T.getType_elemt_TS(tab[0]);
        String s,exp_affecter = tab[1];
        if(type_result!=null) {
            switch (type_result) {
                case "int_SJ":

                    tab = tab[1].split("/", 2);
                    if (tab.length > 1) {
                        Erreur err;
                        err = new Erreur("1", "incompatibilité", this.line, this.colonne, " Vous avez affecté  à la variable :  \n  \t \t \t { " + id_result + " } "
                                + " de type int_SJ \n \t \t  une division dans le résultat est un float .");
                        errors.AddErrorWarning(err);

                    } else {
                        tab = tab[0].split("[-+*()]+");
                        this.compatibilite = true;
                        i = 0;
                        while ((this.compatibilite) && (i < tab.length)) {
                            if (T.TableSymbol.containsKey(tab[i])) {

                                if (!((T.getType_elemt_TS(tab[i])).equals("int_SJ"))) {
                                    this.compatibilite = false;
                                }
                            } else {
                                if ((tab[i].charAt(0) == '"') && (tab[i].charAt(tab[i].length() - 1) == '"')) {
                                    this.compatibilite = false;
                                }

                                // QUESTION : traitant les nombre constant !
                            }
                            i++;
                        }
                        if (this.compatibilite == false) {
                            txt_erreur = "Incompatibilité de type dans l'expression : \n \t\t\t" + exp_affecter + " par rapport a l'identifiant : \n \t\t\t " + id_result + " qui est de type :  int_SJ .\t \t\t";
                            Erreur err;
                            err = new Erreur("1", "incompatibilité", this.line, this.colonne, txt_erreur);
                            errors.AddErrorWarning(err);

                        }
                    }
                    break;
                case "float_SJ":

                    tab = tab[1].split("\"", 2);
                    if (tab.length > 1) {
                        Erreur err;
                        err = new Erreur("1", "incompatibilité", this.line, this.colonne, "  Incompatibilité de type , vous avez \n \t\t\t  affecté à la variable  { " + id_result + " }" +
                                "  \n \t\t\t de type float une chaine de caractere \t");
                        errors.AddErrorWarning(err);
                    } else {

                        tab = tab[0].split("[-+*/()]+");
                        i = 0;
                        this.compatibilite = true;
                        while ((i < tab.length) && (this.compatibilite == true)) {
                            if (T.TableSymbol.containsKey(tab[i])) {
                                if ((T.getType_elemt_TS(tab[i])).equals("string_SJ")) {
                                    this.compatibilite = false;
                                }
                            }
                            i++;
                        }
                        if (this.compatibilite == false) {

                            txt_erreur = "Incompatibilité de type dans l'expression : \n \t\t\t" + exp_affecter + " par rapport a l'identifiant : \n \t\t\t " + id_result + " qui est de type : \n \t\t\t float_SJ => un String a été rencontré \t";
                            Erreur err;
                            err = new Erreur("1", "incompatibilité", this.line, this.colonne, txt_erreur);
                            errors.AddErrorWarning(err);
                        }
                    }
                    break;
                case "string_SJ":

                    tab = tab[1].split("[-+*/]+", 2);
                    if (tab.length > 1) {
                        Erreur err;
                        err = new Erreur("1", "incompatibilité", this.line, this.colonne, "Incompatibilité de type , vous avez affecté à la variable { " + id_result +
                                "} de type String une expression arithmétique");
                        errors.AddErrorWarning(err);
                    } else {
                        if ((T.TableSymbol).containsKey(tab[0])) {
                            if ((T.getType_elemt_TS(tab[0])).equals("string_SJ")) {

                            } else {
                                Erreur err;
                                err = new Erreur("1", "incompatibilité", this.line, this.colonne, "Incompatibilité de type , vous avez affecté  à la variable {" + id_result +
                                        "}  de type String une expression arithmétique");
                                errors.AddErrorWarning(err);

                            }
                        } else {
                            if (tab[0].charAt(0) == '"') {
                                if (tab[0].charAt(tab[0].length() - 1) == '"') {

                                } else {
                                    txt_erreur = "Incompatibilité de type de :\n \t\t\t " + tab[0] + "\n \t\t\t par rapport a l'identifiant : " + id_result;
                                    Erreur err;
                                    err = new Erreur("1", "incompatibilité", this.line, this.colonne, txt_erreur);
                                    errors.AddErrorWarning(err);
                                }
                            } else {
                                txt_erreur = "Incompatibilité de type de : \n \t\t\t\t" + tab[0] + " par rapport a l'identifiant : " + id_result + "\t";
                                Erreur err;
                                err = new Erreur("1", "incompatibilité", this.line, this.colonne, txt_erreur);
                                errors.AddErrorWarning(err);
                            }
                        }

                    }
                    break;
            }
        }
    }
    public boolean get_compatibilite()
    {
        return this.compatibilite;
    }
}