package com.sd.dao.V2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConnectionFactory {
  private static Connection conn = null;
  private ConnectionFactory() {}
  public static Connection getConnection(){
    //Statement stmt=null;
    //ResultSet rs=null;
    try{
      String path=System.getProperty("user.dir");
      path+="/src/mysql.properties.txt";
      Properties prop=new Properties();
      prop.load(new FileInputStream(path));
      Class.forName("com.mysql.jdbc.Driver");
      conn=DriverManager.getConnection(
         prop.getProperty("URL"),
         prop.getProperty("USER"),
         prop.getProperty("PASSWORD")
      );
      //String mySql="select name from persons where id<5 order by id"; 
     //stmt=conn.createStatement();

      //rs=stmt.executeQuery(mySql);
      //while(rs.next()){
        //System.out.println(rs.getString("name")); 
      //}
    }
    catch(Exception e){
      e.printStackTrace();
    }
    return conn;
  }
}