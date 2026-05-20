package executorService;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        try(ExecutorService service = Executors.newFixedThreadPool(3)){
            Future<Integer> future = service.submit(new ReturnValueTask());

            System.out.println("Result of the task: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class ReturnValueTask implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 29;
    }
}
