import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;

public class Dish {

    private static final int TRAY_CAPACITY = 10;

    private final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern("HH:mm:ss");
    private final ArrayBlockingQueue<Integer> cleanTray = new ArrayBlockingQueue<>(TRAY_CAPACITY);
    private final ArrayBlockingQueue<Integer> dryTray = new ArrayBlockingQueue<>(TRAY_CAPACITY);

    public void addToCleanTray(Integer dish) throws InterruptedException {
        cleanTray.put(dish);
        System.out.printf("%s - Dish Washer puts dish %d on the clean tray\n", LocalTime.now().format(dateTimeFormatter), dish);
    }


    public Integer extractFromCleanTray() throws InterruptedException {
        Integer dish = cleanTray.take();
        System.out.printf("%s - Dish Dryer extracts clean dish %d from clean tray\n", LocalTime.now().format(dateTimeFormatter), dish);
        return dish;
    }


    public void addToDryTray(Integer dish) throws InterruptedException {
        dryTray.put(dish);
        System.out.printf("%s - Dish Dryer puts dry dish %d on the dry tray\n", LocalTime.now().format(dateTimeFormatter), dish);
    }


    public Integer extractFromDryTray() throws InterruptedException {
        Integer dish = dryTray.take();
        System.out.printf("%s - Organizer extracts clean dish %d from clean tray and put it in the cupboard\n", LocalTime.now().format(dateTimeFormatter), dish);
        return dish;
    }

}
