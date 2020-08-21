package homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Registry")
public class Registry {

        private Specialist specialist;

        public Specialist getSpecialist(){
            return specialist;
        }

        @Autowired()
        @Qualifier("Specialist")
        public void setSpecialist(Specialist specialist) {
            this.specialist = specialist;
        }

        public void issue_direction() {
            System.out.println("Направление выдано");
            specialist.direct();
        }
}

