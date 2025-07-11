package ru.mrlargha.commonui.elements.employmentNote.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TasksResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/domain/RewardInfo;", "", "redwards", "", "Lru/mrlargha/commonui/elements/employmentNote/domain/RewardType;", "<init>", "(Ljava/util/List;)V", "getRedwards", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RewardInfo {
    private final List<RewardType> redwards;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RewardInfo copy$default(RewardInfo rewardInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = rewardInfo.redwards;
        }
        return rewardInfo.copy(list);
    }

    public final List<RewardType> component1() {
        return this.redwards;
    }

    public final RewardInfo copy(List<RewardType> redwards) {
        Intrinsics.checkNotNullParameter(redwards, "redwards");
        return new RewardInfo(redwards);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RewardInfo) && Intrinsics.areEqual(this.redwards, ((RewardInfo) obj).redwards);
    }

    public int hashCode() {
        return this.redwards.hashCode();
    }

    public String toString() {
        return "RewardInfo(redwards=" + this.redwards + ")";
    }

    public RewardInfo(List<RewardType> redwards) {
        Intrinsics.checkNotNullParameter(redwards, "redwards");
        this.redwards = redwards;
    }

    public final List<RewardType> getRedwards() {
        return this.redwards;
    }
}
