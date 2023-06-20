import java.util.Scanner;
public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        char y, o;
        System.out.print("Корень дерева: ");
        int s = in.nextInt();
        Tree<Integer> tree = new Tree<>(s, null);
        for(;;){
            int n;
            System.out.print("Добавить: ");
            n = in.nextInt();
            if(n == 0) break;
            tree.add(n);
        }
        do{
            System.out.print("p - распечатать элементы дерева, r - удалить эелемент, s - поиск: ");

            o = in.next().charAt(0);
            switch(o){
                case 'p':
                    tree.print();
                    break;
                case 'r':
                    tree.print();
                    System.out.print("Выберите какой элемент удалить: ");
                    tree.remove(in.nextInt());
                    break;
                case 's':
                    System.out.println("Введите элемент для поиска: ");
                    if ((tree.search(in.nextInt()) != null)) {
                        System.out.println("Есть");
                    } else {
                        System.out.println("Нет");
                    }
                    break;
            }
            System.out.print("Продолжить (y/n)? ");
            y = in.next().charAt(0);
        }while(y != 'n');
        in.close();
    }
}
