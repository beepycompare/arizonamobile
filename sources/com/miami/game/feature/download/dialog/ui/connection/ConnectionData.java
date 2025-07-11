package com.miami.game.feature.download.dialog.ui.connection;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConnectionData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;", "", "ip", "", "port", HintConstants.AUTOFILL_HINT_PASSWORD, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIp", "()Ljava/lang/String;", "getPort", "getPassword", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionData {
    public static final int $stable = 0;
    private final String ip;
    private final String password;
    private final String port;

    public ConnectionData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ConnectionData copy$default(ConnectionData connectionData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = connectionData.ip;
        }
        if ((i & 2) != 0) {
            str2 = connectionData.port;
        }
        if ((i & 4) != 0) {
            str3 = connectionData.password;
        }
        return connectionData.copy(str, str2, str3);
    }

    public final String component1() {
        return this.ip;
    }

    public final String component2() {
        return this.port;
    }

    public final String component3() {
        return this.password;
    }

    public final ConnectionData copy(String ip, String port, String password) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(password, "password");
        return new ConnectionData(ip, port, password);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConnectionData) {
            ConnectionData connectionData = (ConnectionData) obj;
            return Intrinsics.areEqual(this.ip, connectionData.ip) && Intrinsics.areEqual(this.port, connectionData.port) && Intrinsics.areEqual(this.password, connectionData.password);
        }
        return false;
    }

    public int hashCode() {
        return (((this.ip.hashCode() * 31) + this.port.hashCode()) * 31) + this.password.hashCode();
    }

    public String toString() {
        String str = this.ip;
        String str2 = this.port;
        return "ConnectionData(ip=" + str + ", port=" + str2 + ", password=" + this.password + ")";
    }

    public ConnectionData(String ip, String port, String password) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(password, "password");
        this.ip = ip;
        this.port = port;
        this.password = password;
    }

    public /* synthetic */ ConnectionData(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "192.168.0.133" : str, (i & 2) != 0 ? "7777" : str2, (i & 4) != 0 ? HintConstants.AUTOFILL_HINT_PASSWORD : str3);
    }

    public final String getIp() {
        return this.ip;
    }

    public final String getPort() {
        return this.port;
    }

    public final String getPassword() {
        return this.password;
    }
}
