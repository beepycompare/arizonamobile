package ru.mrlargha.commonui.elements.battlePassView;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UserBattlePass.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/battlePassView/DataResponse;", "", "type", "", "headers", "", "desc", "rewards", "", "Lru/mrlargha/commonui/elements/battlePassView/RewardResponse;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getType", "()I", "getHeaders", "()Ljava/lang/String;", "getDesc", "getRewards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DataResponse {
    private final String desc;
    private final String headers;
    private final List<RewardResponse> rewards;
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataResponse copy$default(DataResponse dataResponse, int i, String str, String str2, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dataResponse.type;
        }
        if ((i2 & 2) != 0) {
            str = dataResponse.headers;
        }
        if ((i2 & 4) != 0) {
            str2 = dataResponse.desc;
        }
        if ((i2 & 8) != 0) {
            list = dataResponse.rewards;
        }
        return dataResponse.copy(i, str, str2, list);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.headers;
    }

    public final String component3() {
        return this.desc;
    }

    public final List<RewardResponse> component4() {
        return this.rewards;
    }

    public final DataResponse copy(int i, String headers, String desc, List<RewardResponse> list) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new DataResponse(i, headers, desc, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DataResponse) {
            DataResponse dataResponse = (DataResponse) obj;
            return this.type == dataResponse.type && Intrinsics.areEqual(this.headers, dataResponse.headers) && Intrinsics.areEqual(this.desc, dataResponse.desc) && Intrinsics.areEqual(this.rewards, dataResponse.rewards);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.type) * 31) + this.headers.hashCode()) * 31) + this.desc.hashCode()) * 31;
        List<RewardResponse> list = this.rewards;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        int i = this.type;
        String str = this.headers;
        String str2 = this.desc;
        return "DataResponse(type=" + i + ", headers=" + str + ", desc=" + str2 + ", rewards=" + this.rewards + ")";
    }

    public DataResponse(int i, String headers, String desc, List<RewardResponse> list) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.type = i;
        this.headers = headers;
        this.desc = desc;
        this.rewards = list;
    }

    public final int getType() {
        return this.type;
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
}
