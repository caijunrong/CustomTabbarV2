package com.caijunrong.customview;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.caijunrong.customview.fragment.*;

public class MainActivity extends AppCompatActivity {

    private CustomXMLView customTabView;

    private List<Fragment> fragmentList;
    private List<CustomXMLView> tabList;
    private int index = 0;//再次点击的id
    private int currentTabIndex = -1; //当前显示的id
    private HomeTabAdapter homeTabAdapter;
    private NoScrollViewPager viewPager_main;



    private FragmentHome fragmentHome;
    private FragmentSearch fragmentSearch;
    private FragmentShareOrder fragmentShareOrder;
    private FragmentCart fragmentCart;
    private FragmentCenter fragmentCenter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //----1----
        tabList = new ArrayList<CustomXMLView>();
        tabList.add((CustomXMLView)findViewById(R.id.tab_btn_01));
        tabList.add((CustomXMLView)findViewById(R.id.tab_btn_02));
        tabList.add((CustomXMLView)findViewById(R.id.tab_btn_03));
        tabList.add((CustomXMLView)findViewById(R.id.tab_btn_04));
        tabList.add((CustomXMLView)findViewById(R.id.tab_btn_05));

        fragmentList = new ArrayList<Fragment>();
        fragmentHome = new FragmentHome();
        fragmentSearch = new FragmentSearch();
        fragmentShareOrder = new FragmentShareOrder();
        fragmentCart = new FragmentCart();
        fragmentCenter = new FragmentCenter();

        fragmentList.add(fragmentHome);
        fragmentList.add(fragmentSearch);
        fragmentList.add(fragmentShareOrder);
        fragmentList.add(fragmentCart);
        fragmentList.add(fragmentCenter);

        viewPager_main = (NoScrollViewPager)findViewById(R.id.viewpager_main_v2);


        //----2----
        homeTabAdapter = new HomeTabAdapter(getSupportFragmentManager(), fragmentList, viewPager_main);
        //最多5页
        viewPager_main.setOffscreenPageLimit(5);
        viewPager_main.setAdapter(homeTabAdapter);

        //更新第一个view的颜色为红色
        updataUI(0);

    }

    public void bottomTabClick(View view) {

        switch (view.getId()){

            case R.id.tab_btn_01:
                index = 0;
                break;
            case R.id.tab_btn_02:
                index = 1;
                break;
            case R.id.tab_btn_03:
                index = 2;
                break;
            case R.id.tab_btn_04:
                index = 3;
                break;
            case R.id.tab_btn_05:
                index = 4;
                break;

        }

        updataUI(index);
    }

    //更新UI
    private void updataUI(int index){

        if (currentTabIndex != index){

            CustomXMLView customXMLView = tabList.get(index);
            customXMLView.setSelectedState(true);

            if (currentTabIndex != -1){
                CustomXMLView customXMLViewOld = tabList.get(currentTabIndex);
                customXMLViewOld.setSelectedState(false);
            }


            currentTabIndex = index;


        }

        //点击事件之后，将fragment换到另一页
        homeTabAdapter.showFragmentWithID(index);

    }
}
