package src.threads;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Wget implements Runnable {
    private final String url;
    private final int speed;

    public Wget(String url, int speed) {
        this.url = url;
        this.speed = speed;
    }

    @Override
    public void run() {
        try (BufferedInputStream input = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream output = new FileOutputStream("fileto.xml")) {
            long startAt = System.currentTimeMillis();
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            int downloadData = 0;
            while ((bytesRead = input.read(dataBuffer, 0, dataBuffer.length)) != -1) {
                var downloadAt = System.nanoTime();
                output.write(dataBuffer, 0, bytesRead);
                downloadData += bytesRead;
                var time = (System.nanoTime() - downloadAt);
                if (downloadData >= speed && time < 10000) {
                    try {
                        Thread.sleep(10000 - time);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Read 512 bytes : " + (System.nanoTime() - downloadAt) + " nano.");
            }
        } catch (IOException ignored) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        String url = args[0];
        int speed = Integer.parseInt(args[1]);
        Thread wget = new Thread(new Wget(url, speed));
        wget.setName("wget");
        wget.start();
        wget.join();
    }
}
