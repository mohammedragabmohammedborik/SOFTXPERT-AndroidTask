package com.mohammed.androiddevelopertask.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.mohammed.androiddevelopertask.R;
import com.mohammed.androiddevelopertask.databinding.ActivityMainBinding;
import com.mohammed.androiddevelopertask.webservice.UtilityHelper;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private  HomeViewModel homeViewModel;
private  int page=4;
private  HomeAdapter homeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        homeViewModel=new ViewModelProvider(this).get(HomeViewModel.class);

        setContentView(activityMainBinding.getRoot());


        setSupportActionBar(activityMainBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setContentView(R.layout.activity_main);
        initView();
        getHomeData();

    }
//    @Override
//    public void onRefresh() {
//    }

    public void getHomeData() {
      //  homeFragmentLayoutBinding.swipReferash.setRefreshing(true);

        try {

            if (UtilityHelper.getConnectionType(this)!=0) {
                homeViewModel.getHomeItem(page).observe(this, new Observer<HomeResponse>() {
                    @Override
                    public void onChanged(HomeResponse orderDatresponse) {
                        if (orderDatresponse != null) {
                            if (orderDatresponse.getStatus() == 1) {
                                homeAdapter.setModelsList(orderDatresponse.getHomeResponsDataList());



                            }
                            else {
                                Toast.makeText(MainActivity.this, "Errorr", Toast.LENGTH_SHORT).show();
                            }

                        } else {

                            Toast.makeText(MainActivity.this, "Errorr", Toast.LENGTH_SHORT).show();



                        }
                    }
                });

            } else {
                Toast.makeText(MainActivity.this, "NoCoonection", Toast.LENGTH_SHORT).show();


            }


        } catch (Exception ex) {
            ex.printStackTrace();


        }
    }

    public  void   initView(){
        homeAdapter=new HomeAdapter(MainActivity.this);

        activityMainBinding.recycleid.setAdapter(homeAdapter);
    }
}
