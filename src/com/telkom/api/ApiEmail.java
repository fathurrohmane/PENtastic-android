package com.telkom.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;

public class ApiEmail {

	/**
	 * @param args
	 */
	public ApiEmail() {

	}
	
	public void OAuth(){
		// inisialisasi consumer key, dan consumer secret
        OAuthConsumer consumer = new DefaultOAuthConsumer("bestapp140","K50YB");
 
        OAuthProvider provider = new DefaultOAuthProvider("http://sandbox.appprime.net/TemanDev/rest/RequestToken/",
        		"http://sandbox.appprime.net/TemanDev/rest/AccessToken/",
        		"");
        
        		System.out.println("Fetching request token ... ");
        		String verificationCode = null;
        		String authUrl;
        		try {
        			/* Send SMS */   			
//        			authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND); // get request token
//                    System.out.println("Request token =" + consumer.getToken());
//                    System.out.println("Token Secret =" + consumer.getTokenSecret());
//                    System.out.println("Now visit:\n" + authUrl
//                                    + "\n... and grant this app authorization");
//                    verificationCode = "1";
//                    System.out.println("Fetching access token...");
//                    provider.retrieveAccessToken(consumer, verificationCode.trim()); // get access token
//                    System.out.println("Access token: " + consumer.getToken());
//                    System.out.println("Token secret: " + consumer.getTokenSecret());
//                    
//                    String inputJSON = "{\"sendSMS\":{\"pinRequestID\":\"1\",\"pinDestAddress\":\"6285294159556\",\"pinMessageBody\":\"tes send sms\",\"pinShortCode\":\"9147\"}}";
//                    
//                    System.out.println(inputJSON);
//                    
//                    URL url2 = new URL("http://sandbox.appprime.net/TemanDev/rest/sendSMS/"); // inisialisasi URL API
//                    HttpURLConnection connection = (HttpURLConnection)url2.openConnection();
//     
//                    connection.setRequestMethod("POST"); // inisialiasi method
//                    connection.setRequestProperty("Content-Type", "application/json");  // content-type
//                    connection.setDoOutput(true);
//                    consumer.setTokenWithSecret(consumer.getToken(), consumer.getTokenSecret()); // input access token dan access token secret
//                    consumer.sign(connection);
//     
//                    OutputStreamWriter outputWriter = new OutputStreamWriter(connection.getOutputStream());
//                    outputWriter.write(inputJSON); // request message in post body
//                    outputWriter.flush();
//                    outputWriter.close();
//     
//                    BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream())); // get response
//                    String line;
//                    while ((line = rd.readLine()) != null) { // read response
//                        System.out.println(line);
//                    }
//                    connection.connect();
        
        
        /* SEnd EMail */
        			authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND); // get request token
                    System.out.println("Request token =" + consumer.getToken());
                    System.out.println("Token Secret =" + consumer.getTokenSecret());
                    System.out.println("Now visit:\n" + authUrl
                                    + "\n... and grant this app authorization");
                    verificationCode = "1";
                    System.out.println("Fetching access token...");
                    provider.retrieveAccessToken(consumer, verificationCode.trim()); // get access token
                    System.out.println("Access token: " + consumer.getToken());
                    System.out.println("Token secret: " + consumer.getTokenSecret());
                    
                    String inputJSON = "{\"sendEmail\":{\"to\":\"bimoputra1994@gmail.com\",\"subject\":\"BEST APPS ID\",\"content\":\"SELAMAT! TIM KAMU MENANG KOMPETISI BEST APSS ID KATEGORI GAMES!\"}}";
                    
                    System.out.println(inputJSON);
                    
                    URL url2 = new URL("http://sandbox.appprime.net/TemanDev/rest/sendEmail/"); // inisialisasi URL API
                    HttpURLConnection connection = (HttpURLConnection)url2.openConnection();
      
                    connection.setRequestMethod("POST"); // inisialiasi method
                    connection.setRequestProperty("Content-Type", "application/json");  // content-type
                    connection.setDoOutput(true);
                    consumer.setTokenWithSecret(consumer.getToken(), consumer.getTokenSecret()); // input access token dan access token secret
                    consumer.sign(connection);
     
                    OutputStreamWriter outputWriter = new OutputStreamWriter(connection.getOutputStream());
                    outputWriter.write(inputJSON); // request message in post body
                    outputWriter.flush();
                    outputWriter.close();
     
                    BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream())); // get response
                    String line;
                    while ((line = rd.readLine()) != null) { // read response
                        System.out.println(line);
                    }
                    connection.connect();
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
    }
}
