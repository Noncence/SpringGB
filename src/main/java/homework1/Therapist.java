package homework1;

import org.springframework.stereotype.Component;

@Component("Specialist")
public class Therapist implements Specialist{
    public void direct() {
        System.out.println("Выдано направление к терапевту");
    }
}
