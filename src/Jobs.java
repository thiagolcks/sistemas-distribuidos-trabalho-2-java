import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Jobs extends UnicastRemoteObject implements JobsInterface {
	private static final long serialVersionUID = -8230315085049783767L;
	
	private List<Job> jobs;
	private List<Job> doneJobs;
	private int jobNumber = 20;

	protected Jobs() throws RemoteException {
		super();
		createJobs();
	}
	
	private void createJobs() {
		jobs = new ArrayList<Job>();
		doneJobs = new ArrayList<Job>();
		for (int i = 0; i < jobNumber ; i++) {
			Job j = new Job();
			printJobHead(j);
			jobs.add(j);
		}
	}

	@Override
	public synchronized Job getJob() {
		if (jobs.size() > 0) {
			Job job = jobs.get(0);
			jobs.remove(0);
			return job;
		}
		return null;
	}

	@Override
	public synchronized void setJob(Job job) {
		doneJobs.add(job);
		printJobHead(job);
	}
	
	public void printJob(Job job) {
		for (Integer i : job.getList()){
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("");
	}
	
	public void printJobHead(Job job) {
		List<Integer> list = job.getList();
		for (int i = 0; i < 100; i++){
			System.out.print(list.get(i) + " ");
		}
		System.out.println("");
		System.out.println("---------------------------------------");
		System.out.println("");
	}
	
}
