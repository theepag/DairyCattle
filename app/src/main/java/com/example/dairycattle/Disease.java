package com.example.dairycattle;

public class Disease {

    String diseaseId;
    String diseaseDate;
    String clinicalSigns;
    String typeOfClinicalSigns;
    String kindOfDisease;
    String treatment;
    String remarks;

    public Disease() {
    }

    public Disease(String diseaseId, String diseaseDate, String clinicalSigns, String typeOfClinicalSigns, String kindOfDisease, String treatment, String remarks) {
        this.diseaseId = diseaseId;
        this.diseaseDate = diseaseDate;
        this.clinicalSigns = clinicalSigns;
        this.typeOfClinicalSigns = typeOfClinicalSigns;
        this.kindOfDisease = kindOfDisease;
        this.treatment = treatment;
        this.remarks = remarks;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDiseaseDate() {
        return diseaseDate;
    }

    public void setDiseaseDate(String diseaseDate) {
        this.diseaseDate = diseaseDate;
    }

    public String getClinicalSigns() {
        return clinicalSigns;
    }

    public void setClinicalSigns(String clinicalSigns) {
        this.clinicalSigns = clinicalSigns;
    }

    public String getTypeOfClinicalSigns() {
        return typeOfClinicalSigns;
    }

    public void setTypeOfClinicalSigns(String typeOfClinicalSigns) {
        this.typeOfClinicalSigns = typeOfClinicalSigns;
    }

    public String getKindOfDisease() {
        return kindOfDisease;
    }

    public void setKindOfDisease(String kindOfDisease) {
        this.kindOfDisease = kindOfDisease;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
