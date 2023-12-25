package src.threads.newTasks;

import java.util.concurrent.*;

public class TaskExecutorsFuture {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future future = service.submit(new Callable(){
            public Object call() throws Exception {
                System.out.println("Another thread was executed");
                return "result";
            }
        });
        try {
            System.out.println("Result: " + future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
