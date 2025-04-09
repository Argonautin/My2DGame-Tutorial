package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Tent extends Entity{

	public static final String objName = "Tent";
	
	GamePanel gp;
	
	public OBJ_Tent(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		name = objName;
		down1 = setup("/objects/tent");
		description = "[Tent]\nYou can sleep until\nnext morning.";
		price = 30;
		stackable = true;
	}
	public boolean use(Entity entity)
	{
		gp.gameState = gp.sleepState;
		gp.playSE(13);
		gp.player.life = gp.player.maxLife;
		gp.player.mana = gp.player.maxMana;
		gp.player.getSleepingImage(down1);
		return true;
	}
}
