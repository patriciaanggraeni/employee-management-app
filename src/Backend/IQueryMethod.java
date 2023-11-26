package Backend;

import java.util.ArrayList;

public interface IQueryMethod {
    
    void save();
    void delete();
    
    Object getByid(int id);
    
    ArrayList getAll();
    ArrayList search(String keyword);
} 