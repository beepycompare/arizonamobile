package ru.mrlargha.commonui.elements.dialogs;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InfoDialogAnimatedBar.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/InfoDialogAnimatedBar;", "", Constants.ScionAnalytics.PARAM_LABEL, "", "durationMs", "", "<init>", "(Ljava/lang/String;J)V", "getLabel", "()Ljava/lang/String;", "getDurationMs", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InfoDialogAnimatedBar {
    private final long durationMs;
    private final String label;

    public static /* synthetic */ InfoDialogAnimatedBar copy$default(InfoDialogAnimatedBar infoDialogAnimatedBar, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = infoDialogAnimatedBar.label;
        }
        if ((i & 2) != 0) {
            j = infoDialogAnimatedBar.durationMs;
        }
        return infoDialogAnimatedBar.copy(str, j);
    }

    public final String component1() {
        return this.label;
    }

    public final long component2() {
        return this.durationMs;
    }

    public final InfoDialogAnimatedBar copy(String label, long j) {
        Intrinsics.checkNotNullParameter(label, "label");
        return new InfoDialogAnimatedBar(label, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InfoDialogAnimatedBar) {
            InfoDialogAnimatedBar infoDialogAnimatedBar = (InfoDialogAnimatedBar) obj;
            return Intrinsics.areEqual(this.label, infoDialogAnimatedBar.label) && this.durationMs == infoDialogAnimatedBar.durationMs;
        }
        return false;
    }

    public int hashCode() {
        return (this.label.hashCode() * 31) + Long.hashCode(this.durationMs);
    }

    public String toString() {
        String str = this.label;
        return "InfoDialogAnimatedBar(label=" + str + ", durationMs=" + this.durationMs + ")";
    }

    public InfoDialogAnimatedBar(String label, long j) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        this.durationMs = j;
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }
}
