package com.example.hostelmanagementsystem.model;

import com.example.hostelmanagementsystem.enums.ApplicationStatus;
import java.util.Date;

public class HostelApplication {

    private String applicationId;        // Firebase key
    private String studentId;            // FK → Student
    private String requestedRoomId;      // FK → Room

    private Long submissionDate;
    private ApplicationStatus status;

    private int semester;
    private float cgpa;
    private String parentContact;
    private String emergencyContact;

    private String rejectionReason;
    private Long approvalDate;

    // 🔹 REQUIRED for Firebase
    public HostelApplication() {
    }

    // 🔹 Constructor used by submitApplication(...)
    public HostelApplication(
            String applicationId,
            String studentId,
            String roomId
    ) {
        this.applicationId = applicationId;
        this.studentId = studentId;
        this.requestedRoomId = roomId;

        this.status = ApplicationStatus.PENDING;
        this.submissionDate = System.currentTimeMillis();

        this.rejectionReason = null;
        this.approvalDate = null;
    }


    // =====================
    // Getters & Setters
    // =====================

    public String getApplicationId() { return applicationId; }
    public void setApplicationId(String applicationId) { this.applicationId = applicationId; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getRequestedRoomId() { return requestedRoomId; }
    public void setRequestedRoomId(String requestedRoomId) { this.requestedRoomId = requestedRoomId; }

    // For Firebase - returns Long
    public Long getSubmissionDate() {
        return submissionDate;
    }
    public void setSubmissionDate(Long submissionDate) {
        this.submissionDate = submissionDate;
    }

    // Helper method for getting Date object (not used by Firebase)
    public Date getSubmissionDateAsDate() {
        return submissionDate != null ? new Date(submissionDate) : null;
    }

    public ApplicationStatus getStatus() { return status; }
    public void setStatus(ApplicationStatus status) { this.status = status; }

    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }

    public float getCgpa() { return cgpa; }
    public void setCgpa(float cgpa) { this.cgpa = cgpa; }

    public String getParentContact() { return parentContact; }
    public void setParentContact(String parentContact) { this.parentContact = parentContact; }

    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

    public String getRejectionReason() { return rejectionReason; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }

    // For Firebase - returns Long
    public Long getApprovalDate() {
        return approvalDate;
    }
    public void setApprovalDate(Long approvalDate) {
        this.approvalDate = approvalDate;
    }

    // Helper method for getting Date object (not used by Firebase)
    public Date getApprovalDateAsDate() {
        return approvalDate != null ? new Date(approvalDate) : null;
    }

    // =====================
    // Domain Logic (UML)
    // =====================

    public boolean validateEligibility() {
        return cgpa >= 2.0;
    }

    public void updateStatus(ApplicationStatus status) {
        this.status = status;
        if (status == ApplicationStatus.APPROVED) {
            this.approvalDate = System.currentTimeMillis();
        }
    }

    public void setRejection(String reason) {
        this.status = ApplicationStatus.REJECTED;
        this.rejectionReason = reason;
    }
}
