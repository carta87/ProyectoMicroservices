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
    date = "2024-11-06T14:04:00-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
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

        studentDTO.id( studentEntity.getId() );
        studentDTO.name( studentEntity.getName() );
        studentDTO.lastName( studentEntity.getLastName() );
        studentDTO.email( studentEntity.getEmail() );
        studentDTO.courseNumber( studentEntity.getCourseNumber() );
        studentDTO.attendant( mapToDto( studentEntity.getAttendant() ) );

        return studentDTO.build();
    }

    @Override
    public StudentEntity mapToEntity(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        StudentEntity.StudentEntityBuilder studentEntity = StudentEntity.builder();

        studentEntity.id( studentDTO.getId() );
        studentEntity.name( studentDTO.getName() );
        studentEntity.lastName( studentDTO.getLastName() );
        studentEntity.email( studentDTO.getEmail() );
        studentEntity.courseNumber( studentDTO.getCourseNumber() );
        studentEntity.attendant( attendantDTOToAttendantEntity( studentDTO.getAttendant() ) );

        return studentEntity.build();
    }

    @Override
    public AttendantDTO mapToDto(AttendantEntity attendantEntity) {
        if ( attendantEntity == null ) {
            return null;
        }

        AttendantDTO.AttendantDTOBuilder attendantDTO = AttendantDTO.builder();

        attendantDTO.id( attendantEntity.getId() );
        attendantDTO.name( attendantEntity.getName() );
        attendantDTO.lastName( attendantEntity.getLastName() );
        attendantDTO.email( attendantEntity.getEmail() );

        return attendantDTO.build();
    }

    protected AttendantEntity attendantDTOToAttendantEntity(AttendantDTO attendantDTO) {
        if ( attendantDTO == null ) {
            return null;
        }

        AttendantEntity.AttendantEntityBuilder attendantEntity = AttendantEntity.builder();

        attendantEntity.id( attendantDTO.getId() );
        attendantEntity.name( attendantDTO.getName() );
        attendantEntity.lastName( attendantDTO.getLastName() );
        attendantEntity.email( attendantDTO.getEmail() );

        return attendantEntity.build();
    }
}
