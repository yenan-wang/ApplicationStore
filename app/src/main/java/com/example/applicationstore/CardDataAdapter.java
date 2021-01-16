package com.example.applicationstore;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CardDataAdapter extends ArrayAdapter<CardData> implements View.OnClickListener {

    private int resourceID;
    private int id;

    public CardDataAdapter(Context context, int textViewResourceId, List<CardData> objects) {
        super(context, textViewResourceId, objects);
        resourceID = textViewResourceId;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        id = position;
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.buttonOne = view.findViewById(R.id.button_one);
            viewHolder.buttonTwo = view.findViewById(R.id.button_two);
            viewHolder.buttonThree = view.findViewById(R.id.button_three);
            viewHolder.buttonFour = view.findViewById(R.id.button_four);
            viewHolder.more = view.findViewById(R.id.imageButton_more);
            viewHolder.imageButtonOne = view.findViewById(R.id.imageButton_one);
            viewHolder.imageButtonTwo = view.findViewById(R.id.imageButton_two);
            viewHolder.imageButtonThree = view.findViewById(R.id.imageButton_three);
            viewHolder.imageButtonFour = view.findViewById(R.id.imageButton_four);

            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.buttonOne.setOnClickListener(this);
        viewHolder.buttonTwo.setOnClickListener(this);
        viewHolder.buttonThree.setOnClickListener(this);
        viewHolder.buttonFour.setOnClickListener(this);
        viewHolder.more.setOnClickListener(this);
        viewHolder.imageButtonOne.setOnClickListener(this);
        viewHolder.imageButtonTwo.setOnClickListener(this);
        viewHolder.imageButtonThree.setOnClickListener(this);
        viewHolder.imageButtonFour.setOnClickListener(this);


        /*viewHolder.buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "No." + position + " ButtonOne: 下载中", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "No." + position + " ButtonTwo：安装中", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "No." + position + " ButtonThree：恭喜你", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "No." + position + " ButtonFour：安装完成", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MoreActivity.class);
                getContext().startActivity(intent);
                //Toast.makeText(getContext(), "This is No." + position + " More", Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.imageButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),InstallPage.class);
                getContext().startActivity(intent);
                //Toast.makeText(getContext(), "This is No." + position + " imageButtonOne", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imageButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),InstallPage.class);
                getContext().startActivity(intent);
                //Toast.makeText(getContext(), "This is No." + position + " imageButtonTwo", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imageButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),InstallPage.class);
                getContext().startActivity(intent);
                //Toast.makeText(getContext(), "This is No." + position + " imageButtonThree", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imageButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),InstallPage.class);
                getContext().startActivity(intent);
                //Toast.makeText(getContext(), "This is No." + position + " imageButtonFour", Toast.LENGTH_SHORT).show();
            }
        });*/

        CardData cardData = getItem(position);
        Log.d("position", String.valueOf(cardData));

        //View view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);


        TextView cardMainName = view.findViewById(R.id.choiceness_text_main);
        TextView cardViceName = view.findViewById(R.id.choiceness_text_vice);

        ImageView softImageOne = view.findViewById(R.id.imageButton_one);
        ImageView softImageTwo = view.findViewById(R.id.imageButton_two);
        ImageView softImageThree = view.findViewById(R.id.imageButton_three);
        ImageView softImageFour = view.findViewById(R.id.imageButton_four);

        TextView softMainNameOne = view.findViewById(R.id.text_main_one);
        TextView softMainNameTwo = view.findViewById(R.id.text_main_two);
        TextView softMainNameThree = view.findViewById(R.id.text_main_three);
        TextView softMainNameFour = view.findViewById(R.id.text_main_four);
        TextView softViceNameOne = view.findViewById(R.id.text_vice_one);
        TextView softViceNameTwo = view.findViewById(R.id.text_vice_two);
        TextView softViceNameThree = view.findViewById(R.id.text_vice_three);
        TextView softViceNameFour = view.findViewById(R.id.text_vice_four);

        cardMainName.setText(cardData.getMainTitle());
        cardViceName.setText(cardData.getViceTitle());

        softImageOne.setImageResource(cardData.getSoftCardImageOne());
        softImageTwo.setImageResource(cardData.getSoftCardImageTwo());
        softImageThree.setImageResource(cardData.getSoftCardImageThree());
        softImageFour.setImageResource(cardData.getSoftCardImageFour());

        softMainNameOne.setText(cardData.getSoftCardNameOne());
        softMainNameTwo.setText(cardData.getSoftCardNameTwo());
        softMainNameThree.setText(cardData.getSoftCardNameThree());
        softMainNameFour.setText(cardData.getSoftCardNameFour());

        softViceNameOne.setText(cardData.getSoftCardInstallDataOne());
        softViceNameTwo.setText(cardData.getSoftCardInstallDataTwo());
        softViceNameThree.setText(cardData.getSoftCardInstallDataThree());
        softViceNameFour.setText(cardData.getSoftCardInstallDataFour());

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_one:
                Toast.makeText(getContext(), "No." + id + " ButtonOne: 下载中", Toast.LENGTH_SHORT).show();
                if(id == 0){
                    Intent buttonOne = new Intent(getContext(), SettingActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 1){
                    Intent buttonOne = new Intent(getContext(), MoreActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 2){
                    Intent buttonOne = new Intent(getContext(), SignActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 3){
                    Intent buttonOne = new Intent(getContext(), SearchActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 4){
                    Intent buttonOne = new Intent(getContext(), MainActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 5){
                    Intent buttonOne = new Intent(getContext(), SettingActivity.class);
                    getContext().startActivity(buttonOne);
                }
                break;
            case R.id.button_two:
                Toast.makeText(getContext(), "No." + id + " ButtonTwo：安装中", Toast.LENGTH_SHORT).show();
                if(id == 0){
                    Intent buttonOne = new Intent(getContext(), MoreActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 1){
                    Intent buttonOne = new Intent(getContext(), SignActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 2){
                    Intent buttonOne = new Intent(getContext(), SearchActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 3){
                    Intent buttonOne = new Intent(getContext(), MainActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 4){
                    Intent buttonOne = new Intent(getContext(), SettingActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 5){
                    Intent buttonOne = new Intent(getContext(), SettingActivity.class);
                    getContext().startActivity(buttonOne);
                }
                break;
            case R.id.button_three:
                Toast.makeText(getContext(), "No." + id + " ButtonThree：恭喜你", Toast.LENGTH_SHORT).show();
                if(id == 0){
                    Intent buttonOne = new Intent(getContext(), SignActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 1){
                    Intent buttonOne = new Intent(getContext(), SearchActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 2){
                    Intent buttonOne = new Intent(getContext(), MainActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 3){
                    Intent buttonOne = new Intent(getContext(), MoreActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 4){
                    Intent buttonOne = new Intent(getContext(), SettingActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 5){
                    Intent buttonOne = new Intent(getContext(), MoreActivity.class);
                    getContext().startActivity(buttonOne);
                }
                break;
            case R.id.button_four:
                Toast.makeText(getContext(), "No." + id + " ButtonFour：安装完成", Toast.LENGTH_SHORT).show();
                if(id == 0){
                    Intent buttonOne = new Intent(getContext(), SearchActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 1){
                    Intent buttonOne = new Intent(getContext(), MainActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 2){
                    Intent buttonOne = new Intent(getContext(), SignActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 3){
                    Intent buttonOne = new Intent(getContext(), SettingActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 4){
                    Intent buttonOne = new Intent(getContext(), MoreActivity.class);
                    getContext().startActivity(buttonOne);
                }
                if(id == 5){
                    Intent buttonOne = new Intent(getContext(), SettingActivity.class);
                    getContext().startActivity(buttonOne);
                }
                break;
            case R.id.imageButton_more:
                Intent more = new Intent(getContext(),MoreActivity.class);
                getContext().startActivity(more);
                break;
            case R.id.imageButton_one:
                Intent imageButtonOne = new Intent(getContext(),InstallPage.class);
                getContext().startActivity(imageButtonOne);
                break;
            case R.id.imageButton_two:
                Intent imageButtonTwo = new Intent(getContext(),InstallPage.class);
                getContext().startActivity(imageButtonTwo);
                break;
            case R.id.imageButton_three:
                Intent imageButtonThree = new Intent(getContext(),InstallPage.class);
                getContext().startActivity(imageButtonThree);
                break;
            case R.id.imageButton_four:
                Intent imageButtonFour = new Intent(getContext(),InstallPage.class);
                getContext().startActivity(imageButtonFour);
                break;
        }
    }

    /*@Override
    public void onClick(View view) {
        switch (view.getId()){
            case
        }
    }*/

    class ViewHolder {
        Button buttonOne;
        Button buttonTwo;
        Button buttonThree;
        Button buttonFour;
        ImageButton more;
        ImageButton imageButtonOne;
        ImageButton imageButtonTwo;
        ImageButton imageButtonThree;
        ImageButton imageButtonFour;


    }
}
