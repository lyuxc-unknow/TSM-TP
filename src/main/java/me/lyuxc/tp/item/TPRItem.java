package me.lyuxc.tp.item;

import me.lyuxc.tp.DataComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class TPRItem extends Item {
    public TPRItem() {
        super(new Properties()
                .stacksTo(1)
        );
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        double playerX = itemStack.get(DataComponent.X);
        double playerY = itemStack.get(DataComponent.Y);
        double playerZ = itemStack.get(DataComponent.Z);
        pPlayer.setPos(playerX,playerY,playerZ);
//        pPlayer.setItemInHand(pUsedHand, Items.AIR.getDefaultInstance());
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
