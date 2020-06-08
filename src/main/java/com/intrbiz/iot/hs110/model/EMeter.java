package com.intrbiz.iot.hs110.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EMeter
{
    @JsonProperty("get_realtime")
    private GetRealtime realtime;

    @JsonProperty("get_monthstat")
    private GetMonthstat monthstat;

    @JsonProperty("get_daystat")
    private GetDaystat daystat;
    
    public EMeter()
    {
        super();
    }

    public GetRealtime getRealtime()
    {
        return realtime;
    }

    public void setRealtime(GetRealtime realtime)
    {
        this.realtime = realtime;
    }

    public GetMonthstat getMonthstat() {
        return monthstat;
    }

    public void setMonthstat(GetMonthstat monthstat) {
        this.monthstat = monthstat;
    }

    public GetDaystat getDaystat() {
        return daystat;
    }

    public void setDaystat(GetDaystat daystat) {
        this.daystat = daystat;
    }
}
