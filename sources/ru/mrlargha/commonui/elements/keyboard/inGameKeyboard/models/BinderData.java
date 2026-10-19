package ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.models;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.common.ui.BinderButtonType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BinderData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/models/BinderData;", "", TtmlNode.ATTR_ID, "", "binderName", "", "binderType", "Lcom/arizona/common/ui/BinderButtonType;", "<init>", "(ILjava/lang/String;Lcom/arizona/common/ui/BinderButtonType;)V", "getId", "()I", "getBinderName", "()Ljava/lang/String;", "setBinderName", "(Ljava/lang/String;)V", "getBinderType", "()Lcom/arizona/common/ui/BinderButtonType;", "setBinderType", "(Lcom/arizona/common/ui/BinderButtonType;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BinderData {
    private String binderName;
    private BinderButtonType binderType;
    private final int id;

    public static /* synthetic */ BinderData copy$default(BinderData binderData, int i, String str, BinderButtonType binderButtonType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = binderData.id;
        }
        if ((i2 & 2) != 0) {
            str = binderData.binderName;
        }
        if ((i2 & 4) != 0) {
            binderButtonType = binderData.binderType;
        }
        return binderData.copy(i, str, binderButtonType);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.binderName;
    }

    public final BinderButtonType component3() {
        return this.binderType;
    }

    public final BinderData copy(int i, String binderName, BinderButtonType binderType) {
        Intrinsics.checkNotNullParameter(binderName, "binderName");
        Intrinsics.checkNotNullParameter(binderType, "binderType");
        return new BinderData(i, binderName, binderType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BinderData) {
            BinderData binderData = (BinderData) obj;
            return this.id == binderData.id && Intrinsics.areEqual(this.binderName, binderData.binderName) && this.binderType == binderData.binderType;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.binderName.hashCode()) * 31) + this.binderType.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.binderName;
        return "BinderData(id=" + i + ", binderName=" + str + ", binderType=" + this.binderType + ")";
    }

    public BinderData(int i, String binderName, BinderButtonType binderType) {
        Intrinsics.checkNotNullParameter(binderName, "binderName");
        Intrinsics.checkNotNullParameter(binderType, "binderType");
        this.id = i;
        this.binderName = binderName;
        this.binderType = binderType;
    }

    public final int getId() {
        return this.id;
    }

    public final String getBinderName() {
        return this.binderName;
    }

    public final void setBinderName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.binderName = str;
    }

    public final BinderButtonType getBinderType() {
        return this.binderType;
    }

    public final void setBinderType(BinderButtonType binderButtonType) {
        Intrinsics.checkNotNullParameter(binderButtonType, "<set-?>");
        this.binderType = binderButtonType;
    }
}
