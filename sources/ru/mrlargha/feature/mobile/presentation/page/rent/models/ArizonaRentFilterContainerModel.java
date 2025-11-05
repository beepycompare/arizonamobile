package ru.mrlargha.feature.mobile.presentation.page.rent.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArizonaRentAdModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentFilterContainerModel;", "", "filter", "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentFilterModel;", "data", "", "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdModel;", "<init>", "(Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentFilterModel;Ljava/util/List;)V", "getFilter", "()Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentFilterModel;", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mobile_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentFilterContainerModel {
    private final List<ArizonaRentAdModel> data;
    private final ArizonaRentFilterModel filter;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArizonaRentFilterContainerModel copy$default(ArizonaRentFilterContainerModel arizonaRentFilterContainerModel, ArizonaRentFilterModel arizonaRentFilterModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            arizonaRentFilterModel = arizonaRentFilterContainerModel.filter;
        }
        if ((i & 2) != 0) {
            list = arizonaRentFilterContainerModel.data;
        }
        return arizonaRentFilterContainerModel.copy(arizonaRentFilterModel, list);
    }

    public final ArizonaRentFilterModel component1() {
        return this.filter;
    }

    public final List<ArizonaRentAdModel> component2() {
        return this.data;
    }

    public final ArizonaRentFilterContainerModel copy(ArizonaRentFilterModel arizonaRentFilterModel, List<ArizonaRentAdModel> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new ArizonaRentFilterContainerModel(arizonaRentFilterModel, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArizonaRentFilterContainerModel) {
            ArizonaRentFilterContainerModel arizonaRentFilterContainerModel = (ArizonaRentFilterContainerModel) obj;
            return Intrinsics.areEqual(this.filter, arizonaRentFilterContainerModel.filter) && Intrinsics.areEqual(this.data, arizonaRentFilterContainerModel.data);
        }
        return false;
    }

    public int hashCode() {
        ArizonaRentFilterModel arizonaRentFilterModel = this.filter;
        return ((arizonaRentFilterModel == null ? 0 : arizonaRentFilterModel.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        ArizonaRentFilterModel arizonaRentFilterModel = this.filter;
        return "ArizonaRentFilterContainerModel(filter=" + arizonaRentFilterModel + ", data=" + this.data + ")";
    }

    public ArizonaRentFilterContainerModel(ArizonaRentFilterModel arizonaRentFilterModel, List<ArizonaRentAdModel> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.filter = arizonaRentFilterModel;
        this.data = data;
    }

    public final ArizonaRentFilterModel getFilter() {
        return this.filter;
    }

    public final List<ArizonaRentAdModel> getData() {
        return this.data;
    }
}
