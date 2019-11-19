package com.example.dairycattle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class VaccineList extends ArrayAdapter<Vaccine> {
    private Activity context;
    private List<Vaccine> vaccineList;

    public VaccineList(Activity context, List<Vaccine> vaccineList) {
        super(context, R.layout.vaccine_list, vaccineList);
        this.context = context;
        this.vaccineList = vaccineList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.vaccine_list, null, true);

        TextView textViewVaccineDate= listViewItem.findViewById(R.id.textViewVaccineDate);
        TextView textViewVaccineID = listViewItem.findViewById(R.id.textViewVaccineID);

        Vaccine vaccine = vaccineList.get(position);
        textViewVaccineDate.setText(vaccine.getVaccineDate());
        textViewVaccineID.setText(vaccine.getVaccineID());


        return listViewItem;
    }
}