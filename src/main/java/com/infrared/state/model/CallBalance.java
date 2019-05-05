package com.infrared.state.model;

import java.util.Map;

public class CallBalance {
    private int groupBalance;
    private Map<String, Integer> representativeBalance;

    public int getGroupBalance() {
        return groupBalance;
    }

    public void setGroupBalance(int groupBalance) {
        this.groupBalance = groupBalance;
    }

    public Map<String, Integer> getRepresentativeBalance() {
        return representativeBalance;
    }

    public void setRepresentativeBalance(Map<String, Integer> representativeBalance) {
        this.representativeBalance = representativeBalance;
    }

    public void reduceGroupBalance() {
        groupBalance--;
    }
}
