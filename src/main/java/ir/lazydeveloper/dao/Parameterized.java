package ir.lazydeveloper.dao;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Type;

public abstract class Parameterized<T> {
    private Class<T> clazz;

    public Parameterized() {
        Type type = ((ParameterizedTypeImpl)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.clazz = type instanceof Class ? (Class)type : null;
    }

    protected Class<T> getClazz() {
        return this.clazz;
    }
}
