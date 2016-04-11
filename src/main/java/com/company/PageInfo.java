package com.company;

/**
 * Created by bingoc on 16/4/11.
 */
public class PageInfo {
    private String pageUrl;
    private int pageNums;

    public PageInfo() {
    }

    public String getPageUrl() {

        return pageUrl;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageUrl='" + pageUrl + '\'' +
                ", pageNums=" + pageNums +
                '}';
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public int getPageNums() {
        return pageNums;
    }

    public void setPageNums(int pageNums) {
        this.pageNums = pageNums;
    }

    public PageInfo(int pageNums, String pageUrl) {

        this.pageNums = pageNums;
        this.pageUrl = pageUrl;
    }
}
