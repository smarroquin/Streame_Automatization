package com.streame.dbTest;

import java.sql.ResultSet;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.streame.base.SQLConnector;

public class UserDBTest {

	public SQLConnector SQLConnector;
	
	 @Test(priority = 1)
	 public void ListOfUser() throws Exception {
		 
		 SQLConnector.setUp();
     try{
	 String query = "select * from userinfo";
	 // Get the contents of userinfo table from DB
	 ResultSet res = SQLConnector.stmt.executeQuery(query);
	// Print the result untill all the records are printed
	 // res.next() returns true if there is any next record else returns false
	  while (res.next())
	    {
      System.out.print(res.getString(1));
	       System.out.print("\t" + res.getString(2));
	         System.out.print("\t" + res.getString(3));
	       System.out.println("\t" + res.getString(4));
	    }
	  }
      catch(Exception e)
	         {
	              e.printStackTrace();
	       }     
	 }
}
