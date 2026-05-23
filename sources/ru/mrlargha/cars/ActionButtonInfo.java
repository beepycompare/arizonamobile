package ru.mrlargha.cars;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001d"}, d2 = {"Lru/mrlargha/cars/ActionButtonInfo;", "", "id", "", "title", "", "icon", "color", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getIcon", "setIcon", "getColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "cars"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ActionButtonInfo {
    private final String color;
    private String icon;
    private final int id;
    private String title;

    public static /* synthetic */ ActionButtonInfo copy$default(ActionButtonInfo actionButtonInfo, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = actionButtonInfo.id;
        }
        if ((i2 & 2) != 0) {
            str = actionButtonInfo.title;
        }
        if ((i2 & 4) != 0) {
            str2 = actionButtonInfo.icon;
        }
        if ((i2 & 8) != 0) {
            str3 = actionButtonInfo.color;
        }
        return actionButtonInfo.copy(i, str, str2, str3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.color;
    }

    public final ActionButtonInfo copy(int i, String title, String icon, String str) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new ActionButtonInfo(i, title, icon, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActionButtonInfo) {
            ActionButtonInfo actionButtonInfo = (ActionButtonInfo) obj;
            return this.id == actionButtonInfo.id && Intrinsics.areEqual(this.title, actionButtonInfo.title) && Intrinsics.areEqual(this.icon, actionButtonInfo.icon) && Intrinsics.areEqual(this.color, actionButtonInfo.color);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.icon.hashCode()) * 31;
        String str = this.color;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        String str2 = this.icon;
        return "ActionButtonInfo(id=" + i + ", title=" + str + ", icon=" + str2 + ", color=" + this.color + ")";
    }

    public ActionButtonInfo(int i, String title, String icon, String str) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.id = i;
        this.title = title;
        this.icon = icon;
        this.color = str;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final String getColor() {
        return this.color;
    }
}
