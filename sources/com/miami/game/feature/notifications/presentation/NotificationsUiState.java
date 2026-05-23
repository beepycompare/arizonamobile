package com.miami.game.feature.notifications.presentation;

import androidx.compose.ui.graphics.ImageBitmap;
import com.facebook.internal.NativeProtocol;
import com.miami.game.core.drawable.resources.R;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: uiState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/miami/game/feature/notifications/presentation/NotificationsUiState;", "", "backGroundId", "", "isArizona", "", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "file", "Ljava/io/File;", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "<init>", "(IZILjava/io/File;Landroidx/compose/ui/graphics/ImageBitmap;)V", "getBackGroundId", "()I", "()Z", "getVersion", "getFile", "()Ljava/io/File;", "getImageBitmap", "()Landroidx/compose/ui/graphics/ImageBitmap;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "notifications"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationsUiState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int backGroundId;
    private final File file;
    private final ImageBitmap imageBitmap;
    private final boolean isArizona;
    private final int version;

    public static /* synthetic */ NotificationsUiState copy$default(NotificationsUiState notificationsUiState, int i, boolean z, int i2, File file, ImageBitmap imageBitmap, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = notificationsUiState.backGroundId;
        }
        if ((i3 & 2) != 0) {
            z = notificationsUiState.isArizona;
        }
        if ((i3 & 4) != 0) {
            i2 = notificationsUiState.version;
        }
        if ((i3 & 8) != 0) {
            file = notificationsUiState.file;
        }
        if ((i3 & 16) != 0) {
            imageBitmap = notificationsUiState.imageBitmap;
        }
        ImageBitmap imageBitmap2 = imageBitmap;
        int i4 = i2;
        return notificationsUiState.copy(i, z, i4, file, imageBitmap2);
    }

    public final int component1() {
        return this.backGroundId;
    }

    public final boolean component2() {
        return this.isArizona;
    }

    public final int component3() {
        return this.version;
    }

    public final File component4() {
        return this.file;
    }

    public final ImageBitmap component5() {
        return this.imageBitmap;
    }

    public final NotificationsUiState copy(int i, boolean z, int i2, File file, ImageBitmap imageBitmap) {
        return new NotificationsUiState(i, z, i2, file, imageBitmap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NotificationsUiState) {
            NotificationsUiState notificationsUiState = (NotificationsUiState) obj;
            return this.backGroundId == notificationsUiState.backGroundId && this.isArizona == notificationsUiState.isArizona && this.version == notificationsUiState.version && Intrinsics.areEqual(this.file, notificationsUiState.file) && Intrinsics.areEqual(this.imageBitmap, notificationsUiState.imageBitmap);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.backGroundId) * 31) + Boolean.hashCode(this.isArizona)) * 31) + Integer.hashCode(this.version)) * 31;
        File file = this.file;
        int hashCode2 = (hashCode + (file == null ? 0 : file.hashCode())) * 31;
        ImageBitmap imageBitmap = this.imageBitmap;
        return hashCode2 + (imageBitmap != null ? imageBitmap.hashCode() : 0);
    }

    public String toString() {
        int i = this.backGroundId;
        boolean z = this.isArizona;
        int i2 = this.version;
        File file = this.file;
        return "NotificationsUiState(backGroundId=" + i + ", isArizona=" + z + ", version=" + i2 + ", file=" + file + ", imageBitmap=" + this.imageBitmap + ")";
    }

    public NotificationsUiState(int i, boolean z, int i2, File file, ImageBitmap imageBitmap) {
        this.backGroundId = i;
        this.isArizona = z;
        this.version = i2;
        this.file = file;
        this.imageBitmap = imageBitmap;
    }

    public /* synthetic */ NotificationsUiState(int i, boolean z, int i2, File file, ImageBitmap imageBitmap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? null : file, (i3 & 16) != 0 ? null : imageBitmap);
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

    /* compiled from: uiState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/feature/notifications/presentation/NotificationsUiState$Companion;", "", "<init>", "()V", "initial", "Lcom/miami/game/feature/notifications/presentation/NotificationsUiState;", "isArizona", "", "notifications"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NotificationsUiState initial(boolean z) {
            return new NotificationsUiState(z ? R.drawable.arizona_backgournd_home : R.drawable.rodina_backgournd_home, z, 0, null, null, 28, null);
        }
    }
}
