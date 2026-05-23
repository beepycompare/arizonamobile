package com.arizonagames.feature.arizona.cars;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/arizonagames/feature/arizona/cars/Bonus;", "", "id", "", "valueString", "", "<init>", "(ILjava/lang/String;)V", "getId", "()I", "getValueString", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "cars"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Bonus {
    private final int id;
    private final String valueString;

    public static /* synthetic */ Bonus copy$default(Bonus bonus, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bonus.id;
        }
        if ((i2 & 2) != 0) {
            str = bonus.valueString;
        }
        return bonus.copy(i, str);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.valueString;
    }

    public final Bonus copy(int i, String str) {
        return new Bonus(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Bonus) {
            Bonus bonus = (Bonus) obj;
            return this.id == bonus.id && Intrinsics.areEqual(this.valueString, bonus.valueString);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        String str = this.valueString;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        int i = this.id;
        return "Bonus(id=" + i + ", valueString=" + this.valueString + ")";
    }

    public Bonus(int i, String str) {
        this.id = i;
        this.valueString = str;
    }

    public final int getId() {
        return this.id;
    }

    public final String getValueString() {
        return this.valueString;
    }
}
