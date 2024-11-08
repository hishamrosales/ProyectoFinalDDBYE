package com.umad.proyectofinalddby.controllers;

import com.umad.proyectofinalddby.data.Director;
import com.umad.proyectofinalddby.dataContext.DataContext;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author hisha
 */
public class DirectorController extends BaseController<Director, Integer> {

    @Override
    public List<Director> GetAll() {
        List<Director> directors = null;

        try {
            directors = DataContext.getOpenSession().createQuery("from Director order by Id", Director.class).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return directors;
    }

    @Override
    public Director GetById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Director Save(Director NEWrEGISTRY) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Director Update(Director updateRegistry) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Director Delete(Director deletedRegistry) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
