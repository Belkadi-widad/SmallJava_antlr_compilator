import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

public class TableSymbol {

    HashMap<String, Elmt_TableSymbol> TableSymbol = new HashMap<String, Elmt_TableSymbol> ();
    ArrayList<String> Warnings = new   ArrayList<String>();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String	ANSI_ORANGE				= "\u001B[33m";
    //"\u001B[35m";
    public TableSymbol(HashMap<String, Elmt_TableSymbol> tableSymbol)
    {
        TableSymbol = tableSymbol;
    }
    public TableSymbol() {
        TableSymbol  = new  HashMap<String, Elmt_TableSymbol>();
    }
    public String getType_elemt_TS(String id_elemt)
    {
        Elmt_TableSymbol e=this.TableSymbol.get(id_elemt);
        if(e!=null)
        return e.getType();
        return null ;
    }
    @Override
    public String toString() {
        return "TableSymbol \n " +
                "TableSymbol=" + TableSymbol +
                '}';
    }
    public void afficherTS()
    {
        if(!this.TableSymbol.isEmpty()) {
            System.out.println("\n/***************Table des symboles ******************/\n");
            System.out.println("\t____________________________________________________________________________\n");
            System.out.println("\t| Name \t \t| Type \t \t | Value \t \t  |Declared \t  | Affected \t  \n");
            System.out.println("\t____________________________________________________________________________\n");
            for(Map.Entry<String, Elmt_TableSymbol> entry : this.TableSymbol.entrySet()) {
                String name_var = entry.getKey();
                Elmt_TableSymbol element = entry.getValue();
                if(element.isInitialized()==false)
                {
                    this.Warnings.add("warning! the variable  "+ name_var +"  is declared but not affected !! ");
                }
                System.out.println("\t "+ name_var + "\t \t|"+ element.getType()+ "\t \t |" + element.getValue()+ "\t \t \t  |" +
                        element.getDeclared()+ "\t \t   \t |" + element.isInitialized()+ "\t \t  |"+ "\n");


            }
        }
        else {
            System.out.println("\n/***************Table des symboles vide  ******************/\n");

        }
    }
    public String ValeurDeId(String id  )
    {
        if(this.TableSymbol.containsKey(id))
        {
            return String.valueOf(this.TableSymbol.get(id).getValue());
        }
        return null ;
    }
    public void GettingWarnings()
    {

        if(this.Warnings.size()!=0) {
            System.out.println("****************warnings !!!******************* ");

            this.Warnings.forEach((warn) -> System.out.println(ANSI_ORANGE + warn + ANSI_RESET));
        }

    }




}
