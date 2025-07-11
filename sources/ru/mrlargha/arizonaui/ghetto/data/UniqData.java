package ru.mrlargha.arizonaui.ghetto.data;

import kotlin.Metadata;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/data/UniqData;", "", "id", "", "ukrop", "balance", "<init>", "(III)V", "getId", "()I", "getUkrop", "getBalance", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UniqData {
    private final int balance;
    private final int id;
    private final int ukrop;

    public static /* synthetic */ UniqData copy$default(UniqData uniqData, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = uniqData.id;
        }
        if ((i4 & 2) != 0) {
            i2 = uniqData.ukrop;
        }
        if ((i4 & 4) != 0) {
            i3 = uniqData.balance;
        }
        return uniqData.copy(i, i2, i3);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.ukrop;
    }

    public final int component3() {
        return this.balance;
    }

    public final UniqData copy(int i, int i2, int i3) {
        return new UniqData(i, i2, i3);
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
        return (((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.ukrop)) * 31) + Integer.hashCode(this.balance);
    }

    public String toString() {
        int i = this.id;
        int i2 = this.ukrop;
        return "UniqData(id=" + i + ", ukrop=" + i2 + ", balance=" + this.balance + ")";
    }

    public UniqData(int i, int i2, int i3) {
        this.id = i;
        this.ukrop = i2;
        this.balance = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final int getUkrop() {
        return this.ukrop;
    }

    public final int getBalance() {
        return this.balance;
    }
}
