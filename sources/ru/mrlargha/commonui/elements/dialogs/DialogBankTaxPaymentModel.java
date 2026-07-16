package ru.mrlargha.commonui.elements.dialogs;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DialogBankTaxPayment.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006&"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentModel;", "", "type", "", "header", "", "addType", "taxList", "", "Lru/mrlargha/commonui/elements/dialogs/DialogBankTaxPaymentInfo;", TtmlNode.TAG_BODY, "primaryButton", "additionalInfo", "<init>", "(ILjava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getHeader", "()Ljava/lang/String;", "getAddType", "getTaxList", "()Ljava/util/List;", "getBody", "getPrimaryButton", "getAdditionalInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DialogBankTaxPaymentModel {
    private final int addType;
    private final String additionalInfo;
    private final String body;
    private final String header;
    private final String primaryButton;
    private final List<DialogBankTaxPaymentInfo> taxList;
    private final int type;

    public DialogBankTaxPaymentModel() {
        this(0, null, 0, null, null, null, null, 127, null);
    }

    public static /* synthetic */ DialogBankTaxPaymentModel copy$default(DialogBankTaxPaymentModel dialogBankTaxPaymentModel, int i, String str, int i2, List list, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = dialogBankTaxPaymentModel.type;
        }
        if ((i3 & 2) != 0) {
            str = dialogBankTaxPaymentModel.header;
        }
        if ((i3 & 4) != 0) {
            i2 = dialogBankTaxPaymentModel.addType;
        }
        List<DialogBankTaxPaymentInfo> list2 = list;
        if ((i3 & 8) != 0) {
            list2 = dialogBankTaxPaymentModel.taxList;
        }
        if ((i3 & 16) != 0) {
            str2 = dialogBankTaxPaymentModel.body;
        }
        if ((i3 & 32) != 0) {
            str3 = dialogBankTaxPaymentModel.primaryButton;
        }
        if ((i3 & 64) != 0) {
            str4 = dialogBankTaxPaymentModel.additionalInfo;
        }
        String str5 = str3;
        String str6 = str4;
        String str7 = str2;
        int i4 = i2;
        return dialogBankTaxPaymentModel.copy(i, str, i4, list2, str7, str5, str6);
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

    public final List<DialogBankTaxPaymentInfo> component4() {
        return this.taxList;
    }

    public final String component5() {
        return this.body;
    }

    public final String component6() {
        return this.primaryButton;
    }

    public final String component7() {
        return this.additionalInfo;
    }

    public final DialogBankTaxPaymentModel copy(int i, String header, int i2, List<DialogBankTaxPaymentInfo> taxList, String body, String primaryButton, String additionalInfo) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(taxList, "taxList");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(primaryButton, "primaryButton");
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        return new DialogBankTaxPaymentModel(i, header, i2, taxList, body, primaryButton, additionalInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DialogBankTaxPaymentModel) {
            DialogBankTaxPaymentModel dialogBankTaxPaymentModel = (DialogBankTaxPaymentModel) obj;
            return this.type == dialogBankTaxPaymentModel.type && Intrinsics.areEqual(this.header, dialogBankTaxPaymentModel.header) && this.addType == dialogBankTaxPaymentModel.addType && Intrinsics.areEqual(this.taxList, dialogBankTaxPaymentModel.taxList) && Intrinsics.areEqual(this.body, dialogBankTaxPaymentModel.body) && Intrinsics.areEqual(this.primaryButton, dialogBankTaxPaymentModel.primaryButton) && Intrinsics.areEqual(this.additionalInfo, dialogBankTaxPaymentModel.additionalInfo);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.type) * 31) + this.header.hashCode()) * 31) + Integer.hashCode(this.addType)) * 31) + this.taxList.hashCode()) * 31) + this.body.hashCode()) * 31) + this.primaryButton.hashCode()) * 31) + this.additionalInfo.hashCode();
    }

    public String toString() {
        int i = this.type;
        String str = this.header;
        int i2 = this.addType;
        List<DialogBankTaxPaymentInfo> list = this.taxList;
        String str2 = this.body;
        String str3 = this.primaryButton;
        return "DialogBankTaxPaymentModel(type=" + i + ", header=" + str + ", addType=" + i2 + ", taxList=" + list + ", body=" + str2 + ", primaryButton=" + str3 + ", additionalInfo=" + this.additionalInfo + ")";
    }

    public DialogBankTaxPaymentModel(int i, String header, int i2, List<DialogBankTaxPaymentInfo> taxList, String body, String primaryButton, String additionalInfo) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(taxList, "taxList");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(primaryButton, "primaryButton");
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        this.type = i;
        this.header = header;
        this.addType = i2;
        this.taxList = taxList;
        this.body = body;
        this.primaryButton = primaryButton;
        this.additionalInfo = additionalInfo;
    }

    public /* synthetic */ DialogBankTaxPaymentModel(int i, String str, int i2, List list, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        String str5;
        String str6;
        List list2;
        String str7;
        String str8;
        int i4;
        DialogBankTaxPaymentModel dialogBankTaxPaymentModel;
        int i5;
        i = (i3 & 1) != 0 ? 9 : i;
        str = (i3 & 2) != 0 ? "" : str;
        i2 = (i3 & 4) != 0 ? 0 : i2;
        list = (i3 & 8) != 0 ? CollectionsKt.emptyList() : list;
        str2 = (i3 & 16) != 0 ? "" : str2;
        str3 = (i3 & 32) != 0 ? "" : str3;
        if ((i3 & 64) != 0) {
            str5 = "";
            str7 = str2;
            str6 = str3;
            i4 = i2;
            list2 = list;
            i5 = i;
            str8 = str;
            dialogBankTaxPaymentModel = this;
        } else {
            str5 = str4;
            str6 = str3;
            list2 = list;
            str7 = str2;
            str8 = str;
            i4 = i2;
            dialogBankTaxPaymentModel = this;
            i5 = i;
        }
        new DialogBankTaxPaymentModel(i5, str8, i4, list2, str7, str6, str5);
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

    public final List<DialogBankTaxPaymentInfo> getTaxList() {
        return this.taxList;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getPrimaryButton() {
        return this.primaryButton;
    }

    public final String getAdditionalInfo() {
        return this.additionalInfo;
    }
}
