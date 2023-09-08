import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;

public class ThreadTestUtil {

    private static final Logger log = LoggerFactory.getLogger(ThreadTestUtil.class);

    public static void threadTest(ThreadFactory factory) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10_0000; i++) {
            factory.newThread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }).start();
        }

        log.info("用时：{} ms", System.currentTimeMillis() - start);
    }
}
