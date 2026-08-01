package ru.mrlargha.commonui.elements.dialogs;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: DialogListItemTabs.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/InfoDialogPayload;", "", "type", "", "header", "", TtmlNode.TAG_BODY, "primaryButton", "secondaryButton", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getHeader", "()Ljava/lang/String;", "getBody", "getPrimaryButton", "getSecondaryButton", "hasStructuredContent", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final class InfoDialogPayload {
    private final String body;
    private final String header;
    private final String primaryButton;
    private final String secondaryButton;
    private final int type;

    public InfoDialogPayload() {
        this(0, null, null, null, null, 31, null);
    }

    public static /* synthetic */ InfoDialogPayload copy$default(InfoDialogPayload infoDialogPayload, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = infoDialogPayload.type;
        }
        if ((i2 & 2) != 0) {
            str = infoDialogPayload.header;
        }
        if ((i2 & 4) != 0) {
            str2 = infoDialogPayload.body;
        }
        if ((i2 & 8) != 0) {
            str3 = infoDialogPayload.primaryButton;
        }
        if ((i2 & 16) != 0) {
            str4 = infoDialogPayload.secondaryButton;
        }
        String str5 = str4;
        String str6 = str2;
        return infoDialogPayload.copy(i, str, str6, str3, str5);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.header;
    }

    public final String component3() {
        return this.body;
    }

    public final String component4() {
        return this.primaryButton;
    }

    public final String component5() {
        return this.secondaryButton;
    }

    public final InfoDialogPayload copy(int i, String header, String body, String primaryButton, String secondaryButton) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(primaryButton, "primaryButton");
        Intrinsics.checkNotNullParameter(secondaryButton, "secondaryButton");
        return new InfoDialogPayload(i, header, body, primaryButton, secondaryButton);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InfoDialogPayload) {
            InfoDialogPayload infoDialogPayload = (InfoDialogPayload) obj;
            return this.type == infoDialogPayload.type && Intrinsics.areEqual(this.header, infoDialogPayload.header) && Intrinsics.areEqual(this.body, infoDialogPayload.body) && Intrinsics.areEqual(this.primaryButton, infoDialogPayload.primaryButton) && Intrinsics.areEqual(this.secondaryButton, infoDialogPayload.secondaryButton);
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.type) * 31) + this.header.hashCode()) * 31) + this.body.hashCode()) * 31) + this.primaryButton.hashCode()) * 31) + this.secondaryButton.hashCode();
    }

    public String toString() {
        int i = this.type;
        String str = this.header;
        String str2 = this.body;
        String str3 = this.primaryButton;
        return "InfoDialogPayload(type=" + i + ", header=" + str + ", body=" + str2 + ", primaryButton=" + str3 + ", secondaryButton=" + this.secondaryButton + ")";
    }

    public InfoDialogPayload(int i, String header, String body, String primaryButton, String secondaryButton) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(primaryButton, "primaryButton");
        Intrinsics.checkNotNullParameter(secondaryButton, "secondaryButton");
        this.type = i;
        this.header = header;
        this.body = body;
        this.primaryButton = primaryButton;
        this.secondaryButton = secondaryButton;
    }

    public /* synthetic */ InfoDialogPayload(int i, String str, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        String str5;
        String str6;
        String str7;
        String str8;
        InfoDialogPayload infoDialogPayload;
        int i3;
        i = (i2 & 1) != 0 ? 0 : i;
        str = (i2 & 2) != 0 ? "" : str;
        str2 = (i2 & 4) != 0 ? "" : str2;
        str3 = (i2 & 8) != 0 ? "" : str3;
        if ((i2 & 16) != 0) {
            str5 = "";
            str8 = str2;
            str6 = str3;
            i3 = i;
            str7 = str;
            infoDialogPayload = this;
        } else {
            str5 = str4;
            str6 = str3;
            str7 = str;
            str8 = str2;
            infoDialogPayload = this;
            i3 = i;
        }
        new InfoDialogPayload(i3, str7, str8, str6, str5);
    }

    public final int getType() {
        return this.type;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getPrimaryButton() {
        return this.primaryButton;
    }

    public final String getSecondaryButton() {
        return this.secondaryButton;
    }

    public final boolean hasStructuredContent() {
        return (StringsKt.isBlank(this.header) && StringsKt.isBlank(this.body) && StringsKt.isBlank(this.primaryButton) && StringsKt.isBlank(this.secondaryButton)) ? false : true;
    }
}
