/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.validators;

import com.mycompany.pojo.Dulich;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author QUOC ANH
 */
@Component
public class DulichNameValidator implements Validator{
   @Autowired
    private javax.validation.Validator beanValidator;
    @Override
    public boolean supports(Class<?> clazz) 
    {
            return Dulich.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
          // Chay bean validate
        Set<ConstraintViolation<Object>> contraints 
                = this.beanValidator.validate(target);
        for (ConstraintViolation<Object> obj: contraints)
            errors.rejectValue(obj.getPropertyPath().toString(), 
                    obj.getMessageTemplate(), obj.getMessage());
        
        
        // Chay spring validate
//        Dulich p = (Dulich) target;
//     if ( p.getTendulich().contains("QA") == false)
//            errors.rejectValue("tendulich", "product.name.containsError");
            
    }
    
}
