package Design_questions.lruCache;

public class Main {
    public static void main(String[] args) {
        LruCache<Integer, String> cache = new LruCache<>(3);

        cache.put(1, "Value 1");
        cache.put(2, "Value 2");
        cache.put(3, "Value 3");

        System.out.println(cache.get(1)); // Output: Value 1
        System.out.println(cache.get(2)); // Output: Value 2

        cache.put(4, "Value 4");

        System.out.println(cache.get(3)); // Output: null
        System.out.println(cache.get(4)); // Output: Value 4

    }
}
