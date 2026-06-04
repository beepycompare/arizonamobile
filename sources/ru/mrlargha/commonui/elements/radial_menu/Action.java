package ru.mrlargha.commonui.elements.radial_menu;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SectorData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\b\u0001\u0010\u0004\u001a\u00020\u0005:\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\b\u0003\u0010\u0004\u001a\u00020\u0005:\u0002\b\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u0092\u0002\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/Action;", "", "title", "", "iconResource", "", "Landroidx/annotation/DrawableRes;", "<init>", "(Ljava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getIconResource", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Action {
    private final int iconResource;
    private final String title;

    public static /* synthetic */ Action copy$default(Action action, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = action.title;
        }
        if ((i2 & 2) != 0) {
            i = action.iconResource;
        }
        return action.copy(str, i);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.iconResource;
    }

    public final Action copy(String title, int i) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new Action(title, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Action) {
            Action action = (Action) obj;
            return Intrinsics.areEqual(this.title, action.title) && this.iconResource == action.iconResource;
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + Integer.hashCode(this.iconResource);
    }

    public String toString() {
        String str = this.title;
        return "Action(title=" + str + ", iconResource=" + this.iconResource + ")";
    }

    public Action(String title, int i) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.iconResource = i;
    }

    public final int getIconResource() {
        return this.iconResource;
    }

    public final String getTitle() {
        return this.title;
    }
}
