package com.miami.game.core.server.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FavoriteServerEntity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/miami/game/core/server/data/FavoriteServerEntity;", "", "serverId", "", "serverName", "", "<init>", "(ILjava/lang/String;)V", "getServerId", "()I", "getServerName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "server_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FavoriteServerEntity {
    private final int serverId;
    private final String serverName;

    public static /* synthetic */ FavoriteServerEntity copy$default(FavoriteServerEntity favoriteServerEntity, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = favoriteServerEntity.serverId;
        }
        if ((i2 & 2) != 0) {
            str = favoriteServerEntity.serverName;
        }
        return favoriteServerEntity.copy(i, str);
    }

    public final int component1() {
        return this.serverId;
    }

    public final String component2() {
        return this.serverName;
    }

    public final FavoriteServerEntity copy(int i, String serverName) {
        Intrinsics.checkNotNullParameter(serverName, "serverName");
        return new FavoriteServerEntity(i, serverName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FavoriteServerEntity) {
            FavoriteServerEntity favoriteServerEntity = (FavoriteServerEntity) obj;
            return this.serverId == favoriteServerEntity.serverId && Intrinsics.areEqual(this.serverName, favoriteServerEntity.serverName);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.serverId) * 31) + this.serverName.hashCode();
    }

    public String toString() {
        int i = this.serverId;
        return "FavoriteServerEntity(serverId=" + i + ", serverName=" + this.serverName + ")";
    }

    public FavoriteServerEntity(int i, String serverName) {
        Intrinsics.checkNotNullParameter(serverName, "serverName");
        this.serverId = i;
        this.serverName = serverName;
    }

    public final int getServerId() {
        return this.serverId;
    }

    public final String getServerName() {
        return this.serverName;
    }
}
