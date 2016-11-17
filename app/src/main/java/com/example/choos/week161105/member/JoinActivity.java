package com.example.choos.week161105.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.choos.week161105.MainActivity;
import com.example.choos.week161105.R;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener{

    EditText et_id,et_pw,et_name,et_email,et_phone,et_address;
    Button bt_submit,bt_cancel;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        service = new MemberServiceImpl(this.getApplicationContext());
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_address = (EditText) findViewById(R.id.et_address);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);
        bt_submit.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
                    case R.id.bt_submit:

                        MemberDTO param = new MemberDTO();
                        param.setId(et_id.getText().toString());
                        param.setPw(et_pw.getText().toString());
                        param.setName(et_name.getText().toString());
                        param.setEmail(et_email.getText().toString());
                        param.setPhone(et_phone.getText().toString());
                        param.setAddr(et_address.getText().toString());

                    case R.id.bt_cancel:

                        Intent intent = new Intent(this.getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;


                }

    }
}
