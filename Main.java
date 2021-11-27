/*В маленьком интернет кафе в деревне есть N компьютеров. Кафе работает по принципо FIFO,
 т.е. когда все компьютеры заняты, то очередному желающему необходимо подождать. В кафе приходит M туристов.
 Турист проводит за компьютером от 15 минут до 2 часов (время выбирается случайно).
 Напишите программу, которая имитирует порядок доступа к компьютерам в кафе и выводит журнал доступа на экран в процессе работы.
 Необходимо так выбрать масштаб для времени в имитации, чтобы время выполнение программы было меньше 3 минут.

N и M вводятся с клавиатуры.
Можно использовать Thread.sleep(4000);*/


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter thr number of computers: ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("Enter the number of tourists: ");
        s = new Scanner(System.in);
        int m = s.nextInt();
        Cafe cafe = new Cafe(n, m);
        cafe.openCafe();
    }
}
