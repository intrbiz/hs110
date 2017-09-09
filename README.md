# HS110

This is a very simple Java client to control the HS110 TP Link WiFi Smart Plugs.

## Example

One example using the library:


``` java 

import com.intrbiz.iot.hs110.HS110Client;
import com.intrbiz.iot.hs110.model.GetRealtime;

public class Example {

    public static void main(String[] args) throws Exception {

        HS110Client plug = new HS110Client("10.19.32.228");
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
```

## License

HS110 Client
Copyright (c) 2017, Chris Ellis
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met: 

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer. 
2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution. 

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.


## Author

Chris Ellis

Twitter: @intrbiz

Web: intrbiz.com

Copyright (c) Chris Ellis 2017
