package com.example.cursoandroidfasta.internet;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cursoandroidfasta.R;

public class lay_internet extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.lay_internet);
		
		if (isNetworkAvailable())

		new descargarCaminatas().execute();
		
		else
			Toast.makeText(lay_internet.this, "Sin internet", Toast.LENGTH_SHORT).show();

		super.onCreate(savedInstanceState);
	}

	public class descargarCaminatas extends AsyncTask<Void, Void, ArrayList<Caminata>>
	{
		ProgressDialog pd;
		
		public descargarCaminatas()
		{
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void onPreExecute()
		{
			pd = new ProgressDialog(lay_internet.this);
			pd.setMessage("Descargando");
			pd.show();
			pd.setCancelable(false);
			super.onPreExecute();
		}

		@Override
		protected ArrayList<Caminata> doInBackground(Void... params)
		{

			return getCaminatas.devolverCaminatas();

		}

		@Override
		protected void onPostExecute(ArrayList<Caminata> result)
		{
			if (pd.isShowing())
			pd.dismiss();
			// do dao stuff
			AdaptadorSenderos adap = new AdaptadorSenderos(getApplicationContext(), result);
			ListView listView_circuitos = (ListView) findViewById(R.id.listView_circuitos);
			listView_circuitos.setAdapter(adap);
			super.onPostExecute(result);
		}
	}
	
	private boolean isNetworkAvailable() 
	{
		ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}
