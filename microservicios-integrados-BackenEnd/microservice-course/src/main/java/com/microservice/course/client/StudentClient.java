package com.microservice.course.client;

import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "micro-service-student", url = "https://web-microservices-students-d8dsfwhnhjecgwd3.centralus-01.azurewebsites.net")
public interface StudentClient {

    @GetMapping(path = "/student/search-by-course/{idCourse}")
    ResponseEntity<List<StudentDTO>> findAllStudentByCourse(@PathVariable Long idCourse);
}
