package com.subject.SubjectService.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subject.SubjectService.dto.SubjectDTO;
import com.subject.SubjectService.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	private SubjectService subjectService;
	
	

	public SubjectController(SubjectService subjectService) {
		super();
		this.subjectService = subjectService;
	}


    @PostMapping("/save")
	public SubjectDTO save(@RequestBody SubjectDTO subjectDTO) {
		return subjectService.save(subjectDTO);
		
	}
    
    @GetMapping("/get")
	public List<SubjectDTO> getAll() {
		return subjectService.getSubjects();
		
	}
    
    @GetMapping("/get/{id}")
 	public SubjectDTO fetchByID(@PathVariable ("id") Integer id) {
 		return subjectService.getSubjectByID(id);
 		
 	}
}
