package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    // สร้างตัวแปร service ที่จะใช้ในการติดต่อกับ UserService
    private final UserService service;

    // Constructor เพื่อ inject UserService เข้ามาใช้งาน
    public UserController(UserService service) {
        this.service = service;
    }

    // คำขอ GET ที่หน้า Home Page ("/") สำหรับแสดงข้อมูลผู้ใช้ทั้งหมด
    @GetMapping("/")
    public String viewHomePage(Model model) {
        // นำข้อมูลผู้ใช้ทั้งหมดจาก service มาตั้งใน attribute ของ model
        model.addAttribute("listUsers", service.listAll());
        return "index"; // ส่งกลับไปยัง view "index" (หน้า Home)
    }

    // คำขอ GET ที่หน้า "/new" เพื่อแสดงฟอร์มสำหรับสร้างผู้ใช้ใหม่
    @GetMapping("/new")
    public String showNewForm(Model model) {
        // สร้างอ็อบเจ็กต์ User ใหม่เพื่อใช้ในฟอร์ม
        model.addAttribute("user", new User());
        return "new_user"; // ส่งกลับไปยัง view "new_user" (ฟอร์มสร้างผู้ใช้ใหม่)
    }

    // คำขอ POST สำหรับบันทึกข้อมูลผู้ใช้ใหม่
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        // เรียกใช้ service เพื่อบันทึกข้อมูลผู้ใช้
        service.save(user);
        return "redirect:/"; // เปลี่ยนเส้นทางไปยังหน้า Home หลังจากบันทึกข้อมูล
    }

    // คำขอ GET เพื่อแสดงฟอร์มแก้ไขข้อมูลผู้ใช้ตาม ID
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        // เรียกข้อมูลผู้ใช้จาก service โดยใช้ id ที่ได้รับ
        User user = service.get(id);
        // นำข้อมูลผู้ใช้ที่ได้มาตั้งใน attribute ของ model
        model.addAttribute("user", user);
        return "edit_user"; // ส่งกลับไปยัง view "edit_user" (ฟอร์มแก้ไขผู้ใช้)
    }

    // คำขอ GET สำหรับลบผู้ใช้ตาม ID
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        // เรียกใช้ service เพื่อทำการลบผู้ใช้ที่มี id ตรงกับที่ระบุ
        service.delete(id);
        return "redirect:/"; // เปลี่ยนเส้นทางไปยังหน้า Home หลังจากลบผู้ใช้
    }
}
