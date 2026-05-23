package ru.mrlargha.cars;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006'"}, d2 = {"Lru/mrlargha/cars/CircleProgressBarInfo;", "", "id", "", "title", "", "icon", "value", "maxValue", "postfix", "<init>", "(ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getIcon", "setIcon", "getValue", "setValue", "(I)V", "getMaxValue", "setMaxValue", "getPostfix", "setPostfix", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "cars"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CircleProgressBarInfo {
    private String icon;
    private final int id;
    private int maxValue;
    private String postfix;
    private String title;
    private int value;

    public static /* synthetic */ CircleProgressBarInfo copy$default(CircleProgressBarInfo circleProgressBarInfo, int i, String str, String str2, int i2, int i3, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = circleProgressBarInfo.id;
        }
        if ((i4 & 2) != 0) {
            str = circleProgressBarInfo.title;
        }
        if ((i4 & 4) != 0) {
            str2 = circleProgressBarInfo.icon;
        }
        if ((i4 & 8) != 0) {
            i2 = circleProgressBarInfo.value;
        }
        if ((i4 & 16) != 0) {
            i3 = circleProgressBarInfo.maxValue;
        }
        if ((i4 & 32) != 0) {
            str3 = circleProgressBarInfo.postfix;
        }
        int i5 = i3;
        String str4 = str3;
        return circleProgressBarInfo.copy(i, str, str2, i2, i5, str4);
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

    public final int component4() {
        return this.value;
    }

    public final int component5() {
        return this.maxValue;
    }

    public final String component6() {
        return this.postfix;
    }

    public final CircleProgressBarInfo copy(int i, String title, String icon, int i2, int i3, String postfix) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return new CircleProgressBarInfo(i, title, icon, i2, i3, postfix);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CircleProgressBarInfo) {
            CircleProgressBarInfo circleProgressBarInfo = (CircleProgressBarInfo) obj;
            return this.id == circleProgressBarInfo.id && Intrinsics.areEqual(this.title, circleProgressBarInfo.title) && Intrinsics.areEqual(this.icon, circleProgressBarInfo.icon) && this.value == circleProgressBarInfo.value && this.maxValue == circleProgressBarInfo.maxValue && Intrinsics.areEqual(this.postfix, circleProgressBarInfo.postfix);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.icon.hashCode()) * 31) + Integer.hashCode(this.value)) * 31) + Integer.hashCode(this.maxValue)) * 31) + this.postfix.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        String str2 = this.icon;
        int i2 = this.value;
        int i3 = this.maxValue;
        return "CircleProgressBarInfo(id=" + i + ", title=" + str + ", icon=" + str2 + ", value=" + i2 + ", maxValue=" + i3 + ", postfix=" + this.postfix + ")";
    }

    public CircleProgressBarInfo(int i, String title, String icon, int i2, int i3, String postfix) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        this.id = i;
        this.title = title;
        this.icon = icon;
        this.value = i2;
        this.maxValue = i3;
        this.postfix = postfix;
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

    public final int getMaxValue() {
        return this.maxValue;
    }

    public final String getPostfix() {
        return this.postfix;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setMaxValue(int i) {
        this.maxValue = i;
    }

    public final void setPostfix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.postfix = str;
    }

    public final void setValue(int i) {
        this.value = i;
    }
}
