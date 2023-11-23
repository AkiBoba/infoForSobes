package src.interfaceClass;

import static java.lang.System.*;
import java.lang.Error;

public interface MyData {

    default void print(String str) {
        if (!isNull(str))
            out.println("Class myData, printing string : " + str);
    }

    static boolean isNull(String str) {
        out.println("Static method for checking on null");

        return str == null || ("".equals(str));
    }
}
