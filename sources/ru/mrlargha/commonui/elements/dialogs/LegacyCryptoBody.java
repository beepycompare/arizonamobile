package ru.mrlargha.commonui.elements.dialogs;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogBuyCrypto.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/LegacyCryptoBody;", "", "headerInfo", "Lru/mrlargha/commonui/elements/dialogs/DialogBuyCryptoHeaderInfo;", TtmlNode.TAG_BODY, "", "<init>", "(Lru/mrlargha/commonui/elements/dialogs/DialogBuyCryptoHeaderInfo;Ljava/lang/String;)V", "getHeaderInfo", "()Lru/mrlargha/commonui/elements/dialogs/DialogBuyCryptoHeaderInfo;", "getBody", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final class LegacyCryptoBody {
    private final String body;
    private final DialogBuyCryptoHeaderInfo headerInfo;

    public LegacyCryptoBody() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ LegacyCryptoBody copy$default(LegacyCryptoBody legacyCryptoBody, DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            dialogBuyCryptoHeaderInfo = legacyCryptoBody.headerInfo;
        }
        if ((i & 2) != 0) {
            str = legacyCryptoBody.body;
        }
        return legacyCryptoBody.copy(dialogBuyCryptoHeaderInfo, str);
    }

    public final DialogBuyCryptoHeaderInfo component1() {
        return this.headerInfo;
    }

    public final String component2() {
        return this.body;
    }

    public final LegacyCryptoBody copy(DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo, String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new LegacyCryptoBody(dialogBuyCryptoHeaderInfo, body);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LegacyCryptoBody) {
            LegacyCryptoBody legacyCryptoBody = (LegacyCryptoBody) obj;
            return Intrinsics.areEqual(this.headerInfo, legacyCryptoBody.headerInfo) && Intrinsics.areEqual(this.body, legacyCryptoBody.body);
        }
        return false;
    }

    public int hashCode() {
        DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo = this.headerInfo;
        return ((dialogBuyCryptoHeaderInfo == null ? 0 : dialogBuyCryptoHeaderInfo.hashCode()) * 31) + this.body.hashCode();
    }

    public String toString() {
        DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo = this.headerInfo;
        return "LegacyCryptoBody(headerInfo=" + dialogBuyCryptoHeaderInfo + ", body=" + this.body + ")";
    }

    public LegacyCryptoBody(DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo, String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.headerInfo = dialogBuyCryptoHeaderInfo;
        this.body = body;
    }

    public final DialogBuyCryptoHeaderInfo getHeaderInfo() {
        return this.headerInfo;
    }

    public /* synthetic */ LegacyCryptoBody(DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dialogBuyCryptoHeaderInfo, (i & 2) != 0 ? "" : str);
    }

    public final String getBody() {
        return this.body;
    }
}
