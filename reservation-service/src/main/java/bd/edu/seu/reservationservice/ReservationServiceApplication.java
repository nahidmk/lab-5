package bd.edu.seu.reservationservice;

import bd.edu.seu.reservationservice.Exception.ResourceAlreadyExistException;
import bd.edu.seu.reservationservice.service.DummyData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReservationServiceApplication {

    public static void main(String[] args) throws ResourceAlreadyExistException {
        ConfigurableApplicationContext run = SpringApplication.run(ReservationServiceApplication.class, args);
//        DummyData bean = run.getBean(DummyData.class);
//        bean.saveData();
    }

}
