import javax.swing.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Class_1 {
   protected static String inputFilePath = "/Users/li6ri9ka/IdeaProjects/input output/task_3/src/inputBigText.txt";

    public static void main(String[] args) {
        timeMeasurementsBufferedReader(inputFilePath);
        timeMeasurementsFileChannel(inputFilePath);

    }


    public static void timeMeasurementsBufferedReader(String inputFilePath) {
        long startTime = System.currentTimeMillis();
        String outputFilePath = "output.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String result = line.toUpperCase();
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ошибка чтение" + e.getMessage());

        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Метод: timeMeasurementsBufferedReader: " + totalTime);
    }


    public static void timeMeasurementsFileChannel(String inputFilePath) {
        long startTime = System.currentTimeMillis();
        String outputFilePath = "output_1.txt";
        try {
            FileInputStream fis = new FileInputStream(inputFilePath);
            FileOutputStream fos = new FileOutputStream(outputFilePath);
            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (inChannel.read(buffer)!=-1) {
                buffer.flip();
                baos.write(buffer.array(), 0, buffer.limit());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Метод: timeMeasurementsFileChannel: " + totalTime);
    }
}
