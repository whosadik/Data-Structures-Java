public class person2 {
        private String name;
        private int age;
        public person2(String name, int age){
            this.name = name;
            this.age = age;
        }
        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public void printDetails() {
            System.out.println("Person Information:");
            System.out.println("Name: " + getName());
            System.out.println("Age: " + getAge());
        }

    public static void main(String[] args) {
        person2 person2 = new person2("Adilzhan", 17);
        person2.printDetails();
    }
}
