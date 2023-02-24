package com.example.dbookk.entity;

public class Visitor {
    private String documentId;
   private String vis_id;
   private String vis_first_name;
    private String vis_last_name;
    private String vis_nfc_card;
    private String 	vis_IDNumber;
    private String time_stamp;
    private Long vis_phone;
    private String vis_type;
    private String vis_qr_code;

    public Visitor() {
    }

    public Visitor(String documentId,String vis_id, String vis_first_name, String vis_last_name, String vis_nfc_card, String vis_IDNumber, String time_stamp, Long vis_phone, String vis_type, String vis_qr_code) {
        this.documentId = documentId;
        this.vis_id = vis_id;
        this.vis_first_name = vis_first_name;
        this.vis_last_name = vis_last_name;
        this.vis_nfc_card = vis_nfc_card;
        this.vis_IDNumber = vis_IDNumber;
        this.time_stamp = time_stamp;
        this.vis_phone = vis_phone;
        this.vis_type = vis_type;
        this.vis_qr_code = vis_qr_code;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    public String getVis_id() {
        return vis_id;
    }

    public void setVis_id(String vis_id) {
        this.vis_id = vis_id;
    }

    public String getVis_first_name() {
        return vis_first_name;
    }

    public void setVis_first_name(String vis_first_name) {
        this.vis_first_name = vis_first_name;
    }

    public String getVis_last_name() {
        return vis_last_name;
    }

    public void setVis_last_name(String vis_last_name) {
        this.vis_last_name = vis_last_name;
    }

    public String getVis_nfc_card() {
        return vis_nfc_card;
    }

    public void setVis_nfc_card(String vis_nfc_card) {
        this.vis_nfc_card = vis_nfc_card;
    }

    public String getVis_IDNumber() {
        return vis_IDNumber;
    }

    public void setVis_IDNumber(String vis_IDNumber) {
        this.vis_IDNumber = vis_IDNumber;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public Long getVis_phone() {
        return vis_phone;
    }

    public void setVis_phone(Long vis_phone) {
        this.vis_phone = vis_phone;
    }

    public String getVis_type() {
        return vis_type;
    }

    public void setVis_type(String vis_type) {
        this.vis_type = vis_type;
    }

    public String getVis_qr_code() {
        return vis_qr_code;
    }

    public void setVis_qr_code(String vis_qr_code) {
        this.vis_qr_code = vis_qr_code;
    }
}
