package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Normal extends Entity{

	public static final String objName = "normal Sword";
	
	public OBJ_Sword_Normal(GamePanel gp) {
		super(gp);
		
		type = type_sword;
		name = objName;
		down1 = setup("/objects/sword_normal");
		attackValue = 1;
		attackArea.width = 32;
		attackArea.height = 32;
		description = "[" + name + "]\nAn old sword.";
		price = 20;
		knockBackPower = 2;
		motion1_duration = 5;
		motion2_duration = 25;
	}

}
