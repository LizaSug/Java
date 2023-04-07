class Stack{
    static int max = 4;
    int nums[] = new int[max];
    int top;
    Stack(){
        this.top = 0;
    }
    void display(){
        for(int i = 0; i<top; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    void push(int var){
        if(top >= max){
            System.out.println("Стек переполнен");
        }
        else{
            nums[top++] = var;
        }

    }
    void pop(){
        if(top-1<0){
            System.out.println("Стек пуст");
        }
        else{
            nums[--top] = 0;
        }

    }
}
