package net.pentlock.thunderdataengine.beton;

import net.pentlock.thunderdataengine.profiles.ThunderPlayer;
import net.pentlock.thunderdataengine.utilities.PlayerUtil;
import org.betonquest.betonquest.Instruction;
import org.betonquest.betonquest.api.Condition;
import org.betonquest.betonquest.exceptions.InstructionParseException;
import org.betonquest.betonquest.exceptions.QuestRuntimeException;
import org.betonquest.betonquest.utils.PlayerConverter;
import org.bukkit.entity.Player;

public class PhysicalOffenseCondition extends Condition {
    private final int offense;
    public PhysicalOffenseCondition(Instruction instruction, boolean forceSync) throws InstructionParseException {
        super(instruction, forceSync);
        this.offense = instruction.getInt();
    }

    @Override
    protected Boolean execute(String s) throws QuestRuntimeException {
        Player player = PlayerConverter.getPlayer(s);
        ThunderPlayer thunderPlayer = PlayerUtil.findPlayer(player.getUniqueId());
        if (thunderPlayer != null) {
            return offense <= thunderPlayer.getPhysicalOffense();
        } else {
            return null;
        }
    }
}
