package steph.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import steph.tutorialmod.TutorialMod;

public class ModItems {
    public static final Item CITRINE = registerItem("citrine",
            new Item(new FabricItemSettings()));

    public static final Item GREENGUY = registerItem("greenguy",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.Mod_ID, name), item);
    }


    public static void addItemstoItemGroup(){
        addToItemsGroup(ItemGroups.INGREDIENTS, CITRINE);
        addToItemsGroup(ItemGroups.FUNCTIONAL, GREENGUY);
    }
    private static void addToItemsGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.Mod_ID);

        addItemstoItemGroup();
}

}
