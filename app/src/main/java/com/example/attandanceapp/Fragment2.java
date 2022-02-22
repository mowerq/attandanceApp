package com.example.attandanceapp;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {



    TextView namesTextView, numbersTextView;
    String fileName = "people.txt";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2_layout, container, false);

        namesTextView = v.findViewById(R.id.textView);
        numbersTextView = v.findViewById(R.id.textView2);

        List<String> namesList = new ArrayList<>();
        List<Integer> numbersList = new ArrayList<>();

        String[] lines = readFile(getContext()).split("\n");
        for (int i = 0; i < lines.length; i++) {
            String[] numNames = lines[i].split(" ", 2);
            if (Integer.parseInt(numNames[0]) > 0){
                namesList.add(numNames[1]);
                numbersList.add(Integer.parseInt(numNames[0]));
            }
        }

        for (int i = 0; i < numbersList.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < numbersList.size(); j++){
                if (numbersList.get(j) > numbersList.get(index)){
                    index = j;
                }
            }
            int biggestNumber = numbersList.get(index);
            numbersList.set(index, numbersList.get(i));
            numbersList.set(i, biggestNumber);
            String bigName = namesList.get(index);
            namesList.set(index, namesList.get(i));
            namesList.set(i, bigName);
        }

        String namesString = "";

        String numbersString = "";
        for (int i = 0; i < numbersList.size(); i++) {
            numbersString = numbersString + numbersList.get(i).toString() + "\n";
            namesString = namesString + namesList.get(i) + "\n";
        }

        namesTextView.setText(namesString);
        numbersTextView.setText(numbersString);

        return v;
    }


    private String readFile(Context context) {
        String fileContents;
        try {
            FileInputStream fileInputStream;
            fileInputStream = context.openFileInput(fileName);


            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
            List<String> lines = new ArrayList<String>();

            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();

            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            fileContents = (TextUtils.join("\n", lines));
        } catch (Exception e) {
            e.printStackTrace();
            fileContents = "";

        }
        return fileContents;
    }



}
