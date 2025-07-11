package ru.mrlargha.commonui.elements.inventory.presentation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InventoryScreen.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/SendId;", "", "id", "", "<init>", "(Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lru/mrlargha/commonui/elements/inventory/presentation/SendId;", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendId {
    private final Integer id;

    public static /* synthetic */ SendId copy$default(SendId sendId, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = sendId.id;
        }
        return sendId.copy(num);
    }

    public final Integer component1() {
        return this.id;
    }

    public final SendId copy(Integer num) {
        return new SendId(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SendId) && Intrinsics.areEqual(this.id, ((SendId) obj).id);
    }

    public int hashCode() {
        Integer num = this.id;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "SendId(id=" + this.id + ")";
    }

    public SendId(Integer num) {
        this.id = num;
    }

    public final Integer getId() {
        return this.id;
    }
}
