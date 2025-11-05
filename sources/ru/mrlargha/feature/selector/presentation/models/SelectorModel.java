package ru.mrlargha.feature.selector.presentation.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectorModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J_\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lru/mrlargha/feature/selector/presentation/models/SelectorModel;", "", "currentIndex", "", "maxIndex", "title", "", FirebaseAnalytics.Param.PRICE, "currencyType", "declineButton", "Lru/mrlargha/feature/selector/presentation/models/SelectorButtonModel;", "confirmButton", "additionalInfo", "", "Lru/mrlargha/feature/selector/presentation/models/SelectorInfoModel;", "<init>", "(IILjava/lang/String;IILru/mrlargha/feature/selector/presentation/models/SelectorButtonModel;Lru/mrlargha/feature/selector/presentation/models/SelectorButtonModel;Ljava/util/List;)V", "getCurrentIndex", "()I", "getMaxIndex", "getTitle", "()Ljava/lang/String;", "getPrice", "getCurrencyType", "getDeclineButton", "()Lru/mrlargha/feature/selector/presentation/models/SelectorButtonModel;", "getConfirmButton", "getAdditionalInfo", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "selector_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SelectorModel {
    private final List<SelectorInfoModel> additionalInfo;
    private final SelectorButtonModel confirmButton;
    private final int currencyType;
    private final int currentIndex;
    private final SelectorButtonModel declineButton;
    private final int maxIndex;
    private final int price;
    private final String title;

    public static /* synthetic */ SelectorModel copy$default(SelectorModel selectorModel, int i, int i2, String str, int i3, int i4, SelectorButtonModel selectorButtonModel, SelectorButtonModel selectorButtonModel2, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = selectorModel.currentIndex;
        }
        if ((i5 & 2) != 0) {
            i2 = selectorModel.maxIndex;
        }
        if ((i5 & 4) != 0) {
            str = selectorModel.title;
        }
        if ((i5 & 8) != 0) {
            i3 = selectorModel.price;
        }
        if ((i5 & 16) != 0) {
            i4 = selectorModel.currencyType;
        }
        if ((i5 & 32) != 0) {
            selectorButtonModel = selectorModel.declineButton;
        }
        if ((i5 & 64) != 0) {
            selectorButtonModel2 = selectorModel.confirmButton;
        }
        List<SelectorInfoModel> list2 = list;
        if ((i5 & 128) != 0) {
            list2 = selectorModel.additionalInfo;
        }
        SelectorButtonModel selectorButtonModel3 = selectorButtonModel2;
        List list3 = list2;
        int i6 = i4;
        SelectorButtonModel selectorButtonModel4 = selectorButtonModel;
        return selectorModel.copy(i, i2, str, i3, i6, selectorButtonModel4, selectorButtonModel3, list3);
    }

    public final int component1() {
        return this.currentIndex;
    }

    public final int component2() {
        return this.maxIndex;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.price;
    }

    public final int component5() {
        return this.currencyType;
    }

    public final SelectorButtonModel component6() {
        return this.declineButton;
    }

    public final SelectorButtonModel component7() {
        return this.confirmButton;
    }

    public final List<SelectorInfoModel> component8() {
        return this.additionalInfo;
    }

    public final SelectorModel copy(int i, int i2, String title, int i3, int i4, SelectorButtonModel declineButton, SelectorButtonModel confirmButton, List<SelectorInfoModel> additionalInfo) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(declineButton, "declineButton");
        Intrinsics.checkNotNullParameter(confirmButton, "confirmButton");
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        return new SelectorModel(i, i2, title, i3, i4, declineButton, confirmButton, additionalInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelectorModel) {
            SelectorModel selectorModel = (SelectorModel) obj;
            return this.currentIndex == selectorModel.currentIndex && this.maxIndex == selectorModel.maxIndex && Intrinsics.areEqual(this.title, selectorModel.title) && this.price == selectorModel.price && this.currencyType == selectorModel.currencyType && Intrinsics.areEqual(this.declineButton, selectorModel.declineButton) && Intrinsics.areEqual(this.confirmButton, selectorModel.confirmButton) && Intrinsics.areEqual(this.additionalInfo, selectorModel.additionalInfo);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.currentIndex) * 31) + Integer.hashCode(this.maxIndex)) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + Integer.hashCode(this.currencyType)) * 31) + this.declineButton.hashCode()) * 31) + this.confirmButton.hashCode()) * 31) + this.additionalInfo.hashCode();
    }

    public String toString() {
        int i = this.currentIndex;
        int i2 = this.maxIndex;
        String str = this.title;
        int i3 = this.price;
        int i4 = this.currencyType;
        SelectorButtonModel selectorButtonModel = this.declineButton;
        SelectorButtonModel selectorButtonModel2 = this.confirmButton;
        return "SelectorModel(currentIndex=" + i + ", maxIndex=" + i2 + ", title=" + str + ", price=" + i3 + ", currencyType=" + i4 + ", declineButton=" + selectorButtonModel + ", confirmButton=" + selectorButtonModel2 + ", additionalInfo=" + this.additionalInfo + ")";
    }

    public SelectorModel(int i, int i2, String title, int i3, int i4, SelectorButtonModel declineButton, SelectorButtonModel confirmButton, List<SelectorInfoModel> additionalInfo) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(declineButton, "declineButton");
        Intrinsics.checkNotNullParameter(confirmButton, "confirmButton");
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        this.currentIndex = i;
        this.maxIndex = i2;
        this.title = title;
        this.price = i3;
        this.currencyType = i4;
        this.declineButton = declineButton;
        this.confirmButton = confirmButton;
        this.additionalInfo = additionalInfo;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final int getMaxIndex() {
        return this.maxIndex;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getCurrencyType() {
        return this.currencyType;
    }

    public final SelectorButtonModel getDeclineButton() {
        return this.declineButton;
    }

    public final SelectorButtonModel getConfirmButton() {
        return this.confirmButton;
    }

    public final List<SelectorInfoModel> getAdditionalInfo() {
        return this.additionalInfo;
    }
}
