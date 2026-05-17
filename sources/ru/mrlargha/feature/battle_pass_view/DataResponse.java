package ru.mrlargha.feature.battle_pass_view;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UserBattlePass.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J_\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006&"}, d2 = {"Lru/mrlargha/feature/battle_pass_view/DataResponse;", "", "type", "", "imageType", "title", "", "headers", "desc", "rewards", "", "Lru/mrlargha/feature/battle_pass_view/RewardResponse;", "path", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getType", "()I", "getImageType", "getTitle", "()Ljava/lang/String;", "getHeaders", "getDesc", "getRewards", "()Ljava/util/List;", "getPath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "battle-pass-view"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DataResponse {
    private final String desc;
    private final String headers;
    private final int imageType;
    private final String path;
    private final List<RewardResponse> rewards;
    private final String title;
    private final int type;

    public static /* synthetic */ DataResponse copy$default(DataResponse dataResponse, int i, int i2, String str, String str2, String str3, List list, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = dataResponse.type;
        }
        if ((i3 & 2) != 0) {
            i2 = dataResponse.imageType;
        }
        if ((i3 & 4) != 0) {
            str = dataResponse.title;
        }
        if ((i3 & 8) != 0) {
            str2 = dataResponse.headers;
        }
        if ((i3 & 16) != 0) {
            str3 = dataResponse.desc;
        }
        List<RewardResponse> list2 = list;
        if ((i3 & 32) != 0) {
            list2 = dataResponse.rewards;
        }
        if ((i3 & 64) != 0) {
            str4 = dataResponse.path;
        }
        List list3 = list2;
        String str5 = str4;
        String str6 = str3;
        String str7 = str;
        return dataResponse.copy(i, i2, str7, str2, str6, list3, str5);
    }

    public final int component1() {
        return this.type;
    }

    public final int component2() {
        return this.imageType;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.headers;
    }

    public final String component5() {
        return this.desc;
    }

    public final List<RewardResponse> component6() {
        return this.rewards;
    }

    public final String component7() {
        return this.path;
    }

    public final DataResponse copy(int i, int i2, String str, String str2, String str3, List<RewardResponse> list, String str4) {
        return new DataResponse(i, i2, str, str2, str3, list, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DataResponse) {
            DataResponse dataResponse = (DataResponse) obj;
            return this.type == dataResponse.type && this.imageType == dataResponse.imageType && Intrinsics.areEqual(this.title, dataResponse.title) && Intrinsics.areEqual(this.headers, dataResponse.headers) && Intrinsics.areEqual(this.desc, dataResponse.desc) && Intrinsics.areEqual(this.rewards, dataResponse.rewards) && Intrinsics.areEqual(this.path, dataResponse.path);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.imageType)) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.headers;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.desc;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<RewardResponse> list = this.rewards;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.path;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        int i = this.type;
        int i2 = this.imageType;
        String str = this.title;
        String str2 = this.headers;
        String str3 = this.desc;
        List<RewardResponse> list = this.rewards;
        return "DataResponse(type=" + i + ", imageType=" + i2 + ", title=" + str + ", headers=" + str2 + ", desc=" + str3 + ", rewards=" + list + ", path=" + this.path + ")";
    }

    public DataResponse(int i, int i2, String str, String str2, String str3, List<RewardResponse> list, String str4) {
        this.type = i;
        this.imageType = i2;
        this.title = str;
        this.headers = str2;
        this.desc = str3;
        this.rewards = list;
        this.path = str4;
    }

    public final int getType() {
        return this.type;
    }

    public final int getImageType() {
        return this.imageType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getHeaders() {
        return this.headers;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final List<RewardResponse> getRewards() {
        return this.rewards;
    }

    public final String getPath() {
        return this.path;
    }
}
