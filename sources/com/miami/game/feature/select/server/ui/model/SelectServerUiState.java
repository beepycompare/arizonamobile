package com.miami.game.feature.select.server.ui.model;

import androidx.compose.ui.graphics.ImageBitmap;
import coil3.util.UtilsKt;
import com.facebook.internal.NativeProtocol;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.core.server.model.ServerModel;
import com.miami.game.core.server.model.ServerStateCategory;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectServerUiState.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u0000 12\u00020\u0001:\u00011Bi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jo\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0014\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010/\u001a\u000200HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!Ê\u0001\u0002\b3¨\u00062"}, d2 = {"Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;", "", "currentServer", "Lcom/miami/game/core/server/model/ServerModel;", "serversList", "", "selectedCategory", "Lcom/miami/game/core/server/model/ServerStateCategory;", "isError", "", "backGroundId", "", "isArizona", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, UtilsKt.SCHEME_FILE, "Ljava/io/File;", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "<init>", "(Lcom/miami/game/core/server/model/ServerModel;Ljava/util/List;Lcom/miami/game/core/server/model/ServerStateCategory;ZIZILjava/io/File;Landroidx/compose/ui/graphics/ImageBitmap;)V", "getCurrentServer", "()Lcom/miami/game/core/server/model/ServerModel;", "getServersList", "()Ljava/util/List;", "getSelectedCategory", "()Lcom/miami/game/core/server/model/ServerStateCategory;", "()Z", "getBackGroundId", "()I", "getVersion", "getFile", "()Ljava/io/File;", "getImageBitmap", "()Landroidx/compose/ui/graphics/ImageBitmap;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "select-server", "Landroidx/compose/runtime/Stable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectServerUiState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int backGroundId;
    private final ServerModel currentServer;
    private final File file;
    private final ImageBitmap imageBitmap;
    private final boolean isArizona;
    private final boolean isError;
    private final ServerStateCategory selectedCategory;
    private final List<ServerModel> serversList;
    private final int version;

    public static /* synthetic */ SelectServerUiState copy$default(SelectServerUiState selectServerUiState, ServerModel serverModel, List list, ServerStateCategory serverStateCategory, boolean z, int i, boolean z2, int i2, File file, ImageBitmap imageBitmap, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            serverModel = selectServerUiState.currentServer;
        }
        List<ServerModel> list2 = list;
        if ((i3 & 2) != 0) {
            list2 = selectServerUiState.serversList;
        }
        if ((i3 & 4) != 0) {
            serverStateCategory = selectServerUiState.selectedCategory;
        }
        if ((i3 & 8) != 0) {
            z = selectServerUiState.isError;
        }
        if ((i3 & 16) != 0) {
            i = selectServerUiState.backGroundId;
        }
        if ((i3 & 32) != 0) {
            z2 = selectServerUiState.isArizona;
        }
        if ((i3 & 64) != 0) {
            i2 = selectServerUiState.version;
        }
        if ((i3 & 128) != 0) {
            file = selectServerUiState.file;
        }
        if ((i3 & 256) != 0) {
            imageBitmap = selectServerUiState.imageBitmap;
        }
        File file2 = file;
        ImageBitmap imageBitmap2 = imageBitmap;
        boolean z3 = z2;
        int i4 = i2;
        int i5 = i;
        ServerStateCategory serverStateCategory2 = serverStateCategory;
        return selectServerUiState.copy(serverModel, list2, serverStateCategory2, z, i5, z3, i4, file2, imageBitmap2);
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

    public final int component7() {
        return this.version;
    }

    public final File component8() {
        return this.file;
    }

    public final ImageBitmap component9() {
        return this.imageBitmap;
    }

    public final SelectServerUiState copy(ServerModel serverModel, List<ServerModel> serversList, ServerStateCategory selectedCategory, boolean z, int i, boolean z2, int i2, File file, ImageBitmap imageBitmap) {
        Intrinsics.checkNotNullParameter(serversList, "serversList");
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        return new SelectServerUiState(serverModel, serversList, selectedCategory, z, i, z2, i2, file, imageBitmap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelectServerUiState) {
            SelectServerUiState selectServerUiState = (SelectServerUiState) obj;
            return Intrinsics.areEqual(this.currentServer, selectServerUiState.currentServer) && Intrinsics.areEqual(this.serversList, selectServerUiState.serversList) && this.selectedCategory == selectServerUiState.selectedCategory && this.isError == selectServerUiState.isError && this.backGroundId == selectServerUiState.backGroundId && this.isArizona == selectServerUiState.isArizona && this.version == selectServerUiState.version && Intrinsics.areEqual(this.file, selectServerUiState.file) && Intrinsics.areEqual(this.imageBitmap, selectServerUiState.imageBitmap);
        }
        return false;
    }

    public int hashCode() {
        ServerModel serverModel = this.currentServer;
        int hashCode = (((((((((((((serverModel == null ? 0 : serverModel.hashCode()) * 31) + this.serversList.hashCode()) * 31) + this.selectedCategory.hashCode()) * 31) + Boolean.hashCode(this.isError)) * 31) + Integer.hashCode(this.backGroundId)) * 31) + Boolean.hashCode(this.isArizona)) * 31) + Integer.hashCode(this.version)) * 31;
        File file = this.file;
        int hashCode2 = (hashCode + (file == null ? 0 : file.hashCode())) * 31;
        ImageBitmap imageBitmap = this.imageBitmap;
        return hashCode2 + (imageBitmap != null ? imageBitmap.hashCode() : 0);
    }

    public String toString() {
        ServerModel serverModel = this.currentServer;
        List<ServerModel> list = this.serversList;
        ServerStateCategory serverStateCategory = this.selectedCategory;
        boolean z = this.isError;
        int i = this.backGroundId;
        boolean z2 = this.isArizona;
        int i2 = this.version;
        File file = this.file;
        return "SelectServerUiState(currentServer=" + serverModel + ", serversList=" + list + ", selectedCategory=" + serverStateCategory + ", isError=" + z + ", backGroundId=" + i + ", isArizona=" + z2 + ", version=" + i2 + ", file=" + file + ", imageBitmap=" + this.imageBitmap + ")";
    }

    public SelectServerUiState(ServerModel serverModel, List<ServerModel> serversList, ServerStateCategory selectedCategory, boolean z, int i, boolean z2, int i2, File file, ImageBitmap imageBitmap) {
        Intrinsics.checkNotNullParameter(serversList, "serversList");
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        this.currentServer = serverModel;
        this.serversList = serversList;
        this.selectedCategory = selectedCategory;
        this.isError = z;
        this.backGroundId = i;
        this.isArizona = z2;
        this.version = i2;
        this.file = file;
        this.imageBitmap = imageBitmap;
    }

    public final ServerModel getCurrentServer() {
        return this.currentServer;
    }

    public /* synthetic */ SelectServerUiState(ServerModel serverModel, List list, ServerStateCategory serverStateCategory, boolean z, int i, boolean z2, int i2, File file, ImageBitmap imageBitmap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : serverModel, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? ServerStateCategory.Desktop : serverStateCategory, (i3 & 8) != 0 ? false : z, i, z2, (i3 & 64) != 0 ? 0 : i2, (i3 & 128) != 0 ? null : file, (i3 & 256) != 0 ? null : imageBitmap);
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

    public final int getVersion() {
        return this.version;
    }

    public final File getFile() {
        return this.file;
    }

    public final ImageBitmap getImageBitmap() {
        return this.imageBitmap;
    }

    /* compiled from: SelectServerUiState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;", "isArizona", "", "select-server"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SelectServerUiState initial(boolean z) {
            return new SelectServerUiState(null, null, ServerStateCategory.Desktop, false, z ? R.drawable.arizona_backgournd_home : R.drawable.rodina_backgournd_home, z, 0, null, null, 459, null);
        }
    }
}
