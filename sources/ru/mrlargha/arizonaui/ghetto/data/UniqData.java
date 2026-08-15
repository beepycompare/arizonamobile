package ru.mrlargha.arizonaui.ghetto.data;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/data/UniqData;", "", TtmlNode.ATTR_ID, "", "ukrop", "balance", "", "<init>", "(IIJ)V", "getId", "()I", "getUkrop", "getBalance", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UniqData {
    private final long balance;
    private final int id;
    private final int ukrop;

    public static /* synthetic */ UniqData copy$default(UniqData uniqData, int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = uniqData.id;
        }
        if ((i3 & 2) != 0) {
            i2 = uniqData.ukrop;
        }
        if ((i3 & 4) != 0) {
            j = uniqData.balance;
        }
        return uniqData.copy(i, i2, j);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.ukrop;
    }

    public final long component3() {
        return this.balance;
    }

    public final UniqData copy(int i, int i2, long j) {
        return new UniqData(i, i2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UniqData) {
            UniqData uniqData = (UniqData) obj;
            return this.id == uniqData.id && this.ukrop == uniqData.ukrop && this.balance == uniqData.balance;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.ukrop)) * 31) + Long.hashCode(this.balance);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.ukrop;
        return "UniqData(id=" + i + ", ukrop=" + i2 + ", balance=" + this.balance + ")";
    }

    public UniqData(int i, int i2, long j) {
        this.id = i;
        this.ukrop = i2;
        this.balance = j;
    }

    public final int getId() {
        return this.id;
    }

    public final int getUkrop() {
        return this.ukrop;
    }

    public final long getBalance() {
        return this.balance;
    }
}
