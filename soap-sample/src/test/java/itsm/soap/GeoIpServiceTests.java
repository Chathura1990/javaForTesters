package itsm.soap;

import com.lavasoft.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class GeoIpServiceTests {

    @Test
    public void testMyIp(){
        GeoIPService ipService = new GeoIPService();
        GeoIPServiceSoap geoIPServiceSoap = ipService.getGeoIPServiceSoap();
        String geoIp = geoIPServiceSoap.getIpLocation("192.168.31.84");
        System.out.println(geoIp);
    }
}
