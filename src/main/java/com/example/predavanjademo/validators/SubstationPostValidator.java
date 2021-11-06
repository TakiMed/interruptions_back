package com.example.predavanjademo.validators;
import com.example.predavanjademo.repositories.SubstationRepository;
import com.example.predavanjademo.web.dto.SubstationDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class SubstationPostValidator implements Validator {
    // stavila sam nad substation DTO
    @Autowired
    private SubstationRepository substationRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(SubstationDTO.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // validaciona pravila

        SubstationDTO substationDTO = (SubstationDTO) o; // konvertovanje
        validateSubstationName(substationDTO.getFullName(), errors);
        validateISSCode(substationDTO.getIssCode(), errors);


    }

    private void validateSubstationName(String fullName, Errors errors) {
        boolean existsBySubstationName = substationRepository.existsByFullName(fullName);
        if(existsBySubstationName){
            errors.rejectValue(
                    "fullName",
                    "fullName.already-taken",
                    "Substation with this name already exists. Please, try again."
            );
        }
    }

    private void validateISSCode(String issCode, Errors errors) {

        if(StringUtils.isBlank(issCode)){
            errors.rejectValue(
                    "issCode",
                    "issCode.invalid-length",
                    "ISS CODE is not valid. Please, check again."
            );
        }

        if(issCode.length()!=6){
            errors.rejectValue(
                    "issCode",
                    "issCode.invalid",
                    "Number of characters in ISS CODE should be six. Please, try again."
            );
        }
    }
}
