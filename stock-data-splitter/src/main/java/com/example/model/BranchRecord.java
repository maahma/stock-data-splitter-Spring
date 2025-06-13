package com.example.model;
import com.opencsv.bean.CsvBindByName;

public class BranchRecord {
    @CsvBindByName(column = "Branch")
    private String branch;

    @CsvBindByName(column = "NSC Model Code Calc")
    private String nscModelCodeCalc;
    
    @CsvBindByName(column = "Colour")
    private String colour;
    
    @CsvBindByName(column = "Confirmed Late Date")
    private String confirmedLateDate;
    
    @CsvBindByName(column = "Current Node")
    private String currentNode;
    
    @CsvBindByName(column = "Dealer Code")
    private String dealerCode;
    
    @CsvBindByName(column = "Dealer Name")
    private String dealerName;
    
    @CsvBindByName(column = "Final Delivery Dealer Addr")
    private String finalDeliveryDealerAddr;
    
    @CsvBindByName(column = "Final Delivery Dealer Code")
    private String finalDeliveryDealerCode;
    
    @CsvBindByName(column = "Financial Owner Category")
    private String financialOwnerCategory;
    
    @CsvBindByName(column = "Hold Damage")
    private String holdDamage;
    
    @CsvBindByName(column = "Model Group")
    private String modelGroup;
    
    @CsvBindByName(column = "Model Group Code")
    private String modelGroupCode;
    
    @CsvBindByName(column = "ModelVariant")
    private String modelvariant;
    
    @CsvBindByName(column = "NSCCode")
    private String nsccode;
    
    @CsvBindByName(column = "NSC Local Vehicle Code")
    private String nscLocalVehicleCode;
    
    @CsvBindByName(column = "Number of Records")
    private String numberOfRecords;
    
    @CsvBindByName(column = "Planned Offline Date")
    private String plannedOfflineDate;
    
    @CsvBindByName(column = "Revised Late Date")
    private String revisedLateDate;
    
    @CsvBindByName(column = "SecondaryFleetCode")
    private String secondaryfleetcode;
    
    @CsvBindByName(column = "Engine")
    private String engine;
    
    @CsvBindByName(column = "Transmission")
    private String transmission;
    
    @CsvBindByName(column = "Wheel Drive")
    private String wheelDrive;
    
    @CsvBindByName(column = "Trans Date")
    private String transDate;
    
    @CsvBindByName(column = "Veh Order Class Code")
    private String vehOrderClassCode;
    
    @CsvBindByName(column = "Veh Order Class Type Code")
    private String vehOrderClassTypeCode;
    
    @CsvBindByName(column = "Vehicle Scrap Date")
    private String vehicleScrapDate;
    
    @CsvBindByName(column = "Vin")
    private String vin;
    
    @CsvBindByName(column = "Latest Achievement Point")
    private String latestAchievementPoint;
    
    @CsvBindByName(column = "Prodn YYYYMM")
    private String prodnYyyymm;
    
    @CsvBindByName(column = "Order Number")
    private String orderNumber;
    
    @CsvBindByName(column = "Date Available")
    private String dateAvailable;
    
    @CsvBindByName(column = "Date Delivered")
    private String dateDelivered;
    
    @CsvBindByName(column = "Revised Delivery Date")
    private String revisedDeliveryDate;
    
    @CsvBindByName(column = "Latest Achievement Point Date")
    private String latestAchievementPointDate;
    
    @CsvBindByName(column = "Buyer Code")
    private String buyerCode;
}

