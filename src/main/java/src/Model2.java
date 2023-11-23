package src;

public class Model2 extends Model{
    @Override
    public void run() {
        System.out.println("Run m-2");
    }

    public void run(String name) {
        System.out.println("Run " + name);
    }
}
