package com.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.Prescription;
import com.spring.service.PrescriptionService;

@Controller
public class PrescriptionController {

	@Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/dashboard")
    public String dashboard(Model model,
        @RequestParam(value="start", required=false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate start,
        @RequestParam(value="end", required=false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate end) {

        if(start == null) start = LocalDate.now().withDayOfMonth(1);
        if(end == null) end = LocalDate.now();
        List<Prescription> list = prescriptionService.findByDateRange(start, end);
        model.addAttribute("prescriptions", list);
        return "dashboard";
    }
 

    @GetMapping("/add-prescription")
    public String addPrescriptionForm(Model model){
        model.addAttribute("prescription", new Prescription());
        return "add-prescription";
    }

    @PostMapping("/add-prescription")
    public String savePrescription(@ModelAttribute Prescription prescription){
        prescriptionService.save(prescription);
        return "redirect:/dashboard";
    }

    @GetMapping("/edit-prescription/{id}")
    public String editForm(@PathVariable Long id, Model model){
        model.addAttribute("prescription", prescriptionService.findAll().stream()
            .filter(p->p.getId().equals(id))
            .findFirst().orElse(null));
        return "edit-prescription";
    }

    @PostMapping("/edit-prescription")
    public String updatePrescription(@ModelAttribute Prescription prescription){
        prescriptionService.save(prescription);
        return "redirect:/dashboard";
    }

    @GetMapping("/delete-prescription/{id}")
    public String deletePrescription(@PathVariable Long id){
        prescriptionService.delete(id);
        return "redirect:/dashboard";
    }
    
    @GetMapping("/daily-report")
    public String dailyReport(Model model) {
        Map<String, Long> datewiseCount = prescriptionService.getPrescriptionCountByDate();
        model.addAttribute("report", datewiseCount);
        return "daily-report";
    }
  
}
