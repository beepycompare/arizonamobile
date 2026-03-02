package ru.mrlargha.employment.center.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/employment/center/data/AdditionalInfo;", "", "name", "", "value", "", "<init>", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getValue", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "employment-center"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AdditionalInfo {
    private final String name;
    private final int value;

    public static /* synthetic */ AdditionalInfo copy$default(AdditionalInfo additionalInfo, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = additionalInfo.name;
        }
        if ((i2 & 2) != 0) {
            i = additionalInfo.value;
        }
        return additionalInfo.copy(str, i);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.value;
    }

    public final AdditionalInfo copy(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new AdditionalInfo(name, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdditionalInfo) {
            AdditionalInfo additionalInfo = (AdditionalInfo) obj;
            return Intrinsics.areEqual(this.name, additionalInfo.name) && this.value == additionalInfo.value;
        }
        return false;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + Integer.hashCode(this.value);
    }

    public String toString() {
        String str = this.name;
        return "AdditionalInfo(name=" + str + ", value=" + this.value + ")";
    }

    public AdditionalInfo(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.value = i;
    }

    public final String getName() {
        return this.name;
    }

    public final int getValue() {
        return this.value;
    }
}
