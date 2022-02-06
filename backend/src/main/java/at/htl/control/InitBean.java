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

    @Inject
    OwnerRepository ownerRepository;

    @Inject
    Logger LOG;

    void init(@Observes StartupEvent event) {

        readFile();

        Owner o = new Owner("Horst", "Meier");

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

    public void readFile(){
        try {
            var s = Files.lines(Paths.get("data.csv"));
            //String header = s.findFirst().get();

            s.map(l -> l.split(";"))
                    .skip(1) // skips the header line ("FirstName;LastName;....")
                    .map(l -> {
                        Owner o = new Owner();
                        o.setFirstName(l[0]);
                        o.setLastName(l[1]);
                        return o;
                    }).forEach(p -> {
                        ownerRepository.save(p);
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}