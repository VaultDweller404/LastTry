package org.egordorichev.lasttry.item;

import org.egordorichev.lasttry.item.Item;
import org.newdawn.slick.Image;

public class Coin extends Item {
	public Coin(int id, String name, Image texture) {
		super(id, name, texture);
	}

	@Override
	public boolean canBeUsed() {
		return false;
	}

	@Override
	public int getMaxInStack() {
		return 100;
	}
}