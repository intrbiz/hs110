package com.intrbiz.iot.hs110.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetDaystat extends HS110CallStatus
{
    @JsonProperty("day_list")
    private List<EnergyDay> dayList;

    public List<EnergyDay> getDayList() {
        return dayList;
    }

    public void setDayList(List<EnergyDay> dayList) {
        this.dayList = dayList;
    }
}
