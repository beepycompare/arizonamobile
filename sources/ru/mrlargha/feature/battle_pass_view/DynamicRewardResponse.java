package ru.mrlargha.feature.battle_pass_view;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UserBattlePass.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006 "}, d2 = {"Lru/mrlargha/feature/battle_pass_view/DynamicRewardResponse;", "", "title", "", "imageType", "", "rewards", "", "Lru/mrlargha/feature/battle_pass_view/RewardResponse;", "mainColors", "path", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getImageType", "()I", "getRewards", "()Ljava/util/List;", "getMainColors", "getPath", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "battle-pass-view"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DynamicRewardResponse {
    private final int imageType;
    private final List<String> mainColors;
    private final String path;
    private final List<RewardResponse> rewards;
    private final String title;

    public static /* synthetic */ DynamicRewardResponse copy$default(DynamicRewardResponse dynamicRewardResponse, String str, int i, List list, List list2, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = dynamicRewardResponse.title;
        }
        if ((i2 & 2) != 0) {
            i = dynamicRewardResponse.imageType;
        }
        List<RewardResponse> list3 = list;
        if ((i2 & 4) != 0) {
            list3 = dynamicRewardResponse.rewards;
        }
        List<String> list4 = list2;
        if ((i2 & 8) != 0) {
            list4 = dynamicRewardResponse.mainColors;
        }
        if ((i2 & 16) != 0) {
            str2 = dynamicRewardResponse.path;
        }
        String str3 = str2;
        List list5 = list3;
        return dynamicRewardResponse.copy(str, i, list5, list4, str3);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.imageType;
    }

    public final List<RewardResponse> component3() {
        return this.rewards;
    }

    public final List<String> component4() {
        return this.mainColors;
    }

    public final String component5() {
        return this.path;
    }

    public final DynamicRewardResponse copy(String str, int i, List<RewardResponse> list, List<String> list2, String str2) {
        return new DynamicRewardResponse(str, i, list, list2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DynamicRewardResponse) {
            DynamicRewardResponse dynamicRewardResponse = (DynamicRewardResponse) obj;
            return Intrinsics.areEqual(this.title, dynamicRewardResponse.title) && this.imageType == dynamicRewardResponse.imageType && Intrinsics.areEqual(this.rewards, dynamicRewardResponse.rewards) && Intrinsics.areEqual(this.mainColors, dynamicRewardResponse.mainColors) && Intrinsics.areEqual(this.path, dynamicRewardResponse.path);
        }
        return false;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.imageType)) * 31;
        List<RewardResponse> list = this.rewards;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.mainColors;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.path;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        int i = this.imageType;
        List<RewardResponse> list = this.rewards;
        List<String> list2 = this.mainColors;
        return "DynamicRewardResponse(title=" + str + ", imageType=" + i + ", rewards=" + list + ", mainColors=" + list2 + ", path=" + this.path + ")";
    }

    public DynamicRewardResponse(String str, int i, List<RewardResponse> list, List<String> list2, String str2) {
        this.title = str;
        this.imageType = i;
        this.rewards = list;
        this.mainColors = list2;
        this.path = str2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getImageType() {
        return this.imageType;
    }

    public final List<RewardResponse> getRewards() {
        return this.rewards;
    }

    public final List<String> getMainColors() {
        return this.mainColors;
    }

    public final String getPath() {
        return this.path;
    }
}
