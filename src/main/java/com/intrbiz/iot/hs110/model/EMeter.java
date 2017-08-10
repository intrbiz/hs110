package com.intrbiz.iot.hs110.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EMeter
{
    @JsonProperty("get_realtime")
    private GetRealtime realtime;
    
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
}
