import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Code_Objet {
    Quadruplets quads;
    HashMap<String,ArrayList<Integer>> liste_jump = new HashMap<String,ArrayList<Integer>>();
    int i=0;
    HashMap<Integer,ElementCodeObjet> code_objet =new HashMap<>();
    String Acc ="";
    public  Code_Objet(Quadruplets quads)
    {
        this.quads=quads;
        Acc="";
    }
    public void Modifier_branchement(String num_qc)
    {
        ArrayList<Integer> liste = this.liste_jump.get(num_qc);
        if(liste!=null)
        {
            ElementCodeObjet e;
            for( Integer entry : liste) {
                e = this.code_objet.get(entry);
                e.destination=ElementCodeObjet.nb_elem+1+"";
            }
        }
    }
    public void Ajouter_list_jum(String num_qc,int num_code_objet)
    {
        if(!this.liste_jump.containsKey(num_qc))
        {
            this.liste_jump.put(num_qc,new ArrayList<Integer>());
        }
        (this.liste_jump.get(num_qc)).add(num_code_objet);
    }
    public String get_jump(String br)
    {
        switch (br)
        {
            case "BNE":
                return "JNE";
            case "BE":
                return "JE";
            case "BL":
                return "JL";
            case "BLE":
                return "JLE";
            case "BG":
                return "JG";
            case "BGE":
                return "JGE";
            case "BZ":
                return "JZ";
            case "BNZ":
                return "JNZ";
            case "BR":
                return "JUMP";
            default:
                return null;

        }


    }

    public void Code_branchement(ElementQuad qc)
    {
        ElementCodeObjet c ;
        ArrayList<String> operandes  = new ArrayList<>();
        if(qc.operateur.equals("BR") )
        {
            c = new ElementCodeObjet("JUMP","","");
            this.code_objet.put(c.num_elem,c);
            this.Ajouter_list_jum(qc.operande1,c.num_elem);
        }
        else
        {
            if(qc.operateur.equals("BZ") || qc.operateur.equals("BNZ"))
            {
                if(!this.Acc.equals(qc.Tamporaire))
                {
                    c = new ElementCodeObjet("MOV","AX",qc.Tamporaire);
                    this.code_objet.put(c.num_elem,c);
                    this.Acc = qc.operande2;
                }
                c = new ElementCodeObjet(this.get_jump(qc.operateur),"","");
                this.code_objet.put(c.num_elem,c);
                this.Ajouter_list_jum(qc.operande1,c.num_elem);
            }
            else
            {
                if(this.Acc.equals(qc.operande2))
                {
                    c = new ElementCodeObjet("CMP","AX",qc.Tamporaire);
                    this.code_objet.put(c.num_elem,c);
                }
                else
                {
                    if(this.Acc.equals(qc.Tamporaire))
                    {
                        c = new ElementCodeObjet("CMP",qc.operande2,"AX");
                        this.code_objet.put(c.num_elem,c);
                    }
                    else
                    {
                        c = new ElementCodeObjet("MOV","AX",qc.operande2);
                        this.code_objet.put(c.num_elem,c);
                        this.Acc = qc.operande2;
                        c = new ElementCodeObjet("CMP","AX",qc.Tamporaire);
                        this.code_objet.put(c.num_elem,c);
                    }
                }

                c = new ElementCodeObjet(this.get_jump(qc.operateur),"","");
                this.code_objet.put(c.num_elem,c);
                this.Ajouter_list_jum(qc.operande1,c.num_elem);
            }
        }
    }



    public void Parcourir_quads()
    {
        for( ElementQuad entry : this.quads.Quads) {
            Modifier_branchement(entry.num_quad+"");
            switch (entry.type_quad )
            {
                case 0: Code_affectation(entry);break;
                case 1: {Code_expression(entry);

                    break;}

                case 3: Code_ecriture(entry);break;
                case 4: Code_lecture(entry);break;
                case 5: Code_branchement(entry);break;

            }

        }
        Modifier_branchement(ElementQuad.num_global+1+"");





    }

    public void Code_affectation(ElementQuad qc)
    {
        ArrayList<String> operandes  = new ArrayList<>();
        operandes=this.GettingAcc(qc);

        this.MovToVariable(qc.Tamporaire);
    }
    public void MovToVariable(String  op)

    {
        ElementCodeObjet e=new ElementCodeObjet("Mov",op,"AX");
        i++;
        this.code_objet.put(ElementCodeObjet.nb_elem,e);
    }

    public  ArrayList<String> GettingAcc_Condition(ElementQuad qc)
    {
        String op1  = qc.operande1;
        String op2 = qc.operande2;

        String tmp =qc.Tamporaire;

        ArrayList<String> operandes  = new ArrayList<>();
        if(this.Acc.equals(""))
        {
            ElementCodeObjet e=new ElementCodeObjet("Mov","AX",op1);
            this.code_objet.put(ElementCodeObjet.nb_elem,e);
            this.Acc=op1;
            operandes.add(op1);
            operandes.add(op2);
            operandes.add("True");
        }
        else  // commutatif
        {
            if(this.Acc.equals(op2) )
            {  if((qc.operateur.equals("+") ||  qc.operateur.equals("*")))
            {
                operandes.add(op2);
                operandes.add(op1);
                operandes.add("True");

            }
                if(qc.operateur.equals("/") || qc.operateur.equals("-"))
                {

                    ElementCodeObjet e = new ElementCodeObjet("Mov", op2, "AX");
                    i++;
                    this.code_objet.put(ElementCodeObjet.nb_elem, e);
                    e = new ElementCodeObjet("Mov", "AX", op1);
                    this.code_objet.put(ElementCodeObjet.nb_elem, e);
                    this.Acc = op1;
                }
            }
            else if(!this.Acc.equals(op1))
            {
                if(qc.operateur.equals("="))
                {

                    ElementCodeObjet e = new ElementCodeObjet("Mov", op1, "AX");
                    i++;
                    this.code_objet.put(ElementCodeObjet.nb_elem, e);

                }
                else {

                    ElementCodeObjet e = new ElementCodeObjet("Mov", "AX", op1);
                    this.code_objet.put(ElementCodeObjet.nb_elem, e);
                    this.Acc = op1;

                }
                operandes.add(op1);
                operandes.add(op2);
                operandes.add("False"); //  ici il y a ni op 1 ni op2
            }
            else {
                operandes.add(op1);
                operandes.add(op2);
                operandes.add("False"); //  ici il y a ni op 1 ni op2
            }
        }

        return operandes;
    }
    public  ArrayList<String> GettingAcc(ElementQuad qc)
    {
        String op1  = qc.operande1;
        String op2 = qc.operande2;

        String tmp =qc.Tamporaire;

        ArrayList<String> operandes  = new ArrayList<>();
        if(this.Acc.equals(""))
        {
            ElementCodeObjet e=new ElementCodeObjet("Mov","AX",op1);
            this.code_objet.put(ElementCodeObjet.nb_elem,e);
            this.Acc=op1;
            operandes.add(op1);
            operandes.add(op2);
            operandes.add("True");
        }
        else  // commutatif
        {
            if(this.Acc.equals(op2) )
            {  if((qc.operateur.equals("+") ||  qc.operateur.equals("*")))
            {
                operandes.add(op2);
                operandes.add(op1);
                operandes.add("True");

            }
                if(qc.operateur.equals("/") || qc.operateur.equals("-"))
                {

                    ElementCodeObjet e = new ElementCodeObjet("Mov", op2, "AX");
                    i++;
                    this.code_objet.put(ElementCodeObjet.nb_elem, e);
                    e = new ElementCodeObjet("Mov", "AX", op1);
                    this.code_objet.put(ElementCodeObjet.nb_elem, e);
                    this.Acc = op1;
                }
            }
            else if(!this.Acc.equals(op1))
            {
                if(qc.operateur.equals("="))
                {

                    ElementCodeObjet e = new ElementCodeObjet("Mov", op1, "AX");
                    i++;
                    this.code_objet.put(ElementCodeObjet.nb_elem, e);

                }
                else {

                    ElementCodeObjet e = new ElementCodeObjet("Mov", "AX", op1);
                    this.code_objet.put(ElementCodeObjet.nb_elem, e);
                    this.Acc = op1;

                }
                operandes.add(op1);
                operandes.add(op2);
                operandes.add("False"); //  ici il y a ni op 1 ni op2
            }
            else {
                operandes.add(op1);
                operandes.add(op2);
                operandes.add("False"); //  ici il y a ni op 1 ni op2
            }
        }

        return operandes;
    }
    public void Code_expression(ElementQuad qc)
    {
        ArrayList<String> operandes = new ArrayList<String>();
        switch(qc.operateur)
        {
            case "+"  : operandes = this.GettingAcc(qc);

                if( operandes.get(0).equals(qc.operande1))
                {

                    ElementCodeObjet e=new ElementCodeObjet("Add","Ax",qc.operande2);
                    i++;
                    this.code_objet.put(ElementCodeObjet.nb_elem,e);

                }
                else {
                    ElementCodeObjet e=new ElementCodeObjet("Add","Ax",qc.operande1);
                    i++;
                    this.code_objet.put(ElementCodeObjet.nb_elem,e);

                }
                this.Acc=qc.Tamporaire;
                break;

            case "*"  : operandes = this.GettingAcc(qc);

                if( operandes.get(0).equals(qc.operande1))
                {

                    ElementCodeObjet e=new ElementCodeObjet("Mult","Ax",qc.operande2);
                    i++;
                    this.code_objet.put(ElementCodeObjet.nb_elem,e);

                }
                else {
                    ElementCodeObjet e=new ElementCodeObjet("Mult","Ax",qc.operande1);
                    i++;
                    this.code_objet.put(ElementCodeObjet.nb_elem,e);

                }
                this.Acc=qc.Tamporaire;
                break;
            case "/"  : {operandes = this.GettingAcc(qc);



                ElementCodeObjet e=new ElementCodeObjet("Div","Ax",qc.operande2);
                i++;
                this.code_objet.put(ElementCodeObjet.nb_elem,e);
                this.Acc=qc.Tamporaire;

                break;
            }

            case "-"  : {operandes = this.GettingAcc(qc);

                ElementCodeObjet e=new ElementCodeObjet("Sub","Ax",qc.operande2);
                i++;
                this.code_objet.put(ElementCodeObjet.nb_elem,e);
                this.Acc=qc.Tamporaire;

                break;
            }

        }

    }
    public void Code_condition(ElementQuad qc)
    {


    }
    public void Code_ecriture(ElementQuad qc)
    {
        ElementCodeObjet c = new ElementCodeObjet("LEA","DX",qc.Tamporaire);
        this.code_objet.put(c.num_elem,c);
        c = new ElementCodeObjet("MOV","AH","09H");
        this.code_objet.put(c.num_elem,c);
        c = new ElementCodeObjet("INT","21H","");
        this.code_objet.put(c.num_elem,c);


    }
    public void Code_lecture(ElementQuad qc)
    {
        ElementCodeObjet c = new ElementCodeObjet("MOV","AH","0AH");
        this.code_objet.put(c.num_elem,c);
        c = new ElementCodeObjet("INT","21H","");
        this.code_objet.put(c.num_elem,c);
        c = new ElementCodeObjet("MOV",qc.Tamporaire,"DX");
        this.code_objet.put(c.num_elem,c);
    }

    public void afficherTS()
    {
        if(!this.code_objet.isEmpty()) {
            System.out.println("\n/*************** Code Objet ******************/\n");
            System.out.println("\t____________________________________________________________________________\n");
            System.out.println("\t| Operation \t \t| Destination  \t \t | Source  \t|  \n");
            System.out.println("\t____________________________________________________________________________\n");
            for(Map.Entry<Integer, ElementCodeObjet> entry : this.code_objet.entrySet()) {
                int name_var = entry.getKey();
                ElementCodeObjet element = entry.getValue();

                System.out.println("\t "+element.num_elem+ " |"+ element.operation + "\t \t|"+ element.destination+ "\t \t |" + element.source  + "\n");


            }
        }
        else {
            System.out.println("\n/***************Code Objet vide  ******************/\n");

        }
    }
}
