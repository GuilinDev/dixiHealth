import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class DemoTest {
    private void changeValue(StringBuffer sb) {
        sb.replace(0, sb.length(), "changed");
        System.out.println(sb.toString());
    }
    @Test
    public void test1() {
        StringBuffer sb = new StringBuffer("unchanged");
        changeValue(sb);
        assertEquals("changed",sb.toString());
    }

    private void changeValue(String str) {
        str = "changed";
        System.out.println(str);
    }

    @Test
    public void test2() {
        String str = new String("unchanged");
        changeValue(str);
        assertEquals("unchanged", str);
    }

    private void changeValue2(String str) throws Exception{
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(str, "changed2".toCharArray());
    }

    @Test
    public void test3() throws Exception{
        String str = "unchanged2";
        changeValue2(str);
        assertEquals("changed2", str);
        assertSame("unchanged2", str);

        System.out.println("Hello World");
        System.out.println("unchanged2");
    }

    private void swap (int x, int y) {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x: " + x);
        System.out.println("y: " + y);
    }

    @Test
    public void test4() {
        int x = 100;
        int y = -100;
        swap(x, y);
        assertEquals(100, x);
        assertEquals(-100, y);
    }

    private void swap (WarpedInt x, WarpedInt y) {
        x.value = x.value ^ y.value;
        y.value = x.value ^ y.value;;
        x.value = x.value ^ y.value;
    }

    @Test
    public void test5() {
        WarpedInt x = new WarpedInt(100);
        WarpedInt y = new WarpedInt(-100);
        swap(x, y);
        assertEquals(-100, x.value);
        assertEquals(100, y.value);
    }
}
