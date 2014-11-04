package com.example.cursoandroidfasta;

import android.util.Log;

public class Debug
{
	static boolean isDebug = true;
	static String tag = "tag";
	
	public static void mensaje(String valor)
	{
		if(isDebug)
		Log.d(tag, valor);
	}
	
	public static void mensajeError(String valor)
	{
		if(isDebug)
		Log.e(tag, valor);
	}
	
	public static void mensaje(int valor)
	{
		if(isDebug)
		Log.e(tag, ""+valor);
	}
	
	
}
