package com.example.choos.week161105.calc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.choos.week161105.MainActivity;
import com.example.choos.week161105.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class CalcActivity extends AppCompatActivity implements OnClickListener {

    EditText et_first, et_second;
    Button bt_plus, bt_minus, bt_multi, bt_divid, bt_mod, bt_back;
    TextView tv_result;
    int result;
    CalcService service;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        service = new CalcServiceImpl();

        et_first = (EditText)findViewById(R.id.et_first);
        et_second = (EditText)findViewById(R.id.et_second);
        bt_plus = (Button)findViewById(R.id.bt_plus);
        bt_minus = (Button)findViewById(R.id.bt_minus);
        bt_multi = (Button)findViewById(R.id.bt_multi);
        bt_divid = (Button)findViewById(R.id.bt_divid);
        bt_mod = (Button)findViewById(R.id.bt_mod);
        //bt_equal = (Button)findViewById(R.id.bt_equal);
        tv_result = (TextView)findViewById(R.id.tv_result);
        bt_back = (Button)findViewById(R.id.bt_back);

        bt_plus.setOnClickListener((OnClickListener) this);
        bt_minus.setOnClickListener((OnClickListener) this);
        bt_multi.setOnClickListener((OnClickListener) this);
        bt_divid.setOnClickListener((OnClickListener) this);
        bt_mod.setOnClickListener((OnClickListener) this);
        //bt_equal.setOnClickListener((OnClickListener) this);
        bt_back.setOnClickListener((OnClickListener) this);
        result = 0;



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        int first = Integer.parseInt(et_first.getText().toString());
        int second = Integer.parseInt(et_second.getText().toString());
        CalcDTO dto = new CalcDTO();
        dto.setFirst(first);
        dto.setSecond(second);

        switch (v.getId()) {

            case R.id.bt_back :
                Intent intent = new Intent(this.getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;


            case R.id.bt_plus :
                //result = service.plus(dto);
                result = first + second;
                tv_result.setText("Result : " + result);
                break;

            case R.id.bt_minus :
                //result = service.minus(dto);
                result = first - second;
                tv_result.setText("Result : " + result);
                break;

            case R.id.bt_multi :
                //result = service.multi(dto);
                result = first * second;
                tv_result.setText("Result : " + result);
                break;

            case R.id.bt_divid :
                //result = service.divid(dto);
                result = first / second;
                tv_result.setText("Result : " + result);
                break;

            case R.id.bt_mod :
                //result = service.mod(dto);
                result = first % second;
                tv_result.setText("Result : " + result);
                break;


        }
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Calc Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
