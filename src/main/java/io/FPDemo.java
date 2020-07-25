package io;

import java.util.Optional;
import java.util.stream.Stream;

public class FPDemo {

    public static void main(String[] args) {
        Optional result =
                Stream.of("f", "ba", "hello").map(s -> s.length()).filter(l -> l <= 3).max((o1, o2) -> o1 - o2);
        System.out.println(result.get()); // 输出2 }
    }
}
