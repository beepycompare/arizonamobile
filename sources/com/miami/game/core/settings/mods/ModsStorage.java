package com.miami.game.core.settings.mods;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ModsStorage.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsStorage;", "", "<init>", "()V", "lock", "getLock$settings", "()Ljava/lang/Object;", "clearImportedCopies", "", "context", "Landroid/content/Context;", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModsStorage {
    public static final ModsStorage INSTANCE = new ModsStorage();
    private static final Object lock = new Object();

    private ModsStorage() {
    }

    public final Object getLock$settings() {
        return lock;
    }

    public final void clearImportedCopies(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (lock) {
            File file = new File(context.getFilesDir(), "resource-mods");
            if (file.exists() && !FilesKt.deleteRecursively(file)) {
                throw new IllegalStateException("Cannot remove private mod copy".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
