
import com.intrbiz.iot.hs110.HS110Client;
import com.intrbiz.iot.hs110.model.GetRealtime;

public class Example {

    public static void main(String[] args) throws Exception
    {
        HS110Client plug1 = new HS110Client("172.30.4.139");
        HS110Client plug2 = new HS110Client("172.30.4.140");
        
        System.out.println(plug1.sysInfo());
        System.out.println(plug2.sysInfo());
        
        plug1.on();
        plug2.on();
        
        for (int i = 0; i < 10; i++)
        {
            GetRealtime response1 = plug1.consumption();
            System.out.println("Power: " + response1.getPower() + "W, Total Consumption: " + response1.getConsumption() + "kWh, Current: " + response1.getCurrent() + "A, Voltage: " + response1.getVoltage() + "V");
            GetRealtime response2 = plug2.consumption();
            System.out.println("Power: " + response2.getPower() + "W, Total Consumption: " + response2.getConsumption() + "kWh, Current: " + response2.getCurrent() + "A, Voltage: " + response2.getVoltage() + "V");
            Thread.sleep(5000);
        }
        //
        plug1.ledOff();
        Thread.sleep(5000);
        plug1.ledOn();
        Thread.sleep(5000);
        //
        plug1.off();
        Thread.sleep(5000);
        plug1.on();
    }

}
