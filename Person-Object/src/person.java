public class person {
    private String name;
    private int age;
    public person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public static void main(String[] args) {
        person info = new person("Adilzhan", 17);
        System.out.println("Name:" + info.getName() + ", age:" + info.getAge());
    }
}
