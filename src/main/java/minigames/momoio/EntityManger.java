package minigames.momoio;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityManger {
    private static final int bossDamage = Config.get().getInt("entities.boss.bossDamage");
    private static final int wolfDamage = Config.get().getInt("entities.wolfDamage");
    private static final int ox = Config.get().getInt("map.ox");
    private static final int oz = Config.get().getInt("map.oz");
    private static final int oy = Config.get().getInt("map.oy");
    private static final Location bossSpawnCoords = new Location(Bukkit.getWorld("world"), 0, -60, 0);
    private static final double bossHealth = Config.get().getDouble("entities.boss.health");
    private static final double bossSpawnCooldown = Config.get().getInt("entities.boss.cooldown");
    private static final int periodSpawnEntity = Config.get().getInt("entities.periodSpawnEntity");
    private static final int maxEntity = Config.get().getInt("entities.maxEntity");
    private static List<Entity> entityList = new ArrayList<>();
    public static List<Entity> getEntityList() {return entityList;}
    //СПАВН СУЩНОСТЕЙ
    public static void init() {
        for (Entity entity : getEntityList()) {
            entity.remove();
        }
        spawnBoss();
        BukkitRunnable entitySpawner = new BukkitRunnable() {
            @Override
            public void run() {
                if (entityList.size() > maxEntity) return;
                int chanceEntity = new Random().nextInt(4);
                Location randomLocation;
                while (true) {
                    int x = new Random().nextInt(ox);
                    int z = new Random().nextInt(oz);
                    randomLocation = new Location(Bukkit.getServer().getWorld("world"), x, oy, z);
                    if (!randomLocation.getBlock().getType().isAir()) {
                        continue;
                    }
                    break;
                }
                switch (chanceEntity) {
                    case 0:
                        Entity cow = randomLocation.getWorld().spawnEntity(randomLocation, EntityType.COW);
                        entityList.add(cow);
                        break;
                    case 1:
                        Entity pig = randomLocation.getWorld().spawnEntity(randomLocation, EntityType.PIG);
                        entityList.add(pig);
                        break;
                    case 2:
                        Entity chicken = randomLocation.getWorld().spawnEntity(randomLocation, EntityType.CHICKEN);
                        entityList.add(chicken);
                    case 3:
                        Entity wolf = randomLocation.getWorld().spawnEntity(randomLocation, EntityType.WOLF);
                        Silverfish zombie = (Silverfish) randomLocation.getWorld().spawnEntity(randomLocation, EntityType.SILVERFISH);
                        zombie.setInvulnerable(true);
                        zombie.setInvisible(true);
                        zombie.setSilent(true);
                        zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, wolfDamage));
                        wolf.addPassenger(zombie);
                        entityList.add(wolf);
                }
            }
        };entitySpawner.runTaskTimer(MoMoio.getPlugin(), 0, 20 * periodSpawnEntity);
        }
    //КД ДЛЯ БОССА
    public static void bossSpawnTimer() {
        BukkitRunnable bossSpawner = new BukkitRunnable() {
            int timer = 0;
            @Override
            public void run() {
                timer += 1;
                if (timer != bossSpawnCooldown) return;
                spawnBoss();
                this.cancel();
            }
        };bossSpawner.runTaskTimer(MoMoio.getPlugin(), 0, 20);
    }
    //МЕТОД СПАВНА БОССА
    private static void spawnBoss(){
        LivingEntity boss = (LivingEntity) bossSpawnCoords.getWorld().spawnEntity(bossSpawnCoords, EntityType.RAVAGER);
        boss.setCustomName("БРР ЧЕ ГОВОРИЩЬ БРРРЖ НЕ СЛЫШУ");
        boss.setCustomNameVisible(true);
        boss.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, bossDamage));
        ((Damageable) boss).setHealth(bossHealth);
    }
}
