package src;

public class Test2 {
    public static void main(String[] args) {
        Model model1 = new Model1();
        Model model2 = new Model2();
        print(model1);
        print(model2);
    }

    static void print(Model model) {
        model.run();
    }
}


