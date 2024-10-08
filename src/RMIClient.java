import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int id;
        String nom;
        String auteur;
        int choix;

        do {



        do {


            System.out.println("--Menu--");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Rechercher un livre");
            System.out.println("3. Lister les livres");
            System.out.println("4. Quitter");
            System.out.println("Entrer un numero :");
            choix = sc.nextInt();
            sc.nextLine();

        }while(choix<1 || choix >4);
        try{
            Registry registry=LocateRegistry.getRegistry("localhost",1098);
            MyRemoteService service=(MyRemoteService)registry.lookup("MyRemoteService");
            switch (choix){
                case 1:
                    System.out.println("Entrer Id ");
                    id=sc.nextInt();
                    sc.nextLine();  // Consume the leftover newline
                    System.out.println("Entrer nom");
                    nom=sc.nextLine();
                    System.out.println("Entrer auteur");
                    auteur=sc.nextLine();
                    Livre livre=new Livre(id,nom,auteur);

                    boolean reponse = service.ajouterLivre(livre);
                    if (reponse){
                        System.out.println("Livre ajoute avec succes");
                    }
                    break;
                case 2:
                    System.out.println("Entrer nom");
                    nom=sc.nextLine();
                    Livre livre1 = service.RechercheLivre(nom);
                    if (livre1!=null){
                        System.out.println("--Livre trouvé--");
                        System.out.println("Id:"+livre1.getId());
                        System.out.println("Nom:"+livre1.getName());
                        System.out.println("Auteur:"+livre1.getAuteur());

                    }else{
                        System.out.println("Non trovee");
                    }
                    break;
                case 3:
                    List<Livre> list_livres=service.ListerLivres();
                   if(list_livres.size()>0){
                       int i=1;
                       for( Livre livre_affichage : list_livres){
                           System.out.println("Livre N"+ i);
                           System.out.println("Id:"+livre_affichage.getId());
                           System.out.println("Nom:"+livre_affichage.getName());
                           System.out.println("Auteur:"+livre_affichage.getAuteur());
                           System.out.println("--------------------------------------------");
                           i++;
                       }
                   }else{
                       System.out.println("Aucun livre trouvé");
                   }

                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Error ");

            }






        }catch(Exception e){
            e.printStackTrace();
        }

        }while(choix!=4);

    }


}
