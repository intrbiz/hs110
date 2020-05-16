
import com.intrbiz.iot.hs110.HS110Client;
import com.intrbiz.iot.hs110.model.GetRealtime;

public class Example {

    public static void main(String[] args) throws Exception
    {
        HS110Client plug = new HS110Client("172.30.4.139");
        plug.sysInfo();
        plug.on();
        //
        for (int i = 0; i < 10; i++)
        {
            GetRealtime response = plug.consumption();
            System.out.println("Power: " + response.getPower() + "W, Total Consumption: " + response.getConsumption() + "kWh Current: " + response.getCurrent() + "A Voltage: " + response.getVoltage());
            Thread.sleep(5000);
        }
        //
        plug.ledOff();
        Thread.sleep(5000);
        plug.ledOn();
        Thread.sleep(5000);
        //
        plug.off();
        Thread.sleep(5000);
        plug.on();
    }

}
