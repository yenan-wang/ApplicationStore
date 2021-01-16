package com.example.applicationstore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class ClassifyDataAdapter extends ArrayAdapter<ClassifyData> {
    private int resourceID;

    public ClassifyDataAdapter(Context context, int textViewResourceId, List<ClassifyData> objects) {
        super(context, textViewResourceId, objects);
        resourceID = textViewResourceId;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view;
        ViewHolderClassify viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
            viewHolder = new ViewHolderClassify();
            viewHolder.imageButton = view.findViewById(R.id.classify_imageButton);
            viewHolder.buttonOne = view.findViewById(R.id.game_secondFragment_button_one);
            viewHolder.buttonTwo = view.findViewById(R.id.game_secondFragment_button_two);
            viewHolder.buttonThree = view.findViewById(R.id.game_secondFragment_button_three);
            viewHolder.buttonFour = view.findViewById(R.id.game_secondFragment_button_four);
            viewHolder.buttonFive = view.findViewById(R.id.game_secondFragment_button_five);
            viewHolder.buttonSix = view.findViewById(R.id.game_secondFragment_button_six);

            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolderClassify) view.getTag();
        }
        viewHolder.buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), String.valueOf(getItemId(position)) + ": ButtonOne",Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),String.valueOf(getItemId(position))+ ": ButtonTwo",Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),String.valueOf(getItemId(position))+ ": ButtonThree",Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),String.valueOf(getItemId(position)) + ": ButtonFour",Toast.LENGTH_SHORT).show();
            }
        });viewHolder.buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),String.valueOf(getItemId(position)) + ": ButtonFive",Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),String.valueOf(getItemId(position)) + ": ButtonSix",Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),InstallPage.class);
                getContext().startActivity(intent);
            }
        });

        ClassifyData classifyData = getItem(position);
        //View view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);

        ImageButton imageButton = view.findViewById(R.id.classify_imageButton);
        Button buttonOne = view.findViewById(R.id.game_secondFragment_button_one);
        Button buttonTwo = view.findViewById(R.id.game_secondFragment_button_two);
        Button buttonThree = view.findViewById(R.id.game_secondFragment_button_three);
        Button buttonFour = view.findViewById(R.id.game_secondFragment_button_four);
        Button buttonFive = view.findViewById(R.id.game_secondFragment_button_five);
        Button buttonSix = view.findViewById(R.id.game_secondFragment_button_six);

        imageButton.setImageResource(classifyData.getImageID());

        buttonOne.setText(classifyData.getButtonOneText());
        buttonTwo.setText(classifyData.getButtonTwoText());
        buttonThree.setText(classifyData.getButtonThreeText());
        buttonFour.setText(classifyData.getButtonFourText());
        buttonFive.setText(classifyData.getButtonFiveText());
        buttonSix.setText(classifyData.getButtonSixText());

        buttonOne.setVisibility(classifyData.getButtonOneVisibility());
        buttonTwo.setVisibility(classifyData.getButtonTwoVisibility());
        buttonThree.setVisibility(classifyData.getButtonThreeVisibility());
        buttonFour.setVisibility(classifyData.getButtonFourVisibility());
        buttonFive.setVisibility(classifyData.getButtonFiveVisibility());
        buttonSix.setVisibility(classifyData.getButtonSixVisibility());

        return view;

    }
    class ViewHolderClassify{
        ImageButton imageButton;
        Button buttonOne;
        Button buttonTwo;
        Button buttonThree;
        Button buttonFour;
        Button buttonFive;
        Button buttonSix;
    }

}
