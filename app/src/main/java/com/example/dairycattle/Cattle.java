package com.example.dairycattle;

public class Cattle {


    String CattleId;
    String CattleFarmID;
    String CattleDateOfBirth;
    String CattleBreed;
    String CattleSpecialFeature;
    String CattleSex;
    String CattleNoOfLactation;
    String CattleBirthWeight;
    String BreedingWeight;
    String CattleWeaningWeight;
    String CattleAveragePreWeaningGrowthRate;
    String CattleAveragePostWeaningGrowthRate;

    String CattleLastCalvingDate;

    public Cattle() {

    }

    public Cattle(String cattleId, String cattleFarmID, String cattleDateOfBirth, String cattleBreed, String cattleSpecialFeature, String cattleSex, String cattleNoOfLactation, String cattleBirthWeight, String breedingWeight, String cattleWeaningWeight, String cattleAveragePreWeaningGrowthRate, String cattleAveragePostWeaningGrowthRate, String cattleLastCalvingDate) {
        CattleId = cattleId;
        CattleFarmID = cattleFarmID;
        CattleDateOfBirth = cattleDateOfBirth;
        CattleBreed = cattleBreed;
        CattleSpecialFeature = cattleSpecialFeature;
        CattleSex = cattleSex;
        CattleNoOfLactation = cattleNoOfLactation;
        CattleBirthWeight = cattleBirthWeight;
        BreedingWeight = breedingWeight;
        CattleWeaningWeight = cattleWeaningWeight;
        CattleAveragePreWeaningGrowthRate = cattleAveragePreWeaningGrowthRate;
        CattleAveragePostWeaningGrowthRate = cattleAveragePostWeaningGrowthRate;
        CattleLastCalvingDate = cattleLastCalvingDate;
    }

    public String getCattleId() {
        return CattleId;
    }

    public String getCattleFarmID() {
        return CattleFarmID;
    }

    public String getCattleDateOfBirth() {
        return CattleDateOfBirth;
    }

    public String getCattleBreed() {
        return CattleBreed;
    }

    public String getCattleSpecialFeature() {
        return CattleSpecialFeature;
    }

    public String getCattleSex() {
        return CattleSex;
    }

    public String getCattleNoOfLactation() {
        return CattleNoOfLactation;
    }

    public String getCattleBirthWeight() {
        return CattleBirthWeight;
    }

    public String getBreedingWeight() {
        return BreedingWeight;
    }

    public String getCattleWeaningWeight() {
        return CattleWeaningWeight;
    }

    public String getCattleAveragePreWeaningGrowthRate() {
        return CattleAveragePreWeaningGrowthRate;
    }

    public String getCattleAveragePostWeaningGrowthRate() {
        return CattleAveragePostWeaningGrowthRate;
    }

    public String getCattleLastCalvingDate() {
        return CattleLastCalvingDate;
    }

    public void setCattleId(String cattleId) {
        CattleId = cattleId;
    }

    public void setCattleFarmID(String cattleFarmID) {
        CattleFarmID = cattleFarmID;
    }

    public void setCattleDateOfBirth(String cattleDateOfBirth) {
        CattleDateOfBirth = cattleDateOfBirth;
    }

    public void setCattleBreed(String cattleBreed) {
        CattleBreed = cattleBreed;
    }

    public void setCattleSpecialFeature(String cattleSpecialFeature) {
        CattleSpecialFeature = cattleSpecialFeature;
    }

    public void setCattleSex(String cattleSex) {
        CattleSex = cattleSex;
    }

    public void setCattleNoOfLactation(String cattleNoOfLactation) {
        CattleNoOfLactation = cattleNoOfLactation;
    }

    public void setCattleBirthWeight(String cattleBirthWeight) {
        CattleBirthWeight = cattleBirthWeight;
    }

    public void setBreedingWeight(String breedingWeight) {
        BreedingWeight = breedingWeight;
    }

    public void setCattleWeaningWeight(String cattleWeaningWeight) {
        CattleWeaningWeight = cattleWeaningWeight;
    }

    public void setCattleAveragePreWeaningGrowthRate(String cattleAveragePreWeaningGrowthRate) {
        CattleAveragePreWeaningGrowthRate = cattleAveragePreWeaningGrowthRate;
    }

    public void setCattleAveragePostWeaningGrowthRate(String cattleAveragePostWeaningGrowthRate) {
        CattleAveragePostWeaningGrowthRate = cattleAveragePostWeaningGrowthRate;
    }

    public void setCattleLastCalvingDate(String cattleLastCalvingDate) {
        CattleLastCalvingDate = cattleLastCalvingDate;
    }
}
