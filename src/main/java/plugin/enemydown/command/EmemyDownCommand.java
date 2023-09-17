package plugin.enemydown.command;

import java.util.SplittableRandom;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class EmemyDownCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(sender instanceof Player player) {
      World world = player.getWorld();

      player.setHealth(20);
      player.setFoodLevel(20);

      Location playerLocation = player.getLocation();
      double x = playerLocation.getX();
      double y = playerLocation.getY();
      double z = playerLocation.getZ();
      int random = new SplittableRandom().nextInt(15) - 7;
      Location enemySpawnLocation = new Location(world, (x + random), y , (z + random));

      world.spawnEntity(enemySpawnLocation, EntityType.ZOMBIE);
    }
    return false;
  }
}
