package com.example.dbookk.entity;

public class Guard {

    private String documentId;
    private String gua_first_name;
    private String gua_last_name;
    private Long gua_phone;
    private String gua_address;
    private String gua_email;
    private int gua_id;
    private String time_stamp;

    private String gua_username;

    public Guard() {
    }

    public Guard(String documentId, String gua_first_name, String gua_last_name, Long gua_phone, String gua_address, String gua_email, int gua_id, String time_stamp, String gua_username) {
        this.documentId = documentId;
        this.gua_first_name = gua_first_name;
        this.gua_last_name = gua_last_name;
        this.gua_phone = gua_phone;
        this.gua_address = gua_address;
        this.gua_email = gua_email;
        this.gua_id = gua_id;
        this.time_stamp = time_stamp;
        this.gua_username = gua_username;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getGua_first_name() {
        return gua_first_name;
    }

    public void setGua_first_name(String gua_first_name) {
        this.gua_first_name = gua_first_name;
    }

    public String getGua_last_name() {
        return gua_last_name;
    }

    public void setGua_last_name(String gua_last_name) {
        this.gua_last_name = gua_last_name;
    }

    public Long getGua_phone() {
        return gua_phone;
    }

    public void setGua_phone(Long gua_phone) {
        this.gua_phone = gua_phone;
    }

    public String getGua_address() {
        return gua_address;
    }

    public void setGua_address(String gua_address) {
        this.gua_address = gua_address;
    }

    public String getGua_email() {
        return gua_email;
    }

    public void setGua_email(String gua_email) {
        this.gua_email = gua_email;
    }

    public int getGua_id() {
        return gua_id;
    }

    public void setGua_id(int gua_id) {
        this.gua_id = gua_id;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getGua_username() {
        return gua_username;
    }

    public void setGua_username(String gua_username) {
        this.gua_username = gua_username;
    }
}
