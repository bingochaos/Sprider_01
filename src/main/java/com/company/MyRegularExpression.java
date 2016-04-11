package com.company;

/**
 * Created by bingoc on 16/4/11.
 */
public class MyRegularExpression {
    // 房产数据匹配正则
    public static final String houseInfoExpression = "data-index=\"(.+?)\".+?" +//标签
            "data-id=\"(.+?)\">.*?" +//数据id
            "<h2><a.+?title=.+?>(.+?)[&nbsp;]{0,}</a>.*?" +//title
            "region.+?>(.+?)[&nbsp;]{0,}<.*?" +//小区
            "meters.+?>(.+?)[&nbsp;]{0,}<.*?" +//大小
            "price.+?num.+?>(.+?)</span>.*?" +//价格
            "price-pre.+?>(.+?)</div>";//每平米价格

    //pageUrl
    public static final String pageUrl = "comp-module=.+?page-url=\"(.+?)\\{.*?page-data.+?\"totalPage\":(.+?),\"";
    //页数
    public static final String pagesNumber = "page-data=\"{\"totalPage\":(.+?),\"";

    //各页地址
    public static final String pages = "href=\"(.+?)\" data-page";


}
