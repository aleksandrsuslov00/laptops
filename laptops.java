import java.util.*;

class Laptop {
    private String producer;
    private String model;
    private String processor;
    private int amountRam;
    private int hardDriveCapacity;
    private String operatingSystem;
    private double screenSize;
    private String color;
    private int price;

    public Laptop(String producer, String model, String processor, int amountRam, int hardDriveCapacity,
            String operatingSystem, double screenSize, String color, int price) {
        this.producer = producer;
        this.model = model;
        this.processor = processor;
        this.amountRam = hardDriveCapacity;
        this.hardDriveCapacity = hardDriveCapacity;
        this.operatingSystem = operatingSystem;
        this.screenSize = screenSize;
        this.color = color;
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public String getProcessor() {
        return processor;
    }

    public int getAmountRam() {
        return amountRam;
    }

    public int getHardDriveCapacity() {
        return hardDriveCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }
}

public class laptops {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Apple", "MacBook Air", "Apple M1", 8, 256, "macOS", 13.3, "белый", 93490));
        laptops.add(new Laptop("Lenovo", "IdeaPad Slim 5", "AMD Ryzen 5", 16, 256, "Windows", 14, "cерый", 63070));
        laptops.add(new Laptop("Asus", "Vivobook S14", "AMD Ryzen 7", 16, 1024, "Windows", 16.1, "серебристый", 119030));
        laptops.add(new Laptop("HP", "OMEN 16-c", "AMD Ryzen 9", 16, 256, "Windows", 16.1, "белый", 119030));
        laptops.add(new Laptop("MSI", "Modern 14 C5M", "AMD Ryzen 5", 16, 512, "Windows", 14, "черный", 52460));
        laptops.add(new Laptop("Acer", "Nitro 5", "Intel Core i5", 8, 512, "macOS", 15.6, "белый", 58658));
        laptops.add(new Laptop("HP", "EliteBook 1050", "Intel Core i7", 32, 1024, "Windows", 15.6, "белый", 74745));
        laptops.add(new Laptop("HP", "Pavilion 15", "AMD Ryzen 3", 8, 256, "Windows", 15.6, "серый", 46530));
        laptops.add(new Laptop("HP", "ZBook Studio G9", "Intel Core i9", 32, 512, "Windows", 16, "серебристый", 250010));
        filterLaptops(laptops);
    }

    private static void filterLaptops(Set<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите критерии фильтрации:");
        System.out.println("1 - Производитель");
        System.out.println("2 - Модель");
        System.out.println("3 - Процессор");
        System.out.println("4 - ОЗУ");
        System.out.println("5 - Объем ж/д");
        System.out.println("6 - Операционная система");
        System.out.println("7 - Размер экрана");
        System.out.println("8 - Цвет");
        System.out.println("9 - Цена");

        int chosenParametr = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите минимальное значение для выбранного критерия:");
        Object min = null;

        switch (chosenParametr) {
            case 1:
                System.out.println("Производитель:");
                min = scanner.nextLine();
                break;
            case 2:
                System.out.println("Модель:");
                min = scanner.nextLine();
                break;
            case 3:
                System.out.println("Процессор:");
                min = scanner.nextLine();
                break;
            case 4:
                System.out.println("ОЗУ:");
                min = scanner.nextInt();
                break;
            case 5:
                System.out.println("Объем ж/д:");
                min = scanner.nextInt();
                break;
            case 6:
                System.out.println("Операционная система:");
                min = scanner.nextLine();
                break;
            case 7:
                System.out.println("Размер экрана:");
                min = scanner.nextDouble();
                break;
            case 8:
                System.out.println("Цвет");
                min = scanner.nextLine();
                break;
            case 9:
                System.out.println("Цена:");
                min = scanner.nextInt();
                break;

        }

        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            switch (chosenParametr) {
                case 1:
                    if (laptop.getProducer().equalsIgnoreCase((String) min)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 2:
                    if (laptop.getModel().equalsIgnoreCase((String) min)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 3:
                    if (laptop.getProcessor().equalsIgnoreCase((String) min)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 4:
                    if (laptop.getAmountRam() >= (int) min) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 5:
                    if (laptop.getHardDriveCapacity() >= (int) min) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 6:
                    if (laptop.getOperatingSystem().equalsIgnoreCase((String) min)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 7:
                    if (laptop.getScreenSize() >= (double) min) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 8:
                    if (laptop.getColor().equalsIgnoreCase((String) min)) {
                        filteredLaptops.add(laptop);
                    }
                case 9:
                    if (laptop.getPrice() >= (int) min) {
                        filteredLaptops.add(laptop);
                    }
                    break;
            }
        }

        System.out.println("Результаты фильтрации:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop.getProducer() + " " + laptop.getModel() + ", Процессор: "
                    + laptop.getProcessor() +
                    ", ОЗУ: " + laptop.getAmountRam() + "ГБ" +
                    ", Объем ж/д: " + laptop.getHardDriveCapacity() + "ГБ" +
                    ", ОС: " + laptop.getOperatingSystem() + ", Экран " + laptop.getScreenSize() + '"' + ", Цвет: "
                    + laptop.getColor() + ", Цена: " + laptop.getPrice());
        }
    }
}


