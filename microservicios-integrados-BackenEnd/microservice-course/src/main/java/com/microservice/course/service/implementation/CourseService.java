package com.microservice.course.service.implementation;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.CourseDTO;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.exception.exception.DuplicateNumberCourseException;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.jpa.entity.CourseEntity;
import com.microservice.course.mapper.CourseMapper;
import com.microservice.course.repository.ICourseRepository;
import com.microservice.course.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final CourseMapper courseMapper;
    private final StudentClient studentClient;
    private final ICourseRepository iCourseRepository;


    @Override
    public List<CourseDTO> findAll() {
        return courseMapper.mapToDto((List<CourseEntity>) iCourseRepository.findAll());
    }

    @Override
    public CourseDTO findById(Long id) {
        return courseMapper.mapToDto(iCourseRepository.findById(id).orElse(new CourseEntity()));
    }

    @Override
    @Transactional
    public void save(CourseDTO courseDTO) {
        if (iCourseRepository.existsByNumberCourse(courseDTO.getNumberCourse())) {
            throw new DuplicateNumberCourseException("El número de curso " + courseDTO.getNumberCourse() + " esta registrado.", HttpStatus.BAD_REQUEST);
        }
        iCourseRepository.save(courseMapper.mapToEntity(courseDTO));
    }

    @Override
    @Transactional
    public void update(CourseDTO courseDTO) {
        //Verificar si el number_course ya existe
         if (iCourseRepository.existsByNumberCourse(courseDTO.getNumberCourse())) {
             iCourseRepository.save(courseMapper.mapToEntity(courseDTO));
         }else {
             throw new DuplicateNumberCourseException("Debe actualizar número de curso " + courseDTO.getNumberCourse() + " registrado.", HttpStatus.BAD_REQUEST);
         }
    }

    @Override
    public StudentByCourseResponse findStudentsByNumberCourse(Long numberCourse) {

        //busqueda de los datos del curso
        CourseEntity courseEntity = iCourseRepository.findByNumberCourse(numberCourse).orElse(new CourseEntity());

        //obtener los estudiantes del curso
        ResponseEntity<List<StudentDTO>> students = studentClient.findAllStudentByCourse(numberCourse);

        //construir el response
        return StudentByCourseResponse.builder()
                .courseName(courseEntity.getName())
                .teacher(courseEntity.getTeacher() == null ? "": courseEntity.getTeacher())
                .studentDTOList(students.getBody())
                .build();
    }

    @Override
    public void deleteById(Long id) {
        iCourseRepository.deleteById(id);
    }
}
