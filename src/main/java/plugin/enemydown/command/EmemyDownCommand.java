package plugin.enemydown.command;

import java.util.List;
import java.util.SplittableRandom;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zoglin;

public class EmemyDownCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof Player player) {
      World world = player.getWorld();

      player.setHealth(20);
      player.setFoodLevel(20);

      List<EntityType> enemyList = List.of(EntityType.ZOMBIE, EntityType.SKELETON);
      int random = new SplittableRandom().nextInt(2);

      world.spawnEntity(getEnemySpawnLocation(player, world), enemyList.get(random));
    }
    return false;
  }

  /**
   * 敵の出現場所を取得します。
   * 出現エリアはX軸とZ軸は自分の位置からプラス、ランダムで-7から7までの値が設定されます。
   * Y軸はプレイヤーと同じ位置になります。
   *
   * @param player　コマンドを実行したプレイヤー
   * @param world　 コマンドを実行したプレイヤーが所属するワールド
   * @return 敵の出現場所
   */
  private Location getEnemySpawnLocation(Player player, World world) {
    Location playerLocation = player.getLocation();
    int randomX = new SplittableRandom().nextInt(15) - 7;
    int randomZ = new SplittableRandom().nextInt(15) - 7;

    double x = playerLocation.getX() + randomX;
    double y = playerLocation.getY();
    double z = playerLocation.getZ() + randomZ;

    return new Location(world, x , y , z);
  }
}
