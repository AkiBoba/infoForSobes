package src.intern.collections.classes.cats.shape;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShapeTest {

    @Test
    void getPerimetr() {
        Shape shape = new Shape(1,2);
        int expPer = 3;
        int per = shape.getPerimetr();
        assertThat(per == expPer);
    }
    @Test
    void getPerimetr1() {
        Shape shape = new Triangle(1,2, 3);
        int expPer = 6;
        int per = shape.getPerimetr();
        assertThat(per == expPer);
    }
    @Test
    void getPerimetr2() {
        Shape shape = new Prglnc(1,2);
        int expPer = 6;
        int per = shape.getPerimetr();
        assertThat(per == expPer);
    }
}