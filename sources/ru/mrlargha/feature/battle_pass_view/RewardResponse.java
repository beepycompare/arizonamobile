package ru.mrlargha.feature.battle_pass_view;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UserBattlePass.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/RewardResponse;", "", "title", "", "sysName", "", "info", "description", "colors", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getSysName", "()I", "getInfo", "getDescription", "getColors", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "battle-pass-view"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RewardResponse {
    private final List<String> colors;
    private final String description;
    private final String info;
    private final int sysName;
    private final String title;

    public static /* synthetic */ RewardResponse copy$default(RewardResponse rewardResponse, String str, int i, String str2, String str3, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rewardResponse.title;
        }
        if ((i2 & 2) != 0) {
            i = rewardResponse.sysName;
        }
        if ((i2 & 4) != 0) {
            str2 = rewardResponse.info;
        }
        if ((i2 & 8) != 0) {
            str3 = rewardResponse.description;
        }
        List<String> list2 = list;
        if ((i2 & 16) != 0) {
            list2 = rewardResponse.colors;
        }
        List list3 = list2;
        String str4 = str2;
        return rewardResponse.copy(str, i, str4, str3, list3);
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

    public final String component4() {
        return this.description;
    }

    public final List<String> component5() {
        return this.colors;
    }

    public final RewardResponse copy(String str, int i, String str2, String str3, List<String> list) {
        return new RewardResponse(str, i, str2, str3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RewardResponse) {
            RewardResponse rewardResponse = (RewardResponse) obj;
            return Intrinsics.areEqual(this.title, rewardResponse.title) && this.sysName == rewardResponse.sysName && Intrinsics.areEqual(this.info, rewardResponse.info) && Intrinsics.areEqual(this.description, rewardResponse.description) && Intrinsics.areEqual(this.colors, rewardResponse.colors);
        }
        return false;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.sysName)) * 31;
        String str2 = this.info;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.colors;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        int i = this.sysName;
        String str2 = this.info;
        String str3 = this.description;
        return "RewardResponse(title=" + str + ", sysName=" + i + ", info=" + str2 + ", description=" + str3 + ", colors=" + this.colors + ")";
    }

    public RewardResponse(String str, int i, String str2, String str3, List<String> list) {
        this.title = str;
        this.sysName = i;
        this.info = str2;
        this.description = str3;
        this.colors = list;
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

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getColors() {
        return this.colors;
    }
}
