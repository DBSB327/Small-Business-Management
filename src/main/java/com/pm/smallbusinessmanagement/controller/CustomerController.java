package com.pm.smallbusinessmanagement.controller;

import com.pm.smallbusinessmanagement.model.Customer;
import com.pm.smallbusinessmanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllClients() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Customer>> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addClient(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateClient(@PathVariable Long id, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Client deleted successfully");
    }
}






//Итоговый порядок реализации
//1️⃣ Пользователи и роли (CRUD, аутентификация, роли).
//        2️⃣ Клиенты (CRUD, поиск, фильтрация).
//        3️⃣ Сотрудники (CRUD, привязка к пользователям).
//        4️⃣ Товары и склад (CRUD, учет запасов, списание при продаже).
//        5️⃣ Продажи и заказы (оформление, расчет, обновление остатков).
//        6️⃣ Финансы (учет доходов/расходов, отчеты).
//        7️⃣ Отчеты и аналитика (дашборды, аналитика).
//        8️⃣ Задачи и документы (управление задачами, хранение документов).



//Фильтрация и поиск клиентов.
//Привязка сотрудников к пользователям.
//Учет запасов товаров и списание при продаже.
//Расчет стоимости и обновление остатков при оформлении продаж.
//Финансовый учет доходов и расходов, финансовые отчеты.
//Система отчетов и аналитики (дашборды, графики).
//Управление задачами и их привязка к пользователям или клиентам.

