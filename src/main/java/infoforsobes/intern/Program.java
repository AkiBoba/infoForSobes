package infoforsobes.intern;

import static java.lang.System.*;

public class Program {
    public static void main (String args[]){
        Person undef = new Person("ddd");
        undef.introduce();

        Person tom = new Person("Tom");
        tom.introduce();
    }
    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public void introduce() {
            Greeting.greet(this); // Передача текущего объекта в метод greet()
        }



        public static class Greeting {
            public static void greet(Person person) {
                System.out.println("Привет, " + person.name + "!");
            }
        }
    }
}
