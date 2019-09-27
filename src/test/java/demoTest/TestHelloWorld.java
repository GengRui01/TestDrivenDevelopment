package demoTest;

import demo.HelloWorld;
import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * Description: HelloWorld测试类
 *
 * @ClassName: TestHelloWorld
 * @Author: GengRui
 * @Date: 2019/9/27 16:35
 */
public class TestHelloWorld extends TestCase {

    public TestHelloWorld(String name) {
        super(name);
    }

    public void testSay() {
        HelloWorld helloWorld = new HelloWorld();
        assertEquals("Hello World", helloWorld.say());
    }

    public static void main(String[] args) {
        TestRunner.run(TestHelloWorld.class);
    }
}