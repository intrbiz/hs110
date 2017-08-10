package com.intrbiz.iot.hs110.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetRealtime extends HS110CallStatus
{
    @JsonProperty("current")
    private double current;
    
    @JsonProperty("voltage")
    private double voltage;
    
    @JsonProperty("power")
    private double power;
    
    @JsonProperty("total")
    private double consumption;
    
    public GetRealtime()
    {
        super();
    }

    public double getCurrent()
    {
        return current;
    }

    public void setCurrent(double current)
    {
        this.current = current;
    }

    public double getVoltage()
    {
        return voltage;
    }

    public void setVoltage(double voltage)
    {
        this.voltage = voltage;
    }

    public double getPower()
    {
        return power;
    }

    public void setPower(double power)
    {
        this.power = power;
    }

    public double getConsumption()
    {
        return consumption;
    }

    public void setConsumption(double consumption)
    {
        this.consumption = consumption;
    }
}
