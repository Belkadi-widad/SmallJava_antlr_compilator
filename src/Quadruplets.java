import java.util.ArrayList;
import java.util.Map;

public class Quadruplets {

    ArrayList<ElementQuad> Quads = new ArrayList<ElementQuad>();

    public Quadruplets(ArrayList<ElementQuad> quads) {
        Quads = quads;
    }
    public Quadruplets() {

    }


    public void afficherQuad()
    {
        if(!this.Quads.isEmpty()) {

            System.out.println("\n/*************** Quadruplets ******************/\n");
            System.out.println("\t____________________________________________________________________________\n");
            System.out.println("\t| Num \t | Opérateur \t \t| Opérande 1 \t \t | Opérande 2 \t \t  |Temporaire \t  \n");
            System.out.println("\t____________________________________________________________________________\n");
            for( ElementQuad entry : this.Quads) {

                System.out.println("\t "+ entry.num_quad + "\t \t|"+entry.operateur+ "\t \t |" + entry.operande1+ "\t \t \t  |" +entry.operande2
                        + "\t \t   \t |" +entry.Tamporaire + "\t \t  |"+ "\n");


            }
        }
        else {
            System.out.println("\n/***************Quad vide  ******************/\n");

        }
    }
}
