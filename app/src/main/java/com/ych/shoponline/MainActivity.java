package com.ych.shoponline;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.ych.shoponline.fragment.HomeFragment;


public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mTabhost;
    private LayoutInflater mInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInflater = LayoutInflater.from(this);
        mTabhost= (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this.getApplication(),getSupportFragmentManager(),R.id.realtabcontent);

        View view1 = mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img = (ImageView) view1.findViewById(R.id.icon_tab);
        TextView tv = (TextView) view1.findViewById(R.id.txt_indicator);

        img.setBackgroundResource(R.mipmap.icon_home);
        tv.setText("主页");

        TabHost.TabSpec tabSpec = mTabhost.newTabSpec("home");
        tabSpec.setIndicator(view1);

        mTabhost.addTab(tabSpec, HomeFragment.class,null);

    }
}
