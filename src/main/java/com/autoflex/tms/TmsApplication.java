package com.autoflex.tms;

import com.autoflex.tms.entities.Bug;
import com.autoflex.tms.entities.Status;
import com.autoflex.tms.repositories.BugRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmsApplication.class, args);
    }

    @Bean()
    CommandLineRunner init(BugRepository bugRepository){
        return args -> {
            Bug firstB = new Bug("smell code", true, true, "pzdc", "777");
            Bug secondB = new Bug("smell code2", false, true, "pzdc2", "777");
            Bug secondBB = new Bug("smell code2", true, true, "pzdc2", "777");
            Bug thirdB = new Bug("smell code3", true, false, "pzdc3", "779");

            bugRepository.save(firstB);
            bugRepository.save(secondB);
            bugRepository.save(secondBB);
            bugRepository.save(thirdB);


            List<Bug> bugs = bugRepository.findByStatusAndUrgent(Status.NEW, true);
            List<Bug> bugs2 = bugRepository.findByUrgentAndDetectedVersion(true, "777");
            List<Bug> bugs3 = bugRepository.findByUrgentAndImportantAndDetectedVersion(false, true, "777");


            for (Bug b : bugs2) {
                System.out.println(b);
            }
        };
    }

}
