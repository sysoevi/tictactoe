package com.example.igor.tictactoe.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.igor.tictactoe.GameField;
import com.example.igor.tictactoe.R;
import com.example.igor.tictactoe.activity.GameFieldActivity;

public class SettingsFragment extends Fragment {
    private EditText mTextSpace;
    private CheckBox mCrossCheckBox;
    private CheckBox mNullCheckBox;
    private Button mButtonNext;
    private String mSign;
    private String mName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings_layout, container, false);

        mTextSpace = v.findViewById(R.id.text_name);
        mCrossCheckBox = v.findViewById(R.id.checkBox_crosses);
        mNullCheckBox = v.findViewById(R.id.checkbox_nulls);
        mButtonNext = v.findViewById(R.id.next_button);

        mCrossCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    mNullCheckBox.setChecked(!b);
                }
            }
        });

        mNullCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    mCrossCheckBox.setChecked(!b);
                }
            }
        });

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mTextSpace.getText().toString().equals("") | mTextSpace.getText().toString()
                        .equals(" ")){
                    Toast.makeText(getActivity(), R.string.name_error, Toast.LENGTH_SHORT).show();
                }else if(!mCrossCheckBox.isChecked() & !mNullCheckBox.isChecked()){
                    Toast.makeText(getActivity(), R.string.check_box_error, Toast.LENGTH_SHORT).show();
                }else{
                    mName = mTextSpace.getText().toString();
                    if(mCrossCheckBox.isChecked()){
                        mSign = "x";
                    }
                    if(mNullCheckBox.isChecked()){
                        mSign = "o";
                    }
                    Intent intent = GameFieldActivity.newIntent(getActivity(), mName, mSign);
                    startActivity(intent);
                }
            }
        });

        return v;
    }
}
