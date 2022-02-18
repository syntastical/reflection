import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ExampleProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for(Object arg: args) {
            System.out.println("An arg for " + method.getName() + ", value " + arg);
        }
        return method.invoke(null, args);
        // Continue calling the original method
//        if(method.getName().equals("sendSomething")) {
//            System.out.println("Do some custom logic");
//        }
//        System.out.println(proxy.getClass());
//        System.out.println(method.getName());
//        if(args != null) {
//            System.out.println(args.length);
//        }
    }
}