package com.example.dbookk.entity;

public class Movements {

    private String visitor_id;
    private String check_in;
    private String check_out;
    private String duration;
    private String visitor_name;
    private String shift;
    public int status;
    public Movements() {
    }

    public Movements(String visitor_id, String check_in, String check_out, String duration, String visitor_name, String shift, int status) {
        this.visitor_id = visitor_id;
        this.check_in = check_in;
        this.check_out = check_out;
        this.duration = duration;
        this.visitor_name = visitor_name;
        this.shift = shift;
        this.status = status;
    }

    public String getVisitor_id() {
        return visitor_id;
    }

    public void setVisitor_id(String visitor_id) {
        this.visitor_id = visitor_id;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }


    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
