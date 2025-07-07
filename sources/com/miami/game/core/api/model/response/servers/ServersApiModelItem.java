package com.miami.game.core.api.model.response.servers;

import androidx.autofill.HintConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServersApiModelItem.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b3\b\u0086\b\u0018\u00002\u00020\u0001B½\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00105\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010?\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010$Jæ\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0003HÖ\u0001J\t\u0010E\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b!\u0010\u001bR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\"\u0010\u001bR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b-\u0010\u001bR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b.\u0010\u001bR\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b\u0016\u0010$R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b\u0017\u0010$¨\u0006F"}, d2 = {"Lcom/miami/game/core/api/model/response/servers/ServersApiModelItem;", "", "number", "", "name", "", "ip", "port", "online", "maxplayers", HintConstants.AUTOFILL_HINT_PASSWORD, "", "vk", "tg", "inst", "icon", "additionalIps", "", "plotPoints", "Lcom/miami/game/core/api/model/response/servers/PlotPointApiModel;", "xdonate", "xpayday", "isNew", "isTop", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getIp", "getPort", "getOnline", "getMaxplayers", "getPassword", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVk", "getTg", "getInst", "getIcon", "getAdditionalIps", "()Ljava/util/List;", "getPlotPoints", "getXdonate", "getXpayday", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/miami/game/core/api/model/response/servers/ServersApiModelItem;", "equals", "other", "hashCode", "toString", "api-model_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServersApiModelItem {
    @SerializedName("additionalIps")
    private final List<String> additionalIps;
    @SerializedName("icon")
    private final String icon;
    @SerializedName("inst")
    private final String inst;
    @SerializedName("ip")
    private final String ip;
    @SerializedName("new")
    private final Boolean isNew;
    @SerializedName("recomend")
    private final Boolean isTop;
    @SerializedName("maxplayers")
    private final Integer maxplayers;
    @SerializedName("name")
    private final String name;
    @SerializedName("number")
    private final Integer number;
    @SerializedName("online")
    private final Integer online;
    @SerializedName(HintConstants.AUTOFILL_HINT_PASSWORD)
    private final Boolean password;
    @SerializedName("plotPoints")
    private final List<PlotPointApiModel> plotPoints;
    @SerializedName("port")
    private final Integer port;
    @SerializedName("tg")
    private final String tg;
    @SerializedName("vk")
    private final String vk;
    @SerializedName("donateMultiplier")
    private final Integer xdonate;
    @SerializedName("experienceMultiplier")
    private final Integer xpayday;

    public static /* synthetic */ ServersApiModelItem copy$default(ServersApiModelItem serversApiModelItem, Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Boolean bool, String str3, String str4, String str5, String str6, List list, List list2, Integer num5, Integer num6, Boolean bool2, Boolean bool3, int i, Object obj) {
        Boolean bool4;
        Boolean bool5;
        Integer num7;
        ServersApiModelItem serversApiModelItem2;
        Integer num8;
        String str7;
        String str8;
        Integer num9;
        Integer num10;
        Integer num11;
        Boolean bool6;
        String str9;
        String str10;
        String str11;
        String str12;
        List list3;
        List list4;
        Integer num12;
        Integer num13 = (i & 1) != 0 ? serversApiModelItem.number : num;
        String str13 = (i & 2) != 0 ? serversApiModelItem.name : str;
        String str14 = (i & 4) != 0 ? serversApiModelItem.ip : str2;
        Integer num14 = (i & 8) != 0 ? serversApiModelItem.port : num2;
        Integer num15 = (i & 16) != 0 ? serversApiModelItem.online : num3;
        Integer num16 = (i & 32) != 0 ? serversApiModelItem.maxplayers : num4;
        Boolean bool7 = (i & 64) != 0 ? serversApiModelItem.password : bool;
        String str15 = (i & 128) != 0 ? serversApiModelItem.vk : str3;
        String str16 = (i & 256) != 0 ? serversApiModelItem.tg : str4;
        String str17 = (i & 512) != 0 ? serversApiModelItem.inst : str5;
        String str18 = (i & 1024) != 0 ? serversApiModelItem.icon : str6;
        List list5 = (i & 2048) != 0 ? serversApiModelItem.additionalIps : list;
        List list6 = (i & 4096) != 0 ? serversApiModelItem.plotPoints : list2;
        Integer num17 = (i & 8192) != 0 ? serversApiModelItem.xdonate : num5;
        Integer num18 = num13;
        Integer num19 = (i & 16384) != 0 ? serversApiModelItem.xpayday : num6;
        Boolean bool8 = (i & 32768) != 0 ? serversApiModelItem.isNew : bool2;
        if ((i & 65536) != 0) {
            bool5 = bool8;
            bool4 = serversApiModelItem.isTop;
            num8 = num19;
            str7 = str13;
            str8 = str14;
            num9 = num14;
            num10 = num15;
            num11 = num16;
            bool6 = bool7;
            str9 = str15;
            str10 = str16;
            str11 = str17;
            str12 = str18;
            list3 = list5;
            list4 = list6;
            num12 = num17;
            num7 = num18;
            serversApiModelItem2 = serversApiModelItem;
        } else {
            bool4 = bool3;
            bool5 = bool8;
            num7 = num18;
            serversApiModelItem2 = serversApiModelItem;
            num8 = num19;
            str7 = str13;
            str8 = str14;
            num9 = num14;
            num10 = num15;
            num11 = num16;
            bool6 = bool7;
            str9 = str15;
            str10 = str16;
            str11 = str17;
            str12 = str18;
            list3 = list5;
            list4 = list6;
            num12 = num17;
        }
        return serversApiModelItem2.copy(num7, str7, str8, num9, num10, num11, bool6, str9, str10, str11, str12, list3, list4, num12, num8, bool5, bool4);
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

    public final List<String> component12() {
        return this.additionalIps;
    }

    public final List<PlotPointApiModel> component13() {
        return this.plotPoints;
    }

    public final Integer component14() {
        return this.xdonate;
    }

    public final Integer component15() {
        return this.xpayday;
    }

    public final Boolean component16() {
        return this.isNew;
    }

    public final Boolean component17() {
        return this.isTop;
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

    public final ServersApiModelItem copy(Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Boolean bool, String str3, String str4, String str5, String str6, List<String> list, List<PlotPointApiModel> list2, Integer num5, Integer num6, Boolean bool2, Boolean bool3) {
        return new ServersApiModelItem(num, str, str2, num2, num3, num4, bool, str3, str4, str5, str6, list, list2, num5, num6, bool2, bool3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServersApiModelItem) {
            ServersApiModelItem serversApiModelItem = (ServersApiModelItem) obj;
            return Intrinsics.areEqual(this.number, serversApiModelItem.number) && Intrinsics.areEqual(this.name, serversApiModelItem.name) && Intrinsics.areEqual(this.ip, serversApiModelItem.ip) && Intrinsics.areEqual(this.port, serversApiModelItem.port) && Intrinsics.areEqual(this.online, serversApiModelItem.online) && Intrinsics.areEqual(this.maxplayers, serversApiModelItem.maxplayers) && Intrinsics.areEqual(this.password, serversApiModelItem.password) && Intrinsics.areEqual(this.vk, serversApiModelItem.vk) && Intrinsics.areEqual(this.tg, serversApiModelItem.tg) && Intrinsics.areEqual(this.inst, serversApiModelItem.inst) && Intrinsics.areEqual(this.icon, serversApiModelItem.icon) && Intrinsics.areEqual(this.additionalIps, serversApiModelItem.additionalIps) && Intrinsics.areEqual(this.plotPoints, serversApiModelItem.plotPoints) && Intrinsics.areEqual(this.xdonate, serversApiModelItem.xdonate) && Intrinsics.areEqual(this.xpayday, serversApiModelItem.xpayday) && Intrinsics.areEqual(this.isNew, serversApiModelItem.isNew) && Intrinsics.areEqual(this.isTop, serversApiModelItem.isTop);
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
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<String> list = this.additionalIps;
        int hashCode12 = (hashCode11 + (list == null ? 0 : list.hashCode())) * 31;
        List<PlotPointApiModel> list2 = this.plotPoints;
        int hashCode13 = (hashCode12 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num5 = this.xdonate;
        int hashCode14 = (hashCode13 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.xpayday;
        int hashCode15 = (hashCode14 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Boolean bool2 = this.isNew;
        int hashCode16 = (hashCode15 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isTop;
        return hashCode16 + (bool3 != null ? bool3.hashCode() : 0);
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
        List<String> list = this.additionalIps;
        List<PlotPointApiModel> list2 = this.plotPoints;
        Integer num5 = this.xdonate;
        Integer num6 = this.xpayday;
        Boolean bool2 = this.isNew;
        return "ServersApiModelItem(number=" + num + ", name=" + str + ", ip=" + str2 + ", port=" + num2 + ", online=" + num3 + ", maxplayers=" + num4 + ", password=" + bool + ", vk=" + str3 + ", tg=" + str4 + ", inst=" + str5 + ", icon=" + str6 + ", additionalIps=" + list + ", plotPoints=" + list2 + ", xdonate=" + num5 + ", xpayday=" + num6 + ", isNew=" + bool2 + ", isTop=" + this.isTop + ")";
    }

    public ServersApiModelItem(Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Boolean bool, String str3, String str4, String str5, String str6, List<String> list, List<PlotPointApiModel> list2, Integer num5, Integer num6, Boolean bool2, Boolean bool3) {
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
        this.additionalIps = list;
        this.plotPoints = list2;
        this.xdonate = num5;
        this.xpayday = num6;
        this.isNew = bool2;
        this.isTop = bool3;
    }

    public final Integer getNumber() {
        return this.number;
    }

    public final String getName() {
        return this.name;
    }

    public final String getIp() {
        return this.ip;
    }

    public final Integer getPort() {
        return this.port;
    }

    public final Integer getOnline() {
        return this.online;
    }

    public final Integer getMaxplayers() {
        return this.maxplayers;
    }

    public final Boolean getPassword() {
        return this.password;
    }

    public final String getVk() {
        return this.vk;
    }

    public final String getTg() {
        return this.tg;
    }

    public final String getInst() {
        return this.inst;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final List<String> getAdditionalIps() {
        return this.additionalIps;
    }

    public final List<PlotPointApiModel> getPlotPoints() {
        return this.plotPoints;
    }

    public final Integer getXdonate() {
        return this.xdonate;
    }

    public final Integer getXpayday() {
        return this.xpayday;
    }

    public final Boolean isNew() {
        return this.isNew;
    }

    public final Boolean isTop() {
        return this.isTop;
    }
}
