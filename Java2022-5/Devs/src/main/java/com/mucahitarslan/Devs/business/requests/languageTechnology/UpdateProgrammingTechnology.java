package com.mucahitarslan.Devs.business.requests.languageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgrammingTechnology {
    private int id;
    private String name;
    private int programmingLanguageId;
}
