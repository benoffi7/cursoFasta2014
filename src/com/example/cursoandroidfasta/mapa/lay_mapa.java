package com.example.cursoandroidfasta.mapa;

import java.io.File;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cursoandroidfasta.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

//tengo que extender de FragmentActivity porque estoy manipulando un fragmento
public class lay_mapa extends FragmentActivity 
{
	private GoogleMap mapa;
	private LocationManager locationManager;
	private LocationListener listenerGPS;

	@Override
	protected void onCreate(Bundle arg0) 
	{
		super.onCreate(arg0);
		setContentView(R.layout.lay_mapa);
		setupGPS();
		setupMapa();
		mostrarMarcador(1,"Esfera de Dragon I", "Plaza Peralta Ramos", Double.parseDouble("-37.999111"), Double.parseDouble("-57.562029"));
		mostrarMarcador(2,"Esfera de Dragon II", "Plaza Mitre", Double.parseDouble("-38.003541"), Double.parseDouble("-57.552159"));
		mostrarMarcador(3,"Esfera de Dragon III", "Plaza Rocha", Double.parseDouble("-37.992989"), Double.parseDouble("-57.556665"));
		mostrarMarcador(4,"Esfera de Dragon IV", "Plaza San Mart�n", Double.parseDouble("-37.997826"), Double.parseDouble("-57.547052"));
		mostrarMarcador(5,"Esfera de Dragon X", "Primavesi", Double.parseDouble("-38.028594"), Double.parseDouble("-57.541602"));
		mostrarMarcador(6,"Esfera de Dragon XI", "Base Naval", Double.parseDouble("-38.043365"), Double.parseDouble("-57.542589"));
		mostrarMarcador(7,"Esfera de Dragon XII", "UTN", Double.parseDouble("-38.049753"), Double.parseDouble("-57.543619"));
	
	}

	private void setupMapa()
	{
		//levantamos el mapa
	//	mapa = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		SupportMapFragment mapF =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		mapa = mapF.getMap();
		
		
		
		//activamos el seguimiento de la ubicación actual. esto crea un punto azul que nos sigue y el boton para ubicarnos
		mapa.setMyLocationEnabled(true);
		//metodo para cuando hacemos click dentro del popup
		mapa.setOnInfoWindowClickListener(new OnInfoWindowClickListener() 
		{
			@Override
			public void onInfoWindowClick(Marker marker)
			{
				Toast.makeText(getApplicationContext(), "Presione un popup dentro del marker", Toast.LENGTH_SHORT).show();
				//ocultamos popup
				marker.hideInfoWindow();
				
					AlertDialog.Builder dialogo1 = new AlertDialog.Builder(lay_mapa.this);  
			        dialogo1.setTitle(getResources().getString(R.string.app_name));  
			        dialogo1.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
			        dialogo1.setMessage("Hola, mucho gusto, soy un Alert Dialog. Presione cualquiera de mis tres opciones. Gracias y que tenga buen día");            
			          
			        dialogo1.setPositiveButton("Tostada al medio", new DialogInterface.OnClickListener() 
			        {  
			            public void onClick(DialogInterface dialogo1, int id)
			            {  
			            	// toast centrado
			        		Toast toast2 = Toast.makeText(getApplicationContext(), "Vamos argentina!", Toast.LENGTH_LONG);
			        		toast2.setGravity(Gravity.CENTER, 0, 0);
			        		toast2.show();
			                dialogo1.dismiss();  
			            }  
			        });
			        dialogo1.setNegativeButton("Tostada personalizada", new DialogInterface.OnClickListener()
					{
						
						@Override
						public void onClick(DialogInterface dialog, int which)
						{
							Toast toast3 = new Toast(lay_mapa.this);

							LayoutInflater inflater = getLayoutInflater();
							View layout = inflater.inflate(R.layout.toast_personalizado, (ViewGroup) findViewById(R.id.lytLayout));

							TextView txtMsg = (TextView) layout.findViewById(R.id.txtMensaje);
							txtMsg.setText("Vamos argentina!");

							toast3.setDuration(Toast.LENGTH_SHORT);
							toast3.setView(layout);
							toast3.show();
							
							dialog.dismiss();
						}
					});     
			        dialogo1.setNeutralButton("Otra actividad", new DialogInterface.OnClickListener()
					{
						
						@Override
						public void onClick(DialogInterface dialog, int which)
						{
							dialog.dismiss();
						}
					});
			        dialogo1.show();				
				
				
			}
		});
		mapa.setOnMapClickListener(new OnMapClickListener()
		{
			
			@Override
			public void onMapClick(LatLng arg0)
			{
				//arg0.latitude
				//arg0.longitude
				
				
			}
		});
		//meedo para cuando hacemos clicl en un marker
		mapa.setOnMarkerClickListener(new OnMarkerClickListener()
		{
			public boolean onMarkerClick(Marker marker) 
			{
				//mostrarmos el popup
				if (!marker.isInfoWindowShown())
				marker.showInfoWindow();
				Toast.makeText(getApplicationContext(), "Presione un marker", Toast.LENGTH_SHORT).show();
				return true;
			}
		});		
		
		mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

	}
	
	private void setupGPS()
	{
		//traigo la constante referida al servicio de ubicación
		String serviceString = Context.LOCATION_SERVICE;
		//con ese valor, creo un location manaeger
		locationManager = (LocationManager) getSystemService(serviceString);
		//un listener cada vez que cambia la ubicación
		listenerGPS = new LocationListener();
		//pido actualizaciones cada mil milisegundos y 100 metros con los datos
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 100, listenerGPS);
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) 
		{
			//pido actualizaciones cada mil milisegundos y 100 metros con el GPS (si tengo habilitado el GPS)
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 100, listenerGPS);
		}
		else
		{
			
		}
	}
	
	private void mostrarMarcador(int id, String nombre, String direccion, double lat, double lng)
	{	
		// buscar una imagen en la SDCard y asiganarla en el marker
		String file_path = Environment.getExternalStorageDirectory()+File.separator+"/esferas";
		File dir = new File(file_path);  	 
		if(!dir.exists())
			  				dir.mkdirs();
		File file = new File(dir, "esfera"+id+".png");
		Bitmap myBitmap =null ;
		if ( (file.exists() ) && (file.length()>0) )
		{
		  myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
		}
		
		if (myBitmap!=null)
		{
			mapa.addMarker(new MarkerOptions()
							    .position(new LatLng(lat, lng))
						        .title(nombre)							        
						        .icon(BitmapDescriptorFactory.fromBitmap(myBitmap))
						        .snippet(direccion)); 
			 myBitmap.recycle();
			 myBitmap = null;
			 System.gc();
		 }
		 else
		 {
			 //busco el id basado en el nombre
			 int drawableID = getResources().getIdentifier("esfera_"+id, "drawable", getPackageName());
			// String aux = getResources().getString(drawableID);
			 mapa.addMarker(new MarkerOptions()
							    .position(new LatLng(lat, lng))
						        .title(nombre)	//el titulo del popup				
						        .icon(BitmapDescriptorFactory.fromResource(drawableID))
						        .snippet(direccion)); //el sub-titulo del popup
		 }
	}

	public class LocationListener implements android.location.LocationListener
	{
		//cuando cambia la ubicación
		public void onLocationChanged(Location location) 
		{
			//recuperamos la posición
			LatLng ubicacion = new LatLng(location.getLatitude(),location.getLongitude());
			//creamos un objeto cámara y establecemos zoom y posicion
			CameraPosition camPos = new CameraPosition.Builder()
					.target(ubicacion)
					.zoom(14) // Establecemos el zoom en 14
					.build();
			
			CameraUpdate camUpd = CameraUpdateFactory.newCameraPosition(camPos);
			//animamos el mapa basado en esa configuraci�n de camara
			mapa.animateCamera(camUpd);
		}

		public void onProviderDisabled(String provider) 
		{
		}

		public void onProviderEnabled(String provider) 
		{
		}

		public void onStatusChanged(String provider, int status, Bundle extras)
		{
		}

		public void onGpsStatusChanged(int event)
		{
			
		}
	}
}