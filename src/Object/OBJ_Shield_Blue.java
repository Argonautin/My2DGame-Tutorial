package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Blue extends Entity{

	public static final String objName = "Blue Shield";
	
	public OBJ_Shield_Blue(GamePanel gp) {
		super(gp);
		
		type = type_shield;
		name = objName;
		down1 = setup("/objects/shield_Blue");
		defenseValue = 2;
		description = "[" + name + "]\nA shiny blue shield.";
		price = 15;
	}

}
	


