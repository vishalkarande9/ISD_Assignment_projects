// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



// Extend HttpServlet class
public class testServlet extends HttpServlet {  
   // Method to handle GET method request.
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String appHeight =request.getParameter("app_height") ;
      String appWidth = request.getParameter("app_width") ;
      String message = request.getParameter("message") ;
      String fontSize = request.getParameter("font_size") ;
      String fontStyle_bold = request.getParameter("font_style_bold") ; 
      String fontStyle_italic = request.getParameter("font_style_italic") ; 
      String fontColor = request.getParameter("font_color") ;
      String shapeHeight = request.getParameter("shape_height") ;
      String shapeWidth = request.getParameter("shape_width") ;
      String shape = request.getParameter("shape") ;
      String shapeColor = request.getParameter("shape_color") ;

      // Set response content type
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String title = "Reading All Form Parameterssadddddddddddddddddddddddddddddddd";
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
         
         out.println("appHeight : "+appHeight+" appWidth : "+appWidth+" message : "+message+" fontSize : "+fontSize+" fontStyle_bold : "+fontStyle_bold+" fontStyle_italic : "+fontStyle_italic+" fontColor : "+fontColor+" shapeHeight : "+shapeHeight+" shapeWidth : "+shapeWidth+ " shape : "+shape+" shapeColor : "+shapeColor);
      

      
   }

 

   // Method to handle POST method request.
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      doGet(request, response);
   }

   
}


// command to compile javac -classpath 'C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar' .\testServlet.java