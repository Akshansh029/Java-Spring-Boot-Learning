package executorService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Basic working
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("Akshansh029");
        try {
            System.out.println(completableFuture.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // runAsync and supplyAsync
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Future Thread Run: " + Thread.currentThread().getName());
        });
        runAsyncFuture.get();

        CompletableFuture<String> supplyAsyncFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Future Thread Supply: " + Thread.currentThread().getName();
        });
        System.out.println(supplyAsyncFuture.get());
    }
}
