
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GravityXMain extends JavaPlugin {
    
    public static GravityXMain instance;
    public static String gamename = (ChatColor.RED + "[Gravity-X] ");
    public static boolean gamestart;
    
    @Override
    public void onEnable() {
        gamestart = false;
        instance = this;
        Bukkit.getPluginManager().registerEvents(new ForceJump(), this);
        Bukkit.getPluginManager().registerEvents(new MainListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathCheck(), this);
        Timers.pregame();
        Bukkit.setDefaultGameMode(GameMode.ADVENTURE);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        
        
        if (!(sender instanceof Player)) {
            sender.sendMessage("FUCK OFF YOU CUNT");
        }
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (commandLabel.equalsIgnoreCase("start")) {
                if (p.isOp()) {
                    Bukkit.broadcastMessage("Game Start!");
                    gamestart = true;
                    Player[] players = Bukkit.getServer().getOnlinePlayers();
                    
                    for (Player p1 : players) {
                        PogoStick.ItemEquip(p1);
                    }
                } else {
                    Bukkit.broadcastMessage(p.getName() + "tried ot start the game like "
                            + "faggot");
                }
            } else if (commandLabel.equalsIgnoreCase("stopgame")) {
                if (p.isOp()) {
                    Bukkit.broadcastMessage("Game Stopped!");
                    gamestart = false;
                } else {
                    Bukkit.broadcastMessage(p.getName() + "tried ot start the game like "
                            + "faggot");
                }
            }
        }
        return false;
    }
}
