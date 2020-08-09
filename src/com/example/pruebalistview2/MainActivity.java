package com.example.pruebalistview2;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {
	
	ListView lv1;
	EditText et1;
	ArrayList<String> lista1;
	ArrayAdapter<String> adaptador1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv1=(ListView)findViewById(R.id.listView1);
        et1=(EditText)findViewById(R.id.editText1);
        
        lista1=new ArrayList<String>();
        lista1.add("www.google.com.ar");
        lista1.add("www.lanacion.com.ar");
        lista1.add("www.issd.edu.ar");
        lista1.add("www.lavoz.com.ar");
        /*
        String[] lista2=new String[4];
        lista2[0]="www.google.com.ar";
        lista2[1]="www.lanacion.com.ar";
        lista2[2]="www.issd.edu.ar";
        lista2[3]="www.lavoz.com.ar";
        */
        adaptador1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista1);
        lv1.setAdapter(adaptador1);
        
        lv1.setOnItemClickListener(new OnItemClickListener() {

        	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

        		//Toast.makeText(MainActivity.this, lista1.get(arg2), Toast.LENGTH_LONG).show();
        		
        		Intent intento1=new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+lista1.get(arg2)));
        		startActivity(intento1);
        		
			}});
    }
    
    public void agregar (View v) {
    	 String sitio=et1.getText().toString();
    	 lista1.add(sitio);
    	 et1.setText("");
    	 adaptador1.notifyDataSetChanged(); //refresh de la lista visualizada
    	 
    }


    
}
