package ru.mrlargha.commonui.utils.emoji;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RichTextColorBoxSpan.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/utils/emoji/RichTextColorBox;", "", "hex", "", Constants.ScionAnalytics.PARAM_LABEL, "useDarkText", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getHex", "()Ljava/lang/String;", "getLabel", "getUseDarkText", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RichTextColorBox {
    private final String hex;
    private final String label;
    private final boolean useDarkText;

    public static /* synthetic */ RichTextColorBox copy$default(RichTextColorBox richTextColorBox, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = richTextColorBox.hex;
        }
        if ((i & 2) != 0) {
            str2 = richTextColorBox.label;
        }
        if ((i & 4) != 0) {
            z = richTextColorBox.useDarkText;
        }
        return richTextColorBox.copy(str, str2, z);
    }

    public final String component1() {
        return this.hex;
    }

    public final String component2() {
        return this.label;
    }

    public final boolean component3() {
        return this.useDarkText;
    }

    public final RichTextColorBox copy(String hex, String label, boolean z) {
        Intrinsics.checkNotNullParameter(hex, "hex");
        Intrinsics.checkNotNullParameter(label, "label");
        return new RichTextColorBox(hex, label, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RichTextColorBox) {
            RichTextColorBox richTextColorBox = (RichTextColorBox) obj;
            return Intrinsics.areEqual(this.hex, richTextColorBox.hex) && Intrinsics.areEqual(this.label, richTextColorBox.label) && this.useDarkText == richTextColorBox.useDarkText;
        }
        return false;
    }

    public int hashCode() {
        return (((this.hex.hashCode() * 31) + this.label.hashCode()) * 31) + Boolean.hashCode(this.useDarkText);
    }

    public String toString() {
        String str = this.hex;
        String str2 = this.label;
        return "RichTextColorBox(hex=" + str + ", label=" + str2 + ", useDarkText=" + this.useDarkText + ")";
    }

    public RichTextColorBox(String hex, String label, boolean z) {
        Intrinsics.checkNotNullParameter(hex, "hex");
        Intrinsics.checkNotNullParameter(label, "label");
        this.hex = hex;
        this.label = label;
        this.useDarkText = z;
    }

    public final String getHex() {
        return this.hex;
    }

    public final String getLabel() {
        return this.label;
    }

    public final boolean getUseDarkText() {
        return this.useDarkText;
    }
}
