package com.example.abir.greendaodatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText name,owner,address,contact;
    Button save;
    //initiate
    private STOREDao noteDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // get the note DAO
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        noteDao = daoSession.getSTOREDao();

        name=(EditText)findViewById(R.id.shopname);
        owner=(EditText)findViewById(R.id.malik);
        address=(EditText)findViewById(R.id.add);
        contact=(EditText)findViewById(R.id.mbl);
        save=(Button)findViewById(R.id.sv);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Take action.
                String n=name.getText().toString();
                String o=owner.getText().toString();
                String a=address.getText().toString();
                String m=contact.getText().toString();
                STORE note = new STORE();
                note.setName(n);
                note.setOwner(o);
                note.setAddress(a);
                note.setMobile(m);
                //DaoSession daoSession = (App.getInstance()).getDaoSession();
                //STOREDao noteDao = daoSession.getSTOREDao();
                noteDao.insert(note);
                Toast.makeText(getApplicationContext(),note.getName(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, VIEW_DATA.class);
                startActivity(i);
            }
        });
    }
}
