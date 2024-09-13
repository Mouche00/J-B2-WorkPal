package model;

import java.time.LocalDate;

public class Reservation {
    private String id;
    private String member;
    private String workspace;
    private LocalDate startDate;
    private LocalDate endDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Reservation(String id, String member, String workspace, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.member = member;
        this.workspace = workspace;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
