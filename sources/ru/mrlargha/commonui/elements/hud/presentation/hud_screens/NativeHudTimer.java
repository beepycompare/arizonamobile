package ru.mrlargha.commonui.elements.hud.presentation.hud_screens;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NativeProvider.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/NativeHudTimer;", "", "seconds", "", "maxTime", "icon", "", "<init>", "(IILjava/lang/String;)V", "getSeconds", "()I", "getMaxTime", "getIcon", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NativeHudTimer {
    private final String icon;
    private final int maxTime;
    private final int seconds;

    public static /* synthetic */ NativeHudTimer copy$default(NativeHudTimer nativeHudTimer, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = nativeHudTimer.seconds;
        }
        if ((i3 & 2) != 0) {
            i2 = nativeHudTimer.maxTime;
        }
        if ((i3 & 4) != 0) {
            str = nativeHudTimer.icon;
        }
        return nativeHudTimer.copy(i, i2, str);
    }

    public final int component1() {
        return this.seconds;
    }

    public final int component2() {
        return this.maxTime;
    }

    public final String component3() {
        return this.icon;
    }

    public final NativeHudTimer copy(int i, int i2, String icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new NativeHudTimer(i, i2, icon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NativeHudTimer) {
            NativeHudTimer nativeHudTimer = (NativeHudTimer) obj;
            return this.seconds == nativeHudTimer.seconds && this.maxTime == nativeHudTimer.maxTime && Intrinsics.areEqual(this.icon, nativeHudTimer.icon);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.seconds) * 31) + Integer.hashCode(this.maxTime)) * 31) + this.icon.hashCode();
    }

    public String toString() {
        int i = this.seconds;
        int i2 = this.maxTime;
        return "NativeHudTimer(seconds=" + i + ", maxTime=" + i2 + ", icon=" + this.icon + ")";
    }

    public NativeHudTimer(int i, int i2, String icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.seconds = i;
        this.maxTime = i2;
        this.icon = icon;
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public final int getMaxTime() {
        return this.maxTime;
    }

    public final String getIcon() {
        return this.icon;
    }
}
