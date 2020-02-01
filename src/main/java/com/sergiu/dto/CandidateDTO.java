package com.sergiu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sergiu.util.StatusExam;

import java.io.Serializable;

public class CandidateDTO implements Serializable {

    private Long cnp;

    private String firstName;

    private String lastName;

    private CategoryDTO categoryDTO;

    private String highSchool;

    private Double bacGrade;

    private Double bacBestGrade;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private HallDTO hallDTO;

    private StatusExam statusExam;

    public Long getCnp() {
        return cnp;
    }

    public void setCnp(Long cnp) {
        this.cnp = cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public Double getBacGrade() {
        return bacGrade;
    }

    public void setBacGrade(Double bacGrade) {
        this.bacGrade = bacGrade;
    }

    public Double getBacBestGrade() {
        return bacBestGrade;
    }

    public void setBacBestGrade(Double bacBestGrade) {
        this.bacBestGrade = bacBestGrade;
    }

    public HallDTO getHallDTO() {
        return hallDTO;
    }

    public void setHallDTO(HallDTO hallDTO) {
        this.hallDTO = hallDTO;
    }

    public StatusExam getStatusExam() {
        return statusExam;
    }

    public void setStatusExam(StatusExam statusExam) {
        this.statusExam = statusExam;
    }
}