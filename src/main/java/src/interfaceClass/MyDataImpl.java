package src.interfaceClass;

import static java.lang.System.*;

public class MyDataImpl implements MyData {
    public boolean isNull(String str) {
        out.println("Checking on null");

        return str == null;
    }

    public static void main(String args[]){
//        MyDataImpl obj = new MyDataImpl();
//        obj.print("");
//        obj.print("def");
//        obj.isNull("abc");
        MyData.isNull("");
    }
}
