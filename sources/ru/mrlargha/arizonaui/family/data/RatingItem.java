package ru.mrlargha.arizonaui.family.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lru/mrlargha/arizonaui/family/data/RatingItem;", "", "name", "", FirebaseAnalytics.Param.LEVEL, "", "leader", "flagId", "memberCount", "<init>", "(Ljava/lang/String;ILjava/lang/String;II)V", "getName", "()Ljava/lang/String;", "getLevel", "()I", "getLeader", "getFlagId", "getMemberCount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RatingItem {
    @SerializedName("flagid")
    private final int flagId;
    private final String leader;
    private final int level;
    @SerializedName("member_count")
    private final int memberCount;
    private final String name;

    public static /* synthetic */ RatingItem copy$default(RatingItem ratingItem, String str, int i, String str2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = ratingItem.name;
        }
        if ((i4 & 2) != 0) {
            i = ratingItem.level;
        }
        if ((i4 & 4) != 0) {
            str2 = ratingItem.leader;
        }
        if ((i4 & 8) != 0) {
            i2 = ratingItem.flagId;
        }
        if ((i4 & 16) != 0) {
            i3 = ratingItem.memberCount;
        }
        int i5 = i3;
        String str3 = str2;
        return ratingItem.copy(str, i, str3, i2, i5);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.level;
    }

    public final String component3() {
        return this.leader;
    }

    public final int component4() {
        return this.flagId;
    }

    public final int component5() {
        return this.memberCount;
    }

    public final RatingItem copy(String name, int i, String leader, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(leader, "leader");
        return new RatingItem(name, i, leader, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RatingItem) {
            RatingItem ratingItem = (RatingItem) obj;
            return Intrinsics.areEqual(this.name, ratingItem.name) && this.level == ratingItem.level && Intrinsics.areEqual(this.leader, ratingItem.leader) && this.flagId == ratingItem.flagId && this.memberCount == ratingItem.memberCount;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + Integer.hashCode(this.level)) * 31) + this.leader.hashCode()) * 31) + Integer.hashCode(this.flagId)) * 31) + Integer.hashCode(this.memberCount);
    }

    public String toString() {
        String str = this.name;
        int i = this.level;
        String str2 = this.leader;
        int i2 = this.flagId;
        return "RatingItem(name=" + str + ", level=" + i + ", leader=" + str2 + ", flagId=" + i2 + ", memberCount=" + this.memberCount + ")";
    }

    public RatingItem(String name, int i, String leader, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(leader, "leader");
        this.name = name;
        this.level = i;
        this.leader = leader;
        this.flagId = i2;
        this.memberCount = i3;
    }

    public final String getName() {
        return this.name;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getLeader() {
        return this.leader;
    }

    public final int getFlagId() {
        return this.flagId;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }
}
