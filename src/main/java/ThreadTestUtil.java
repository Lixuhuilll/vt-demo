import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;

public class ThreadTestUtil {

    private static final Logger log = LoggerFactory.getLogger(ThreadTestUtil.class);

    public static void threadTest(ThreadFactory factory) {

        Thread[] threads = new Thread[10_0000];

        long create = System.currentTimeMillis();
        for (int i = 0; i < 10_0000; i++) {
            threads[i] = factory.newThread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            });
        }
        log.info("创建用时：{} ms", System.currentTimeMillis() - create);

        long start = System.currentTimeMillis();
        for (var thread : threads) {
            thread.start();
        }
        log.info("启动用时：{} ms", System.currentTimeMillis() - start);

        // 等待执行完成
        try {
            for (var thread : threads) {
                thread.join();
            }
        } catch (InterruptedException ignored) {}
        log.info("运行用时：{} ms", System.currentTimeMillis() - start);
    }
}
