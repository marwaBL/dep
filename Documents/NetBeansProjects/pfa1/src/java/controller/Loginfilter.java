/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER1
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class Loginfilter  implements Filter{

    
     public static final String ACCES_CONNEXION  = "/faces/connexion.xhtml";
  public static final String ATT_SESSION_USER = "sessionUtilisateur";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    /* Cast des objets request et response */
HttpServletRequest request = (HttpServletRequest) req;
HttpServletResponse response = (HttpServletResponse) res;

/* Récupération de la session depuis la requête */
HttpSession session = request.getSession();

/**
 * Si l'objet utilisateur n'existe pas dans la session en cours, alors
 * l'utilisateur n'est pas connecté.
 */
if ( UserController.u == null ) {
    /* Redirection vers la page publique */
    request.getRequestDispatcher( ACCES_CONNEXION ).forward( request, response );
} else {
    /* Affichage de la page restreinte */
    chain.doFilter( request, response );
}
    
    
    
    
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
