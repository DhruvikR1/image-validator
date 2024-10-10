package io.github.dhruvikr1.validator;

import io.github.dhruvikr1.annotation.ValidateImage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class ImageFileValidator implements ConstraintValidator<ValidateImage, MultipartFile> {
    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null || file.isEmpty()) {
            context.buildConstraintViolationWithTemplate("File cannot be null or empty")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        }
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            context.buildConstraintViolationWithTemplate("Invalid file type. Only image files are allowed.")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        }
        long fileSize = file.getSize();
        if (fileSize > 2 * 1024 * 1024) { // 5MB
            context.buildConstraintViolationWithTemplate("File size exceeds the maximum limit of 5MB.")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        }

        return true;
    }
}
