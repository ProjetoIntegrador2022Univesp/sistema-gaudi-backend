package com.gaudisystems.sistemagaudi.core.services;

import java.util.List;

public interface ApplicationService {
    
    public void save(Object object);
    public void update(Object object);
    public void delete(Object object);
    public Object findById(Long id);
    public List<?> findAll();
}
