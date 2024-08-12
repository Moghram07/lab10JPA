package com.example.lab10.Service;

import com.example.lab10.Model.JobPost;
import com.example.lab10.Repository.JopPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JopPostRepository jopPostRepository;

    public List<JobPost> getAllJobPosts() {
        return jopPostRepository.findAll();
    }

    public void addJobPost(JobPost jobPost) {
        jopPostRepository.save(jobPost);
    }

    public boolean removeJobPost(Integer id) {
        JobPost jobPost = jopPostRepository.getById(id);
        if(jobPost == null) {
            return false;
        }
        jopPostRepository.delete(jobPost);
        return true;
    }

    public boolean updateJobPost(Integer id, JobPost jobPost) {
        JobPost j = jopPostRepository.getById(id);
        if(j == null) {
            return false;
        }
        j.setTitle(jobPost.getTitle());
        j.setDescreption(jobPost.getDescreption());
        j.setPostingDate(jobPost.getPostingDate());
        j.setLocation(jobPost.getLocation());
        j.setSalary(jobPost.getSalary());

        jopPostRepository.save(jobPost);
        return true;
    }
}
