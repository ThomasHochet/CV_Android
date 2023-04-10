package com.example.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cv.Class.Langage;
import com.example.cv.Class.LangageAdapter;
import com.example.cv.Class.Projet;
import com.example.cv.Class.ProjetAdapter;

import java.util.ArrayList;

public class CompetencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competences);

        // underline
        TextView titreLang = findViewById(R.id.textViewTitreLang);
        SpannableStringBuilder underlineLang = new SpannableStringBuilder(getResources().getText(R.string.lang));
        underlineLang.setSpan(new UnderlineSpan(), 0, underlineLang.length(), 0);
        titreLang.setText(underlineLang);

        TextView titreProj = findViewById(R.id.textViewTitreProj);
        SpannableStringBuilder underlineProj = new SpannableStringBuilder(getResources().getText(R.string.proj));
        underlineProj.setSpan(new UnderlineSpan(), 0, underlineProj.length(), 0);
        titreProj.setText(underlineProj);

        // Bouton retour
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listLanguages = findViewById(R.id.listViewLanguages);
        ListView listProjects = findViewById(R.id.listViewProjects);

        String[] sArrayLanguages = getResources().getStringArray(R.array.langages);
        String[] sArrayProjects = getResources().getStringArray(R.array.projets);

        ArrayList<Langage> langages = new ArrayList<Langage>();
        ArrayList<Projet> projets = new ArrayList<Projet>();

        for(String langage : sArrayLanguages) {
            // 0 : nom, 1 : progress
            String[] data = langage.split("; ");
            Langage lang = new Langage(data[0] + " : ", Integer.parseInt(data[1]));
            langages.add(lang);
        }

        for(String projet : sArrayProjects) {
            // 0 : nom, 1 : description
            String[] data = projet.split("; ");
            Projet proj = new Projet(data[0] + " : ", data[1]);
            projets.add(proj);
        }

        LangageAdapter langageAdapter = new LangageAdapter(langages, this);
        ProjetAdapter projetAdapter = new ProjetAdapter(projets, this);

        listLanguages.setAdapter(langageAdapter);
        listProjects.setAdapter(projetAdapter);

        Button github = findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://github.com/ThomasHochet/CV_Android";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            // Fermer l'activité actuelle
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}