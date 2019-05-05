package com.infrared.state.model;

public class Call {
    private int id;
    private String representative;
    private CallStatus status;
    private String reason;

    public Call(){}
    public Call(int id, String representative) {
        this.id = id;
        this.representative = representative;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public CallStatus getStatus() {
        return status;
    }

    public void setStatus(CallStatus status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Call[id=" + id + ", representative=" + representative
                + ", status=" + status + ", reason=" + reason + "]";
    }
}
