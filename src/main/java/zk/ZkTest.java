package zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZkTest {

	private String pnode = "zk_test";
	private String snode = "sub";
	private String host = "127.0.0.1:2181";

	public void connect(String content) throws Exception {
		ZooKeeper zk = new ZooKeeper(host, 5000, new Watcher() {
			public void process(WatchedEvent event) {
				// no process
				System.out.println("===exprie["+event.toString()+"]");
			}
		});
		String createdPath = zk.create("/" + pnode + "/" + snode, content.getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println("create :" + createdPath);
	}

	public void handle() throws InterruptedException {
		Thread.sleep(Long.MAX_VALUE);
	}

	public static void main(String[] args) throws Exception {
		ZkTest as = new ZkTest();
		as.connect("register");
		as.handle();
	}

}
