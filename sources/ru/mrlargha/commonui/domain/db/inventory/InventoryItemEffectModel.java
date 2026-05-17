package ru.mrlargha.commonui.domain.db.inventory;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InventoryItemEntity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEffectModel;", "", "effectType", "", "<init>", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEffectType", "Lru/mrlargha/commonui/domain/db/inventory/InventoryEffectType;", "component1", "()Ljava/lang/Integer;", "copy", "(Ljava/lang/Integer;)Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEffectModel;", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryItemEffectModel {
    private Integer effectType;

    private final Integer component1() {
        return this.effectType;
    }

    public static /* synthetic */ InventoryItemEffectModel copy$default(InventoryItemEffectModel inventoryItemEffectModel, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = inventoryItemEffectModel.effectType;
        }
        return inventoryItemEffectModel.copy(num);
    }

    public final InventoryItemEffectModel copy(Integer num) {
        return new InventoryItemEffectModel(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InventoryItemEffectModel) && Intrinsics.areEqual(this.effectType, ((InventoryItemEffectModel) obj).effectType);
    }

    public int hashCode() {
        Integer num = this.effectType;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "InventoryItemEffectModel(effectType=" + this.effectType + ")";
    }

    public InventoryItemEffectModel(Integer num) {
        this.effectType = num;
    }

    public final InventoryEffectType getEffectType() {
        Object obj;
        Iterator<E> it = InventoryEffectType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            int id = ((InventoryEffectType) obj).getId();
            Integer num = this.effectType;
            if (num != null && id == num.intValue()) {
                break;
            }
        }
        InventoryEffectType inventoryEffectType = (InventoryEffectType) obj;
        return inventoryEffectType == null ? InventoryEffectType.FOREGROUND : inventoryEffectType;
    }
}
