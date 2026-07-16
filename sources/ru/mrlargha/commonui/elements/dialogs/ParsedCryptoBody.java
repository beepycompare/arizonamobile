package ru.mrlargha.commonui.elements.dialogs;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogBuyCrypto.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/ParsedCryptoBody;", "", "framedText", "", "bodyText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFramedText", "()Ljava/lang/String;", "getBodyText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final class ParsedCryptoBody {
    private final String bodyText;
    private final String framedText;

    public ParsedCryptoBody() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ ParsedCryptoBody copy$default(ParsedCryptoBody parsedCryptoBody, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parsedCryptoBody.framedText;
        }
        if ((i & 2) != 0) {
            str2 = parsedCryptoBody.bodyText;
        }
        return parsedCryptoBody.copy(str, str2);
    }

    public final String component1() {
        return this.framedText;
    }

    public final String component2() {
        return this.bodyText;
    }

    public final ParsedCryptoBody copy(String framedText, String bodyText) {
        Intrinsics.checkNotNullParameter(framedText, "framedText");
        Intrinsics.checkNotNullParameter(bodyText, "bodyText");
        return new ParsedCryptoBody(framedText, bodyText);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParsedCryptoBody) {
            ParsedCryptoBody parsedCryptoBody = (ParsedCryptoBody) obj;
            return Intrinsics.areEqual(this.framedText, parsedCryptoBody.framedText) && Intrinsics.areEqual(this.bodyText, parsedCryptoBody.bodyText);
        }
        return false;
    }

    public int hashCode() {
        return (this.framedText.hashCode() * 31) + this.bodyText.hashCode();
    }

    public String toString() {
        String str = this.framedText;
        return "ParsedCryptoBody(framedText=" + str + ", bodyText=" + this.bodyText + ")";
    }

    public ParsedCryptoBody(String framedText, String bodyText) {
        Intrinsics.checkNotNullParameter(framedText, "framedText");
        Intrinsics.checkNotNullParameter(bodyText, "bodyText");
        this.framedText = framedText;
        this.bodyText = bodyText;
    }

    public /* synthetic */ ParsedCryptoBody(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getFramedText() {
        return this.framedText;
    }

    public final String getBodyText() {
        return this.bodyText;
    }
}
