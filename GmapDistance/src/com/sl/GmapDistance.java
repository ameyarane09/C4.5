package com.sl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class GmapDistance {
  public static void main(String[] args) throws IOException {
	  // Reference - https://developers.google.com/maps/documentation/distancematrix/
	  URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Stamford&destinations=JFK");
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      String line, outputString = "";
      BufferedReader reader = new BufferedReader(
      new InputStreamReader(conn.getInputStream()));
      while ((line = reader.readLine()) != null) {
          outputString += line;
      }
      System.out.println(outputString);
      String str="";
      int i = outputString.indexOf("duration");
      for(int x=i+41;x<i+56;x++)
      {
    	  str = str+outputString.charAt(x);
    	//  System.out.println(outputString.charAt(x));
      }
      System.out.println(str);
      DistancePojo capRes = new Gson().fromJson(outputString, DistancePojo.class);
      System.out.println(capRes);
  }
}
	