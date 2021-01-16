package com.example.applicationstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment implements View.OnClickListener{


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);

        //绑定组件
        ImageButton search = view.findViewById(R.id.my_search);
        ImageButton scan = view.findViewById(R.id.my_scan);
        ImageButton setting = view.findViewById(R.id.my_setting);

        ImageButton userPhoto = view.findViewById(R.id.user_photo);
        TextView userName = view.findViewById(R.id.user_name);
        Button  buttonMy = view.findViewById(R.id.button_my);

        ImageButton installHasGift = view.findViewById(R.id.my_imageButton_installHasGift);
        ImageButton winScore = view.findViewById(R.id.my_imageButton_winScore);
        ImageButton scoreStore = view.findViewById(R.id.my_imageButton_scoreStore);
        ImageButton latestActivity = view.findViewById(R.id.my_imageButton_latestActivity);

        RelativeLayout score = view.findViewById(R.id.my_score);
        RelativeLayout applicationUpdate = view.findViewById(R.id.my_applicationUpdate);
        RelativeLayout downloadManage = view.findViewById(R.id.my_downloadManage);
        RelativeLayout applicationUninstall = view.findViewById(R.id.my_applicationUninstall);
        RelativeLayout myAppointment = view.findViewById(R.id.my_myAppointment);
        RelativeLayout helpAndFeedback = view.findViewById(R.id.my_helpAndFeedback);

        //添加监听事件
        search.setOnClickListener(this);
        scan.setOnClickListener(this);
        setting.setOnClickListener(this);

        userPhoto.setOnClickListener(this);
        userName.setOnClickListener(this);
        buttonMy.setOnClickListener(this);
        installHasGift.setOnClickListener(this);
        winScore.setOnClickListener(this);
        scoreStore.setOnClickListener(this);
        latestActivity.setOnClickListener(this);

        score.setOnClickListener(this);
        applicationUpdate.setOnClickListener(this);
        downloadManage.setOnClickListener(this);
        applicationUninstall.setOnClickListener(this);
        myAppointment.setOnClickListener(this);
        helpAndFeedback.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.my_search:
                Intent searchIntent = new Intent(getContext(),SearchActivity.class);
                startActivity(searchIntent);
                break;
            case R.id.my_scan:
                Intent scanIntent = new Intent(getContext(),SearchActivity.class);
                startActivity(scanIntent);
                break;
            case R.id.my_setting:
                Intent settingIntent = new Intent(getContext(),SettingActivity.class);
                startActivity(settingIntent);
                break;

            case R.id.user_photo:
                Intent userPhotoIntent = new Intent(getContext(),SettingActivity.class);
                startActivity(userPhotoIntent);
                break;
            case R.id.user_name:
                Intent userNameIntent = new Intent(getContext(),SettingActivity.class);
                startActivity(userNameIntent);
                break;
            case R.id.button_my:
                Intent buttonMyIntent = new Intent(getContext(),SignActivity.class);
                startActivity(buttonMyIntent);
                break;

            case R.id.my_imageButton_installHasGift:
                Intent installHasGiftIntent = new Intent(getContext(),SearchActivity.class);
                startActivity(installHasGiftIntent);
                break;
            case R.id.my_imageButton_winScore:
                Intent winScoreIntent = new Intent(getContext(),SearchActivity.class);
                startActivity(winScoreIntent);
                break;
            case R.id.my_imageButton_scoreStore:
                Intent scoreStoreIntent = new Intent(getContext(),SearchActivity.class);
                startActivity(scoreStoreIntent);
                break;
            case R.id.my_imageButton_latestActivity:
                Intent latestActivityIntent = new Intent(getContext(),SearchActivity.class);
                startActivity(latestActivityIntent);
                break;

            case R.id.my_score:
                Intent scoreIntent = new Intent(getContext(),InstallPage.class);
                startActivity(scoreIntent);
                break;
            case R.id.my_applicationUpdate:
                Intent applicationUpdateIntent = new Intent(getContext(),InstallPage.class);
                startActivity(applicationUpdateIntent);
                break;
            case R.id.my_downloadManage:
                Intent downloadManageIntent = new Intent(getContext(),InstallPage.class);
                startActivity(downloadManageIntent);
                break;
            case R.id.my_applicationUninstall:
                Intent applicationUninstallIntent = new Intent(getContext(),InstallPage.class);
                startActivity(applicationUninstallIntent);
                break;
            case R.id.my_myAppointment:
                Intent myAppointmentIntent = new Intent(getContext(),InstallPage.class);
                startActivity(myAppointmentIntent);
                break;
            case R.id.my_helpAndFeedback:
                Intent helpAndFeedbackIntent = new Intent(getContext(),InstallPage.class);
                startActivity(helpAndFeedbackIntent);
                break;
            default:
                break;
        }

    }
}
