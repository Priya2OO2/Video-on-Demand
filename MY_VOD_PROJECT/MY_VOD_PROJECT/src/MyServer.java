import com.vmm.JHTTPServer;
import java.io.File;
import java.util.Properties;
import vmm.DBLoader;
import java.sql.*;

public class MyServer extends JHTTPServer{
    
    public MyServer(int portno) throws Exception{
        
        super(portno);
    }
    
    
    @Override
   public Response serve(String uri,String method,Properties header,Properties parms,Properties files){
      
           if(uri.equals("/")){
               String ans=("WELCOME TO MY SERVER");
               Response rs=new Response(HTTP_OK,"text/plain",ans);
               return rs;
               
           }
           else if(uri.equals("/one")){
               
               String ans="Random no is"+Math.random();
               Response rs=new Response(HTTP_OK,"text/plain",ans);
               return rs;
               
           }
           else if(uri.equals("/checklogin")){
               
               String u=parms.getProperty("user");
               String p=parms.getProperty("pass");
               
                 String ans;
               try{
                   
                   ResultSet rs=DBLoader.executeSQL("select * from users where username='"+u+"'and password='"+p+"'");
                   
                   if(rs.next()){
                       
                       
                       ans="Login Successfull!!!";
                   }
                   else{
                       
                       ans="Login Failed!!!";
                   }
                   
                   
               }
           
           catch(Exception ex){
                   ans=ex.toString();
                   
                   }
               Response res=new Response(HTTP_OK,"text/plain",ans);
               return res;
   }
           else if(uri.equals("/signup")){
                
                String u=parms.getProperty("user");
                String p=parms.getProperty("pass");
                String m=parms.getProperty("mobile");
                String e=parms.getProperty("email");
                
                //2 recieve files
                String abspath="src/myuploads/users";
              String photo_name=  saveFileOnServerWithOriginalName(files,parms,"f1",abspath);
                
                
                String ans="";
                
                
                try{
                    ResultSet  rs= DBLoader.executeSQL("select * from users where username='"+u+"'");
                    
                    if(rs.next()){
                        
                        ans="This Username is Already Taken";
                    }
                    else{
                        
                        rs.moveToInsertRow();
                         
                        rs.updateString("username", u);
                        rs.updateString("password",p);
                        rs.updateString("mobile", m);
                        rs.updateString("email", e);
                        rs.updateString("photo",abspath+"/"+photo_name);
                        rs.insertRow();
                        ans="SignUp Sucessfully";
                    }
                }
                catch(Exception ex){
                    
                    ans=ex.toString();
                    
                    
                    
                }
                Response res=new Response(HTTP_OK,"text/plain",ans);
                return res;
           }
            else if(uri.equals("/getcategories"))
         {
             String ans = "";
             
             try
             {
                 ResultSet rs = DBLoader.executeSQL("select * from category");
                 
                 String catname, photo;
                 
                 while(rs.next())
                 {
                     catname = rs.getString("catname");
                     photo = rs.getString("photo");
                     
                     ans = ans + catname + "," + photo+";";
                 }
                 
             }
             catch(Exception ex)
             {
                 ans = ex.toString();
             }
             
             
             Response res = new Response(HTTP_OK, "text/plain", ans );
             return res;
         }
          else if(uri.equals("/addcategory"))
         {
             // receive text
             String catname = parms.getProperty("catname");
             
             // receive file and save
             String abspath = "src/myuploads/category/";
             
             String photo_name = saveFileOnServerWithOriginalName(files, parms, "f1", abspath);
         
             String ans = "";
             
             // now record in DB
             try
             {
                 ResultSet rs = DBLoader.executeSQL("select * from category where catname='"+catname+"'");
         
                 if(rs.next())
                 {
                     ans = "This Category Already Exists !!"; 
                 }
                 else
                 {
                     rs.moveToInsertRow();
                     
                     rs.updateString("catname", catname);
                     rs.updateString("photo", abspath+photo_name);
                     
                     rs.insertRow();
                     
                     ans = "New Category Added Successfully !!!";
                     
                 }
             }
             catch(Exception ex)
             {
                 ex.printStackTrace();
                 ans = ex.toString();
             }
             
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
          else if(uri.equals("/addvideo"))
         {
             String videoname = parms.getProperty("videoname");
             String desc = parms.getProperty("desc");
             String trailer = parms.getProperty("trailer");
             String catname = parms.getProperty("catname");
             int runningtime = Integer.parseInt(parms.getProperty("runningtime"));
             
             
             String abspath1 = "src/myuploads/posters/";
             
             String poster_name = saveFileOnServerWithOriginalName(files, parms, "poster", abspath1);
             
             String abspath2 = "src/myuploads/videos/";
             
             String movie_name = saveFileOnServerWithOriginalName(files, parms, "video", abspath2);
             
             // now record in DB
             
             String ans = "";
             
             try
             {
                 ResultSet rs = DBLoader.executeSQL("select * from videos where videoname='"+videoname+"'");
                 
                 if(rs.next())
                 {
                     ans = "This Video Name Already Exists !!!";
                 }
                 else
                 {
                     rs.moveToInsertRow();
                     
                     rs.updateString("videoname", videoname);
                     rs.updateString("description", desc);
                     
                     // \\ add for mac
                     rs.updateString("photo", abspath1+"\\"+poster_name);
                     
                     rs.updateString("videolink", abspath2+"\\"+movie_name);
                     
                     rs.updateString("trailerlink", trailer);
                     rs.updateString("catname", catname);
                     rs.updateInt("runningtime", runningtime);
                     
                     rs.insertRow();
                     
                     ans = "New Movie Added Successfully !!!";
                 }
                 
             }
             catch(Exception ex)
             {
                 ans = ex.toString();
             }
             
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
             
         }
         else if(uri.equals("/getvideos"))
         {
             String catname = parms.getProperty("catname");
             
             String ans = "";
             
             try
             {
                 ResultSet rs = DBLoader.executeSQL("select vid,videoname,photo from videos where catname='"+catname+"'");
             
                 while(rs.next())
                 {
                     int vid = rs.getInt("vid");
                     String vname = rs.getString("videoname");
                     String desc  = rs.getString("photo");
                     
                     ans = ans + vid+","+vname+","+desc+";";
                     
                 }
                 
             
             }
             catch(Exception ex)
             {
                 ans = ex.toString();
             }
             
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
         else if(uri.equals("/getvideodetail"))
         {
             int vid = Integer.parseInt(parms.getProperty("vid"));
             
             String ans="";
             
             try
             {
                ResultSet rs = DBLoader.executeSQL("select * from videos where vid="+vid);
                
                if(rs.next())
                {
                    String vname = rs.getString("videoname");
                    String desc  = rs.getString("description");
                    String photo = rs.getString("photo");
                    String trailerlink = rs.getString("trailerlink");
                    String videolink = rs.getString("videolink");
                    String catname = rs.getString("catname");
                    int runningtime = rs.getInt("runningtime");
                    
                    ans = vname+","+desc+","+photo+","+videolink+","+trailerlink+","+catname+","+runningtime;
                }
             }
             catch(Exception ex)
             {
                 ans = ex.toString();
             }
             
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
         else if(uri.equals("/playmovie"))
         {
             String movie_path = parms.getProperty("movie_path");
             
             Response res = streamFile(movie_path, method, header);
             return res;
         }
         else if(uri.equals("/checkadminlogin"))
         {
             String u = parms.getProperty("user");
             String p = parms.getProperty("pass");
             
             String ans = "";
             
             try
             {
                ResultSet rs = 
                DBLoader.executeSQL("select * from admin where username='"+u+"' and password='"+p+"'");
             
                if(rs.next())
                {
                    ans = "success";
                }
                else
                {
                    ans = "fail";
                }
                
             }
             catch(Exception ex)
             {
                 ans = ex.toString();
             }
             
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
         else
         {
             String ans = "Invalid uri";   
             Response res = new Response(HTTP_OK, "text/plain", ans);
             return res;
         }
    }
    
   

   
       
        
    
    
    
}
