package com.example.plannerz_backend.controller;

import com.example.plannerz_backend.dao.StudyGroupRepository;
import com.example.plannerz_backend.model.StudyGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor //생성자 주입
public class StudyGroupController {

    private final StudyGroupRepository groupRepository;

    @GetMapping("/api/studygroup")
    public List<StudyGroup> getAllGroup(){
        return groupRepository.findAll();
    }

    @PostMapping("/api/studygroup")
    public Object createStudyGroup(@RequestBody StudyGroup studyGroup){
        try{
            StudyGroup result = groupRepository.save(studyGroup);
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return new RuntimeException(e.getMessage());
        }
    }
}
