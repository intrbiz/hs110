package com.intrbiz.iot.hs110;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.intrbiz.iot.hs110.model.GetRealtime;
import com.intrbiz.iot.hs110.model.HS110Response;

public class HS110Client
{
    private static final Charset ASCII = Charset.forName("ASCII");
    
    private static final byte KEY = (byte) 0xAB;
    
    private static final byte[] ON = encrypt("{\"system\":{\"set_relay_state\":{\"state\":1}}}");
    
    private static final byte[] OFF = encrypt("{\"system\":{\"set_relay_state\":{\"state\":0}}}");
    
    private static final byte[] SYSINFO = encrypt("{\"system\":{\"get_sysinfo\":{}}}");
    
    private static final byte[] EMETER = encrypt("{ \"emeter\":{ \"get_realtime\":null } }");
    
    private static final byte[] LED_ON = encrypt("{\"system\":{\"set_led_off\":{\"off\": 0}}}");
    
    private static final byte[] LED_OFF = encrypt("{\"system\":{\"set_led_off\":{\"off\": 1}}}");
    
    private String address;
    
    private int port = 9999;
    
    private final ObjectMapper mapper = new ObjectMapper();
    
    public HS110Client(String address)
    {
        this.address = address;
        // setup the JSON decoder
        this.mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        this.mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        this.mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // register response types
        this.mapper.registerSubtypes(HS110Response.class);
    }
    
    private <T> T parse(String input, Class<T> type) throws IOException
    {
        if (input == null) return null;
        System.out.println("Parsing: " + input);
        try (JsonParser p = this.mapper.getFactory().createParser(input))
        {
            return this.mapper.readValue(p, type);
        }
    }
    
    public byte[] send(byte[] message) throws Exception
    {
        try (Socket socket = new Socket(this.address, this.port))
        {
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            // write
            out.write(message);
            out.flush();
            // read
            byte[] buffer = new byte[4096];
            int r = in.read(buffer);
            if (r == -1) return null;
            byte[] ret = new byte[r];
            System.arraycopy(buffer, 0, ret, 0, r);
            return ret;
        }
    }
    
    public String sendMessage(String message) throws Exception
    {
        return decrypt(send(encrypt(message)));
    }
    
    public HS110Response setLEDState(boolean on) throws Exception
    {
        return parse(decrypt(send(on ? LED_ON : LED_OFF)), HS110Response.class);
    }
    
    public HS110Response ledOn() throws Exception
    {
        return parse(decrypt(send(LED_ON)), HS110Response.class);
    }
    
    public HS110Response ledOff() throws Exception
    {
        return parse(decrypt(send(LED_OFF)), HS110Response.class);
    }
    
    public HS110Response setRelayState(boolean on) throws Exception
    {
        return parse(decrypt(send(on ? ON : OFF)), HS110Response.class);
    }
    
    public HS110Response on() throws Exception
    {
        return parse(decrypt(send(ON)), HS110Response.class);
    }
    
    public HS110Response off() throws Exception
    {
        return parse(decrypt(send(OFF)), HS110Response.class);
    }
    
    public GetRealtime consumption() throws Exception
    {
        HS110Response response = parse(decrypt(send(EMETER)), HS110Response.class);
        if (response == null || response.getEmeter() == null || response.getEmeter().getRealtime() == null) 
            return null;
        return response.getEmeter().getRealtime();
    }
    
    public HS110Response sysInfo() throws Exception
    {
        return parse(decrypt(send(SYSINFO)), HS110Response.class);
    }
    
    private static byte[] encrypt(String message)
    {
        byte[] data = message.getBytes(ASCII);
        byte[] enc = new byte[data.length + 4];
        ByteBuffer.wrap(enc).putInt(data.length);
        System.arraycopy(data, 0, enc, 4, data.length);
        byte key = KEY;
        for (int i = 4; i < enc.length; i ++)
        {
            enc[i] = (byte) (enc[i] ^ key);
            key = enc[i];
        }
        return enc;
    }
    
    private static String decrypt(byte[] data)
    {
        if (data == null) return null;
        byte key = KEY;
        byte nextKey = 0;
        for (int i = 4; i < data.length; i++)
        {
            nextKey = data[i];
            data[i] = (byte) (data[i] ^ key);
            key = nextKey;
        }
        return new String(data, 4, data.length - 4, ASCII);
    }
    
    public static String toHex(byte[] b)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
        {
            if ((b[i] & 0xF0) == 0) sb.append("0");
            sb.append(Integer.toHexString(b[i] & 0xFF));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws Exception
    {
        HS110Client plug = new HS110Client("10.19.32.228");
        System.out.println(plug.sysInfo());
        System.out.println(plug.on());
        //
        for (int i = 0; i < 10; i++)
        {
            GetRealtime response = plug.consumption();
            System.out.println("Power: " + response.getPower() + "W, Total Consumption: " + response.getConsumption() + "kWh Current: " + response.getCurrent() + "A Voltage: " + response.getVoltage());
            Thread.sleep(5000);
        }
        //
        System.out.println(plug.ledOff());
        Thread.sleep(5000);
        System.out.println(plug.ledOn());
        Thread.sleep(5000);
        //
        System.out.println(plug.off());
        Thread.sleep(5000);
        System.out.println(plug.on());
        
    }
}
