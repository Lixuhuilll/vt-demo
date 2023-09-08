public class VTMain {

    public static void main(String[] args) {
        var factory = Thread.ofVirtual().name("vt-test-", 0).factory();
        ThreadTestUtil.threadTest(factory);
    }
}