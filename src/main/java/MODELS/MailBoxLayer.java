package MODELS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static com.google.common.net.HttpHeaders.USER_AGENT;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author hamza
 */
public class MailBoxLayer {

    /**
     * make a get request to MailBoxLayer api
     */
    private String getData(String email) throws Exception {
        String url = "http://apilayer.net/api/check?access_key=1e10d00ff0f032f29638c0ae4da00182&email=" + email + "&smtp=1&format=1";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    /**
     * return true if email exist , false if not
     */
    public boolean checkSMTP(String email) {
        JSONObject res;
        try {
            //convert response to json object
            res = new JSONObject(getData(email));
            return res.getBoolean("smtp_check");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
}
