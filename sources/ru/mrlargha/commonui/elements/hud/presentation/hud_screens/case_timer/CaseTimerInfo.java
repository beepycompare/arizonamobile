package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.case_timer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CaseTimer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/case_timer/CaseTimerInfo;", "", "image", "", "time", "buttonText", "", "<init>", "(IILjava/lang/String;)V", "getImage", "()I", "getTime", "getButtonText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CaseTimerInfo {
    private final String buttonText;
    private final int image;
    private final int time;

    public static /* synthetic */ CaseTimerInfo copy$default(CaseTimerInfo caseTimerInfo, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = caseTimerInfo.image;
        }
        if ((i3 & 2) != 0) {
            i2 = caseTimerInfo.time;
        }
        if ((i3 & 4) != 0) {
            str = caseTimerInfo.buttonText;
        }
        return caseTimerInfo.copy(i, i2, str);
    }

    public final int component1() {
        return this.image;
    }

    public final int component2() {
        return this.time;
    }

    public final String component3() {
        return this.buttonText;
    }

    public final CaseTimerInfo copy(int i, int i2, String buttonText) {
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        return new CaseTimerInfo(i, i2, buttonText);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CaseTimerInfo) {
            CaseTimerInfo caseTimerInfo = (CaseTimerInfo) obj;
            return this.image == caseTimerInfo.image && this.time == caseTimerInfo.time && Intrinsics.areEqual(this.buttonText, caseTimerInfo.buttonText);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.image) * 31) + Integer.hashCode(this.time)) * 31) + this.buttonText.hashCode();
    }

    public String toString() {
        int i = this.image;
        int i2 = this.time;
        return "CaseTimerInfo(image=" + i + ", time=" + i2 + ", buttonText=" + this.buttonText + ")";
    }

    public CaseTimerInfo(int i, int i2, String buttonText) {
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        this.image = i;
        this.time = i2;
        this.buttonText = buttonText;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getTime() {
        return this.time;
    }

    public final String getButtonText() {
        return this.buttonText;
    }
}
