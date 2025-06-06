package Object;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Chest extends Entity
{
	
	public static final String objName = "Chest";
	
	GamePanel gp;

	
	public OBJ_Chest(GamePanel gp) 
	{
		super(gp);
		this.gp = gp;
		
		
		type = type_obstacle;
		name = objName;
		image = setup("/objects/chest");
		image2 = setup("/objects/chest_opened");
		down1 = image;
		collision = true;
		
		solidArea.x = 4;
		solidArea.y = 16;
		solidArea.width = 40;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
	}
	public void setLoot(Entity loot)
	{
		this.loot = loot;
		setDialogue();
	}
	public void setDialogue()
	{
		dialogues[0][0] = "You open the chest and find a " + loot.name + "!\n...But you cannot carry any more!";
		dialogues[1][0]	= "You open the chest and find a " + loot.name + "!\nYou obtain the " + loot.name + "!";
		dialogues[2][0]	= "It's empty.";
	}
	public void interact()
	{

			if(opened == false)
			{
				gp.playSE(3);

				if(gp.player.canObatinItem(loot) == false)
				{
					startDialogue(this,0);
				}
				else
				{
					startDialogue(this,1);
					down1 = image2;
					opened = true;
				}
			}
			else
			{
				startDialogue(this,2);
			}
	}
}
