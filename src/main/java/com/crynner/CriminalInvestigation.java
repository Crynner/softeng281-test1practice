package com.crynner;

import java.util.HashMap;

public class CriminalInvestigation {
    public static int totalCases = 0;

    public CriminalInvestigation() {
    }

    public void addCase(String caseId, String victimName, String suspectName, String crimeType) {
    }

    public void updateCaseStatus(String caseId, String status) {
    }

    public String getCaseDetails(String caseId) {
        return "";
    }

    public static int getTotalCases() {
        return 0;
    }

    public static void resetTotalCases() {
        totalCases = 0;
    }
}

class Case {

    public Case(String caseId, String victimName, String suspectName, String crimeType) {
        // Implement constructor
    }

    // Getters and setters
    public String getCaseId() {
        return "";
    }

    public String getVictimName() {
        return "";
    }

    public String getSuspectName() {
        return "";
    }

    public String getStatus() {
        return "";
    }

    public String getCrimeType() {
        return "";
    }

    public void setStatus(String status) {
    }
}

