
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

public class GravityXMain extends JavaPlugin {

    public static GravityXMain instance;
    public static String gamename = (ChatColor.RED + "[SkyBound] " + ChatColor.WHITE);
    public static boolean gamestart;
    
    @Override
    public void onEnable() {
        gamestart = false;
        instance = this;
        Bukkit.getPluginManager().registerEvents(new ForceJump(), this);
        Bukkit.getPluginManager().registerEvents(new DeathCheck(), this);
        Bukkit.getPluginManager().registerEvents(new MainListener(),this);
        Timers.pregame();
        Bukkit.setDefaultGameMode(GameMode.ADVENTURE);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (commandLabel.equalsIgnoreCase("start")) {
                if (p.isOp()) {
                    Bukkit.broadcastMessage("Game Start!");
                    gamestart = true;
                    for (Player p1 : Bukkit.getOnlinePlayers()) {
                        PogoStick.ItemEquip(p1);
                    }
                }
            } else if (commandLabel.equalsIgnoreCase("stopgame")) {
                if (p.isOp()) {
                    Bukkit.broadcastMessage("Game Stopped!");
                    for (Player p1 : Bukkit.getOnlinePlayers()) {
                        for (PotionEffect effect : p1.getActivePotionEffects()) {
                            p1.removePotionEffect(effect.getType());
                        }
                    }
                    gamestart = false;
                }
            }
        }
        return false;
    }
}
