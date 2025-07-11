package ru.mrlargha.commonui.elements.tuningAuto.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResponseData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/tuningAuto/domain/AddedToCart;", "", "color", "", "icon", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getIcon", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddedToCart {
    private final String color;
    private final String icon;
    private final String text;

    public static /* synthetic */ AddedToCart copy$default(AddedToCart addedToCart, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addedToCart.color;
        }
        if ((i & 2) != 0) {
            str2 = addedToCart.icon;
        }
        if ((i & 4) != 0) {
            str3 = addedToCart.text;
        }
        return addedToCart.copy(str, str2, str3);
    }

    public final String component1() {
        return this.color;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.text;
    }

    public final AddedToCart copy(String color, String icon, String text) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        return new AddedToCart(color, icon, text);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AddedToCart) {
            AddedToCart addedToCart = (AddedToCart) obj;
            return Intrinsics.areEqual(this.color, addedToCart.color) && Intrinsics.areEqual(this.icon, addedToCart.icon) && Intrinsics.areEqual(this.text, addedToCart.text);
        }
        return false;
    }

    public int hashCode() {
        return (((this.color.hashCode() * 31) + this.icon.hashCode()) * 31) + this.text.hashCode();
    }

    public String toString() {
        String str = this.color;
        String str2 = this.icon;
        return "AddedToCart(color=" + str + ", icon=" + str2 + ", text=" + this.text + ")";
    }

    public AddedToCart(String color, String icon, String text) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(text, "text");
        this.color = color;
        this.icon = icon;
        this.text = text;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }
}
