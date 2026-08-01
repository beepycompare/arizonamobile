package ru.mrlargha.commonui.elements.dialogs;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogListItemTabs.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/ResolvedInfoDialogContent;", "", "header", "", TtmlNode.TAG_BODY, "primaryButton", "secondaryButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHeader", "()Ljava/lang/String;", "getBody", "getPrimaryButton", "getSecondaryButton", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ResolvedInfoDialogContent {
    private final String body;
    private final String header;
    private final String primaryButton;
    private final String secondaryButton;

    public static /* synthetic */ ResolvedInfoDialogContent copy$default(ResolvedInfoDialogContent resolvedInfoDialogContent, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resolvedInfoDialogContent.header;
        }
        if ((i & 2) != 0) {
            str2 = resolvedInfoDialogContent.body;
        }
        if ((i & 4) != 0) {
            str3 = resolvedInfoDialogContent.primaryButton;
        }
        if ((i & 8) != 0) {
            str4 = resolvedInfoDialogContent.secondaryButton;
        }
        return resolvedInfoDialogContent.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.header;
    }

    public final String component2() {
        return this.body;
    }

    public final String component3() {
        return this.primaryButton;
    }

    public final String component4() {
        return this.secondaryButton;
    }

    public final ResolvedInfoDialogContent copy(String header, String body, String primaryButton, String secondaryButton) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(primaryButton, "primaryButton");
        Intrinsics.checkNotNullParameter(secondaryButton, "secondaryButton");
        return new ResolvedInfoDialogContent(header, body, primaryButton, secondaryButton);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResolvedInfoDialogContent) {
            ResolvedInfoDialogContent resolvedInfoDialogContent = (ResolvedInfoDialogContent) obj;
            return Intrinsics.areEqual(this.header, resolvedInfoDialogContent.header) && Intrinsics.areEqual(this.body, resolvedInfoDialogContent.body) && Intrinsics.areEqual(this.primaryButton, resolvedInfoDialogContent.primaryButton) && Intrinsics.areEqual(this.secondaryButton, resolvedInfoDialogContent.secondaryButton);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.header.hashCode() * 31) + this.body.hashCode()) * 31) + this.primaryButton.hashCode()) * 31) + this.secondaryButton.hashCode();
    }

    public String toString() {
        String str = this.header;
        String str2 = this.body;
        String str3 = this.primaryButton;
        return "ResolvedInfoDialogContent(header=" + str + ", body=" + str2 + ", primaryButton=" + str3 + ", secondaryButton=" + this.secondaryButton + ")";
    }

    public ResolvedInfoDialogContent(String header, String body, String primaryButton, String secondaryButton) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(primaryButton, "primaryButton");
        Intrinsics.checkNotNullParameter(secondaryButton, "secondaryButton");
        this.header = header;
        this.body = body;
        this.primaryButton = primaryButton;
        this.secondaryButton = secondaryButton;
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
}
