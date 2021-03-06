package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by bingoc on 16/4/11.
 */
public class SpiderHttpGet {

    private URLConnection urlConnection;

    public SpiderHttpGet() {
    }

    public SpiderHttpGet(URLConnection urlConnection) {
        this.urlConnection = urlConnection;
    }

    public String httpGet(String url)
    {
        String result = "";

        BufferedReader in = null;

        try {
            URL realUrl = new URL(url);
            System.out.println(realUrl + "\n" + url);
            urlConnection = realUrl.openConnection();
            urlConnection.connect();
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            System.out.println(urlConnection.getHeaderFields());

            String line;
            while((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e){
            System.out.println("发送get请求异常！" + e);
            e.printStackTrace();
        } finally {
            try{
                if(in != null){
                    in.close();
                }

            }catch (Exception e2){

                e2.printStackTrace();
            }
        }
        return result;
    }




}
