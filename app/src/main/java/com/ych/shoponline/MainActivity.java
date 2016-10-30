package com.ych.shoponline;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.ych.shoponline.bean.Tab;
import com.ych.shoponline.fragment.CartFragment;
import com.ych.shoponline.fragment.CategoryFragment;
import com.ych.shoponline.fragment.HomeFragment;
import com.ych.shoponline.fragment.HotFragment;
import com.ych.shoponline.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mTabhost;
    private LayoutInflater mInflater;
    private List<Tab> mTabs = new ArrayList<>(5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInflater = LayoutInflater.from(this);//获得容器
        initTab();
    }

    // init the tabs
    private void initTab() {
        Tab tab_home = new Tab(R.string.home,R.drawable.selector_icon_home,HomeFragment.class);
        Tab tab_hot = new Tab(R.string.hot,R.drawable.selector_icon_hot,HotFragment.class);
        Tab tab_category = new Tab(R.string.catagory,R.drawable.selector_icon_category,CategoryFragment.class);
        Tab tab_cart = new Tab(R.string.cart,R.drawable.selector_icon_cart,CartFragment.class);
        Tab tab_mine = new Tab(R.string.mine,R.drawable.selector_icon_mine,MineFragment.class);

        mTabs.add(tab_home);
        mTabs.add(tab_hot);
        mTabs.add(tab_category);
        mTabs.add(tab_cart);
        mTabs.add(tab_mine);

        //获得realtabcontent，然后启动
        mTabhost= (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this.getApplication(),getSupportFragmentManager(),R.id.realtabcontent);
        for (Tab tab : mTabs){
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));//把tab导入到tabspec的indicator中
            mTabhost.addTab(tabSpec,tab.getFragment(),null);//导入tab以及对应的fragment页面
        }

        //mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        //mTabhost.setCurrentTab(10);

    }

    //准备每个tab的内容Indicator
    private  View buildIndicator(Tab tab){

        View view1 = mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img = (ImageView) view1.findViewById(R.id.icon_tab);
        TextView tv = (TextView) view1.findViewById(R.id.txt_indicator);
        img.setBackgroundResource(tab.getIcon());
        tv.setText(tab.getTitle());
        return  view1;
    }

}
