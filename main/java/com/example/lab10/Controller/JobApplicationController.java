package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/application")
@RequiredArgsConstructor
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getJobApplication() {
        List<JobApplication> applications = jobApplicationService.getAllJobApplications();
        return ResponseEntity.ok(applications);
    }

    @PostMapping("/add")
    public ResponseEntity addJobApplication(@RequestBody JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        jobApplicationService.addJobApplication(jobApplication);
        return ResponseEntity.status(201).body(new ApiResponse("jobApplication added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJobApplication(@PathVariable Integer id, @RequestBody JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdated = jobApplicationService.updateJobApplication(id, jobApplication);
        if (isUpdated) {
            return ResponseEntity.status(201).body(new ApiResponse("jobApplication updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("jobApplication not updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobApplication(@PathVariable Integer id) {
        boolean isDeleted = jobApplicationService.deleteJobApplication(id);
        if (isDeleted) {
            return ResponseEntity.status(201).body(new ApiResponse("jobApplication deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("jobApplication not deleted"));
    }
}
