package ru.mrlargha.commonui.elements.shop;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ShopScreen.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/shop/SellerInfo;", "", "name", "", "type", "", "buttons", "<init>", "(Ljava/lang/String;II)V", "getName", "()Ljava/lang/String;", "getType", "()I", "getButtons", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SellerInfo {
    private final int buttons;
    private final String name;
    private final int type;

    public static /* synthetic */ SellerInfo copy$default(SellerInfo sellerInfo, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sellerInfo.name;
        }
        if ((i3 & 2) != 0) {
            i = sellerInfo.type;
        }
        if ((i3 & 4) != 0) {
            i2 = sellerInfo.buttons;
        }
        return sellerInfo.copy(str, i, i2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.buttons;
    }

    public final SellerInfo copy(String name, int i, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new SellerInfo(name, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SellerInfo) {
            SellerInfo sellerInfo = (SellerInfo) obj;
            return Intrinsics.areEqual(this.name, sellerInfo.name) && this.type == sellerInfo.type && this.buttons == sellerInfo.buttons;
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.buttons);
    }

    public String toString() {
        String str = this.name;
        int i = this.type;
        return "SellerInfo(name=" + str + ", type=" + i + ", buttons=" + this.buttons + ")";
    }

    public SellerInfo(String name, int i, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.type = i;
        this.buttons = i2;
    }

    public final int getButtons() {
        return this.buttons;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }
}
