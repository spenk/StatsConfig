public class StatsConfigListener extends PluginListener {
	  public StatsConfigListener() {
	  }
	  public boolean onCommand(Player player, String[] split) {
		  if ((split[0].equalsIgnoreCase("/sc-help")) && (player.canUseCommand("/sc-help"))){
			  if (split.length >= 2){
   				 player.sendMessage("§9StatsConfig help page 1/3");
  				  player.sendMessage("§c/feed,feed yourself or another player.");
  				  player.sendMessage("§c/heal, Heal yourself or another player.");
  				  player.sendMessage("§c/kill, kills anoter player.");
  				  player.sendMessage("§c/maim, maim yourself or another player.");
  				  player.sendMessage("§c/slap, slap yourself or another player.");
  				  player.sendMessage("§c/die, commit suecide.");
  				  player.sendMessage("§c/massmurder kill evryone.");
  				  
     				return true;
			  }
			  else if (split.length >= 2){
		      		
		      	}
		      		try{
		      			if (split[1].equalsIgnoreCase("1")){
		      				 player.sendMessage("§9StatsConfig help page 1/3");
		   				  player.sendMessage("§c/feed,feed yourself or another player.");
		   				  player.sendMessage("§c/heal, Heal yourself or another player.");
		   				  player.sendMessage("§c/kill, kills anoter player.");
		   				  player.sendMessage("§c/maim, maim yourself or another player.");
		   				  player.sendMessage("§c/slap, slap yourself or another player.");
		   				  player.sendMessage("§c/die, commit suecide.");
		   				  player.sendMessage("§c/massmurder kill evryone.");
		      				return true;
		      			}
		      			if (split[1].equalsIgnoreCase("2")) {
		      				 player.sendMessage("§9StatsConfig help page 2/3");
		  				  player.sendMessage("§c/starvate, starvate yourself or another player.");
						  player.sendMessage("§c/exp [get|set|add|remove] [player] [amount], get sets or removes player exp.");//*
						 // player.sendMessage("§c/burn, lightens yourself, another player");
						  player.sendMessage("§c/explain <SC command without />, explains a SC command.");
						  player.sendMessage("§c/fl [get|set|add|remove] [player] [amount] gets,sets,adds,removes player foodlevel.");
						  player.sendMessage("§c/health [get|set|add|remove] [player] [amount] gets,sets,adds,removes player health.");
						  player.sendMessage("§9total 12 commands.");
		      				return true;
		      			}
		            player.sendMessage("§cUsage - /sc-help <1,2,3>");
		          }
		          catch (Throwable t)
		          {
		            player.sendMessage("§cUsage - /sc-help <1,2,3>");
		          }
		        return true;
		      }
		  
		  
          if ((split[0].equalsIgnoreCase("/fl")) && (player.canUseCommand("/fl"))) {
              if (split.length >= 3)
                try {
               Player player2 = etc.getServer().matchPlayer(split[2]);
                  if (player2 == null)
        	        {
        	          player.sendMessage("§cthis player doesn not exist or is currently not logged in!");
        	          return true;
        	        }
                  if (split[1].equalsIgnoreCase("get")) {
                	  if (player2.getFoodLevel() >= 10 )
                          player.sendMessage("§a" + player2.getName() + "'s foodlevel: §2"+ player2.getFoodLevel()*5 +"% "+ "§a.");
                	  else
                		  if (player2.getFoodLevel() <= 10 )
                			  player.sendMessage("§a" + player2.getName() + "'s foodlevel: §4" + player2.getFoodLevel()*5 +"% "+ "§a.");
                  }
                  if (split.length < 4) return true; int foodl = Integer.parseInt(split[3])/5;
                  
                  if (foodl*5 >= 101){
                	  player.sendMessage(player2.getName() + "§a isnt hungry that much.");
                	  return true;
                  }
                  if (foodl <= -1){
                	  player.sendMessage("you cant feed anyone less than 0");
                	  return true;
                  }
                  if (split[1].equalsIgnoreCase("set")) {
                    player2.getEntity().M = 0;
                    player2.setFoodLevel(foodl);
                    player.sendMessage("§a" + player2.getName() + "'s foodlevel was set to " + foodl*5 +"%.");
                    player2.sendMessage("§a" + player.getName() + " set your foodlevel " + foodl*5 + "%."); return true;
                  }
                  if (split[1].equalsIgnoreCase("add")) {
                	  int gfl = player2.getFoodLevel() + foodl;
                	  player2.setFoodLevel(gfl);
                    player.sendMessage("§a" + foodl*5 + "% food was added to " + player2.getName() + ".");
                    player2.sendMessage("§a" + player.getName() + " added " + foodl*5 + "% to your foodlevel."); return true;
                  }
                  if (split[1].equalsIgnoreCase("remove")) {
                	if (foodl > player2.getFoodLevel()){
                		player.sendMessage(player2.getName()+"§a hasnt that much food left to remove it.");
                		return true;
                	}
                	if (foodl <= 0){
                		player.sendMessage("§cyou cant feed a player this way use /fl [set|add] or /feed");
                		return true;
                	}
                    player2.getEntity().M = 0;
                    int rfl = player2.getFoodLevel() - foodl;
                    player2.setFoodLevel(rfl);
                    player.sendMessage("§a" + foodl*5 + "% food was removed from " + player2.getName() + ".");
                    player2.sendMessage("§a" + player.getName() + " removed " + foodl*5 + "% from your foodlevel."); return true;
                  }
                  player.sendMessage("§cUsage - /fl [get|set|add|remove] [player] [amount]");
                }
                catch (Throwable t)
                {
                  player.sendMessage("§cUsage - /fl [get|set|add|remove] [player] [amount]");
                }
              else {
                player.sendMessage("§cUsage - /fl [get|set|add|remove] [player] [amount]");
              }
              return true;
            }

          
          
          if ((split[0].equalsIgnoreCase("/health")) && (player.canUseCommand("/health"))) {
              if (split.length >= 3)
                try {
                	Player player2 = etc.getServer().matchPlayer(split[2]);
                  if (player2 == null)
        	        {
        	          player.sendMessage("§cthis player doesn not exist or is currently not logged in!");
        	          return true;
        	        }
                  if (split[1].equalsIgnoreCase("get")) {
                	  if (player2.getHealth() >= 10 )
                          player.sendMessage("§a" + player2.getName() + "'s health: §2"+ player2.getHealth()*5 +"% "+ "§a.");
                	  else
                		  if (player2.getHealth() <= 10 )
                			  player.sendMessage("§a" + player2.getName() + "'s health: §4" + player2.getHealth()*5 +"% "+ "§a.");
                  }
                  if (split.length < 4) return true; int healthl = Integer.parseInt(split[3])/5;
                  
                  if (healthl*5 >= 101){
                	  player.sendMessage(player2.getName() + "§a isnt hungry that much.");
                	  return true;
                  }
                  if (healthl <= -1){
                	  player.sendMessage("you cant heal anyone less than 0");
                	  return true;
                  }
                  if (split[1].equalsIgnoreCase("set")) {
                    player2.getEntity().M = 0;
                    player2.setHealth(healthl);
                    player.sendMessage("§a" + player2.getName() + "'s health was set to " + healthl*5 +"%.");
                    player2.sendMessage("§a" + player.getName() + " set your health to " + healthl*5 + "%."); return true;
                  }
                  if (split[1].equalsIgnoreCase("add")) {
                	  int gfl = player2.getHealth() + healthl;
                	  player2.setHealth(gfl);
                    player.sendMessage("§a" + healthl*5 + "% health was added to " + player2.getName() + ".");
                    player2.sendMessage("§a" + player.getName() + " added " + healthl*5 + "% to your health."); return true;
                  }
                  if (split[1].equalsIgnoreCase("remove")) {
                	if (healthl > player2.getHealth()){
                		player.sendMessage(player2.getName()+"§a hasnt that much health left to remove it.");
                		return true;
                	}
                	if (healthl <= 0){
                		player.sendMessage("§cyou cant heal a player this way use /health [set|add] or /heal");
                		return true;
                	}
                    player2.getEntity().M = 0;
                    int rfl = player2.getHealth() - healthl;
                    player2.setHealth(rfl);
                    player.sendMessage("§a" + healthl*5 + "% health was removed from " + player2.getName() + ".");
                    player2.sendMessage("§a" + player.getName() + " removed " + healthl*5 + "% from your health."); return true;
                  }
                  player.sendMessage("§cUsage - /health [get|set|add|remove] [player] [amount]");
                }
                catch (Throwable t)
                {
                  player.sendMessage("§cUsage - /health [get|set|add|remove] [player] [amount]");
                }
              else {
                player.sendMessage("§cUsage - /health [get|set|add|remove] [player] [amount]");
              }
              return true;
            }

          
          
		  if ((split[0].equalsIgnoreCase("/feed")) && (player.canUseCommand("/feed")))
	      {
	        if (split.length < 2)
	        {
	          player.sendMessage("§ayou have fed yourself.");
	          player.setFoodLevel(20);
	          return true;
	        }
	        Player player2 = etc.getServer().matchPlayer(split[2]);
	        if (player2 == null)
	        {
	          player.sendMessage("§cthis player doesn not exist or is currently not logged in!");
	          return true;
	        }
	        if (player2.getPlayer() == player.getPlayer())
	        {
	          player.sendMessage("§b[tip]To feed yourself, type '/feed'.");
	          return true;
	        }
	        player.sendMessage("§a"+player2.getName() + " has been fed.");
	        player2.sendMessage("§a"+player.getName() + " has fed you.");
	        player2.setFoodLevel(20);
	        return true;
	      }
		  
		  
		  
          if ((split[0].equalsIgnoreCase("/starvate")) && (player.canUseCommand("/starvate")))
		      {
		        if (split.length < 2)
		        {
		          player.sendMessage("§ayou starvated yourself!");
		          player.setFoodLevel(0);
		          return true;
		        }
		        Player player2 = etc.getServer().matchPlayer(split[2]);
		        if (player2 == null)
		        {
		          player.sendMessage("§cthis player doesn not exist or is currently not logged in!");
		          return true;
		        }
		        if (player2.getPlayer() == player.getPlayer())
		        {
		          player.sendMessage("§b[tip]To starvate yourself, type '/starvate'.");
		          return true;
		        }
		        player.sendMessage("§a"+player2.getName() + " has been starvated.");
		        player2.sendMessage("§a"+player.getName() + " has starvated you.");
		        player2.setFoodLevel(0);
		        return true;
		      }
          
          
          
          if ((split[0].equalsIgnoreCase("/exp")) && (player.canUseCommand("/exp"))) {
            if (split.length >= 3)
              try {
            	 Player player2 = etc.getServer().matchPlayer(split[2]);
                if (split[1].equalsIgnoreCase("get")) {
                  player.sendMessage("§a" + player2.getName() + "'s XP: " + player2.getXP() + ". Level: " + player2.getLevel());
                }
                if (split.length < 4) return true; int exp = Integer.parseInt(split[3]);
                if (split[1].equalsIgnoreCase("set")) {
                  player2.getEntity().M = 0;
                  player2.setXP(exp);
                  player.sendMessage("§a" + player2.getName() + "'s XP was set to " + exp);
                  player2.sendMessage("§a" + player.getName() + " set your XP " + exp); return true;
                }
                if (split[1].equalsIgnoreCase("add")) {
                  player2.addXP(exp);
                  player.sendMessage("§a" + exp + " XP was added to " + player2.getName() + ".");
                  player2.sendMessage("§a" + player.getName() + " added " + exp + " to your XP."); return true;
                }
                if (split[1].equalsIgnoreCase("remove")) {
                  player2.getEntity().M = 0;
                  exp = player2.getXP() - exp;
                  player2.setXP(exp);
                  player.sendMessage("§a" + exp + " XP was removed from " + player2.getName() + ".");
                  player2.sendMessage("§e" + player.getName() + " removed " + exp + " from your XP."); return true;
                }
                player.sendMessage("§cUsage - /exp [get|set|add|remove] [player] [amount]");
              }
              catch (Throwable t)
              {
                player.sendMessage("§cUsage - /exp [get|set|add|remove] [player] [amount]");
              }
            else {
              player.sendMessage("§cUsage - /exp [get|set|add|remove] [player] [amount]");
            }
            return true;
          }
          
          
          
          if ((split[0].equalsIgnoreCase("/burn")) && (player.canUseCommand("/burn")))
	      {
	        if (split.length < 2)
	        {
	          player.sendMessage("§ayou burned yourself");
	          player.setFireTicks(20);
	          return true;
	        }
	        Player player2 = etc.getServer().matchPlayer(split[2]);
	        if (player2 == null)
	        {
	          player.sendMessage("§cthis player doesn not exist or is currently not logged in!");
	          return true;
	        }
	        if (player2.getPlayer() == player.getPlayer())
	        {
	          player.sendMessage("§b[tip]To light yourself, type '/burn'.");
	          return true;
	        }
	        player.sendMessage("§a"+player2.getName() + " has been lighted.");
	        player2.sendMessage("§a"+player.getName() + " has lighted you.");
	        player2.setFireTicks(20);
	        return true;
	      }
          
          
          
		  if ((split[0].equalsIgnoreCase("/heal")) && (player.canUseCommand("/heal")))
	      {
	        if (split.length < 2)
	        {
	          player.sendMessage("§ayou healed yourself.");
	          player.setHealth(20);
	          return true;
	        }
	        Player player2 = etc.getServer().matchPlayer(split[2]);
	        if (player2 == null)
	        {
	          player.sendMessage("§cthis player doesn not exist or is currently not logged in!");
	          return true;
	        }
	        if (player2.getPlayer() == player.getPlayer())
	        {
	          player.sendMessage("§b[tip]To heal yourself, type '/heal'.");
	          return true;
	        }
	        player.sendMessage("§a"+player2.getName() + " has been healed.");
	        player2.sendMessage("§a"+player.getName() + " has healed you.");
	        player2.setHealth(20);
	        return true;
	      }
		  
		  
		  
		          if ((split[0].equalsIgnoreCase("/kill")) && (player.canUseCommand("/kill")))
		          {
		  	        if (split.length < 2)
		  	        {
		  	          player.sendMessage("§ato commit suecide type /die.");
		  	          return true;
		  	        }
		  	      Player player2 = etc.getServer().matchPlayer(split[2]);
		  	        if (player2 == null)
		  	        {
		  	          player.sendMessage("§cthis player doesn not exist or is currently not logged in!");
		  	          return true;
		  	        }
		  	        if (player2.getPlayer() == player.getPlayer())
		  	        {
		  	          player.sendMessage("§b[tip]To commit suecide, type '/die'.");
		  	          return true;
		  	        }
		  	        player.sendMessage("§a"+player2.getName() + " has been killed.");
		  	        player2.sendMessage("§a"+player.getName() + " has killed you.");
		  	        player2.setHealth(00);
		  	        return true;
		          }
		          
		          
		          
				  if ((split[0].equalsIgnoreCase("/maim")) && (player.canUseCommand("/maim")))
			      {
			        if (split.length < 2)
			        {
			          player.sendMessage("§ayou maimed yourself.");
			          player.setHealth(1);
			          return true;
			        }
			        Player player2 = etc.getServer().matchPlayer(split[2]);
			        if (player2 == null)
			        {
			          player.sendMessage("§cthis player doesn not exist or is currently not logged in!");
			          return true;
			        }
			        if (player2.getPlayer() == player.getPlayer())
			        {
			          player.sendMessage("§b[tip]To maim yourself, type '/maim'.");
			          return true;
			        }
			        player.sendMessage("§a"+player2.getName() + " has been maimed.");
			        player2.sendMessage("§a"+player.getName() + " has maimed you.");
			        player2.setHealth(1);
			        return true;
			      }
				  
				  
				  
	  if ((split[0].equalsIgnoreCase("/slap")) && (player.canUseCommand("/slap")))
      {
        if (split.length < 2)
        {
          player.sendMessage("you slapped yourself.");
          int health = player.getHealth() -1;
          player.setHealth(health);
          return true;
        }
        Player player2 = etc.getServer().matchPlayer(split[2]);
        if (player2 == null)
        {
          player.sendMessage("§cthis player doesn not exist or is currently not logged in!");
          return true;
        }
        if (player2.getPlayer() == player.getPlayer())
        {
          player.sendMessage("§b[tip]To slap yourself, type '/slap'.");
          return true;
        }
        int health2 = player2.getHealth() -2;
        player.sendMessage("§a"+player2.getName() + " has been slapped.");
        player2.sendMessage("§a"+player.getName() + " has slapped you.");
        player2.setHealth(health2);
        return true;
      }
	  
	  
	  
	  if ((split[0].equalsIgnoreCase("/explain")) && (player.canUseCommand("/explain"))){
      	if (split.length >= 2){
      		
      	}
      		try{
      			if (split[1].equalsIgnoreCase("sc-help")){
      				player.sendMessage("§2SC-CMD Dictionary /sc-help");
      				player.sendMessage("§3usage: /sc-help");
      				player.sendMessage("§6result /sc-help: shows you all SC commands");
      				return true;
      			}
      			if (split[1].equalsIgnoreCase("feed")) {
      				player.sendMessage("§2SC-CMD Dictionary /feed.");
      				player.sendMessage("§3usage: /feed or /feed <player>.");
      				player.sendMessage("§6result /feed: sets your foodlevel to max (20).");
      				player.sendMessage("§6result /feed <player>: sets <player> foodlevel to max(20).");
      				return true;
      			}
      			if (split[1].equalsIgnoreCase("heal")) {
      				player.sendMessage("§2SC-CMD Dictionary /heal.");
      				player.sendMessage("§3usage: /heal or /heal <player>.");
      				player.sendMessage("§6result /heal: sets your Health to max (20).");
      				player.sendMessage("§6result /heal <player>: sets <player> Health to max(20).");
      			return true;
      			}
      			if (split[1].equalsIgnoreCase("kill")) {
      				player.sendMessage("§2SC-CMD Dictionary /kill.");
      				player.sendMessage("§3usage: /kill <player>");
      				player.sendMessage("§6result /kill <player>: sets <player> Health to min (00).");
      				player.sendMessage("§6result /kill <player>: kills a player");
      				return true;
      			}
      			if (split[1].equalsIgnoreCase("maim")) {
      				player.sendMessage("§2SC-CMD Dictionary /maim.");
      				player.sendMessage("§3usage: /maim <player> or /maim.");
      				player.sendMessage("§6result /maim: sets your Health to (1).");
      				player.sendMessage("§6result /maim <player>: sets <player> Health to (1).");
      				return true;
      		}
      			if (split[1].equalsIgnoreCase("slap")) {
      				player.sendMessage("§2SC-CMD Dictionary /slap.");
      				player.sendMessage("§3usage: /slap <player> or /slap.");
      				player.sendMessage("§6result /slap: decreases your health with 1.");
      				player.sendMessage("§6result /slap <player>: decreases <player> health with 1");
      				return true;
      	}
      			if (split[1].equalsIgnoreCase("die")) {
      				player.sendMessage("§2SC-CMD Dictionary /kill.");
      				player.sendMessage("§3usage: /die.");
      				player.sendMessage("§6result /die: sets your Health to (0).");
      				player.sendMessage("§6result /die: commit suecide (kill yourself) .");
      				return true;
      }
      			if (split[1].equalsIgnoreCase("massmurder")) {
      				player.sendMessage("§2SC-CMD Dictionary /massmurder.");
      				player.sendMessage("§3usage: /massmurder.");
      				player.sendMessage("§6result /massmurder: sets health of all players (except you) to 0."); 
      				player.sendMessage("§6result /massmurder: kill all players except you");
      				return true;
      	}
      			if (split[1].equalsIgnoreCase("starvate")) {
      				player.sendMessage("§2SC-CMD Dictionary /starvate.");
      				player.sendMessage("§3usage: /starvate <player> or /starvate.");
      				player.sendMessage("§6result /starvate: sets your FoodLevel to 0.");
      				player.sendMessage("§6result /starvate <player>: sets <player> FoodLevel to 0");
      				return true;
      	}
      			if (split[1].equalsIgnoreCase("exp")) {
      				player.sendMessage("§2SC-CMD Dictionary /exp.");
      				player.sendMessage("§3usage: /exp [get|set|add|remove] <player> <amount>");
      				player.sendMessage("§9exampl /exp set player 10");
      				player.sendMessage("§6result /exp get: gets player XP and level");
      				player.sendMessage("§6result /exp set: sets player XP to [int amount]");
      				player.sendMessage("§6result /exp add: adds [int amount] to player XP");
      				player.sendMessage("§6result /exp remove: removes [int amount] XP from player");
      				return true;
      	}
      			//if (split[1].equalsIgnoreCase("burn")) {
      				//player.sendMessage("§2SC-CMD Dictionary /burn.");
      				//player.sendMessage("§3usage: /burn <player> or /burn.");
      				//player.sendMessage("§6result /burn: sets you in fire till you lost 10 hearts.");
      				//player.sendMessage("§6result /burn <player>: burns a player till he lost 10 hearts");
      				//player.sendMessage("§6exception: when player/you is in water player doesnt burn or lose hearts"); 
      				//return true;
      	//}
      			if (split[1].equalsIgnoreCase("explain")) {
      				player.sendMessage("§2SC-CMD Dictionary /explain.");
      				player.sendMessage("§3usage: /explain SC-command without /.");
      				player.sendMessage("§6result /explain: explains you how a command works.");
      				return true;
      		}
      			if (split[1].equalsIgnoreCase("fl")) {
      				player.sendMessage("§2SC-CMD Dictionary /FoodLevel.");
      				player.sendMessage("§3usage: /fl [get|set|add|remove] <player> <amount>");
      				player.sendMessage("§9exampl /fl set player 10");
      				player.sendMessage("§6result /fl get: gets player FoodLevel");
      				player.sendMessage("§6result /fl set: sets player FoodLevel to [int amount]");
      				player.sendMessage("§6result /fl add: adds [int amount] to player's FoodLevel");
      				player.sendMessage("§6result /fl remove: removes [int amount] from player's FoodLevel");
      				player.sendMessage("§bimportant! <amount> is in % so if you want full FoodLevel use 100 for <amount>");
      				player.sendMessage("§bimportant! you only can use values like 90 or 95 other values like 23 will be rounded up");
      				return true;
      			}
      			if (split[1].equalsIgnoreCase("health")) {
      				player.sendMessage("§2SC-CMD Dictionary /Health.");
      				player.sendMessage("§3usage: /health [get|set|add|remove] <player> <amount>");
      				player.sendMessage("§9example /health set player 10");
      				player.sendMessage("§6result /health get: gets player Health");
      				player.sendMessage("§6result /health set: sets player health to [int amount]");
      				player.sendMessage("§6result /health add: adds [int amount] to player Health");
      				player.sendMessage("§6result /health remove: removes [int amount] from player's FoodLevel");
      				player.sendMessage("§bimportant! <amount> is in % so if you want full health use 100 for <amount>");
      				player.sendMessage("§bimportant! you only can use values like 90 or 95 other values like 23 will be rounded up");
      				return true;
      			}
            player.sendMessage("§cUsage - /explain <SC-command without />");
          }
          catch (Throwable t)
          {
            player.sendMessage("§cUsage - /explain <SC-command without />");
          }
        return true;
      }
	  
	  
	  
	  if ((split[0].equalsIgnoreCase("/die")) && (player.canUseCommand("/die"))){
		  if (split.length == 1){
			  player.sendMessage("§4you committed suecide.");
			  player.setHealth(00);
			  return true;
		  }
		  if (split.length >= 1)
		  if (split[1] != null){
			player.sendMessage("§4you cant kill someone else.");
			return true;
		  }
	  }
			       if ((split[0].equalsIgnoreCase("/massmurder")) && (player.canUseCommand("/massmurder"))) {
			              if (split.length == 1) {
			                  for (Player p : etc.getServer().getPlayerList()) {
			                    if (player != p) {
			                      p.setHealth(0);
			                      p.sendMessage("§aYou were murdered by " + "§4" + player.getName() + "§0!");
			                      p.sendMessage("§a" +p.getName()+" , "+ "were murdered by "+player.getName()+"!");
			                      player.sendMessage("§4You just murdered everyone!");
			                      return true;
			                    }
			              }
			              }
	return true;
}
	return false;
}
}