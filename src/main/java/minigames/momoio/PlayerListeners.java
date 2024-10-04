package minigames.momoio;

import me.neznamy.tab.api.TabAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Arrays;
import java.util.List;

public class PlayerListeners implements Listener {
    TabAPI api = TabAPI.getInstance();
    Location greenZone = new Location(Bukkit.getWorld("world"), Config.get().getDouble("map.greenZone.ox"), Config.get().getDouble("map.greenZone.oy"), Config.get().getDouble("map.greenZone.oz"));
    private final int foodAmountCactus = Config.get().getInt("resources.foodAmountCactus");
    private final int foodAmount = Config.get().getInt("resources.foodAmount");
    private final int woodAmount = Config.get().getInt("resources.woodAmount");
    private final int stoneAmount = Config.get().getInt("resources.stoneAmount");
    private final int goldAmount = Config.get().getInt("resources.goldAmount");
    private final int expAmountWood = Config.get().getInt("resources.expAmountWood");
    private final int expAmountStone = Config.get().getInt("resources.expAmountStone");
    private final int expAmountGold = Config.get().getInt("resources.expAmountGold");
    private final int expAmountFood = Config.get().getInt("resources.expAmountFood");
    private final int shieldCooldown = Config.get().getInt("items.shield.cooldown");
    private static List<Material> noDamageItems = Arrays.asList(
            Material.WOODEN_AXE,
            Material.IRON_AXE,
            Material.STONE_AXE,
            Material.DIAMOND_AXE,
            Material.WOODEN_PICKAXE,
            Material.IRON_PICKAXE,
            Material.STONE_PICKAXE,
            Material.DIAMOND_PICKAXE);
    //ДАВАНИЕ РЕСУРСОВ ЗА СЛОМАННЫЕ БЛОКИ
    @EventHandler
    public void breakBlockEvent(BlockBreakEvent event) {
        if (event.getBlock().getType().equals(Material.OAK_PLANKS)) {
            event.getBlock().getDrops().clear();
            return;
        }
        if (event.getBlock().getType().equals(Material.STONE_BRICKS)) {
            event.getBlock().getDrops().clear();
            return;
        }
        event.setCancelled(true);
        Material brokenBlockType = event.getBlock().getType();
        PlayerModel model = PlayerManager.getPlayerModel(event.getPlayer());
        if (model == null) return;
        if (brokenBlockType.equals(Material.OAK_LOG) || brokenBlockType.equals(Material.SPRUCE_LOG)) {
            model.addWood(woodAmount);
            model.addExp(expAmountWood);
            return;
        }
        if (brokenBlockType.equals(Material.CACTUS)) {
            model.addFood(foodAmountCactus);
            model.addExp(expAmountFood);
            return;
        }
        if (brokenBlockType.equals(Material.FLOWERING_AZALEA_LEAVES)) {
            model.addFood(foodAmount);
            model.addExp(expAmountFood);
            return;
        }
        if (brokenBlockType.equals(Material.STONE) || brokenBlockType.equals(Material.COBBLESTONE)) {
            model.addStone(stoneAmount);
            model.addExp(expAmountStone);
            return;
        }
        if (brokenBlockType.equals(Material.RAW_GOLD_BLOCK)) {
            model.addGold(goldAmount);
            model.addExp(expAmountGold);
        }
    }
    //ЗАПРЕТ НА СТРОИТЕЛЬСТВО БЛОКОВ
    @EventHandler
    public void placeBlockEvent(BlockPlaceEvent event) {
        if (event.getBlock().getType().equals(Material.OAK_PLANKS)) return;
        if (event.getBlock().getType().equals(Material.STONE_BRICKS)) return;
        event.setCancelled(true);
    }
    //ЧТО ПРОИСХОДИТ ПОСЛЕ СМЕРТИ ИГРОКА
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        if (player.getKiller() != null) {
            PlayerManager.getPlayerModel(player.getKiller()).addWood(PlayerManager.getPlayerModel(player).getWood() / 3);
            PlayerManager.getPlayerModel(player.getKiller()).addGold(PlayerManager.getPlayerModel(player).getGold() / 3);
            PlayerManager.getPlayerModel(player.getKiller()).addStone(PlayerManager.getPlayerModel(player).getStone() / 3);
            PlayerManager.getPlayerModel(player.getKiller()).addFood(PlayerManager.getPlayerModel(player).getFood() / 3);
        }
        api.getScoreboardManager().resetScoreboard(api.getPlayer(player.getUniqueId()));
        PlayerManager.removePlayer(player);
        PlayerManager.addPlayer(player);
    }
    //ЧТО ПРОИСХОДИТ ПОСЛЕ ЛИВА ИГРОКА
    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        player.setExp(0);
        player.setLevel(0);
        player.getInventory().clear();
        PlayerManager.removePlayer(player);
        api.getScoreboardManager().resetScoreboard(api.getPlayer(event.getPlayer().getUniqueId()));
    }
    //ГРИНЗОНА + ЗАПРЕТ НА ПВП С ИНСТРУМЕНТАМИ
    @EventHandler
    public void playerDamagePlayer(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.isBlocking()) player.setCooldown(Material.SHIELD, shieldCooldown);
        }
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (PlayerManager.getPlayerModel(player).inGreenZone()) {
                event.getDamager().sendMessage("Пвп выключено в гринзоне");
                event.setCancelled(true);
            }
            if (noDamageItems.contains(((Player) event.getDamager()).getInventory().getItemInMainHand().getType())) {
                event.setCancelled(true);
            }
        }
    }
    //СЕТ ДАМАГЕРА ДЛЯ ИГРОКА, ПОЛУЧИШВЕГО УРОН ОТ ПУЛИ
    @EventHandler
    public void entityGetDamageByProjectile(ProjectileHitEvent event) {
        Entity entity = event.getHitEntity();
        if (entity instanceof Player && PlayerManager.getPlayerModel((Player) entity).inGreenZone()) {
            event.setCancelled(true);
            return;
        }
        if (event.getEntity().getType().equals(EntityType.SNOWBALL)) {
            if (event.getEntity().isEmpty()) return;
            Player shooter = (Player) event.getEntity().getShooter();
            ((Damageable) entity).damage(Config.get().getDouble("items.mushket.damage"), shooter);
        }
    }
}

