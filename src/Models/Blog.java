package Models;

import java.sql.Date;
 
/**
 *
 * @author ASUS
 */
public class Blog {
    private int id_blog;
    private String titre;
    private String artiste;
    private Date date_publication;
    private String contenu;
    private String etiquette;
    private String image;

    public Blog(String titre, String artiste, String contenu, String etiquette) {
        this.titre = titre;
        this.artiste = artiste;
        this.contenu = contenu;
        this.etiquette = etiquette;
    }
    


   
    public Blog(int id_blog, String titre, String artiste, Date date_publication, String contenu, String etiquette, String image) {
        this.id_blog = id_blog;
        this.titre = titre;
        this.artiste = artiste;
        this.date_publication = date_publication;
        this.contenu = contenu;
        this.etiquette = etiquette;
        this.image = image;
    }
       public Blog(String titre, String artiste, Date date_publication, String contenu, String etiquette, String image) {
     
        this.titre = titre;
        this.artiste = artiste;
        this.date_publication = date_publication;
        this.contenu = contenu;
        this.etiquette = etiquette;
        this.image = image;
    }
       public Blog() {
    }

    public int getId_blog() {
        return id_blog;
    }

    public String getTitre() {
        return titre;
    }

    public String getArtiste() {
        return artiste;
    }

    public Date getDate_publication() {
        return date_publication;
    }

    public String getContenu() {
        return contenu;
    }

    public String getEtiquette() {
        return etiquette;
    }

    public String getImage() {
        return image;
    }

    public void setId_blog(int id_blog) {
        this.id_blog = id_blog;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public void setDate_publication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setEtiquette(String etiquette) {
        this.etiquette = etiquette;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Blog{" + "id_blog=" + id_blog + ", titre=" + titre + ", artiste=" + artiste + ", date_publication=" + date_publication + ", contenu=" + contenu + ", etiquette=" + etiquette + ", image=" + image + '}';
    }
       
   
}

