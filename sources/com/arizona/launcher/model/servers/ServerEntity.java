package com.arizona.launcher.model.servers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerEntity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b2\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\t\u0010:\u001a\u00020\u0011HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\u009f\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0005HÆ\u0001J\u0013\u0010?\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010(R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010 R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001a¨\u0006C"}, d2 = {"Lcom/arizona/launcher/model/servers/ServerEntity;", "", "id", "", "address", "", "port", "hasPassword", "", "currentPlayerCount", "maxPlayerCount", "serverName", "tg", "vk", "inst", "favorite", "serverType", "Lcom/arizona/launcher/model/servers/ServerType;", "ping", "plotPoints", "serverIcon", "<init>", "(ILjava/lang/String;IZIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/arizona/launcher/model/servers/ServerType;ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getAddress", "()Ljava/lang/String;", "getPort", "getHasPassword", "()Z", "getCurrentPlayerCount", "setCurrentPlayerCount", "(I)V", "getMaxPlayerCount", "getServerName", "getTg", "getVk", "getInst", "getFavorite", "setFavorite", "(Z)V", "getServerType", "()Lcom/arizona/launcher/model/servers/ServerType;", "getPing", "setPing", "getPlotPoints", "getServerIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServerEntity {
    public static final int $stable = 8;
    private final String address;
    private int currentPlayerCount;
    private boolean favorite;
    private final boolean hasPassword;
    private final int id;
    private final String inst;
    private final int maxPlayerCount;
    private int ping;
    private final String plotPoints;
    private final int port;
    private final String serverIcon;
    private final String serverName;
    private final ServerType serverType;
    private final String tg;
    private final String vk;

    public final int component1() {
        return this.id;
    }

    public final String component10() {
        return this.inst;
    }

    public final boolean component11() {
        return this.favorite;
    }

    public final ServerType component12() {
        return this.serverType;
    }

    public final int component13() {
        return this.ping;
    }

    public final String component14() {
        return this.plotPoints;
    }

    public final String component15() {
        return this.serverIcon;
    }

    public final String component2() {
        return this.address;
    }

    public final int component3() {
        return this.port;
    }

    public final boolean component4() {
        return this.hasPassword;
    }

    public final int component5() {
        return this.currentPlayerCount;
    }

    public final int component6() {
        return this.maxPlayerCount;
    }

    public final String component7() {
        return this.serverName;
    }

    public final String component8() {
        return this.tg;
    }

    public final String component9() {
        return this.vk;
    }

    public final ServerEntity copy(int i, String address, int i2, boolean z, int i3, int i4, String serverName, String tg, String vk, String inst, boolean z2, ServerType serverType, int i5, String plotPoints, String serverIcon) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(serverName, "serverName");
        Intrinsics.checkNotNullParameter(tg, "tg");
        Intrinsics.checkNotNullParameter(vk, "vk");
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(serverType, "serverType");
        Intrinsics.checkNotNullParameter(plotPoints, "plotPoints");
        Intrinsics.checkNotNullParameter(serverIcon, "serverIcon");
        return new ServerEntity(i, address, i2, z, i3, i4, serverName, tg, vk, inst, z2, serverType, i5, plotPoints, serverIcon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServerEntity) {
            ServerEntity serverEntity = (ServerEntity) obj;
            return this.id == serverEntity.id && Intrinsics.areEqual(this.address, serverEntity.address) && this.port == serverEntity.port && this.hasPassword == serverEntity.hasPassword && this.currentPlayerCount == serverEntity.currentPlayerCount && this.maxPlayerCount == serverEntity.maxPlayerCount && Intrinsics.areEqual(this.serverName, serverEntity.serverName) && Intrinsics.areEqual(this.tg, serverEntity.tg) && Intrinsics.areEqual(this.vk, serverEntity.vk) && Intrinsics.areEqual(this.inst, serverEntity.inst) && this.favorite == serverEntity.favorite && this.serverType == serverEntity.serverType && this.ping == serverEntity.ping && Intrinsics.areEqual(this.plotPoints, serverEntity.plotPoints) && Intrinsics.areEqual(this.serverIcon, serverEntity.serverIcon);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((Integer.hashCode(this.id) * 31) + this.address.hashCode()) * 31) + Integer.hashCode(this.port)) * 31) + Boolean.hashCode(this.hasPassword)) * 31) + Integer.hashCode(this.currentPlayerCount)) * 31) + Integer.hashCode(this.maxPlayerCount)) * 31) + this.serverName.hashCode()) * 31) + this.tg.hashCode()) * 31) + this.vk.hashCode()) * 31) + this.inst.hashCode()) * 31) + Boolean.hashCode(this.favorite)) * 31) + this.serverType.hashCode()) * 31) + Integer.hashCode(this.ping)) * 31) + this.plotPoints.hashCode()) * 31) + this.serverIcon.hashCode();
    }

    public String toString() {
        int i = this.id;
        String str = this.address;
        int i2 = this.port;
        boolean z = this.hasPassword;
        int i3 = this.currentPlayerCount;
        int i4 = this.maxPlayerCount;
        String str2 = this.serverName;
        String str3 = this.tg;
        String str4 = this.vk;
        String str5 = this.inst;
        boolean z2 = this.favorite;
        ServerType serverType = this.serverType;
        int i5 = this.ping;
        String str6 = this.plotPoints;
        return "ServerEntity(id=" + i + ", address=" + str + ", port=" + i2 + ", hasPassword=" + z + ", currentPlayerCount=" + i3 + ", maxPlayerCount=" + i4 + ", serverName=" + str2 + ", tg=" + str3 + ", vk=" + str4 + ", inst=" + str5 + ", favorite=" + z2 + ", serverType=" + serverType + ", ping=" + i5 + ", plotPoints=" + str6 + ", serverIcon=" + this.serverIcon + ")";
    }

    public ServerEntity(int i, String address, int i2, boolean z, int i3, int i4, String serverName, String tg, String vk, String inst, boolean z2, ServerType serverType, int i5, String plotPoints, String serverIcon) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(serverName, "serverName");
        Intrinsics.checkNotNullParameter(tg, "tg");
        Intrinsics.checkNotNullParameter(vk, "vk");
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(serverType, "serverType");
        Intrinsics.checkNotNullParameter(plotPoints, "plotPoints");
        Intrinsics.checkNotNullParameter(serverIcon, "serverIcon");
        this.id = i;
        this.address = address;
        this.port = i2;
        this.hasPassword = z;
        this.currentPlayerCount = i3;
        this.maxPlayerCount = i4;
        this.serverName = serverName;
        this.tg = tg;
        this.vk = vk;
        this.inst = inst;
        this.favorite = z2;
        this.serverType = serverType;
        this.ping = i5;
        this.plotPoints = plotPoints;
        this.serverIcon = serverIcon;
    }

    public final int getId() {
        return this.id;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getPort() {
        return this.port;
    }

    public final boolean getHasPassword() {
        return this.hasPassword;
    }

    public final int getCurrentPlayerCount() {
        return this.currentPlayerCount;
    }

    public final void setCurrentPlayerCount(int i) {
        this.currentPlayerCount = i;
    }

    public final int getMaxPlayerCount() {
        return this.maxPlayerCount;
    }

    public final String getServerName() {
        return this.serverName;
    }

    public final String getTg() {
        return this.tg;
    }

    public final String getVk() {
        return this.vk;
    }

    public final String getInst() {
        return this.inst;
    }

    public final boolean getFavorite() {
        return this.favorite;
    }

    public final void setFavorite(boolean z) {
        this.favorite = z;
    }

    public final ServerType getServerType() {
        return this.serverType;
    }

    public final int getPing() {
        return this.ping;
    }

    public final void setPing(int i) {
        this.ping = i;
    }

    public final String getPlotPoints() {
        return this.plotPoints;
    }

    public final String getServerIcon() {
        return this.serverIcon;
    }
}
