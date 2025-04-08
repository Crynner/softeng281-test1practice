package com.crynner;

import java.util.ArrayList;

class TeamMember {

    public TeamMember(String name, String role) {
    }

    public String getName() {
        return "";
    }

    public String getRole() {
        return "";
    }

    public String toString() {
        return "%s the %s";
    }
}

class TeamManager {

    public void addMember(TeamMember member) {
    }

    public boolean hasMember(TeamMember member) {
        return true;
    }

    public int teamSize() {
        return 0;
    }
}