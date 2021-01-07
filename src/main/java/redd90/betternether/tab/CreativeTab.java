package redd90.betternether.tab;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import redd90.betternether.BetterNether;
import redd90.betternether.registry.BlocksRegistry;

public class CreativeTab {
    public static final ItemGroup BN_TAB = new ItemGroup(BetterNether.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlocksRegistry.NETHER_GRASS);
        }
    };
}
