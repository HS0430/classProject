package dept;

import java.util.HashMap;
import java.util.Map;

import dept.controller.Controller;
import dept.controller.DeleteController;
import dept.controller.ExitController;
import dept.controller.InsertController;
import dept.controller.SelectByController;
import dept.controller.SelectController;
import dept.controller.UpdateController;
public class Command {

	public Map<Integer, Controller> cmd;
	
	public Command() {
		cmd = new HashMap<>();
		
		cmd.put(1, new SelectController());
		cmd.put(2, new SelectByController());
		cmd.put(3, new InsertController());
		cmd.put(4, new UpdateController());
		cmd.put(5, new DeleteController());
		cmd.put(6, new ExitController());
	}
	
}