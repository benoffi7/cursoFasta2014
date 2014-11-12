package com.example.cursoandroidfasta.clase3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cursoandroidfasta.R;

public class lay_login_correcto extends Activity
{
	private TextView text_nombre;
	String usuario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lay_login_correcto);		
		Intent quienmellamo =getIntent();
		Bundle contenedor =quienmellamo.getExtras();
		
		usuario = contenedor.getString(app.clave_nombre);
		levantarXML();
		text_nombre.setText(usuario);
	}
	
	private void levantarXML()
	{
		text_nombre  = (TextView)findViewById(R.id.text_nombre);
		
	}
	
	@Override
	protected void onStart()
	{
		// TODO Auto-generated method stub
		super.onStart();
	}
	
	@Override
	protected void onPause()
	{
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	
}
