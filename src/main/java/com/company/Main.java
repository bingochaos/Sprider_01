package com.company;

import java.util.ArrayList;


public class Main {

    public static String url = "http://bj.lianjia.com/xiaoqu/1111027381403/esf/";
    //public static String url = "http://bj.lianjia.com/ershoufang/pg1";

    public static void main(String[] args) {

        String result =  new SprideHttpGet().httpGet(url);
        ArrayList<HouseInfo> houseInfos = new ArrayList<HouseInfo>();
        PageInfo pageNum = new RegexUrl().RegexForPages(result, MyRegularExpression.pageUrl);
        //RegexUrl.getRegexUrlSington().RegexForHouses(result, MyRegularExpression.houseInfoExpression);
        if(pageNum != null)
        {
            for(int i = 1; i < pageNum.getPageNums()+1; i++)
            {
                PageSpride pageSpride = new PageSpride();
                pageSpride.setUrl(pageNum.getPageUrl());
                pageSpride.setPageNum(i);
                new Thread(pageSpride).start();

            }
        }



    }


}