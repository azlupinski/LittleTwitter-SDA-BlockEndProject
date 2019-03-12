package pl.sda.util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static AtomicLong lastId = new AtomicLong(3);

    public static Long next() {
        return lastId.incrementAndGet();
    }
}
