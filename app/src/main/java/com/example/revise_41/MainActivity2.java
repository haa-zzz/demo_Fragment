package com.example.revise_41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    public static void actionStart(Context context,String title,String content){
        Intent intent = new Intent(context,MainActivity2.class);
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");
        ContentFragment contentFragment = (ContentFragment)getSupportFragmentManager().findFragmentById(R.id.content_fragment);
        contentFragment.refresh(title,content);
    }
}