package com.mohammed.androiddevelopertask.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mohammed.androiddevelopertask.R;
import com.mohammed.androiddevelopertask.databinding.ItemHomeLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private LayoutInflater inflater;
    Context context;
    List<HomeResponsData> moduleClassList;

    private  List<HomeResponsData> newList=new ArrayList<>();


    public HomeAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());

        }
        return new HomeViewHolder(ItemHomeLayoutBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

    }

    @BindingAdapter("modelImage")
    public static void setModelImage(ImageView modelImage, String imageUrl) {
        Glide.with(modelImage)
                .load(imageUrl)
                .placeholder(R.drawable.empty)
                .into(modelImage);
    }

    public void setModelsList(List<HomeResponsData> moduleClassList) {
        this.moduleClassList = moduleClassList;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position,List<Object> payloads) {

        holder.setModuleClassList(moduleClassList.get(position));


    }


    @Override
    public int getItemCount() {

        if (moduleClassList == null) {
            return 0;
        }
        return moduleClassList.size();
    }

//
    class HomeViewHolder extends RecyclerView.ViewHolder {
        private ItemHomeLayoutBinding itemHomeLayoutBinding;


        public HomeViewHolder(@NonNull ItemHomeLayoutBinding itemView) {
            super(itemView.getRoot());
            this.itemHomeLayoutBinding = itemView;

        }

        void setModuleClassList(HomeResponsData homeModel) {
            this.itemHomeLayoutBinding.setItemHome(homeModel);

        }



    }


}
