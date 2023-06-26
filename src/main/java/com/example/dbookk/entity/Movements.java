package com.example.dbookk.entity;

public class Movements {

    private String visitor_id;
    private String check_in;
    private String check_in_gate;
    private String check_out;
    private String check_out_gate;
    private String duration;
    private String visitor_name;
    private String shift;
    public int status;
    public String employee_type;
    public String comment = "";
    public String editor ="";
    public Movements() {
    }

    public Movements(String visitor_id, String check_in, String check_in_gate, String check_out, String check_out_gate, String duration, String visitor_name, String shift, int status, String employee_type, String comment, String editor) {
        this.visitor_id = visitor_id;
        this.check_in = check_in;
        this.check_in_gate = check_in_gate;
        this.check_out = check_out;
        this.check_out_gate = check_out_gate;
        this.duration = duration;
        this.visitor_name = visitor_name;
        this.shift = shift;
        this.status = status;
        this.employee_type = employee_type;
        this.comment = comment;
        this.editor = editor;
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

    public String getEmployee_type() {
        return employee_type;
    }
    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public String getCheck_in_gate() {
        return check_in_gate;
    }

    public void setCheck_in_gate(String check_in_gate) {
        this.check_in_gate = check_in_gate;
    }

    public String getCheck_out_gate() {
        return check_out_gate;
    }

    public void setCheck_out_gate(String check_out_gate) {
        this.check_out_gate = check_out_gate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
}
