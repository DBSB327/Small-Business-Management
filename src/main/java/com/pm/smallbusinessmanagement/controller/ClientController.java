package com.pm.smallbusinessmanagement.controller;

import com.pm.smallbusinessmanagement.model.Client;
import com.pm.smallbusinessmanagement.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        return ResponseEntity.ok(clientService.updateClient(id, client));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
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

