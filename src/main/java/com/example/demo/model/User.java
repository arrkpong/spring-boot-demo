package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// กำหนดว่า class นี้เป็น Entity ที่จะใช้ในฐานข้อมูล
@Entity
@Table(name = "users")  // ระบุชื่อ table ในฐานข้อมูลที่เกี่ยวข้องกับ class นี้
@Getter  // ใช้ Lombok เพื่อสร้าง getter สำหรับทุกฟิลด์
@Setter  // ใช้ Lombok เพื่อสร้าง setter สำหรับทุกฟิลด์
public class User {

    // ระบุว่า id เป็น primary key และจะใช้การ auto-generate ค่า
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ใช้ Identity strategy ในการสร้างค่า ID อัตโนมัติ
    private Long id;

    // ฟิลด์ name สำหรับเก็บชื่อของผู้ใช้
    private String name;

    // ฟิลด์ email สำหรับเก็บอีเมลของผู้ใช้
    private String email;
}
