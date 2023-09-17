package plugin.enemydown;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemydown.command.EmemyDownCommand;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
      Bukkit.getPluginManager().registerEvents(this, this);
      getCommand("enemyDown").setExecutor(new EmemyDownCommand());
    }

}
