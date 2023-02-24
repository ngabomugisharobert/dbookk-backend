package com.example.dbookk.entity;

public class Movement {
    private String documentId;
    private String visitor_id;
    private String MovementType;
    private String mv_time;
    private int guard_id;
    private String transportType;
    private String vehicle_plate;
    private int gate_id;
    private String mv_id;

    private String vis_name = null;

    private String guard_name = null;

    public Movement() {
    }

    public Movement(String documentId, String visitor_id, String movementType, String mv_time, int guard_id, String transportType, String vehicle_plate, int gate_id, String mv_id) {
        this.documentId = documentId;
        this.visitor_id = visitor_id;
        MovementType = movementType;
        this.mv_time = mv_time;
        this.guard_id = guard_id;
        this.transportType = transportType;
        this.vehicle_plate = vehicle_plate;
        this.gate_id = gate_id;
        this.mv_id = mv_id;
    }

    public String getGuard_name() {
        return guard_name;
    }

    public void setGuard_name(String guard_name) {
        this.guard_name = guard_name;
    }
    public String getVis_name() {
        return vis_name;
    }

    public void setVis_name(String vis_name) {
        this.vis_name = vis_name;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getVisitor_id() {
        return visitor_id;
    }

    public void setVisitor_id(String visitor_id) {
        this.visitor_id = visitor_id;
    }

    public String getMovementType() {
        return MovementType;
    }

    public void setMovementType(String movementType) {
        MovementType = movementType;
    }

    public String getMv_time() {
        return mv_time;
    }

    public void setMv_time(String mv_time) {
        this.mv_time = mv_time;
    }

    public int getGuard_id() {
        return guard_id;
    }

    public void setGuard_id(int guard_id) {
        this.guard_id = guard_id;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getVehicle_plate() {
        return vehicle_plate;
    }

    public void setVehicle_plate(String vehicle_plate) {
        this.vehicle_plate = vehicle_plate;
    }

    public int getGate_id() {
        return gate_id;
    }

    public void setGate_id(int gate_id) {
        this.gate_id = gate_id;
    }

    public String getMv_id() {
        return mv_id;
    }

    public void setMv_id(String mv_id) {
        this.mv_id = mv_id;
    }
}
