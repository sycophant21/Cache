package helper;

import java.lang.reflect.Field;

public class ReflectionHelper {

    public String getGetter(String fieldType, Class value) {
        for (Field field : value.getDeclaredFields()) {
            String name = field.getName();
            Annotate annotate = field.getAnnotation(Annotate.class);
            if (annotate != null) {
                if (annotate.fieldName().equalsIgnoreCase(fieldType)) {
                    if (annotate.indexed()) {
                        return annotate.getter();
                    }
                    else {
                        throw new RuntimeException("Field can't be indexed");
                    }
                }
            }
            else if (name.equalsIgnoreCase(fieldType)) {
                return "get"+name.substring(0,1).toUpperCase().concat(name.substring(1));
            }
        }
        throw new RuntimeException("Field not found");
    }
}
