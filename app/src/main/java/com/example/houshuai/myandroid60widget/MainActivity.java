package com.example.houshuai.myandroid60widget;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.houshuai.Fragment.FirstNewsPager;
import com.example.houshuai.Fragment.FourNewsPager;
import com.example.houshuai.Fragment.SecondNewsPager;
import com.example.houshuai.Fragment.ThreeNewsPager;
import com.example.houshuai.Inter.MainToFirstNP;
import com.example.houshuai.SnakbarUtils.Sanckbars;

import java.util.LinkedList;
//主界面   新闻传递到FirstNewsPager    以此类推
public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawuLayout;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPger;
    private AppBarLayout appBarLayout;
    private NavigationView mNavigation;
    private String[] bottomTitle;
    private LinkedList<Fragment> fragments;
    private MainToFirstNP firstInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化各个控件
        initView();
        //设置控件的各个功能
        initFunciton();

    }

    private void initFunciton() {
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.night_share_qzone_icon);
        toolbar.setTitle("新特性");
        toolbar.setSubtitle("这是一个6.0新特性控件显示");
        //设置DrawerLayout开关指示器,即Toolbar最左边的ICon
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawuLayout, toolbar, R.string.open, R.string.close);
        actionBarDrawerToggle.syncState();
        drawuLayout.addDrawerListener(actionBarDrawerToggle);
        //设置NavigationView中menu的item被选中时候执行的操作
        onNavagationViewMenuItemSelect(mNavigation);
        //向tabLayout和ViewPager中增加数据
        addDatas();
        //初始化ViewPager最大的缓存数
        viewPger.setOffscreenPageLimit(5);
        viewPger.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                // TODO: 2016/6/18
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return bottomTitle[position];
            }
        });
        //设置viewpager的监听事件
        onViewPagerListener(viewPger);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPger);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                firstInterface.sendCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void addDatas() {
        //准备TabLayout的数据
        bottomTitle = getResources().getStringArray(R.array.Bottom_title);
        //准备ViewPager的数据
        fragments = new LinkedList<>();
        for (String titleName :
                bottomTitle) {
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setText(titleName);
            tab.setIcon(R.mipmap.night_share_qzone_icon);
            tabLayout.addTab(tab);

        }
        fragments.add(new FirstNewsPager());
        fragments.add(new SecondNewsPager());
        fragments.add(new ThreeNewsPager());
        fragments.add(new FourNewsPager());
    }

    private void onViewPagerListener(ViewPager viewPger) {
        viewPger.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                firstInterface.sendCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
    }

    private void onNavagationViewMenuItemSelect(NavigationView mNavigation) {
        mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            String msgString = null;
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // TODO: 2016/6/18
                switch (item.getItemId()) {
                    case R.id.menu_01:
                         msgString = (String) item.getTitle();
                        break;
                    case R.id.menu_02:
                        msgString = (String) item.getTitle();
                        break;
                    case R.id.menu_03:
                        msgString = (String) item.getTitle();
                        break;
                    case R.id.menu_04:
                        msgString = (String) item.getTitle();
                        break;
                    case R.id.menu_05:
                        msgString = (String) item.getTitle();
                        break;
                    default:
                        break;
                }
                //Menu item点击后选中  ,并关闭DrawLayout
                item.setChecked(true);
                drawuLayout.closeDrawers();
                //设置提示华语
                Sanckbars.show(viewPger,msgString,0);
                return false;
            }
        });

    }


    private void initView() {
        drawuLayout = (DrawerLayout) findViewById(R.id.drawer);
        toolbar = (Toolbar) findViewById(R.id.tb_Toolbar);
        tabLayout = (TabLayout) findViewById(R.id.fth_showContent);
        viewPger = (ViewPager) findViewById(R.id.vp_pagerView);
        appBarLayout = (AppBarLayout) findViewById(R.id.abl_collpase);
        mNavigation = (NavigationView) findViewById(R.id.ngv_slide);
        firstInterface=  (MainToFirstNP) this;
    }
}
