package com.example.choos.week161105.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.choos.week161105.global.Member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberDAO extends SQLiteOpenHelper  {

    public MemberDAO(Context context) {
        super(context, "hanbit.db",null,1);
        this.getWritableDatabase(); //데이터베이스 생성
        Log.d("DB 생성","====SUCCESS====");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + Member.TABLE+"\n" +
                "(\n" +
                Member.ID+" text primary key,\n" +
                Member.PW+" text ,\n" +
                Member.NAME+" text ,\n" +
                Member.EMAIL+" text ,\n" +
                Member.PHONE+" text ,\n" +
                Member.PHOTO+" text ,\n" +
                Member.ADDR+" text " +
                ");");
        db.execSQL("INSERT INTO " + Member.TABLE+" ("+Member.ID
                +", "+Member.PW+", "+Member.NAME+", "+Member.EMAIL+", "
                +Member.PHONE+", "+Member.PHOTO+","+Member.ADDR+")\n"
                + "VALUES ('hong1','1','HONGGILDONG','a@a.com','01012345678','default.jpg','SEOUL');");
        Log.d("MemberTABLE 생성","====SUCCESS====");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(MemberDTO param){
        Log.d("JOIN : ID ", param.getId());
        Log.d("JOIN : PW ", param.getPw());
        Log.d("JOIN : NAME ", param.getName());
        Log.d("JOIN : EMAIL ", param.getEmail());
        Log.d("JOIN : PHONE ", param.getPhone());
        Log.d("JOIN : PHOTO ", param.getPhoto());
        Log.d("JOIN : ADDRESS ", param.getAddr());

        String sql = "INSERT INTO \" + Member.TABLE+\" (\"+Member.ID\n" +
                "                +\", \"+Member.PW+\", \"+Member.NAME+\", \"+Member.EMAIL+\", \"\n" +
                "                +Member.PHONE+\", \"+Member.PHOTO+\",\"+Member.ADDR+\")\\n\"\n" +
                "                + \"VALUES ('hong1','1','HONGGILDONG','a@a.com','01012345678','default.jpg','SEOUL');";
        SQLiteDatabase db = this.getWritableDatabase() ;
        db.execSQL(sql);
    }
    public int selectCount(){
        int count = 0;
        return count;
    }
    public MemberDTO selectOne(String id){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public ArrayList<MemberDTO> selectList(){
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        return list;
    }
    public MemberDTO login(MemberDTO param){
        Log.d("JOIN : ID ", param.getId());
        Log.d("JOIN : PW ", param.getPw());
        String sql = "SELECT "+Member.PW+
                " FROM "+Member.TABLE+" where id= '"+param.getId()+"';";
        MemberDTO member = new MemberDTO();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToNext()) member.setPw(cursor.getString(0));
        Log.d("PW", member.getPw());
        return member;
    }
    public void update(MemberDTO param){

    }
    public void delete(MemberDTO param){

    }
}
