package com.microservice_report.service.implementation;

import com.microservice_report.dto.StudentDTO;
import com.microservice_report.service.IComprobantePagoService;
import com.microservice_report.utils.ConstantesReportes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
@RequiredArgsConstructor
public class ComprobantePagoService implements IComprobantePagoService {
    @Override
    public ResponseEntity<byte[]> generarReporteComprobantePago(StudentDTO studentDTO) {

        int numeroComprobante = 1245;
        numeroComprobante++;

        String nombreArchivo ="comprobantePago";

        String filePath =
                ConstantesReportes.PATH_ORIGIN_PRINCIPAL
                        + nombreArchivo+ ".jrxml";

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ConstantesReportes.DATE_FECHA_HORA);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put(ConstantesReportes.NUMERO_COMPRONBANTE, String.valueOf(numeroComprobante));
        parameters.put(ConstantesReportes.FECHA_COMPRONBANTE, formatter.format(date));
        parameters.put(ConstantesReportes.VALOR_PAGADO, new BigDecimal(30000));
        parameters.put(ConstantesReportes.MEDIO_PAGO, "Efectivo");
        parameters.put(ConstantesReportes.NOMBRE_ALUMNO, studentDTO.getName() + " " + studentDTO.getLastName());
        parameters.put(ConstantesReportes.NOMBRE_ACUDIENTE, studentDTO.getAttendant().getName() + " " + studentDTO.getAttendant().getLastName());
        parameters.put(ConstantesReportes.IMAGEN_DIR, ConstantesReportes.PATH_IMAGENES);

        /*try {
            JasperReport report = JasperCompileManager.compileReport(filePath);
            JasperPrint print =  print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(print, destinationPath);
            return ConstantesReportes.REPORTE_EXITOSO;
        } catch (JRException e) {
            return ConstantesReportes.REPORTE_FALLIDO;
        }*/
        try {
            JasperReport report = JasperCompileManager.compileReport(filePath);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(print, byteArrayOutputStream);
            byte[] pdfBytes = byteArrayOutputStream.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=" +
                    nombreArchivo+studentDTO.getName() + studentDTO.getLastName() +".pdf");

            log.info(ConstantesReportes.REPORTE_EXITOSO);
            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (JRException e) {
            log.error(ConstantesReportes.REPORTE_FALLIDO, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}