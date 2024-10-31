package com.microservice.student.mapper;

import com.microservice.student.dto.AttendantDTO;
import com.microservice.student.dto.StudentDTO;
import com.microservice.student.jpa.entity.AttendantEntity;
import com.microservice.student.jpa.entity.StudentEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-31T12:33:20-0500",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public List<StudentDTO> mapToDto(List<StudentEntity> studentEntities) {
        if ( studentEntities == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>( studentEntities.size() );
        for ( StudentEntity studentEntity : studentEntities ) {
            list.add( mapToDto( studentEntity ) );
        }

        return list;
    }

    @Override
    public StudentDTO mapToDto(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        StudentDTO.StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.attendant( mapToDto( studentEntity.getAttendant() ) );
        studentDTO.courseNumber( studentEntity.getCourseNumber() );
        studentDTO.email( studentEntity.getEmail() );
        studentDTO.id( studentEntity.getId() );
        studentDTO.lastName( studentEntity.getLastName() );
        studentDTO.name( studentEntity.getName() );

        return studentDTO.build();
    }

    @Override
    public StudentEntity mapToEntity(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        StudentEntity.StudentEntityBuilder studentEntity = StudentEntity.builder();

        studentEntity.attendant( attendantDTOToAttendantEntity( studentDTO.getAttendant() ) );
        studentEntity.courseNumber( studentDTO.getCourseNumber() );
        studentEntity.email( studentDTO.getEmail() );
        studentEntity.id( studentDTO.getId() );
        studentEntity.lastName( studentDTO.getLastName() );
        studentEntity.name( studentDTO.getName() );

        return studentEntity.build();
    }

    @Override
    public AttendantDTO mapToDto(AttendantEntity attendantEntity) {
        if ( attendantEntity == null ) {
            return null;
        }

        AttendantDTO.AttendantDTOBuilder attendantDTO = AttendantDTO.builder();

        attendantDTO.email( attendantEntity.getEmail() );
        attendantDTO.id( attendantEntity.getId() );
        attendantDTO.lastName( attendantEntity.getLastName() );
        attendantDTO.name( attendantEntity.getName() );

        return attendantDTO.build();
    }

    protected AttendantEntity attendantDTOToAttendantEntity(AttendantDTO attendantDTO) {
        if ( attendantDTO == null ) {
            return null;
        }

        AttendantEntity.AttendantEntityBuilder attendantEntity = AttendantEntity.builder();

        attendantEntity.email( attendantDTO.getEmail() );
        attendantEntity.id( attendantDTO.getId() );
        attendantEntity.lastName( attendantDTO.getLastName() );
        attendantEntity.name( attendantDTO.getName() );

        return attendantEntity.build();
    }
}
