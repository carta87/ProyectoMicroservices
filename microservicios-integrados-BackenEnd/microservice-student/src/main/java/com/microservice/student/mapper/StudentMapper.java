package com.microservice.student.mapper;

import com.microservice.student.dto.AttendantDTO;
import com.microservice.student.dto.StudentDTO;
import com.microservice.student.jpa.entity.AttendantEntity;
import com.microservice.student.jpa.entity.StudentEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    List<StudentDTO> mapToDto(List<StudentEntity> studentEntities);

    StudentDTO mapToDto(StudentEntity studentEntity);

    StudentEntity mapToEntity(StudentDTO studentDTO);

    AttendantDTO mapToDto(AttendantEntity attendantEntity);


}
