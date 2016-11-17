package com.example.choos.week161105.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.choos.week161105.R;

public class UpdateActivity extends AppCompatActivity {
    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        service = new MemberServiceImpl(this.getApplicationContext());
    }
}
