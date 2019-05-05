package com.infrared.state.model;

import java.util.List;

public class CallInfo {
    private List<Call> calls;
    private int numOfAccepted;
    private int numOfSkipped;

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }

    public int getNumOfAccepted() {
        return numOfAccepted;
    }

    public int getNumOfSkipped() {
        return numOfSkipped;
    }

    //Calls设置的变化
    public void increaseNumOfAccepted() {
        numOfAccepted++;
    }
    public void increaseNumOfSkipped() {
        numOfSkipped++;
    }
}
