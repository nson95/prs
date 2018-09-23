

import java.util.List;

public interface PrsDAO {
	
	    String get();
	    <T> List<T> getAll();
	    boolean add();
	    boolean update();
	    boolean delete();
		
}


