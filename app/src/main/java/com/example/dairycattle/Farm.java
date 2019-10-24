package com.example.dairycattle;

public class Farm {


    String FarmId;
    String FarmName;
    String FarmRegNo;
    String FarmOwner;
    String FarmDivision;
    String FarmAddress;
    String FarmContact;
    String FarmCattle;
    String FarmDairy;

    public Farm(){

    }

    public Farm(String farmId, String farmName, String farmRegNo, String farmOwner, String farmDivision, String farmAddress, String farmContact, String farmCattle, String farmDairy) {
        FarmId = farmId;
        FarmName = farmName;
        FarmRegNo = farmRegNo;
        FarmOwner = farmOwner;
        FarmDivision = farmDivision;
        FarmAddress = farmAddress;
        FarmContact = farmContact;
        FarmCattle = farmCattle;
        FarmDairy = farmDairy;
    }

    public String getFarmId() {
        return FarmId;
    }

    public String getFarmName() {
        return FarmName;
    }

    public String getFarmRegNo() {
        return FarmRegNo;
    }

    public String getFarmOwner() {
        return FarmOwner;
    }

    public String getFarmDivision() {
        return FarmDivision;
    }

    public String getFarmAddress() {
        return FarmAddress;
    }

    public String getFarmContact() {
        return FarmContact;
    }

    public String getFarmCattle() {
        return FarmCattle;
    }

    public String getFarmDairy() {
        return FarmDairy;
    }
}

