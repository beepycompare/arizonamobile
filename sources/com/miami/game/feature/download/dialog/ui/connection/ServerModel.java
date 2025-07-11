package com.miami.game.feature.download.dialog.ui.connection;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConnectionHolder.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/miami/game/feature/download/dialog/ui/connection/ServerModel;", "", "number", "", "ip", "", "port", HintConstants.AUTOFILL_HINT_PASSWORD, "isMobile", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getNumber", "()I", "getIp", "()Ljava/lang/String;", "getPort", "getPassword", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "dialogs_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerModel {
    public static final int $stable = 0;
    private final String ip;
    private final boolean isMobile;
    private final int number;
    private final String password;
    private final String port;

    public ServerModel() {
        this(0, null, null, null, false, 31, null);
    }

    public static /* synthetic */ ServerModel copy$default(ServerModel serverModel, int i, String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = serverModel.number;
        }
        if ((i2 & 2) != 0) {
            str = serverModel.ip;
        }
        if ((i2 & 4) != 0) {
            str2 = serverModel.port;
        }
        if ((i2 & 8) != 0) {
            str3 = serverModel.password;
        }
        if ((i2 & 16) != 0) {
            z = serverModel.isMobile;
        }
        boolean z2 = z;
        String str4 = str2;
        return serverModel.copy(i, str, str4, str3, z2);
    }

    public final int component1() {
        return this.number;
    }

    public final String component2() {
        return this.ip;
    }

    public final String component3() {
        return this.port;
    }

    public final String component4() {
        return this.password;
    }

    public final boolean component5() {
        return this.isMobile;
    }

    public final ServerModel copy(int i, String ip, String port, String password, boolean z) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(password, "password");
        return new ServerModel(i, ip, port, password, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServerModel) {
            ServerModel serverModel = (ServerModel) obj;
            return this.number == serverModel.number && Intrinsics.areEqual(this.ip, serverModel.ip) && Intrinsics.areEqual(this.port, serverModel.port) && Intrinsics.areEqual(this.password, serverModel.password) && this.isMobile == serverModel.isMobile;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.number) * 31) + this.ip.hashCode()) * 31) + this.port.hashCode()) * 31) + this.password.hashCode()) * 31) + Boolean.hashCode(this.isMobile);
    }

    public String toString() {
        int i = this.number;
        String str = this.ip;
        String str2 = this.port;
        String str3 = this.password;
        return "ServerModel(number=" + i + ", ip=" + str + ", port=" + str2 + ", password=" + str3 + ", isMobile=" + this.isMobile + ")";
    }

    public ServerModel(int i, String ip, String port, String password, boolean z) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(port, "port");
        Intrinsics.checkNotNullParameter(password, "password");
        this.number = i;
        this.ip = ip;
        this.port = port;
        this.password = password;
        this.isMobile = z;
    }

    public /* synthetic */ ServerModel(int i, String str, String str2, String str3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? false : z);
    }

    public final int getNumber() {
        return this.number;
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

    public final boolean isMobile() {
        return this.isMobile;
    }
}
