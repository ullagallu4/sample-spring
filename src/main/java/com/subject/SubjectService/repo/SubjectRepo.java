package com.subject.SubjectService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subject.SubjectService.entity.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {

}
