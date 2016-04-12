package com.company;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bingoc on 16/4/11.
 */
public class RegexUrl {

    private static Logger logger = Logger.getLogger(RegexUrl.class);

    public RegexUrl() {
    }

    public PageInfo RegexForPages(String targetStr, String patternStr)
    {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(targetStr);
        PageInfo pageInfo = new PageInfo();

        if(matcher.find())
        {
            System.out.println(matcher.group());
            pageInfo.setPageNums(Integer.parseInt(matcher.group(2)));
            pageInfo.setPageUrl(matcher.group(1));
            return pageInfo;
        }
        return null;
    }
    //获取当前页的房产信息
    public ArrayList<HouseInfo> RegexForHouses(String targetStr, String patternStr)
    {
        ArrayList<HouseInfo> results = new ArrayList<HouseInfo>();
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(targetStr);
        boolean isFind = matcher.find();

        while(isFind){
            HouseInfo houseInfo = new HouseInfo();

/*
houseInfo = new HouseInfo(Integer.getInteger(matcher.group(1)),
matcher.group(2), matcher.group(3), matcher.group(4), matcher.group(5),
Integer.getInteger(matcher.group(6)),
matcher.group(7));
*/
            houseInfo.setHouseIndex(Integer.parseInt(matcher.group(1)));
            houseInfo.setHouseDataId(matcher.group(2));
            houseInfo.setHouseTitle(matcher.group(3));
            houseInfo.setHouseRegion(matcher.group(4));
            houseInfo.setHouseArea(matcher.group(5));
            houseInfo.setHousePrice(Integer.parseInt(matcher.group(6)));
            houseInfo.setHousePricePer(matcher.group(7));

            JSONObject jsonObject = new JSONObject(houseInfo);
            System.out.println(jsonObject);

            try {
                JSONObject jsonObjectOld = ReadJsonFile("/Users/bingoc/IdeaProjects/Log/Spride_01/" + houseInfo.getHouseDataId() + ".json");
                if(jsonObject.getInt("housePrice") != jsonObjectOld.getInt("housePrice")){
                    WriteJsonFile("/Users/bingoc/IdeaProjects/Log/Spride_01/" + houseInfo.getHouseDataId() + ".json", jsonObject.toString());
                    logger.error("\n新房价信息\n" + houseInfo);
                }
            } catch (FileNotFoundException e) {
                try {
                    WriteJsonFile("/Users/bingoc/IdeaProjects/Log/Spride_01/" + houseInfo.getHouseDataId() + ".json", jsonObject.toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                logger.error("\n新房源信息\n" + houseInfo);
            } catch (IOException e)
            {

            }
            results.add(houseInfo);

            isFind = matcher.find();
           // logger.debug(houseInfo);
        }

        return results;
    }

    public static synchronized void WriteJsonFile(String filePath, String josn) throws IOException
    {
        FileWriter fileWriter = new FileWriter(filePath, true);
        PrintWriter out = new PrintWriter(fileWriter);
        //out.write(josn);
        //out.println();
        out.println(josn);
        //out.println();
        fileWriter.close();
        out.close();
    }

    public static JSONObject ReadJsonFile(String filePath) throws IOException
    {
        File file = new File(filePath);
        BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String string = bufferedReader.readLine();
        JSONObject jsonObject = new JSONObject(string);
        return jsonObject;

    }
}
