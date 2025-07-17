package org.example.essential.level2;

// 세부 메뉴 속성 가지는 클래스
// new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거")
public class MenuItem {
    private String name;
    private double price;
    private String explain;
    public MenuItem(String name, double price, String explain) {
        this.name = name;
        this.price = price;
        this.explain = explain;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public String getExplain(){ return this.explain; }
}
