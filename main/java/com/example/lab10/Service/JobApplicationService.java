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
    private final JopPostRepository jopPostRepository;
    private final UserRepository userRepository;
    
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    public String addJobApplication(JobApplication jobApplication) {
        if(jopPostRepository.getById(jobApplication.getPostId())!= null && userRepository.getById(jobApplication.getUserId())!=null) {
            jobApplicationRepository.save(jobApplication);
            return "Job Application Added Successfully";
        }
        
            return "Job Application Not Added Successfully";   
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
