package ru.mrlargha.arizonaui.ghetto.data;

import kotlin.Metadata;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/data/BandInfo;", "", "id", "", "territories", "fights_count", "rank", "<init>", "(IIII)V", "getId", "()I", "getTerritories", "getFights_count", "getRank", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BandInfo {
    private final int fights_count;
    private final int id;
    private final int rank;
    private final int territories;

    public static /* synthetic */ BandInfo copy$default(BandInfo bandInfo, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = bandInfo.id;
        }
        if ((i5 & 2) != 0) {
            i2 = bandInfo.territories;
        }
        if ((i5 & 4) != 0) {
            i3 = bandInfo.fights_count;
        }
        if ((i5 & 8) != 0) {
            i4 = bandInfo.rank;
        }
        return bandInfo.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.territories;
    }

    public final int component3() {
        return this.fights_count;
    }

    public final int component4() {
        return this.rank;
    }

    public final BandInfo copy(int i, int i2, int i3, int i4) {
        return new BandInfo(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BandInfo) {
            BandInfo bandInfo = (BandInfo) obj;
            return this.id == bandInfo.id && this.territories == bandInfo.territories && this.fights_count == bandInfo.fights_count && this.rank == bandInfo.rank;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.territories)) * 31) + Integer.hashCode(this.fights_count)) * 31) + Integer.hashCode(this.rank);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.territories;
        int i3 = this.fights_count;
        return "BandInfo(id=" + i + ", territories=" + i2 + ", fights_count=" + i3 + ", rank=" + this.rank + ")";
    }

    public BandInfo(int i, int i2, int i3, int i4) {
        this.id = i;
        this.territories = i2;
        this.fights_count = i3;
        this.rank = i4;
    }

    public final int getId() {
        return this.id;
    }

    public final int getTerritories() {
        return this.territories;
    }

    public final int getFights_count() {
        return this.fights_count;
    }

    public final int getRank() {
        return this.rank;
    }
}
