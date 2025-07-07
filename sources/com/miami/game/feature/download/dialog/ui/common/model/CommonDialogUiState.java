package com.miami.game.feature.download.dialog.ui.common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CommonDialogUiState.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;", "", "isProgress", "", "isPrivacyAccepted", "descriptionText", "", "policyLink", "termsLink", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getDescriptionText", "()Ljava/lang/String;", "getPolicyLink", "getTermsLink", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "dialogs_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CommonDialogUiState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String descriptionText;
    private final boolean isPrivacyAccepted;
    private final boolean isProgress;
    private final String policyLink;
    private final String termsLink;

    public static /* synthetic */ CommonDialogUiState copy$default(CommonDialogUiState commonDialogUiState, boolean z, boolean z2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = commonDialogUiState.isProgress;
        }
        if ((i & 2) != 0) {
            z2 = commonDialogUiState.isPrivacyAccepted;
        }
        if ((i & 4) != 0) {
            str = commonDialogUiState.descriptionText;
        }
        if ((i & 8) != 0) {
            str2 = commonDialogUiState.policyLink;
        }
        if ((i & 16) != 0) {
            str3 = commonDialogUiState.termsLink;
        }
        String str4 = str3;
        String str5 = str;
        return commonDialogUiState.copy(z, z2, str5, str2, str4);
    }

    public final boolean component1() {
        return this.isProgress;
    }

    public final boolean component2() {
        return this.isPrivacyAccepted;
    }

    public final String component3() {
        return this.descriptionText;
    }

    public final String component4() {
        return this.policyLink;
    }

    public final String component5() {
        return this.termsLink;
    }

    public final CommonDialogUiState copy(boolean z, boolean z2, String descriptionText, String policyLink, String termsLink) {
        Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
        Intrinsics.checkNotNullParameter(policyLink, "policyLink");
        Intrinsics.checkNotNullParameter(termsLink, "termsLink");
        return new CommonDialogUiState(z, z2, descriptionText, policyLink, termsLink);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommonDialogUiState) {
            CommonDialogUiState commonDialogUiState = (CommonDialogUiState) obj;
            return this.isProgress == commonDialogUiState.isProgress && this.isPrivacyAccepted == commonDialogUiState.isPrivacyAccepted && Intrinsics.areEqual(this.descriptionText, commonDialogUiState.descriptionText) && Intrinsics.areEqual(this.policyLink, commonDialogUiState.policyLink) && Intrinsics.areEqual(this.termsLink, commonDialogUiState.termsLink);
        }
        return false;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.isProgress) * 31) + Boolean.hashCode(this.isPrivacyAccepted)) * 31) + this.descriptionText.hashCode()) * 31) + this.policyLink.hashCode()) * 31) + this.termsLink.hashCode();
    }

    public String toString() {
        boolean z = this.isProgress;
        boolean z2 = this.isPrivacyAccepted;
        String str = this.descriptionText;
        String str2 = this.policyLink;
        return "CommonDialogUiState(isProgress=" + z + ", isPrivacyAccepted=" + z2 + ", descriptionText=" + str + ", policyLink=" + str2 + ", termsLink=" + this.termsLink + ")";
    }

    public CommonDialogUiState(boolean z, boolean z2, String descriptionText, String policyLink, String termsLink) {
        Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
        Intrinsics.checkNotNullParameter(policyLink, "policyLink");
        Intrinsics.checkNotNullParameter(termsLink, "termsLink");
        this.isProgress = z;
        this.isPrivacyAccepted = z2;
        this.descriptionText = descriptionText;
        this.policyLink = policyLink;
        this.termsLink = termsLink;
    }

    public final boolean isProgress() {
        return this.isProgress;
    }

    public final boolean isPrivacyAccepted() {
        return this.isPrivacyAccepted;
    }

    public /* synthetic */ CommonDialogUiState(boolean z, boolean z2, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? "" : str, str2, str3);
    }

    public final String getDescriptionText() {
        return this.descriptionText;
    }

    public final String getPolicyLink() {
        return this.policyLink;
    }

    public final String getTermsLink() {
        return this.termsLink;
    }

    /* compiled from: CommonDialogUiState.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/download/dialog/ui/common/model/CommonDialogUiState;", "isArizona", "", "descriptionText", "", "dialogs_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CommonDialogUiState initial(boolean z, String descriptionText) {
            Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
            return new CommonDialogUiState(false, false, descriptionText, z ? "https://arizona-rp.com/document/policy" : "https://rodina-rp.com/policy", z ? "https://arizona-rp.com/document/terms" : "https://rodina-rp.com/terms", 3, null);
        }
    }
}
