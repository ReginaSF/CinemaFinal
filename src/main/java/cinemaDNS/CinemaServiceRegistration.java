package cinemaDNS;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import S01Seat_Heating.Service01;

public class CinemaServiceRegistration {
	public static void main (String [] args ) throws InterruptedException {
		try {
	// Create a JmDNS instance
		JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	//Registering Service01. URL to obtain the service:
		ServiceInfo Service01_SeatHeating = ServiceInfo.create("_http._tcp.local.", 
                	"Service01_SeatHeating", 9091, "path=index.html");
		jmdns.registerService(Service01_SeatHeating);
		
		System.out.println("Service_Heating registered: "
		+ InetAddress.getLocalHost()+Service01_SeatHeating.getPort());
		
		//Start the service
		Service01.startS();

} catch (IOException e) {
    e.printStackTrace();

}
}
}

