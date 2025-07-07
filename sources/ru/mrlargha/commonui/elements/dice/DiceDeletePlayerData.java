package ru.mrlargha.commonui.elements.dice;

import kotlin.Metadata;
/* compiled from: Dice.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/dice/DiceDeletePlayerData;", "", "id", "", "<init>", "(I)V", "getId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DiceDeletePlayerData {
    private final int id;

    public static /* synthetic */ DiceDeletePlayerData copy$default(DiceDeletePlayerData diceDeletePlayerData, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = diceDeletePlayerData.id;
        }
        return diceDeletePlayerData.copy(i);
    }

    public final int component1() {
        return this.id;
    }

    public final DiceDeletePlayerData copy(int i) {
        return new DiceDeletePlayerData(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DiceDeletePlayerData) && this.id == ((DiceDeletePlayerData) obj).id;
    }

    public int hashCode() {
        return Integer.hashCode(this.id);
    }

    public String toString() {
        return "DiceDeletePlayerData(id=" + this.id + ")";
    }

    public DiceDeletePlayerData(int i) {
        this.id = i;
    }

    public final int getId() {
        return this.id;
    }
}
