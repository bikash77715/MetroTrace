package com.hp.pav.demojune6.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.hp.pav.demojune6.domain.Route;

import java.util.ArrayList;

/**
 * Created by Pav on 5/25/2017.
 */

public class DBA extends SQLiteOpenHelper {
    final static String db_name = "metrotrace.db";
    Context context;
    public DBA(Context context) {

        super(context, db_name, null, 2);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS route( id INTEGER PRIMARY KEY AUTOINCREMENT, route_no INTEGER, name VARCHAR(30), stops VARCHAR(900),start_from VARCHAR(30), end_at VARCHAR(30) )");

        db.execSQL("CREATE TABLE IF NOT EXISTS bus( id INTEGER PRIMARY KEY AUTOINCREMENT,  reg_no VARCHAR(10), route_no INTEGER, lat REAL, lng REAL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { // It is executed when database version is changed

        db.execSQL("DROP TABLE IF EXISTS route");
        db.execSQL("DROP TABLE IF EXISTS bus");
        onCreate(db);

    }

    public void initialiseDB(){}

    public void addRoute(Route route) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("route_no",route.getRoute_no());
        cv.put("name", route.getName());
        cv.put("stops", route.getStops());
        cv.put("start_from", route.getStart_from());
        cv.put("end_at", route.getEnd_at());

        db.insert("route", null, cv);

//        db.execSQL("CREATE TABLE IF NOT EXISTS route( id INTEGER PRIMARY KEY AUTOINCREMENT, route_no INTEGER, name VARCHAR(30), stops VARCHAR(900),start_from VARCHAR(30), end_at VARCHAR(30) )");

        db.close();

    }

    public ArrayList<Route> getRoutes() {
        SQLiteDatabase dbr = this.getReadableDatabase();
        Cursor cursor = dbr.rawQuery("SELECT * FROM route ORDER BY name", null); // a pointer
        ArrayList<Route> route_list = new ArrayList<>();

        if(cursor.getCount()!=0){
            if(cursor.moveToFirst()){
                do{
                    Route route = new Route();
                    route.setRoute_no(cursor.getInt(cursor.getColumnIndex("route_no")));
                    route.setName(cursor.getString(cursor.getColumnIndex("name")));
                    route.setStops(cursor.getString(cursor.getColumnIndex("stops")));
                    route.setStart_from(cursor.getString(cursor.getColumnIndex("start_from")));
                    route.setEnd_at(cursor.getString(cursor.getColumnIndex("end_at")));

                    route_list.add(route);

                }while (cursor.moveToNext()); //if cursor can move to next
            }
        }
        cursor.close();
        dbr.close();
        return route_list;


    }
}
