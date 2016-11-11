import java.rmi.Naming;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Worker {
	
	public static void main(String[] args) {
		new Worker();
	}
	
	public Worker () {
		JobsInterface jobs;
		Instant start = Instant.now();
		try {
			jobs = (JobsInterface) Naming.lookup("rmi://localhost:8088/jobs");
			Job job = jobs.getJob();
			while (job != null) {
				List<Integer> list = job.getList();
				bubbleSort(list);
				job.setList(list);
				jobs.setJob(job);
				job = jobs.getJob();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end).toMillis() + "ms");
	}
	
	public void bubbleSort(List<Integer> group) {
		boolean flag = true;
		int temp;

		while (flag) {
			flag = false;
			for(int j=0; j < group.size() -1;  j++ ) {
				if (group.get(j) > group.get(j+1)) {
					temp = group.get(j);
					group.set(j, group.get(j+1));
					group.set(j+1, temp);
					flag = true;
				} 
			} 
		} 
	}

}
