package com.efarmkart.app.service.darkHubService;

import com.efarmkart.app.repository.darkHubRepository.ComplaintRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.efarmkart.app.model.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import com.efarmkart.app.model.darkHubModel.*;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepo complaintRepo;

    // Create a new complaint
    public Complaint registerComplaint(Complaint complaint) {
        complaint.setStatus("OPEN");
        complaint.setCreatedAt(LocalDateTime.now());
        return complaintRepo.save(complaint);
    }

    // Get all complaints
    public List<Complaint> getAllComplaints() {
        return complaintRepo.findAll();
    }

    // Get complaint by ID
    public Optional<Complaint> getComplaintById(Long id) {
        return complaintRepo.findById(id);
    }

    // Update complaint status
    public Complaint updateComplaintStatus(Long id, String newStatus) {
        Optional<Complaint> optionalComplaint = complaintRepo.findById(id);
        if (optionalComplaint.isPresent()) {
            Complaint complaint = optionalComplaint.get();
            complaint.setStatus(newStatus.toUpperCase());
            return complaintRepo.save(complaint);
        } else {
            throw new RuntimeException("Complaint not found with ID: " + id);
        }
    }

    // Delete complaint
    public void deleteComplaint(Long id) {
        if (!complaintRepo.existsById(id)) {
            throw new RuntimeException("Complaint not found");
        }
        complaintRepo.deleteById(id);
    }

    // Get complaints by status
    public List<Complaint> getComplaintsByStatus(String status) {
        return complaintRepo.findByStatusIgnoreCase(status);
    }

    // Custom escalation logic
    public Complaint escalateComplaint(Long id, String reason) {
        Complaint complaint = complaintRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setStatus("ESCALATED");
        complaint.setDescription(complaint.getDescription() + "\n[Escalated Reason]: " + reason);
        return complaintRepo.save(complaint);
    }
}