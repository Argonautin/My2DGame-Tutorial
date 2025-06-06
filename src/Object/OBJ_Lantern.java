package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Lantern extends Entity{

	public static final String objName = "Lantern";
	
	public OBJ_Lantern(GamePanel gp) {
		super(gp);
		
		type = type_light;
		name = objName;
		down1 = setup("/objects/lantern");
		description = "[Lantern]\nIlluminates your \nsurroundings.";
		price = 20;
		lightRadius = 350;
	}

}
