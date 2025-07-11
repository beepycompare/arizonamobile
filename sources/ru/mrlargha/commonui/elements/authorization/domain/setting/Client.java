package ru.mrlargha.commonui.elements.authorization.domain.setting;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Client.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/setting/Client;", "", "server", "Lru/mrlargha/commonui/elements/authorization/domain/setting/Server;", "<init>", "(Lru/mrlargha/commonui/elements/authorization/domain/setting/Server;)V", "getServer", "()Lru/mrlargha/commonui/elements/authorization/domain/setting/Server;", "setServer", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Client {
    @SerializedName("server")
    private Server server;

    public Client() {
        this(null, 1, null);
    }

    public static /* synthetic */ Client copy$default(Client client, Server server, int i, Object obj) {
        if ((i & 1) != 0) {
            server = client.server;
        }
        return client.copy(server);
    }

    public final Server component1() {
        return this.server;
    }

    public final Client copy(Server server) {
        return new Client(server);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Client) && Intrinsics.areEqual(this.server, ((Client) obj).server);
    }

    public int hashCode() {
        Server server = this.server;
        if (server == null) {
            return 0;
        }
        return server.hashCode();
    }

    public String toString() {
        return "Client(server=" + this.server + ")";
    }

    public Client(Server server) {
        this.server = server;
    }

    public /* synthetic */ Client(Server server, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Server(null, null, 3, null) : server);
    }

    public final Server getServer() {
        return this.server;
    }

    public final void setServer(Server server) {
        this.server = server;
    }
}
