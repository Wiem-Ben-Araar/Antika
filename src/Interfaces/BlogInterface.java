/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import Models.Blog;

/**
 *
 * @author dridi
 */
public interface BlogInterface {
     public void AjouterBlog(Blog object);

    public void ModifierBlog(Blog object,int id);

    public void SupprimerBlog(int id);

    public List<Blog> RechercherBlog(String titre);

    public List<Blog> AfficherBlogs();

    public Blog getBlogById(int object);

    public List<Blog>  TrieBlog(String object);

    
}
