import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Application {
    private String privateString;
    public String publicString;
    public static void main(String[] args) throws Exception {
        proxy();
//        reflection();
    }


    // Reflection
    public static void reflection() throws Exception {
//        Application app = new Application();
        Application app = (Application) Class.forName("Application").getConstructor().newInstance();
//        app.method1("blah");
//        app.getClass().getMethods()[0].
        Method method1 = app.getClass().getMethod("method1", String.class);
//        Method method1 = app.getClass().getMethod("method1");
//        method1.invoke(app,"myValue");

        Method method2 = Application.class.getMethod("method2",String.class);
        method2.invoke(null, "blah");

//        for(Method method: Application.class.getMethods()) {
//            System.out.println(method.getName());
//        }
    }
    public void method1(String parameter1) {
        System.out.println("method1 called with " + parameter1);
    }
    public static void method2(String parameter1) {
        System.out.println("method2 called with " + parameter1);
    }

    // Proxy
    public static void proxy() {
        Calc proxy = (Calc) Proxy.newProxyInstance(ExampleProxy.class.getClassLoader(),
                new Class[] { Calc.class },
                new ExampleProxy());
        System.out.println(proxy.sum(1,2));
    }
}
