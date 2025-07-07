package ru.mrlargha.arizonaui.documents.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DocumentsData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lru/mrlargha/arizonaui/documents/data/PremiumLevel;", "", "mark", "", "desc", "", "text", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getMark", "()I", "getDesc", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PremiumLevel {
    private final String desc;
    private final int mark;
    private final String text;

    public static /* synthetic */ PremiumLevel copy$default(PremiumLevel premiumLevel, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = premiumLevel.mark;
        }
        if ((i2 & 2) != 0) {
            str = premiumLevel.desc;
        }
        if ((i2 & 4) != 0) {
            str2 = premiumLevel.text;
        }
        return premiumLevel.copy(i, str, str2);
    }

    public final int component1() {
        return this.mark;
    }

    public final String component2() {
        return this.desc;
    }

    public final String component3() {
        return this.text;
    }

    public final PremiumLevel copy(int i, String desc, String text) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(text, "text");
        return new PremiumLevel(i, desc, text);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PremiumLevel) {
            PremiumLevel premiumLevel = (PremiumLevel) obj;
            return this.mark == premiumLevel.mark && Intrinsics.areEqual(this.desc, premiumLevel.desc) && Intrinsics.areEqual(this.text, premiumLevel.text);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.mark) * 31) + this.desc.hashCode()) * 31) + this.text.hashCode();
    }

    public String toString() {
        int i = this.mark;
        String str = this.desc;
        return "PremiumLevel(mark=" + i + ", desc=" + str + ", text=" + this.text + ")";
    }

    public PremiumLevel(int i, String desc, String text) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(text, "text");
        this.mark = i;
        this.desc = desc;
        this.text = text;
    }

    public final int getMark() {
        return this.mark;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getText() {
        return this.text;
    }
}
