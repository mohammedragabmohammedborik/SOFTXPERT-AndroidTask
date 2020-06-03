package com.mohammed.androiddevelopertask.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeResponse {
    @SerializedName("status")
    private  int status;
    @SerializedName("data")
    private List<HomeResponsData> homeResponsDataList;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<HomeResponsData> getHomeResponsDataList() {
        return homeResponsDataList;
    }

    public void setHomeResponsDataList(List<HomeResponsData> homeResponsDataList) {
        this.homeResponsDataList = homeResponsDataList;
    }
}
