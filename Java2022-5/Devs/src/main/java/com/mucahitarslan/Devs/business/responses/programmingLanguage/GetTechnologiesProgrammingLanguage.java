package com.mucahitarslan.Devs.business.responses.programmingLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTechnologiesProgrammingLanguage {
    private int id;
    private String name;
    private int programmingLanguageId;
    private String programmingLanguageName;
}
