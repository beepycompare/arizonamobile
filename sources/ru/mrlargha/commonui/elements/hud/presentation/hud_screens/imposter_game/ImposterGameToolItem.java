package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.imposter_game;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/imposter_game/ImposterGameToolItem;", "", "id", "", "image", "", "selected", "<init>", "(ILjava/lang/String;I)V", "getId", "()I", "getImage", "()Ljava/lang/String;", "getSelected", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ImposterGameToolItem {
    private final int id;
    private final String image;
    private final int selected;

    public static /* synthetic */ ImposterGameToolItem copy$default(ImposterGameToolItem imposterGameToolItem, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = imposterGameToolItem.id;
        }
        if ((i3 & 2) != 0) {
            str = imposterGameToolItem.image;
        }
        if ((i3 & 4) != 0) {
            i2 = imposterGameToolItem.selected;
        }
        return imposterGameToolItem.copy(i, str, i2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.image;
    }

    public final int component3() {
        return this.selected;
    }

    public final ImposterGameToolItem copy(int i, String image, int i2) {
        Intrinsics.checkNotNullParameter(image, "image");
        return new ImposterGameToolItem(i, image, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImposterGameToolItem) {
            ImposterGameToolItem imposterGameToolItem = (ImposterGameToolItem) obj;
            return this.id == imposterGameToolItem.id && Intrinsics.areEqual(this.image, imposterGameToolItem.image) && this.selected == imposterGameToolItem.selected;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.image.hashCode()) * 31) + Integer.hashCode(this.selected);
    }

    public String toString() {
        int i = this.id;
        String str = this.image;
        return "ImposterGameToolItem(id=" + i + ", image=" + str + ", selected=" + this.selected + ")";
    }

    public ImposterGameToolItem(int i, String image, int i2) {
        Intrinsics.checkNotNullParameter(image, "image");
        this.id = i;
        this.image = image;
        this.selected = i2;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final int getSelected() {
        return this.selected;
    }
}
