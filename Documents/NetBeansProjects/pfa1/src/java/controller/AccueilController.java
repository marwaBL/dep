/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChercheurDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import modele.Chercheur;
import modele.User;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.DonutChartModel;

/**
 *
 * @author USER1
 */
@Named(value = "accueilController")
@SessionScoped
public class AccueilController implements Serializable {

    /**
     * Creates a new instance of AccueilController
     */
    private List<String> images;  
    private DonutChartModel donutModel;  
      
    private BubbleChartModel bubbleModel;  
private Chercheur ch;

    public Chercheur getCh() {
        return ch;
    }

    public void setCh(Chercheur ch) {
        this.ch = ch;
    }






    public BubbleChartModel getBubbleModel() {
        return bubbleModel;
    }

    public void setBubbleModel(BubbleChartModel bubbleModel) {
        this.bubbleModel = bubbleModel;
    }

    public List <String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
  
   
  
    private void createBubbleModel() {  
        bubbleModel = new BubbleChartModel();  
  
        bubbleModel.add(new BubbleChartSeries("Acura", 70, 183,55));  
        bubbleModel.add(new BubbleChartSeries("Alfa Romeo", 45, 92, 36));  
        bubbleModel.add(new BubbleChartSeries("AM General", 24, 104, 40));  
        bubbleModel.add(new BubbleChartSeries("Bugatti", 50, 123, 60));  
        bubbleModel.add(new BubbleChartSeries("BMW", 15, 89, 25));  
        bubbleModel.add(new BubbleChartSeries("Audi", 40, 180, 80));  
        bubbleModel.add(new BubbleChartSeries("Aston Martin", 70, 70, 48));  
    }  
      
    public DonutChartModel getDonutModel() {  
        return donutModel;  
    }  
   
    private void createDonutModel() {  
        donutModel = new DonutChartModel();  
          
        Map<String, Number> circle1 = new LinkedHashMap<String, Number>();  
        circle1.put("Brand 1", 150);  
        circle1.put("Brand 2", 400);  
        circle1.put("Brand 3", 200);  
        circle1.put("Brand 4", 10);  
        donutModel.addCircle(circle1);  
          
        Map<String, Number> circle2 = new LinkedHashMap<String, Number>();  
        circle2.put("Brand 1", 540);  
        circle2.put("Brand 2", 125);  
        circle2.put("Brand 3", 702);  
        circle2.put("Brand 4", 421);  
        donutModel.addCircle(circle2);  
          
        Map<String, Number> circle3 = new LinkedHashMap<String, Number>();  
        circle3.put("Brand 1", 40);  
        circle3.put("Brand 2", 325);  
        circle3.put("Brand 3", 402);  
        circle3.put("Brand 4", 421);  
        donutModel.addCircle(circle3);  
    }  
    
    
    
    public AccueilController() {
         createDonutModel();  
         createBubbleModel();  
         images = new ArrayList<String>();  
       /* images.add("images1.jpg");  
        images.add("images2.jpg");*/  
       
      
         
          images.add("image7.jpg");
          images.add("image8.jpg");
          images.add("image9.jpg");
          images.add("image10.jpg");
            
    }
    
    public String genererProfil()
    { System.out.println("generer profil");
        return "profil";
       /* UserController uC=new UserController();
        User u=uC.getU();
        ChercheurDao chdao=new ChercheurDao();
      Chercheur ch=  chdao.findChercheurByUser(u);
      setCh(ch);*/
    }
    
}
