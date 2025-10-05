package TestDemos;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

/**
 * @author Administrator
 * @date 2025/9/17 16:05
 * @see
 * @since JDK 17
 */
public class AnnotationTestDemo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        User user = new User("dme", "123456", 26, new Dog("dog", 5));
        user = new AnnotationTestDemo().anyObject(user);
        System.out.println(user);
    }

    public <T> T anyObject(T t) throws IllegalAccessException, InstantiationException {
        Class<T> tClass = (Class<T>) t.getClass();
        Constructor<?> constructor = tClass.getDeclaredConstructors()[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objects = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                if (parameterTypes[i] == int.class || parameterTypes[i] == short.class || parameterTypes[i] == long.class || parameterTypes[i] == byte.class)
                    objects[i] = 0;
                else if (parameterTypes[i] == float.class || parameterTypes[i] == double.class)
                    objects[i] = 0.0;
                else if (parameterTypes[i] == char.class)
                    objects[i] = "\u0000";
                else
                    objects[i] = false;
            } else {
                objects[i] = null;
            }
        }
        T newInstance = tClass.newInstance();
        for (Field declaredField : tClass.getDeclaredFields()) {
            declaredField.setAccessible(true);
            //其实不需要在乎 值的类型 get和set 返回值参数
            declaredField.set(newInstance, (declaredField.get(t)));
        }
        return newInstance;
    }
}
