package com.github.stars_sea.enderport.item;

import com.github.stars_sea.enderport.sound.SoundShortcut;
import com.github.stars_sea.enderport.util.EffectHelper;
import com.github.stars_sea.enderport.world.Location;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class EnderPearlFragment extends Item {
    public EnderPearlFragment() {
        super(new Settings().group(ItemGroup.MISC).maxCount(16));
    }

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, @NotNull PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        stack.decrement(1);

        Location location = new Location(world, user.getPos());
        location.teleportToNearbySafely(30, user);

        EffectHelper.addTpParticles(world, user.getPos());
        SoundShortcut.TELEPORT.play(user);
        user.getItemCooldownManager().set(this, 100);
        user.incrementStat(Stats.USED.getOrCreateStat(this));

        return TypedActionResult.consume(stack);
    }
}
