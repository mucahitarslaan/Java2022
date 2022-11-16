package com.mucahitarslan.Devs.business.responses.languageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdTechnology {
    private int id;
    private String name;
    private int programmingLanguageId;
    private String programmingLanguageName;
}
