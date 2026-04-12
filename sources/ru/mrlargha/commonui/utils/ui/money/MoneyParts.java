package ru.mrlargha.commonui.utils.ui.money;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
/* compiled from: MoneyElement.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/utils/ui/money/MoneyParts;", "", CmcdData.OBJECT_TYPE_MANIFEST, "", "kk", "k", "<init>", "(III)V", "getM", "()I", "getKk", "getK", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MoneyParts {
    private final int k;
    private final int kk;
    private final int m;

    public static /* synthetic */ MoneyParts copy$default(MoneyParts moneyParts, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = moneyParts.m;
        }
        if ((i4 & 2) != 0) {
            i2 = moneyParts.kk;
        }
        if ((i4 & 4) != 0) {
            i3 = moneyParts.k;
        }
        return moneyParts.copy(i, i2, i3);
    }

    public final int component1() {
        return this.m;
    }

    public final int component2() {
        return this.kk;
    }

    public final int component3() {
        return this.k;
    }

    public final MoneyParts copy(int i, int i2, int i3) {
        return new MoneyParts(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MoneyParts) {
            MoneyParts moneyParts = (MoneyParts) obj;
            return this.m == moneyParts.m && this.kk == moneyParts.kk && this.k == moneyParts.k;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.m) * 31) + Integer.hashCode(this.kk)) * 31) + Integer.hashCode(this.k);
    }

    public String toString() {
        int i = this.m;
        int i2 = this.kk;
        return "MoneyParts(m=" + i + ", kk=" + i2 + ", k=" + this.k + ")";
    }

    public MoneyParts(int i, int i2, int i3) {
        this.m = i;
        this.kk = i2;
        this.k = i3;
    }

    public final int getM() {
        return this.m;
    }

    public final int getKk() {
        return this.kk;
    }

    public final int getK() {
        return this.k;
    }
}
