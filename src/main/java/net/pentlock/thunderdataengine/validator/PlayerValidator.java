package net.pentlock.thunderdataengine.validator;

import net.pentlock.thunderdataengine.profiles.ThunderPlayer;
import net.pentlock.thunderdataengine.utilities.PlayerUtil;
import org.bukkit.entity.Player;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PlayerValidator {

    public PlayerValidator(ThunderPlayer thunderPlayer, Player player) {

        if (thunderPlayer.getName() == null) {
            thunderPlayer.setName(player.getName());
        }

        if (thunderPlayer.getGrave() == null) {
            thunderPlayer.setGrave("None");
        }

        if (thunderPlayer.getGraveWorld() == null) {
            thunderPlayer.setGraveWorld("world");
        }

        if (thunderPlayer.getDateCreated() == null) {
            thunderPlayer.setDateCreated(new Date());
        }

        if (thunderPlayer.getUUID() == null) {
            thunderPlayer.setUUID(player.getUniqueId());
        }

        if (thunderPlayer.getParty() == null) {
            thunderPlayer.setParty(player.getUniqueId());
        }

        if (thunderPlayer.getGuild() == null) {
            thunderPlayer.setGuild(player.getUniqueId());
        }

        if (thunderPlayer.getHouses() == null) {
            thunderPlayer.setHouses(new String[0]);
        }

        if (thunderPlayer.getDataPlayTime() == null) {
            thunderPlayer.setDataPlayTime(new long[0]);
        }

        if (thunderPlayer.getDataPvpDamage() == null) {
            thunderPlayer.setDataPvpDamage(new double[0]);
        }

        if (thunderPlayer.getDataPvpDefenseDamage() == null) {
            thunderPlayer.setDataPvpDefenseDamage(new double[0]);
        }

        if (thunderPlayer.getDataPveDamage() == null) {
            thunderPlayer.setDataPveDamage(new double[0]);
        }

        if (thunderPlayer.getDataPveDefenseDamage() == null) {
            thunderPlayer.setDataPveDefenseDamage(new double[0]);
        }

        if (thunderPlayer.getDataWealthGain() == null) {
            thunderPlayer.setDataWealthGain(new double[0]);
        }

        if (thunderPlayer.getDataMoneyDrops() == null) {
            thunderPlayer.setDataMoneyDrops(new double[0]);
        }

        if (thunderPlayer.getTag() == null) {
            thunderPlayer.setTag("New");
        }

        if (thunderPlayer.getLastKnownLocation() == null) {
            thunderPlayer.setLastKnownLocation(new String[0]);
        }

        if (thunderPlayer.getDataWealth() == null) {
            thunderPlayer.setDataWealth(new double[0]);
        }

        if (thunderPlayer.getSessionStats() == null) {
            thunderPlayer.setSessionStats(runSessionSetup());
        }

        PlayerUtil.updatePlayer(thunderPlayer.getUUID(), thunderPlayer);
    }

    private Map<String, double[]> runSessionSetup() {
        Map<String, double[]> sessionStats = new HashMap<>();

        sessionStats.put("pvpDamage", new double[0]);
        sessionStats.put("pvpDefenseDamage", new double[0]);
        sessionStats.put("pveDamage", new double[0]);
        sessionStats.put("pveDefenseDamage", new double[0]);
        sessionStats.put("wealthGain", new double[0]);
        sessionStats.put("moneyDrops", new double[0]);

        return sessionStats;
    }
}
