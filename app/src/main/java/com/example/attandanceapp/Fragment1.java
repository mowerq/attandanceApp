package com.example.attandanceapp;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment implements View.OnClickListener {

    ChipGroup chipGroup;
    Chip ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10, ch11, ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch20, ch21, ch22, ch23, ch24, ch25, ch26, ch27, ch28, ch29, ch30, ch31, ch32, ch33;
    ImageButton saveButton;
    private String fileName;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_1_layout, container, false);
        fileName = "people.txt";

        createFile(getContext());

        ch1 = v.findViewById(R.id.chip1);
        ch2 = v.findViewById(R.id.chip2);
        ch3 = v.findViewById(R.id.chip3);
        ch4 = v.findViewById(R.id.chip4);
        ch5 = v.findViewById(R.id.chip5);
        ch6 = v.findViewById(R.id.chip6);
        ch7 = v.findViewById(R.id.chip7);
        ch8 = v.findViewById(R.id.chip8);
        ch9 = v.findViewById(R.id.chip9);
        ch10 = v.findViewById(R.id.chip10);
        ch11 = v.findViewById(R.id.chip11);
        ch12 = v.findViewById(R.id.chip12);
        ch13 = v.findViewById(R.id.chip13);
        ch14 = v.findViewById(R.id.chip14);
        ch15 = v.findViewById(R.id.chip15);
        ch16 = v.findViewById(R.id.chip16);
        ch17 = v.findViewById(R.id.chip17);
        ch18 = v.findViewById(R.id.chip18);
        ch19 = v.findViewById(R.id.chip19);
        ch20 = v.findViewById(R.id.chip20);
        ch21 = v.findViewById(R.id.chip21);
        ch22 = v.findViewById(R.id.chip22);
        ch23 = v.findViewById(R.id.chip23);
        ch24 = v.findViewById(R.id.chip24);
        ch25 = v.findViewById(R.id.chip25);
        ch26 = v.findViewById(R.id.chip26);
        ch27 = v.findViewById(R.id.chip27);
        ch28 = v.findViewById(R.id.chip28);
        ch29 = v.findViewById(R.id.chip29);
        ch30 = v.findViewById(R.id.chip30);
        ch31 = v.findViewById(R.id.chip31);
        ch32 = v.findViewById(R.id.chip32);
        ch33 = v.findViewById(R.id.chip33);
        saveButton = v.findViewById(R.id.imageButton7);
        chipGroup = v.findViewById(R.id.chipGroupID);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> names = new ArrayList<String>();
                if (ch1.isChecked()) names.add("Arif Taşçıoğlu");
                if (ch2.isChecked()) names.add("Asena Koşmaz");
                if (ch3.isChecked()) names.add("Aslı Nurhan Seçir");
                if (ch4.isChecked()) names.add("Begüm Ukulele Şan");
                if (ch5.isChecked()) names.add("Berna Kavradım");
                if (ch6.isChecked()) names.add("Buse Pala");
                if (ch7.isChecked()) names.add("Buğra Arslanca");
                if (ch8.isChecked()) names.add("Büşra Aykutoğlu");
                if (ch9.isChecked()) names.add("Büşra Nimet Bolat");
                if (ch10.isChecked()) names.add("Cemil Hoca Ukulele");
                if (ch11.isChecked()) names.add("Cemile Sancaktar");
                if (ch12.isChecked()) names.add("Çiğdem Yönetim");
                if (ch13.isChecked()) names.add("Dilan Yapıcı");
                if (ch14.isChecked()) names.add("Eda Nur Aygören");
                if (ch15.isChecked()) names.add("Esra Keleş");
                if (ch16.isChecked()) names.add("Eyyüp Atay");
                if (ch17.isChecked()) names.add("Feyza Altınbaş");
                if (ch18.isChecked()) names.add("Feyza Ukulele Şan");
                if (ch19.isChecked()) names.add("Hüsna Şeyma Bozdağ");
                if (ch20.isChecked()) names.add("Kader Gitar Şan");
                if (ch21.isChecked()) names.add("Kübra Cangir");
                if (ch22.isChecked()) names.add("Meryem Gezer");
                if (ch23.isChecked()) names.add("Müge Yarımca");
                if (ch24.isChecked()) names.add("Orhan Vuran");
                if (ch25.isChecked()) names.add("Ömer Bozkuş");
                if (ch26.isChecked()) names.add("Rümeysa Nur Duran");
                if (ch27.isChecked()) names.add("Sabri Taş");
                if (ch28.isChecked()) names.add("Şeyma Ukulele Şan");
                if (ch29.isChecked()) names.add("Tülay Tosun");
                if (ch30.isChecked()) names.add("Yağmur Uslu");
                if (ch31.isChecked()) names.add("Yunus Şahin");
                if (ch32.isChecked()) names.add("Zeynep Ukulele Şan");
                if (ch33.isChecked()) names.add("Zülal Uslu");

                String afterSave = "";
                String beforeSave = readFile(getContext());
                String[] lines = beforeSave.split("\n");
                String namesFile;
                Integer numbersFile;
                boolean isThereSelected = false;

                for (int i = 0; i < lines.length; i++) {
                    String[] numName = lines[i].split(" ",2);

                    numbersFile = Integer.parseInt(numName[0]);
                    namesFile = numName[1];
                    for (int j = 0; j < names.size(); j++) {
                        if (namesFile.equals(names.get(j))){
                            numbersFile = numbersFile + 1;
                            isThereSelected = true;
                        }
                    }
                    afterSave = afterSave + numbersFile + " " + namesFile + "\n";
                }
                if(isThereSelected){
                    writeFile(getContext(), afterSave);
                    Toast.makeText(getContext(), "Uygulamamamı kullandığın için tşk :D Başarıyla kaydettim.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(), "Henüz kimseyi seçmedin xd", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return v;
    }


    private void createFile(Context context) {
        File file;
        file = new File(context.getFilesDir(), fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                String emptyPeople = "0 Arif Taşçıoğlu\n" +
                        "0 Asena Koşmaz\n" +
                        "0 Aslı Nurhan Seçir\n" +
                        "0 Begüm Ukulele Şan\n" +
                        "0 Berna Kavradım\n" +
                        "0 Buse Pala\n" +
                        "0 Buğra Arslanca\n" +
                        "0 Büşra Aykutoğlu\n" +
                        "0 Büşra Nimet Bolat\n" +
                        "0 Cemil Hoca Ukulele\n" +
                        "0 Cemile Sancaktar\n" +
                        "0 Çiğdem Yönetim\n" +
                        "0 Dilan Yapıcı\n" +
                        "0 Eda Nur Aygören\n" +
                        "0 Esra Keleş\n" +
                        "0 Eyyüp Atay\n" +
                        "0 Feyza Altınbaş\n" +
                        "0 Feyza Ukulele Şan\n" +
                        "0 Hüsna Şeyma Bozdağ\n" +
                        "0 Kader Gitar Şan\n" +
                        "0 Kübra Cangir\n" +
                        "0 Meryem Gezer\n" +
                        "0 Müge Yarımca\n" +
                        "0 Orhan Vuran\n" +
                        "0 Ömer Bozkuş\n" +
                        "0 Rümeysa Nur Duran\n" +
                        "0 Sabri Taş\n" +
                        "0 Şeyma Ukulele Şan\n" +
                        "0 Tülay Tosun\n" +
                        "0 Yağmur Uslu\n" +
                        "0 Yunus Şahin\n" +
                        "0 Zeynep Ukulele Şan\n" +
                        "0 Zülal Uslu";
                writeFile(context, emptyPeople);
            } catch (IOException e) {
            }
        } else {
        }
    }

    private void writeFile(Context context, String fileContents) {
        try {
            FileOutputStream fileOutputStream;
            fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);


            fileOutputStream.write(fileContents.getBytes(Charset.forName("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @Override
    public void onClick(View v) {
    }
}
