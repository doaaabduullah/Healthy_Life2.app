package com.example.healthylife2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Login.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_USERS = "users";
    private static final String TABLE_FEEDBACK = "feedback";
    private static final String TABLE_PERSONAL_DETAIL = "personalDetail";

    // Column names for the tables
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_RATINGS = "ratings";
    private static final String COLUMN_FEEDBACK_TXT = "feedbackTxt";
    private static final String COLUMN_CURRENT_WEIGHT = "currentWeight";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_GOAL_WEIGHT = "goalWeight";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTableQuery = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_USERNAME + " TEXT PRIMARY KEY, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_PHONE + " TEXT)";
        db.execSQL(createUsersTableQuery);

        String createFeedbackTableQuery = "CREATE TABLE " + TABLE_FEEDBACK + " (" +
                COLUMN_RATINGS + " TEXT, " +
                COLUMN_FEEDBACK_TXT + " TEXT)";
        db.execSQL(createFeedbackTableQuery);

        String createPersonalDetailTableQuery = "CREATE TABLE " + TABLE_PERSONAL_DETAIL + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CURRENT_WEIGHT + " TEXT, " +
                COLUMN_HEIGHT + " TEXT, " +
                COLUMN_GOAL_WEIGHT + " TEXT)";
        db.execSQL(createPersonalDetailTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FEEDBACK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONAL_DETAIL);
        onCreate(db);
    }

    public boolean insertData(String username, String password, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, username);
        contentValues.put(COLUMN_PASSWORD, password);
        contentValues.put(COLUMN_PHONE, phone);

        long result = db.insert(TABLE_USERS, null, contentValues);
        return result != -1;
    }

    public boolean insertFeedback(String ratings, String feedbackTxt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_RATINGS, ratings);
        contentValues.put(COLUMN_FEEDBACK_TXT, feedbackTxt);

        long result = db.insert(TABLE_FEEDBACK, null, contentValues);
        return result != -1;
    }

    public boolean insertPersonalDetail(String currentWeight, String height, String goalWeight) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CURRENT_WEIGHT, currentWeight);
        contentValues.put(COLUMN_HEIGHT, height);
        contentValues.put(COLUMN_GOAL_WEIGHT, goalWeight);

        long result = db.insert(TABLE_PERSONAL_DETAIL, null, contentValues);
        return result != -1;
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + "=?", new String[]{username});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    public boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + "=? AND " + COLUMN_PASSWORD + "=?", new String[]{username, password});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }
}
