package ru.mrlargha.commonui.elements.hud.presentation.api.obj;

import androidx.autofill.HintConstants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudApiRequest.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b7\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013HÆ\u0003J¬\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020\u000b2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\u0003HÖ\u0001J\t\u0010I\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019R\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001c\"\u0004\b/\u0010\u001eR \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001eR \u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u001eR.\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006J"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/api/obj/Query;", "", "number", "", "name", "", "ip", "port", "online", "maxplayers", HintConstants.AUTOFILL_HINT_PASSWORD, "", "vk", "tg", "inst", "icon", "plotPoints", "Ljava/util/ArrayList;", "Lru/mrlargha/commonui/elements/hud/presentation/api/obj/PlotPoints;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getNumber", "()Ljava/lang/Integer;", "setNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getIp", "setIp", "getPort", "setPort", "getOnline", "setOnline", "getMaxplayers", "setMaxplayers", "getPassword", "()Ljava/lang/Boolean;", "setPassword", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getVk", "setVk", "getTg", "setTg", "getInst", "setInst", "getIcon", "setIcon", "getPlotPoints", "()Ljava/util/ArrayList;", "setPlotPoints", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)Lru/mrlargha/commonui/elements/hud/presentation/api/obj/Query;", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Query {
    @SerializedName("icon")
    private String icon;
    @SerializedName("inst")
    private String inst;
    @SerializedName("ip")
    private String ip;
    @SerializedName("maxplayers")
    private Integer maxplayers;
    @SerializedName("name")
    private String name;
    @SerializedName("number")
    private Integer number;
    @SerializedName("online")
    private Integer online;
    @SerializedName(HintConstants.AUTOFILL_HINT_PASSWORD)
    private Boolean password;
    @SerializedName("plotPoints")
    private ArrayList<PlotPoints> plotPoints;
    @SerializedName("port")
    private Integer port;
    @SerializedName("tg")
    private String tg;
    @SerializedName("vk")
    private String vk;

    public Query() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ Query copy$default(Query query, Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Boolean bool, String str3, String str4, String str5, String str6, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            num = query.number;
        }
        if ((i & 2) != 0) {
            str = query.name;
        }
        if ((i & 4) != 0) {
            str2 = query.ip;
        }
        if ((i & 8) != 0) {
            num2 = query.port;
        }
        if ((i & 16) != 0) {
            num3 = query.online;
        }
        if ((i & 32) != 0) {
            num4 = query.maxplayers;
        }
        if ((i & 64) != 0) {
            bool = query.password;
        }
        if ((i & 128) != 0) {
            str3 = query.vk;
        }
        if ((i & 256) != 0) {
            str4 = query.tg;
        }
        if ((i & 512) != 0) {
            str5 = query.inst;
        }
        if ((i & 1024) != 0) {
            str6 = query.icon;
        }
        ArrayList<PlotPoints> arrayList2 = arrayList;
        if ((i & 2048) != 0) {
            arrayList2 = query.plotPoints;
        }
        String str7 = str6;
        ArrayList arrayList3 = arrayList2;
        String str8 = str4;
        String str9 = str5;
        Boolean bool2 = bool;
        String str10 = str3;
        Integer num5 = num3;
        Integer num6 = num4;
        return query.copy(num, str, str2, num2, num5, num6, bool2, str10, str8, str9, str7, arrayList3);
    }

    public final Integer component1() {
        return this.number;
    }

    public final String component10() {
        return this.inst;
    }

    public final String component11() {
        return this.icon;
    }

    public final ArrayList<PlotPoints> component12() {
        return this.plotPoints;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.ip;
    }

    public final Integer component4() {
        return this.port;
    }

    public final Integer component5() {
        return this.online;
    }

    public final Integer component6() {
        return this.maxplayers;
    }

    public final Boolean component7() {
        return this.password;
    }

    public final String component8() {
        return this.vk;
    }

    public final String component9() {
        return this.tg;
    }

    public final Query copy(Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Boolean bool, String str3, String str4, String str5, String str6, ArrayList<PlotPoints> plotPoints) {
        Intrinsics.checkNotNullParameter(plotPoints, "plotPoints");
        return new Query(num, str, str2, num2, num3, num4, bool, str3, str4, str5, str6, plotPoints);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Query) {
            Query query = (Query) obj;
            return Intrinsics.areEqual(this.number, query.number) && Intrinsics.areEqual(this.name, query.name) && Intrinsics.areEqual(this.ip, query.ip) && Intrinsics.areEqual(this.port, query.port) && Intrinsics.areEqual(this.online, query.online) && Intrinsics.areEqual(this.maxplayers, query.maxplayers) && Intrinsics.areEqual(this.password, query.password) && Intrinsics.areEqual(this.vk, query.vk) && Intrinsics.areEqual(this.tg, query.tg) && Intrinsics.areEqual(this.inst, query.inst) && Intrinsics.areEqual(this.icon, query.icon) && Intrinsics.areEqual(this.plotPoints, query.plotPoints);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.number;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ip;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.port;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.online;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.maxplayers;
        int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Boolean bool = this.password;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.vk;
        int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.tg;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.inst;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.icon;
        return ((hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.plotPoints.hashCode();
    }

    public String toString() {
        Integer num = this.number;
        String str = this.name;
        String str2 = this.ip;
        Integer num2 = this.port;
        Integer num3 = this.online;
        Integer num4 = this.maxplayers;
        Boolean bool = this.password;
        String str3 = this.vk;
        String str4 = this.tg;
        String str5 = this.inst;
        String str6 = this.icon;
        return "Query(number=" + num + ", name=" + str + ", ip=" + str2 + ", port=" + num2 + ", online=" + num3 + ", maxplayers=" + num4 + ", password=" + bool + ", vk=" + str3 + ", tg=" + str4 + ", inst=" + str5 + ", icon=" + str6 + ", plotPoints=" + this.plotPoints + ")";
    }

    public Query(Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Boolean bool, String str3, String str4, String str5, String str6, ArrayList<PlotPoints> plotPoints) {
        Intrinsics.checkNotNullParameter(plotPoints, "plotPoints");
        this.number = num;
        this.name = str;
        this.ip = str2;
        this.port = num2;
        this.online = num3;
        this.maxplayers = num4;
        this.password = bool;
        this.vk = str3;
        this.tg = str4;
        this.inst = str5;
        this.icon = str6;
        this.plotPoints = plotPoints;
    }

    public final Integer getNumber() {
        return this.number;
    }

    public final void setNumber(Integer num) {
        this.number = num;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getIp() {
        return this.ip;
    }

    public final void setIp(String str) {
        this.ip = str;
    }

    public final Integer getPort() {
        return this.port;
    }

    public final void setPort(Integer num) {
        this.port = num;
    }

    public final Integer getOnline() {
        return this.online;
    }

    public final void setOnline(Integer num) {
        this.online = num;
    }

    public final Integer getMaxplayers() {
        return this.maxplayers;
    }

    public final void setMaxplayers(Integer num) {
        this.maxplayers = num;
    }

    public final Boolean getPassword() {
        return this.password;
    }

    public final void setPassword(Boolean bool) {
        this.password = bool;
    }

    public final String getVk() {
        return this.vk;
    }

    public final void setVk(String str) {
        this.vk = str;
    }

    public final String getTg() {
        return this.tg;
    }

    public final void setTg(String str) {
        this.tg = str;
    }

    public final String getInst() {
        return this.inst;
    }

    public final void setInst(String str) {
        this.inst = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public /* synthetic */ Query(Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Boolean bool, String str3, String str4, String str5, String str6, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : num4, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? new ArrayList() : arrayList);
    }

    public final ArrayList<PlotPoints> getPlotPoints() {
        return this.plotPoints;
    }

    public final void setPlotPoints(ArrayList<PlotPoints> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.plotPoints = arrayList;
    }
}
