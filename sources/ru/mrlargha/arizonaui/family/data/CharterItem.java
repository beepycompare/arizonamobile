package ru.mrlargha.arizonaui.family.data;

import com.arizona.launcher.model.settings.SettingsConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: data.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fHÆ\u0001J\u0013\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001aR\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001a¨\u0006*"}, d2 = {"Lru/mrlargha/arizonaui/family/data/CharterItem;", "", "accountId", "", "name", "", "online", "fractionRank", "fractionDays", "paidDays", "weeklyActive", "isPaidRank", "", "isLeader", "isDeputy", "<init>", "(ILjava/lang/String;IIIIIZZZ)V", "getAccountId", "()I", "getName", "()Ljava/lang/String;", "getOnline", "getFractionRank", "getFractionDays", "getPaidDays", "getWeeklyActive", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CharterItem {
    @SerializedName("accountid")
    private final int accountId;
    @SerializedName("fraction_days")
    private final int fractionDays;
    @SerializedName("fraction_rank")
    private final int fractionRank;
    @SerializedName("status_deputy")
    private final boolean isDeputy;
    @SerializedName("status_leader")
    private final boolean isLeader;
    @SerializedName("paid_rank_status")
    private final boolean isPaidRank;
    @SerializedName(SettingsConstants.NICKNAME)
    private final String name;
    @SerializedName("online_status")
    private final int online;
    @SerializedName("paid_rank_days")
    private final int paidDays;
    @SerializedName("weekly_active")
    private final int weeklyActive;

    public static /* synthetic */ CharterItem copy$default(CharterItem charterItem, int i, String str, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = charterItem.accountId;
        }
        if ((i7 & 2) != 0) {
            str = charterItem.name;
        }
        if ((i7 & 4) != 0) {
            i2 = charterItem.online;
        }
        if ((i7 & 8) != 0) {
            i3 = charterItem.fractionRank;
        }
        if ((i7 & 16) != 0) {
            i4 = charterItem.fractionDays;
        }
        if ((i7 & 32) != 0) {
            i5 = charterItem.paidDays;
        }
        if ((i7 & 64) != 0) {
            i6 = charterItem.weeklyActive;
        }
        if ((i7 & 128) != 0) {
            z = charterItem.isPaidRank;
        }
        if ((i7 & 256) != 0) {
            z2 = charterItem.isLeader;
        }
        if ((i7 & 512) != 0) {
            z3 = charterItem.isDeputy;
        }
        boolean z4 = z2;
        boolean z5 = z3;
        int i8 = i6;
        boolean z6 = z;
        int i9 = i4;
        int i10 = i5;
        return charterItem.copy(i, str, i2, i3, i9, i10, i8, z6, z4, z5);
    }

    public final int component1() {
        return this.accountId;
    }

    public final boolean component10() {
        return this.isDeputy;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.online;
    }

    public final int component4() {
        return this.fractionRank;
    }

    public final int component5() {
        return this.fractionDays;
    }

    public final int component6() {
        return this.paidDays;
    }

    public final int component7() {
        return this.weeklyActive;
    }

    public final boolean component8() {
        return this.isPaidRank;
    }

    public final boolean component9() {
        return this.isLeader;
    }

    public final CharterItem copy(int i, String name, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new CharterItem(i, name, i2, i3, i4, i5, i6, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CharterItem) {
            CharterItem charterItem = (CharterItem) obj;
            return this.accountId == charterItem.accountId && Intrinsics.areEqual(this.name, charterItem.name) && this.online == charterItem.online && this.fractionRank == charterItem.fractionRank && this.fractionDays == charterItem.fractionDays && this.paidDays == charterItem.paidDays && this.weeklyActive == charterItem.weeklyActive && this.isPaidRank == charterItem.isPaidRank && this.isLeader == charterItem.isLeader && this.isDeputy == charterItem.isDeputy;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((Integer.hashCode(this.accountId) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.online)) * 31) + Integer.hashCode(this.fractionRank)) * 31) + Integer.hashCode(this.fractionDays)) * 31) + Integer.hashCode(this.paidDays)) * 31) + Integer.hashCode(this.weeklyActive)) * 31) + Boolean.hashCode(this.isPaidRank)) * 31) + Boolean.hashCode(this.isLeader)) * 31) + Boolean.hashCode(this.isDeputy);
    }

    public String toString() {
        int i = this.accountId;
        String str = this.name;
        int i2 = this.online;
        int i3 = this.fractionRank;
        int i4 = this.fractionDays;
        int i5 = this.paidDays;
        int i6 = this.weeklyActive;
        boolean z = this.isPaidRank;
        boolean z2 = this.isLeader;
        return "CharterItem(accountId=" + i + ", name=" + str + ", online=" + i2 + ", fractionRank=" + i3 + ", fractionDays=" + i4 + ", paidDays=" + i5 + ", weeklyActive=" + i6 + ", isPaidRank=" + z + ", isLeader=" + z2 + ", isDeputy=" + this.isDeputy + ")";
    }

    public CharterItem(int i, String name, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.accountId = i;
        this.name = name;
        this.online = i2;
        this.fractionRank = i3;
        this.fractionDays = i4;
        this.paidDays = i5;
        this.weeklyActive = i6;
        this.isPaidRank = z;
        this.isLeader = z2;
        this.isDeputy = z3;
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final String getName() {
        return this.name;
    }

    public final int getOnline() {
        return this.online;
    }

    public final int getFractionRank() {
        return this.fractionRank;
    }

    public final int getFractionDays() {
        return this.fractionDays;
    }

    public final int getPaidDays() {
        return this.paidDays;
    }

    public final int getWeeklyActive() {
        return this.weeklyActive;
    }

    public final boolean isPaidRank() {
        return this.isPaidRank;
    }

    public final boolean isLeader() {
        return this.isLeader;
    }

    public final boolean isDeputy() {
        return this.isDeputy;
    }
}
