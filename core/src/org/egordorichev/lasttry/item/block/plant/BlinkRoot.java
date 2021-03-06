package org.egordorichev.lasttry.item.block.plant;

import org.egordorichev.lasttry.LastTry;
import org.egordorichev.lasttry.graphics.Assets;
import org.egordorichev.lasttry.graphics.Textures;
import org.egordorichev.lasttry.item.ItemID;

public class BlinkRoot extends Plant {
    public BlinkRoot() {
        super(ItemID.blinkRoot, "Blink Root", Assets.getTexture(Textures.blinkRootIcon), Assets.getTexture(Textures.blinkRoot));
    }

    @Override
    public void updateBlock(int x, int y) {
        byte hp = LastTry.world.getBlockHp(x, y);

        if (hp >= Plant.GROW_THRESHOLD + 1 && LastTry.random.nextInt(3) == 0) {
            LastTry.world.setBlockHP(Plant.GROW_THRESHOLD, x, y);
        } else if (hp == Plant.GROW_THRESHOLD || hp == Plant.GROW_THRESHOLD + 1) {
            LastTry.world.setBlockHP(Plant.GROW_THRESHOLD, x, y);
        } else if (hp < Plant.GROW_THRESHOLD) {
            LastTry.world.setBlockHP((byte) (hp + 1), x, y);
        }
    }

    @Override
    public boolean canBeGrownAt(int x, int y) {
        if (!super.canBeGrownAt(x, y)) {
            return false;
        }

        short id = LastTry.world.getBlockID(x, y + 1);

        if (id != ItemID.dirtBlock) { // TODO: add mud
            return false;
        }

        return true;
    }
}