import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
	
	public static void main(String[] args) {
		startRegistry();
	}
	
	public static void startRegistry() {
		try {
			Jobs jobs = new Jobs();
			LocateRegistry.createRegistry(8088);
			String uri = "rmi://localhost:8088/jobs";
			Naming.rebind(uri, jobs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
