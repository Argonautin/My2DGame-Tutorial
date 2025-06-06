package Entity;


import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Object.OBJ_Chest;
import Object.OBJ_Fireball;
import Object.OBJ_Shield_Wood;
import Object.OBJ_Sword_Normal;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{


	KeyHandler keyH;
	public final int screenX;
	public final int screenY;
	public boolean attackCanceled = false;
	public boolean lightUpdated = false;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		super(gp);
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
//HITBOX PLAYER		
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();

	}
	public void setDefaultValues()	{	
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		defaultSpeed = 4;
		speed = defaultSpeed;
		direction = "down";
		
		// PLAYER STATUS
		level = 1;
		maxLife = 6;
		life = maxLife;
		maxMana = 4;
		mana = maxMana;
		ammo = 0;
		strenght = 1;                     // more damage
		dexterity = 1;                   // more defense
		exp = 0;
		nextLevelExp = 5;
		coin = 0;
		currentWeapon = new OBJ_Sword_Normal(gp); 
		currentShield = new OBJ_Shield_Wood(gp);
		currentLight = null;
		projectile = new OBJ_Fireball(gp);
		attack = getAttack();             // total damage
		defense = getDefense();           // total defense
		invincible = false;
		
		getPlayerImage();
		getPlayerAttackImage();
		getGuardImage();
		setItems();
		setDialogue();
		
	}
	public void setDefaultPositions()
	{
		gp.currentMap = 0;
		worldX = gp.tileSize *23;
		worldY = gp.tileSize * 21;
		direction = "down";
	}
	public void setDialogue()
	{
		dialogues[0][0] = "You get level " + level + " now!\n"
				+ "You feel stronger!";
	}
	public void restoreStatus()
	{
		life = maxLife;
		mana = maxMana;
		speed = defaultSpeed;
		invincible = false;
		transparent = false;
		attacking = false;
		guarding = false;
		knockBack = false;
		lightUpdated = true;
	}
	public void setItems()
	{
		inventory.clear();
		inventory.add(currentWeapon);
		inventory.add(currentShield);
	}
	public int getAttack()
	{
		attackArea = currentWeapon.attackArea;
		motion1_duration = currentWeapon.motion1_duration;
		motion2_duration = currentWeapon.motion2_duration;
		return attack = strenght * currentWeapon.attackValue;
	}
	public int getDefense()
	{
		return defense = dexterity * currentShield.defenseValue;
	}
	public int getCurrentWeaponSlot()
	{
		int currentWeaponSlot = 0;
		for(int i = 0; i < inventory.size(); i++)
		{
			if(inventory.get(i) == currentWeapon)
			{
				currentWeaponSlot = i;
			}
		}
		return currentWeaponSlot;
	}
	public int getCurrentShieldSlot()
	{
		int currentShieldSlot = 0;
		for(int i = 0; i < inventory.size(); i++)
		{
			if(inventory.get(i) == currentShield)
			{
				currentShieldSlot = i;
			}
		}
		return currentShieldSlot;
	}
	public void getPlayerImage( ) {
		
		up1 = setup("/player/boy_up_1");
		up2 = setup("/player/boy_up_2");
		down1 = setup("/player/boy_down_1");
		down2 = setup("/player/boy_down_2");
		left1 = setup("/player/boy_left_1");
		left2 = setup("/player/boy_left_2");
		right1 = setup("/player/boy_right_1");
		right2 = setup("/player/boy_right_2");	
	}
	public void getSleepingImage(BufferedImage image)
	{
		up1 = image;
		up2 = image;
		down1 = image;
		down2 = image;
		left1 = image;
		left2 = image;
		right1 = image;
		right2 = image;
	}
	public void getPlayerAttackImage()
	{
		if(currentWeapon.type == type_sword)
		{
			attackUp1 = setupAttackImage("/player/boy_attack_up_1",gp.tileSize,gp.tileSize*2);
			attackUp2 = setupAttackImage("/player/boy_attack_up_2",gp.tileSize,gp.tileSize*2);
			attackDown1 = setupAttackImage("/player/boy_attack_down_1",gp.tileSize,gp.tileSize*2);
			attackDown2 = setupAttackImage("/player/boy_attack_down_2",gp.tileSize,gp.tileSize*2);
			attackLeft1 = setupAttackImage("/player/boy_attack_left_1",gp.tileSize*2,gp.tileSize);
			attackLeft2 = setupAttackImage("/player/boy_attack_left_2",gp.tileSize*2,gp.tileSize);
			attackRight1 = setupAttackImage("/player/boy_attack_Right_1",gp.tileSize*2,gp.tileSize);
			attackRight2 = setupAttackImage("/player/boy_attack_Right_2",gp.tileSize*2,gp.tileSize);
		}
		if(currentWeapon.type == type_axe)
		{
			attackUp1 = setupAttackImage("/player/boy_axe_up_1",gp.tileSize,gp.tileSize*2);
			attackUp2 = setupAttackImage("/player/boy_axe_up_2",gp.tileSize,gp.tileSize*2);
			attackDown1 = setupAttackImage("/player/boy_axe_down_1",gp.tileSize,gp.tileSize*2);
			attackDown2 = setupAttackImage("/player/boy_axe_down_2",gp.tileSize,gp.tileSize*2);
			attackLeft1 = setupAttackImage("/player/boy_axe_left_1",gp.tileSize*2,gp.tileSize);
			attackLeft2 = setupAttackImage("/player/boy_axe_left_2",gp.tileSize*2,gp.tileSize);
			attackRight1 = setupAttackImage("/player/boy_axe_Right_1",gp.tileSize*2,gp.tileSize);
			attackRight2 = setupAttackImage("/player/boy_axe_Right_2",gp.tileSize*2,gp.tileSize);
		}
		if(currentWeapon.type == type_pickaxe)
		{
			attackUp1 = setupAttackImage("/player/boy_pick_up_1",gp.tileSize,gp.tileSize*2);
			attackUp2 = setupAttackImage("/player/boy_pick_up_2",gp.tileSize,gp.tileSize*2);
			attackDown1 = setupAttackImage("/player/boy_pick_down_1",gp.tileSize,gp.tileSize*2);
			attackDown2 = setupAttackImage("/player/boy_pick_down_2",gp.tileSize,gp.tileSize*2);
			attackLeft1 = setupAttackImage("/player/boy_pick_left_1",gp.tileSize*2,gp.tileSize);
			attackLeft2 = setupAttackImage("/player/boy_pick_left_2",gp.tileSize*2,gp.tileSize);
			attackRight1 = setupAttackImage("/player/boy_pick_Right_1",gp.tileSize*2,gp.tileSize);
			attackRight2 = setupAttackImage("/player/boy_pick_Right_2",gp.tileSize*2,gp.tileSize);
		}
	}
	public void getGuardImage()
	{
		guardUp = setup("/player/boy_guard_up");
		guardDown = setup("/player/boy_guard_down");
		guardLeft = setup("/player/boy_guard_left");
		guardRight = setup("/player/boy_guard_right");
	}
	public void update()	
	{
		if(knockBack == true)
		{
			//CHECK TILE COLLISION
			collisionOn = false;
			gp.cChecker.checkTile(this);
			// CHECK OBJECTS COLLISION
			gp.cChecker.checkObject(this, true);
			// CHECk NPC COLLISION
			gp.cChecker.CheckEntity(this, gp.npc);
			//CHECK MONSTER COLLISION
			gp.cChecker.CheckEntity(this, gp.monster);
			//CHECK INTERACTIVE TILE COLLISION
			gp.cChecker.CheckEntity(this, gp.iTile);
			
			if(collisionOn == true)
			{
				knockBackCounter = 0;
				knockBack = false;
				speed = defaultSpeed;
			}
			else if(collisionOn == false)
			{
				switch(knockBackDirection)
				{
				case "up": worldY -= speed;break;			
				case "down":worldY += speed;break;			
				case "left":worldX -= speed;break;				
				case "right":worldX += speed;break;
				}
			}
			knockBackCounter++;
			if(knockBackCounter == 10)
			{
				knockBackCounter = 0;
				knockBack = false;
				speed = defaultSpeed;
			}
		}
		
		else if(attacking == true)
		{
			attacking();
		}
		else if(keyH.spacePressed == true)
		{
			guarding = true;
			guardCounter++;
		}
		else if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed == true) 
		{
			if(keyH.upPressed == true) 
			{
				direction = "up";
				
			}
			else if(keyH.downPressed == true) 
			{
				direction = "down";

			}
			else if(keyH.leftPressed == true) 
			{
				direction = "left";
				
			}
			else if(keyH.rightPressed == true) 
			{
				direction = "right";
				
			}
			
			//CHECK TILE COLLISION
			
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			// CHECK OBJECTS COLLISION
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			// CHECk NPC COLLISION
			int npcIndex = gp.cChecker.CheckEntity(this, gp.npc);
			interactNPC(npcIndex);
			
			//CHECK MONSTER COLLISION
			int monsterIndex = gp.cChecker.CheckEntity(this, gp.monster);
			contactMonster(monsterIndex);
			
			//CHECK INTERACTIVE TILE COLLISION
			int iTileIndex = gp.cChecker.CheckEntity(this, gp.iTile);
			
			// CHECK EVENT
			gp.eHandler.checkEvent();
			
			
			
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			if(collisionOn == false && keyH.enterPressed == false)
			{
				switch(direction)
				{
				case "up": 
					worldY -= speed;
					break;
					
				case "down":
					worldY += speed;
					break;
					
				case "left":
					worldX -= speed;
					break;
					
				case "right":
					worldX += speed;
					break;
				}
			}
			if(keyH.enterPressed == true && attackCanceled == false)
			{
				attacking = true;
				spriteCounter = 0;
			}
			attackCanceled = false;
			gp.keyH.enterPressed = false;
			guarding = false;
			guardCounter = 0;
			
			spriteCounter++;
			if(spriteCounter > 12) 
			{
				if(spriteNum == 1 ) 
				{
					spriteNum = 2;
				}
				else if(spriteNum == 2) 
				{
					
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			if(life > maxLife)
			{
				life = maxLife;
			}
			if(mana > maxMana)
			{
				mana = maxMana;
			}
			if(life <= 0)
			{
				gp.stopMusic();
				gp.gameState = gp.gameOverState;
				gp.ui.commandNum = -1;
				
				gp.playSE(11);		
			}
		}
		
		if(gp.keyH.shotKeyPressed == true && projectile.alive == false && shotAvailableCounter == 30 && projectile.haveResource(this) == true)
		{
			//SET DEFAULT COORDINATES, DIRECTION AND USER
			projectile.set(worldX, worldY, direction, true, this);
			
			//SUBTREACT THE COST (MANA,AMMO ITP)
			projectile.subtractResource(this);
			//CHECK VACANCY
			for(int i = 0; i < gp.projectile[1].length; i++)
			{
				if(gp.projectile[gp.currentMap][i] == null)
				{
					gp.projectile[gp.currentMap][i] = projectile;
					break;
				}
			}
			shotAvailableCounter = 0;
			
			gp.playSE(9);
		}
		if(invincible == true)
		{
			invincibleCounter++;
			if(invincibleCounter > 60)
			{
				invincible = false;
				transparent = false;
				invincibleCounter = 0;
			}
		}
		if(shotAvailableCounter < 30)
		{
			shotAvailableCounter++;
		}
		
	}
	public void pickUpObject(int i)
	{

		if(i != 999)
			//PICKUP ONLY ITEMS
			if(gp.obj[gp.currentMap][i].type == type_pickupOnly)
			{
				gp.obj[gp.currentMap][i].use(this);
				gp.obj[gp.currentMap][i] = null;
			}
			//OBSTANCLE
			else if(gp.obj[gp.currentMap][i].type == type_obstacle)
			{
				if(keyH.enterPressed == true);
				{
					attackCanceled = true;
					gp.obj[gp.currentMap][i].interact();
				}
			}
			
			// INVENTORY ITEMS
			else 
			{
					String text;
					if(canObatinItem(gp.obj[gp.currentMap][i]) == true)
					{
						gp.playSE(1);
						text = "Got a " + gp.obj[gp.currentMap][i].name + "!";
					}
					else {
						text = "You cannot carry any more!";
					}
					gp.ui.addMessage(text);
					gp.obj[gp.currentMap][i] = null;
			}
	}
	public void interactNPC(int i)
	{
		
		if(i != 999)
		{
			if(gp.keyH.enterPressed == true)
			{
				attackCanceled = true;
				gp.npc[gp.currentMap][i].speak();
			}
			gp.npc[gp.currentMap][i].move(direction);
		}
		
	}
	public void contactMonster(int i)
	{
		if(i != 999)
		{
			if(gp.player.invincible == false && gp.monster[gp.currentMap][i].dying == false)
			{
				gp.playSE(6);
				
				int damage = gp.monster[gp.currentMap][i].attack - defense;
				if(damage < 1)
				{
					damage = 1;
				}
				life -= damage;
				invincible = true;
				transparent = true;
				if(life < 0)
				{
					life = 0;
				}
			}
		}
	}
	public void damageMonster(int i, Entity attacker, int attack, int knockBackPower)
	{
		if(i != 999)
		{
			if(gp.monster[gp.currentMap][i].invincible == false)
			{
				gp.playSE(5);
				
				if(knockBackPower > 0)
				{
					setKnockBack(gp.monster[gp.currentMap][i], attacker, knockBackPower);
				}
				
				if(gp.monster[gp.currentMap][i].offBalance == true)
				{
					attack *=5;
				}
				
				int damage = attack - gp.monster[gp.currentMap][i].defense;
				if(damage < 0)
				{
					damage = 0;
				}
				gp.monster[gp.currentMap][i].life -= damage;
				gp.ui.addMessage(damage + " damage!");
				gp.monster[gp.currentMap][i].invincible = true;
				gp.monster[gp.currentMap][i].damageReaction();
				
				if(gp.monster[gp.currentMap][i].life <= 0)
				{
					gp.monster[gp.currentMap][i].dying = true;
					gp.ui.addMessage("killed the "+ gp.monster[gp.currentMap][i].name + "!");
					gp.ui.addMessage("Exp " + gp.monster[gp.currentMap][i].exp);
					exp += gp.monster[gp.currentMap][i].exp;
					checkLevelUp();
				}
			}
		}
	}
	public void knockBack(Entity entity,int knockBackPower)
	{
		entity.direction = direction;
		entity.speed += knockBackPower;
		entity.knockBack = true;
		
	}
	public void damageInteractiveTile(int i)
	{
		if(i != 999 && gp.iTile[gp.currentMap][i].destructible == true && gp.iTile[gp.currentMap][i].isCorrectItem(this) == true && gp.iTile[gp.currentMap][i].invincible == false)
		{
			gp.iTile[gp.currentMap][i].playSE();
			gp.iTile[gp.currentMap][i].life--;
			gp.iTile[gp.currentMap][i].invincible = true;
			
			// Generate particle
			generateParticle(gp.iTile[gp.currentMap][i],gp.iTile[gp.currentMap][i]);
			
			if(gp.iTile[gp.currentMap][i].life == 0)
			{
//				gp.iTile[gp.currentMap][i].checkDrop();
				gp.iTile[gp.currentMap][i] = gp.iTile[gp.currentMap][i].getDestroyedForm();
			}
		}
	}
	public void damageProjectile(int i)
	{
		if(i != 999)
		{
			Entity projectile = gp.projectile[gp.currentMap][i];
			projectile.alive = false;
			generateParticle(projectile,projectile);
		}
	}
	public void checkLevelUp()
	{
		if(exp >= nextLevelExp)
		{
			level++;
			nextLevelExp = nextLevelExp*3;
			maxLife += 2;
			strenght++;
			dexterity ++;
			attack = getAttack();
			defense = getDefense();
			gp.playSE(7);
			gp.gameState = gp.dialogueState;

			setDialogue();
			startDialogue(this,0);
		}
	}
	public void selectItem()
	{
		int itemIndex = gp.ui.getItemIndexOnSlot(gp.ui.playerSlotCol,gp.ui.playerSlotRow);
		if(itemIndex < inventory.size())
		{
			Entity selectedItem = inventory.get(itemIndex);
			
			if(selectedItem.type == type_sword || selectedItem.type == type_axe || selectedItem.type == type_pickaxe)
			{
				currentWeapon = selectedItem;
				attack = getAttack();
				getPlayerAttackImage();
			}
			if(selectedItem.type == type_shield)
			{
				currentShield = selectedItem;
				defense = getDefense();
			}
			if(selectedItem.type == type_light)
			{
				if(currentLight == selectedItem)
				{
					currentLight = null;
				}
				else
				{
					currentLight = selectedItem;
				}
				lightUpdated = true;
			}
			if(selectedItem.type == type_consumable)
			{
				if(selectedItem.use(this) == true)
				{
					if(selectedItem.amount > 1)
					{
						selectedItem.amount--;
					}
					else
					{
						inventory.remove(itemIndex);
					}
				}
			}
		}
	}
	public int searchItemInInventory(String itemName)
	{
		int itemIndex = 999;
		
		for(int i = 0; i < inventory.size(); i++) 
		{
			if(inventory.get(i).name.equals(itemName))
			{
				itemIndex = i;
				break;
			}
		}
		return itemIndex;
	}
	public boolean canObatinItem(Entity item)
	{
		boolean canObtain = false;
		
		Entity newItem = gp.eGenerator.getObject(item.name);
		
		// Check if stackable
		if(newItem.stackable == true)
		{
			int index = searchItemInInventory(newItem.name);
			
			if(index != 999)
			{
				inventory.get(index).amount++;
				canObtain = true;
			}
			else // new item so need to check vacancy
			{
				if(inventory.size() != maxInventorySize)
				{
					inventory.add(newItem);
					canObtain = true;
				}
			}
		}
		else // not stackable so check vacancy
		{
			if(inventory.size() != maxInventorySize)
			{
				inventory.add(newItem);
				canObtain = true;
			}
		}
		return canObtain;
	}
	public void draw(Graphics2D g2) {
		
		//g2.setColor(Color.white);
		
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image = null;
		int tempScreenX = screenX;
		int tempScreenY = screenY;
		
		switch(direction) 
		{
		case "up":
			if(attacking == false)
			{
				if(spriteNum == 1) {image = up1;}
				if(spriteNum == 2) {image = up2;}
			}
			if(attacking == true)
			{
				tempScreenY = screenY - gp.tileSize;
				if(spriteNum == 1) {image = attackUp1;}
				if(spriteNum == 2) {image = attackUp2;}
			}
			if(guarding == true)
			{
				image = guardUp;
			}
			break;
		case "down":
			if(attacking == false) 
			{
				if(spriteNum == 1) {image = down1;}
				if(spriteNum == 2) {image = down2;}
			}
			if(attacking == true)
			{
				if(spriteNum == 1) {image = attackDown1;}
				if(spriteNum == 2) {image = attackDown2;}
			}
			if(guarding == true)
			{
				image = guardDown;
			}
			break;
		case "right":
			if(attacking == false)
			{
				if(spriteNum == 1) {image = right1;}
				if(spriteNum == 2) {image = right2;}
			}
			if(attacking == true)
			{
				if(spriteNum == 1) {image = attackRight1;}
				if(spriteNum == 2) {image = attackRight2;}
			}
			if(guarding == true)
			{
				image = guardRight;
			}
			break;
		case "left":
			if(attacking == false)
			{
				if(spriteNum == 1) {image = left1;}
				if(spriteNum == 2) {image = left2;}
			}
			if(attacking == true)
			{
				tempScreenX = screenX - gp.tileSize;
				if(spriteNum == 1) {image = attackLeft1;}
				if(spriteNum == 2) {image = attackLeft2;}
			}
			if(guarding == true)
			{
				image = guardLeft;
			}
			break;
		}
		if(transparent == true)
		{
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		}
		if(drawing == true)
		{
			g2.drawImage(image, tempScreenX, tempScreenY, null);
		}

		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	}
}
