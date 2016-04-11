package com.company;

/**
 * Created by bingoc on 16/4/11.
 */
public class HouseInfo {
    //网页中的数据标签index
    private int houseIndex;
    //房产数据编号
    private String houseDataId;
    //标题
    private String houseTitle;
    //小区
    private String houseRegion;
    //大小(平米）
    private String houseArea;
    //总价格
    private int housePrice;
    //每平米价格
    private String housePricePer;

    public HouseInfo() {
    }

    public HouseInfo(int houseIndex, String houseDataId, String houseTitle, String houseRegion, String houseArea, int housePrice, String housePricePer) {
        this.houseIndex = houseIndex;
        this.houseDataId = houseDataId;
        this.houseTitle = houseTitle;
        this.houseRegion = houseRegion;
        this.houseArea = houseArea;
        this.housePrice = housePrice;
        this.housePricePer = housePricePer;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "houseIndex=" + houseIndex +
                ", houseDataId='" + houseDataId + '\'' +
                ", houseTitle='" + houseTitle + '\'' +
                ", houseRegion='" + houseRegion + '\'' +
                ", houseArea='" + houseArea + '\'' +
                ", housePrice=" + housePrice +
                ", housePricePer='" + housePricePer + '\'' +
                '}';
    }

    public int getHouseIndex() {
        return houseIndex;
    }

    public void setHouseIndex(int houseIndex) {
        this.houseIndex = houseIndex;
    }

    public String getHouseDataId() {
        return houseDataId;
    }

    public void setHouseDataId(String houseDataId) {
        this.houseDataId = houseDataId;
    }

    public String getHouseTitle() {
        return houseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        this.houseTitle = houseTitle;
    }

    public String getHouseRegion() {
        return houseRegion;
    }

    public void setHouseRegion(String houseRegion) {
        this.houseRegion = houseRegion;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

    public String getHousePricePer() {
        return housePricePer;
    }

    public void setHousePricePer(String housePricePer) {
        this.housePricePer = housePricePer;
    }
}
