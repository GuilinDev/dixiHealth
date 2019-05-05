package com.infrared.state.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "call_limit")
public class CallLimitEntity {
    @Id
    private String id;
    @Column
    private int limits;
    @Column(name = "group_ind")
    private String groupIndicator;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLimits() {
        return limits;
    }

    public void setLimit(int limits) {
        this.limits = limits;
    }

    public String getGroupIndicator() {
        return groupIndicator;
    }

    public void setGroupIndicator(String groupIndicator) {
        this.groupIndicator = groupIndicator;
    }
}
