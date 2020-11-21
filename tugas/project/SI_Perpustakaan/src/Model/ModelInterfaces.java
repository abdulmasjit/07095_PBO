package Model;
public interface ModelInterfaces {
    public void view();
    public void insert(Object x);
    public void update(int index, Object x);
    public void delete(int index);
    public void get_where(int index);
}
