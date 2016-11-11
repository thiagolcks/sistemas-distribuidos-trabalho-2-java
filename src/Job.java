import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Job implements Serializable {
	private static final long serialVersionUID = 3265418803385534548L;
	private List<Integer> list;

	public Job() {
		list = new ArrayList<Integer>();
		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
	
}
