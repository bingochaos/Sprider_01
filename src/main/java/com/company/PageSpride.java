package com.company;

/**
 * Created by bingoc on 16/4/11.
 */
public class PageSpride implements Runnable {

    private String url;
    private int pageNum;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void run() {
        String result = new SprideHttpGet().httpGet("http://bj.lianjia.com" + url + pageNum + '/');
        new RegexUrl().RegexForHouses(result, MyRegularExpression.houseInfoExpression);

    }
}
