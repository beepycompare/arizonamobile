package com.arizona.launcher.model.servers;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FavoriteServer.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/model/servers/FavoriteServer;", "", "serverId", "", "serverType", "", "<init>", "(ILjava/lang/String;)V", "getServerId", "()I", "getServerType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FavoriteServer {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int serverId;
    private final String serverType;

    public static /* synthetic */ FavoriteServer copy$default(FavoriteServer favoriteServer, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = favoriteServer.serverId;
        }
        if ((i2 & 2) != 0) {
            str = favoriteServer.serverType;
        }
        return favoriteServer.copy(i, str);
    }

    public final int component1() {
        return this.serverId;
    }

    public final String component2() {
        return this.serverType;
    }

    public final FavoriteServer copy(int i, String serverType) {
        Intrinsics.checkNotNullParameter(serverType, "serverType");
        return new FavoriteServer(i, serverType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FavoriteServer) {
            FavoriteServer favoriteServer = (FavoriteServer) obj;
            return this.serverId == favoriteServer.serverId && Intrinsics.areEqual(this.serverType, favoriteServer.serverType);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.serverId) * 31) + this.serverType.hashCode();
    }

    public String toString() {
        int i = this.serverId;
        return "FavoriteServer(serverId=" + i + ", serverType=" + this.serverType + ")";
    }

    public FavoriteServer(int i, String serverType) {
        Intrinsics.checkNotNullParameter(serverType, "serverType");
        this.serverId = i;
        this.serverType = serverType;
    }

    public final int getServerId() {
        return this.serverId;
    }

    /* compiled from: FavoriteServer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/model/servers/FavoriteServer$Companion;", "", "<init>", "()V", "fromSAMPServerInfo", "Lcom/arizona/launcher/model/servers/FavoriteServer;", "info", "Lcom/arizona/launcher/model/servers/SAMPServerInfo;", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FavoriteServer fromSAMPServerInfo(SAMPServerInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return new FavoriteServer(info.getId(), info.getServerType().getServerName());
        }
    }

    public final String getServerType() {
        return this.serverType;
    }
}
