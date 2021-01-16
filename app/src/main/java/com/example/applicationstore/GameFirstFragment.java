package com.example.applicationstore;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class GameFirstFragment extends Fragment implements View.OnClickListener {
    private List<CardData> cardDataList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_first_fragment, container, false);

        initCardData();
        CardDataAdapter adapter = new CardDataAdapter(getActivity(), R.layout.choiceness, cardDataList);

        ImageButton onlineGame = view.findViewById(R.id.game_firstFragment_ImageButton_onlineGame);
        ImageButton standAlone = view.findViewById(R.id.game_firstFragment_ImageButton_standAlone);
        ImageButton smallGame = view.findViewById(R.id.game_firstFragment_ImageButton_smallGame);
        ImageButton indieGame = view.findViewById(R.id.game_firstFragment_ImageButton_indieGame);
        ImageButton latest = view.findViewById(R.id.game_firstFragment_ImageButton_latest);
        ListView listView = view.findViewById(R.id.list_item);

        onlineGame.setOnClickListener(this);
        standAlone.setOnClickListener(this);
        smallGame.setOnClickListener(this);
        indieGame.setOnClickListener(this);
        latest.setOnClickListener(this);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                CardData cardData = cardDataList.get(position);
                Toast.makeText(getActivity(), cardData.getMainTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.game_firstFragment_ImageButton_onlineGame:
                Intent onlineGame = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
                startActivity(onlineGame);
                break;
            case R.id.game_firstFragment_ImageButton_standAlone:
                Intent standAlone = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
                startActivity(standAlone);
                break;
            case R.id.game_firstFragment_ImageButton_smallGame:
                Intent smallGame = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
                startActivity(smallGame);
                break;
            case R.id.game_firstFragment_ImageButton_indieGame:
                Intent indieGame = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
                startActivity(indieGame);
                break;
            case R.id.game_firstFragment_ImageButton_latest:
                Intent latest = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
                startActivity(latest);
                break;
            default:
                break;
        }
    }

    public void initCardData() {
        for (int i = 0; i < 6; i++) {
            SoftCard softCard1 = new SoftCard();
            SoftCard softCard2 = new SoftCard();
            SoftCard softCard3 = new SoftCard();
            SoftCard softCard4 = new SoftCard();
            softCard1.setData(R.drawable.logo1, "酷跑精灵（布偶一败涂地）", "105万次安装");
            softCard2.setData(R.drawable.logo2, "迷你方块世界", "118万次安装");
            softCard3.setData(R.drawable.logo3, "火柴人越狱2", "823万次安装");
            softCard4.setData(R.drawable.logo4, "神射手", "189万次安装");
            CardData data1 = new CardData("你不能错过的单机游戏", "重温经典，不怕断网", softCard1, softCard2, softCard3, softCard4);
            cardDataList.add(data1);
        }

    }


}
