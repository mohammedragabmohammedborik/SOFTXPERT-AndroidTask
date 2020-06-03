package com.mohammed.androiddevelopertask.home;

import com.google.gson.annotations.SerializedName;

public class HomeResponsData {
    @SerializedName("brand")
    private  String brand;
    @SerializedName("isUsed")
    private  String  isUsed;
    @SerializedName("imageUrl")
    private  String imageUrl;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
