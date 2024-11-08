package com.umad.proyectofinalddby.controllers;

import java.util.List;

/**
 *
 * @author hisha
 */
public abstract class BaseController<T, E> {

    public abstract List<T> GetAll();

    public abstract T GetById(E id);

    public abstract T Save(T NEWrEGISTRY);

    public abstract T Update(T updateRegistry);

    public abstract T Delete(T deletedRegistry);
}
