package minigames.momoio;

import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.scoreboard.Scoreboard;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerModel {
    private final Player player;
    private int wood;
    private int stone;
    private int gold;
    private int food;
    private int exp;
    private int lvl;
    private int totalExp;
    private int upgradePoints;
    private boolean greenZone;
    private final int lvlProgress = Config.get().getInt("lvlProgress");

    public PlayerModel(Player player) {
        this.player = player;
        this.wood = 0;
        this.stone = 0;
        this.gold = 0;
        this.food = 0;
        this.exp = 0;
        this.lvl = 0;
        this.totalExp = 0;
        this.upgradePoints = 0;
        this.greenZone = false;

    }
    //ОБНОВЛЕНИЕ СКОРБОРДА У ИГРОКА
    public void updateScoreboard(TabAPI api) {
        List<String> linesScoreboard = new ArrayList<>();
        linesScoreboard.add("Дерево: " + wood);
        linesScoreboard.add("Камень: " + stone);
        linesScoreboard.add("Еда: " + food);
        linesScoreboard.add("Золото: " + gold);
        linesScoreboard.add("Очки прокачки: " + upgradePoints);
        Scoreboard scoreboard = api.getScoreboardManager().createScoreboard(player.getName(), "Ресурсы", linesScoreboard);
        api.getScoreboardManager().showScoreboard(api.getPlayer(player.getName()), scoreboard);
    }
    //ДАЛЬШЕ МЕТОДЫ ДЛЯ ПОЛУЧЕНИЯ, ДОБАВЛЕНИЯ РЕСУРСОВ
    public Player getPlayer() {
        return player;
    }

    public int getWood() {
        return wood;
    }

    public int getStone() {
        return stone;
    }

    public int getGold() {
        return gold;
    }

    public int getFood() {
        return food;
    }
    public int getLvl() {return lvl;}
    public int getUpgradePoints() {return upgradePoints;}
    public void removeStone(int stone) {
        if (stone > this.stone) return;
        this.stone -= stone;
    }
    public void removeWood(int wood) {
        if (wood > this.wood) return;
        this.wood -= wood;
    }
    public void removeGold(int gold) {
        if (gold > this.gold) return;
        this.gold -= gold;
    }
    public void addWood(int wood) {
        this.wood += wood;
    }
    public void addUpgradePoints(int upgradePoints) {
        this.upgradePoints += upgradePoints;
    }
    public void addStone(int stone) {
        this.stone += stone;
    }
    public void addGold(int gold) {
        this.gold += gold;
    }
    public void addFood(int food) {
        this.food += food;
    }
    public void addExp(int exp) {
        this.exp += exp;
        totalExp += exp;
        player.setExp((float) this.exp / ((lvl + 1) * lvlProgress));
        if (totalExp >= ((lvl + 1) * lvlProgress)) {
            this.exp = 0;
            lvl += 1;
            addUpgradePoints((int) Math.floor(Math.ceil((double) lvl / 5)));
            player.setLevel(lvl);
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, SoundCategory.AMBIENT, 50, 2);
        }
    }
    public void setGreenZone(boolean b) {
        greenZone = b;
    }
    public boolean inGreenZone() {
        return greenZone;
    }
}

