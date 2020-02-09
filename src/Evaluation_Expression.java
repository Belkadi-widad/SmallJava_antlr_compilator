
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


public class Evaluation_Expression {

    String expr="" ;
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");

    public Evaluation_Expression(String expr)
    {
        super();
        this.expr = expr;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean  RemplacerValeurID(TableSymbol tb)
    {
        String[] Operandes = this.expr.split("[-+*/%()]");
        String valeur_id;

        for ( String op : Operandes) {
            if(!this.isNumeric(op) )
            {

                valeur_id = tb.ValeurDeId(op);
                if( valeur_id!=null )
                {
                    if(!valeur_id.contains("null") && !valeur_id.toLowerCase().contains("nan")  && !valeur_id.toLowerCase().contains("infinity")  ) {
                        this.expr = this.expr.replace(op, valeur_id);

                    }
                    else // la valeur est null
                    {
                        return false ;
                    }
                }
                else // la valeur n'existe pas dans la TS
                {
                    return false ;
                }
            }
        }
    return true ;

    }

    public void  ExpressionApresDiv(TableSymbol tb)
    {
        String[] Operandes = this.expr.split("[-+*/%]");
        String valeur_id;

        for ( String op : Operandes
        ) {

            if(!this.isNumeric(op) )
            {

                valeur_id = tb.ValeurDeId(op);
                if( valeur_id!=null  )
                {
                    if(!valeur_id.equals("null")) {

                        this.expr = this.expr.replace(op, valeur_id);
                    }
                    else // la valeur n'existe pas dans la TS
                    {
                        this.expr = null ;
                    }
                }


            }

        }
    }

    public int  Taille_expr() {
        String[] Operandes = this.expr.split("[-+*/%]");
        return Operandes.length;
    }
    public Object  EvaluateExpr() throws ScriptException
    {
        if(this.expr!=null   ) {


            if( !this.expr.contains("null") && !this.expr.contains("Infinity") && !this.expr.contains("NaN") )
            {
                return engine.eval(this.expr);

            }

        }
        return null ;
    }



}