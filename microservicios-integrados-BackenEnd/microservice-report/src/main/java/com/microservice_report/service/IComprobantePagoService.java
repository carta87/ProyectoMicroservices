package com.microservice_report.service;

import com.microservice_report.dto.StudentDTO;
import org.springframework.http.ResponseEntity;

public interface IComprobantePagoService {

    ResponseEntity<byte[]> generarReporteComprobantePago(StudentDTO studentDTO);
}
