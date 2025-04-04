package com.crynner;

import java.util.HashMap;

public class CriminalInvestigation {
    public static int totalCases = 0;
    HashMap<String, Case> cases = new HashMap<>();

    public CriminalInvestigation() {
    }

    public void addCase(String caseId, String victimName, String suspectName, String crimeType) {
        if (!cases.keySet().contains(caseId)){
            cases.put(caseId, new Case(caseId, victimName, suspectName, crimeType));
            totalCases++;
        }
    }

    public void updateCaseStatus(String caseId, String status) {
        for (String id : cases.keySet()) {
            if (id.equals(caseId)) {
                cases.get(id).setStatus("Closed");
                return;
            }
        }
        System.out.println("Case not found");
    }

    public String getCaseDetails(String caseId) {
        for (String id : cases.keySet()) {
            Case foundCase = cases.get(id);
            if (id.equals(caseId)) {
                return String.format("Case ID: %s, Victim: %s, Suspect: %s, Status: %s, Crime Type: %s",
                    foundCase.getCaseId(), foundCase.getVictimName(), foundCase.getSuspectName(), foundCase.getStatus(),
                    foundCase.getCrimeType());
            }
        }
        return "Case not found";
        
    }

    public static int getTotalCases() {
        return totalCases;
    }

    public static void resetTotalCases() {
        totalCases = 0;
    }
}

class Case {
    private String id;
    private String victim;
    private String suspect;
    private String crime;
    private String status = "Open";

    public Case(String caseId, String victimName, String suspectName, String crimeType) {
        id = caseId;
        victim = victimName;
        suspect = suspectName;
        crime = crimeType;
    }

    // Getters and setters
    public String getCaseId() {
        return id;
    }

    public String getVictimName() {
        return victim;
    }

    public String getSuspectName() {
        return suspect;
    }

    public String getStatus() {
        return status;
    }

    public String getCrimeType() {
        return crime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

