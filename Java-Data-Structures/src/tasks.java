class WritingMaterials{
    String name;
    String color;
    int price;
    double length;
    boolean draw;

    public WritingMaterials(){

    }

    public WritingMaterials(String name, String color, int price, double length, boolean draw) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.length = length;
        this.draw = draw;
    }

    public WritingMaterials(String name, int n) {

    }

    public void display(){
        System.out.println("Название: " + name + "," + "Цвет: " + color + "," +  "Длина: " + length + "," +  "Цена: " + price + "," +  "Умеет рисовать: " + (draw ? "Да" :"Нет"));
    }

    public void replace_rod(String new_color){
        color = new_color;
    }

    public void priceUp(int n){
        price += n;
    }

    public void priceDown(int n){
        price -= n;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public void draw(){
        if(draw){
            System.out.println(name + " провёл линию. Её цвет - " + color);
        }else {
            System.out.println(name + " не может ничего нарисовать.");
        }
    }

    public void draw(int n){
        if (draw)
            System.out.println( name + " провёл линий: " + n + ". Их цвет - " + color);
        else
            System.out.println(name + " не может ничего нарисовать.");
    }

    public void draw(String color){
        if(draw)
            System.out.println(name + " провёл линий: 1. Их цвет - " + color);
        else
            System.out.println(name + " не может ничего нарисовать.");
    }

    public void draw(String color, int n){
        if(draw)
            System.out.println(name + " провёл линий: " + n + ". Их цвет - " + color);
    }
}

class Pen extends WritingMaterials{
    int countColor;
    boolean auto;

    public Pen(){

    }

    public Pen(int countColor, boolean auto) {
        this.countColor = countColor;
        this.auto = auto;
        super.draw = true;
    }

    public Pen(String name, String color, int price, double length, boolean draw, int countColor, boolean auto) {
        super(name, color, price, length, draw);
        this.countColor = countColor;
        this.auto = auto;
        super.draw = true;
    }

    public Pen(String name, int n, int countColor, boolean auto) {
        super(name, n);
        this.countColor = countColor;
        this.auto = auto;
        super.draw = true;
    }


    public void writeMyName(){
        System.out.println(name);
    }

    public int getCountColor() {
        return countColor;
    }

    public void setCountColor(int countColor) {
        this.countColor = countColor;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    public boolean isAuto() {
        return auto;
    }
}

class Ruler extends WritingMaterials{
    int length;
    boolean wood;

    public Ruler(){

    }

    public Ruler(int length, boolean wood) {
        this.length = length;
        this.wood = wood;
        super.draw = false;
    }

    public Ruler(String name, String color, int price, double length, boolean draw, int length1, boolean wood) {
        super(name, color, price, length, draw);
        this.length = length1;
        this.wood = wood;
        super.draw = false;
    }

    public Ruler(String name, int n, int length, boolean wood) {
        super(name, n);
        this.length = length;
        this.wood = wood;
        super.draw = false;
    }

    public int getLength() {
        return length;
    }

    public boolean isWood() {
        return wood;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }

    public void measure(){
        System.out.println("Сейчас померяем длину");
    }
}

class Divider extends WritingMaterials{
    String dividerType;
    boolean metal;

    public Divider(){

    }

    public Divider(String dividerType, boolean metal) {
        this.dividerType = dividerType;
        this.metal = metal;
        super.draw = true;
    }

    public Divider(String name, String color, int price, double length, boolean draw, String dividerType, boolean metal) {
        super(name, color, price, length, draw);
        this.dividerType = dividerType;
        this.metal = metal;
        super.draw = true;

    }

    public Divider(String name, int n, String dividerType, boolean metal) {
        super(name, n);
        this.dividerType = dividerType;
        this.metal = metal;
        super.draw = true;
    }


    public String getDividerType() {
        return dividerType;
    }

    public boolean isMetal() {
        return metal;
    }

    public void setDividerType(String dividerType) {
        this.dividerType = dividerType;
    }

    public void setMetal(boolean metal) {
        this.metal = metal;
    }

    public void draw_circle(){
        System.out.println("Нарисован круг");
    }
}

class Man{
    public static void main(String[] args) {
        WritingMaterials wm = new WritingMaterials("ручка", "Красный", 145, 15.6, true);
        wm.display();

        Pen p = new Pen();
        p.setName("Паркер");
        p.display();
        p.setCountColor(2);
        p.setAuto(false);
        System.out.println(p.getCountColor());
        System.out.println(p.isAuto());
        p.writeMyName();

        Ruler r = new Ruler();
        r.setName("Линейка");
        r.display();
        r.setLength(25);
        r.setWood(true);
        System.out.println(r.getLength());
        System.out.println(r.isWood());
        r.measure();

        Divider d = new Divider();
        d.setName("Циркуль");
        d.display();
        d.setDividerType("С карандашом");
        d.setMetal(true);
        System.out.println(d.getDividerType());
        System.out.println(d.isMetal());
        d.draw_circle();
    }
}