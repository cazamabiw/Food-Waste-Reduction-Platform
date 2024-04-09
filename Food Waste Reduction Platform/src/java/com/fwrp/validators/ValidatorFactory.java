/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fwrp.validators;

/**
 *
 * @author Jessica Gunawan
 */
import com.fwrp.models.User;
import java.util.HashMap;
import java.util.Map;

public class ValidatorFactory {
    private final Map<Class<?>, Object> validators = new HashMap<>();

    public ValidatorFactory() {
        // Initialize the map with type-validator mappings
        validators.put(User.class, new UserValidator());
//        validators.put(RoleDTO.class, new RoleValidator());
//        validators.put(UserRoleDTO.class, new UserRoleValidator());
//        validators.put(FileTypeDTO.class, new FileTypeValidator());
//        validators.put(UserDownloadLogDTO.class, new UserDownloadLogValidator());
//        validators.put(FileDataDTO.class, new FileDataValidator());
        // Add more mappings for other types as needed
    }

    public <T> Validator<T> getValidator(Class<T> targetType) {
        Object validator = validators.get(targetType);

        if (validator != null) {
            return (Validator<T>) validator;
        }

        throw new IllegalArgumentException("No validator found for type " + targetType);
    }
}
