package com.mucahitarslan.Devs.business.requests.languageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgrammingTechnology {
    private String name;
    private int programmingLanguageId;
}
