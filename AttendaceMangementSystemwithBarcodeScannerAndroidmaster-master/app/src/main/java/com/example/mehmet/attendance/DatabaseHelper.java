package com.example.mehmet.attendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name = "Attendance.db";
    public static final String Table_Name = "Attendace_table";
    public static final String Table_Notes = "Notes";
    public  static final String Table_Attendance="Login";
    public static final String Col_1 = "ID";
    public static final String Col_2 = "Register_Form_No";
    public static final String Col_3 = "Roll_No";
    public static final String Col_4 = "Full_Name";
    public static final String Col_5 = "Gender";
    public static final String Col_6 = "Class";
    public static final String Col_7 = "College_Id_No";
    public static final String Col_8 = "Mobile_No";
    public static final String Coln_1 = "nid";
    public static final String Coln_2 = "title";
    public static final String Coln_3 = "body";
    public static final String Colx_2="email";
    public static final String Coly_3="password";



    public DatabaseHelper(Context context) {
        super(context, Database_Name, null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Table_Name + "(" + Col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + Col_2 + " TEXT," + Col_3 + " TEXT," + Col_4 + " TEXT," + Col_5 + " TEXT," + Col_6 + " TEXT," + Col_7 + " TEXT," + Col_8 + " TEXT" + ")";
        db.execSQL(query);

        String query1 = "CREATE TABLE " + Table_Notes + "(" + Coln_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + Coln_2 + " TEXT," + Coln_3 + ")";
        db.execSQL(query1);

        String query2 = "CREATE TABLE " + Table_Attendance + "(" + Coln_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + Coln_2 + " TEXT," + Coln_3 + ")";

        db.execSQL(query2);

        db.execSQL("CREATE TABLE user(email text PRİMARY KEY,password text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        db.execSQL("DROP TABLE IF EXISTS " + Table_Notes);
        db.execSQL("DROP TABLE IF EXISTS "+ Table_Attendance);
        onCreate(db);
    }
    public boolean insertRegisterForm(String formno, String rollno, String fullname, String gender, String Class, String collegeid, String mobno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(Col_2, formno);
        content.put(Col_3, rollno);
        content.put(Col_4, fullname);
        content.put(Col_5, gender);
        content.put(Col_6, Class);
        content.put(Col_7, collegeid);
        content.put(Col_8, mobno);
        long result = db.insert(Table_Name, null, content);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getAllData(String getData) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + Table_Name + " where College_Id_No= " + getData, null);
        return res;
    }

    public Cursor DisplayInfo(String getData) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + Table_Name + " where Full_Name= " + getData + " or Mobile_No= " + getData, null);
        return res;
    }

    public Cursor getAllStuds() {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + Table_Name, null);
            return res;
    }
    public boolean saveNotes(String title, String body) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(Coln_2, title);
        content.put(Coln_3, body);
        long result = db.insert(Table_Notes, null, content);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insert(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(Colx_2, email);
        content.put(Coly_3, password);
        long result = db.insert(Table_Attendance, null, content);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Boolean GetAllAttendance(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + Table_Attendance+ " where email=? ",new  String[]{email});
        if (cursor.getCount()>0) return false;
        else return true;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(Table_Attendance,"ID=?",new String[] {id});

    }

}

