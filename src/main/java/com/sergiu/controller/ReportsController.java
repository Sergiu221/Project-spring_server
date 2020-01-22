package com.sergiu.controller;

import com.sergiu.dto.ReportCandidatesDTO;
import com.sergiu.dto.ReportHallsDTO;
import com.sergiu.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@CrossOrigin
@RestController
public class ReportsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportsController.class);
    @Autowired
    private ReportService reportService;


    @GetMapping("/report")
    public ResponseEntity<Resource> report() throws IOException {

        File file = reportService.generateReport();

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=candidati.pdf")
                .body(resource);
    }

    @PostMapping("reports/candidates")
    public ResponseEntity<Resource> getReportsWithCandidates(@Valid @RequestBody ReportCandidatesDTO reportCandidatesDTO) throws FileNotFoundException {

        LOGGER.info("Start generate report for candidates!");
        File file = reportService.generateReportCandidates(reportCandidatesDTO);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=candidati.pdf")
                .body(resource);
    }

    @PostMapping("reports/halls")
    public ResponseEntity<Resource> getReportsWithHalls(@Valid @RequestBody ReportHallsDTO hallsDTO) throws FileNotFoundException {

        LOGGER.info("Start generate report for candidates!");
        File file = reportService.generateReportHalls(hallsDTO);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=sali.pdf")
                .body(resource);
    }

    @GetMapping("reports/general_list_distributed")
    public ResponseEntity<Resource> buildGeneralListDistributedReport() throws FileNotFoundException {

        LOGGER.info("Start generate report for GeneralListDistributedReport!");
        File file = reportService.buildGeneralListDistributedReport();

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .body(resource);
    }

    @GetMapping("reports/candidates_without_exam")
    public ResponseEntity<Resource> buildCandidatesListWithoutExam() throws FileNotFoundException {

        LOGGER.info("Start generate report for CandidatesListWithoutExam!");
        File file = reportService.buildCandidatesListWithoutExam();
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .body(resource);
    }

    @GetMapping("reports/candidates_from_hall/{hallId}")
    public ResponseEntity<Resource> buildCandidatesListWithoutExam(@PathVariable Integer hallId) throws FileNotFoundException {

        File file = reportService.buildCandidatesListFromHall(hallId);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .body(resource);
    }
}
