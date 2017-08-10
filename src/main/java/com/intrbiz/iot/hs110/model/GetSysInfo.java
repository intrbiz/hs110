package com.intrbiz.iot.hs110.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetSysInfo extends HS110CallStatus
{
    @JsonProperty("sw_ver")
    private String softwareVersion;
    
    @JsonProperty("hw_ver")
    private String hardwareVersion;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("model")
    private String model;
    
    @JsonProperty("mac")
    private String macAddress;
    
    @JsonProperty("deviceId")
    private String deviceId;
    
    @JsonProperty("hwId")
    private String hardwareId;
    
    @JsonProperty("fwId")
    private String firmwareId;
    
    @JsonProperty("oemId")
    private String oemId;
    
    @JsonProperty("alias")
    private String alias;
    
    @JsonProperty("dev_name")
    private String deviceName;
    
    @JsonProperty("icon_hash")
    private String iconHash;
    
    @JsonProperty("relay_state")
    private int relayState;
    
    @JsonProperty("on_time")
    private long onTime;
    
    @JsonProperty("active_mode")
    private String activeMode;
    
    @JsonProperty("feature")
    private String feature;
    
    @JsonProperty("updating")
    private int updating;
    
    @JsonProperty("rssi")
    private int rssi;
    
    @JsonProperty("led_off")
    private int ledOff;
    
    @JsonProperty("latitude")
    private double latitude;
    
    @JsonProperty("longitude")
    private double longitude;
    
    public GetSysInfo()
    {
        super();
    }

    public String getSoftwareVersion()
    {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion)
    {
        this.softwareVersion = softwareVersion;
    }

    public String getHardwareVersion()
    {
        return hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion)
    {
        this.hardwareVersion = hardwareVersion;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getMacAddress()
    {
        return macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getHardwareId()
    {
        return hardwareId;
    }

    public void setHardwareId(String hardwareId)
    {
        this.hardwareId = hardwareId;
    }

    public String getFirmwareId()
    {
        return firmwareId;
    }

    public void setFirmwareId(String firmwareId)
    {
        this.firmwareId = firmwareId;
    }

    public String getOemId()
    {
        return oemId;
    }

    public void setOemId(String oemId)
    {
        this.oemId = oemId;
    }

    public String getAlias()
    {
        return alias;
    }

    public void setAlias(String alias)
    {
        this.alias = alias;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getIconHash()
    {
        return iconHash;
    }

    public void setIconHash(String iconHash)
    {
        this.iconHash = iconHash;
    }

    public int getRelayState()
    {
        return relayState;
    }

    public void setRelayState(int relayState)
    {
        this.relayState = relayState;
    }

    public long getOnTime()
    {
        return onTime;
    }

    public void setOnTime(long onTime)
    {
        this.onTime = onTime;
    }

    public String getActiveMode()
    {
        return activeMode;
    }

    public void setActiveMode(String activeMode)
    {
        this.activeMode = activeMode;
    }

    public String getFeature()
    {
        return feature;
    }

    public void setFeature(String feature)
    {
        this.feature = feature;
    }

    public int getUpdating()
    {
        return updating;
    }

    public void setUpdating(int updating)
    {
        this.updating = updating;
    }

    public int getRssi()
    {
        return rssi;
    }

    public void setRssi(int rssi)
    {
        this.rssi = rssi;
    }

    public int getLedOff()
    {
        return ledOff;
    }

    public void setLedOff(int ledOff)
    {
        this.ledOff = ledOff;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }
}
