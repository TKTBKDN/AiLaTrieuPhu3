package com.example.takhanhthien.ailatrieuphu.dataBase;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.example.takhanhthien.ailatrieuphu.model.Question;

import java.util.ArrayList;

public class DatabaseALTP {
    final String DATABASE_NAME = "Question.sqlite";
    public static final String TABLE_NAME = "Question";
    public static final String DV_NAME = "Question.sqlite";
    public static final String PATH = Environment.getDataDirectory() +
            "/data/com.takhanhthien.ailatrieuphu/databases/" + DV_NAME;
    public static final String TABLE_ID = "_id";
    public static final String TABLE_QUESTION = "Question";
    public static final String TABLE_CASE_A = "CaseA";
    public static final String TABLE_CASE_B = "CaseB";
    public static final String TABLE_CASE_C = "CaseC";
    public static final String TABLE_CASE_D = "CaseD";
    public static final String TABLE_TRUE_CASE = "TrueCase";
    SQLiteDatabase database;
    private Activity activity;

    public DatabaseALTP(Activity activity) {
        this.activity = activity;
    }

    public void closeDaTaBase() {
        database.close();
    }

    public ArrayList<Question> getData() {
        ArrayList<Question> arrQuestions = new ArrayList<>();
        database = Database.initDatabase(activity, DATABASE_NAME);

        for (int i = 1; i < 16; i++) {
            String table = TABLE_NAME + i + "";
            String sql = "SELECT * FROM " + table + " ORDER BY random() limit 1";
            Cursor cursor = database.rawQuery(sql, null);
            int indexId = cursor.getColumnIndex(TABLE_ID);
            int indexQuestion = cursor.getColumnIndex(TABLE_QUESTION);
            int indexCaseA = cursor.getColumnIndex(TABLE_CASE_A);
            int indexCaseB = cursor.getColumnIndex(TABLE_CASE_B);
            int indexCaseC = cursor.getColumnIndex(TABLE_CASE_C);
            int indexCaseD = cursor.getColumnIndex(TABLE_CASE_D);
            int indexTrueCase = cursor.getColumnIndex(TABLE_TRUE_CASE);
            cursor.moveToFirst();
            int id = cursor.getInt(indexId);
            String question = cursor.getString(indexQuestion);
            String caseA = cursor.getString(indexCaseA);
            String caseB = cursor.getString(indexCaseB);
            String caseC = cursor.getString(indexCaseC);
            String caseD = cursor.getString(indexCaseD);
            int trueCase = cursor.getInt(indexTrueCase);
            Question question1 = new Question(id, question, caseA, caseB, caseC, caseD, trueCase);
            arrQuestions.add(question1);
        }
        closeDaTaBase();
        //cursor.close();
        return arrQuestions;
    }
}
