
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class ForceJump implements Listener {

    public static List<String> FrozenPlayers = new ArrayList();

    @EventHandler
    public void onGroundHit(final PlayerMoveEvent e) {
        final Player player = e.getPlayer();
        if (GravityXMain.gamestart == true) {
            if (e.getFrom().getBlockY() > e.getTo().getBlockY()) {
                final Block block = e.getTo().getBlock().getRelative(BlockFace.DOWN);
                final Location blocklocation = block.getLocation();
                if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == (Material.EMERALD_BLOCK)) {
                    player.playSound(player.getLocation(), Sound.CREEPER_HISS, 10, 0);
                    Vector v = player.getLocation().getDirection().multiply(-1).setY(7);
                    player.setVelocity(v);
                } else if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == (Material.DIAMOND_BLOCK)) {
                    player.playSound(player.getLocation(), Sound.CREEPER_HISS, 10, 0);
                    Vector v = player.getLocation().getDirection().multiply(-1).setY(10);
                    player.setVelocity(v);
                } else if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == (Material.ICE)) {
                    player.playSound(player.getLocation(), Sound.DIG_SNOW, 10, 0);
                    GravityXMain.FrozenPlayers.add(player.getName());
                    player.sendMessage(GravityXMain.gamename + "You're now frozen.");
                    Bukkit.getScheduler().scheduleSyncDelayedTask((GravityXMain.instance), new Runnable() {
                        @Override
                        public void run() {
                            player.sendMessage(GravityXMain.gamename + "You're now unfrozen.");
                            player.playSound(player.getLocation(), Sound.LEVEL_UP, 0, 10);
                            GravityXMain.FrozenPlayers.remove(player.getName());
                        }
                    }, 150);
                } else if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == (Material.REDSTONE_BLOCK)) {
                    player.playSound(player.getLocation(), Sound.EXPLODE, 10, 0);
                    Vector v = player.getLocation().getDirection().multiply(-1).setY(5);
                    player.setVelocity(v);
                    block.setType(Material.AIR);
                    DiscSize.Sphere(blocklocation, 4, Material.AIR);
                    Bukkit.getScheduler().scheduleSyncDelayedTask((GravityXMain.instance), new Runnable() {
                        @Override
                        public void run() {
                            DiscSize.Sphere(blocklocation, 4, Material.GLASS);
                            block.setType(Material.REDSTONE_BLOCK);
                        }
                    }, 150);
                } else if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() != (Material.AIR)) {
                    Vector v = player.getLocation().getDirection().multiply(-1).setY(3);
                    player.setVelocity(v);
                }
            } else if (FrozenPlayers.contains(e.getPlayer().getName())) {
                e.setTo(e.getFrom());
            }
        } else {
        }
    }
}
