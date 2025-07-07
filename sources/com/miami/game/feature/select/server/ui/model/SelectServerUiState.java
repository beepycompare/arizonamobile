package com.miami.game.feature.select.server.ui.model;

import com.miami.game.core.drawable.resources.R;
import com.miami.game.core.server.model.ServerModel;
import com.miami.game.core.server.model.ServerStateCategory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectServerUiState.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003JM\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015¨\u0006%"}, d2 = {"Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;", "", "currentServer", "Lcom/miami/game/core/server/model/ServerModel;", "serversList", "", "selectedCategory", "Lcom/miami/game/core/server/model/ServerStateCategory;", "isError", "", "backGroundId", "", "isArizona", "<init>", "(Lcom/miami/game/core/server/model/ServerModel;Ljava/util/List;Lcom/miami/game/core/server/model/ServerStateCategory;ZIZ)V", "getCurrentServer", "()Lcom/miami/game/core/server/model/ServerModel;", "getServersList", "()Ljava/util/List;", "getSelectedCategory", "()Lcom/miami/game/core/server/model/ServerStateCategory;", "()Z", "getBackGroundId", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "select-server_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelectServerUiState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int backGroundId;
    private final ServerModel currentServer;
    private final boolean isArizona;
    private final boolean isError;
    private final ServerStateCategory selectedCategory;
    private final List<ServerModel> serversList;

    public static /* synthetic */ SelectServerUiState copy$default(SelectServerUiState selectServerUiState, ServerModel serverModel, List list, ServerStateCategory serverStateCategory, boolean z, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            serverModel = selectServerUiState.currentServer;
        }
        List<ServerModel> list2 = list;
        if ((i2 & 2) != 0) {
            list2 = selectServerUiState.serversList;
        }
        if ((i2 & 4) != 0) {
            serverStateCategory = selectServerUiState.selectedCategory;
        }
        if ((i2 & 8) != 0) {
            z = selectServerUiState.isError;
        }
        if ((i2 & 16) != 0) {
            i = selectServerUiState.backGroundId;
        }
        if ((i2 & 32) != 0) {
            z2 = selectServerUiState.isArizona;
        }
        int i3 = i;
        boolean z3 = z2;
        return selectServerUiState.copy(serverModel, list2, serverStateCategory, z, i3, z3);
    }

    public final ServerModel component1() {
        return this.currentServer;
    }

    public final List<ServerModel> component2() {
        return this.serversList;
    }

    public final ServerStateCategory component3() {
        return this.selectedCategory;
    }

    public final boolean component4() {
        return this.isError;
    }

    public final int component5() {
        return this.backGroundId;
    }

    public final boolean component6() {
        return this.isArizona;
    }

    public final SelectServerUiState copy(ServerModel serverModel, List<ServerModel> serversList, ServerStateCategory selectedCategory, boolean z, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(serversList, "serversList");
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        return new SelectServerUiState(serverModel, serversList, selectedCategory, z, i, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelectServerUiState) {
            SelectServerUiState selectServerUiState = (SelectServerUiState) obj;
            return Intrinsics.areEqual(this.currentServer, selectServerUiState.currentServer) && Intrinsics.areEqual(this.serversList, selectServerUiState.serversList) && this.selectedCategory == selectServerUiState.selectedCategory && this.isError == selectServerUiState.isError && this.backGroundId == selectServerUiState.backGroundId && this.isArizona == selectServerUiState.isArizona;
        }
        return false;
    }

    public int hashCode() {
        ServerModel serverModel = this.currentServer;
        return ((((((((((serverModel == null ? 0 : serverModel.hashCode()) * 31) + this.serversList.hashCode()) * 31) + this.selectedCategory.hashCode()) * 31) + Boolean.hashCode(this.isError)) * 31) + Integer.hashCode(this.backGroundId)) * 31) + Boolean.hashCode(this.isArizona);
    }

    public String toString() {
        ServerModel serverModel = this.currentServer;
        List<ServerModel> list = this.serversList;
        ServerStateCategory serverStateCategory = this.selectedCategory;
        boolean z = this.isError;
        int i = this.backGroundId;
        return "SelectServerUiState(currentServer=" + serverModel + ", serversList=" + list + ", selectedCategory=" + serverStateCategory + ", isError=" + z + ", backGroundId=" + i + ", isArizona=" + this.isArizona + ")";
    }

    public SelectServerUiState(ServerModel serverModel, List<ServerModel> serversList, ServerStateCategory selectedCategory, boolean z, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(serversList, "serversList");
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        this.currentServer = serverModel;
        this.serversList = serversList;
        this.selectedCategory = selectedCategory;
        this.isError = z;
        this.backGroundId = i;
        this.isArizona = z2;
    }

    public final ServerModel getCurrentServer() {
        return this.currentServer;
    }

    public /* synthetic */ SelectServerUiState(ServerModel serverModel, List list, ServerStateCategory serverStateCategory, boolean z, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : serverModel, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? ServerStateCategory.Desktop : serverStateCategory, (i2 & 8) != 0 ? false : z, i, z2);
    }

    public final List<ServerModel> getServersList() {
        return this.serversList;
    }

    public final ServerStateCategory getSelectedCategory() {
        return this.selectedCategory;
    }

    public final boolean isError() {
        return this.isError;
    }

    public final int getBackGroundId() {
        return this.backGroundId;
    }

    public final boolean isArizona() {
        return this.isArizona;
    }

    /* compiled from: SelectServerUiState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;", "isArizona", "", "select-server_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SelectServerUiState initial(boolean z) {
            return new SelectServerUiState(null, null, ServerStateCategory.Mobile, false, z ? R.drawable.bg_arizona : R.drawable.bg_rodina, z, 11, null);
        }
    }
}
