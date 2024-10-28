package com.example.PizzaDerivary.services;


import com.example.PizzaDerivary.Model.Menu;
import com.example.PizzaDerivary.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService{
    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public void saveMenu(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    @Override
    public Menu updateMenu(int id, Menu menu) {
        Optional<Menu> existingMenuOptional = menuRepository.findById(id);
        if (existingMenuOptional.isPresent()) {
            Menu existingMenu = existingMenuOptional.get();
            existingMenu.setName(menu.getName());
            existingMenu.setUnitPrice(menu.getUnitPrice());
            existingMenu.setImageUrl(menu.getImageUrl());
            existingMenu.setIngredients(menu.getIngredients());
            existingMenu.setSoldOut(menu.isSoldOut());
            return menuRepository.save(existingMenu);
        } else {
            return null;
        }
    }


    @Override
    public void deleteMenu(int id) {
        menuRepository.deleteById(id);
    }
}
