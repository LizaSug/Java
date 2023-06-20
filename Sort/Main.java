public class Main {
    //Сортировка пузырьком:
    public static void bubbleSort(int[] sortArr){
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
    }
    //Сортировка вставками:
    public static void insertionSort(int[] sortArr) {
        int j;
        //сортировку начинаем со второго элемента, т.к. считается, что первый элемент уже отсортирован
        for (int i = 1; i < sortArr.length; i++) {
            //сохраняем ссылку на индекс предыдущего элемента
            int swap = sortArr[i];
            for (j = i; j > 0 && swap < sortArr[j - 1]; j--) {
                //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                sortArr[j] = sortArr[j - 1];
            }
            sortArr[j] = swap;
        }
    }
    public static void main(String args[]) {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        bubbleSort(sortArr);
        System.out.print("Пузырьком: ");
        for(int i = 0; i < sortArr.length; i++){
            System.out.print(sortArr[i] + " ");
        }
        System.out.print("\nВставками: ");
        int[] sortArr2 = {3, 1, 10, 8, 4, 11};
        insertionSort(sortArr2);
        for(int i = 0; i < sortArr2.length; i++){
            System.out.print(sortArr2[i] + " ");
        }
    }
}
