package com.arizonagames.feature.arizona.family.data;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FamilyData.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bï\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\b#\u0010$J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0006HÆ\u0003J\t\u0010J\u001a\u00020\u0006HÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J\t\u0010L\u001a\u00020\u0006HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u000fHÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\t\u0010V\u001a\u00020\u0006HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\u0006HÆ\u0003J\t\u0010Y\u001a\u00020\u000fHÆ\u0003J\t\u0010Z\u001a\u00020\u000fHÆ\u0003J\t\u0010[\u001a\u00020\u0006HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010CJ\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\"0!HÆ\u0003J®\u0002\u0010c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!HÆ\u0001¢\u0006\u0002\u0010dJ\u0014\u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010h\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010i\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)R\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b9\u0010)R\u0011\u0010\u0017\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b:\u00102R\u0011\u0010\u0018\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b;\u00102R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010&R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010&R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010&R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010&R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010D\u001a\u0004\bB\u0010CR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006j"}, d2 = {"Lcom/arizonagames/feature/arizona/family/data/FamilyData;", "", "id", "", "management", "title", "", "type", "desc", "message", "bg", "icon", "reputation", "evil", "money", "", "coins", "deposit", "payDay", "flag", "fraction", "aliance", "apart", "verification", "brand", "discord", FirebaseAnalytics.Param.LEVEL, "currentExp", "totalExp", "hasEstate", "online", "members", "leaders", "", "Lcom/arizonagames/feature/arizona/family/data/Leader;", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIJIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;IIIIILjava/lang/Integer;Ljava/util/List;)V", "getId", "()I", "getManagement", "getTitle", "()Ljava/lang/String;", "getType", "getDesc", "getMessage", "getBg", "getIcon", "getReputation", "getEvil", "getMoney", "()J", "getCoins", "getDeposit", "getPayDay", "getFlag", "getFraction", "getAliance", "getApart", "getVerification", "getBrand", "getDiscord", "getLevel", "getCurrentExp", "getTotalExp", "getHasEstate", "getOnline", "getMembers", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLeaders", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIJIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;IIIIILjava/lang/Integer;Ljava/util/List;)Lcom/arizonagames/feature/arizona/family/data/FamilyData;", "equals", "", "other", "hashCode", "toString", "family"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FamilyData {
    private final String aliance;
    private final String apart;
    private final int bg;
    private final long brand;
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
    private final Integer members;
    private final String message;
    private final long money;
    private final int online;
    private final int payDay;
    private final int reputation;
    private final String title;
    private final int totalExp;
    private final String type;
    private final long verification;

    public static /* synthetic */ FamilyData copy$default(FamilyData familyData, int i, int i2, String str, String str2, String str3, String str4, int i3, int i4, int i5, int i6, long j, int i7, int i8, int i9, String str5, String str6, String str7, String str8, long j2, long j3, String str9, int i10, int i11, int i12, int i13, int i14, Integer num, List list, int i15, Object obj) {
        List<Leader> list2;
        Integer num2;
        int i16;
        String str10;
        String str11;
        String str12;
        String str13;
        long j4;
        long j5;
        String str14;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        String str15;
        String str16;
        String str17;
        String str18;
        int i23;
        int i24;
        int i25;
        int i26;
        long j6;
        int i27;
        int i28;
        int i29 = (i15 & 1) != 0 ? familyData.id : i;
        int i30 = (i15 & 2) != 0 ? familyData.management : i2;
        String str19 = (i15 & 4) != 0 ? familyData.title : str;
        String str20 = (i15 & 8) != 0 ? familyData.type : str2;
        String str21 = (i15 & 16) != 0 ? familyData.desc : str3;
        String str22 = (i15 & 32) != 0 ? familyData.message : str4;
        int i31 = (i15 & 64) != 0 ? familyData.bg : i3;
        int i32 = (i15 & 128) != 0 ? familyData.icon : i4;
        int i33 = (i15 & 256) != 0 ? familyData.reputation : i5;
        int i34 = (i15 & 512) != 0 ? familyData.evil : i6;
        long j7 = (i15 & 1024) != 0 ? familyData.money : j;
        int i35 = (i15 & 2048) != 0 ? familyData.coins : i7;
        int i36 = (i15 & 4096) != 0 ? familyData.deposit : i8;
        int i37 = i29;
        int i38 = (i15 & 8192) != 0 ? familyData.payDay : i9;
        String str23 = (i15 & 16384) != 0 ? familyData.flag : str5;
        String str24 = (i15 & 32768) != 0 ? familyData.fraction : str6;
        String str25 = (i15 & 65536) != 0 ? familyData.aliance : str7;
        String str26 = (i15 & 131072) != 0 ? familyData.apart : str8;
        String str27 = str23;
        long j8 = (i15 & 262144) != 0 ? familyData.verification : j2;
        long j9 = (i15 & 524288) != 0 ? familyData.brand : j3;
        String str28 = (i15 & 1048576) != 0 ? familyData.discord : str9;
        int i39 = (i15 & 2097152) != 0 ? familyData.level : i10;
        String str29 = str28;
        int i40 = (i15 & 4194304) != 0 ? familyData.currentExp : i11;
        int i41 = (i15 & 8388608) != 0 ? familyData.totalExp : i12;
        int i42 = (i15 & 16777216) != 0 ? familyData.hasEstate : i13;
        int i43 = (i15 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? familyData.online : i14;
        Integer num3 = (i15 & 67108864) != 0 ? familyData.members : num;
        if ((i15 & 134217728) != 0) {
            num2 = num3;
            list2 = familyData.leaders;
            str10 = str24;
            str11 = str25;
            str12 = str27;
            str13 = str26;
            j4 = j8;
            j5 = j9;
            str14 = str29;
            i17 = i40;
            i18 = i41;
            i19 = i42;
            i20 = i43;
            i21 = i39;
            i22 = i30;
            str15 = str19;
            str16 = str20;
            str17 = str21;
            str18 = str22;
            i23 = i31;
            i24 = i32;
            i25 = i33;
            i26 = i34;
            j6 = j7;
            i27 = i35;
            i28 = i36;
            i16 = i38;
        } else {
            list2 = list;
            num2 = num3;
            i16 = i38;
            str10 = str24;
            str11 = str25;
            str12 = str27;
            str13 = str26;
            j4 = j8;
            j5 = j9;
            str14 = str29;
            i17 = i40;
            i18 = i41;
            i19 = i42;
            i20 = i43;
            i21 = i39;
            i22 = i30;
            str15 = str19;
            str16 = str20;
            str17 = str21;
            str18 = str22;
            i23 = i31;
            i24 = i32;
            i25 = i33;
            i26 = i34;
            j6 = j7;
            i27 = i35;
            i28 = i36;
        }
        return familyData.copy(i37, i22, str15, str16, str17, str18, i23, i24, i25, i26, j6, i27, i28, i16, str12, str10, str11, str13, j4, j5, str14, i21, i17, i18, i19, i20, num2, list2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component10() {
        return this.evil;
    }

    public final long component11() {
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

    public final long component19() {
        return this.verification;
    }

    public final int component2() {
        return this.management;
    }

    public final long component20() {
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

    public final Integer component27() {
        return this.members;
    }

    public final List<Leader> component28() {
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

    public final FamilyData copy(int i, int i2, String title, String type, String desc, String message, int i3, int i4, int i5, int i6, long j, int i7, int i8, int i9, String flag, String fraction, String aliance, String apart, long j2, long j3, String discord, int i10, int i11, int i12, int i13, int i14, Integer num, List<Leader> leaders) {
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
        return new FamilyData(i, i2, title, type, desc, message, i3, i4, i5, i6, j, i7, i8, i9, flag, fraction, aliance, apart, j2, j3, discord, i10, i11, i12, i13, i14, num, leaders);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilyData) {
            FamilyData familyData = (FamilyData) obj;
            return this.id == familyData.id && this.management == familyData.management && Intrinsics.areEqual(this.title, familyData.title) && Intrinsics.areEqual(this.type, familyData.type) && Intrinsics.areEqual(this.desc, familyData.desc) && Intrinsics.areEqual(this.message, familyData.message) && this.bg == familyData.bg && this.icon == familyData.icon && this.reputation == familyData.reputation && this.evil == familyData.evil && this.money == familyData.money && this.coins == familyData.coins && this.deposit == familyData.deposit && this.payDay == familyData.payDay && Intrinsics.areEqual(this.flag, familyData.flag) && Intrinsics.areEqual(this.fraction, familyData.fraction) && Intrinsics.areEqual(this.aliance, familyData.aliance) && Intrinsics.areEqual(this.apart, familyData.apart) && this.verification == familyData.verification && this.brand == familyData.brand && Intrinsics.areEqual(this.discord, familyData.discord) && this.level == familyData.level && this.currentExp == familyData.currentExp && this.totalExp == familyData.totalExp && this.hasEstate == familyData.hasEstate && this.online == familyData.online && Intrinsics.areEqual(this.members, familyData.members) && Intrinsics.areEqual(this.leaders, familyData.leaders);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.management)) * 31) + this.title.hashCode()) * 31) + this.type.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.message.hashCode()) * 31) + Integer.hashCode(this.bg)) * 31) + Integer.hashCode(this.icon)) * 31) + Integer.hashCode(this.reputation)) * 31) + Integer.hashCode(this.evil)) * 31) + Long.hashCode(this.money)) * 31) + Integer.hashCode(this.coins)) * 31) + Integer.hashCode(this.deposit)) * 31) + Integer.hashCode(this.payDay)) * 31) + this.flag.hashCode()) * 31) + this.fraction.hashCode()) * 31) + this.aliance.hashCode()) * 31) + this.apart.hashCode()) * 31) + Long.hashCode(this.verification)) * 31) + Long.hashCode(this.brand)) * 31) + this.discord.hashCode()) * 31) + Integer.hashCode(this.level)) * 31) + Integer.hashCode(this.currentExp)) * 31) + Integer.hashCode(this.totalExp)) * 31) + Integer.hashCode(this.hasEstate)) * 31) + Integer.hashCode(this.online)) * 31;
        Integer num = this.members;
        return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.leaders.hashCode();
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
        long j = this.money;
        int i7 = this.coins;
        int i8 = this.deposit;
        int i9 = this.payDay;
        String str5 = this.flag;
        String str6 = this.fraction;
        String str7 = this.aliance;
        String str8 = this.apart;
        long j2 = this.verification;
        long j3 = this.brand;
        String str9 = this.discord;
        int i10 = this.level;
        int i11 = this.currentExp;
        int i12 = this.totalExp;
        int i13 = this.hasEstate;
        int i14 = this.online;
        Integer num = this.members;
        return "FamilyData(id=" + i + ", management=" + i2 + ", title=" + str + ", type=" + str2 + ", desc=" + str3 + ", message=" + str4 + ", bg=" + i3 + ", icon=" + i4 + ", reputation=" + i5 + ", evil=" + i6 + ", money=" + j + ", coins=" + i7 + ", deposit=" + i8 + ", payDay=" + i9 + ", flag=" + str5 + ", fraction=" + str6 + ", aliance=" + str7 + ", apart=" + str8 + ", verification=" + j2 + ", brand=" + j3 + ", discord=" + str9 + ", level=" + i10 + ", currentExp=" + i11 + ", totalExp=" + i12 + ", hasEstate=" + i13 + ", online=" + i14 + ", members=" + num + ", leaders=" + this.leaders + ")";
    }

    public FamilyData(int i, int i2, String title, String type, String desc, String message, int i3, int i4, int i5, int i6, long j, int i7, int i8, int i9, String flag, String fraction, String aliance, String apart, long j2, long j3, String discord, int i10, int i11, int i12, int i13, int i14, Integer num, List<Leader> leaders) {
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
        this.money = j;
        this.coins = i7;
        this.deposit = i8;
        this.payDay = i9;
        this.flag = flag;
        this.fraction = fraction;
        this.aliance = aliance;
        this.apart = apart;
        this.verification = j2;
        this.brand = j3;
        this.discord = discord;
        this.level = i10;
        this.currentExp = i11;
        this.totalExp = i12;
        this.hasEstate = i13;
        this.online = i14;
        this.members = num;
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

    public final long getMoney() {
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

    public final long getVerification() {
        return this.verification;
    }

    public final long getBrand() {
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

    public final Integer getMembers() {
        return this.members;
    }

    public final List<Leader> getLeaders() {
        return this.leaders;
    }
}
