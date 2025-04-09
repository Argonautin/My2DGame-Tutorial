package monster;

import java.util.Random;

import Entity.Entity;
import Object.OBJ_Coin_Bronze;
import Object.OBJ_Heart;
import Object.OBJ_ManaCrystal;
import Object.OBJ_Rock;
import main.GamePanel;

public class MON_GreenSlime extends Entity
{

	GamePanel gp;
	public MON_GreenSlime(GamePanel gp) 
	{
		super(gp);

		this.gp = gp;
		
		type = type_monster;
		name = "Green Slime";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 4;
		life = maxLife;
		attack = 5;
		defense = 0;
		exp = 2;
		projectile = new OBJ_Rock(gp);
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage()
	{
		up1 = setup("/monster/greenslime_down_1");
		up2 = setup("/monster/greenslime_down_2");
		down1 = setup("/monster/greenslime_down_1");
		down2 = setup("/monster/greenslime_down_2");
		left1 = setup("/monster/greenslime_down_1");
		left2 = setup("/monster/greenslime_down_2");
		right1 = setup("/monster/greenslime_down_1");
		right2 = setup("/monster/greenslime_down_2");
	}
	public void setAction()
	{
		if(onPath == true)
		{
			// check if it stops chasing
			checkStopChasing(gp.player, 15, 100);
			// search the direction to go
			searchPath(getGoalCol(gp.player),getGoalRow(gp.player));
		}
		else
		{
			//check if it starts chasing
			checkChasing(gp.player, 5, 100);
			//get a Random direction
			getRandomDirection(120);
		}
	}
	public void damageReaction()
	{
		actionLockCounter = 0;
//		direction = gp.player.direction;
		onPath = true;
	}
	public void checkDrop()
	{
		//CAST A DIE
		int i = new Random().nextInt(100)+1;
		
		// SET THE MONSTER DROP
		if(i < 50)
		{
			dropItem(new OBJ_Coin_Bronze(gp));
		}
		if(i >= 50 && i < 75)
		{
			dropItem(new OBJ_Heart(gp));
		}
		if(i >= 75 && i < 100)
		{
			dropItem(new OBJ_ManaCrystal(gp));
		}
	}

}
