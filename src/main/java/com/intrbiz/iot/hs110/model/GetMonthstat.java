package com.intrbiz.iot.hs110.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetMonthstat extends HS110CallStatus
{
    @JsonProperty("month_list")
    private List<EnergyMonth> monthList;

    public List<EnergyMonth> getMonthList() {
        return monthList;
    }

    public void setMonthList(List<EnergyMonth> monthList) {
        this.monthList = monthList;
    }
}
