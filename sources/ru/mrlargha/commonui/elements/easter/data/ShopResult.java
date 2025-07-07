package ru.mrlargha.commonui.elements.easter.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ShopData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/easter/data/ShopResult;", "", "image", "", "name", "", "count", "caption", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "getImage", "()I", "getName", "()Ljava/lang/String;", "getCount", "getCaption", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShopResult {
    private final String caption;
    private final int count;
    private final int image;
    private final String name;

    public static /* synthetic */ ShopResult copy$default(ShopResult shopResult, int i, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = shopResult.image;
        }
        if ((i3 & 2) != 0) {
            str = shopResult.name;
        }
        if ((i3 & 4) != 0) {
            i2 = shopResult.count;
        }
        if ((i3 & 8) != 0) {
            str2 = shopResult.caption;
        }
        return shopResult.copy(i, str, i2, str2);
    }

    public final int component1() {
        return this.image;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.count;
    }

    public final String component4() {
        return this.caption;
    }

    public final ShopResult copy(int i, String name, int i2, String caption) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(caption, "caption");
        return new ShopResult(i, name, i2, caption);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShopResult) {
            ShopResult shopResult = (ShopResult) obj;
            return this.image == shopResult.image && Intrinsics.areEqual(this.name, shopResult.name) && this.count == shopResult.count && Intrinsics.areEqual(this.caption, shopResult.caption);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.image) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.count)) * 31) + this.caption.hashCode();
    }

    public String toString() {
        int i = this.image;
        String str = this.name;
        int i2 = this.count;
        return "ShopResult(image=" + i + ", name=" + str + ", count=" + i2 + ", caption=" + this.caption + ")";
    }

    public ShopResult(int i, String name, int i2, String caption) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(caption, "caption");
        this.image = i;
        this.name = name;
        this.count = i2;
        this.caption = caption;
    }

    public final int getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getCaption() {
        return this.caption;
    }
}
