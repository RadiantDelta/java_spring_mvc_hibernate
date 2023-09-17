package ru.madbrains.spring_mvc.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.madbrains.spring_mvc.company.employer.Developer;
import ru.madbrains.spring_mvc.company.employer.Employee;
import ru.madbrains.spring_mvc.company.employer.ITRole;
import ru.madbrains.spring_mvc.company.employer.PM;
import ru.madbrains.spring_mvc.dto.CompanyDTO;
import ru.madbrains.spring_mvc.service.CompanyService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public CompanyDTO Company() {
        return CompanyDTO.from(companyService.getCompany());
    }

    @PostMapping("/employers/developers")
    public ResponseEntity addEmployer(@RequestBody Developer developer) {
        log.info("add developer");
        companyService.addDeveloper(developer);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/employers/PMs")
    public ResponseEntity addEmployer(@RequestBody PM pm) {
        companyService.addPM(pm);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/employers/{index}")
    public ResponseEntity<Employee<ITRole>> getEmployerByIndex(@PathVariable int index) {
        log.info("get employer by index = " +  index);
        try {

            return ResponseEntity.ok(companyService.getEmployerByIndex(index));
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/employers/find")
    public ResponseEntity<List<Employee<ITRole>>> getEmployerByRole(@RequestParam(name = "role") ITRole role) {
        log.info("get employer by role = " + role);

        return ResponseEntity.ok(companyService.getEmployersByRole(role));
    }
}
