import java.util.LinkedList;

public class Computer extends Thread {
    LinkedList<Traveller> travellers;

    public Computer(LinkedList<Traveller> q) {
        travellers = q;
    }

    @Override
    public void run() {
        while (!travellers.isEmpty()) {
            Traveller tmpTr = getTimeTravaller();
            System.out.println("Путешественник " + tmpTr.getTravelerNumber() + " получил доступ к компьютеру, сидитт чиллит!");
            try {
                sleep(tmpTr.getTravelersTime() * 200);
                printTime(tmpTr);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

    public Traveller getTimeTravaller() {
        synchronized (travellers) {
            return travellers.poll();
        }
    }

    public void printTime(Traveller tmpTr) {
        int tmpTime = tmpTr.getTravelersTime();

        if (tmpTr.getTravelersTime() < 60) {
            System.out.println("Путешественник " + tmpTr.getTravelerNumber() + " закончил чем-то заниматься, продолжительность занятия " + tmpTr.getTravelersTime() + " минут/минуточек/минуток");
        } else if (tmpTr.getTravelersTime() == 60) {
            System.out.println("Путешественник " + tmpTr.getTravelerNumber() + " закончил чем-то заниматься, продолжительность занятия " + 1 + " часик ");
        } else if (tmpTr.getTravelersTime() > 60 && tmpTr.getTravelersTime() < 120) {
            tmpTime -= 60;
            System.out.println("Путешественник " + tmpTr.getTravelerNumber() + " закончил чем-то заниматься, продолжительность занятия " + 1 + " часик и " + tmpTime + " минут/минуточек/минуток");
        } else {
            System.out.println("Путешественник " + tmpTr.getTravelerNumber() + " закончил чем-то заниматься, продолжительность занятия целых " + 2 + " часика");
        }
    }
}
