package com.microservice.course.service;

import com.microservice.course.dto.CourseDTO;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<CourseDTO> findAll();

    CourseDTO findById(Long id);

    void save (CourseDTO course);

    void update(CourseDTO course);

    StudentByCourseResponse findStudentsByNumberCourse(Long numberCourse);

    void deleteById(Long id);
}
