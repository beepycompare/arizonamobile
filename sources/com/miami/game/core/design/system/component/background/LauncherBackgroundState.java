package com.miami.game.core.design.system.component.background;

import androidx.compose.ui.graphics.ImageBitmap;
import coil3.util.UtilsKt;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BackgroundManager.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fÊ\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001a"}, d2 = {"Lcom/miami/game/core/design/system/component/background/LauncherBackgroundState;", "", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "<init>", "(ILjava/io/File;Landroidx/compose/ui/graphics/ImageBitmap;)V", "getVersion", "()I", "getFile", "()Ljava/io/File;", "getImageBitmap", "()Landroidx/compose/ui/graphics/ImageBitmap;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "design-system", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LauncherBackgroundState {
    public static final int $stable = 8;
    private final File file;
    private final ImageBitmap imageBitmap;
    private final int version;

    public LauncherBackgroundState() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ LauncherBackgroundState copy$default(LauncherBackgroundState launcherBackgroundState, int i, File file, ImageBitmap imageBitmap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = launcherBackgroundState.version;
        }
        if ((i2 & 2) != 0) {
            file = launcherBackgroundState.file;
        }
        if ((i2 & 4) != 0) {
            imageBitmap = launcherBackgroundState.imageBitmap;
        }
        return launcherBackgroundState.copy(i, file, imageBitmap);
    }

    public final int component1() {
        return this.version;
    }

    public final File component2() {
        return this.file;
    }

    public final ImageBitmap component3() {
        return this.imageBitmap;
    }

    public final LauncherBackgroundState copy(int i, File file, ImageBitmap imageBitmap) {
        return new LauncherBackgroundState(i, file, imageBitmap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LauncherBackgroundState) {
            LauncherBackgroundState launcherBackgroundState = (LauncherBackgroundState) obj;
            return this.version == launcherBackgroundState.version && Intrinsics.areEqual(this.file, launcherBackgroundState.file) && Intrinsics.areEqual(this.imageBitmap, launcherBackgroundState.imageBitmap);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.version) * 31;
        File file = this.file;
        int hashCode2 = (hashCode + (file == null ? 0 : file.hashCode())) * 31;
        ImageBitmap imageBitmap = this.imageBitmap;
        return hashCode2 + (imageBitmap != null ? imageBitmap.hashCode() : 0);
    }

    public String toString() {
        int i = this.version;
        File file = this.file;
        return "LauncherBackgroundState(version=" + i + ", file=" + file + ", imageBitmap=" + this.imageBitmap + ")";
    }

    public LauncherBackgroundState(int i, File file, ImageBitmap imageBitmap) {
        this.version = i;
        this.file = file;
        this.imageBitmap = imageBitmap;
    }

    public /* synthetic */ LauncherBackgroundState(int i, File file, ImageBitmap imageBitmap, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : file, (i2 & 4) != 0 ? null : imageBitmap);
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
}
