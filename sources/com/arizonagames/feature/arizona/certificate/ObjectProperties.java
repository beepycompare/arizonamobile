package com.arizonagames.feature.arizona.certificate;

import kotlin.Metadata;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/arizonagames/feature/arizona/certificate/ObjectProperties;", "", "main_color", "", "sec_color", "wear", "dirt", "<init>", "(IIII)V", "getMain_color", "()I", "getSec_color", "getWear", "getDirt", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "certificate"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ObjectProperties {
    private final int dirt;
    private final int main_color;
    private final int sec_color;
    private final int wear;

    public static /* synthetic */ ObjectProperties copy$default(ObjectProperties objectProperties, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = objectProperties.main_color;
        }
        if ((i5 & 2) != 0) {
            i2 = objectProperties.sec_color;
        }
        if ((i5 & 4) != 0) {
            i3 = objectProperties.wear;
        }
        if ((i5 & 8) != 0) {
            i4 = objectProperties.dirt;
        }
        return objectProperties.copy(i, i2, i3, i4);
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

    public final int component4() {
        return this.dirt;
    }

    public final ObjectProperties copy(int i, int i2, int i3, int i4) {
        return new ObjectProperties(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ObjectProperties) {
            ObjectProperties objectProperties = (ObjectProperties) obj;
            return this.main_color == objectProperties.main_color && this.sec_color == objectProperties.sec_color && this.wear == objectProperties.wear && this.dirt == objectProperties.dirt;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.main_color) * 31) + Integer.hashCode(this.sec_color)) * 31) + Integer.hashCode(this.wear)) * 31) + Integer.hashCode(this.dirt);
    }

    public String toString() {
        int i = this.main_color;
        int i2 = this.sec_color;
        int i3 = this.wear;
        return "ObjectProperties(main_color=" + i + ", sec_color=" + i2 + ", wear=" + i3 + ", dirt=" + this.dirt + ")";
    }

    public ObjectProperties(int i, int i2, int i3, int i4) {
        this.main_color = i;
        this.sec_color = i2;
        this.wear = i3;
        this.dirt = i4;
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

    public final int getDirt() {
        return this.dirt;
    }
}
