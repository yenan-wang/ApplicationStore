package com.example.applicationstore;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener , ViewPager.OnPageChangeListener {
    private ImageButton search_image, search_scan;
    private TextView search_text;
    private ListView homeList;
    private ScrollView scrollView;
    private ImageButton homeImageButtonOne, homeImageButtonTwo, homeImageButtonThree, homeImageButtonFour, homeImageButtonFive;
    private Button homeButtonWelfare, homeBUttonBest;

    private List<CardData> homeDataList = new ArrayList<>();

    private ViewPager bannerViewPager;        //轮播图Viewpager
    private List<ImageView> imageViewList;    //轮播图图片
    private LinearLayout bannerPointLayout;   //轮播图圆点
    private TextView bannerTittle;            //轮播图标题
    private int previousSelectedPosition = 0;//上次高亮显示的位置
    private boolean isStop = false;           //控制循环的子线程是否停止

    /* private ArrayList<ImageView> imageViews;


     */
    private final int[] imageIds = {
            R.drawable.banner_image_one,
            R.drawable.banner_image_two,
            R.drawable.banner_image_three,
            R.drawable.banner_image_four
    };
    private final String[] textBannerTitleStrings = {
            "海边椰树",
            "阳光",
            "连绵起伏的群山",
            "边陲小镇"
    };

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            bannerViewPager.setCurrentItem(bannerViewPager.getCurrentItem() + 1);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        initViewPager(view);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //每两秒向主线程发送一条消息，切换ViewPager的页面
                while (!isStop) {
                    SystemClock.sleep(4000);
                    handler.sendEmptyMessage(0);
                }
            }
        }).start();

        initHomeData();
        CardDataAdapter homeAdapter = new CardDataAdapter(getActivity(), R.layout.choiceness, homeDataList);
        search_text = view.findViewById(R.id.search_text);
        search_image = view.findViewById(R.id.search_image);
        search_scan = view.findViewById(R.id.search_scan);
        homeButtonWelfare = view.findViewById(R.id.welfare_service);
        homeBUttonBest = view.findViewById(R.id.best_honor);
        homeImageButtonOne = view.findViewById(R.id.home_imageButton_necessary);
        homeImageButtonTwo = view.findViewById(R.id.home_imageButton_must_play);
        homeImageButtonThree = view.findViewById(R.id.home_imageButton_hot_video);
        homeImageButtonFour = view.findViewById(R.id.home_imageButton_classify);
        homeImageButtonFive = view.findViewById(R.id.home_imageButton_game_center);
        homeList = view.findViewById(R.id.home_list);
        homeList.setAdapter(homeAdapter);
        setListViewHeightBasedOnChildren(homeList);
        scrollView = view.findViewById(R.id.scrollView);

        search_text.setOnClickListener(this);
        search_image.setOnClickListener(this);
        search_scan.setOnClickListener(this);
        homeButtonWelfare.setOnClickListener(this);
        homeBUttonBest.setOnClickListener(this);
        homeImageButtonOne.setOnClickListener(this);
        homeImageButtonTwo.setOnClickListener(this);
        homeImageButtonThree.setOnClickListener(this);
        homeImageButtonFour.setOnClickListener(this);
        homeImageButtonFive.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.welfare_service:
                Intent welfareServiceIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(welfareServiceIntent);
                break;
            case R.id.best_honor:
                Intent bestHonorIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(bestHonorIntent);
                break;
            case R.id.home_imageButton_necessary:
                Intent necessaryIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(necessaryIntent);
                break;
            case R.id.home_imageButton_must_play:
                Intent mustPlayIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(mustPlayIntent);
                break;
            case R.id.home_imageButton_hot_video:
                Intent hotVideoIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(hotVideoIntent);
                break;
            case R.id.home_imageButton_classify:
                Intent classifyIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(classifyIntent);
                break;
            case R.id.home_imageButton_game_center:
                Intent gameCenterIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(gameCenterIntent);
                break;
            case R.id.search_image:
                Intent searchImageIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(searchImageIntent);
                break;
            case R.id.search_text:
                Intent searchTextIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(searchTextIntent);
                break;
            case R.id.search_scan:
                Intent searchScanIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(searchScanIntent);
                break;
            default:
                break;
        }
    }

    public void initHomeData() {
        for (int i = 0; i < 12; i++) {
            SoftCard softCard1 = new SoftCard();
            SoftCard softCard2 = new SoftCard();
            SoftCard softCard3 = new SoftCard();
            SoftCard softCard4 = new SoftCard();
            softCard1.setData(R.drawable.logo1, "酷跑精灵（布偶一败涂地）", "105万次安装");
            softCard2.setData(R.drawable.logo2, "迷你方块世界", "118万次安装");
            softCard3.setData(R.drawable.logo3, "火柴人越狱2", "823万次安装");
            softCard4.setData(R.drawable.logo4, "神射手", "189万次安装");
            CardData data2 = new CardData("你不能错过的单机游戏", "重温经典，不怕断网", softCard1, softCard2, softCard3, softCard4);
            homeDataList.add(data2);
        }
    }


    @Override
    public void onDestroy() {
        isStop = true;
        super.onDestroy();
    }

    /**
     * private ViewPager bannerViewPager;        //轮播图Viewpager
     * private List<ImageView> imageViewList;    //轮播图图片
     * private LinearLayout bannerPointLayout;   //轮播图圆点
     * private TextView bannerTittle;            //轮播图标题
     * private  int previousSelectedPosition = 0;//上次高亮显示的位置
     */
    public void initViewPager(View view) {

        bannerViewPager = view.findViewById(R.id.bannerViewPager);
        bannerPointLayout = view.findViewById(R.id.bannerPointLayout);
        bannerTittle = view.findViewById(R.id.bannerTitle);
        imageViewList = new ArrayList<ImageView>();

        ImageView imageView;
        View pointView;
        LinearLayout.LayoutParams params;

        for (int i = 0; i < imageIds.length; i++) {
            imageView = new ImageView(getContext());
            imageView.setBackgroundResource(imageIds[i]);
            imageViewList.add(imageView);

            //根据图片添加点
            pointView = new View(getContext());
            params  = new LinearLayout.LayoutParams(5,5);
            params.leftMargin = 5;
            pointView.setLayoutParams(params);
            pointView.setEnabled(false);
            pointView.setBackgroundResource(R.drawable.point_selector);
            bannerPointLayout.addView(pointView);
        }

        HomePagerAdapter homePagerAdapter = new HomePagerAdapter();
        bannerViewPager.setAdapter(homePagerAdapter);
        bannerViewPager.setOnPageChangeListener(this);

        int item = (Integer.MAX_VALUE / 2) - ((Integer.MAX_VALUE / 2) % imageViewList.size());
        bannerViewPager.setCurrentItem(item);
        bannerTittle.setText(textBannerTitleStrings[previousSelectedPosition]);
        bannerPointLayout.getChildAt(previousSelectedPosition).setEnabled(true);
    }

    class HomePagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
            //return 0;
        }

        /**
         * 移动的对象和进来的对象如果是同一个就返回true, 代表复用view对象
         * false 使用object对象
         */
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        //需要销毁的对象的position传进来
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            //super.destroyItem(container, position, object);
            bannerViewPager.removeView(imageViewList.get(position % imageViewList.size()));
        }

        //加载position位置的view对象
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            bannerViewPager.addView(imageViewList.get(position % imageViewList.size()));
            return imageViewList.get(position % imageViewList.size());
            //return super.instantiateItem(container, position);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bannerTittle.setText(textBannerTitleStrings[position % imageViewList.size()]);
        bannerPointLayout.getChildAt(position % imageViewList.size()).setEnabled(true);
        bannerPointLayout.getChildAt(previousSelectedPosition).setEnabled(false);
        previousSelectedPosition = position % imageViewList.size();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



    //解决ScrollView中嵌套ListView时，list显示不全的问题
    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

}

