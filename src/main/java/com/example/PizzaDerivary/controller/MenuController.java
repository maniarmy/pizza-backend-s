package com.example.PizzaDerivary.controller;

import com.example.PizzaDerivary.Model.Menu;
import com.example.PizzaDerivary.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "http://localhost:5173")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/add")
    public String add(@RequestBody Menu menu){
        menuService.saveMenu(menu);
        return "New pizza menu is added";
    }

    @GetMapping("/get")
    public List<Menu> list(){
        return menuService.getAllMenu();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        menuService.deleteMenu(id);
        return "Pizza menu with id " + id + " is deleted";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody Menu menu) {
        Menu updatedMenu = menuService.updateMenu(id, menu);
        if (updatedMenu != null) {
            return "Pizza menu with id " + id + " is updated";
        } else {
            return "Pizza menu with id " + id + " not found";
        }
    }

}
