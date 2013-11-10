
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class GravityXMain extends JavaPlugin{
    
        public static GravityXMain instance;
        public static String gamename = (ChatColor.RED + "[Gravity-X] ");
        
        @Override
        public void onEnable(){
            instance = this;
            Bukkit.getPluginManager().registerEvents(new ForceJump(), this);
            Bukkit.getPluginManager().registerEvents(new MainListener(), this);
        }
    
}
