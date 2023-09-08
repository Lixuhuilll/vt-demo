public class PTMain {

    public static void main(String[] args) {
        var factory = Thread.ofPlatform().name("pt-test-", 0).factory();
        ThreadTestUtil.threadTest(factory);
    }
}
