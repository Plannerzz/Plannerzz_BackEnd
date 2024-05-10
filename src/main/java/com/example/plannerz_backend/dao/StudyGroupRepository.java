package com.example.plannerz_backend.dao;

import com.example.plannerz_backend.model.StudyGroup;
import com.example.plannerz_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {

}
