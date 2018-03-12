package com.example.abir.greendaodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class VIEW_DATA extends AppCompatActivity {
    TextView show;
    //initiate
    private STOREDao noteDao;
    DaoSession daoSession;

    TextView s,o,a,c;
    Button b,del;
    //DaoSession daoSession = (App.getInstance()).getDaoSession();
    //STOREDao noteDao = daoSession.getSTOREDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        s=(TextView)findViewById(R.id.shopname);
        o=(TextView)findViewById(R.id.ownname);
        a=(TextView)findViewById(R.id.addview);
        c=(TextView)findViewById(R.id.call);
        del=(Button)findViewById(R.id.delete);
        // get the note DAO
        daoSession = ((App) getApplication()).getDaoSession();
        noteDao = daoSession.getSTOREDao();

        b=(Button)findViewById(R.id.showlist);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Take action.
                List<STORE> notes = noteDao.loadAll();
                for (int i=0;i<notes.size();i++){
                    Toast.makeText(getApplicationContext(),notes.get(i).getName(), Toast.LENGTH_SHORT).show();
                    Log.d("FROM DATABASE",notes.get(i).getName());
                }
                s.setText(notes.get(notes.size()-1).getName());
                o.setText(notes.get(notes.size()-1).getOwner());
                a.setText(notes.get(notes.size()-1).getAddress());
                c.setText(notes.get(notes.size()-1).getMobile());

            }
        });

        //show.setText(notes.toString());
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delete all the table
                daoSession.getSTOREDao().deleteAll();

                Toast.makeText(getApplicationContext(),"DELETED ALL THE DATA", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
