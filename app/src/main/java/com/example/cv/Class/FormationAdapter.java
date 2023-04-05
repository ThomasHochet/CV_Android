package com.example.cv.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cv.R;

import java.util.ArrayList;

public class FormationAdapter extends BaseAdapter {

    private ArrayList<Formation> formations;
    private Context context;

    public FormationAdapter(ArrayList<Formation> formations, Context context) {
        this.formations = formations;
        this.context = context;
    }

    @Override
    public int getCount() {
        return formations.size();
    }

    @Override
    public Object getItem(int i) {
        return formations.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_formation, viewGroup, false);
        }

        TextView annee = view.findViewById(R.id.textViewAnnee);
        annee.setText(formations.get(i).getFin());

        TextView diplome = view.findViewById(R.id.textViewDiplome);
        diplome.setText(formations.get(i).getNom());

        TextView lieu = view.findViewById(R.id.textViewLieu);
        lieu.setText(formations.get(i).getLieu());
        return view;
    }
}
