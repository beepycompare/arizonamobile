package ru.mrlargha.arizonaui.family.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MapData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0013HÆ\u0003J\t\u0010?\u001a\u00020\u0013HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003JÇ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0003HÆ\u0001J\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u0003HÖ\u0001J\t\u0010H\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001b¨\u0006I"}, d2 = {"Lru/mrlargha/arizonaui/family/data/CapturesItem;", "", "family_id", "", "family_db_id", "family_name", "", "family_color", "family_flag", "attack_family_id", "attack_family_db_id", "attack_family_name", "attack_family_color", "attack_family_flag", "attack_month", "attack_day", "attack_hour", "attack_minute", "date_attack_unix", "", "date_capture", "family_moneta", "family_money", "capture_id_zone", "<init>", "(IILjava/lang/String;IIIILjava/lang/String;IIIIIIJJIII)V", "getFamily_id", "()I", "getFamily_db_id", "getFamily_name", "()Ljava/lang/String;", "getFamily_color", "getFamily_flag", "getAttack_family_id", "getAttack_family_db_id", "getAttack_family_name", "getAttack_family_color", "getAttack_family_flag", "getAttack_month", "getAttack_day", "getAttack_hour", "getAttack_minute", "getDate_attack_unix", "()J", "getDate_capture", "getFamily_moneta", "getFamily_money", "getCapture_id_zone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CapturesItem {
    private final int attack_day;
    private final int attack_family_color;
    private final int attack_family_db_id;
    private final int attack_family_flag;
    private final int attack_family_id;
    private final String attack_family_name;
    private final int attack_hour;
    private final int attack_minute;
    private final int attack_month;
    private final int capture_id_zone;
    private final long date_attack_unix;
    private final long date_capture;
    private final int family_color;
    private final int family_db_id;
    private final int family_flag;
    private final int family_id;
    private final int family_moneta;
    private final int family_money;
    private final String family_name;

    public static /* synthetic */ CapturesItem copy$default(CapturesItem capturesItem, int i, int i2, String str, int i3, int i4, int i5, int i6, String str2, int i7, int i8, int i9, int i10, int i11, int i12, long j, long j2, int i13, int i14, int i15, int i16, Object obj) {
        int i17;
        int i18;
        int i19 = (i16 & 1) != 0 ? capturesItem.family_id : i;
        int i20 = (i16 & 2) != 0 ? capturesItem.family_db_id : i2;
        String str3 = (i16 & 4) != 0 ? capturesItem.family_name : str;
        int i21 = (i16 & 8) != 0 ? capturesItem.family_color : i3;
        int i22 = (i16 & 16) != 0 ? capturesItem.family_flag : i4;
        int i23 = (i16 & 32) != 0 ? capturesItem.attack_family_id : i5;
        int i24 = (i16 & 64) != 0 ? capturesItem.attack_family_db_id : i6;
        String str4 = (i16 & 128) != 0 ? capturesItem.attack_family_name : str2;
        int i25 = (i16 & 256) != 0 ? capturesItem.attack_family_color : i7;
        int i26 = (i16 & 512) != 0 ? capturesItem.attack_family_flag : i8;
        int i27 = (i16 & 1024) != 0 ? capturesItem.attack_month : i9;
        int i28 = (i16 & 2048) != 0 ? capturesItem.attack_day : i10;
        int i29 = (i16 & 4096) != 0 ? capturesItem.attack_hour : i11;
        int i30 = (i16 & 8192) != 0 ? capturesItem.attack_minute : i12;
        int i31 = i19;
        long j3 = (i16 & 16384) != 0 ? capturesItem.date_attack_unix : j;
        long j4 = (i16 & 32768) != 0 ? capturesItem.date_capture : j2;
        int i32 = (i16 & 65536) != 0 ? capturesItem.family_moneta : i13;
        int i33 = (i16 & 131072) != 0 ? capturesItem.family_money : i14;
        if ((i16 & 262144) != 0) {
            i18 = i32;
            i17 = capturesItem.capture_id_zone;
        } else {
            i17 = i15;
            i18 = i32;
        }
        return capturesItem.copy(i31, i20, str3, i21, i22, i23, i24, str4, i25, i26, i27, i28, i29, i30, j3, j4, i18, i33, i17);
    }

    public final int component1() {
        return this.family_id;
    }

    public final int component10() {
        return this.attack_family_flag;
    }

    public final int component11() {
        return this.attack_month;
    }

    public final int component12() {
        return this.attack_day;
    }

    public final int component13() {
        return this.attack_hour;
    }

    public final int component14() {
        return this.attack_minute;
    }

    public final long component15() {
        return this.date_attack_unix;
    }

    public final long component16() {
        return this.date_capture;
    }

    public final int component17() {
        return this.family_moneta;
    }

    public final int component18() {
        return this.family_money;
    }

    public final int component19() {
        return this.capture_id_zone;
    }

    public final int component2() {
        return this.family_db_id;
    }

    public final String component3() {
        return this.family_name;
    }

    public final int component4() {
        return this.family_color;
    }

    public final int component5() {
        return this.family_flag;
    }

    public final int component6() {
        return this.attack_family_id;
    }

    public final int component7() {
        return this.attack_family_db_id;
    }

    public final String component8() {
        return this.attack_family_name;
    }

    public final int component9() {
        return this.attack_family_color;
    }

    public final CapturesItem copy(int i, int i2, String family_name, int i3, int i4, int i5, int i6, String attack_family_name, int i7, int i8, int i9, int i10, int i11, int i12, long j, long j2, int i13, int i14, int i15) {
        Intrinsics.checkNotNullParameter(family_name, "family_name");
        Intrinsics.checkNotNullParameter(attack_family_name, "attack_family_name");
        return new CapturesItem(i, i2, family_name, i3, i4, i5, i6, attack_family_name, i7, i8, i9, i10, i11, i12, j, j2, i13, i14, i15);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CapturesItem) {
            CapturesItem capturesItem = (CapturesItem) obj;
            return this.family_id == capturesItem.family_id && this.family_db_id == capturesItem.family_db_id && Intrinsics.areEqual(this.family_name, capturesItem.family_name) && this.family_color == capturesItem.family_color && this.family_flag == capturesItem.family_flag && this.attack_family_id == capturesItem.attack_family_id && this.attack_family_db_id == capturesItem.attack_family_db_id && Intrinsics.areEqual(this.attack_family_name, capturesItem.attack_family_name) && this.attack_family_color == capturesItem.attack_family_color && this.attack_family_flag == capturesItem.attack_family_flag && this.attack_month == capturesItem.attack_month && this.attack_day == capturesItem.attack_day && this.attack_hour == capturesItem.attack_hour && this.attack_minute == capturesItem.attack_minute && this.date_attack_unix == capturesItem.date_attack_unix && this.date_capture == capturesItem.date_capture && this.family_moneta == capturesItem.family_moneta && this.family_money == capturesItem.family_money && this.capture_id_zone == capturesItem.capture_id_zone;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((Integer.hashCode(this.family_id) * 31) + Integer.hashCode(this.family_db_id)) * 31) + this.family_name.hashCode()) * 31) + Integer.hashCode(this.family_color)) * 31) + Integer.hashCode(this.family_flag)) * 31) + Integer.hashCode(this.attack_family_id)) * 31) + Integer.hashCode(this.attack_family_db_id)) * 31) + this.attack_family_name.hashCode()) * 31) + Integer.hashCode(this.attack_family_color)) * 31) + Integer.hashCode(this.attack_family_flag)) * 31) + Integer.hashCode(this.attack_month)) * 31) + Integer.hashCode(this.attack_day)) * 31) + Integer.hashCode(this.attack_hour)) * 31) + Integer.hashCode(this.attack_minute)) * 31) + Long.hashCode(this.date_attack_unix)) * 31) + Long.hashCode(this.date_capture)) * 31) + Integer.hashCode(this.family_moneta)) * 31) + Integer.hashCode(this.family_money)) * 31) + Integer.hashCode(this.capture_id_zone);
    }

    public String toString() {
        int i = this.family_id;
        int i2 = this.family_db_id;
        String str = this.family_name;
        int i3 = this.family_color;
        int i4 = this.family_flag;
        int i5 = this.attack_family_id;
        int i6 = this.attack_family_db_id;
        String str2 = this.attack_family_name;
        int i7 = this.attack_family_color;
        int i8 = this.attack_family_flag;
        int i9 = this.attack_month;
        int i10 = this.attack_day;
        int i11 = this.attack_hour;
        int i12 = this.attack_minute;
        long j = this.date_attack_unix;
        long j2 = this.date_capture;
        int i13 = this.family_moneta;
        int i14 = this.family_money;
        return "CapturesItem(family_id=" + i + ", family_db_id=" + i2 + ", family_name=" + str + ", family_color=" + i3 + ", family_flag=" + i4 + ", attack_family_id=" + i5 + ", attack_family_db_id=" + i6 + ", attack_family_name=" + str2 + ", attack_family_color=" + i7 + ", attack_family_flag=" + i8 + ", attack_month=" + i9 + ", attack_day=" + i10 + ", attack_hour=" + i11 + ", attack_minute=" + i12 + ", date_attack_unix=" + j + ", date_capture=" + j2 + ", family_moneta=" + i13 + ", family_money=" + i14 + ", capture_id_zone=" + this.capture_id_zone + ")";
    }

    public CapturesItem(int i, int i2, String family_name, int i3, int i4, int i5, int i6, String attack_family_name, int i7, int i8, int i9, int i10, int i11, int i12, long j, long j2, int i13, int i14, int i15) {
        Intrinsics.checkNotNullParameter(family_name, "family_name");
        Intrinsics.checkNotNullParameter(attack_family_name, "attack_family_name");
        this.family_id = i;
        this.family_db_id = i2;
        this.family_name = family_name;
        this.family_color = i3;
        this.family_flag = i4;
        this.attack_family_id = i5;
        this.attack_family_db_id = i6;
        this.attack_family_name = attack_family_name;
        this.attack_family_color = i7;
        this.attack_family_flag = i8;
        this.attack_month = i9;
        this.attack_day = i10;
        this.attack_hour = i11;
        this.attack_minute = i12;
        this.date_attack_unix = j;
        this.date_capture = j2;
        this.family_moneta = i13;
        this.family_money = i14;
        this.capture_id_zone = i15;
    }

    public final int getFamily_id() {
        return this.family_id;
    }

    public final int getFamily_db_id() {
        return this.family_db_id;
    }

    public final String getFamily_name() {
        return this.family_name;
    }

    public final int getFamily_color() {
        return this.family_color;
    }

    public final int getFamily_flag() {
        return this.family_flag;
    }

    public final int getAttack_family_id() {
        return this.attack_family_id;
    }

    public final int getAttack_family_db_id() {
        return this.attack_family_db_id;
    }

    public final String getAttack_family_name() {
        return this.attack_family_name;
    }

    public final int getAttack_family_color() {
        return this.attack_family_color;
    }

    public final int getAttack_family_flag() {
        return this.attack_family_flag;
    }

    public final int getAttack_month() {
        return this.attack_month;
    }

    public final int getAttack_day() {
        return this.attack_day;
    }

    public final int getAttack_hour() {
        return this.attack_hour;
    }

    public final int getAttack_minute() {
        return this.attack_minute;
    }

    public final long getDate_attack_unix() {
        return this.date_attack_unix;
    }

    public final long getDate_capture() {
        return this.date_capture;
    }

    public final int getFamily_moneta() {
        return this.family_moneta;
    }

    public final int getFamily_money() {
        return this.family_money;
    }

    public final int getCapture_id_zone() {
        return this.capture_id_zone;
    }
}
