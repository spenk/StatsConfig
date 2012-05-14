import java.util.logging.Logger;

public class StatsConfig extends Plugin
{
	  String name = "StatsConfig";
	  String version = "2.1";
	  String author = " spenk";
	  static Logger log = Logger.getLogger("Minecraft");
	  
	  
public void initialize(){
	StatsConfigListener listener = new StatsConfigListener();
log.info(this.name +" version "+ this.version + " by " +this.author+(" is initialized!"));
etc.getLoader().addListener(PluginLoader.Hook.HEALTH_CHANGE, listener, this, PluginListener.Priority.MEDIUM);
etc.getLoader().addListener(PluginLoader.Hook.COMMAND, listener, this, PluginListener.Priority.MEDIUM);
etc.getInstance().addCommand("/sc-help", "to see all StatsConfig commands");
etc.getInstance().addCommand("/feed","feed yourself or another player");
etc.getInstance().addCommand("/heal"," Heal yourself or another player");
etc.getInstance().addCommand("/kill"," kill anoter player");
etc.getInstance().addCommand("/maim"," maim yourself or another player");
etc.getInstance().addCommand("/slap"," slap yourself or another player");
etc.getInstance().addCommand("/die"," commit suecide");
etc.getInstance().addCommand("/massmurder"," kill evryone");
etc.getInstance().addCommand("/starvate"," starvate yourself or another player");
etc.getInstance().addCommand("/exp "," [get|set|add|remove] get sets or removes player exp");
//etc.getInstance().addCommand("/burn <all>"," lightens yourself, another player or all players");
etc.getInstance().addCommand("/explain <SC command without />"," explains a SC command");
etc.getInstance().addCommand("/fl", "[get|set|add|remove] [player] [amount] gets,sets,adds,removes player foodlevel");
etc.getInstance().addCommand("/health"," [get|set|add|remove] [player] [amount] gets,sets,adds,removes player health");
}
public void enable(){
	log.info(this.name + " version " + this.version + " by " + this.author + " is enabled!");
}

public void disable(){
	log.info(this.name + " version " + this.version + " is disabled!");
    etc.getInstance().removeCommand("/sc-help");
    etc.getInstance().removeCommand("/feed");
    etc.getInstance().removeCommand("/heal");
    etc.getInstance().removeCommand("/kill");
    etc.getInstance().removeCommand("/maim");
    etc.getInstance().removeCommand("/slap");
    etc.getInstance().removeCommand("/die");
    etc.getInstance().removeCommand("/massmurder");
    etc.getInstance().removeCommand("/starvate");
    etc.getInstance().removeCommand("/exp");
    //etc.getInstance().removeCommand("/burn <all>");
    etc.getInstance().removeCommand("/starvate");
    etc.getInstance().removeCommand("/explain <SC command without />");
    etc.getInstance().removeCommand("/fl");
    etc.getInstance().removeCommand("/health");
}
}