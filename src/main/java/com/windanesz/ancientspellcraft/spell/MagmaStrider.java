package com.windanesz.ancientspellcraft.spell;

import com.windanesz.ancientspellcraft.AncientSpellcraft;
import com.windanesz.ancientspellcraft.handler.ASEventHandler;
import com.windanesz.ancientspellcraft.registry.AncientSpellcraftItems;
import com.windanesz.ancientspellcraft.registry.AncientSpellcraftPotions;
import electroblob.wizardry.spell.SpellBuff;
import net.minecraft.item.Item;

/**
 *  Effect applied in {@link ASEventHandler#onLivingUpdateEvent(net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent)}
 */
public class MagmaStrider extends SpellBuff {

	public MagmaStrider() {
		super(AncientSpellcraft.MODID, "magma_strider", 216, 26, 11, () -> AncientSpellcraftPotions.magma_strider);
		soundValues(0.7f, 1.2f, 0.4f);
	}

	@Override
	public boolean applicableForItem(Item item) {
		return item == AncientSpellcraftItems.ancient_spellcraft_spell_book || item == AncientSpellcraftItems.ancient_spellcraft_scroll;
	}
}
