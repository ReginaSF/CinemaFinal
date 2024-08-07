package cinemaDNS;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import S01Seat_Heating.Service01;
import S02Seat_Water.service02;
import S03Cinema_Lights.service03;
import S04Cinema_Admission.service04;
import S05Drink_Catalog.service05;
import S06Food_Payment.service06;

public class CinemaServiceRegistration {
    public static void main(String[] args) throws InterruptedException {
        try {
            // Declaring the JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Registering Service01
            ServiceInfo Service01_SeatHeating = ServiceInfo.create("_grpc._tcp.local.",
                    "Service01_SeatHeating" , 9091, "path=index.html");
            jmdns.registerService(Service01_SeatHeating);

            System.out.println("Service01_Heating registered: "
                    + InetAddress.getLocalHost() + " Port:" + Service01_SeatHeating.getPort());

            // Registering Service02
            ServiceInfo Service02_SeatWater = ServiceInfo.create("_grpc._tcp.local.",
                    "Service02_SeatWater" , 50051, "path=index.html");
            jmdns.registerService(Service02_SeatWater);

            System.out.println("Service02_Water registered: "
                    + InetAddress.getLocalHost() + " Port:" + Service02_SeatWater.getPort());

            // Registering Service03
            ServiceInfo Service03_CinemaLights = ServiceInfo.create("_grpc._tcp.local.",
                    "Service03_CinemaLights" , 50052, "path=index.html");
            jmdns.registerService(Service03_CinemaLights);

            System.out.println("Service03_CinemaLights registered: "
                    + InetAddress.getLocalHost() + " Port:" + Service03_CinemaLights.getPort());

            // Registering Service04
            ServiceInfo Service04Cinema_Admission = ServiceInfo.create("_grpc._tcp.local.",
                    "Service04Cinema_Admission" , 50053, "path=index.html");
            jmdns.registerService(Service04Cinema_Admission);

            System.out.println("Service04Cinema_Admission registered: "
                    + InetAddress.getLocalHost() + " Port:" + Service04Cinema_Admission.getPort());

            // Registering Service05
            ServiceInfo Service05Drink_Catalog = ServiceInfo.create("_grpc._tcp.local.",
                    "Service05Drink_Catalog ", 50054, "path=index.html");
            jmdns.registerService(Service05Drink_Catalog);

            System.out.println("Service05Drink_Catalog registered: "
                    + InetAddress.getLocalHost() + " Port:" + Service05Drink_Catalog.getPort());

            // Registering Service06
            ServiceInfo Service06Food_Payment = ServiceInfo.create("_grpc._tcp.local.",
                    "Service06Food_Payment ", 9090, "path=index.html");
            jmdns.registerService(Service06Food_Payment);

            System.out.println("Service06Food_Payment registered: "
                    + InetAddress.getLocalHost() + " Port:" + Service06Food_Payment.getPort());

            // Starting each service in a separate thread:
            new Thread(() -> {
                try {
                    Service01.main(args);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try { 
                	service02.main(args);
                	} catch (Exception e) {
                    e.printStackTrace(); 
                    }}).start();

            new Thread(() -> {
                try {
                    service03.main(args);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    service04.main(args);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    service05.main(args);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    service06.main(args);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
