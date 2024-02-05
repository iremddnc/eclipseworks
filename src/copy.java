
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Computer {
    CPU cpu;
    RAM ram;

    public Computer(CPU cpu, RAM ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public void run() {
        int sum = 0;
        for (int i = 0; i < ram.getCapacity(); i++) {
            sum += ram.getValue(i, i);
        }
        ram.setValue(0, 0, sum);
    }

    public String toString() {
        return "Computer: " + cpu.toString() + " " + ram.toString();
    }
}

class Laptop extends Computer {
    int milliAmp;
    int battery;

    public Laptop(CPU cpu, RAM ram, int milliAmp) {
        super(cpu, ram);
        this.milliAmp = milliAmp;
        this.battery = milliAmp * 30 / 100;
    }

    public int batteryPercentage() {
        return battery * 100 / milliAmp;
    }

    public void charge() {
        while (batteryPercentage() < 90) {
            battery += milliAmp * 2 / 100;
        }
    }

    public void run() {
        if (batteryPercentage() > 5) {
            super.run();
            battery -= milliAmp * 3 / 100;
        } else {
            charge();
        }
    }

    public String toString() {
        return super.toString() + " " + battery;
    }
}

class Desktop extends Computer {
    ArrayList<String> peripherals;

    public Desktop(CPU cpu, RAM ram, String... peripherals) {
        super(cpu, ram);
        this.peripherals = new ArrayList<>(Arrays.asList(peripherals));
    }

    public void run() {
        int sum = 0;
        for (int i = 0; i < ram.getCapacity(); i++) {
            for (int j = 0; j < ram.getCapacity(); j++) {
                sum = cpu.compute(sum, ram.getValue(i, j));
            }
        }
        ram.setValue(0, 0, sum);
    }

    public void plugIn(String peripheral) {
        peripherals.add(peripheral);
    }

    public String plugOut() {
        return peripherals.remove(peripherals.size() - 1);
    }

    public String plugOut(int index) {
        return peripherals.remove(index);
    }

    public String toString() {
        String peripheralsString = "";
        for (String peripheral : peripherals) {
            peripheralsString += peripheral + " ";
        }
        return super.toString() + " " + peripheralsString;
    }
}

class CPU {
    String name;
    double clock;

    public CPU(String name, double clock) {
        this.name = name;
        this.clock = clock;
    }

    public String getName() {
        return name;
    }

    public double getClock() {
        return clock;
    }

    public int compute(int a, int b) {
        return a + b;
    }

    public String toString() {
        return "CPU: " + name + " " + clock + "Ghz";
    }
}


 class RAM {
    private String type;
    private int capacity;
    private int[][] memory;

    public RAM(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        initMemory();
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    private void initMemory() {
        memory = new int[capacity][capacity];
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                memory[i][j] = random.nextInt(11);
            }
        }
    }

    private boolean check(int i, int j) {
        return i >= 0 && i < capacity && j >= 0 && j < capacity;
    }

    public int getValue(int i, int j) {
        if (!check(i, j)) {
            return -1;
        }
        return memory[i][j];
    }

    public void setValue(int i, int j, int value) {
        if (check(i, j)) {
            memory[i][j] = value;
        }
    }

    @Override
    public String toString() {
        return "RAM: " + type + " " + capacity + "GB";
    }
}
