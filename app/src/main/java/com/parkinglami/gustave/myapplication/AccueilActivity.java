package com.parkinglami.gustave.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class AccueilActivity extends ActionBarActivity implements View.OnClickListener {

    Button btnMap;
    Button popup;
    AlertDialog.Builder dialogBuilder;
    String nomDialog;
    TextView lblTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
       // lblTemperature =(TextView)findViewById();
        btnMap =(Button)findViewById(R.id.btnGmap);
        btnMap.setOnClickListener(this);
    /*    btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });*/
        popup = (Button) findViewById(R.id.btnPopup);
        popup.setOnClickListener(this);
    }

    public void myPopPupDialog(){
        //variables
        dialogBuilder = new AlertDialog.Builder(this);
        final String[] str = {"Directeur","Visiteur","Handicapé","Employé"};
         nomDialog = "\nVous êtes ";

        //process
        dialogBuilder.setTitle("Reservation");
        dialogBuilder.setSingleChoiceItems(str,-1,new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                nomDialog += str[which];
                display();
                Toast.makeText(getApplicationContext(),nomDialog,Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //output
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }

    public void display(){
       String strOrder = "\n"+nomDialog;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accueil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case  R.id.btnGmap:
                Intent intent = new Intent(AccueilActivity.this,MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.btnPopup:
                myPopPupDialog();
                break;
        }
    }
}
