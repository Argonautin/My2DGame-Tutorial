package main;

import Entity.Entity;
import Object.OBJ_Axe;
import Object.OBJ_Boots;
import Object.OBJ_Chest;
import Object.OBJ_Coin_Bronze;
import Object.OBJ_Door;
import Object.OBJ_Door_Iron;
import Object.OBJ_Fireball;
import Object.OBJ_Heart;
import Object.OBJ_Key;
import Object.OBJ_Lantern;
import Object.OBJ_ManaCrystal;
import Object.OBJ_Pickaxe;
import Object.OBJ_Red_Potion;
import Object.OBJ_Rock;
import Object.OBJ_Shield_Blue;
import Object.OBJ_Shield_Wood;
import Object.OBJ_Sword_Normal;
import Object.OBJ_Tent;

public class EntityGenerator {

	GamePanel gp;
	public EntityGenerator(GamePanel gp)
	{
	this.gp = gp;	
	}
	public Entity getObject(String itemName)
	{
		Entity obj = null;
		
		switch(itemName)
		{
		case OBJ_Axe.objName: obj = new OBJ_Axe(gp); break;
		case OBJ_Pickaxe.objName: obj = new OBJ_Pickaxe(gp); break;
		case OBJ_Boots.objName: obj = new OBJ_Boots(gp); break;
		case OBJ_Chest.objName: obj = new OBJ_Chest(gp); break;
		case OBJ_Coin_Bronze.objName: obj = new OBJ_Coin_Bronze(gp); break;
		case OBJ_Door.objName: obj = new OBJ_Door(gp); break;
		case OBJ_Door_Iron.objName: obj = new OBJ_Door_Iron(gp); break;
		case OBJ_Fireball.objName: obj = new OBJ_Fireball(gp); break;
		case OBJ_Heart.objName: obj = new OBJ_Heart(gp); break;
		case OBJ_Key.objName: obj = new OBJ_Key(gp); break;
		case OBJ_Lantern.objName: obj = new OBJ_Lantern(gp); break;
		case OBJ_ManaCrystal.objName: obj = new OBJ_ManaCrystal(gp); break;
		case OBJ_Red_Potion.objName: obj = new OBJ_Red_Potion(gp); break;
		case OBJ_Rock.objName: obj = new OBJ_Rock(gp); break;
		case OBJ_Shield_Blue.objName: obj = new OBJ_Shield_Blue(gp); break;
		case OBJ_Shield_Wood.objName: obj = new OBJ_Shield_Wood(gp); break;
		case OBJ_Sword_Normal.objName: obj = new OBJ_Sword_Normal(gp); break;
		case OBJ_Tent.objName: obj = new OBJ_Tent(gp); break;

		}
		return obj; 
	}
}
