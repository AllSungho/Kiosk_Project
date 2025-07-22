package org.example.challenge.level1;

import java.math.BigDecimal;

// 세부 메뉴 속성 가지는 클래스
public class MenuItem {
    private String name;        // 메뉴 이름
    private BigDecimal price;       // 메뉴 가격
    private String explain;     // 메뉴 설명
    public MenuItem(String name, BigDecimal price, String explain) {
        this.name = name;       // 생성자로 메뉴 이름 초기화
        this.price = price;     // 생성자로 메뉴 가격 초기화
        this.explain = explain; // 생성자로 메뉴 설명 초기화
    }
    // 키오스크에서 Setter 필요 X
    public String getName(){ return this.name; }       // 메뉴 이름 Getter
    public BigDecimal getPrice(){ return this.price; }     // 메뉴 가격 Getter
    public String getExplain(){ return this.explain; }  // 메뉴 설명 Getter
}
