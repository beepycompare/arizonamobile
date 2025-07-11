package com.miami.game.core.server.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServersState.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003Jc\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\rHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/miami/game/core/server/model/ServersState;", "", "currentServer", "Lcom/miami/game/core/server/model/ServerModel;", "serverListMobile", "", "serverListDesktop", "serverListFavorite", "selectedCategory", "Lcom/miami/game/core/server/model/ServerStateCategory;", "isError", "", "xDonate", "", "<init>", "(Lcom/miami/game/core/server/model/ServerModel;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/miami/game/core/server/model/ServerStateCategory;ZI)V", "getCurrentServer", "()Lcom/miami/game/core/server/model/ServerModel;", "getServerListMobile", "()Ljava/util/List;", "getServerListDesktop", "getServerListFavorite", "getSelectedCategory", "()Lcom/miami/game/core/server/model/ServerStateCategory;", "()Z", "getXDonate", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "server_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServersState {
    private final ServerModel currentServer;
    private final boolean isError;
    private final ServerStateCategory selectedCategory;
    private final List<ServerModel> serverListDesktop;
    private final List<ServerModel> serverListFavorite;
    private final List<ServerModel> serverListMobile;
    private final int xDonate;

    public ServersState() {
        this(null, null, null, null, null, false, 0, 127, null);
    }

    public static /* synthetic */ ServersState copy$default(ServersState serversState, ServerModel serverModel, List list, List list2, List list3, ServerStateCategory serverStateCategory, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            serverModel = serversState.currentServer;
        }
        List<ServerModel> list4 = list;
        if ((i2 & 2) != 0) {
            list4 = serversState.serverListMobile;
        }
        List<ServerModel> list5 = list2;
        if ((i2 & 4) != 0) {
            list5 = serversState.serverListDesktop;
        }
        List<ServerModel> list6 = list3;
        if ((i2 & 8) != 0) {
            list6 = serversState.serverListFavorite;
        }
        if ((i2 & 16) != 0) {
            serverStateCategory = serversState.selectedCategory;
        }
        if ((i2 & 32) != 0) {
            z = serversState.isError;
        }
        if ((i2 & 64) != 0) {
            i = serversState.xDonate;
        }
        boolean z2 = z;
        int i3 = i;
        ServerStateCategory serverStateCategory2 = serverStateCategory;
        List list7 = list5;
        return serversState.copy(serverModel, list4, list7, list6, serverStateCategory2, z2, i3);
    }

    public final ServerModel component1() {
        return this.currentServer;
    }

    public final List<ServerModel> component2() {
        return this.serverListMobile;
    }

    public final List<ServerModel> component3() {
        return this.serverListDesktop;
    }

    public final List<ServerModel> component4() {
        return this.serverListFavorite;
    }

    public final ServerStateCategory component5() {
        return this.selectedCategory;
    }

    public final boolean component6() {
        return this.isError;
    }

    public final int component7() {
        return this.xDonate;
    }

    public final ServersState copy(ServerModel serverModel, List<ServerModel> serverListMobile, List<ServerModel> serverListDesktop, List<ServerModel> serverListFavorite, ServerStateCategory selectedCategory, boolean z, int i) {
        Intrinsics.checkNotNullParameter(serverListMobile, "serverListMobile");
        Intrinsics.checkNotNullParameter(serverListDesktop, "serverListDesktop");
        Intrinsics.checkNotNullParameter(serverListFavorite, "serverListFavorite");
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        return new ServersState(serverModel, serverListMobile, serverListDesktop, serverListFavorite, selectedCategory, z, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServersState) {
            ServersState serversState = (ServersState) obj;
            return Intrinsics.areEqual(this.currentServer, serversState.currentServer) && Intrinsics.areEqual(this.serverListMobile, serversState.serverListMobile) && Intrinsics.areEqual(this.serverListDesktop, serversState.serverListDesktop) && Intrinsics.areEqual(this.serverListFavorite, serversState.serverListFavorite) && this.selectedCategory == serversState.selectedCategory && this.isError == serversState.isError && this.xDonate == serversState.xDonate;
        }
        return false;
    }

    public int hashCode() {
        ServerModel serverModel = this.currentServer;
        return ((((((((((((serverModel == null ? 0 : serverModel.hashCode()) * 31) + this.serverListMobile.hashCode()) * 31) + this.serverListDesktop.hashCode()) * 31) + this.serverListFavorite.hashCode()) * 31) + this.selectedCategory.hashCode()) * 31) + Boolean.hashCode(this.isError)) * 31) + Integer.hashCode(this.xDonate);
    }

    public String toString() {
        ServerModel serverModel = this.currentServer;
        List<ServerModel> list = this.serverListMobile;
        List<ServerModel> list2 = this.serverListDesktop;
        List<ServerModel> list3 = this.serverListFavorite;
        ServerStateCategory serverStateCategory = this.selectedCategory;
        boolean z = this.isError;
        return "ServersState(currentServer=" + serverModel + ", serverListMobile=" + list + ", serverListDesktop=" + list2 + ", serverListFavorite=" + list3 + ", selectedCategory=" + serverStateCategory + ", isError=" + z + ", xDonate=" + this.xDonate + ")";
    }

    public ServersState(ServerModel serverModel, List<ServerModel> serverListMobile, List<ServerModel> serverListDesktop, List<ServerModel> serverListFavorite, ServerStateCategory selectedCategory, boolean z, int i) {
        Intrinsics.checkNotNullParameter(serverListMobile, "serverListMobile");
        Intrinsics.checkNotNullParameter(serverListDesktop, "serverListDesktop");
        Intrinsics.checkNotNullParameter(serverListFavorite, "serverListFavorite");
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        this.currentServer = serverModel;
        this.serverListMobile = serverListMobile;
        this.serverListDesktop = serverListDesktop;
        this.serverListFavorite = serverListFavorite;
        this.selectedCategory = selectedCategory;
        this.isError = z;
        this.xDonate = i;
    }

    public final ServerModel getCurrentServer() {
        return this.currentServer;
    }

    public /* synthetic */ ServersState(ServerModel serverModel, List list, List list2, List list3, ServerStateCategory serverStateCategory, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i3;
        boolean z2;
        List list4;
        ServerStateCategory serverStateCategory2;
        List list5;
        List list6;
        ServersState serversState;
        ServerModel serverModel2;
        serverModel = (i2 & 1) != 0 ? null : serverModel;
        list = (i2 & 2) != 0 ? CollectionsKt.emptyList() : list;
        list2 = (i2 & 4) != 0 ? CollectionsKt.emptyList() : list2;
        list3 = (i2 & 8) != 0 ? CollectionsKt.emptyList() : list3;
        serverStateCategory = (i2 & 16) != 0 ? ServerStateCategory.Desktop : serverStateCategory;
        z = (i2 & 32) != 0 ? false : z;
        if ((i2 & 64) != 0) {
            i3 = 0;
            serverStateCategory2 = serverStateCategory;
            z2 = z;
            list6 = list2;
            list4 = list3;
            serverModel2 = serverModel;
            list5 = list;
            serversState = this;
        } else {
            i3 = i;
            z2 = z;
            list4 = list3;
            serverStateCategory2 = serverStateCategory;
            list5 = list;
            list6 = list2;
            serversState = this;
            serverModel2 = serverModel;
        }
        new ServersState(serverModel2, list5, list6, list4, serverStateCategory2, z2, i3);
    }

    public final List<ServerModel> getServerListMobile() {
        return this.serverListMobile;
    }

    public final List<ServerModel> getServerListDesktop() {
        return this.serverListDesktop;
    }

    public final List<ServerModel> getServerListFavorite() {
        return this.serverListFavorite;
    }

    public final ServerStateCategory getSelectedCategory() {
        return this.selectedCategory;
    }

    public final boolean isError() {
        return this.isError;
    }

    public final int getXDonate() {
        return this.xDonate;
    }
}
