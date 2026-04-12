package ru.mrlargha.feature.battle_pass_view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UserBattlePass.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/RewardResponse;", "", "title", "", "sysName", "", "info", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getSysName", "()I", "getInfo", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "battle-pass-view"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RewardResponse {
    private final String info;
    private final int sysName;
    private final String title;

    public static /* synthetic */ RewardResponse copy$default(RewardResponse rewardResponse, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rewardResponse.title;
        }
        if ((i2 & 2) != 0) {
            i = rewardResponse.sysName;
        }
        if ((i2 & 4) != 0) {
            str2 = rewardResponse.info;
        }
        return rewardResponse.copy(str, i, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.sysName;
    }

    public final String component3() {
        return this.info;
    }

    public final RewardResponse copy(String title, int i, String str) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new RewardResponse(title, i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RewardResponse) {
            RewardResponse rewardResponse = (RewardResponse) obj;
            return Intrinsics.areEqual(this.title, rewardResponse.title) && this.sysName == rewardResponse.sysName && Intrinsics.areEqual(this.info, rewardResponse.info);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.title.hashCode() * 31) + Integer.hashCode(this.sysName)) * 31;
        String str = this.info;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.title;
        int i = this.sysName;
        return "RewardResponse(title=" + str + ", sysName=" + i + ", info=" + this.info + ")";
    }

    public RewardResponse(String title, int i, String str) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        this.sysName = i;
        this.info = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getSysName() {
        return this.sysName;
    }

    public final String getInfo() {
        return this.info;
    }
}
