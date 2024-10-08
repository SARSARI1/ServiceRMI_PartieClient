import java.io.Serializable;

public class Livre implements Serializable {
    private int id;
    private String name;
    private String auteur;

    public Livre() {
    }

    public Livre(int id, String name, String auteur) {
        this.id = id;
        this.name = name;
        this.auteur = auteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
