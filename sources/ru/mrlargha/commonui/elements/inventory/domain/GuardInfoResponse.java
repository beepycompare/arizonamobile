package ru.mrlargha.commonui.elements.inventory.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.inventory.domain.models.GuardInfo;
/* compiled from: GuardInfoResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J*\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/GuardInfoResponse;", "", "type", "", "securities", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/GuardInfo;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;)V", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSecurities", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lru/mrlargha/commonui/elements/inventory/domain/GuardInfoResponse;", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GuardInfoResponse {
    private final List<GuardInfo> securities;
    private final Integer type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuardInfoResponse copy$default(GuardInfoResponse guardInfoResponse, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = guardInfoResponse.type;
        }
        if ((i & 2) != 0) {
            list = guardInfoResponse.securities;
        }
        return guardInfoResponse.copy(num, list);
    }

    public final Integer component1() {
        return this.type;
    }

    public final List<GuardInfo> component2() {
        return this.securities;
    }

    public final GuardInfoResponse copy(Integer num, List<GuardInfo> securities) {
        Intrinsics.checkNotNullParameter(securities, "securities");
        return new GuardInfoResponse(num, securities);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GuardInfoResponse) {
            GuardInfoResponse guardInfoResponse = (GuardInfoResponse) obj;
            return Intrinsics.areEqual(this.type, guardInfoResponse.type) && Intrinsics.areEqual(this.securities, guardInfoResponse.securities);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.type;
        return ((num == null ? 0 : num.hashCode()) * 31) + this.securities.hashCode();
    }

    public String toString() {
        Integer num = this.type;
        return "GuardInfoResponse(type=" + num + ", securities=" + this.securities + ")";
    }

    public GuardInfoResponse(Integer num, List<GuardInfo> securities) {
        Intrinsics.checkNotNullParameter(securities, "securities");
        this.type = num;
        this.securities = securities;
    }

    public final Integer getType() {
        return this.type;
    }

    public final List<GuardInfo> getSecurities() {
        return this.securities;
    }
}
