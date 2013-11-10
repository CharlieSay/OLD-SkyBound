
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Timers extends JavaPlugin {

    public static int pregametimer = 30;
    public static int actualtimer = 300;

    public void pregame() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask((GravityXMain.instance), new Runnable() {
            @Override
            public void run() {                   
                Player[] players = Bukkit.getServer().getOnlinePlayers();
                pregametimer--;
                boardmanager.seconds.setScore(pregametimer);
                if (pregametimer < 11) {
                    for (Player p : players) {
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0, 10);
                    }
                }else if(pregametimer == 0){
                    for (Player p : players) {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 0, 10);
                    }
                    Bukkit.broadcastMessage(GravityXMain.gamename + "Start hitting!");
                }else{
                    
                }
            }
        }, 0, 20);
    }
     public void actualgame() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask((GravityXMain.instance), new Runnable() {
            @Override
            public void run() {                   
                Player[] players = Bukkit.getServer().getOnlinePlayers();
                actualtimer--;
                int seconds = actualtimer;
                boardmanager.seconds.getScoreboard().resetScores(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Lobby Timer:"));
                boardmanager.gametimer = boardmanager.board.get
                if (pregametimer < 11) {
                    for (Player p : players) {
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0, 10);
                    }
                }else if(pregametimer == 0){
                    for (Player p : players) {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 0, 10);
                    }
                    Bukkit.broadcastMessage(GravityXMain.gamename + "Start hitting!");
                }else{
                    
                }
            }
        }, 0, 20);
        
    }
}
