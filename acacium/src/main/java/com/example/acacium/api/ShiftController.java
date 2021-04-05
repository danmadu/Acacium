package com.example.acacium.api;

import com.example.acacium.model.Shift;
import com.example.acacium.service.ShiftService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

// Model >> DAO/Interface >> Data Access Service >> Service >> Controller

@RestController
public class ShiftController {
    private final ShiftService shiftService;

    @Autowired
    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @PostMapping("/upload-shift-csvfile")
    public void uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload");
            model.addAttribute("status", false);
        } else {
            // parse CSV file to create a list of Shift objects
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                List<Shift> shifts = new CsvToBeanBuilder(reader)
                        .withType(Shift.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build()
                        .parse();
                // insert list of shifts into insertMultipleShifts function in shift service
                this.shiftService.insertMultipleShifts(shifts);
                System.out.println(Arrays.toString(this.shiftService.retrieveAllShifts().toArray()));

                model.addAttribute("shifts", shifts);
                model.addAttribute("status", true);
            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }
    }

    @GetMapping("/get-shifts")
    public List<Shift> retrieveShifts() {
        // retrieves all shifts
        return this.shiftService.retrieveAllShifts();
    }
}
