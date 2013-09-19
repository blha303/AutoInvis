package me.blha303.autoinvis;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.logging.Logger;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.EventHandler;

public class AutoInvis extends JavaPlugin implements Listener {

    private Logger log;

    public void onEnable() {
        log = this.getLogger();
        getServer().getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults(true);
        getConfig().addDefault("potioneffect", true);
        saveConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPermission("autoinvis.bypass")) {
            if (getConfig().getBoolean("potioneffect")) {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000*20, 0));
            } else {
                for (Player pl : this.getServer().getOnlinePlayers()) {
                    if (!pl.hasPermission("autoinvis.bypass")) {
                        pl.hidePlayer(event.getPlayer());
                        event.getPlayer().hidePlayer(pl);
                    }
                }
            }
            log.info(event.getPlayer().getName() + " given invisibility");
        } else {
            log.info(event.getPlayer().getName() + " has the override permission.");
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        if (!event.getPlayer().hasPermission("autoinvis.bypass")) {
            if (getConfig().getBoolean("potioneffect")) {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000*20, 0));
            } else {
                for (Player pl : this.getServer().getOnlinePlayers()) {
                    if (!pl.hasPermission("autoinvis.bypass")) {
                        pl.hidePlayer(event.getPlayer());
                        event.getPlayer().hidePlayer(pl);
                    }
                }
            }
            log.info(event.getPlayer().getName() + " given invisibility");
        } else {
            log.info(event.getPlayer().getName() + " has the override permission.");
        }
    }

}
