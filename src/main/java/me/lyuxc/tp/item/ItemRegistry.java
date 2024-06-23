package me.lyuxc.tp.item;

import me.lyuxc.tp.TestStarTP;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestStarTP.MOD_ID);

    public static final DeferredItem<Item> TPJ = ITEMS.register("tpj", TPJItem::new);
    public static final DeferredItem<Item> TPR = ITEMS.register("tpr", TPRItem::new);


    public static void addCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == TestStarTP.TP_TAB.value()) {
            ITEMS.getEntries().stream().map(DeferredHolder::get).forEach(event::accept);
        }
    }

    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        modEventBus.addListener(ItemRegistry::addCreativeTab);
    }
}
