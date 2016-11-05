package com.ych.shoponline.weidgt;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ych.shoponline.R;

/**
 * Created by Administrator on 2016/11/3.
 */
public class SOToolbar extends Toolbar {

    private LayoutInflater mInflater;

    private View mView;
    private TextView mTextTitle;
    private EditText mSearchView;
    private Button mRightButton;


    public SOToolbar(Context context) {
       this(context,null);
    }

    public SOToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SOToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();

        if(attrs != null){
            final TintTypedArray a =TintTypedArray.obtainStyledAttributes(getContext(),attrs,R.styleable.SOToolBar,defStyleAttr,0);


        }
    }

    private void initView() {
        mInflater = LayoutInflater.from(getContext());
        mView = mInflater.inflate(R.layout.toolbar,null);

        mTextTitle = (TextView) mView.findViewById(R.id.toolbar_title);
        mSearchView = (EditText) mView.findViewById(R.id.toolbar_searchview);
        mRightButton = (Button) mView.findViewById(R.id.toolbar_rightButton);

        //指定我们要的toolbar的长宽，对齐方式
        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
        addView(mView,lp);
    }

    @Override
    public void setTitle(@StringRes int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView();
        if(mTextTitle !=null) {
            mTextTitle.setText(title);
            showTitleView();
        }
    }

    public  void showSearchView(){

        if(mSearchView !=null)
            mSearchView.setVisibility(VISIBLE);

    }
    public void hideSearchView(){
        if(mSearchView !=null)
            mSearchView.setVisibility(GONE);
    }
    public void showTitleView(){
        if(mTextTitle !=null)
            mTextTitle.setVisibility(VISIBLE);
    }
    public void hideTitleView() {
        if (mTextTitle != null)
            mTextTitle.setVisibility(GONE);

    }
}
