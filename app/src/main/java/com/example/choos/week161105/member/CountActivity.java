package com.example.choos.week161105.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.choos.week161105.R;

public class CountActivity extends AppCompatActivity {
    MemberService service;
    //필드는 속성을 정의할 뿐 동작을 실행하지 않는다.
    //OOP는 속성과 기능의 정의를 분할한다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        service = new MemberServiceImpl(this.getApplicationContext());


    }
}
