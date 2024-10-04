package minigames.momoio;

import me.neznamy.tab.api.TabAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class PlayerManager {
    private static final int ox = Config.get().getInt("map.ox");
    private static final int oz = Config.get().getInt("map.ox");
    private static final int oy = Config.get().getInt("map.oy");
    private final static TabAPI api = TabAPI.getInstance();
    private static List<PlayerModel> playerModelList = new ArrayList<>();
    //ОБНОВЛЕНИЕ СКОРБОРДОВ ИГРОКОВ КАЖДУЮ СЕКУНДУ
    public static void init() {
        BukkitRunnable scoreboardHandler = new BukkitRunnable() {
            @Override
            public void run() {
                for (PlayerModel model : playerModelList) {
                    model.updateScoreboard(api);
                }
            }
        };scoreboardHandler.runTaskTimer(MoMoio.getPlugin(), 0, 20);
    }
    /*
    МЕТОДЫ ДЛЯ ДОБАВЛЕНИЯ И УДАЛЕНИЯ МОДЕЛИ ИГРОКА В/ИЗ ЛИСТ(А)
    НЕОБХОДИМО ДЛЯ СКОРБОРДА
    */
    public static void addPlayer(Player player) {
        playerModelList.add(new PlayerModel(player));
    }

    public static void removePlayer(Player player) {
        PlayerModel model = getPlayerModel(player);
        if (model == null) return;
        playerModelList.remove(model);
    }
    //ПОЛУЧЕНИЕ МОДЕЛИ ИГРОКА
    public static PlayerModel getPlayerModel(Player player) {
        if (player == null) return null;
        for (PlayerModel model : playerModelList) {
            if (!model.getPlayer().equals(player)) continue;
            return model;
        }
        return  null;
    }
    /*
    РАССЧЕТ КООРДИНАТОВ И РАНДОМНАЯ ТЕЛЕПОРТАЦИЯ
    ПОКА ЧТО СЕЙФ ТЕЛЕПОРТ НА ОДНОЙ ВЫСОТЕ
    СДЕЛАТЬ ЧТОБ СЕЙФ ТП БЫЛО НА ВСЕХ ВЫСОТАХ
     */
    public static void randomPlayerTeleport(Player player) {
        while (true) {
            int x = new Random().nextInt(ox);
            int z = new Random().nextInt(oz);
            Location randomLocation = new Location(Bukkit.getServer().getWorld("world"), x, oy, z);
            if (!randomLocation.getBlock().getType().isAir()) continue;
            player.teleport(randomLocation);
            break;
        }
    }
}
