package redd90.betternether.mixin;

import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

import redd90.betternether.BetterNether;

public class MixinConnector implements IMixinConnector {
	@Override
	public void connect() {
		BetterNether.LOGGER.debug("Better Nether: Connecting Mixins...");
		Mixins.addConfiguration("betternether.mixins.json");
		//BetterNether.isUsingMixin = true;
		BetterNether.LOGGER.info("Better Nether: Mixin Connected!");
	}
}
