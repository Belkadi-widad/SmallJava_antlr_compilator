import java.util.ArrayList;

public class Errors_and_warnings {

    ArrayList<Erreur> Errors = new ArrayList<Erreur>();



    public Errors_and_warnings(String categortie, ArrayList<Erreur> errors) {
        Errors = errors;
    }

    public Errors_and_warnings() {

    }
    public void AddErrorWarning(Erreur error ) {
        Errors.add(error) ;
    }

    public ArrayList<Erreur> getToutErrors()
    {
        ArrayList<Erreur> errors = new  ArrayList<Erreur>();
        for ( Erreur error: Errors
        ) {
            if(error.categortie.equals("1"))
            {    errors.add(error);
            }
        }

        return errors ;
    }
    public ArrayList<Erreur> getToutWarnings()
    {
        ArrayList<Erreur> warns = new  ArrayList<Erreur>();
        for ( Erreur error: Errors
        ) {
            if(error.categortie.equals("2"))
            {    warns.add(error);
            }
        }

        return warns ;
    }
    public void AffichageErrors()
    {
        ArrayList<Erreur> Error = this.getToutErrors() ;
        if(!Error.isEmpty()) {
            int i=1;
            System.out.println("\n/*************** "+ Error.size() + " erreurs sémantiques détéctés ******************/\n");
            System.out.println("\t____________________________________________________________________________\n");
            System.out.println("| Numéro de \n l'erreur  \t  | l'erreur \t \t \t \t \t \t \t \t |  La ligne  \t  | La colonne   \t   | La raison   \t ");
            System.out.println("\t_________________________________________________________________________________________________________\n");
            for( Erreur entry : Error) {

                System.out.println(entry.toString(i));
                i++;

            }
        }
        else {
            System.out.println("\n/*************** Erreurs : 0 ; compilé avec succés !  ******************/\n");

        }
    }
    public void AffichageWarnings()
    {


    }


}
