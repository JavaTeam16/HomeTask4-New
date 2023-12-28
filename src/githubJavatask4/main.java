package githubJavatask4;

//An example main class to demonstrate object creation and method usage
public class Main {
 public static void main(String[] args) {
     LogFileManager logManager = new LogFileManager();

     // Example usage of the log manager
     logManager.createLogEntry(LogType.CHARGING_STATION, "Charger1 - Started charging process.");

     // Open log files with different scenarios
     logManager.openLogFile(LogType.CHARGING_STATION, "Charger1", LocalDate.now()); // Specific equipment and date
     logManager.openLogFile(LogType.CHARGING_STATION, "Charger1", null); // Specific equipment, current date
     logManager.openLogFile(LogType.SYSTEM, null, LocalDate.of(2023, 4, 1)); // System logs of a specific date
     logManager.openLogFile(LogType.ENERGY_MANAGEMENT, null, null); // All energy management logs of current date
 }
}