package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobPost")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getJobPost() {
         List<JobPost> jobPost = jobPostService.getAllJobPosts();
         return ResponseEntity.ok(jobPost);
    }

    @PostMapping("/add")
    public ResponseEntity addJobPost(@RequestBody @Valid JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        jobPostService.addJobPost(jobPost);

        return ResponseEntity.status(200).body(new ApiResponse("jobPost added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJobPost(@PathVariable Integer id, @RequestBody @Valid JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdated = jobPostService.updateJobPost(id, jobPost);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse( "job post updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("jobPost not updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobPost(@PathVariable Integer id) {
        boolean isDeleted = jobPostService.removeJobPost(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("jobPost deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("jobPost not deleted"));
    }
}
