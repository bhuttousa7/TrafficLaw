package com.example.usama.trafficlaw;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Violation {
    private String TicketId, ViolationType, Location;
    private int Amount;
    private String violationDate;
    private String dueDate;

    private String Name;
    private String numberPlate;
    private String Cnic;




    private String Phone;
    private String LicenceNo;
    private String City;

    private String status;
    @SuppressLint("SimpleDateFormat")
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public Violation(String ticketId, String violationType, String location, int amount, String violationDate, String dueDate, String status, String nPlate,
                     String cnic, String Licence, String City, String name,String phoneNumber) {
        TicketId = ticketId;
        ViolationType = violationType;
        Location = location;
        Amount = amount;
        this.violationDate = violationDate;
        this.dueDate = dueDate;
        this.numberPlate = nPlate;
        this.Cnic = cnic;
        this.LicenceNo = Licence;
        this.City = City;
        this.status = status;
        this.Name = name;
        this.Phone = phoneNumber;
    }
    //Default Constructor for Sample Data and Testing
    public Violation() {
        TicketId = "ABC1234";
        ViolationType = "Red Light Violation";
        Location = "Defence View";
        Amount = 500;
        this.Name = "Default";
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        String datetime = dateformat.format(c.getTime());
        this.violationDate = datetime;
        this.dueDate = datetime;
        this.status= "Failed";
        this.numberPlate = "AVC-871";
        this.Cnic = "43304-98711515-5";
        this.LicenceNo = "AV034214";
        this.City = "Karachi";
        this.Phone = "+92332-2718432";
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTicketId() {
        return TicketId;
    }

    public void setTicketId(String ticketId) {
        TicketId = ticketId;
    }

    public String getViolationType() {
        return ViolationType;
    }

    public void setViolationType(String violationType) {
        ViolationType = violationType;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getViolationDate() {
        return violationDate;
    }

    public void setViolationDate(String violationDate) {
        this.violationDate = violationDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getCnic() {
        return Cnic;
    }

    public void setCnic(String cnic) {
        Cnic = cnic;
    }

    public String getLicenceNo() {
        return LicenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        LicenceNo = licenceNo;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
