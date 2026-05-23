package ru.mrlargha.arizona.rating;

import kotlin.Metadata;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizona/rating/ObjectProperties;", "", "main_color", "", "sec_color", "wear", "<init>", "(III)V", "getMain_color", "()I", "getSec_color", "getWear", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "item-rating"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ObjectProperties {
    private final int main_color;
    private final int sec_color;
    private final int wear;

    public static /* synthetic */ ObjectProperties copy$default(ObjectProperties objectProperties, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = objectProperties.main_color;
        }
        if ((i4 & 2) != 0) {
            i2 = objectProperties.sec_color;
        }
        if ((i4 & 4) != 0) {
            i3 = objectProperties.wear;
        }
        return objectProperties.copy(i, i2, i3);
    }

    public final int component1() {
        return this.main_color;
    }

    public final int component2() {
        return this.sec_color;
    }

    public final int component3() {
        return this.wear;
    }

    public final ObjectProperties copy(int i, int i2, int i3) {
        return new ObjectProperties(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ObjectProperties) {
            ObjectProperties objectProperties = (ObjectProperties) obj;
            return this.main_color == objectProperties.main_color && this.sec_color == objectProperties.sec_color && this.wear == objectProperties.wear;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.main_color) * 31) + Integer.hashCode(this.sec_color)) * 31) + Integer.hashCode(this.wear);
    }

    public String toString() {
        int i = this.main_color;
        int i2 = this.sec_color;
        return "ObjectProperties(main_color=" + i + ", sec_color=" + i2 + ", wear=" + this.wear + ")";
    }

    public ObjectProperties(int i, int i2, int i3) {
        this.main_color = i;
        this.sec_color = i2;
        this.wear = i3;
    }

    public final int getMain_color() {
        return this.main_color;
    }

    public final int getSec_color() {
        return this.sec_color;
    }

    public final int getWear() {
        return this.wear;
    }
}
