package com.intrbiz.iot.hs110.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HS110System
{
    @JsonProperty("set_relay_state")
    private SetRelayState relayState;
    
    @JsonProperty("get_sysinfo")
    private GetSysInfo sysInfo;
    
    @JsonProperty("set_led_off")
    private SetLEDOff ledOff;
    
    public HS110System()
    {
        super();
    }

    public SetRelayState getRelayState()
    {
        return relayState;
    }

    public void setRelayState(SetRelayState relayState)
    {
        this.relayState = relayState;
    }

    public GetSysInfo getSysInfo()
    {
        return sysInfo;
    }

    public void setSysInfo(GetSysInfo sysInfo)
    {
        this.sysInfo = sysInfo;
    }

    public SetLEDOff getLedOff()
    {
        return ledOff;
    }

    public void setLedOff(SetLEDOff ledOff)
    {
        this.ledOff = ledOff;
    }
}
