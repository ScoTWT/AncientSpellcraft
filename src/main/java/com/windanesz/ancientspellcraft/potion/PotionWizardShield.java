package com.windanesz.ancientspellcraft.potion;

import com.windanesz.ancientspellcraft.item.ItemNewArtefact;
import com.windanesz.ancientspellcraft.registry.AncientSpellcraftItems;
import com.windanesz.ancientspellcraft.registry.AncientSpellcraftPotions;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.Constants;

import java.util.UUID;

public class PotionWizardShield extends PotionMagicEffectAS {

	public static final UUID shieldUUID = UUID.fromString("ad3f15af-1039-470c-9460-9913c70d17d4");

	public PotionWizardShield(String name, boolean isBadEffect, int liquidColour, ResourceLocation texture) {
		super(name, isBadEffect, liquidColour, texture);
		this.registerPotionAttributeModifier(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, shieldUUID.toString(), 1.0D, Constants.AttributeModifierOperation.ADD);
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		if (duration == 40 && amplifier > 0) {
			// ready to reduce amplifier and increase duration by one second
			return true;
		}
		return super.isReady(duration, amplifier);
	}

	@Override
	public void performEffect(EntityLivingBase entity, int amplifier) {

		super.performEffect(entity, amplifier);

		if (entity instanceof EntityPlayer) {
			boolean hasArtefact = ItemNewArtefact.isNewArtefactActive((EntityPlayer) entity, AncientSpellcraftItems.head_shield);
			int newAmplifier = amplifier - (hasArtefact ? 1 : 2);
			if (newAmplifier >= 0) {
				PotionEffect newEffect = new PotionEffect(AncientSpellcraftPotions.wizard_shield, hasArtefact ? 70 : 60, newAmplifier);
				entity.removePotionEffect(this);
				entity.addPotionEffect(newEffect);
			}
		}
	}
}
