package ru.mrlargha.commonui.elements.dialogs;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogSign.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogSignModel;", "", "text", "", "value", "", "color", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "getValue", "()I", "getColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogSignModel {
    private final String color;
    private final String text;
    private final int value;

    public DialogSignModel() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ DialogSignModel copy$default(DialogSignModel dialogSignModel, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = dialogSignModel.text;
        }
        if ((i2 & 2) != 0) {
            i = dialogSignModel.value;
        }
        if ((i2 & 4) != 0) {
            str2 = dialogSignModel.color;
        }
        return dialogSignModel.copy(str, i, str2);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.value;
    }

    public final String component3() {
        return this.color;
    }

    public final DialogSignModel copy(String text, int i, String str) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new DialogSignModel(text, i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogSignModel) {
            DialogSignModel dialogSignModel = (DialogSignModel) obj;
            return Intrinsics.areEqual(this.text, dialogSignModel.text) && this.value == dialogSignModel.value && Intrinsics.areEqual(this.color, dialogSignModel.color);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + Integer.hashCode(this.value)) * 31;
        String str = this.color;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.text;
        int i = this.value;
        return "DialogSignModel(text=" + str + ", value=" + i + ", color=" + this.color + ")";
    }

    public DialogSignModel(String text, int i, String str) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.value = i;
        this.color = str;
    }

    public /* synthetic */ DialogSignModel(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : str2);
    }

    public final String getText() {
        return this.text;
    }

    public final int getValue() {
        return this.value;
    }

    public final String getColor() {
        return this.color;
    }
}
