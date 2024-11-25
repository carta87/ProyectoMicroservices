package com.microservice.course.mapper;

import com.microservice.course.dto.CourseDTO;
import com.microservice.course.jpa.entity.CourseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-25T10:30:55-0500",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.40.0.z20241023-1306, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public List<CourseDTO> mapToDto(List<CourseEntity> courseEntityList) {
        if ( courseEntityList == null ) {
            return null;
        }

        List<CourseDTO> list = new ArrayList<CourseDTO>( courseEntityList.size() );
        for ( CourseEntity courseEntity : courseEntityList ) {
            list.add( mapToDto( courseEntity ) );
        }

        return list;
    }

    @Override
    public CourseDTO mapToDto(CourseEntity courseEntity) {
        if ( courseEntity == null ) {
            return null;
        }

        CourseDTO.CourseDTOBuilder courseDTO = CourseDTO.builder();

        courseDTO.id( courseEntity.getId() );
        courseDTO.name( courseEntity.getName() );
        courseDTO.numberCourse( courseEntity.getNumberCourse() );
        courseDTO.teacher( courseEntity.getTeacher() );

        return courseDTO.build();
    }

    @Override
    public CourseEntity mapToEntity(CourseDTO courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        CourseEntity.CourseEntityBuilder courseEntity = CourseEntity.builder();

        courseEntity.id( courseDTO.getId() );
        courseEntity.name( courseDTO.getName() );
        courseEntity.numberCourse( courseDTO.getNumberCourse() );
        courseEntity.teacher( courseDTO.getTeacher() );

        return courseEntity.build();
    }
}
