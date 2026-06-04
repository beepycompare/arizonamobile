package com.miami.game.core.server.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServersState.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003Js\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0014\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010)\u001a\u00020*HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/miami/game/core/server/model/ServersState;", "", "currentServer", "Lcom/miami/game/core/server/model/ServerModel;", "serverListMobile", "", "serverListDesktop", "serverListVc", "serverListFavorite", "selectedCategory", "Lcom/miami/game/core/server/model/ServerStateCategory;", "isError", "", "xDonate", "", "<init>", "(Lcom/miami/game/core/server/model/ServerModel;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/miami/game/core/server/model/ServerStateCategory;ZI)V", "getCurrentServer", "()Lcom/miami/game/core/server/model/ServerModel;", "getServerListMobile", "()Ljava/util/List;", "getServerListDesktop", "getServerListVc", "getServerListFavorite", "getSelectedCategory", "()Lcom/miami/game/core/server/model/ServerStateCategory;", "()Z", "getXDonate", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "server"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServersState {
    private final ServerModel currentServer;
    private final boolean isError;
    private final ServerStateCategory selectedCategory;
    private final List<ServerModel> serverListDesktop;
    private final List<ServerModel> serverListFavorite;
    private final List<ServerModel> serverListMobile;
    private final List<ServerModel> serverListVc;
    private final int xDonate;

    public ServersState() {
        this(null, null, null, null, null, null, false, 0, 255, null);
    }

    public static /* synthetic */ ServersState copy$default(ServersState serversState, ServerModel serverModel, List list, List list2, List list3, List list4, ServerStateCategory serverStateCategory, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            serverModel = serversState.currentServer;
        }
        List<ServerModel> list5 = list;
        if ((i2 & 2) != 0) {
            list5 = serversState.serverListMobile;
        }
        List<ServerModel> list6 = list2;
        if ((i2 & 4) != 0) {
            list6 = serversState.serverListDesktop;
        }
        List<ServerModel> list7 = list3;
        if ((i2 & 8) != 0) {
            list7 = serversState.serverListVc;
        }
        List<ServerModel> list8 = list4;
        if ((i2 & 16) != 0) {
            list8 = serversState.serverListFavorite;
        }
        if ((i2 & 32) != 0) {
            serverStateCategory = serversState.selectedCategory;
        }
        if ((i2 & 64) != 0) {
            z = serversState.isError;
        }
        if ((i2 & 128) != 0) {
            i = serversState.xDonate;
        }
        boolean z2 = z;
        int i3 = i;
        List list9 = list8;
        ServerStateCategory serverStateCategory2 = serverStateCategory;
        return serversState.copy(serverModel, list5, list6, list7, list9, serverStateCategory2, z2, i3);
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
        return this.serverListVc;
    }

    public final List<ServerModel> component5() {
        return this.serverListFavorite;
    }

    public final ServerStateCategory component6() {
        return this.selectedCategory;
    }

    public final boolean component7() {
        return this.isError;
    }

    public final int component8() {
        return this.xDonate;
    }

    public final ServersState copy(ServerModel serverModel, List<ServerModel> serverListMobile, List<ServerModel> serverListDesktop, List<ServerModel> serverListVc, List<ServerModel> serverListFavorite, ServerStateCategory selectedCategory, boolean z, int i) {
        Intrinsics.checkNotNullParameter(serverListMobile, "serverListMobile");
        Intrinsics.checkNotNullParameter(serverListDesktop, "serverListDesktop");
        Intrinsics.checkNotNullParameter(serverListVc, "serverListVc");
        Intrinsics.checkNotNullParameter(serverListFavorite, "serverListFavorite");
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        return new ServersState(serverModel, serverListMobile, serverListDesktop, serverListVc, serverListFavorite, selectedCategory, z, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServersState) {
            ServersState serversState = (ServersState) obj;
            return Intrinsics.areEqual(this.currentServer, serversState.currentServer) && Intrinsics.areEqual(this.serverListMobile, serversState.serverListMobile) && Intrinsics.areEqual(this.serverListDesktop, serversState.serverListDesktop) && Intrinsics.areEqual(this.serverListVc, serversState.serverListVc) && Intrinsics.areEqual(this.serverListFavorite, serversState.serverListFavorite) && this.selectedCategory == serversState.selectedCategory && this.isError == serversState.isError && this.xDonate == serversState.xDonate;
        }
        return false;
    }

    public int hashCode() {
        ServerModel serverModel = this.currentServer;
        return ((((((((((((((serverModel == null ? 0 : serverModel.hashCode()) * 31) + this.serverListMobile.hashCode()) * 31) + this.serverListDesktop.hashCode()) * 31) + this.serverListVc.hashCode()) * 31) + this.serverListFavorite.hashCode()) * 31) + this.selectedCategory.hashCode()) * 31) + Boolean.hashCode(this.isError)) * 31) + Integer.hashCode(this.xDonate);
    }

    public String toString() {
        ServerModel serverModel = this.currentServer;
        List<ServerModel> list = this.serverListMobile;
        List<ServerModel> list2 = this.serverListDesktop;
        List<ServerModel> list3 = this.serverListVc;
        List<ServerModel> list4 = this.serverListFavorite;
        ServerStateCategory serverStateCategory = this.selectedCategory;
        boolean z = this.isError;
        return "ServersState(currentServer=" + serverModel + ", serverListMobile=" + list + ", serverListDesktop=" + list2 + ", serverListVc=" + list3 + ", serverListFavorite=" + list4 + ", selectedCategory=" + serverStateCategory + ", isError=" + z + ", xDonate=" + this.xDonate + ")";
    }

    public ServersState(ServerModel serverModel, List<ServerModel> serverListMobile, List<ServerModel> serverListDesktop, List<ServerModel> serverListVc, List<ServerModel> serverListFavorite, ServerStateCategory selectedCategory, boolean z, int i) {
        Intrinsics.checkNotNullParameter(serverListMobile, "serverListMobile");
        Intrinsics.checkNotNullParameter(serverListDesktop, "serverListDesktop");
        Intrinsics.checkNotNullParameter(serverListVc, "serverListVc");
        Intrinsics.checkNotNullParameter(serverListFavorite, "serverListFavorite");
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        this.currentServer = serverModel;
        this.serverListMobile = serverListMobile;
        this.serverListDesktop = serverListDesktop;
        this.serverListVc = serverListVc;
        this.serverListFavorite = serverListFavorite;
        this.selectedCategory = selectedCategory;
        this.isError = z;
        this.xDonate = i;
    }

    public final ServerModel getCurrentServer() {
        return this.currentServer;
    }

    public /* synthetic */ ServersState(ServerModel serverModel, List list, List list2, List list3, List list4, ServerStateCategory serverStateCategory, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i3;
        boolean z2;
        List list5;
        ServerStateCategory serverStateCategory2;
        List list6;
        List list7;
        ServerModel serverModel2;
        List list8;
        ServersState serversState;
        serverModel = (i2 & 1) != 0 ? null : serverModel;
        list = (i2 & 2) != 0 ? CollectionsKt.emptyList() : list;
        list2 = (i2 & 4) != 0 ? CollectionsKt.emptyList() : list2;
        list3 = (i2 & 8) != 0 ? CollectionsKt.emptyList() : list3;
        list4 = (i2 & 16) != 0 ? CollectionsKt.emptyList() : list4;
        serverStateCategory = (i2 & 32) != 0 ? ServerStateCategory.Desktop : serverStateCategory;
        z = (i2 & 64) != 0 ? false : z;
        if ((i2 & 128) != 0) {
            i3 = 0;
            serverStateCategory2 = serverStateCategory;
            z2 = z;
            list7 = list3;
            list5 = list4;
            list8 = list;
            list6 = list2;
            serversState = this;
            serverModel2 = serverModel;
        } else {
            i3 = i;
            z2 = z;
            list5 = list4;
            serverStateCategory2 = serverStateCategory;
            list6 = list2;
            list7 = list3;
            serverModel2 = serverModel;
            list8 = list;
            serversState = this;
        }
        new ServersState(serverModel2, list8, list6, list7, list5, serverStateCategory2, z2, i3);
    }

    public final List<ServerModel> getServerListMobile() {
        return this.serverListMobile;
    }

    public final List<ServerModel> getServerListDesktop() {
        return this.serverListDesktop;
    }

    public final List<ServerModel> getServerListVc() {
        return this.serverListVc;
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
