package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Repository.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;

    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    public void addJobApplication(JobApplication jobApplication) {
        jobApplicationRepository.save(jobApplication);
    }

    public boolean deleteJobApplication(Integer id) {
        JobApplication jobApplication = jobApplicationRepository.getById(id);
        if(jobApplication == null){
            return false;
        }
        jobApplicationRepository.delete(jobApplication);
        return true;
    }

    public boolean updateJobApplication(Integer id, JobApplication jobApplication) {
        JobApplication j = jobApplicationRepository.getById(id);
        if(j == null){
            return false;
        }
        j.setUserId(jobApplication.getUserId());

        jobApplicationRepository.save(j);
        return true;
    }
}
