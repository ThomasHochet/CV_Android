package com.example.cv.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cv.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ExperienceAdapter extends BaseAdapter {

    private ArrayList<Experience> experiences;
    private Context context;

    public ExperienceAdapter(ArrayList<Experience> experiences, Context context) {
        this.experiences = experiences;
        this.context = context;
    }

    @Override
    public int getCount() {
        return experiences.size();
    }

    @Override
    public Object getItem(int i) {
        return experiences.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Creation de la view en prenant item_experience en layout
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_experience, viewGroup, false);
        }
        TextView dateDebut = view.findViewById(R.id.textViewDebut);
        dateDebut.setText(experiences.get(i). getDebut());

        TextView dateFin = view.findViewById(R.id.textViewFin);
        dateFin.setText(experiences.get(i).getFin());

        TextView entreprise = view.findViewById(R.id.textViewEntreprise);
        entreprise.setText(experiences.get(i).getEntreprise());

        TextView description = view.findViewById(R.id.textViewDescription);
        description.setText(experiences.get(i).getDescription());

        return view;
    }
}
