package com.miami.game.core.api.model.response.servers;

import androidx.autofill.HintConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServersApiModelItem.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010>\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012HÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010G\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010H\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010(Jò\u0001\u0010I\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010JJ\u0014\u0010K\u001a\u00020\f2\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010M\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010N\u001a\u00020\u0005HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR'\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R'\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R)\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0007¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b#\u0010\u001cR)\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR)\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\t¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b%\u0010\u001cR)\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\n¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b&\u0010\u001cR)\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u000b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R'\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R'\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R'\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R'\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R-\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00128\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0011¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R-\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00128\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0013¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R)\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(2¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b1\u0010\u001cR)\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(4¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b3\u0010\u001cR)\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(5¢\u0006\n\n\u0002\u0010)\u001a\u0004\b\u0017\u0010(R)\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u0092\u0002\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(6¢\u0006\n\n\u0002\u0010)\u001a\u0004\b\u0018\u0010(¨\u0006O"}, d2 = {"Lcom/miami/game/core/api/model/response/servers/ServersApiModelItem;", "", "number", "", "name", "", "ip", "port", "online", "queue", "maxplayers", HintConstants.AUTOFILL_HINT_PASSWORD, "", "vk", "tg", "inst", "icon", "additionalIps", "", "plotPoints", "Lcom/miami/game/core/api/model/response/servers/PlotPointApiModel;", "xdonate", "xpayday", "isNew", "isTop", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getName", "()Ljava/lang/String;", "getIp", "getPort", "getOnline", "getQueue", "getMaxplayers", "getPassword", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVk", "getTg", "getInst", "getIcon", "getAdditionalIps", "()Ljava/util/List;", "getPlotPoints", "getXdonate", "donateMultiplier", "getXpayday", "experienceMultiplier", "new", "recomend", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/miami/game/core/api/model/response/servers/ServersApiModelItem;", "equals", "other", "hashCode", "toString", "api-model"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
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
    @SerializedName("queue")
    private final Integer queue;
    @SerializedName("tg")
    private final String tg;
    @SerializedName("vk")
    private final String vk;
    @SerializedName("donateMultiplier")
    private final Integer xdonate;
    @SerializedName("experienceMultiplier")
    private final Integer xpayday;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServersApiModelItem copy$default(ServersApiModelItem serversApiModelItem, Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Integer num5, Boolean bool, String str3, String str4, String str5, String str6, List list, List list2, Integer num6, Integer num7, Boolean bool2, Boolean bool3, int i, Object obj) {
        Boolean bool4;
        Boolean bool5;
        Integer num8 = (i & 1) != 0 ? serversApiModelItem.number : num;
        String str7 = (i & 2) != 0 ? serversApiModelItem.name : str;
        String str8 = (i & 4) != 0 ? serversApiModelItem.ip : str2;
        Integer num9 = (i & 8) != 0 ? serversApiModelItem.port : num2;
        Integer num10 = (i & 16) != 0 ? serversApiModelItem.online : num3;
        Integer num11 = (i & 32) != 0 ? serversApiModelItem.queue : num4;
        Integer num12 = (i & 64) != 0 ? serversApiModelItem.maxplayers : num5;
        Boolean bool6 = (i & 128) != 0 ? serversApiModelItem.password : bool;
        String str9 = (i & 256) != 0 ? serversApiModelItem.vk : str3;
        String str10 = (i & 512) != 0 ? serversApiModelItem.tg : str4;
        String str11 = (i & 1024) != 0 ? serversApiModelItem.inst : str5;
        String str12 = (i & 2048) != 0 ? serversApiModelItem.icon : str6;
        List<String> list3 = (i & 4096) != 0 ? serversApiModelItem.additionalIps : list;
        List<PlotPointApiModel> list4 = (i & 8192) != 0 ? serversApiModelItem.plotPoints : list2;
        Integer num13 = num8;
        Integer num14 = (i & 16384) != 0 ? serversApiModelItem.xdonate : num6;
        Integer num15 = (i & 32768) != 0 ? serversApiModelItem.xpayday : num7;
        Boolean bool7 = (i & 65536) != 0 ? serversApiModelItem.isNew : bool2;
        if ((i & 131072) != 0) {
            bool5 = bool7;
            bool4 = serversApiModelItem.isTop;
        } else {
            bool4 = bool3;
            bool5 = bool7;
        }
        return serversApiModelItem.copy(num13, str7, str8, num9, num10, num11, num12, bool6, str9, str10, str11, str12, list3, list4, num14, num15, bool5, bool4);
    }

    public final Integer component1() {
        return this.number;
    }

    public final String component10() {
        return this.tg;
    }

    public final String component11() {
        return this.inst;
    }

    public final String component12() {
        return this.icon;
    }

    public final List<String> component13() {
        return this.additionalIps;
    }

    public final List<PlotPointApiModel> component14() {
        return this.plotPoints;
    }

    public final Integer component15() {
        return this.xdonate;
    }

    public final Integer component16() {
        return this.xpayday;
    }

    public final Boolean component17() {
        return this.isNew;
    }

    public final Boolean component18() {
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
        return this.queue;
    }

    public final Integer component7() {
        return this.maxplayers;
    }

    public final Boolean component8() {
        return this.password;
    }

    public final String component9() {
        return this.vk;
    }

    public final ServersApiModelItem copy(Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Integer num5, Boolean bool, String str3, String str4, String str5, String str6, List<String> list, List<PlotPointApiModel> list2, Integer num6, Integer num7, Boolean bool2, Boolean bool3) {
        return new ServersApiModelItem(num, str, str2, num2, num3, num4, num5, bool, str3, str4, str5, str6, list, list2, num6, num7, bool2, bool3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServersApiModelItem) {
            ServersApiModelItem serversApiModelItem = (ServersApiModelItem) obj;
            return Intrinsics.areEqual(this.number, serversApiModelItem.number) && Intrinsics.areEqual(this.name, serversApiModelItem.name) && Intrinsics.areEqual(this.ip, serversApiModelItem.ip) && Intrinsics.areEqual(this.port, serversApiModelItem.port) && Intrinsics.areEqual(this.online, serversApiModelItem.online) && Intrinsics.areEqual(this.queue, serversApiModelItem.queue) && Intrinsics.areEqual(this.maxplayers, serversApiModelItem.maxplayers) && Intrinsics.areEqual(this.password, serversApiModelItem.password) && Intrinsics.areEqual(this.vk, serversApiModelItem.vk) && Intrinsics.areEqual(this.tg, serversApiModelItem.tg) && Intrinsics.areEqual(this.inst, serversApiModelItem.inst) && Intrinsics.areEqual(this.icon, serversApiModelItem.icon) && Intrinsics.areEqual(this.additionalIps, serversApiModelItem.additionalIps) && Intrinsics.areEqual(this.plotPoints, serversApiModelItem.plotPoints) && Intrinsics.areEqual(this.xdonate, serversApiModelItem.xdonate) && Intrinsics.areEqual(this.xpayday, serversApiModelItem.xpayday) && Intrinsics.areEqual(this.isNew, serversApiModelItem.isNew) && Intrinsics.areEqual(this.isTop, serversApiModelItem.isTop);
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
        Integer num4 = this.queue;
        int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.maxplayers;
        int hashCode7 = (hashCode6 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Boolean bool = this.password;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.vk;
        int hashCode9 = (hashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.tg;
        int hashCode10 = (hashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.inst;
        int hashCode11 = (hashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.icon;
        int hashCode12 = (hashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<String> list = this.additionalIps;
        int hashCode13 = (hashCode12 + (list == null ? 0 : list.hashCode())) * 31;
        List<PlotPointApiModel> list2 = this.plotPoints;
        int hashCode14 = (hashCode13 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num6 = this.xdonate;
        int hashCode15 = (hashCode14 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.xpayday;
        int hashCode16 = (hashCode15 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Boolean bool2 = this.isNew;
        int hashCode17 = (hashCode16 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isTop;
        return hashCode17 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        Integer num = this.number;
        String str = this.name;
        String str2 = this.ip;
        Integer num2 = this.port;
        Integer num3 = this.online;
        Integer num4 = this.queue;
        Integer num5 = this.maxplayers;
        Boolean bool = this.password;
        String str3 = this.vk;
        String str4 = this.tg;
        String str5 = this.inst;
        String str6 = this.icon;
        List<String> list = this.additionalIps;
        List<PlotPointApiModel> list2 = this.plotPoints;
        Integer num6 = this.xdonate;
        Integer num7 = this.xpayday;
        Boolean bool2 = this.isNew;
        return "ServersApiModelItem(number=" + num + ", name=" + str + ", ip=" + str2 + ", port=" + num2 + ", online=" + num3 + ", queue=" + num4 + ", maxplayers=" + num5 + ", password=" + bool + ", vk=" + str3 + ", tg=" + str4 + ", inst=" + str5 + ", icon=" + str6 + ", additionalIps=" + list + ", plotPoints=" + list2 + ", xdonate=" + num6 + ", xpayday=" + num7 + ", isNew=" + bool2 + ", isTop=" + this.isTop + ")";
    }

    public ServersApiModelItem(Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Integer num5, Boolean bool, String str3, String str4, String str5, String str6, List<String> list, List<PlotPointApiModel> list2, Integer num6, Integer num7, Boolean bool2, Boolean bool3) {
        this.number = num;
        this.name = str;
        this.ip = str2;
        this.port = num2;
        this.online = num3;
        this.queue = num4;
        this.maxplayers = num5;
        this.password = bool;
        this.vk = str3;
        this.tg = str4;
        this.inst = str5;
        this.icon = str6;
        this.additionalIps = list;
        this.plotPoints = list2;
        this.xdonate = num6;
        this.xpayday = num7;
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

    public final Integer getQueue() {
        return this.queue;
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
