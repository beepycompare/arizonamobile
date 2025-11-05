package com.arizonagames.feature.arizona.cars;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/arizonagames/feature/arizona/cars/ActionButtonInfo;", "", "id", "", "title", "", "icon", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getIcon", "setIcon", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "cars_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ActionButtonInfo {
    private String icon;
    private final int id;
    private String title;

    public static /* synthetic */ ActionButtonInfo copy$default(ActionButtonInfo actionButtonInfo, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = actionButtonInfo.id;
        }
        if ((i2 & 2) != 0) {
            str = actionButtonInfo.title;
        }
        if ((i2 & 4) != 0) {
            str2 = actionButtonInfo.icon;
        }
        return actionButtonInfo.copy(i, str, str2);
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

    public final ActionButtonInfo copy(int i, String title, String icon) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new ActionButtonInfo(i, title, icon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActionButtonInfo) {
            ActionButtonInfo actionButtonInfo = (ActionButtonInfo) obj;
            return this.id == actionButtonInfo.id && Intrinsics.areEqual(this.title, actionButtonInfo.title) && Intrinsics.areEqual(this.icon, actionButtonInfo.icon);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.icon.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        return "ActionButtonInfo(id=" + i + ", title=" + str + ", icon=" + this.icon + ")";
    }

    public ActionButtonInfo(int i, String title, String icon) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.id = i;
        this.title = title;
        this.icon = icon;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
