package domain;

import java.util.List;

public interface Service {

    public abstract List getAll();
    public abstract void add(Object o);
    public abstract void delete(Object o);

}
