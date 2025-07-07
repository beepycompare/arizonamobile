package ru.mrlargha.commonui.elements;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UniversalAction.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/UniversalAction;", "", "progress", "", "text", "", "<init>", "(ILjava/lang/String;)V", "getProgress", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UniversalAction {
    private final int progress;
    private final String text;

    public static /* synthetic */ UniversalAction copy$default(UniversalAction universalAction, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = universalAction.progress;
        }
        if ((i2 & 2) != 0) {
            str = universalAction.text;
        }
        return universalAction.copy(i, str);
    }

    public final int component1() {
        return this.progress;
    }

    public final String component2() {
        return this.text;
    }

    public final UniversalAction copy(int i, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new UniversalAction(i, text);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UniversalAction) {
            UniversalAction universalAction = (UniversalAction) obj;
            return this.progress == universalAction.progress && Intrinsics.areEqual(this.text, universalAction.text);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.progress) * 31) + this.text.hashCode();
    }

    public String toString() {
        int i = this.progress;
        return "UniversalAction(progress=" + i + ", text=" + this.text + ")";
    }

    public UniversalAction(int i, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.progress = i;
        this.text = text;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final String getText() {
        return this.text;
    }
}
