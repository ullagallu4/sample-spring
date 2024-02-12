package com.subject.SubjectService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
	private Integer subId;
	private String subName;
	private String subAddress;
}
