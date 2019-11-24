package com.example.dairycattle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class DiseaseList extends ArrayAdapter<Disease> {
    private Activity context;
    private List<Disease> diseaseList;

    public DiseaseList(Activity context, List<Disease> diseaseList) {
        super(context, R.layout.disease_list, diseaseList);
        this.context = context;
        this.diseaseList = diseaseList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.disease_list, null, true);

        TextView textViewDiseaseDate= listViewItem.findViewById(R.id.textViewDiseaseDate);
        TextView textViewDiseaseID = listViewItem.findViewById(R.id.textViewDiseaseID);

        Disease disease = diseaseList.get(position);
        textViewDiseaseDate.setText(disease.getDiseaseDate());
        textViewDiseaseID.setText(disease.getDiseaseID());


        return listViewItem;
    }

}