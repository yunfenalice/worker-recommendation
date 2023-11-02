package com.beady.elastic.service;

import com.beady.elastic.model.Worker;
import com.beady.elastic.repo.WorkerRepo;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WorkerService {
    private final WorkerRepo workerRepo;
    @Autowired
    public WorkerService(WorkerRepo workerRepo){
        this.workerRepo=workerRepo;

    }
    public void updateWorker(String id,Map<String,String> newValues){
        Optional<Worker> worker = workerRepo.findById(id);


    }
    public void saveBulkWorker(){
        List<Worker> workers = generateRandomWorker(20000);
           workerRepo.saveAll(workers);
    }
    public List<Worker> generateRandomWorker(int count){
        List<Worker> workers = new ArrayList<>();
        Faker faker = new Faker();

        Random random = new Random();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < count; i++) {
            Worker worker = new Worker();
            worker.setId(String.valueOf(i + 1));
            worker.setName(faker.name().fullName());
            worker.setUsername(faker.name().username());
            worker.setEmail(faker.internet().emailAddress());
            worker.setPhone(faker.phoneNumber().phoneNumber());

            // Generate random skills (e.g., "Carpentry", "General Labor")
            String[] skills = {"Carpentry", "General Labor", "Plumbing", "Electrician", "Welding"};
            int randomSkillIndex = random.nextInt(skills.length);
            worker.setSkills(skills[randomSkillIndex]);

            // Generate random title
            worker.setTitle(faker.job().title());

            // Randomly set whether the worker has a vehicle
            worker.setHasVehicle(random.nextBoolean());

            // Generate a random available date within the next year
            int daysToAdd = random.nextInt(365);
            Date currentDate = new Date();
            Date availableDate = new Date(currentDate.getTime() + daysToAdd * 24 * 60 * 60 * 1000L);
            worker.setAvailable_date(availableDate);

            Worker.Address address = new Worker.Address();
            address.setStreet(faker.address().streetAddress());
            address.setSuite(faker.address().secondaryAddress());
            address.setCity(faker.address().city());
            address.setZipcode(faker.address().zipCode());

            Worker.GeoLocation geoLocation = new Worker.GeoLocation();
            geoLocation.setLat(Double.valueOf(faker.address().latitude()));
            geoLocation.setLng(Double.valueOf(faker.address().longitude()));
            address.setGeo(geoLocation);

            worker.setAddress(address);

            Worker.Company company = new Worker.Company();
            company.setName(faker.company().name());
            worker.setCompany(company);
            workers.add(worker);
        }

        return workers;
    }


}
