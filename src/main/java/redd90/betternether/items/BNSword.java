package redd90.betternether.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;
import redd90.betternether.registry.ItemsRegistry;

public class BNSword extends SwordItem {
	public BNSword(IItemTier material, int durability, int attackDamage, float attackSpeed) {
		super(material, attackDamage, attackSpeed, ItemsRegistry.defaultSettings().isImmuneToFire());
	}
}
