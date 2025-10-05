package reflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Administrator
 * @date 2025/9/15 21:32
 * @see
 * @since JDK 17
 */
public class TestClassLoader {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

            Class<TestClassLoader> clazz = TestClassLoader.class;
        Constructor<TestClassLoader> constructor = clazz.getConstructor();
        System.out.println(constructor.newInstance());

    }
}
