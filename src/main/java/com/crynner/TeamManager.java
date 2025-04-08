package com.crynner;

import java.util.List;
import java.util.ArrayList;

class TeamMember {
    private String name;
    private String role;

    public TeamMember(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String toString() {
        return String.format("%s the %s", name, role);
    }
}

class TeamManager {
    private List<TeamMember> members = new ArrayList<>();

    public void addMember(TeamMember member) {
        if (!members.contains(member)) {
            members.add(member);
        }
    }

    public boolean hasMember(TeamMember member) {
        return members.contains(member);
    }

    public int teamSize() {
        return members.size();
    }
}