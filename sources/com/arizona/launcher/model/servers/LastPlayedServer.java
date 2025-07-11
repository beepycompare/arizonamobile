package com.arizona.launcher.model.servers;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LastPlayedServer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/model/servers/LastPlayedServer;", "", "serverId", "", "serverType", "", "date", "Ljava/util/Date;", "<init>", "(ILjava/lang/String;Ljava/util/Date;)V", "getServerId", "()I", "getServerType", "()Ljava/lang/String;", "getDate", "()Ljava/util/Date;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LastPlayedServer {
    private final Date date;
    private final int serverId;
    private final String serverType;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ LastPlayedServer copy$default(LastPlayedServer lastPlayedServer, int i, String str, Date date, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = lastPlayedServer.serverId;
        }
        if ((i2 & 2) != 0) {
            str = lastPlayedServer.serverType;
        }
        if ((i2 & 4) != 0) {
            date = lastPlayedServer.date;
        }
        return lastPlayedServer.copy(i, str, date);
    }

    public final int component1() {
        return this.serverId;
    }

    public final String component2() {
        return this.serverType;
    }

    public final Date component3() {
        return this.date;
    }

    public final LastPlayedServer copy(int i, String serverType, Date date) {
        Intrinsics.checkNotNullParameter(serverType, "serverType");
        Intrinsics.checkNotNullParameter(date, "date");
        return new LastPlayedServer(i, serverType, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LastPlayedServer) {
            LastPlayedServer lastPlayedServer = (LastPlayedServer) obj;
            return this.serverId == lastPlayedServer.serverId && Intrinsics.areEqual(this.serverType, lastPlayedServer.serverType) && Intrinsics.areEqual(this.date, lastPlayedServer.date);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.serverId) * 31) + this.serverType.hashCode()) * 31) + this.date.hashCode();
    }

    public String toString() {
        int i = this.serverId;
        String str = this.serverType;
        return "LastPlayedServer(serverId=" + i + ", serverType=" + str + ", date=" + this.date + ")";
    }

    public LastPlayedServer(int i, String serverType, Date date) {
        Intrinsics.checkNotNullParameter(serverType, "serverType");
        Intrinsics.checkNotNullParameter(date, "date");
        this.serverId = i;
        this.serverType = serverType;
        this.date = date;
    }

    public final int getServerId() {
        return this.serverId;
    }

    public final String getServerType() {
        return this.serverType;
    }

    public /* synthetic */ LastPlayedServer(int i, String str, Date date, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? new Date() : date);
    }

    public final Date getDate() {
        return this.date;
    }

    /* compiled from: LastPlayedServer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/model/servers/LastPlayedServer$Companion;", "", "<init>", "()V", "fromSAMPServerInfo", "Lcom/arizona/launcher/model/servers/LastPlayedServer;", "info", "Lcom/arizona/launcher/model/servers/SAMPServerInfo;", "date", "Ljava/util/Date;", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LastPlayedServer fromSAMPServerInfo(SAMPServerInfo info, Date date) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(date, "date");
            return new LastPlayedServer(info.getId(), info.getServerType().getServerName(), date);
        }
    }
}
