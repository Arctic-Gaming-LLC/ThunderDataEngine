package net.pentlock.thunderdataengine.listeners;

import net.pentlock.thunderdataengine.profiles.Guild;
import net.pentlock.thunderdataengine.profiles.Party;
import net.pentlock.thunderdataengine.profiles.ThunderPlayer;
import net.pentlock.thunderdataengine.utilities.ArrayUtil;
import net.pentlock.thunderdataengine.utilities.GuildUtil;
import net.pentlock.thunderdataengine.utilities.PartyUtil;
import net.pentlock.thunderdataengine.utilities.PlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;
import java.util.UUID;

public class PlayerLogoutListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
        ThunderPlayer thunderPlayer = PlayerUtil.findPlayer(playerUUID);
        if (thunderPlayer != null) {

            // Handles the data collection on logout
            thunderPlayer.setLogout(System.currentTimeMillis());
            long playTime = thunderPlayer.getLogout() - thunderPlayer.getLogin();
            thunderPlayer.setDataPlayTime(ArrayUtil.addToArray(thunderPlayer.getDataPlayTime(), playTime));
            thunderPlayer.setTotalPlayTime(thunderPlayer.getTotalPlayTime() + playTime);

            //Updates the list of online Guild Members - important for Chat System
            Guild guild = GuildUtil.findGuild(thunderPlayer.getGuild());
            boolean onlineGuildMember = false;
            if (guild != null) {
                for (Player playerTarget : Bukkit.getOnlinePlayers()) {
                    UUID uuid = playerTarget.getUniqueId();
                    UUID[] guildMembers = guild.getMembers();

                    for (int i = 0; i < guildMembers.length; ) {
                        if (guildMembers[i].toString().equalsIgnoreCase(uuid.toString())) {
                            onlineGuildMember = true;
                            break;
                        }
                        i++;
                    }
                }
                if (!onlineGuildMember) {
                    GuildUtil.unLoadGuild(thunderPlayer.getGuild());
                }
            }

            //Updates Player Party information
            Party party = PartyUtil.findParty(thunderPlayer.getParty());
            if (party != null) {
                UUID[] members = party.getMembers();
                if (party.getLeader().toString().equalsIgnoreCase(player.getUniqueId().toString())) {
                    if (members.length <= 1) {
                        for (UUID member : members) {
                            Player target = Bukkit.getPlayer(member);
                            if (target != null) {
                                ThunderPlayer thunderTarget = PlayerUtil.findPlayer(target.getUniqueId());
                                thunderTarget.setParty(player.getUniqueId());
                                target.sendMessage(ChatColor.RED + "Your party disbanded.");
                            } else {
                                try {
                                    PlayerUtil.loadPlayer(member);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                ThunderPlayer thunderTarget = PlayerUtil.findPlayer(member);
                                thunderTarget.setParty(member);
                                PlayerUtil.updatePlayer(thunderTarget.getUUID(), thunderTarget);
                                PlayerUtil.unloadPlayer(member);
                            }
                        }
                    } else {
                        for (UUID member : members) {
                            if (!member.toString().equalsIgnoreCase(playerUUID.toString())) {
                                party.setMembers(ArrayUtil.removeFromArray(party.getMembers(), player.getUniqueId()));
                                party.setLeader(member);
                                thunderPlayer.setParty(playerUUID);
                                break;
                            }
                        }
                    }
                } else {
                    party.setMembers(ArrayUtil.removeFromArray(party.getMembers(), player.getUniqueId()));
                    thunderPlayer.setParty(playerUUID);

                }
            }
            PlayerUtil.updatePlayer(thunderPlayer.getUUID(), thunderPlayer);
            PlayerUtil.unloadPlayer(playerUUID);
        }
    }
}
