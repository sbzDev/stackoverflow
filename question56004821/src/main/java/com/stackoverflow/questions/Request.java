package com.stackoverflow.questions;

import java.util.Date;

public class Request {
    private Status status;
    private Date date;
    private int numDays;

    public Status getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }
}
