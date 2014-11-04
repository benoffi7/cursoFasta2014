package com.example.cursoandroidfasta;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ac_main extends Activity
{
	Button button2;
	private TextView textView1;

	String cadena;
	int entero = 0;
	boolean verdadero_falso;
	double decimales;
	float decimales_dos;

	ArrayList<String> lista_cadenas = new ArrayList<String>();
	private EditText editText1;
	private ImageView imageView1;
	private CheckBox checkBox1;
	private RadioGroup radioGroup1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_empty);
		findViews();
		// levantarXML();
		setEvents();
		
		finish();

	}
	
	@Override
	protected void onResume()
	{
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	protected void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	@Override
	protected void onPause()
	{
		// TODO Auto-generated method stub
		super.onPause();
	}

	private void setEvents()
	{
		editText1.addTextChangedListener(new TextWatcher()
		{

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count)
			{
				textView1.setText(s + " " + editText1.getText().toString().length());
				if (editText1.getText().toString().equals("Riquelme"))
				{
					button2.setVisibility(View.INVISIBLE);
				}
				if (editText1.getText().toString().equals("Cubero"))
				{
					button2.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s)
			{
				// TODO Auto-generated method stub

			}
		});

		imageView1.setOnLongClickListener(new OnLongClickListener()
		{
			@Override
			public boolean onLongClick(View arg0)
			{
				Toast.makeText(ac_main.this, getResources().getString(R.string.app_name), Toast.LENGTH_SHORT).show();

				return false;
			}
		});

		textView1.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0)
			{
				Toast.makeText(ac_main.this, getResources().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
				textView1.setTextColor(Color.BLUE);
				textView1.setTextColor(getResources().getColor(R.color.azul_us));
				textView1.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_blanco));
			}
		});

		button2.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				entero++;

				switch (radioGroup1.getCheckedRadioButtonId())
				{
				case R.id.radio0:
					textView1.setText("avion");
					break;
				case R.id.radio1:
					textView1.setText("muñeca");

					break;
				default:
					break;
				}

				switch (entero)
				{
				case 0:

					break;
				case 1:
					Debug.mensajeError("Error 4");
					break;
				case 2:
					Debug.mensajeError("Error 5");
					break;
				case 3:
					imageView1.setImageDrawable(getResources().getDrawable(R.drawable.esfera_7));
				default:
					break;
				}

				if (entero == 1)
				{
					Debug.mensajeError("Error");
				}
				else
					if (textView1.getText().toString().toLowerCase().contains("hola"))
					{
						Debug.mensajeError("Error 3");
					}

//				textView1.setText("" + entero);

			}
		});

		checkBox1.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{

			}
		});

		radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
		{

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{
				switch (checkedId)
				{
				case R.id.radio0:
					checkBox1.setChecked(false);

					break;
				case R.id.radio1:
					checkBox1.setChecked(true);
					break;
				default:
					break;
				}
			}
		});

	}

	private void findViews()
	{
		button2 = (Button) findViewById(R.id.button2);
		textView1 = (TextView) findViewById(R.id.textView1);

		checkBox1 = (CheckBox) findViewById(R.id.checkBox1);

		editText1 = (EditText) findViewById(R.id.editText1);

		Debug.mensaje(textView1.getText().toString());

		imageView1 = (ImageView) findViewById(R.id.imageView1);

		radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);

		Debug.mensaje(1);

		textView1.setText("hola");

		Log.v("tag", textView1.getText().toString());

		for (int i = 0; i < 5; i++)
		{

		}

		for (String i : lista_cadenas)
		{

		}
		
		try
		{
			int div = 5/0;
			Debug.mensaje(div);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
