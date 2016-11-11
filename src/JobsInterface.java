import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JobsInterface extends Remote {
	public Job getJob() throws RemoteException;
	public void setJob(Job job) throws RemoteException;
}
