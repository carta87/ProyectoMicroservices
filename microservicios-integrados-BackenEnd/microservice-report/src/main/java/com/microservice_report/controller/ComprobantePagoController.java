package com.microservice_report.controller;

import com.microservice_report.dto.StudentDTO;
import com.microservice_report.service.IComprobantePagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/reports")
public class ComprobantePagoController {

    private final IComprobantePagoService iComprobantePagoService;

    @PostMapping(path = "/comprobantePago")
    public ResponseEntity<byte[]> reporteComprobante(@RequestBody StudentDTO studentDTO) {
       return iComprobantePagoService.generarReporteComprobantePago(studentDTO);
    }
}
