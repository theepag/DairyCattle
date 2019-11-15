package com.example.dairycattle;

public class Vaccination {

    String vaccinationId;
    String date;
    String vaccinationName;
    String vaccinationPurpose;
    String vaccinationVeterinaryOfficer;
    String remark;
    String nextVaccine;
    String remainder;

    public Vaccination() {
    }

    public Vaccination(String vaccinationId, String date, String vaccinationName, String vaccinationPurpose, String vaccinationVeterinaryOfficer, String remark, String nextVaccine, String remainder) {
        this.vaccinationId = vaccinationId;
        this.date = date;
        this.vaccinationName = vaccinationName;
        this.vaccinationPurpose = vaccinationPurpose;
        this.vaccinationVeterinaryOfficer = vaccinationVeterinaryOfficer;
        this.remark = remark;
        this.nextVaccine = nextVaccine;
        this.remainder = remainder;
    }

    public String getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(String vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVaccinationName() {
        return vaccinationName;
    }

    public void setVaccinationName(String vaccinationName) {
        this.vaccinationName = vaccinationName;
    }

    public String getVaccinationPurpose() {
        return vaccinationPurpose;
    }

    public void setVaccinationPurpose(String vaccinationPurpose) {
        this.vaccinationPurpose = vaccinationPurpose;
    }

    public String getVaccinationVeterinaryOfficer() {
        return vaccinationVeterinaryOfficer;
    }

    public void setVaccinationVeterinaryOfficer(String vaccinationVeterinaryOfficer) {
        this.vaccinationVeterinaryOfficer = vaccinationVeterinaryOfficer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNextVaccine() {
        return nextVaccine;
    }

    public void setNextVaccine(String nextVaccine) {
        this.nextVaccine = nextVaccine;
    }

    public String getRemainder() {
        return remainder;
    }

    public void setRemainder(String remainder) {
        this.remainder = remainder;
    }
}
