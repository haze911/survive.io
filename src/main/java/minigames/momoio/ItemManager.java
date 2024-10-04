package minigames.momoio;

import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Locale;
import java.util.Random;

public class ItemManager {
    private static final int ox = Config.get().getInt("map.ox");
    private static final int oz = Config.get().getInt("map.oz");
    private static final int oy = Config.get().getInt("map.oy");
    private final static double multiplyVectorForMushket = Config.get().getDouble("items.mushket.multiplyVector");
    private final static int mushketCooldown = Config.get().getInt("items.mushket.cooldown");
    private final static int dashCooldown = Config.get().getInt("items.dash.cooldown");
    private final static int enderEyeCooldown = Config.get().getInt("items.enderEye.cooldown");
    private final static double multiplyVectorForDash = Config.get().getDouble("items.dash.multiplyVector");
    private final static int shootCost = Config.get().getInt("items.mushket.cost");
    private final static double radiusStan = Config.get().getDouble("items.stan.radius");
    private final static int stanLevel = Config.get().getInt("items.stan.levelEffect");
    private final static int stanDuration = Config.get().getInt("items.stan.duration");
    private final static int stanCooldown = Config.get().getInt("items.stan.cooldown");

    //МУШКЕТ
    public static void shoot(Player player) {
        if (player.hasCooldown(Material.BRICK)) return;
        if (PlayerManager.getPlayerModel(player).getStone() < shootCost) return;
        PlayerManager.getPlayerModel(player).removeStone(shootCost);
        ItemStack pieceIron = new ItemStack(Material.IRON_NUGGET);
        Vector vector = player.getEyeLocation().getDirection().normalize();
        Location location = player.getEyeLocation();
        Snowball snowball = player.getWorld().spawn(location, Snowball.class);
        snowball.setItem(pieceIron);
        snowball.setVelocity(vector.multiply(multiplyVectorForMushket));
        BukkitRunnable mushketParticles = new BukkitRunnable() {
            @Override
            public void run() {
                if (snowball.isDead()) this.cancel();
                snowball.getLocation().getWorld().spawnParticle(Particle.ASH, snowball.getLocation(), 3);
            }
        };mushketParticles.runTaskTimer(MoMoio.getPlugin(), 0, 2);
        player.setCooldown(Material.BRICK, mushketCooldown);

    }
    //ДЕШ
    public static void dash(Player player) {
        if (player.hasCooldown(Material.FEATHER)) return;
        Vector vector = player.getEyeLocation().getDirection().normalize();
        player.setVelocity(vector.multiply(multiplyVectorForDash));
        player.setCooldown(Material.FEATHER, dashCooldown);
    }
    //ТЕЛЕПОРТ
    public static void randomTeleport(Player player) {
        if (player.hasCooldown(Material.ENDER_EYE)) return;
        while (true) {
            int x = new Random().nextInt(ox);
            int z = new Random().nextInt(oz);
            Location randomLocation = new Location(Bukkit.getServer().getWorld("world"), x, oy, z);
            if (!randomLocation.getBlock().getType().isAir()) continue;
            player.teleport(randomLocation);
            break;
        }
        player.setCooldown(Material.ENDER_EYE, enderEyeCooldown);
    }
    //СТАНОВАЯ СПОСОБНОСТЬ
    public static void stan(Player player) {
        if (player.hasCooldown(Material.COBWEB)) return;
        if (player.getLocation().getNearbyPlayers(radiusStan).isEmpty()) return;
        for (int i = 1; i < 20; i++) {
            Vector vec = player.getVelocity();
            vec.rotateAroundX(3);
            double x = vec.getBlockX();
            double y = vec.getBlockY();
            double z = vec.getBlockY();
            player.getLocation().getWorld().spawnParticle(Particle.HEART, vec.toLocation(player.getWorld()), 3);
        }
        for (Player p :player.getLocation().getNearbyPlayers(radiusStan)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, stanDuration, stanLevel, false, true, false));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, stanDuration, stanLevel, false, true, false));
        }
        player.setCooldown(Material.COBWEB, stanCooldown);

    }
}
