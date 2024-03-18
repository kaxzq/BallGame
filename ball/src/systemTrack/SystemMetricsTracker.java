package systemTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SystemMetricsTracker {
    public static Map<String, ProcessMetrics> getSystemMetrics() {
        Map<String, ProcessMetrics> metrics = new HashMap<>();
        String os = System.getProperty("os.name").toLowerCase();

        try {
            Process process;
            if (os.contains("win")) {
                process = Runtime.getRuntime().exec("tasklist");
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                process = Runtime.getRuntime().exec("ps -eo pid,pcpu,rss");
            } else {
                throw new UnsupportedOperationException("Unsupported operating system");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 3) {
                    String pid = parts[0];
                    double cpuUsage = Double.parseDouble(parts[1]);
                    if (cpuUsage == 0.0) {
                        continue;
                    }
                    long memorySize = Long.parseLong(parts[2]);
                    int openFiles = 0;
                    metrics.put(pid, new ProcessMetrics(pid, cpuUsage, memorySize, openFiles));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return metrics;
    }

    public static class ProcessMetrics {
        public String pid;
        public double cpuUsage;
        public long memorySize;
        public int openFiles;

        public ProcessMetrics(String pid, double cpuUsage, long memorySize, int openFiles) {
            this.pid = pid;
            this.cpuUsage = cpuUsage;
            this.memorySize = memorySize;
            this.openFiles = openFiles;
        }
    }
}