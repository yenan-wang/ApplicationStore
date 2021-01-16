package com.example.applicationstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    private RelativeLayout relativeLayoutOne,relativeLayoutFive,relativeLayoutSix,relativeLayoutSeven,relativeLayoutEight;
    private Switch swichButtonTwo,swichButtonThree,swichButtonFour;
    private TextView textViewOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //添加标题栏返回键
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        relativeLayoutOne = findViewById(R.id.setting_one);
        swichButtonTwo = findViewById(R.id.setting_two_switch);
        swichButtonThree = findViewById(R.id.setting_three_switch);
        swichButtonFour = findViewById(R.id.setting_four_switch);
        relativeLayoutFive = findViewById(R.id.setting_five);
        relativeLayoutSix = findViewById(R.id.setting_six);
        relativeLayoutSeven = findViewById(R.id.setting_seven);
        relativeLayoutEight = findViewById(R.id.setting_eight);

        textViewOne = findViewById(R.id.setting_one_text);

        relativeLayoutOne.setOnClickListener(this);
        swichButtonTwo.setOnClickListener(this);
        swichButtonThree.setOnClickListener(this);
        swichButtonFour.setOnClickListener(this);
        relativeLayoutFive.setOnClickListener(this);
        relativeLayoutSix.setOnClickListener(this);
        relativeLayoutSeven.setOnClickListener(this);
        relativeLayoutEight.setOnClickListener(this);

    }

    //标题栏返回按钮事件响应
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.setting_one:
                alterDialog();
                break;
            case R.id.setting_two_switch:
                if(swichButtonTwo.isChecked()){
                    Toast.makeText(this,"WLAN自动更新已打开。",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"WLAN自动更新已关闭。",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.setting_three_switch:
                if(swichButtonThree.isChecked()){
                    Toast.makeText(this,"自动清除已打开。",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"自动清除已关闭。",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.setting_four_switch:
                if(swichButtonFour.isChecked()){
                    Toast.makeText(this,"消息提醒已打开。",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"消息提醒已关闭。",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.setting_five:
                Toast.makeText(this,"您的软件为最新版本，不需要更新。",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_six:
                Intent agreementIntent = new Intent(this,TextActivity.class);
                startActivity(agreementIntent);
                break;
            case R.id.setting_seven:
                Intent privacyIntent = new Intent(this,TextActivity.class);
                startActivity(privacyIntent);
                break;
            case R.id.setting_eight:
                Toast.makeText(this,"缓存已清理。",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

    public void alterDialog(){
        final String [] items = {"不提醒","100M","80M","60M","40M","20M","每次都提醒"} ;
        final String[] s = new String[1];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("移动网络下载流量提醒额度");
        builder.setSingleChoiceItems(items, 6, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                s[0] = items[i];
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textViewOne.setText(s[0]);
            }
        });
        builder.setNegativeButton("取消", null);
        builder.show();
    }
}
