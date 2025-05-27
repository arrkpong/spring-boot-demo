package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// อินเตอร์เฟซนี้ทำหน้าที่เป็น repository สำหรับการทำงานกับฐานข้อมูล
// โดยใช้ Spring Data JPA ที่ช่วยให้สามารถเข้าถึงและจัดการข้อมูลในฐานข้อมูลได้ง่าย
public interface UserRepository extends JpaRepository<User, Long> {

    // ไม่จำเป็นต้องเขียนเมธอดใดๆ เพราะ Spring Data JPA จะสร้างคำสั่ง SQL ที่จำเป็นให้เอง
    // JpaRepository มีเมธอดพื้นฐานที่สามารถใช้งานได้ เช่น findAll(), save(), deleteById() เป็นต้น
}
