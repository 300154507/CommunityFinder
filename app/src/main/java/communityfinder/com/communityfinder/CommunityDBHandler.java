/**
 * Created by student on 3/23/15.
 */
package communityfinder.com.communityfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;

public class CommunityDBHandler extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Community.db";
    public static final String COMMUNITY = "Community";
    public static final String CSDCode = "CSDCode";
    public static final String SUBDIVISON = "Subdivision";
    public static final String INCOMESCORE = "IncomeScore";
    public static final String EDUCATIONSCORE = "EducationScore";
    public static final String HOUSINGSCORE = "HousingScore";
    public static final String LABOURFORCEACTIVITYSCORE = "Labourforceactivityscore";
    public static final String CWBSCORE = "CWBScore";
    public static final String POPULATION = "Population";
    public static final String CATEGORY = "Category";
    public static final String PROVINCE = "Province";

    public CommunityDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_COMMUNITY_TABLE = "Create Table " + COMMUNITY + "(" +
                CSDCode + " INTEGER PRIMARY KEY,"
                + SUBDIVISON + " TEXT,"
                + INCOMESCORE + " INTEGER,"
                + EDUCATIONSCORE + " INTEGER,"
                + HOUSINGSCORE + " INTEGER,"
                + LABOURFORCEACTIVITYSCORE + " INTEGER,"
                + CWBSCORE + " INTEGER,"
                + POPULATION + " INTEGER,"
                + CATEGORY + " TEXT,"
                + PROVINCE + " TEXT" +
                ")";
       db.execSQL(CREATE_COMMUNITY_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COMMUNITY);
        onCreate(db);
    }
    public void addCommunity(Community foo)
    {
        ContentValues values = new ContentValues();
        values.put(CSDCode,foo.getCSDCode());
        values.put(SUBDIVISON,foo.getSubDivision());
        values.put(INCOMESCORE,foo.getIncomeScore());
        values.put(EDUCATIONSCORE,foo.getEducationScore());
        values.put(HOUSINGSCORE,foo.getHousingScore());
        values.put(LABOURFORCEACTIVITYSCORE,foo.getLabourForceActivityScore());
        values.put(CWBSCORE,foo.getCwbScore());
        values.put(POPULATION,foo.getPopulation());
        values.put(CATEGORY,foo.getCategory());
        values.put(PROVINCE,foo.getProvince());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(COMMUNITY,null,values);

        db.close();
    }
    public Community findCommunity(int x)
    {
        String query = "Select * from " + COMMUNITY + " WHERE " + CSDCode + " = \"" + x + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query,null);
        Community community = new Community();
        if(cursor.moveToFirst())
        {
            cursor.moveToFirst();
            community.setCSDCode((Integer.parseInt(cursor.getString(0))));
            community.setSubDivision(cursor.getString(1));
            community.setIncomeScore(Integer.parseInt(cursor.getString(2)));
            community.setEducationScore((Integer.parseInt(cursor.getString(3))));
            community.setHousingScore(Integer.parseInt(cursor.getString(4)));
            community.setLabourForceActivityScore(Integer.parseInt(cursor.getString(5)));
            community.setCwbScore(Integer.parseInt(cursor.getString(6)));
            community.setPopulation(Integer.parseInt(cursor.getString(7)));
            community.setCategory(cursor.getString(8));
            community.setProvince(cursor.getString(9));
        }
        else
        {
            community = null;
        }
        db.close();
        return  community;
    }
    public boolean deleteCommunity(int x)
    {
        boolean result = false;
        String query = "SELECT * FROM " + COMMUNITY + " WHERE " + CSDCode + " = \"" + x + "\"";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query,null);
        Community community = new Community();

        if(cursor.moveToFirst())
        {
            community.setCSDCode(Integer.parseInt(cursor.getString(0)));
            db.delete(COMMUNITY,CSDCode + " = ?",new String[]{String.valueOf(community.getCSDCode())});
            cursor.close();
            result = true;
        }
        db.close();
        return  result;
    }
    public ArrayList<Community> getAllCommuntites()
    {
        ArrayList<Community> acculmulateCommunityList = new ArrayList<Community>();
        String query = "Select * from " + COMMUNITY;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query,null);
        Community community = new Community();



            if (cursor.moveToFirst()) {
                community = new Community();
                community.setCSDCode((Integer.parseInt(cursor.getString(0))));
                community.setSubDivision(cursor.getString(1));
                community.setIncomeScore(Integer.parseInt(cursor.getString(2)));
                community.setEducationScore((Integer.parseInt(cursor.getString(3))));
                community.setHousingScore(Integer.parseInt(cursor.getString(4)));
                community.setLabourForceActivityScore(Integer.parseInt(cursor.getString(5)));
                community.setCwbScore(Integer.parseInt(cursor.getString(6)));
                community.setPopulation(Integer.parseInt(cursor.getString(7)));
                community.setCategory(cursor.getString(8));
                community.setProvince(cursor.getString(9));
                acculmulateCommunityList.add(community);
                while(cursor.moveToNext()) {
                    community = new Community();
                    community.setCSDCode((Integer.parseInt(cursor.getString(0))));
                    community.setSubDivision(cursor.getString(1));
                    community.setIncomeScore(Integer.parseInt(cursor.getString(2)));
                    community.setEducationScore((Integer.parseInt(cursor.getString(3))));
                    community.setHousingScore(Integer.parseInt(cursor.getString(4)));
                    community.setLabourForceActivityScore(Integer.parseInt(cursor.getString(5)));
                    community.setCwbScore(Integer.parseInt(cursor.getString(6)));
                    community.setPopulation(Integer.parseInt(cursor.getString(7)));
                    community.setCategory(cursor.getString(8));
                    community.setProvince(cursor.getString(9));
                    acculmulateCommunityList.add(community);
                }
            } else {
                community = null;
            }

        db.close();
        return acculmulateCommunityList;
    }
    public ArrayList<Community> findCommunityByCategory(String cat)
    {
        ArrayList<Community> acculmulateCommunityList = new ArrayList<Community>();
        String query = "Select * from " + COMMUNITY + " Where " + CATEGORY + " = \'" + cat + "\'";


        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query,null);
        Community community = new Community();



        if (cursor.moveToFirst()) {
            community = new Community();
            community.setCSDCode((Integer.parseInt(cursor.getString(0))));
            community.setSubDivision(cursor.getString(1));
            community.setIncomeScore(Integer.parseInt(cursor.getString(2)));
            community.setEducationScore((Integer.parseInt(cursor.getString(3))));
            community.setHousingScore(Integer.parseInt(cursor.getString(4)));
            community.setLabourForceActivityScore(Integer.parseInt(cursor.getString(5)));
            community.setCwbScore(Integer.parseInt(cursor.getString(6)));
            community.setPopulation(Integer.parseInt(cursor.getString(7)));
            community.setCategory(cursor.getString(8));
            community.setProvince(cursor.getString(9));
            acculmulateCommunityList.add(community);
            while(cursor.moveToNext()) {
                community = new Community();
                community.setCSDCode((Integer.parseInt(cursor.getString(0))));
                community.setSubDivision(cursor.getString(1));
                community.setIncomeScore(Integer.parseInt(cursor.getString(2)));
                community.setEducationScore((Integer.parseInt(cursor.getString(3))));
                community.setHousingScore(Integer.parseInt(cursor.getString(4)));
                community.setLabourForceActivityScore(Integer.parseInt(cursor.getString(5)));
                community.setCwbScore(Integer.parseInt(cursor.getString(6)));
                community.setPopulation(Integer.parseInt(cursor.getString(7)));
                community.setCategory(cursor.getString(8));
                community.setProvince(cursor.getString(9));
                acculmulateCommunityList.add(community);
            }
        } else {
            community = null;
        }

        db.close();
        return acculmulateCommunityList;
    }

}
