import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger {

    public static void main(String[] args) {
//        EnergySource energySource1 = new EnergySource("energySource1", 100);
//        EnergySource energySource2 = new EnergySource("energySource2", 200);
//        EnergySource energySource3 = new EnergySource("energySource3", 300);
//        EnergySource energySource4 = new EnergySource("energySource4", 400);
//        List<EnergySource> energySources1 = new ArrayList<>();
//        energySources1.add(energySource1);
//        energySources1.add(energySource2);
//        List<EnergySource> energySources2 = new ArrayList<>();
//        energySources2.add(energySource3);
//        energySources2.add(energySource4);
//        EnergyStation energyStation1 = new EnergyStation("energyStation1", energySources1);
//        EnergyStation energyStation2 = new EnergyStation("energyStation1", energySources2);
        createLogFiles("EnergyStation1", "EnergySource1");
        createLogFiles("EnergyStation1", "EnergySource2");
        createLogFiles("EnergyStation2", "EnergySource3");
//        readLogFiles("EnergyStation2", "EnergySource3");

    }

    public static void createLogFiles(String energyStation, String equipment) {
        try {
            String logFileName = createLogFileName(energyStation, equipment);
            // Create a FileHandler with the unique log file name
            FileHandler fileHandler = new FileHandler(logFileName);
            Logger logger = Logger.getLogger("log");
            logger.info("This is an information message about" + energyStation + "and" + equipment);
            logger.warning("This is a warning message.");
            logger.severe("This is a severe error message.");
            logger.addHandler(fileHandler);

            // Set a formatter for the log file
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            // Read all lines from the log file
            List<String> lines = Files.readAllLines(Paths.get(logFileName));

            // Print each line to the console
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String createLogFileName(String energyStation, String equipment) {
        Logger logger = Logger.getLogger("log");
        // Create a timestamp for the log file name
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
        String timestamp = dateFormat.format(new Date());
        // Create a unique log file name with timestamp
        return energyStation + "-" + equipment + "-" + timestamp + ".log";

    }
//    private static void readLogFiles() {
//        try {
//            // Specify the directory where log files are stored
//            Path logDirectory = Paths.get("logs");
//
//            // List all files in the directory
//            Files.list(logDirectory)
//                    .filter(Files::isRegularFile)
//                    .forEach(file -> System.out.println(file.getFileName()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
