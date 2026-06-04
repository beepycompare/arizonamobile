package com.miami.game.core.server.model;

import androidx.autofill.HintConstants;
import com.miami.game.core.api.model.response.servers.PlotPointApiModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b<\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010<\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012HÆ\u0003J\u0011\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010E\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010F\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010)J\t\u0010G\u001a\u00020\fHÆ\u0003J\t\u0010H\u001a\u00020\fHÆ\u0003J\t\u0010I\u001a\u00020\fHÆ\u0003J\u0090\u0002\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010KJ\u0014\u0010L\u001a\u00020\f2\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010N\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010O\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b&\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b'\u0010\u001fR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b2\u0010\u001fR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b3\u0010\u001fR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010*\u001a\u0004\b\u0017\u0010)R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010*\u001a\u0004\b\u0018\u0010)R\u0011\u0010\u0019\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u00104R\u0011\u0010\u001a\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u00104R\u0011\u0010\u001b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u00104¨\u0006P"}, d2 = {"Lcom/miami/game/core/server/model/ServerModel;", "", "number", "", "name", "", "ip", "port", "online", "queue", "maxplayers", HintConstants.AUTOFILL_HINT_PASSWORD, "", "vk", "tg", "inst", "icon", "additionalIps", "", "plotPoints", "Lcom/miami/game/core/api/model/response/servers/PlotPointApiModel;", "xdonate", "xpayday", "isTop", "isNew", "isFavorite", "isMobile", "isArizona", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZZ)V", "getNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getIp", "getPort", "getOnline", "getQueue", "getMaxplayers", "getPassword", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVk", "getTg", "getInst", "getIcon", "getAdditionalIps", "()Ljava/util/List;", "getPlotPoints", "getXdonate", "getXpayday", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZZ)Lcom/miami/game/core/server/model/ServerModel;", "equals", "other", "hashCode", "toString", "server"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServerModel {
    private final List<String> additionalIps;
    private final String icon;
    private final String inst;
    private final String ip;
    private final boolean isArizona;
    private final boolean isFavorite;
    private final boolean isMobile;
    private final Boolean isNew;
    private final Boolean isTop;
    private final Integer maxplayers;
    private final String name;
    private final Integer number;
    private final Integer online;
    private final Boolean password;
    private final List<PlotPointApiModel> plotPoints;
    private final Integer port;
    private final Integer queue;
    private final String tg;
    private final String vk;
    private final Integer xdonate;
    private final Integer xpayday;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServerModel copy$default(ServerModel serverModel, Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Integer num5, Boolean bool, String str3, String str4, String str5, String str6, List list, List list2, Integer num6, Integer num7, Boolean bool2, Boolean bool3, boolean z, boolean z2, boolean z3, int i, Object obj) {
        boolean z4;
        boolean z5;
        Integer num8 = (i & 1) != 0 ? serverModel.number : num;
        String str7 = (i & 2) != 0 ? serverModel.name : str;
        String str8 = (i & 4) != 0 ? serverModel.ip : str2;
        Integer num9 = (i & 8) != 0 ? serverModel.port : num2;
        Integer num10 = (i & 16) != 0 ? serverModel.online : num3;
        Integer num11 = (i & 32) != 0 ? serverModel.queue : num4;
        Integer num12 = (i & 64) != 0 ? serverModel.maxplayers : num5;
        Boolean bool4 = (i & 128) != 0 ? serverModel.password : bool;
        String str9 = (i & 256) != 0 ? serverModel.vk : str3;
        String str10 = (i & 512) != 0 ? serverModel.tg : str4;
        String str11 = (i & 1024) != 0 ? serverModel.inst : str5;
        String str12 = (i & 2048) != 0 ? serverModel.icon : str6;
        List<String> list3 = (i & 4096) != 0 ? serverModel.additionalIps : list;
        List<PlotPointApiModel> list4 = (i & 8192) != 0 ? serverModel.plotPoints : list2;
        Integer num13 = num8;
        Integer num14 = (i & 16384) != 0 ? serverModel.xdonate : num6;
        Integer num15 = (i & 32768) != 0 ? serverModel.xpayday : num7;
        Boolean bool5 = (i & 65536) != 0 ? serverModel.isTop : bool2;
        Boolean bool6 = (i & 131072) != 0 ? serverModel.isNew : bool3;
        boolean z6 = (i & 262144) != 0 ? serverModel.isFavorite : z;
        boolean z7 = (i & 524288) != 0 ? serverModel.isMobile : z2;
        if ((i & 1048576) != 0) {
            z5 = z7;
            z4 = serverModel.isArizona;
        } else {
            z4 = z3;
            z5 = z7;
        }
        return serverModel.copy(num13, str7, str8, num9, num10, num11, num12, bool4, str9, str10, str11, str12, list3, list4, num14, num15, bool5, bool6, z6, z5, z4);
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
        return this.isTop;
    }

    public final Boolean component18() {
        return this.isNew;
    }

    public final boolean component19() {
        return this.isFavorite;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component20() {
        return this.isMobile;
    }

    public final boolean component21() {
        return this.isArizona;
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

    public final ServerModel copy(Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Integer num5, Boolean bool, String str3, String str4, String str5, String str6, List<String> list, List<PlotPointApiModel> list2, Integer num6, Integer num7, Boolean bool2, Boolean bool3, boolean z, boolean z2, boolean z3) {
        return new ServerModel(num, str, str2, num2, num3, num4, num5, bool, str3, str4, str5, str6, list, list2, num6, num7, bool2, bool3, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServerModel) {
            ServerModel serverModel = (ServerModel) obj;
            return Intrinsics.areEqual(this.number, serverModel.number) && Intrinsics.areEqual(this.name, serverModel.name) && Intrinsics.areEqual(this.ip, serverModel.ip) && Intrinsics.areEqual(this.port, serverModel.port) && Intrinsics.areEqual(this.online, serverModel.online) && Intrinsics.areEqual(this.queue, serverModel.queue) && Intrinsics.areEqual(this.maxplayers, serverModel.maxplayers) && Intrinsics.areEqual(this.password, serverModel.password) && Intrinsics.areEqual(this.vk, serverModel.vk) && Intrinsics.areEqual(this.tg, serverModel.tg) && Intrinsics.areEqual(this.inst, serverModel.inst) && Intrinsics.areEqual(this.icon, serverModel.icon) && Intrinsics.areEqual(this.additionalIps, serverModel.additionalIps) && Intrinsics.areEqual(this.plotPoints, serverModel.plotPoints) && Intrinsics.areEqual(this.xdonate, serverModel.xdonate) && Intrinsics.areEqual(this.xpayday, serverModel.xpayday) && Intrinsics.areEqual(this.isTop, serverModel.isTop) && Intrinsics.areEqual(this.isNew, serverModel.isNew) && this.isFavorite == serverModel.isFavorite && this.isMobile == serverModel.isMobile && this.isArizona == serverModel.isArizona;
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
        Boolean bool2 = this.isTop;
        int hashCode17 = (hashCode16 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isNew;
        return ((((((hashCode17 + (bool3 != null ? bool3.hashCode() : 0)) * 31) + Boolean.hashCode(this.isFavorite)) * 31) + Boolean.hashCode(this.isMobile)) * 31) + Boolean.hashCode(this.isArizona);
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
        Boolean bool2 = this.isTop;
        Boolean bool3 = this.isNew;
        boolean z = this.isFavorite;
        boolean z2 = this.isMobile;
        return "ServerModel(number=" + num + ", name=" + str + ", ip=" + str2 + ", port=" + num2 + ", online=" + num3 + ", queue=" + num4 + ", maxplayers=" + num5 + ", password=" + bool + ", vk=" + str3 + ", tg=" + str4 + ", inst=" + str5 + ", icon=" + str6 + ", additionalIps=" + list + ", plotPoints=" + list2 + ", xdonate=" + num6 + ", xpayday=" + num7 + ", isTop=" + bool2 + ", isNew=" + bool3 + ", isFavorite=" + z + ", isMobile=" + z2 + ", isArizona=" + this.isArizona + ")";
    }

    public ServerModel(Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Integer num5, Boolean bool, String str3, String str4, String str5, String str6, List<String> list, List<PlotPointApiModel> list2, Integer num6, Integer num7, Boolean bool2, Boolean bool3, boolean z, boolean z2, boolean z3) {
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
        this.isTop = bool2;
        this.isNew = bool3;
        this.isFavorite = z;
        this.isMobile = z2;
        this.isArizona = z3;
    }

    public /* synthetic */ ServerModel(Integer num, String str, String str2, Integer num2, Integer num3, Integer num4, Integer num5, Boolean bool, String str3, String str4, String str5, String str6, List list, List list2, Integer num6, Integer num7, Boolean bool2, Boolean bool3, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str, str2, num2, num3, num4, num5, bool, str3, str4, str5, str6, list, list2, num6, num7, bool2, bool3, (i & 262144) != 0 ? false : z, (i & 524288) != 0 ? false : z2, (i & 1048576) != 0 ? true : z3);
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

    public final Boolean isTop() {
        return this.isTop;
    }

    public final Boolean isNew() {
        return this.isNew;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public final boolean isMobile() {
        return this.isMobile;
    }

    public final boolean isArizona() {
        return this.isArizona;
    }
}
