package com.microservice.student.client;

import com.microservice.student.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "micro-service-report", url = "http://micro-service-report:8091")
public interface ReporteClient {

    @PostMapping(path = "reports/comprobantePago")
    ResponseEntity<byte[]> reporteComprobante(@RequestBody StudentDTO studentDTO);
}
