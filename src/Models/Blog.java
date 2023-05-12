package Models;

import java.sql.Date;
 
/**
 *
 * @author ASUS
 */
public class Blog {
    private int id_blog;
    private String titre;
    private Artiste artiste;
    private String contenu;
    private String etiquette;

    public Blog(String titre, Artiste artiste, String contenu, String etiquette) {
        this.titre = titre;
        this.artiste = artiste;
        this.contenu = contenu;
        this.etiquette = etiquette;
    }
    


   
    public Blog(int id_blog, String titre, Artiste artiste, String contenu, String etiquette) {
        this.id_blog = id_blog;
        this.titre = titre;
        this.artiste = artiste;
        this.contenu = contenu;
        this.etiquette = etiquette;
    }
       public Blog() {
    }

    public int getId_blog() {
        return id_blog;
    }

    public String getTitre() {
        return titre;
    }

    public Artiste getArtiste() {
        return artiste;
    }


    public String getContenu() {
        return contenu;
    }

    public String getEtiquette() {
        return etiquette;
    }



    public void setId_blog(int id_blog) {
        this.id_blog = id_blog;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }


    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setEtiquette(String etiquette) {
        this.etiquette = etiquette;
    }

    @Override
    public String toString() {
        return "Blog{" + "id_blog=" + id_blog + ", titre=" + titre + ", artiste=" + artiste + ", contenu=" + contenu + ", etiquette=" + etiquette + '}';
    }

 

       
   
}

