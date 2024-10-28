package com.example.PizzaDerivary.services;

import com.example.PizzaDerivary.Model.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    public void saveMenu(Menu menu);
    public List<Menu> getAllMenu();
    Menu updateMenu(int id, Menu menu);
    void deleteMenu(int id);

}
