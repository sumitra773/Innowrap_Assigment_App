package com.example.android.assigament_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class InnoWrap_Assigment_App extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ItemModel> mItemModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItemModels = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        CustomAdapter customAdapter = new CustomAdapter(InnoWrap_Assigment_App.this, mItemModels);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(customAdapter);

        try {
            JSONArray jsonArray = new JSONArray(JsonDataFromAsset());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject userData = jsonArray.getJSONObject(i);
                String header = userData.getString("header");
                String subHeader = userData.getString("sub-header");
                String img = userData.getString("img");
                String type = userData.getString("type");
                String action = userData.getString("action");
                String temp = userData.getString("temp");
                mItemModels.add(new ItemModel(header, subHeader, temp, img, type, action));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public String JsonDataFromAsset() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("assigment.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return json;
        }
        return json;
    }

}
