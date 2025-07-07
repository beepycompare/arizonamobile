package ru.mrlargha.arizonaui.family.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FamilyData.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0004\b!\u0010\"J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\u0006HÆ\u0003J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\t\u0010R\u001a\u00020\u0006HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\u000f\u0010[\u001a\b\u0012\u0004\u0012\u00020 0\u001fHÆ\u0003J\u009d\u0002\u0010\\\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fHÆ\u0001J\u0013\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010`\u001a\u00020\u0003HÖ\u0001J\t\u0010a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010$R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010$R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006b"}, d2 = {"Lru/mrlargha/arizonaui/family/data/FamilyData;", "", "id", "", "management", "title", "", "type", "desc", "message", "bg", "icon", "reputation", "evil", "money", "coins", "deposit", "payDay", "flag", "fraction", "aliance", "apart", "verification", "brand", "discord", FirebaseAnalytics.Param.LEVEL, "currentExp", "totalExp", "hasEstate", "online", "leaders", "", "Lru/mrlargha/arizonaui/family/data/Leader;", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;IIIIILjava/util/List;)V", "getId", "()I", "getManagement", "getTitle", "()Ljava/lang/String;", "getType", "getDesc", "getMessage", "getBg", "getIcon", "getReputation", "getEvil", "getMoney", "getCoins", "getDeposit", "getPayDay", "getFlag", "getFraction", "getAliance", "getApart", "getVerification", "getBrand", "getDiscord", "getLevel", "getCurrentExp", "getTotalExp", "getHasEstate", "getOnline", "getLeaders", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyData {
    private final String aliance;
    private final String apart;
    private final int bg;
    private final int brand;
    private final int coins;
    private final int currentExp;
    private final int deposit;
    private final String desc;
    private final String discord;
    private final int evil;
    private final String flag;
    private final String fraction;
    private final int hasEstate;
    private final int icon;
    private final int id;
    private final List<Leader> leaders;
    private final int level;
    private final int management;
    private final String message;
    private final int money;
    private final int online;
    private final int payDay;
    private final int reputation;
    private final String title;
    private final int totalExp;
    private final String type;
    private final int verification;

    public static /* synthetic */ FamilyData copy$default(FamilyData familyData, int i, int i2, String str, String str2, String str3, String str4, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, String str5, String str6, String str7, String str8, int i11, int i12, String str9, int i13, int i14, int i15, int i16, int i17, List list, int i18, Object obj) {
        List<Leader> list2;
        int i19;
        int i20 = (i18 & 1) != 0 ? familyData.id : i;
        int i21 = (i18 & 2) != 0 ? familyData.management : i2;
        String str10 = (i18 & 4) != 0 ? familyData.title : str;
        String str11 = (i18 & 8) != 0 ? familyData.type : str2;
        String str12 = (i18 & 16) != 0 ? familyData.desc : str3;
        String str13 = (i18 & 32) != 0 ? familyData.message : str4;
        int i22 = (i18 & 64) != 0 ? familyData.bg : i3;
        int i23 = (i18 & 128) != 0 ? familyData.icon : i4;
        int i24 = (i18 & 256) != 0 ? familyData.reputation : i5;
        int i25 = (i18 & 512) != 0 ? familyData.evil : i6;
        int i26 = (i18 & 1024) != 0 ? familyData.money : i7;
        int i27 = (i18 & 2048) != 0 ? familyData.coins : i8;
        int i28 = (i18 & 4096) != 0 ? familyData.deposit : i9;
        int i29 = (i18 & 8192) != 0 ? familyData.payDay : i10;
        int i30 = i20;
        String str14 = (i18 & 16384) != 0 ? familyData.flag : str5;
        String str15 = (i18 & 32768) != 0 ? familyData.fraction : str6;
        String str16 = (i18 & 65536) != 0 ? familyData.aliance : str7;
        String str17 = (i18 & 131072) != 0 ? familyData.apart : str8;
        int i31 = (i18 & 262144) != 0 ? familyData.verification : i11;
        int i32 = (i18 & 524288) != 0 ? familyData.brand : i12;
        String str18 = (i18 & 1048576) != 0 ? familyData.discord : str9;
        int i33 = (i18 & 2097152) != 0 ? familyData.level : i13;
        int i34 = (i18 & 4194304) != 0 ? familyData.currentExp : i14;
        int i35 = (i18 & 8388608) != 0 ? familyData.totalExp : i15;
        int i36 = (i18 & 16777216) != 0 ? familyData.hasEstate : i16;
        int i37 = (i18 & 33554432) != 0 ? familyData.online : i17;
        if ((i18 & 67108864) != 0) {
            i19 = i37;
            list2 = familyData.leaders;
        } else {
            list2 = list;
            i19 = i37;
        }
        return familyData.copy(i30, i21, str10, str11, str12, str13, i22, i23, i24, i25, i26, i27, i28, i29, str14, str15, str16, str17, i31, i32, str18, i33, i34, i35, i36, i19, list2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component10() {
        return this.evil;
    }

    public final int component11() {
        return this.money;
    }

    public final int component12() {
        return this.coins;
    }

    public final int component13() {
        return this.deposit;
    }

    public final int component14() {
        return this.payDay;
    }

    public final String component15() {
        return this.flag;
    }

    public final String component16() {
        return this.fraction;
    }

    public final String component17() {
        return this.aliance;
    }

    public final String component18() {
        return this.apart;
    }

    public final int component19() {
        return this.verification;
    }

    public final int component2() {
        return this.management;
    }

    public final int component20() {
        return this.brand;
    }

    public final String component21() {
        return this.discord;
    }

    public final int component22() {
        return this.level;
    }

    public final int component23() {
        return this.currentExp;
    }

    public final int component24() {
        return this.totalExp;
    }

    public final int component25() {
        return this.hasEstate;
    }

    public final int component26() {
        return this.online;
    }

    public final List<Leader> component27() {
        return this.leaders;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.desc;
    }

    public final String component6() {
        return this.message;
    }

    public final int component7() {
        return this.bg;
    }

    public final int component8() {
        return this.icon;
    }

    public final int component9() {
        return this.reputation;
    }

    public final FamilyData copy(int i, int i2, String title, String type, String desc, String message, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, String flag, String fraction, String aliance, String apart, int i11, int i12, String discord, int i13, int i14, int i15, int i16, int i17, List<Leader> leaders) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(flag, "flag");
        Intrinsics.checkNotNullParameter(fraction, "fraction");
        Intrinsics.checkNotNullParameter(aliance, "aliance");
        Intrinsics.checkNotNullParameter(apart, "apart");
        Intrinsics.checkNotNullParameter(discord, "discord");
        Intrinsics.checkNotNullParameter(leaders, "leaders");
        return new FamilyData(i, i2, title, type, desc, message, i3, i4, i5, i6, i7, i8, i9, i10, flag, fraction, aliance, apart, i11, i12, discord, i13, i14, i15, i16, i17, leaders);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilyData) {
            FamilyData familyData = (FamilyData) obj;
            return this.id == familyData.id && this.management == familyData.management && Intrinsics.areEqual(this.title, familyData.title) && Intrinsics.areEqual(this.type, familyData.type) && Intrinsics.areEqual(this.desc, familyData.desc) && Intrinsics.areEqual(this.message, familyData.message) && this.bg == familyData.bg && this.icon == familyData.icon && this.reputation == familyData.reputation && this.evil == familyData.evil && this.money == familyData.money && this.coins == familyData.coins && this.deposit == familyData.deposit && this.payDay == familyData.payDay && Intrinsics.areEqual(this.flag, familyData.flag) && Intrinsics.areEqual(this.fraction, familyData.fraction) && Intrinsics.areEqual(this.aliance, familyData.aliance) && Intrinsics.areEqual(this.apart, familyData.apart) && this.verification == familyData.verification && this.brand == familyData.brand && Intrinsics.areEqual(this.discord, familyData.discord) && this.level == familyData.level && this.currentExp == familyData.currentExp && this.totalExp == familyData.totalExp && this.hasEstate == familyData.hasEstate && this.online == familyData.online && Intrinsics.areEqual(this.leaders, familyData.leaders);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.management)) * 31) + this.title.hashCode()) * 31) + this.type.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.message.hashCode()) * 31) + Integer.hashCode(this.bg)) * 31) + Integer.hashCode(this.icon)) * 31) + Integer.hashCode(this.reputation)) * 31) + Integer.hashCode(this.evil)) * 31) + Integer.hashCode(this.money)) * 31) + Integer.hashCode(this.coins)) * 31) + Integer.hashCode(this.deposit)) * 31) + Integer.hashCode(this.payDay)) * 31) + this.flag.hashCode()) * 31) + this.fraction.hashCode()) * 31) + this.aliance.hashCode()) * 31) + this.apart.hashCode()) * 31) + Integer.hashCode(this.verification)) * 31) + Integer.hashCode(this.brand)) * 31) + this.discord.hashCode()) * 31) + Integer.hashCode(this.level)) * 31) + Integer.hashCode(this.currentExp)) * 31) + Integer.hashCode(this.totalExp)) * 31) + Integer.hashCode(this.hasEstate)) * 31) + Integer.hashCode(this.online)) * 31) + this.leaders.hashCode();
    }

    public String toString() {
        int i = this.id;
        int i2 = this.management;
        String str = this.title;
        String str2 = this.type;
        String str3 = this.desc;
        String str4 = this.message;
        int i3 = this.bg;
        int i4 = this.icon;
        int i5 = this.reputation;
        int i6 = this.evil;
        int i7 = this.money;
        int i8 = this.coins;
        int i9 = this.deposit;
        int i10 = this.payDay;
        String str5 = this.flag;
        String str6 = this.fraction;
        String str7 = this.aliance;
        String str8 = this.apart;
        int i11 = this.verification;
        int i12 = this.brand;
        String str9 = this.discord;
        int i13 = this.level;
        int i14 = this.currentExp;
        int i15 = this.totalExp;
        int i16 = this.hasEstate;
        int i17 = this.online;
        return "FamilyData(id=" + i + ", management=" + i2 + ", title=" + str + ", type=" + str2 + ", desc=" + str3 + ", message=" + str4 + ", bg=" + i3 + ", icon=" + i4 + ", reputation=" + i5 + ", evil=" + i6 + ", money=" + i7 + ", coins=" + i8 + ", deposit=" + i9 + ", payDay=" + i10 + ", flag=" + str5 + ", fraction=" + str6 + ", aliance=" + str7 + ", apart=" + str8 + ", verification=" + i11 + ", brand=" + i12 + ", discord=" + str9 + ", level=" + i13 + ", currentExp=" + i14 + ", totalExp=" + i15 + ", hasEstate=" + i16 + ", online=" + i17 + ", leaders=" + this.leaders + ")";
    }

    public FamilyData(int i, int i2, String title, String type, String desc, String message, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, String flag, String fraction, String aliance, String apart, int i11, int i12, String discord, int i13, int i14, int i15, int i16, int i17, List<Leader> leaders) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(flag, "flag");
        Intrinsics.checkNotNullParameter(fraction, "fraction");
        Intrinsics.checkNotNullParameter(aliance, "aliance");
        Intrinsics.checkNotNullParameter(apart, "apart");
        Intrinsics.checkNotNullParameter(discord, "discord");
        Intrinsics.checkNotNullParameter(leaders, "leaders");
        this.id = i;
        this.management = i2;
        this.title = title;
        this.type = type;
        this.desc = desc;
        this.message = message;
        this.bg = i3;
        this.icon = i4;
        this.reputation = i5;
        this.evil = i6;
        this.money = i7;
        this.coins = i8;
        this.deposit = i9;
        this.payDay = i10;
        this.flag = flag;
        this.fraction = fraction;
        this.aliance = aliance;
        this.apart = apart;
        this.verification = i11;
        this.brand = i12;
        this.discord = discord;
        this.level = i13;
        this.currentExp = i14;
        this.totalExp = i15;
        this.hasEstate = i16;
        this.online = i17;
        this.leaders = leaders;
    }

    public final int getId() {
        return this.id;
    }

    public final int getManagement() {
        return this.management;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getBg() {
        return this.bg;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getReputation() {
        return this.reputation;
    }

    public final int getEvil() {
        return this.evil;
    }

    public final int getMoney() {
        return this.money;
    }

    public final int getCoins() {
        return this.coins;
    }

    public final int getDeposit() {
        return this.deposit;
    }

    public final int getPayDay() {
        return this.payDay;
    }

    public final String getFlag() {
        return this.flag;
    }

    public final String getFraction() {
        return this.fraction;
    }

    public final String getAliance() {
        return this.aliance;
    }

    public final String getApart() {
        return this.apart;
    }

    public final int getVerification() {
        return this.verification;
    }

    public final int getBrand() {
        return this.brand;
    }

    public final String getDiscord() {
        return this.discord;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getCurrentExp() {
        return this.currentExp;
    }

    public final int getTotalExp() {
        return this.totalExp;
    }

    public final int getHasEstate() {
        return this.hasEstate;
    }

    public final int getOnline() {
        return this.online;
    }

    public final List<Leader> getLeaders() {
        return this.leaders;
    }
}
