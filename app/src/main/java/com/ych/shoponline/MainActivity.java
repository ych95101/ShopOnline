package com.ych.shoponline;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mTabhost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabhost= (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this.getApplication(),getSupportFragmentManager(),R.id.realtabcontent);



    }
}
