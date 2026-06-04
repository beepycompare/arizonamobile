package ru.mrlargha.feature.arizona.cases;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CasesResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/feature/arizona/cases/CasesUsedModel;", "", "itemId", "", "usedType", "Lru/mrlargha/feature/arizona/cases/CasesUsedType;", "<init>", "(ILru/mrlargha/feature/arizona/cases/CasesUsedType;)V", "getItemId", "()I", "getUsedType", "()Lru/mrlargha/feature/arizona/cases/CasesUsedType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "cases"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesUsedModel {
    private final int itemId;
    private final CasesUsedType usedType;

    public static /* synthetic */ CasesUsedModel copy$default(CasesUsedModel casesUsedModel, int i, CasesUsedType casesUsedType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = casesUsedModel.itemId;
        }
        if ((i2 & 2) != 0) {
            casesUsedType = casesUsedModel.usedType;
        }
        return casesUsedModel.copy(i, casesUsedType);
    }

    public final int component1() {
        return this.itemId;
    }

    public final CasesUsedType component2() {
        return this.usedType;
    }

    public final CasesUsedModel copy(int i, CasesUsedType usedType) {
        Intrinsics.checkNotNullParameter(usedType, "usedType");
        return new CasesUsedModel(i, usedType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CasesUsedModel) {
            CasesUsedModel casesUsedModel = (CasesUsedModel) obj;
            return this.itemId == casesUsedModel.itemId && this.usedType == casesUsedModel.usedType;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.itemId) * 31) + this.usedType.hashCode();
    }

    public String toString() {
        int i = this.itemId;
        return "CasesUsedModel(itemId=" + i + ", usedType=" + this.usedType + ")";
    }

    public CasesUsedModel(int i, CasesUsedType usedType) {
        Intrinsics.checkNotNullParameter(usedType, "usedType");
        this.itemId = i;
        this.usedType = usedType;
    }

    public final int getItemId() {
        return this.itemId;
    }

    public final CasesUsedType getUsedType() {
        return this.usedType;
    }
}
