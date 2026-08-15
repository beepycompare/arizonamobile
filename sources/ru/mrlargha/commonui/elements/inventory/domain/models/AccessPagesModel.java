package ru.mrlargha.commonui.elements.inventory.domain.models;

import com.arizona.launcher.UpdateServiceContract;
import kotlin.Metadata;
/* compiled from: UserInventoryBars.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/models/AccessPagesModel;", "", UpdateServiceContract.BundleKey.TOTAL, "", "page", "<init>", "(II)V", "getTotal", "()I", "getPage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AccessPagesModel {
    private final int page;
    private final int total;

    public static /* synthetic */ AccessPagesModel copy$default(AccessPagesModel accessPagesModel, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = accessPagesModel.total;
        }
        if ((i3 & 2) != 0) {
            i2 = accessPagesModel.page;
        }
        return accessPagesModel.copy(i, i2);
    }

    public final int component1() {
        return this.total;
    }

    public final int component2() {
        return this.page;
    }

    public final AccessPagesModel copy(int i, int i2) {
        return new AccessPagesModel(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessPagesModel) {
            AccessPagesModel accessPagesModel = (AccessPagesModel) obj;
            return this.total == accessPagesModel.total && this.page == accessPagesModel.page;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.total) * 31) + Integer.hashCode(this.page);
    }

    public String toString() {
        int i = this.total;
        return "AccessPagesModel(total=" + i + ", page=" + this.page + ")";
    }

    public AccessPagesModel(int i, int i2) {
        this.total = i;
        this.page = i2;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getPage() {
        return this.page;
    }
}
