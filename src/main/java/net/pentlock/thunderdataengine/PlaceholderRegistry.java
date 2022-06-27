package net.pentlock.thunderdataengine;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.pentlock.thunderdataengine.profiles.Guild;
import net.pentlock.thunderdataengine.profiles.ThunderPlayer;
import net.pentlock.thunderdataengine.utilities.GuildUtil;
import net.pentlock.thunderdataengine.utilities.PlayerUtil;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.util.UUID;

public class PlaceholderRegistry extends PlaceholderExpansion {

    private final ThunderDataEngine plugin;

    /**
     * Since we register the expansion inside our own plugin, we
     * can simply use this method here to get an instance of our
     * plugin.
     *
     * @param plugin
     *        The instance of our plugin.
     */
    public PlaceholderRegistry(ThunderDataEngine plugin){
        this.plugin = plugin;
    }

    /**
     * Because this is an internal class,
     * you must override this method to let PlaceholderAPI know to not unregister your expansion class when
     * PlaceholderAPI is reloaded
     *
     * @return true to persist through reloads
     */
    @Override
    public boolean persist(){
        return true;
    }

    /**
     * Because this is a internal class, this check is not needed
     * and we can simply return {@code true}
     *
     * @return Always true since it's an internal class.
     */
    @Override
    public boolean canRegister(){
        return true;
    }

    /**
     * The name of the person who created this expansion should go here.
     * <br>For convienience do we return the author from the plugin.yml
     *
     * @return The name of the author as a String.
     */
    @Override
    public String getAuthor(){
        return plugin.getDescription().getAuthors().toString();
    }

    /**
     * The placeholder identifier should go here.
     * <br>This is what tells PlaceholderAPI to call our onRequest
     * method to obtain a value if a placeholder starts with our
     * identifier.
     * <br>The identifier has to be lowercase and can't contain _ or %
     *
     * @return The identifier in {@code %<identifier>_<value>%} as String.
     */
    @Override
    public String getIdentifier(){
        return "tde";
    }

    /**
     * This is the version of the expansion.
     * <br>You don't have to use numbers, since it is set as a String.
     *
     * For convienience do we return the version from the plugin.yml
     *
     * @return The version as a String.
     */
    @Override
    public String getVersion(){
        return plugin.getDescription().getVersion();
    }


    @Override
    public String onPlaceholderRequest(Player player, String identifier) {


        if (player == null) {
            return "";
        }
        ThunderPlayer thunderPlayer = PlayerUtil.findPlayer(player.getUniqueId());
        assert thunderPlayer != null;
        Guild guild;
        if (!player.getUniqueId().toString().equalsIgnoreCase(thunderPlayer.getGuild().toString())) {
            guild = GuildUtil.findGuild(thunderPlayer.getGuild());

        } else {
            guild = GuildUtil.findGuild(UUID.fromString("069a79f4-44e9-4726-a5be-fca90e38aaf5"));
        }


        // %tde_home_grave%
        if (identifier.equals("home_grave")) {
            String value = thunderPlayer.getGrave();
            return String.valueOf(value);
        }

        // %tde_max_health%
        if (identifier.equals("max_health")) {
            int value = thunderPlayer.getMaxHealth();
            return String.valueOf(value);
        }

        // %tde_current_health%
        if (identifier.equals("current_health")) {
            double temp = thunderPlayer.getCurrentHealth();
            long value;
            if (temp < 1) {
                value = 1;
            } else {
                value = Math.round(temp);
            }
            return String.valueOf(value);
        }

        // %tde_current_health_dec%
        if (identifier.equals("current_health_dec")) {
            double temp = thunderPlayer.getCurrentHealth();
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            return String.valueOf(numberFormat.format(temp));
        }

        // %tde_luck%
        if (identifier.equals("luck")) {

            int luck = thunderPlayer.getLuck();
            String value;
            if (luck > 5) {
                value = "Good";
            } else if (luck > -5) {
                value = "neutral";
            } else {
                value = "Bad";
            }

            return value;
        }

        // %tde_luck_number%
        if (identifier.equals("luck_number")) {
            int value = thunderPlayer.getLuck();
            return String.valueOf(value);
        }

        // %tde_critical_strike%
        if (identifier.equals("critical_strike")) {
            Double value = thunderPlayer.getCriticalStrike();
            return String.valueOf(value);
        }

        // %tde_critical_power%
        if (identifier.equals("critical_power")) {
            double value = thunderPlayer.getCriticalPower();
            return String.valueOf(value);
        }

        // %tde_physical_attack%
        if (identifier.equals("physical_attack")) {
            int value = thunderPlayer.getPhysicalOffense();
            return String.valueOf(value);
        }

        // %tde_archery_attack%
        if (identifier.equals("archery_attack")) {
            int value = thunderPlayer.getArcheryOffense();
            return String.valueOf(value);
        }

        // %tde_physical_defense%
        if (identifier.equals("physical_defense")) {
            int value = thunderPlayer.getPhysicalDefense();
            return String.valueOf(value);
        }

        // %tde_archery_defense%
        if (identifier.equals("archery_defense")) {
            int value = thunderPlayer.getArcheryDefense();
            return String.valueOf(value);
        }

        // %tde_level%
        if (identifier.equals("level")) {
            int level = thunderPlayer.getLevel();
            return String.valueOf(level);
        }

        // %tde_exp%
        if (identifier.equals("exp")) {
            long level = thunderPlayer.getExp();
            return String.valueOf(level);
        }

        // %tde_perk_points%
        if (identifier.equals("perk_points")) {
            return String.valueOf(thunderPlayer.getPerkPoints());
        }

        // %tde_perk_points_health%
        if (identifier.equals("perk_points_health")) {
            return String.valueOf(thunderPlayer.getHealthPerkPoints());
        }

        // %tde_perk_points_critical_strike%
        if (identifier.equals("perk_points_critical_strike")) {
            return String.valueOf(thunderPlayer.getCriticalStrikePerkPoints());
        }

        // %tde_perk_points_critical_power%
        if (identifier.equals("perk_points_critical_power")) {
            return String.valueOf(thunderPlayer.getCriticalPowerPerkPoints());
        }

        // %tde_perk_points_physical_defense%
        if (identifier.equals("perk_points_physical_defense")) {
            return String.valueOf(thunderPlayer.getPhysicalDefensePerkPoints());
        }

        // %tde_perk_points_archery_defense%
        if (identifier.equals("perk_points_archery_defense")) {
            return String.valueOf(thunderPlayer.getArcheryDefensePerkPoints());
        }

        // %tde_perk_points_physical_offense%
        if (identifier.equals("perk_points_physical_offense")) {
            return String.valueOf(thunderPlayer.getPhysicalOffensePerkPoints());
        }

        // %tde_perk_points_archery_offense%
        if (identifier.equals("perk_points_archery_offense")) {
            return String.valueOf(thunderPlayer.getArcheryOffensePerkPoints());
        }

        // %tde_guild_name%
        if (identifier.equals("guild_name")) {
            return guild.getName();
        }
        return null;
    }
}
