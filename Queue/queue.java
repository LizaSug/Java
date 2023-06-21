public class queue
{
    static int n = 10;
    int mas[] = new int[n];
    int head;
    int tail;
    queue()
    {
        for(int i = 0; i<n; i++) mas[i] = 0;
        tail = 0;
        head = 0;
    }
    void display()
    {
        for(int i=head; i<n; i++) System.out.print(mas[i] + " ");
        System.out.println();
    }
    void put(int num)
    {
        if(tail<n)
        {
            mas[tail] = num;
            tail += 1;
        }
        else System.out.println("Очередь переполненна!");
    }
    void get()
    {
        for(int i = 0; i<tail; i++)
        {
            if(i==n-1)
            {
                mas[i] = 0;
                break;
            }
            mas[i] =mas[i+1];
        }
        tail--;
    }

}
