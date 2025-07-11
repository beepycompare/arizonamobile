package ru.mrlargha.arizonaui.documents.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DocumentsData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J½\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0006HÆ\u0001J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0003HÖ\u0001J\t\u0010C\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001c¨\u0006D"}, d2 = {"Lru/mrlargha/arizonaui/documents/data/InfoItemMain;", "", "type", "", "not", "name", "", "sex", "birthday", "citizen", "married", FirebaseAnalytics.Param.LEVEL, "zakono", "job", "agenda", "agenda_color", "charity", "rank", "seria", "number", "signature", "skin_image_url", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getNot", "getName", "()Ljava/lang/String;", "getSex", "getBirthday", "getCitizen", "getMarried", "getLevel", "getZakono", "getJob", "getAgenda", "getAgenda_color", "getCharity", "getRank", "getSeria", "getNumber", "getSignature", "getSkin_image_url", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InfoItemMain {
    private final String agenda;
    private final String agenda_color;
    private final String birthday;
    private final String charity;
    private final String citizen;
    private final String job;
    private final String level;
    private final String married;
    private final String name;
    private final int not;
    private final String number;
    private final String rank;
    private final String seria;
    private final String sex;
    private final String signature;
    private final String skin_image_url;
    private final int type;
    private final String zakono;

    public static /* synthetic */ InfoItemMain copy$default(InfoItemMain infoItemMain, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i3, Object obj) {
        String str17;
        String str18;
        int i4 = (i3 & 1) != 0 ? infoItemMain.type : i;
        int i5 = (i3 & 2) != 0 ? infoItemMain.not : i2;
        String str19 = (i3 & 4) != 0 ? infoItemMain.name : str;
        String str20 = (i3 & 8) != 0 ? infoItemMain.sex : str2;
        String str21 = (i3 & 16) != 0 ? infoItemMain.birthday : str3;
        String str22 = (i3 & 32) != 0 ? infoItemMain.citizen : str4;
        String str23 = (i3 & 64) != 0 ? infoItemMain.married : str5;
        String str24 = (i3 & 128) != 0 ? infoItemMain.level : str6;
        String str25 = (i3 & 256) != 0 ? infoItemMain.zakono : str7;
        String str26 = (i3 & 512) != 0 ? infoItemMain.job : str8;
        String str27 = (i3 & 1024) != 0 ? infoItemMain.agenda : str9;
        String str28 = (i3 & 2048) != 0 ? infoItemMain.agenda_color : str10;
        String str29 = (i3 & 4096) != 0 ? infoItemMain.charity : str11;
        String str30 = (i3 & 8192) != 0 ? infoItemMain.rank : str12;
        int i6 = i4;
        String str31 = (i3 & 16384) != 0 ? infoItemMain.seria : str13;
        String str32 = (i3 & 32768) != 0 ? infoItemMain.number : str14;
        String str33 = (i3 & 65536) != 0 ? infoItemMain.signature : str15;
        if ((i3 & 131072) != 0) {
            str18 = str33;
            str17 = infoItemMain.skin_image_url;
        } else {
            str17 = str16;
            str18 = str33;
        }
        return infoItemMain.copy(i6, i5, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str18, str17);
    }

    public final int component1() {
        return this.type;
    }

    public final String component10() {
        return this.job;
    }

    public final String component11() {
        return this.agenda;
    }

    public final String component12() {
        return this.agenda_color;
    }

    public final String component13() {
        return this.charity;
    }

    public final String component14() {
        return this.rank;
    }

    public final String component15() {
        return this.seria;
    }

    public final String component16() {
        return this.number;
    }

    public final String component17() {
        return this.signature;
    }

    public final String component18() {
        return this.skin_image_url;
    }

    public final int component2() {
        return this.not;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.sex;
    }

    public final String component5() {
        return this.birthday;
    }

    public final String component6() {
        return this.citizen;
    }

    public final String component7() {
        return this.married;
    }

    public final String component8() {
        return this.level;
    }

    public final String component9() {
        return this.zakono;
    }

    public final InfoItemMain copy(int i, int i2, String name, String sex, String birthday, String citizen, String married, String level, String zakono, String job, String agenda, String agenda_color, String charity, String rank, String seria, String number, String signature, String skin_image_url) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sex, "sex");
        Intrinsics.checkNotNullParameter(birthday, "birthday");
        Intrinsics.checkNotNullParameter(citizen, "citizen");
        Intrinsics.checkNotNullParameter(married, "married");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(zakono, "zakono");
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(agenda, "agenda");
        Intrinsics.checkNotNullParameter(agenda_color, "agenda_color");
        Intrinsics.checkNotNullParameter(charity, "charity");
        Intrinsics.checkNotNullParameter(rank, "rank");
        Intrinsics.checkNotNullParameter(seria, "seria");
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(skin_image_url, "skin_image_url");
        return new InfoItemMain(i, i2, name, sex, birthday, citizen, married, level, zakono, job, agenda, agenda_color, charity, rank, seria, number, signature, skin_image_url);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InfoItemMain) {
            InfoItemMain infoItemMain = (InfoItemMain) obj;
            return this.type == infoItemMain.type && this.not == infoItemMain.not && Intrinsics.areEqual(this.name, infoItemMain.name) && Intrinsics.areEqual(this.sex, infoItemMain.sex) && Intrinsics.areEqual(this.birthday, infoItemMain.birthday) && Intrinsics.areEqual(this.citizen, infoItemMain.citizen) && Intrinsics.areEqual(this.married, infoItemMain.married) && Intrinsics.areEqual(this.level, infoItemMain.level) && Intrinsics.areEqual(this.zakono, infoItemMain.zakono) && Intrinsics.areEqual(this.job, infoItemMain.job) && Intrinsics.areEqual(this.agenda, infoItemMain.agenda) && Intrinsics.areEqual(this.agenda_color, infoItemMain.agenda_color) && Intrinsics.areEqual(this.charity, infoItemMain.charity) && Intrinsics.areEqual(this.rank, infoItemMain.rank) && Intrinsics.areEqual(this.seria, infoItemMain.seria) && Intrinsics.areEqual(this.number, infoItemMain.number) && Intrinsics.areEqual(this.signature, infoItemMain.signature) && Intrinsics.areEqual(this.skin_image_url, infoItemMain.skin_image_url);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.not)) * 31) + this.name.hashCode()) * 31) + this.sex.hashCode()) * 31) + this.birthday.hashCode()) * 31) + this.citizen.hashCode()) * 31) + this.married.hashCode()) * 31) + this.level.hashCode()) * 31) + this.zakono.hashCode()) * 31) + this.job.hashCode()) * 31) + this.agenda.hashCode()) * 31) + this.agenda_color.hashCode()) * 31) + this.charity.hashCode()) * 31) + this.rank.hashCode()) * 31) + this.seria.hashCode()) * 31) + this.number.hashCode()) * 31) + this.signature.hashCode()) * 31) + this.skin_image_url.hashCode();
    }

    public String toString() {
        int i = this.type;
        int i2 = this.not;
        String str = this.name;
        String str2 = this.sex;
        String str3 = this.birthday;
        String str4 = this.citizen;
        String str5 = this.married;
        String str6 = this.level;
        String str7 = this.zakono;
        String str8 = this.job;
        String str9 = this.agenda;
        String str10 = this.agenda_color;
        String str11 = this.charity;
        String str12 = this.rank;
        String str13 = this.seria;
        String str14 = this.number;
        String str15 = this.signature;
        return "InfoItemMain(type=" + i + ", not=" + i2 + ", name=" + str + ", sex=" + str2 + ", birthday=" + str3 + ", citizen=" + str4 + ", married=" + str5 + ", level=" + str6 + ", zakono=" + str7 + ", job=" + str8 + ", agenda=" + str9 + ", agenda_color=" + str10 + ", charity=" + str11 + ", rank=" + str12 + ", seria=" + str13 + ", number=" + str14 + ", signature=" + str15 + ", skin_image_url=" + this.skin_image_url + ")";
    }

    public InfoItemMain(int i, int i2, String name, String sex, String birthday, String citizen, String married, String level, String zakono, String job, String agenda, String agenda_color, String charity, String rank, String seria, String number, String signature, String skin_image_url) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sex, "sex");
        Intrinsics.checkNotNullParameter(birthday, "birthday");
        Intrinsics.checkNotNullParameter(citizen, "citizen");
        Intrinsics.checkNotNullParameter(married, "married");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(zakono, "zakono");
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(agenda, "agenda");
        Intrinsics.checkNotNullParameter(agenda_color, "agenda_color");
        Intrinsics.checkNotNullParameter(charity, "charity");
        Intrinsics.checkNotNullParameter(rank, "rank");
        Intrinsics.checkNotNullParameter(seria, "seria");
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(skin_image_url, "skin_image_url");
        this.type = i;
        this.not = i2;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.citizen = citizen;
        this.married = married;
        this.level = level;
        this.zakono = zakono;
        this.job = job;
        this.agenda = agenda;
        this.agenda_color = agenda_color;
        this.charity = charity;
        this.rank = rank;
        this.seria = seria;
        this.number = number;
        this.signature = signature;
        this.skin_image_url = skin_image_url;
    }

    public final int getType() {
        return this.type;
    }

    public final int getNot() {
        return this.not;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSex() {
        return this.sex;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final String getCitizen() {
        return this.citizen;
    }

    public final String getMarried() {
        return this.married;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getZakono() {
        return this.zakono;
    }

    public final String getJob() {
        return this.job;
    }

    public final String getAgenda() {
        return this.agenda;
    }

    public final String getAgenda_color() {
        return this.agenda_color;
    }

    public final String getCharity() {
        return this.charity;
    }

    public final String getRank() {
        return this.rank;
    }

    public final String getSeria() {
        return this.seria;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getSkin_image_url() {
        return this.skin_image_url;
    }
}
