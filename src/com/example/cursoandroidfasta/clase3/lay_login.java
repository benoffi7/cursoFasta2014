package com.example.cursoandroidfasta.clase3;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cursoandroidfasta.R;

public class lay_login extends Activity
{
	EditText edit_user;
	EditText edit_pass;
	Button button_login;

	String TAG = "Ciclodevida";
	String password = "velez";

	ArrayList<String> usuarios = new ArrayList<String>();
	ArrayList<String> passwords = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		Log.d(TAG, "onCreate - lay_login");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lay_login);
		levantarXML();
		asignarEventos();
	}

	@Override
	protected void onResume()
	{
		edit_user.setText("");
		edit_pass.setText("");
		super.onResume();
	}


	private void levantarXML()
	{
		edit_user = (EditText) findViewById(R.id.edit_user);
		edit_pass = (EditText) findViewById(R.id.edit_pass);
		button_login = (Button) findViewById(R.id.button_login);
	}

	private void asignarEventos()
	{
		
		button_login.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				String validacion = validarDatos();
				if (validacion.length() == 0)
				{
					Toast.makeText(getApplicationContext(), "Validacion OK", Toast.LENGTH_SHORT).show();
					Intent intento = new Intent(lay_login.this, lay_login_correcto.class);
					intento.putExtra("nombre", edit_user.getText().toString());
					startActivity(intento);
				}
				else
				// sino
				{
					Toast.makeText(getApplicationContext(), validacion, Toast.LENGTH_LONG).show();
					
				}
			}
		});
	}


	private String validarDatos()
	{
		if (edit_pass.getText().toString().length() == 0)
		{
			return "Pass vacio";
		}
		if (edit_user.getText().toString().length() == 0)
		{
			return "User vacio";
		}
		if (!edit_pass.getText().toString().equals(password))
		{
			return "Contrase�a incorrecta";
		}
		return "";
	}

	@Override
	protected void onPause()
	{
		Log.d(TAG, "onPause - lay_login");
		super.onPause();
	}

	@Override
	protected void onDestroy()
	{
		Log.d(TAG, "onDestroy - lay_login");
		super.onDestroy();
	}

	@Override
	protected void onRestart()
	{
		Log.d(TAG, "onRestart - lay_login");
		super.onRestart();
	}

	@Override
	protected void onStop()
	{
		Log.d(TAG, "onStop - lay_login");
		super.onStop();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		Log.d(TAG, "onSaveInstanceState - lay_login");
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
		Log.d(TAG, "onRestoreInstanceState - lay_login");
		super.onRestoreInstanceState(savedInstanceState);
	}
}
