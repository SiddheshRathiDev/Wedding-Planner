package com.pracone.entities;

import com.pracone.enums.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "project")
@Getter
@Setter
@ToString
public class Project extends BaseEntity {

    @NotNull
    @Column(length = 50)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private Double projectCost;

    @NotNull
    private Integer minHeadCount;


}
