package com.autoflex.tms.dto.projectDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public  class CreateProjectDto {
    //    @NotNull
    private String projectName;
    //    @NotNull
    private String isActive;
    //    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;
    //@FutureOrPresent //fixme!!!
    private String releaseDate;


}
