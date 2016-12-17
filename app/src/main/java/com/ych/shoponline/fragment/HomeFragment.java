package com.ych.shoponline.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.ych.shoponline.R;

/**
 * Created by Administrator on 2016/10/27.
 */
public class HomeFragment extends Fragment{
    @Nullable

    private  String Tag = "shop";

    private SliderLayout mSliderLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        mSliderLayout = (SliderLayout) view.findViewById(R.id.slider);

        initSlider();
        return view;
    }

    //初始化滚动图片
    private void initSlider() {
        TextSliderView demoSlider = new TextSliderView(this.getActivity());
        demoSlider.description("梦想家1");
        demoSlider.image("http://upload-images.jianshu.io/upload_images/3767216-e3b12041521d3621.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        mSliderLayout.addSlider(demoSlider);

        TextSliderView demoSlider1 = new TextSliderView(this.getActivity());
        demoSlider1.description("梦想家2");
        demoSlider1.image("http://upload-images.jianshu.io/upload_images/3767216-38e71eab98e3ef86.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        mSliderLayout.addSlider(demoSlider1);

        TextSliderView demoSlider2 = new TextSliderView(this.getActivity());
        demoSlider2.description("梦想家3");
        demoSlider2.image("http://upload-images.jianshu.io/upload_images/3767216-ddf8f73175066523.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
        mSliderLayout.addSlider(demoSlider2);

        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setDuration(4000);


        //添加图片滚动事件以及点击图片事件
        /*mSliderLayout.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i(Tag,"OnPageScrolled");
            }

            @Override
            public void onPageSelected(int position) {
                Log.i(Tag,"OnPageSelected");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i(Tag,"onPageScrollStateChanged");
            }
        });*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSliderLayout.stopAutoCycle();
    }
}