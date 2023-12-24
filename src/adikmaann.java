public class adikmaann {
        private String name;
        private int age;
        public adikmaann(String name, int age) {
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
            adikmaann person = new adikmaann("Adikman", 25);
            person.setName("Adik");
            person.setAge(30);
            person.printDetails();
        }
    }

