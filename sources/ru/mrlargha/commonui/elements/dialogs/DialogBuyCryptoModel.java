package ru.mrlargha.commonui.elements.dialogs;

import androidx.core.app.FrameMetricsAggregator;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogBuyCrypto.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jg\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0014\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00108\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00109\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015RQ\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u0092\u00028\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\t\u0012*\b\u001d\u0012&\b\fJ\u0004\b\b(\u001eJ\u0004\b\b(\u001fJ\u0004\b\b( J\u0004\b\b(!J\u0004\b\b(\"J\u0004\b\b(#¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR9\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u0092\u0002 \b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u000b\u0012\u0012\b\u001d\u0012\u000e\b\fJ\u0004\b\b(%J\u0004\b\b(&¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006:"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBuyCryptoModel;", "", "type", "", "header", "", "headerInfo", "Lru/mrlargha/commonui/elements/dialogs/DialogBuyCryptoHeaderInfo;", TtmlNode.TAG_BODY, "currencyRate", "", FirebaseAnalytics.Param.CURRENCY, "primaryButton", "secondaryButton", "limits", "Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;", "<init>", "(ILjava/lang/String;Lru/mrlargha/commonui/elements/dialogs/DialogBuyCryptoHeaderInfo;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;)V", "getType", "()I", "getHeader", "()Ljava/lang/String;", "getHeaderInfo", "()Lru/mrlargha/commonui/elements/dialogs/DialogBuyCryptoHeaderInfo;", "getBody", "getCurrencyRate", "()J", "Lcom/google/gson/annotations/SerializedName;", "value", "alternate", "currency_rate", "rate", "current", FirebaseAnalytics.Param.PRICE, "cost", "course", "getCurrency", "currencyId", "currency_id", "getPrimaryButton", "getSecondaryButton", "getLimits", "()Lru/mrlargha/commonui/elements/dialogs/DialogWithdrawLimitModel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBuyCryptoModel {
    private final String body;
    @SerializedName(alternate = {"currencyId", "currency_id"}, value = FirebaseAnalytics.Param.CURRENCY)
    private final String currency;
    @SerializedName(alternate = {"currency_rate", "rate", "current", FirebaseAnalytics.Param.PRICE, "cost", "course"}, value = "currencyRate")
    private final long currencyRate;
    private final String header;
    private final DialogBuyCryptoHeaderInfo headerInfo;
    private final DialogWithdrawLimitModel limits;
    private final String primaryButton;
    private final String secondaryButton;
    private final int type;

    public DialogBuyCryptoModel() {
        this(0, null, null, null, 0L, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public static /* synthetic */ DialogBuyCryptoModel copy$default(DialogBuyCryptoModel dialogBuyCryptoModel, int i, String str, DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo, String str2, long j, String str3, String str4, String str5, DialogWithdrawLimitModel dialogWithdrawLimitModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dialogBuyCryptoModel.type;
        }
        if ((i2 & 2) != 0) {
            str = dialogBuyCryptoModel.header;
        }
        if ((i2 & 4) != 0) {
            dialogBuyCryptoHeaderInfo = dialogBuyCryptoModel.headerInfo;
        }
        if ((i2 & 8) != 0) {
            str2 = dialogBuyCryptoModel.body;
        }
        if ((i2 & 16) != 0) {
            j = dialogBuyCryptoModel.currencyRate;
        }
        if ((i2 & 32) != 0) {
            str3 = dialogBuyCryptoModel.currency;
        }
        if ((i2 & 64) != 0) {
            str4 = dialogBuyCryptoModel.primaryButton;
        }
        if ((i2 & 128) != 0) {
            str5 = dialogBuyCryptoModel.secondaryButton;
        }
        if ((i2 & 256) != 0) {
            dialogWithdrawLimitModel = dialogBuyCryptoModel.limits;
        }
        long j2 = j;
        DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo2 = dialogBuyCryptoHeaderInfo;
        String str6 = str2;
        return dialogBuyCryptoModel.copy(i, str, dialogBuyCryptoHeaderInfo2, str6, j2, str3, str4, str5, dialogWithdrawLimitModel);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.header;
    }

    public final DialogBuyCryptoHeaderInfo component3() {
        return this.headerInfo;
    }

    public final String component4() {
        return this.body;
    }

    public final long component5() {
        return this.currencyRate;
    }

    public final String component6() {
        return this.currency;
    }

    public final String component7() {
        return this.primaryButton;
    }

    public final String component8() {
        return this.secondaryButton;
    }

    public final DialogWithdrawLimitModel component9() {
        return this.limits;
    }

    public final DialogBuyCryptoModel copy(int i, String header, DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo, String body, long j, String currency, String primaryButton, String secondaryButton, DialogWithdrawLimitModel dialogWithdrawLimitModel) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(primaryButton, "primaryButton");
        Intrinsics.checkNotNullParameter(secondaryButton, "secondaryButton");
        return new DialogBuyCryptoModel(i, header, dialogBuyCryptoHeaderInfo, body, j, currency, primaryButton, secondaryButton, dialogWithdrawLimitModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogBuyCryptoModel) {
            DialogBuyCryptoModel dialogBuyCryptoModel = (DialogBuyCryptoModel) obj;
            return this.type == dialogBuyCryptoModel.type && Intrinsics.areEqual(this.header, dialogBuyCryptoModel.header) && Intrinsics.areEqual(this.headerInfo, dialogBuyCryptoModel.headerInfo) && Intrinsics.areEqual(this.body, dialogBuyCryptoModel.body) && this.currencyRate == dialogBuyCryptoModel.currencyRate && Intrinsics.areEqual(this.currency, dialogBuyCryptoModel.currency) && Intrinsics.areEqual(this.primaryButton, dialogBuyCryptoModel.primaryButton) && Intrinsics.areEqual(this.secondaryButton, dialogBuyCryptoModel.secondaryButton) && Intrinsics.areEqual(this.limits, dialogBuyCryptoModel.limits);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.type) * 31) + this.header.hashCode()) * 31;
        DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo = this.headerInfo;
        int hashCode2 = (((((((((((hashCode + (dialogBuyCryptoHeaderInfo == null ? 0 : dialogBuyCryptoHeaderInfo.hashCode())) * 31) + this.body.hashCode()) * 31) + Long.hashCode(this.currencyRate)) * 31) + this.currency.hashCode()) * 31) + this.primaryButton.hashCode()) * 31) + this.secondaryButton.hashCode()) * 31;
        DialogWithdrawLimitModel dialogWithdrawLimitModel = this.limits;
        return hashCode2 + (dialogWithdrawLimitModel != null ? dialogWithdrawLimitModel.hashCode() : 0);
    }

    public String toString() {
        int i = this.type;
        String str = this.header;
        DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo = this.headerInfo;
        String str2 = this.body;
        long j = this.currencyRate;
        String str3 = this.currency;
        String str4 = this.primaryButton;
        String str5 = this.secondaryButton;
        return "DialogBuyCryptoModel(type=" + i + ", header=" + str + ", headerInfo=" + dialogBuyCryptoHeaderInfo + ", body=" + str2 + ", currencyRate=" + j + ", currency=" + str3 + ", primaryButton=" + str4 + ", secondaryButton=" + str5 + ", limits=" + this.limits + ")";
    }

    public DialogBuyCryptoModel(int i, String header, DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo, String body, long j, String currency, String primaryButton, String secondaryButton, DialogWithdrawLimitModel dialogWithdrawLimitModel) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(primaryButton, "primaryButton");
        Intrinsics.checkNotNullParameter(secondaryButton, "secondaryButton");
        this.type = i;
        this.header = header;
        this.headerInfo = dialogBuyCryptoHeaderInfo;
        this.body = body;
        this.currencyRate = j;
        this.currency = currency;
        this.primaryButton = primaryButton;
        this.secondaryButton = secondaryButton;
        this.limits = dialogWithdrawLimitModel;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DialogBuyCryptoModel(int i, String str, DialogBuyCryptoHeaderInfo dialogBuyCryptoHeaderInfo, String str2, long j, String str3, String str4, String str5, DialogWithdrawLimitModel dialogWithdrawLimitModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, dialogBuyCryptoHeaderInfo, str2, j, r11, r12, r13, r14);
        DialogWithdrawLimitModel dialogWithdrawLimitModel2;
        String str6;
        String str7;
        String str8;
        i = (i2 & 1) != 0 ? 8 : i;
        str = (i2 & 2) != 0 ? "" : str;
        dialogBuyCryptoHeaderInfo = (i2 & 4) != 0 ? null : dialogBuyCryptoHeaderInfo;
        str2 = (i2 & 8) != 0 ? "" : str2;
        j = (i2 & 16) != 0 ? 0L : j;
        str3 = (i2 & 32) != 0 ? "" : str3;
        str4 = (i2 & 64) != 0 ? "" : str4;
        str5 = (i2 & 128) != 0 ? "" : str5;
        if ((i2 & 256) != 0) {
            dialogWithdrawLimitModel2 = null;
            str8 = str4;
            str6 = str5;
            str7 = str3;
        } else {
            dialogWithdrawLimitModel2 = dialogWithdrawLimitModel;
            str6 = str5;
            str7 = str3;
            str8 = str4;
        }
    }

    public final int getType() {
        return this.type;
    }

    public final String getHeader() {
        return this.header;
    }

    public final DialogBuyCryptoHeaderInfo getHeaderInfo() {
        return this.headerInfo;
    }

    public final String getBody() {
        return this.body;
    }

    public final long getCurrencyRate() {
        return this.currencyRate;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getPrimaryButton() {
        return this.primaryButton;
    }

    public final String getSecondaryButton() {
        return this.secondaryButton;
    }

    public final DialogWithdrawLimitModel getLimits() {
        return this.limits;
    }
}
