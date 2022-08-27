package com.marcoscareggio.portfolioweb.service;

import java.util.List;

public interface ICommonService <T,Idtype>{
    public List<T> get();
    public T save(T t);
    public void delete(Idtype id);
    public void find(Idtype id);
}
