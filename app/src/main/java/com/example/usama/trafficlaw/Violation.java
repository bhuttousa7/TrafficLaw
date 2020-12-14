package com.example.usama.trafficlaw;

import android.annotation.SuppressLint;

import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Violation  implements Serializable {
    private String TicketId, ViolationType, Location;
    private int Fine;
    private Timestamp violationDate;
    private Timestamp DueDate;

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    private String ImageUrl;
    private String Name;
    private String NumberPlate;
    private long Cnic;

    private int Speed;


    private long Phone;
    private String LicenceNo;
    private String City;

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    private String status;



    @SuppressLint("SimpleDateFormat")
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    Calendar c = Calendar.getInstance();


    public Violation(String ticketId, String violationType, String location, int amount, Timestamp violationDate, Timestamp dueDate, String status, String nPlate,
                     long cnic, String Licence, String City, String name, long phoneNumber, int speed ) {
        TicketId = ticketId;
        ViolationType = violationType;
        Speed = speed;
        Location = location;
        Fine = amount;
        this.violationDate = violationDate;
        this.DueDate = dueDate;
        this.NumberPlate = nPlate;
        this.Cnic = cnic;
        this.LicenceNo = Licence;
        this.City = City;
        this.status = status;
        this.Name = name;
        this.Phone = phoneNumber;
    }
    //Default Constructor for Firestore
    public Violation() {

    }



    //Constructor For Dummy Data
    //Some Dummy Data For User which can be changed
    public Violation(String ticketID, String name, int speed, Timestamp duedate, String numplate, String violationtype, int fine, String location)
    {
        this.TicketId = ticketID;
        this.Name = name;
        this.Speed = speed;
        this.DueDate = duedate;
        this.NumberPlate = numplate;
        this.ViolationType = violationtype;
        this.Fine = fine;
        this.Location = location;
        this.Phone = 923327132;
        this.Cnic = 433204324;
        this.LicenceNo = "AV034214";
        this.City = "Karachi";
        this.status= "Failed";
        this.violationDate = null;

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

    public int getFine() {
        return Fine;
    }

    public void setFine(int fine) {
        Fine = fine;
    }

    public Timestamp getViolationDate() {
        return violationDate;
    }

    public void setViolationDate(Timestamp violationDate) {
        this.violationDate = violationDate;
    }

    public Timestamp getDueDate() {
        return DueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.DueDate = dueDate;
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
        return NumberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.NumberPlate = numberPlate;
    }

    public long getCnic() {
        return Cnic;
    }

    public void setCnic(long cnic) {
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
    public long getPhone() {
        return Phone;
    }

    public void setPhone(long phone) {
        Phone = phone;
    }
}
