import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Logger;

//Реализуйте очередь с помощью LinkedList о следующими методами:
//enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его,
//first() - возвращает первыый элемент из очереди, не удаляя.
public class task2 {
    public static void main(String[] args) {
        Logger lg = Logger.getAnonymousLogger();
        Random rd = new Random();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            enqueue(queue, rd);
            lg.info("enqueue -> " + queue);
        }
        lg.info("dequeue: " + dequeue(queue) + " | queue ->" + queue);
        lg.info("first: " + first(queue) + " | queue -> " + queue);
        lg.info("dequeue: " + dequeue(queue) + " | queue ->" + queue);
        lg.info("first: " + first(queue) + " | queue -> " + queue);
    }

    public static void enqueue(Queue<Integer> q, Random rd) {
        q.add(rd.nextInt(10));
    }

    public static Integer dequeue(Queue<Integer> q) {
        return q.poll();
    }

    public static Integer first(Queue<Integer> q) {
        return q.peek();
    }
}
