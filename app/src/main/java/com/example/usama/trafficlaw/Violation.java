package com.example.usama.trafficlaw;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Violation {
    private String TicketId, ViolationType, Location;
    private int Amount;
    private Date violationDate, dueDate;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public Violation(String ticketId, String violationType, String location, int amount, Date violationDate, Date dueDate) {
        TicketId = ticketId;
        ViolationType = violationType;
        Location = location;
        Amount = amount;
        this.violationDate = violationDate;
        this.dueDate = dueDate;
    }
    //Default Constructor for Sample Data and Testing
    public Violation() {
        TicketId = "ABC1234";
        ViolationType = "Red Light Violation";
        Location = null;
        Amount = 500;
        this.violationDate =  new Date();
        this.dueDate = new Date();

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

    public Date getViolationDate() {
        return violationDate;
    }

    public void setViolationDate(Date violationDate) {
        this.violationDate = violationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }
}
