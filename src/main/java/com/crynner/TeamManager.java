package com.crynner;

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
        return name + " the " + role;
    }
}

class TeamManager {
    private ArrayList<TeamMember> team = new ArrayList<>();

    public void addMember(TeamMember member) {
        team.add(member);
    }

    public boolean hasMember(TeamMember member) {
        return team.contains(member);
    }

    public int teamSize() {
        return team.size();
    }
}