package com.mohammed.androiddevelopertask.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private HomeRepository profileRepository;
    public HomeViewModel() {
        profileRepository =new HomeRepository();
    }




    public LiveData<HomeResponse> getHomeItem(int  page ){
        return  profileRepository.getHomeItem(page);
    }


}
