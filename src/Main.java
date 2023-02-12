import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Initialize a list of notebooks
        List<Notebook> notebooks = initListNotebooks();

        // filtering criteria
        Map<String, String> params = new HashMap<>();
        params.put("RAM", "16 GB");
        params.put("storage", "1 TB");
        params.put("OS", "Windows 10");
        params.put("color", "Silver");

        // Criteria and print the results
        List<Notebook> filteredNotebooks = filter(params, notebooks);

        // Print the filtered list of notebooks
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }

    // Initializes a list of notebooks
    public static List<Notebook> initListNotebooks() {
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook("Dell XPS 13", "16 GB", "1 TB", "Windows 10", "Silver"));
        notebooks.add(new Notebook("MacBook Pro", "16 GB", "1 TB", "macOS", "Space Gray"));
        notebooks.add(new Notebook("HP Spectre x360", "16 GB", "1 TB", "Windows 10", "Nightfall Black"));
        notebooks.add(new Notebook("Lenovo ThinkPad X1 Carbon", "16 GB", "1 TB", "Windows 10", "Black"));
        return notebooks;
    }

    // Filters a list of notebooks based on specified criteria
    public static List<Notebook> filter(Map<String, String> params, List<Notebook> notebooks) {
        List<Notebook> filteredNotebooks = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            if (notebook.matchesCriteria(params)) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }

    // Defines the Notebook class
    public static class Notebook {
        private String model;
        private String RAM;
        private String storage;
        private String OS;
        private String color;

        public Notebook(String model, String RAM, String storage, String OS, String color) {
            this.model = model;
            this.RAM = RAM;
            this.storage = storage;
            this.OS = OS;
            this.color = color;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getRAM() {
            return RAM;
        }

        public void setRAM(String RAM) {
            this.RAM = RAM;
        }

        public String getStorage() {
            return storage;
        }

        public void setStorage(String storage) {
            this.storage = storage;
        }

        public String getOS() {
            return OS;
        }

        public void setOS(String OS) {
            this.OS = OS;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean matchesCriteria(Map<String, String> params) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key.equals("RAM") && !this.RAM.equals(value)) {
                    return false;
                } else if (key.equals("storage") && !this.storage.equals(value)) {
                    return false;
                } else if (key.equals("OS") && !this.OS.equals(value)) {
                    return false;
                } else if (key.equals("color") && !this.color.equals(value)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String toString() {
            return "Notebook{" +
                    "model='" + model + '\'' +
                    ", RAM='" + RAM + '\'' +
                    ", storage='" + storage + '\'' +
                    ", OS='" + OS + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
} 