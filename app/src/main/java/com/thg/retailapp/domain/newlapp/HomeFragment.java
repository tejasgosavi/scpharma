package com.thg.retailapp.domain.newlapp;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;
    //////Banner Slider Finish

    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllBtn;
    private RecyclerView horizontalRecyclerView;
    ////Horizontal Product Finish

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ////// Banner Slider
        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);

        sliderModelList = new ArrayList<SliderModel>();
        sliderModelList.add(new SliderModel(R.drawable.logo_transparent));
        sliderModelList.add(new SliderModel(R.drawable.logo_transparent));
        sliderModelList.add(new SliderModel(R.drawable.logo_transparent));
        sliderModelList.add(new SliderModel(R.drawable.logo_transparent));
        sliderModelList.add(new SliderModel(R.drawable.logo_transparent));


        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);
        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                currentPage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    pageLooper();
                }
            }
        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);
        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideShow();
                if (event.getAction()==MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });
        //////// Banner Slider End

        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalLayoutViewAllBtn = view.findViewById(R.id.horizontal_scroll_layout_button);
        horizontalRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recyclerView);

        List<HorizontalProductModel> horizontalProductModelList = new ArrayList<>();
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.cart,"Azicip","Cipla ltd","11% + (20+5)"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.cart,"Azicip","Cipla ltd","11% + (20+5)"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.cart,"Azicip","Cipla ltd","11% + (20+5)"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.cart,"Azicip","Cipla ltd","11% + (20+5)"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.cart,"Azicip","Cipla ltd","11% + (20+5)"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.cart,"Azicip","Cipla ltd","11% + (20+5)"));
        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.cart,"Azicip","Cipla ltd","11% + (20+5)"));

        HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();

        ////// Horizontal Product End
        ////////////////////////////////// Grid Layout1
        GridView gridView = view.findViewById(R.id.grid_product_layout_gridview);
        gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductModelList));
        ///////////////////////////////// Grid Layout1
        ///////////////////////////////// Grid Layout2
        GridView gridView2 = view.findViewById(R.id.grid_product_layout2_grdview);
        gridView2.setAdapter(new GridProductLayout2Adapter(horizontalProductModelList));
        ///////////////////////////////// Grid Layout2

        return view;

    }
    private void pageLooper(){
        if (currentPage == sliderModelList.size() - 2){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if (currentPage == 1){
            currentPage =sliderModelList.size() - 3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
    }

    private void startBannerSlideShow() {
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage >= sliderModelList.size()){

                    currentPage =1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME);
    }

    private void stopBannerSlideShow(){
        timer.cancel();

    }

}
