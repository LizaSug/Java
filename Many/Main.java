public class Main {
    public static void main(String[] args) {
        Set set1 = new Set(1, 2, 3);
        Set set2 = new Set(2, 3, 4, 5);

        System.out.println("Intersection: " + set1.intersect(set2));
        System.out.println("Union: " + set1.unify(set2));
    }
}