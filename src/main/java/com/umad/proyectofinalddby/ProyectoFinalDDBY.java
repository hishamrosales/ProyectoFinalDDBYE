package com.umad.proyectofinalddby;

import com.umad.proyectofinalddby.controllers.DirectorController;
import com.umad.proyectofinalddby.data.Director;
import com.umad.proyectofinalddby.data.Seeder;
import java.util.List;

/**
 *
 * @author hisha
 */
public class ProyectoFinalDDBY {

    public static void main(String[] args) {

        Seeder seeder = new Seeder();
        seeder.Seed();
        DirectorController directorController = new DirectorController();
        List<Director> directors = directorController.GetAll();
        System.out.print(directors.get(0).getFirstName());
    }
}
