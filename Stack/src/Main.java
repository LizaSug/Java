import java.util.Scanner;
public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Stack s1 = new Stack();
        char yesNo, op;
        int n;
        do{
            System.out.print("стек - ");
            s1.display();
            System.out.print("a - добавить в стек, r - убрать элемент из стека: ");
            op = in.next().charAt(0);
            switch(op){
                case 'a': s1.push(n = getInt()); break;
                case 'r': s1.pop(); break;
            }
            System.out.print("Продолжить (y/n)? : ");
            yesNo= in.next().charAt(0);
        }while(yesNo != 'n');
        in.close();
    }
    public static int getInt(){
        System.out.print("Введите число: ");
        int num;
        if(in.hasNextInt()){
            num = in.nextInt();
        }
        else{
            System.out.println("Вы допустили ошибку при вводе числа.");
            in.next();
            num = getInt();
        }
        return num;
    }
}
