package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

	/**
	 * Provice表建表语句
	 */
	public static final String CREATE_TABLE_PROVINCE = "create table Province(" +
			"id integer primary key autoincrement," +
			"province_name text," +
			"province_code text)";
	/**
	 * City表建表语句 
	 */
	public static final String CREATE_TABLE_CITY = "create table City(" +
			"id integer primary key autoincrement," +
			"city_name text," +
			"city_code text," +
			"province_id integer)";
	/**
	 * county建表语句
	 */
	public static final String CERATE_TABLE_COUNTY ="create table County(" +
			"id integer primary key autoincrement," +
			"county_name text," +
			"county_code text," +
			"city_id integer)";
	
	
	public CoolWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CERATE_TABLE_COUNTY);
		db.execSQL(CREATE_TABLE_CITY);
		db.execSQL(CREATE_TABLE_PROVINCE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists Province");
		db.execSQL("drop table if exists County");
		db.execSQL("drop table if exists City");
		onCreate(db);
	}

}
