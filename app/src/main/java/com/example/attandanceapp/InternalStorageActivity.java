package com.example.attandanceapp;


import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class InternalStorageActivity extends AppCompatActivity {
    private String fileName, fileContents;

    public void setFileContents(String fileContents) {
        this.fileContents = fileContents;
    }

    public String getFileContents() {
        return fileContents;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internalstorage);

        fileName = "people.txt";

        findViewById(R.id.activity_internalstorage_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFile(getApplicationContext());
            }
        });

        findViewById(R.id.activity_internalstorage_write).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeFile(getApplicationContext());
            }
        });

        findViewById(R.id.activity_internalstorage_read).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFile(getApplicationContext());
            }
        });
    }

    private void createFile(Context context) {
        File file;
        file = new File(context.getFilesDir(), fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                Toast.makeText(context, String.format("File %s has been created", fileName), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(context, String.format("File %s creation failed", fileName), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, String.format("File %s already exists", fileName), Toast.LENGTH_SHORT).show();
        }
    }

    private void writeFile(Context context) {
        try {
            FileOutputStream fileOutputStream;
            fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);

            fileOutputStream.write(fileContents.getBytes(Charset.forName("UTF-8")));
            Toast.makeText(context, String.format("Write to %s successful", fileName), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, String.format("Write to file %s failed", fileName), Toast.LENGTH_SHORT).show();
        }
    }

    private void readFile(Context context) {
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
            Toast.makeText(context, String.format("Read from file %s successful", fileName), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, String.format("Read from file %s failed", fileName), Toast.LENGTH_SHORT).show();
            fileContents = "";

        }
    }
}