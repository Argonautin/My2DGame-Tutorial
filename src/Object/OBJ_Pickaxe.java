package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Pickaxe extends Entity{

	public static final String objName = "Pickaxe";
	
	public OBJ_Pickaxe(GamePanel gp) {
		super(gp);
		
		type = type_pickaxe;
		name = objName;
		down1 = setup("/objects/pickaxe");
		attackValue = 2;
		attackArea.width = 28;
		attackArea.height = 28;
		description = "[" + name + "]\nYou will dig it.";
		price = 75;
		knockBackPower = 10;
		motion1_duration = 10;
		motion2_duration = 20;
	}

	
}
