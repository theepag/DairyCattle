package com.example.dairycattle;

public class Dairy {

    String DairyId;
    String DateOfBirth;
    String Breed;
    String CoatColour;
    String Lactation;
    String MotherTag;
    String Remark;

    public Dairy(){

    }

    public Dairy(String dairyId, String dateOfBirth, String breed, String coatColour, String lactation, String motherTag, String remark) {
        DairyId = dairyId;
        DateOfBirth = dateOfBirth;
        Breed = breed;
        CoatColour = coatColour;
        Lactation = lactation;
        MotherTag = motherTag;
        Remark = remark;
    }

    public String getDairyId() {
        return DairyId;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public String getBreed() {
        return Breed;
    }

    public String getCoatColour() {
        return CoatColour;
    }

    public String getLactation() {
        return Lactation;
    }

    public String getMotherTag() {
        return MotherTag;
    }

    public String getRemark() {
        return Remark;
    }
}
