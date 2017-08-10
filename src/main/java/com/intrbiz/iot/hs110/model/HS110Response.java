package com.intrbiz.iot.hs110.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HS110Response
{
    @JsonProperty("system")
    private HS110System system;
    
    @JsonProperty("emeter")
    private EMeter emeter;
    
    public HS110Response()
    {
        super();
    }

    public EMeter getEmeter()
    {
        return emeter;
    }

    public void setEmeter(EMeter emeter)
    {
        this.emeter = emeter;
    }

    public HS110System getSystem()
    {
        return system;
    }

    public void setSystem(HS110System system)
    {
        this.system = system;
    }
}
