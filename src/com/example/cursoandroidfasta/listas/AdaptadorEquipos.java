package com.example.cursoandroidfasta.listas;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cursoandroidfasta.R;

public class AdaptadorEquipos extends BaseAdapter
{
	private ArrayList<Equipo> equipos;
	private Context context;

	public AdaptadorEquipos(ArrayList<Equipo> Equipos, Context Context)
	{
		this.equipos = Equipos;
		this.context = Context;
	}

	@Override
	public int getCount()
	{
		return equipos.size();
	}

	@Override
	public Equipo getItem(int position)
	{
		return equipos.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return 0;
	}

	static class ViewHolder
	{
		TextView text_equipo;
		TextView text_puntos;
		ImageView image_flag;
		LinearLayout ll_row;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		 final Equipo item = getItem(position);
		 ViewHolder holder;
		if (convertView == null)//es la primera vez
		{
			Log.d("Curso","esta es la primera vez del elemento "+item.getNombre());
			LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = li.inflate(R.layout.row_equipo, parent, false);
			holder = new ViewHolder();
			holder.text_equipo = (TextView) convertView.findViewById(R.id.text_equipo);
			holder.text_puntos = (TextView) convertView.findViewById(R.id.text_puntos);
			holder.image_flag = (ImageView) convertView.findViewById(R.id.image_flag);
			holder.ll_row = (LinearLayout) convertView.findViewById(R.id.ll_row);
			convertView.setTag(holder);
		} 
		else
		{
			Log.d("Curso","esta es la primera vez del elemento "+item.getNombre());
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.text_equipo.setText(item.getNombre());
		holder.text_puntos.setText("Puntos: "+item.getPuntos());
		holder.image_flag.setImageDrawable(item.getBandera());
		holder.ll_row.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				Toast.makeText(context, item.getNombre(), Toast.LENGTH_SHORT).show();
				context.startActivity(new Intent(context, lay_lista.class));
			}
		});
		return convertView;
	}
}
