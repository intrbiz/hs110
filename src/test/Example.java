
import com.intrbiz.iot.hs110.HS110Client;
import com.intrbiz.iot.hs110.model.GetRealtime;

/**
 * Created by intrbiz on 9/9/17.
 */
public class Example {

    public static void main(String[] args) throws Exception {

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
