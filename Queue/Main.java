public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        queue s1 = new queue();
        System.out.println("Наполнение очереди");
        for(int i = 1; i<11; i++)
        {
            s1.put(i);
            s1.display();
        }
        System.out.println("Очистка очереди");
        for(int i = 1; i<11; i++)
        {
            s1.get();
            s1.display();
        }
    }
}
