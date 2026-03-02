package ru.mrlargha.commonui.elements.hud.presentation.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerInfoItem.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/models/ServerInfoItem;", "", "token", "", "server", "", "accountId", "<init>", "(Ljava/lang/String;II)V", "getToken", "()Ljava/lang/String;", "getServer", "()I", "getAccountId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ServerInfoItem {
    @SerializedName("accountid")
    private final int accountId;
    private final int server;
    private final String token;

    public static /* synthetic */ ServerInfoItem copy$default(ServerInfoItem serverInfoItem, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = serverInfoItem.token;
        }
        if ((i3 & 2) != 0) {
            i = serverInfoItem.server;
        }
        if ((i3 & 4) != 0) {
            i2 = serverInfoItem.accountId;
        }
        return serverInfoItem.copy(str, i, i2);
    }

    public final String component1() {
        return this.token;
    }

    public final int component2() {
        return this.server;
    }

    public final int component3() {
        return this.accountId;
    }

    public final ServerInfoItem copy(String token, int i, int i2) {
        Intrinsics.checkNotNullParameter(token, "token");
        return new ServerInfoItem(token, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServerInfoItem) {
            ServerInfoItem serverInfoItem = (ServerInfoItem) obj;
            return Intrinsics.areEqual(this.token, serverInfoItem.token) && this.server == serverInfoItem.server && this.accountId == serverInfoItem.accountId;
        }
        return false;
    }

    public int hashCode() {
        return (((this.token.hashCode() * 31) + Integer.hashCode(this.server)) * 31) + Integer.hashCode(this.accountId);
    }

    public String toString() {
        String str = this.token;
        int i = this.server;
        return "ServerInfoItem(token=" + str + ", server=" + i + ", accountId=" + this.accountId + ")";
    }

    public ServerInfoItem(String token, int i, int i2) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.token = token;
        this.server = i;
        this.accountId = i2;
    }

    public final String getToken() {
        return this.token;
    }

    public final int getServer() {
        return this.server;
    }

    public final int getAccountId() {
        return this.accountId;
    }
}
