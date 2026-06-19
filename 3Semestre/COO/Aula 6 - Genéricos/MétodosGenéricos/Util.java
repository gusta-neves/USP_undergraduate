public class Util {
    public static <K, V> boolean comparar(OrdenedPair<K,V> p1, OrdenedPair<K,V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
}
