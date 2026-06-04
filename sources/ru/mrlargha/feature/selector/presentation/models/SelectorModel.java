package ru.mrlargha.feature.selector.presentation.models;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectorModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J_\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001J\u0014\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lru/mrlargha/feature/selector/presentation/models/SelectorModel;", "", "currentIndex", "", "maxIndex", "title", "", FirebaseAnalytics.Param.PRICE, "", "currencyType", "declineButton", "Lru/mrlargha/feature/selector/presentation/models/SelectorButtonModel;", "confirmButton", "additionalInfo", "", "Lru/mrlargha/feature/selector/presentation/models/SelectorInfoModel;", "<init>", "(IILjava/lang/String;JILru/mrlargha/feature/selector/presentation/models/SelectorButtonModel;Lru/mrlargha/feature/selector/presentation/models/SelectorButtonModel;Ljava/util/List;)V", "getCurrentIndex", "()I", "getMaxIndex", "getTitle", "()Ljava/lang/String;", "getPrice", "()J", "getCurrencyType", "getDeclineButton", "()Lru/mrlargha/feature/selector/presentation/models/SelectorButtonModel;", "getConfirmButton", "getAdditionalInfo", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "selector"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SelectorModel {
    private final List<SelectorInfoModel> additionalInfo;
    private final SelectorButtonModel confirmButton;
    private final int currencyType;
    private final int currentIndex;
    private final SelectorButtonModel declineButton;
    private final int maxIndex;
    private final long price;
    private final String title;

    public static /* synthetic */ SelectorModel copy$default(SelectorModel selectorModel, int i, int i2, String str, long j, int i3, SelectorButtonModel selectorButtonModel, SelectorButtonModel selectorButtonModel2, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = selectorModel.currentIndex;
        }
        if ((i4 & 2) != 0) {
            i2 = selectorModel.maxIndex;
        }
        if ((i4 & 4) != 0) {
            str = selectorModel.title;
        }
        if ((i4 & 8) != 0) {
            j = selectorModel.price;
        }
        if ((i4 & 16) != 0) {
            i3 = selectorModel.currencyType;
        }
        if ((i4 & 32) != 0) {
            selectorButtonModel = selectorModel.declineButton;
        }
        if ((i4 & 64) != 0) {
            selectorButtonModel2 = selectorModel.confirmButton;
        }
        List<SelectorInfoModel> list2 = list;
        if ((i4 & 128) != 0) {
            list2 = selectorModel.additionalInfo;
        }
        long j2 = j;
        String str2 = str;
        return selectorModel.copy(i, i2, str2, j2, i3, selectorButtonModel, selectorButtonModel2, list2);
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

    public final long component4() {
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

    public final SelectorModel copy(int i, int i2, String title, long j, int i3, SelectorButtonModel declineButton, SelectorButtonModel confirmButton, List<SelectorInfoModel> additionalInfo) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(declineButton, "declineButton");
        Intrinsics.checkNotNullParameter(confirmButton, "confirmButton");
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        return new SelectorModel(i, i2, title, j, i3, declineButton, confirmButton, additionalInfo);
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
        return (((((((((((((Integer.hashCode(this.currentIndex) * 31) + Integer.hashCode(this.maxIndex)) * 31) + this.title.hashCode()) * 31) + Long.hashCode(this.price)) * 31) + Integer.hashCode(this.currencyType)) * 31) + this.declineButton.hashCode()) * 31) + this.confirmButton.hashCode()) * 31) + this.additionalInfo.hashCode();
    }

    public String toString() {
        int i = this.currentIndex;
        int i2 = this.maxIndex;
        String str = this.title;
        long j = this.price;
        int i3 = this.currencyType;
        SelectorButtonModel selectorButtonModel = this.declineButton;
        SelectorButtonModel selectorButtonModel2 = this.confirmButton;
        return "SelectorModel(currentIndex=" + i + ", maxIndex=" + i2 + ", title=" + str + ", price=" + j + ", currencyType=" + i3 + ", declineButton=" + selectorButtonModel + ", confirmButton=" + selectorButtonModel2 + ", additionalInfo=" + this.additionalInfo + ")";
    }

    public SelectorModel(int i, int i2, String title, long j, int i3, SelectorButtonModel declineButton, SelectorButtonModel confirmButton, List<SelectorInfoModel> additionalInfo) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(declineButton, "declineButton");
        Intrinsics.checkNotNullParameter(confirmButton, "confirmButton");
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        this.currentIndex = i;
        this.maxIndex = i2;
        this.title = title;
        this.price = j;
        this.currencyType = i3;
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

    public final long getPrice() {
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
