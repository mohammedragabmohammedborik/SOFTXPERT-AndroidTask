package com.mohammed.androiddevelopertask.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mohammed.androiddevelopertask.webservice.APIClient;
import com.mohammed.androiddevelopertask.webservice.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {
    private static final String TAG = "HomeRepositary";
 private ApiInterface apiInterface = APIClient.getInstance().apiInterface();

    private MutableLiveData<HomeResponse> homeResponsMutableLiveData;






    public LiveData<HomeResponse> getHomeItem(int page) {
        if(homeResponsMutableLiveData==null) {
            homeResponsMutableLiveData = new MutableLiveData<>();
        }

        apiInterface.getHomeItems(page)
                .enqueue(new Callback<HomeResponse>() {
                    @Override
                    public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                        if (response.body() != null && response.isSuccessful()  ){

                            homeResponsMutableLiveData.setValue(response.body());
                        }

                    }

                    @Override
                    public void onFailure( Call<HomeResponse> call, Throwable t) {
                        homeResponsMutableLiveData.setValue(null);
                        //  Log.e(TAG, "on fetch models: " + t.getLocalizedMessage());
                    }
                });
        return homeResponsMutableLiveData;
    }


}
