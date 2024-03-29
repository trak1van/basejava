import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException,NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("Name1");
        Field field = r.getClass().getDeclaredFields()[0];
        ((Field) field).setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        // TODO : invoke r.toString via reflection
        Method method = r.getClass().getMethod("toString");
        method.invoke(r);
        r.toString();
        System.out.println(method.invoke(r));
        //System.out.println(r);
    }
}
