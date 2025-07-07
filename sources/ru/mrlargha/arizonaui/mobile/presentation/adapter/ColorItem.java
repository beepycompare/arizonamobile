package ru.mrlargha.arizonaui.mobile.presentation.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.mobile.domain.obj.AvatarBackground;
/* compiled from: MobilePhoneMessengerColorsAdapter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/ColorItem;", "", "color", "Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;", "isSelected", "", "<init>", "(Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;Z)V", "getColor", "()Lru/mrlargha/arizonaui/mobile/domain/obj/AvatarBackground;", "()Z", "setSelected", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ColorItem {
    private final AvatarBackground color;
    private boolean isSelected;

    public static /* synthetic */ ColorItem copy$default(ColorItem colorItem, AvatarBackground avatarBackground, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            avatarBackground = colorItem.color;
        }
        if ((i & 2) != 0) {
            z = colorItem.isSelected;
        }
        return colorItem.copy(avatarBackground, z);
    }

    public final AvatarBackground component1() {
        return this.color;
    }

    public final boolean component2() {
        return this.isSelected;
    }

    public final ColorItem copy(AvatarBackground color, boolean z) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new ColorItem(color, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ColorItem) {
            ColorItem colorItem = (ColorItem) obj;
            return this.color == colorItem.color && this.isSelected == colorItem.isSelected;
        }
        return false;
    }

    public int hashCode() {
        return (this.color.hashCode() * 31) + Boolean.hashCode(this.isSelected);
    }

    public String toString() {
        AvatarBackground avatarBackground = this.color;
        return "ColorItem(color=" + avatarBackground + ", isSelected=" + this.isSelected + ")";
    }

    public ColorItem(AvatarBackground color, boolean z) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
        this.isSelected = z;
    }

    public /* synthetic */ ColorItem(AvatarBackground avatarBackground, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(avatarBackground, (i & 2) != 0 ? false : z);
    }

    public final AvatarBackground getColor() {
        return this.color;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
