package com.intrbiz.iot.hs110.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetRealtime extends HS110CallStatus
{
    // V1 HW
    @JsonProperty("current")
    private Double currentA;
    
    @JsonProperty("voltage")
    private Double voltageV;
    
    @JsonProperty("power")
    private Double powerW;
    
    @JsonProperty("total")
    private Double consumptionkWh;
    
    // V2 HW
    
    @JsonProperty("current_ma")
    private Double currentma;


    @JsonProperty("voltage_mv")
    private Double voltagemv;


    @JsonProperty("power_mw")
    private Double powermw;


    @JsonProperty("total_wh")
    private Double consumptionwh;
    
    public GetRealtime()
    {
        super();
    }
    
    // normalised accessors
    
    @JsonIgnore
    public double getCurrent()
    {
        return this.currentA != null ? this.currentA : this.currentma != null ? this.currentma / 1000.0D : 0D;
    }
    
    @JsonIgnore
    public double getVoltage()
    {
        return this.voltageV != null ? this.voltageV : this.voltagemv != null ? this.voltagemv / 1000.0D : 0D;
    }
    
    @JsonIgnore
    public double getPower()
    {
        return this.powerW != null ? this.powerW : this.powermw != null ? this.powermw / 1000.0D : 0D;
    }
    
    @JsonIgnore
    public double getConsumption()
    {
        return this.consumptionkWh != null ? this.consumptionkWh : this.consumptionwh != null ? this.consumptionwh / 1000.0D : 0D;
    }
    
    // HW V1

    public Double getCurrentA()
    {
        return this.currentA;
    }

    public void setCurrentA(Double currentA)
    {
        this.currentA = currentA;
    }
    
    public Double getVoltageV()
    {
        return this.voltageV;
    }

    public void setVoltageV(Double voltageV)
    {
        this.voltageV = voltageV;
    }

    public Double getPowerW()
    {
        return this.powerW;
    }

    public void setPowerW(Double powerW)
    {
        this.powerW = powerW;
    }

    public Double getConsumptionkWh()
    {
        return this.consumptionkWh;
    }

    public void setConsumptionkWh(Double consumptionkWh)
    {
        this.consumptionkWh = consumptionkWh;
    }
    
    // HW V2

    public Double getCurrentma()
    {
        return this.currentma;
    }

    public void setCurrentma(Double currentma)
    {
        this.currentma = currentma;
    }

    public Double getVoltagemv()
    {
        return this.voltagemv;
    }

    public void setVoltagemv(Double voltagemv)
    {
        this.voltagemv = voltagemv;
    }

    public Double getPowermw()
    {
        return this.powermw;
    }

    public void setPowermw(Double powermw)
    {
        this.powermw = powermw;
    }

    public Double getConsumptionwh()
    {
        return this.consumptionwh;
    }

    public void setConsumptionwh(Double consumptionwh)
    {
        this.consumptionwh = consumptionwh;
    }
}
