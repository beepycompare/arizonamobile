package ru.mrlargha.commonui.elements.dialogs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InfoDialogAnimatedBar.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/InfoDialogAnimatedBarContent;", "", "text", "", "animatedBar", "Lru/mrlargha/commonui/elements/dialogs/InfoDialogAnimatedBar;", "<init>", "(Ljava/lang/String;Lru/mrlargha/commonui/elements/dialogs/InfoDialogAnimatedBar;)V", "getText", "()Ljava/lang/String;", "getAnimatedBar", "()Lru/mrlargha/commonui/elements/dialogs/InfoDialogAnimatedBar;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InfoDialogAnimatedBarContent {
    private final InfoDialogAnimatedBar animatedBar;
    private final String text;

    public static /* synthetic */ InfoDialogAnimatedBarContent copy$default(InfoDialogAnimatedBarContent infoDialogAnimatedBarContent, String str, InfoDialogAnimatedBar infoDialogAnimatedBar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = infoDialogAnimatedBarContent.text;
        }
        if ((i & 2) != 0) {
            infoDialogAnimatedBar = infoDialogAnimatedBarContent.animatedBar;
        }
        return infoDialogAnimatedBarContent.copy(str, infoDialogAnimatedBar);
    }

    public final String component1() {
        return this.text;
    }

    public final InfoDialogAnimatedBar component2() {
        return this.animatedBar;
    }

    public final InfoDialogAnimatedBarContent copy(String text, InfoDialogAnimatedBar infoDialogAnimatedBar) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new InfoDialogAnimatedBarContent(text, infoDialogAnimatedBar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InfoDialogAnimatedBarContent) {
            InfoDialogAnimatedBarContent infoDialogAnimatedBarContent = (InfoDialogAnimatedBarContent) obj;
            return Intrinsics.areEqual(this.text, infoDialogAnimatedBarContent.text) && Intrinsics.areEqual(this.animatedBar, infoDialogAnimatedBarContent.animatedBar);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.text.hashCode() * 31;
        InfoDialogAnimatedBar infoDialogAnimatedBar = this.animatedBar;
        return hashCode + (infoDialogAnimatedBar == null ? 0 : infoDialogAnimatedBar.hashCode());
    }

    public String toString() {
        String str = this.text;
        return "InfoDialogAnimatedBarContent(text=" + str + ", animatedBar=" + this.animatedBar + ")";
    }

    public InfoDialogAnimatedBarContent(String text, InfoDialogAnimatedBar infoDialogAnimatedBar) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.animatedBar = infoDialogAnimatedBar;
    }

    public final String getText() {
        return this.text;
    }

    public final InfoDialogAnimatedBar getAnimatedBar() {
        return this.animatedBar;
    }
}
