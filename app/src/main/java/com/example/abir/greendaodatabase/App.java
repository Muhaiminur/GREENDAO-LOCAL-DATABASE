package com.example.abir.greendaodatabase;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

/**
 * Created by ABIR on 3/12/2018.
 */

import android.app.Application;

import org.greenrobot.greendao.database.Database;
import com.example.abir.greendaodatabase.DaoMaster.DevOpenHelper;

public class App extends Application {
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DevOpenHelper helper = new DevOpenHelper(this,"user");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}