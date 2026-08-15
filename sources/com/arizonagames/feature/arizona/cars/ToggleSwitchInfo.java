package com.arizonagames.feature.arizona.cars;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/arizonagames/feature/arizona/cars/ToggleSwitchInfo;", "", TtmlNode.ATTR_ID, "", "title", "", "value", "<init>", "(ILjava/lang/String;I)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getValue", "setValue", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "cars"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ToggleSwitchInfo {
    private final int id;
    private String title;
    private int value;

    public static /* synthetic */ ToggleSwitchInfo copy$default(ToggleSwitchInfo toggleSwitchInfo, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = toggleSwitchInfo.id;
        }
        if ((i3 & 2) != 0) {
            str = toggleSwitchInfo.title;
        }
        if ((i3 & 4) != 0) {
            i2 = toggleSwitchInfo.value;
        }
        return toggleSwitchInfo.copy(i, str, i2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.value;
    }

    public final ToggleSwitchInfo copy(int i, String title, int i2) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new ToggleSwitchInfo(i, title, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToggleSwitchInfo) {
            ToggleSwitchInfo toggleSwitchInfo = (ToggleSwitchInfo) obj;
            return this.id == toggleSwitchInfo.id && Intrinsics.areEqual(this.title, toggleSwitchInfo.title) && this.value == toggleSwitchInfo.value;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.value);
    }

    public String toString() {
        int i = this.id;
        String str = this.title;
        return "ToggleSwitchInfo(id=" + i + ", title=" + str + ", value=" + this.value + ")";
    }

    public ToggleSwitchInfo(int i, String title, int i2) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = i;
        this.title = title;
        this.value = i2;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setValue(int i) {
        this.value = i;
    }
}
