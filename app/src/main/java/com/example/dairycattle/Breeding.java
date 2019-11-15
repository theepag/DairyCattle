package com.example.dairycattle;

public class Breeding {
    
    String breedingId;
    String dateOfHeatSignObserved;
    String dateOfFirstArtificialInsemination;
    String dateOfSecondArtificialInsemination;
    String semanId;
    String veterinarianCode;
    String dateOfPD;
    String dateOfLastCalving;
    String nameOfTechnician;
    String numberOfCalving;
    String aiReceiptNo;

    public Breeding() {
    }

    public Breeding(String breedingId, String dateOfHeatSignObserved, String dateOfFirstArtificialInsemination, String dateOfSecondArtificialInsemination, String semanId, String veterinarianCode, String dateOfPD, String dateOfLastCalving, String nameOfTechnician, String numberOfCalving, String aiReceiptNo) {
        this.breedingId = breedingId;
        this.dateOfHeatSignObserved = dateOfHeatSignObserved;
        this.dateOfFirstArtificialInsemination = dateOfFirstArtificialInsemination;
        this.dateOfSecondArtificialInsemination = dateOfSecondArtificialInsemination;
        this.semanId = semanId;
        this.veterinarianCode = veterinarianCode;
        this.dateOfPD = dateOfPD;
        this.dateOfLastCalving = dateOfLastCalving;
        this.nameOfTechnician = nameOfTechnician;
        this.numberOfCalving = numberOfCalving;
        this.aiReceiptNo = aiReceiptNo;
    }

    public String getBreedingId() {
        return breedingId;
    }

    public void setBreedingId(String breedingId) {
        this.breedingId = breedingId;
    }

    public String getDateOfHeatSignObserved() {
        return dateOfHeatSignObserved;
    }

    public void setDateOfHeatSignObserved(String dateOfHeatSignObserved) {
        this.dateOfHeatSignObserved = dateOfHeatSignObserved;
    }

    public String getDateOfFirstArtificialInsemination() {
        return dateOfFirstArtificialInsemination;
    }

    public void setDateOfFirstArtificialInsemination(String dateOfFirstArtificialInsemination) {
        this.dateOfFirstArtificialInsemination = dateOfFirstArtificialInsemination;
    }

    public String getDateOfSecondArtificialInsemination() {
        return dateOfSecondArtificialInsemination;
    }

    public void setDateOfSecondArtificialInsemination(String dateOfSecondArtificialInsemination) {
        this.dateOfSecondArtificialInsemination = dateOfSecondArtificialInsemination;
    }

    public String getSemanId() {
        return semanId;
    }

    public void setSemanId(String semanId) {
        this.semanId = semanId;
    }

    public String getVeterinarianCode() {
        return veterinarianCode;
    }

    public void setVeterinarianCode(String veterinarianCode) {
        this.veterinarianCode = veterinarianCode;
    }

    public String getDateOfPD() {
        return dateOfPD;
    }

    public void setDateOfPD(String dateOfPD) {
        this.dateOfPD = dateOfPD;
    }

    public String getDateOfLastCalving() {
        return dateOfLastCalving;
    }

    public void setDateOfLastCalving(String dateOfLastCalving) {
        this.dateOfLastCalving = dateOfLastCalving;
    }

    public String getNameOfTechnician() {
        return nameOfTechnician;
    }

    public void setNameOfTechnician(String nameOfTechnician) {
        this.nameOfTechnician = nameOfTechnician;
    }

    public String getNumberOfCalving() {
        return numberOfCalving;
    }

    public void setNumberOfCalving(String numberOfCalving) {
        this.numberOfCalving = numberOfCalving;
    }

    public String getAiReceiptNo() {
        return aiReceiptNo;
    }

    public void setAiReceiptNo(String aiReceiptNo) {
        this.aiReceiptNo = aiReceiptNo;
    }
}
