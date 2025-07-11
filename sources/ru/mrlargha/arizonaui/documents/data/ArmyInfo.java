package ru.mrlargha.arizonaui.documents.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DocumentsData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lru/mrlargha/arizonaui/documents/data/ArmyInfo;", "", "type", "", "not", "name", "", "skin_image_url", "have_army_ticket", "army_online", "rank", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getNot", "getName", "()Ljava/lang/String;", "getSkin_image_url", "getHave_army_ticket", "getArmy_online", "getRank", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArmyInfo {
    private final String army_online;
    private final String have_army_ticket;
    private final String name;
    private final int not;
    private final String rank;
    private final String skin_image_url;
    private final int type;

    public static /* synthetic */ ArmyInfo copy$default(ArmyInfo armyInfo, int i, int i2, String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = armyInfo.type;
        }
        if ((i3 & 2) != 0) {
            i2 = armyInfo.not;
        }
        if ((i3 & 4) != 0) {
            str = armyInfo.name;
        }
        if ((i3 & 8) != 0) {
            str2 = armyInfo.skin_image_url;
        }
        if ((i3 & 16) != 0) {
            str3 = armyInfo.have_army_ticket;
        }
        if ((i3 & 32) != 0) {
            str4 = armyInfo.army_online;
        }
        if ((i3 & 64) != 0) {
            str5 = armyInfo.rank;
        }
        String str6 = str4;
        String str7 = str5;
        String str8 = str3;
        String str9 = str;
        return armyInfo.copy(i, i2, str9, str2, str8, str6, str7);
    }

    public final int component1() {
        return this.type;
    }

    public final int component2() {
        return this.not;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.skin_image_url;
    }

    public final String component5() {
        return this.have_army_ticket;
    }

    public final String component6() {
        return this.army_online;
    }

    public final String component7() {
        return this.rank;
    }

    public final ArmyInfo copy(int i, int i2, String name, String skin_image_url, String have_army_ticket, String army_online, String rank) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(skin_image_url, "skin_image_url");
        Intrinsics.checkNotNullParameter(have_army_ticket, "have_army_ticket");
        Intrinsics.checkNotNullParameter(army_online, "army_online");
        Intrinsics.checkNotNullParameter(rank, "rank");
        return new ArmyInfo(i, i2, name, skin_image_url, have_army_ticket, army_online, rank);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArmyInfo) {
            ArmyInfo armyInfo = (ArmyInfo) obj;
            return this.type == armyInfo.type && this.not == armyInfo.not && Intrinsics.areEqual(this.name, armyInfo.name) && Intrinsics.areEqual(this.skin_image_url, armyInfo.skin_image_url) && Intrinsics.areEqual(this.have_army_ticket, armyInfo.have_army_ticket) && Intrinsics.areEqual(this.army_online, armyInfo.army_online) && Intrinsics.areEqual(this.rank, armyInfo.rank);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.not)) * 31) + this.name.hashCode()) * 31) + this.skin_image_url.hashCode()) * 31) + this.have_army_ticket.hashCode()) * 31) + this.army_online.hashCode()) * 31) + this.rank.hashCode();
    }

    public String toString() {
        int i = this.type;
        int i2 = this.not;
        String str = this.name;
        String str2 = this.skin_image_url;
        String str3 = this.have_army_ticket;
        String str4 = this.army_online;
        return "ArmyInfo(type=" + i + ", not=" + i2 + ", name=" + str + ", skin_image_url=" + str2 + ", have_army_ticket=" + str3 + ", army_online=" + str4 + ", rank=" + this.rank + ")";
    }

    public ArmyInfo(int i, int i2, String name, String skin_image_url, String have_army_ticket, String army_online, String rank) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(skin_image_url, "skin_image_url");
        Intrinsics.checkNotNullParameter(have_army_ticket, "have_army_ticket");
        Intrinsics.checkNotNullParameter(army_online, "army_online");
        Intrinsics.checkNotNullParameter(rank, "rank");
        this.type = i;
        this.not = i2;
        this.name = name;
        this.skin_image_url = skin_image_url;
        this.have_army_ticket = have_army_ticket;
        this.army_online = army_online;
        this.rank = rank;
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

    public final String getSkin_image_url() {
        return this.skin_image_url;
    }

    public final String getHave_army_ticket() {
        return this.have_army_ticket;
    }

    public final String getArmy_online() {
        return this.army_online;
    }

    public final String getRank() {
        return this.rank;
    }
}
