package ru.mrlargha.commonui.elements.donate.presentation.models;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonatePayPassState.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassLevel;", "", TtmlNode.ATTR_ID, "", FirebaseAnalytics.Param.PRICE, "prizes", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassPrize;", "<init>", "(IILjava/util/List;)V", "getId", "()I", "getPrice", "getPrizes", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPassLevel {
    private final int id;
    private final int price;
    private final List<DonatePayPassPrize> prizes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DonatePayPassLevel copy$default(DonatePayPassLevel donatePayPassLevel, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = donatePayPassLevel.id;
        }
        if ((i3 & 2) != 0) {
            i2 = donatePayPassLevel.price;
        }
        if ((i3 & 4) != 0) {
            list = donatePayPassLevel.prizes;
        }
        return donatePayPassLevel.copy(i, i2, list);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.price;
    }

    public final List<DonatePayPassPrize> component3() {
        return this.prizes;
    }

    public final DonatePayPassLevel copy(int i, int i2, List<DonatePayPassPrize> prizes) {
        Intrinsics.checkNotNullParameter(prizes, "prizes");
        return new DonatePayPassLevel(i, i2, prizes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonatePayPassLevel) {
            DonatePayPassLevel donatePayPassLevel = (DonatePayPassLevel) obj;
            return this.id == donatePayPassLevel.id && this.price == donatePayPassLevel.price && Intrinsics.areEqual(this.prizes, donatePayPassLevel.prizes);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.price)) * 31) + this.prizes.hashCode();
    }

    public String toString() {
        int i = this.id;
        int i2 = this.price;
        return "DonatePayPassLevel(id=" + i + ", price=" + i2 + ", prizes=" + this.prizes + ")";
    }

    public DonatePayPassLevel(int i, int i2, List<DonatePayPassPrize> prizes) {
        Intrinsics.checkNotNullParameter(prizes, "prizes");
        this.id = i;
        this.price = i2;
        this.prizes = prizes;
    }

    public final int getId() {
        return this.id;
    }

    public final int getPrice() {
        return this.price;
    }

    public final List<DonatePayPassPrize> getPrizes() {
        return this.prizes;
    }
}
