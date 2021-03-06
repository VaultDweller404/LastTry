package org.egordorichev.lasttry.item.items;

import com.badlogic.gdx.graphics.Texture;
import org.egordorichev.lasttry.item.DamageType;
import org.egordorichev.lasttry.item.Item;
import org.egordorichev.lasttry.item.Rarity;

public class Weapon extends Item {
    protected DamageType damageType;
    protected float baseDamage;
    protected boolean autoSwing;
	protected float criticalStrikeChance;

    public Weapon(short id, String name, Rarity rarity, float baseDamage, DamageType damageType, int useSpeed, Texture texture) {
        super(id, name, rarity, texture);

        this.criticalStrikeChance = 4.0f;
        this.baseDamage = baseDamage;
        this.damageType = damageType;
        this.autoSwing = false;
        this.useSpeed = useSpeed;
        this.useDelay = 0.0f;
    }

    public Weapon(short id, String name, float baseDamage, DamageType damageType, int useSpeed, Texture texture) {
        this(id, name, Rarity.WHITE, baseDamage, damageType, useSpeed, texture);
    }

	@Override
	public boolean use() {
		if (!this.isReady()) {
			return false;
		}

		this.useDelay = this.useSpeed;
		return this.onUse();
	}

	public DamageType getDamageType() {
        return this.damageType;
    }

    public float getBaseDamage() {
        return this.baseDamage;
    }

    public boolean isMagic() {
        return this.damageType == DamageType.MAGIC;
    }

    public boolean isMelee() {
        return this.damageType == DamageType.MELEE;
    }

    public boolean isThrowing() {
        return this.damageType == DamageType.THROWING;
    }

    public boolean isRanged() {
        return this.damageType == DamageType.RANGED;
    }

    public boolean isSummoning() {
        return this.damageType == DamageType.SUMMON;
    }

    public boolean isAutoSwing() {
        return this.autoSwing;
    }
}