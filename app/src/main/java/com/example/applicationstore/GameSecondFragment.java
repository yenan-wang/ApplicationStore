package com.example.applicationstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class GameSecondFragment extends Fragment {
    private List<ClassifyData> classifyDataList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_second_fragment, container, false);

        initClassifyData();
        ClassifyDataAdapter adapter = new ClassifyDataAdapter(getActivity(), R.layout.classify, classifyDataList);
        ListView listView = view.findViewById(R.id.classify_listView);
        listView.setAdapter(adapter);
        return view;
    }

    public void initClassifyData() {
        for (int i = 0; i < 6; i++) {
            ClassifyData classifyData1 = new ClassifyData(
                    R.mipmap.ic_launcher,
                    "消除", View.VISIBLE,
                    "捕鱼", View.VISIBLE,
                    "休闲竞技", View.VISIBLE,
                    "益智", View.VISIBLE,
                    "解谜", View.VISIBLE,
                    "快速反应", View.VISIBLE);
            classifyDataList.add(classifyData1);

            ClassifyData classifyData2 = new ClassifyData(
                    R.mipmap.ic_launcher,
                    "斗地主", View.VISIBLE,
                    "麻将", View.VISIBLE,
                    "纸牌", View.VISIBLE,
                    "棋类", View.VISIBLE,
                    "桌游", View.VISIBLE,
                    null, View.INVISIBLE);
            classifyDataList.add(classifyData2);

            ClassifyData classifyData3 = new ClassifyData(
                    R.mipmap.ic_launcher,
                    "横版格斗", View.VISIBLE,
                    "跑酷", View.VISIBLE,
                    "冒险", View.VISIBLE,
                    "闯关", View.VISIBLE,
                    null, View.GONE,
                    null, View.INVISIBLE);
            classifyDataList.add(classifyData3);

            ClassifyData classifyData4 = new ClassifyData(
                    R.mipmap.ic_launcher,
                    "音乐节奏", View.VISIBLE,
                    "舞蹈", View.VISIBLE,
                    null, View.GONE,
                    null, View.GONE,
                    null, View.GONE,
                    null, View.GONE);
            classifyDataList.add(classifyData4);
        }
    }
}
