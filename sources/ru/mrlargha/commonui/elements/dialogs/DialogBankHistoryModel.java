package ru.mrlargha.commonui.elements.dialogs;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogBankHistory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankHistoryModel;", "", "type", "", "header", "", "addType", TtmlNode.TAG_BODY, "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "getType", "()I", "getHeader", "()Ljava/lang/String;", "getAddType", "getBody", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBankHistoryModel {
    private final int addType;
    private final String body;
    private final String header;
    private final int type;

    public DialogBankHistoryModel() {
        this(0, null, 0, null, 15, null);
    }

    public static /* synthetic */ DialogBankHistoryModel copy$default(DialogBankHistoryModel dialogBankHistoryModel, int i, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = dialogBankHistoryModel.type;
        }
        if ((i3 & 2) != 0) {
            str = dialogBankHistoryModel.header;
        }
        if ((i3 & 4) != 0) {
            i2 = dialogBankHistoryModel.addType;
        }
        if ((i3 & 8) != 0) {
            str2 = dialogBankHistoryModel.body;
        }
        return dialogBankHistoryModel.copy(i, str, i2, str2);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.header;
    }

    public final int component3() {
        return this.addType;
    }

    public final String component4() {
        return this.body;
    }

    public final DialogBankHistoryModel copy(int i, String header, int i2, String body) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(body, "body");
        return new DialogBankHistoryModel(i, header, i2, body);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogBankHistoryModel) {
            DialogBankHistoryModel dialogBankHistoryModel = (DialogBankHistoryModel) obj;
            return this.type == dialogBankHistoryModel.type && Intrinsics.areEqual(this.header, dialogBankHistoryModel.header) && this.addType == dialogBankHistoryModel.addType && Intrinsics.areEqual(this.body, dialogBankHistoryModel.body);
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.type) * 31) + this.header.hashCode()) * 31) + Integer.hashCode(this.addType)) * 31) + this.body.hashCode();
    }

    public String toString() {
        int i = this.type;
        String str = this.header;
        int i2 = this.addType;
        return "DialogBankHistoryModel(type=" + i + ", header=" + str + ", addType=" + i2 + ", body=" + this.body + ")";
    }

    public DialogBankHistoryModel(int i, String header, int i2, String body) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(body, "body");
        this.type = i;
        this.header = header;
        this.addType = i2;
        this.body = body;
    }

    public /* synthetic */ DialogBankHistoryModel(int i, String str, int i2, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 10 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? "" : str2);
    }

    public final int getType() {
        return this.type;
    }

    public final String getHeader() {
        return this.header;
    }

    public final int getAddType() {
        return this.addType;
    }

    public final String getBody() {
        return this.body;
    }
}
