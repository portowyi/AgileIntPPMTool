package online.portowyi.ppmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> MapValidationService(BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            System.out.println("ХЭЗ ЭРРОРЗ");
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
        }

        return null;
    }
}
