package ru.mrlargha.commonui.elements.inventory.presentation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: util.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/ResolvedInventoryEffect;", "", "fileName", "", "effectType", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getFileName", "()Ljava/lang/String;", "getEffectType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/inventory/presentation/ResolvedInventoryEffect;", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ResolvedInventoryEffect {
    private final Integer effectType;
    private final String fileName;

    public static /* synthetic */ ResolvedInventoryEffect copy$default(ResolvedInventoryEffect resolvedInventoryEffect, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resolvedInventoryEffect.fileName;
        }
        if ((i & 2) != 0) {
            num = resolvedInventoryEffect.effectType;
        }
        return resolvedInventoryEffect.copy(str, num);
    }

    public final String component1() {
        return this.fileName;
    }

    public final Integer component2() {
        return this.effectType;
    }

    public final ResolvedInventoryEffect copy(String fileName, Integer num) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return new ResolvedInventoryEffect(fileName, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResolvedInventoryEffect) {
            ResolvedInventoryEffect resolvedInventoryEffect = (ResolvedInventoryEffect) obj;
            return Intrinsics.areEqual(this.fileName, resolvedInventoryEffect.fileName) && Intrinsics.areEqual(this.effectType, resolvedInventoryEffect.effectType);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.fileName.hashCode() * 31;
        Integer num = this.effectType;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        String str = this.fileName;
        return "ResolvedInventoryEffect(fileName=" + str + ", effectType=" + this.effectType + ")";
    }

    public ResolvedInventoryEffect(String fileName, Integer num) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.fileName = fileName;
        this.effectType = num;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Integer getEffectType() {
        return this.effectType;
    }
}
