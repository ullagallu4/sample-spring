package com.subject.SubjectService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.subject.SubjectService.dto.SubjectDTO;
import com.subject.SubjectService.entity.Subject;
import com.subject.SubjectService.repo.SubjectRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubjectService {
	
	private SubjectRepo subjectRepo;
    private ModelMapper modelMapper;


	public SubjectDTO save(SubjectDTO subjectDTO) {
		// TODO Auto-generated method stub
		Subject subject = modelMapper.map(subjectDTO, Subject.class);
		return modelMapper.map(subjectRepo.save(subject),SubjectDTO.class);
	}


	public List<SubjectDTO> getSubjects() {
		// TODO Auto-generated method stub
        List<Subject> subjects = subjectRepo.findAll();
      return subjects.stream().map((subject) -> modelMapper.map(subject, SubjectDTO.class))
              .collect(Collectors.toList());
	}


	public SubjectDTO getSubjectByID(Integer id) {
		// TODO Auto-generated method stub
        Subject subject = subjectRepo.findById(id).get();
        //return UserMapper.mapToUserDto(user);
        return modelMapper.map(subject, SubjectDTO.class);
	}

}
