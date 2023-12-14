package com.pracone.dto;

import com.pracone.enums.Category;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDTO {

    @NotBlank(message = "Name cannot be null or blank!!")
    private String name;

    @NotNull(message = "Category must be described!!")
    private Category category;

    @NotNull(message = "Start date cannot be null!")
    private LocalDate startDate;

    @NotNull(message = "End date cannot be before Start Date or null!")
    private LocalDate endDate;

    @NotNull(message = "Project cost must not be null!!")
    private Double projectCost;

    public void setEndDate(LocalDate endDate) {

        if (startDate == null || startDate.toString().equals("")) {

            this.endDate = endDate;
        } else if (endDate == null || endDate.toString().equals("")) {

            this.endDate = null;
        } else {

            if (endDate.isAfter(getStartDate())) {

                this.endDate = endDate;
            } else {

                this.endDate = null;
            }
        }
    }
}
