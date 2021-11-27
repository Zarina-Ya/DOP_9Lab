import java.util.LinkedList;

public class Cafe {
    private LinkedList<Traveller> travellers;
    private int N;
    private int M;

    public Cafe(int N, int M) {
        travellers = new LinkedList<Traveller>();
        for (int i = 0; i < M; i++) {
            travellers.add(new Traveller(i, (int) (Math.random() * ((120 - 15) + 1) + 15)));
        }
        this.N = N;
        this.M = M;
    }

    public void openCafe() {
        System.out.println("Кафешка открыта!");
        for (int i = M - 1; i >= N; i--) {
            System.out.println("Путешественник " + travellers.get(i).getTravelerNumber() + " ожиданькает, негодует , немножко агрессирует");
        }
        Computer[] computers = new Computer[N];
        for (int i = 0; i < N; i++) {
            computers[i] = new Computer(travellers);
            computers[i].start();

        }
        try {

            for (Computer threadComp : computers) {
                threadComp.join();
            }
            System.out.println("Кафешка опустелa!");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
