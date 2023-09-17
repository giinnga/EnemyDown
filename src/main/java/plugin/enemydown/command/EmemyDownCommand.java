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
      player.setHealth(20);
      player.setFoodLevel(20);


    }
    return false;
  }
}
