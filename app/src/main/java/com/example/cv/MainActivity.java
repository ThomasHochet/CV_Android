package com.example.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cv.Class.Experience;
import com.example.cv.Class.ExperienceAdapter;
import com.example.cv.Class.Formation;
import com.example.cv.Class.FormationAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Underline
        TextView titreExperience = findViewById(R.id.textViewExp);
        SpannableStringBuilder underlineExp = new SpannableStringBuilder(getResources().getText(R.string.exp));
        underlineExp.setSpan(new UnderlineSpan(), 0, underlineExp.length(), 0);
        titreExperience.setText(underlineExp);

        TextView titreFormations = findViewById(R.id.textViewForm);
        SpannableStringBuilder underlineForm = new SpannableStringBuilder(getResources().getText(R.string.form));
        underlineForm.setSpan(new UnderlineSpan(), 0, underlineForm.length(), 0);
        titreFormations.setText(underlineForm);

        // On récupère les string-array de strings.xml
        String[] sArrayExperiences = getResources().getStringArray(R.array.experiences);
        String[] sArrayFormations = getResources().getStringArray(R.array.formations);

        ArrayList<Experience> experiences = new ArrayList<Experience>();
        ArrayList<Formation> formations = new ArrayList<Formation>();

        for(String experience : sArrayExperiences) {
            String[] data = experience.split("; ");
            // 0 : début, 1 : fin, 2 : Entreprise, 3 : Description
            Experience exp = new Experience(data[0], data[1], data[2], data[3]);
            experiences.add(exp);
        }

        for(String formation : sArrayFormations) {
            String[] data = formation.split("; ");
            // 0 : début (ignoré), 1 : fin, 2 : formation, 3 : Lieu
            Formation form = new Formation(data[1], data[2], data[3]);
            formations.add(form);
        }

        ListView listExperiences = findViewById(R.id.ListViewExperiences);
        ExperienceAdapter experienceAdapter = new ExperienceAdapter(experiences, this);
        listExperiences.setAdapter(experienceAdapter);

        ListView listFormations = findViewById(R.id.ListViewFormations);
        FormationAdapter formationAdapter = new FormationAdapter(formations, this);
        listFormations.setAdapter(formationAdapter);

    }

    public void launchCompetencesActivity(View view) {
        Intent intent = new Intent(this, CompetencesActivity.class);
        startActivity(intent);
    }
}