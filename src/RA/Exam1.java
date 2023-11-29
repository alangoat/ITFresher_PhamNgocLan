package RA;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
public class Exam1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap vao so gia tri phan tu cua mang");
        int size = input.nextInt();
        while (size < 0) {
            System.out.println("Yeu cau nhap lai");
            size = input.nextInt();
        }
        int[] arr = new int[size];
        var choice = 0; // khởi tạo biến lựa chọn
        do {
            System.out.println("\n======== MENU ========");
            System.out.println("1. Nhập n gia trị phẩn tử của mảng");
            System.out.println("2. In các giá trị phần tử của mảng");
            System.out.println("3. Tính trung bình các phần tử dương trong mảng");
            System.out.println("4. In ra vị trí các phần tử có giá trị bằng k trong mảng");
            System.out.println("5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần, các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần, các phần tử còn lại ở giữa mảng theo thứ tự tăng dần");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí");
            System.out.println("9. Thoát chương trình");
            System.out.println("Xin mời chọn: ");
            choice = input.nextInt(); // nhập lựa chọn
            // tiến hành đánh giá và thực hiện chương trình324343
            switch (choice) {
                case 1: // nếu giá trị của choice = 1
                    System.out.println("Nhap cac gia tri phan tu trong mang");
                    for (int i=0 ; i < size ; i++)
                    {
                        System.out.printf("arr[%d]=", i);
                        arr[i] = input.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Cac phan tu gia tri trong mang:");
                   printArray(arr);
                    break;
                case 3:
                    int sumPositive = 0;
                    int countPositive = 0;
                    for (int i=0; i < arr.length; i++ ) {
                        if (arr[i] > 0) {
                            sumPositive += arr[i]; // Tính tổng các số dương
                            countPositive++; // Đếm số lượng số dương
                        }
                    }
                    double averagePositive = 0.0;
                    if (countPositive > 0) {
                        averagePositive = (double) sumPositive / countPositive; // Tính trung bình
                    }
                    System.out.println("Trung bình các số dương trong mảng: " + averagePositive);
                    break;
                case 4:
                    System.out.printf("Nhap gia tri k");
                    int k = input.nextInt();
                    boolean found = false;
                    System.out.println("Cac vi tri co phan tu bang" + k + "la");
                    for (int i = 0; i < arr.length;i++)
                    {
                        if(k == arr[i]){
                            found=true;
                            System.out.println("Vi tri"+ i);
                        }
                    }
                    if(!found){
                        System.out.println("Khong tin thay vi tri phan tu co gia tri bang "+ k +"trong mang" );
                    }
                    break;
                case 5:
                    bubbleSortDescending(arr);
                    System.out.println("Cac phan tu cua mang sau khi sap xep noi bot giam dan la");
                    printArray(arr);
                    break;
                case 6:
                    int countPrimes = countPrimeNumbers(arr);
                    System.out.println("Số lượng số nguyên tố trong mảng: " + countPrimes);
                    break;
                case 7:
                    sortCustom(arr);
                    System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));
                    break;
                case 8:
                    System.out.print("Nhập giá trị m: ");
                    int m = input.nextInt();

                    Arrays.sort(arr);
                    System.out.println("Mảng trước khi chèn giá trị m:");
                    System.out.println(Arrays.toString(arr));

                    // Gọi hàm để chèn giá trị m vào mảng đã sắp xếp giảm dần
                    int newarr[] = insertValue(arr, m);

                    Arrays.sort(newarr);
                    System.out.println("Mảng sau khi chèn giá trị m:");
                    System.out.println(Arrays.toString(newarr));
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Sai chức năng. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0); // đk lặp là choice != 0
    }
    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Hoán đổi giá trị nếu phần tử đứng trước lớn hơn phần tử đứng sau
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    ////////////////////////////////////////////////////////////////////////////////
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Hàm đếm số lượng số nguyên tố trong mảng
    public static int countPrimeNumbers(int[] arr) {
        int count = 0;
        for (int number : arr) {
            if (isPrime(number)) {
                count++;
            }
        }
        return count;
    }
    ////////////////////////////////////////////////////////////////
    public static void sortCustom(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int i = 0;

        while (i <= right) {
            if (arr[i] % 2 == 0 && arr[i] % 3 == 0) {
                // Phần tử chẵn và chia hết cho 3 -> di chuyển về đầu mảng
                swap(arr, i, left);
                left++;
                i++;
            } else if (arr[i] % 2 != 0 && arr[i] % 3 == 0) {
                // Phần tử lẻ và chia hết cho 3 -> di chuyển về cuối mảng
                swap(arr, i, right);
                right--;
            } else {
                // Phần tử còn lại, tiếp tục xét phần tử tiếp theo
                i++;
            }
        }

        // Sắp xếp các phần tử chẵn và chia hết cho 3 ở đầu mảng (tăng dần)
        Arrays.sort(arr, 0, left);

        // Sắp xếp các phần tử lẻ và chia hết cho 3 ở cuối mảng (giảm dần)
        Arrays.sort(arr, left, arr.length);
        reverseArray(arr, left, arr.length - 1);
    }

    // Hàm đảo ngược mảng
    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Hàm hoán đổi vị trí giữa hai phần tử trong mảng
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
///////////////////////////////////////////////////////////
    public static int[] insertValue(int[] arr, int m) {
    int length = arr.length;
    arr = Arrays.copyOf(arr, length + 1);
    int i = length - 1;

    while (i >= 0 && arr[i] < m) {
        arr[i + 1] = arr[i];
        i--;
    }
    arr[i + 1] = m;
    return arr;
    }
}
