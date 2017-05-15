package com.example.takhanhthien.ailatrieuphu.dataBase;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.takhanhthien.ailatrieuphu.model.Question;

import java.util.ArrayList;

/**
 * Created by Computer on 4/18/2017.
 */

public class DatabaseQuestion {
    final String DATABASE_NAME = "Question.sqlite";
    public static final String TABLE_ID="_id";
    public static final String TABLE_NAME="Question";
    public static final String TABLE_QUESTION="Question";
    public static final String TABLE_CASE_A="CaseA";
    public static final String TABLE_CASE_B="CaseB";
    public static final String TABLE_CASE_C="CaseC";
    public static final String TABLE_CASE_D="CaseD";
    public static final String TABLE_TRUE_CASE="TrueCase";
    SQLiteDatabase database;
    private Activity activity;

    public DatabaseQuestion(Activity activity) {
        this.activity=activity;
    }

    public ArrayList<Question> readData(){
        database = Database.initDatabase(activity, DATABASE_NAME);
        ArrayList<Question> arrQuestions=new ArrayList<>();
        Cursor cursor=null;
        for (int i=1;i<16;i++) {
            String table = TABLE_NAME + i+"";
            String sql="SELECT * FROM "+table+" ORDER BY RANDOM() limit 1";
            cursor= database.rawQuery(sql,null);
            int indexId= cursor.getColumnIndex(TABLE_ID);
            int indexQuestion= cursor.getColumnIndex(TABLE_QUESTION);
            int indexCaseA=cursor.getColumnIndex(TABLE_CASE_A);
            int indexCaseB=cursor.getColumnIndex(TABLE_CASE_B);
            int indexCaseC=cursor.getColumnIndex(TABLE_CASE_C);
            int indexCaseD=cursor.getColumnIndex(TABLE_CASE_D);
            int indexTrueCase=cursor.getColumnIndex(TABLE_TRUE_CASE);
            cursor.moveToFirst();



            int id=cursor.getInt(indexId);
            String question= cursor.getString(indexQuestion);
            String caseA= cursor.getString(indexCaseA);
            String caseB= cursor.getString(indexCaseB);
            String caseC= cursor.getString(indexCaseC);
            String caseD= cursor.getString(indexCaseD);
            int trueCase= cursor.getInt(indexTrueCase);
            Question question1=new Question(id,question,caseA,caseB,caseC,caseD,trueCase);
            arrQuestions.add(question1);
        }
        cursor.close();
        return arrQuestions;
    }


}
