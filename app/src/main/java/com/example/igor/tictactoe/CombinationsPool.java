package com.example.igor.tictactoe;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CombinationsPool {

    private HashMap<String, String> mCombinations;

    public CombinationsPool(Context context, String sign){
        mCombinations = new HashMap<String, String>();
        try {
            String[] subStr;
            InputStream inputStream;
            if(sign.equals("x")){
                inputStream = context.getResources().openRawResource(R.raw.combinations);
            }else{
                inputStream = context.getResources().openRawResource(R.raw.ocombinations);
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                subStr = line.split(",");
                getCombinations().put(subStr[0], subStr[1]);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getCombinations() {
        return mCombinations;
    }
}
