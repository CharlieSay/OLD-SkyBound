
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

public class DiscSize {//TODO annotations

    private static ArrayList<Block> sphere = new ArrayList<Block>();
    private static Location center;
    private static int radius;

    public static void Sphere(Location center, int radius) {
        DiscSize.center = center;
        DiscSize.radius = radius;
        for (int X = -radius; X < radius; X++) {
            for (int Y = -radius; Y < radius; Y++) {
                for (int Z = -radius; Z < radius; Z++) {
                    if (Math.sqrt((X * X) + (Y * Y) + (Z * Z)) <= radius) {
                        Block block = center.getWorld().getBlockAt(X + center.getBlockX(), center.getBlockY(), Z + center.getBlockZ());
                        block.setType(Material.REDSTONE_BLOCK);
                        sphere.add(block);
                        List<Entity> entList = block.getWorld().getEntities();
                        for (Entity current : entList) {
                            current.remove();
                        }
                    }
                }
            }
        }
    }

    public Location getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public ArrayList<Block> getBlocks() {
        return sphere;
    }

    private boolean isInside(int X, int Y, int Z) {
        return Math.sqrt((X * X) + (Y * Y) + (Z * Z)) <= radius;
    }

    public boolean overlaps(DiscSize other) {
        for (Block block : other.getBlocks()) {
            if (contains(block.getLocation())) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Location loc) {
        return isInside(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
    }
}