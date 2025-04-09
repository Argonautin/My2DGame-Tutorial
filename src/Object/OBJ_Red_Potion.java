package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Red_Potion extends Entity{

	public static final String objName = "Red Potion";
	
	GamePanel gp;
	
	public OBJ_Red_Potion(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_consumable;
		value = 5;
		name = objName;
		down1 = setup("/objects/potion_red");
		description = "[Red Potion]\nHeals your life by " + value + "." ;
		price = 25;
		stackable = true;
		
		setDialogue();
	}
	public void setDialogue()
	{
		dialogues[0][0] = "You drink the " + name + "!\n" + "Your life has been recovered by " + value + ".";
	}
	public boolean use(Entity entity)
	{
		startDialogue(this,0);
		entity.life += value;
		gp.playSE(2);
		return true;
	}

}
