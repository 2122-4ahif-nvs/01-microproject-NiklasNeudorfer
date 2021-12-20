package at.htl.Control;

import at.htl.Entity.Device;
import at.htl.Entity.Room;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.LocalDate;

@ApplicationScoped
public class InitBean {

    @Inject
    DeviceRepository deviceRepository;

    @Inject
    RoomRepository roomRepository;

    void init(@Observes StartupEvent event) {
        Device d = new Device("Chromecast 4K");
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
