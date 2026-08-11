package com.arizonagames.feature.arizona.bank;

import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\u000fHÆ\u0003Jf\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010-J\u0014\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u00020\u0005HÖ\u0081\u0004J\n\u00101\u001a\u00020\bHÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\t0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00062"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankOrganizationInfo;", "", "enable", "", "id", "", "colors", "", "", "name", "money", "", "withdrawError", "depositError", "percents", "Lcom/arizonagames/feature/arizona/bank/BankOrganizationPercents;", "<init>", "(ZLjava/lang/Integer;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/arizonagames/feature/arizona/bank/BankOrganizationPercents;)V", "getEnable", "()Z", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColors", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getMoney", "()J", "getWithdrawError", "getDepositError", "getPercents", "()Lcom/arizonagames/feature/arizona/bank/BankOrganizationPercents;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZLjava/lang/Integer;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/arizonagames/feature/arizona/bank/BankOrganizationPercents;)Lcom/arizonagames/feature/arizona/bank/BankOrganizationInfo;", "equals", "other", "hashCode", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankOrganizationInfo {
    private final List<String> colors;
    private final String depositError;
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean enable;
    private final Integer id;
    private final long money;
    private final String name;
    private final BankOrganizationPercents percents;
    private final String withdrawError;

    public BankOrganizationInfo() {
        this(false, null, null, null, 0L, null, null, null, 255, null);
    }

    public static /* synthetic */ BankOrganizationInfo copy$default(BankOrganizationInfo bankOrganizationInfo, boolean z, Integer num, List list, String str, long j, String str2, String str3, BankOrganizationPercents bankOrganizationPercents, int i, Object obj) {
        if ((i & 1) != 0) {
            z = bankOrganizationInfo.enable;
        }
        if ((i & 2) != 0) {
            num = bankOrganizationInfo.id;
        }
        List<String> list2 = list;
        if ((i & 4) != 0) {
            list2 = bankOrganizationInfo.colors;
        }
        if ((i & 8) != 0) {
            str = bankOrganizationInfo.name;
        }
        if ((i & 16) != 0) {
            j = bankOrganizationInfo.money;
        }
        if ((i & 32) != 0) {
            str2 = bankOrganizationInfo.withdrawError;
        }
        if ((i & 64) != 0) {
            str3 = bankOrganizationInfo.depositError;
        }
        if ((i & 128) != 0) {
            bankOrganizationPercents = bankOrganizationInfo.percents;
        }
        BankOrganizationPercents bankOrganizationPercents2 = bankOrganizationPercents;
        String str4 = str2;
        long j2 = j;
        List list3 = list2;
        String str5 = str;
        return bankOrganizationInfo.copy(z, num, list3, str5, j2, str4, str3, bankOrganizationPercents2);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final Integer component2() {
        return this.id;
    }

    public final List<String> component3() {
        return this.colors;
    }

    public final String component4() {
        return this.name;
    }

    public final long component5() {
        return this.money;
    }

    public final String component6() {
        return this.withdrawError;
    }

    public final String component7() {
        return this.depositError;
    }

    public final BankOrganizationPercents component8() {
        return this.percents;
    }

    public final BankOrganizationInfo copy(boolean z, Integer num, List<String> colors, String name, long j, String withdrawError, String depositError, BankOrganizationPercents percents) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(withdrawError, "withdrawError");
        Intrinsics.checkNotNullParameter(depositError, "depositError");
        Intrinsics.checkNotNullParameter(percents, "percents");
        return new BankOrganizationInfo(z, num, colors, name, j, withdrawError, depositError, percents);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankOrganizationInfo) {
            BankOrganizationInfo bankOrganizationInfo = (BankOrganizationInfo) obj;
            return this.enable == bankOrganizationInfo.enable && Intrinsics.areEqual(this.id, bankOrganizationInfo.id) && Intrinsics.areEqual(this.colors, bankOrganizationInfo.colors) && Intrinsics.areEqual(this.name, bankOrganizationInfo.name) && this.money == bankOrganizationInfo.money && Intrinsics.areEqual(this.withdrawError, bankOrganizationInfo.withdrawError) && Intrinsics.areEqual(this.depositError, bankOrganizationInfo.depositError) && Intrinsics.areEqual(this.percents, bankOrganizationInfo.percents);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.enable) * 31;
        Integer num = this.id;
        return ((((((((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.colors.hashCode()) * 31) + this.name.hashCode()) * 31) + Long.hashCode(this.money)) * 31) + this.withdrawError.hashCode()) * 31) + this.depositError.hashCode()) * 31) + this.percents.hashCode();
    }

    public String toString() {
        boolean z = this.enable;
        Integer num = this.id;
        List<String> list = this.colors;
        String str = this.name;
        long j = this.money;
        String str2 = this.withdrawError;
        String str3 = this.depositError;
        return "BankOrganizationInfo(enable=" + z + ", id=" + num + ", colors=" + list + ", name=" + str + ", money=" + j + ", withdrawError=" + str2 + ", depositError=" + str3 + ", percents=" + this.percents + ")";
    }

    public BankOrganizationInfo(boolean z, Integer num, List<String> colors, String name, long j, String withdrawError, String depositError, BankOrganizationPercents percents) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(withdrawError, "withdrawError");
        Intrinsics.checkNotNullParameter(depositError, "depositError");
        Intrinsics.checkNotNullParameter(percents, "percents");
        this.enable = z;
        this.id = num;
        this.colors = colors;
        this.name = name;
        this.money = j;
        this.withdrawError = withdrawError;
        this.depositError = depositError;
        this.percents = percents;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final Integer getId() {
        return this.id;
    }

    public /* synthetic */ BankOrganizationInfo(boolean z, Integer num, List list, String str, long j, String str2, String str3, BankOrganizationPercents bankOrganizationPercents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? 0L : j, (i & 32) != 0 ? "" : str2, (i & 64) != 0 ? "" : str3, (i & 128) != 0 ? new BankOrganizationPercents(0, 0, 3, null) : bankOrganizationPercents);
    }

    public final List<String> getColors() {
        return this.colors;
    }

    public final String getName() {
        return this.name;
    }

    public final long getMoney() {
        return this.money;
    }

    public final String getWithdrawError() {
        return this.withdrawError;
    }

    public final String getDepositError() {
        return this.depositError;
    }

    public final BankOrganizationPercents getPercents() {
        return this.percents;
    }
}
