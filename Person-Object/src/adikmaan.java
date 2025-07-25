public class adikmaan {
    private String name;
    private int age;

    public adikmaan(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printDetails() {
        System.out.println("Person Information:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
    }

    public static void main(String[] args) {
        adikmaan person = new adikmaan("Adilzhan", 25);
        person.setName("Adikman");
        person.setAge(30);
        person.printDetails();
    }
}
