
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class ForceJump implements Listener {

    @EventHandler
    public void onGroundHit(final PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (e.getFrom().getBlockY() > e.getTo().getBlockY()) {
            if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() != (Material.AIR)) {
                Vector v = player.getLocation().getDirection().multiply(-1).setY(1);
                player.setVelocity(v);
            }else if(e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == (Material.REDSTONE_BLOCK)) {
                Vector v = player.getLocation().getDirection().multiply(-1).setY(2);
                player.setVelocity(v); 
                e.getTo().getBlock().getRelative(BlockFace.DOWN).setType(Material.AIR);               
                Bukkit.getScheduler().scheduleSyncDelayedTask((GravityXMain.instance), new Runnable(){
                    
                    @Override
                    public void run(){
                          e.getTo().getBlock().getRelative(BlockFace.DOWN).setType(Material.REDSTONE_BLOCK);                            
                    }
                    
                }, 150);
            }else if(e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == (Material.EMERALD_BLOCK)){
                Vector v = player.getLocation().getDirection().multiply(-1).setY(5);
                player.setVelocity(v);                 
            }
        }
    }
}
