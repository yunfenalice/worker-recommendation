package com.beady.elastic.service;

import com.beady.elastic.model.Project;
import com.beady.elastic.model.Worker;
import com.beady.elastic.repo.ProjectRepo;
import com.beady.elastic.repo.WorkerRepo;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
@Service
public class ProjectService {
    private final WorkerRepo workerRepo;
    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectService(WorkerRepo workerRepo,ProjectRepo projectRepo) {
        this.workerRepo = workerRepo;
        this.projectRepo=projectRepo;

    }
   public void saveBulkProject(){
       List<Project> projects=generateRandomProject(100);
       projectRepo.saveAll(projects);
   }
    public List<Project> generateRandomProject(int count) {
        Faker faker = new Faker();
        List<Project> projects = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            Project project = new Project();
            project.setId(Integer.toString(i));
            project.setName(faker.name().fullName());
            project.setSupervisor(faker.name().fullName());
            project.setProjectName(generateProjectName(faker));
            project.setRequirements(faker.lorem().sentence(100)+ " " +generateProjectName(faker));
            project.setStartDate(faker.date().future(20, TimeUnit.DAYS));
            project.setEndDate(faker.date().future(365, TimeUnit.DAYS));
            project.setAssignWorker(workerRepo.findById(String.valueOf(faker.number().numberBetween(1, 10001))).get()); // Assuming Worker class is defined
            project.setAddress(new Project.Address(
                    faker.address().streetAddress(),
                    faker.address().buildingNumber(),
                    faker.address().city(),
                    faker.address().zipCode(),
                    new Project.GeoLocation(Double.valueOf(faker.address().latitude()), Double.valueOf(faker.address().longitude()))
            ));
            project.setSite_rating(faker.number().randomDouble(1, 1, 5));
            project.setCompany(new Project.Company(faker.company().name()));
            projects.add(project);


        }
        return projects;

    }

    private String generateProjectName(Faker faker) {
        // Generate a project name using keywords related to worker skills
        String[] keywords = {"Construction", "Building", "Renovation", "Contracting", "Labor", "Development", "Engineering"};
        return keywords[faker.random().nextInt(keywords.length)] + " Project";
    }

    public List<Worker> findWorker(String projectId) {
        Optional<Project> project = projectRepo.findById(projectId);
        List<Worker> batchWorker=new ArrayList<>();
         workerRepo.findAll().forEach(worker -> batchWorker.add(worker));
         return batchWorker;

    }
}
