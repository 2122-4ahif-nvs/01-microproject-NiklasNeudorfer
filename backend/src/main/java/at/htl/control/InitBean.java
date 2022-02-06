package at.htl.control;

import at.htl.entity.Device;
import at.htl.entity.Owner;
import at.htl.entity.Room;
import io.quarkus.logging.Log;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@ApplicationScoped
public class InitBean {

    @Inject
    DeviceRepository deviceRepository;

    @Inject
    RoomRepository roomRepository;

    void init(@Observes StartupEvent event) {
        Owner o = new Owner("Sysadmin", "HTBLA Leonding");

        Device d = new Device("Chromecast 4K", o, BigDecimal.valueOf(424.99));
        deviceRepository.save(d);

        int floor = 1;
        for (int i = 1; i < 100; i++){
            if (i%10 == 0){
                floor++;
            }
            Room r = new Room(i,floor, floor + " Stock ; ZimmerNr: " + i );
            roomRepository.save(r);
        }

    }
}
