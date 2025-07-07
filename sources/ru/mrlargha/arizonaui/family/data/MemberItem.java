package ru.mrlargha.arizonaui.family.data;

import com.arizona.launcher.model.settings.SettingsConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003Jc\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0019R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0019¨\u0006("}, d2 = {"Lru/mrlargha/arizonaui/family/data/MemberItem;", "", "accountId", "", "name", "", "familyId", "familyRank", "quests", "online", "warns", "isLeader", "", "isDeputy", "<init>", "(ILjava/lang/String;IIIIIZZ)V", "getAccountId", "()I", "getName", "()Ljava/lang/String;", "getFamilyId", "getFamilyRank", "getQuests", "getOnline", "getWarns", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MemberItem {
    @SerializedName("accountid")
    private final int accountId;
    @SerializedName("family_id")
    private final int familyId;
    @SerializedName("family_rank")
    private final int familyRank;
    @SerializedName("status_deputy")
    private final boolean isDeputy;
    @SerializedName("status_leader")
    private final boolean isLeader;
    @SerializedName(SettingsConstants.NICKNAME)
    private final String name;
    @SerializedName("online_status")
    private final int online;
    @SerializedName("quests")
    private final int quests;
    @SerializedName("warns")
    private final int warns;

    public static /* synthetic */ MemberItem copy$default(MemberItem memberItem, int i, String str, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = memberItem.accountId;
        }
        if ((i7 & 2) != 0) {
            str = memberItem.name;
        }
        if ((i7 & 4) != 0) {
            i2 = memberItem.familyId;
        }
        if ((i7 & 8) != 0) {
            i3 = memberItem.familyRank;
        }
        if ((i7 & 16) != 0) {
            i4 = memberItem.quests;
        }
        if ((i7 & 32) != 0) {
            i5 = memberItem.online;
        }
        if ((i7 & 64) != 0) {
            i6 = memberItem.warns;
        }
        if ((i7 & 128) != 0) {
            z = memberItem.isLeader;
        }
        if ((i7 & 256) != 0) {
            z2 = memberItem.isDeputy;
        }
        boolean z3 = z;
        boolean z4 = z2;
        int i8 = i5;
        int i9 = i6;
        int i10 = i4;
        int i11 = i2;
        return memberItem.copy(i, str, i11, i3, i10, i8, i9, z3, z4);
    }

    public final int component1() {
        return this.accountId;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.familyId;
    }

    public final int component4() {
        return this.familyRank;
    }

    public final int component5() {
        return this.quests;
    }

    public final int component6() {
        return this.online;
    }

    public final int component7() {
        return this.warns;
    }

    public final boolean component8() {
        return this.isLeader;
    }

    public final boolean component9() {
        return this.isDeputy;
    }

    public final MemberItem copy(int i, String name, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MemberItem(i, name, i2, i3, i4, i5, i6, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MemberItem) {
            MemberItem memberItem = (MemberItem) obj;
            return this.accountId == memberItem.accountId && Intrinsics.areEqual(this.name, memberItem.name) && this.familyId == memberItem.familyId && this.familyRank == memberItem.familyRank && this.quests == memberItem.quests && this.online == memberItem.online && this.warns == memberItem.warns && this.isLeader == memberItem.isLeader && this.isDeputy == memberItem.isDeputy;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.accountId) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.familyId)) * 31) + Integer.hashCode(this.familyRank)) * 31) + Integer.hashCode(this.quests)) * 31) + Integer.hashCode(this.online)) * 31) + Integer.hashCode(this.warns)) * 31) + Boolean.hashCode(this.isLeader)) * 31) + Boolean.hashCode(this.isDeputy);
    }

    public String toString() {
        int i = this.accountId;
        String str = this.name;
        int i2 = this.familyId;
        int i3 = this.familyRank;
        int i4 = this.quests;
        int i5 = this.online;
        int i6 = this.warns;
        boolean z = this.isLeader;
        return "MemberItem(accountId=" + i + ", name=" + str + ", familyId=" + i2 + ", familyRank=" + i3 + ", quests=" + i4 + ", online=" + i5 + ", warns=" + i6 + ", isLeader=" + z + ", isDeputy=" + this.isDeputy + ")";
    }

    public MemberItem(int i, String name, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.accountId = i;
        this.name = name;
        this.familyId = i2;
        this.familyRank = i3;
        this.quests = i4;
        this.online = i5;
        this.warns = i6;
        this.isLeader = z;
        this.isDeputy = z2;
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final String getName() {
        return this.name;
    }

    public final int getFamilyId() {
        return this.familyId;
    }

    public final int getFamilyRank() {
        return this.familyRank;
    }

    public final int getQuests() {
        return this.quests;
    }

    public final int getOnline() {
        return this.online;
    }

    public final int getWarns() {
        return this.warns;
    }

    public final boolean isLeader() {
        return this.isLeader;
    }

    public final boolean isDeputy() {
        return this.isDeputy;
    }
}
