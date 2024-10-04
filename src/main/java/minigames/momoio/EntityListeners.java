package minigames.momoio;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTransformEvent;

public class EntityListeners implements Listener {
    private final static int expAmountCow = Config.get().getInt("entities.expAmountCow");
    private final static int expAmountPig = Config.get().getInt("entities.expAmountPig");
    private final static int expAmountChicken = Config.get().getInt("entities.expAmountChicken");
    private final static int expAmountWolf = Config.get().getInt("entities.expAmountWolf");
    private final static int expAmountRavager = Config.get().getInt("entities.expAmountRavager");
    private final static int expAmountPiglin = Config.get().getInt("entities.expAmountPiglin");
    private final static int goldAmountCow = Config.get().getInt("entities.goldAmountCow");
    private final static int goldAmountWolf = Config.get().getInt("entities.goldAmountWolf");
    private final static int goldAmountPig = Config.get().getInt("entities.goldAmountPig");
    private final static int goldAmountChicken = Config.get().getInt("entities.goldAmountChicken");
    private final static int goldAmountRavager = Config.get().getInt("entities.goldAmountRavager");
    private final static int goldAmountPiglin = Config.get().getInt("entities.goldAmountPiglin");
    private final static int foodAmountCow = Config.get().getInt("entities.foodAmountCow");
    private final static int foodAmountWolf = Config.get().getInt("entities.foodAmountWolf");
    private final static int foodAmountPig = Config.get().getInt("entities.foodAmountPig");
    private final static int foodAmountChicken = Config.get().getInt("entities.foodAmountChicken");
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Player player = event.getEntity().getKiller();
        if (player == null) return;
        switch (entity.getType()) {
            case COW:
                PlayerManager.getPlayerModel(player).addExp(expAmountCow);
                PlayerManager.getPlayerModel(player).addGold(goldAmountCow);
                PlayerManager.getPlayerModel(player).addFood(foodAmountCow);
                break;
            case CHICKEN:
                PlayerManager.getPlayerModel(player).addExp(expAmountChicken);
                PlayerManager.getPlayerModel(player).addGold(goldAmountChicken);
                PlayerManager.getPlayerModel(player).addFood(foodAmountChicken);
                break;
            case PIG:
                PlayerManager.getPlayerModel(player).addExp(expAmountPig);
                PlayerManager.getPlayerModel(player).addGold(goldAmountPig);
                PlayerManager.getPlayerModel(player).addFood(foodAmountPig);
                break;
            case WOLF:
                PlayerManager.getPlayerModel(player).addExp(expAmountWolf);
                PlayerManager.getPlayerModel(player).addGold(goldAmountWolf);
                PlayerManager.getPlayerModel(player).addFood(foodAmountWolf);
                entity.getPassenger().remove();
                break;
            case RAVAGER:
                EntityManger.bossSpawnTimer();
                PlayerManager.getPlayerModel(player).addExp(expAmountRavager);
                PlayerManager.getPlayerModel(player).addGold(goldAmountRavager);
        }
    }
}
