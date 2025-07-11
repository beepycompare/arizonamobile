package ru.mrlargha.arizonaui.ghetto.data;

import kotlin.Metadata;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/data/RatingData;", "", "fraction_id", "", "territories", "<init>", "(II)V", "getFraction_id", "()I", "getTerritories", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RatingData {
    private final int fraction_id;
    private final int territories;

    public static /* synthetic */ RatingData copy$default(RatingData ratingData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = ratingData.fraction_id;
        }
        if ((i3 & 2) != 0) {
            i2 = ratingData.territories;
        }
        return ratingData.copy(i, i2);
    }

    public final int component1() {
        return this.fraction_id;
    }

    public final int component2() {
        return this.territories;
    }

    public final RatingData copy(int i, int i2) {
        return new RatingData(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RatingData) {
            RatingData ratingData = (RatingData) obj;
            return this.fraction_id == ratingData.fraction_id && this.territories == ratingData.territories;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.fraction_id) * 31) + Integer.hashCode(this.territories);
    }

    public String toString() {
        int i = this.fraction_id;
        return "RatingData(fraction_id=" + i + ", territories=" + this.territories + ")";
    }

    public RatingData(int i, int i2) {
        this.fraction_id = i;
        this.territories = i2;
    }

    public final int getFraction_id() {
        return this.fraction_id;
    }

    public final int getTerritories() {
        return this.territories;
    }
}
