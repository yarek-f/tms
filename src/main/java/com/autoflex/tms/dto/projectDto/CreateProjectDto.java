package com.autoflex.tms.dto.projectDto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProjectDto {
    //    @NotNull
    private String projectName;
    //    @NotNull
    private String isActive;
    //    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;
    //@FutureOrPresent //fixme!!!
    private String releaseDate;




}
