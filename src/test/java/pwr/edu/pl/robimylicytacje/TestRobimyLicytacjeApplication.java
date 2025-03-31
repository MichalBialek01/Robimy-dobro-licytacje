package pwr.edu.pl.robimylicytacje;

import org.springframework.boot.SpringApplication;

public class TestRobimyLicytacjeApplication {

    public static void main(String[] args) {
        SpringApplication.from(RobimyLicytacjeApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
