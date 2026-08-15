package com.arizona.launcher.updater.apk;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LauncherApkDownloader.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkDestinationRegistry;", "", "<init>", "()V", "owners", "Ljava/util/concurrent/ConcurrentHashMap;", "", "tryAcquire", "", "destinationKey", "owner", "release", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class LauncherApkDestinationRegistry {
    public static final LauncherApkDestinationRegistry INSTANCE = new LauncherApkDestinationRegistry();
    private static final ConcurrentHashMap<String, Object> owners = new ConcurrentHashMap<>();

    private LauncherApkDestinationRegistry() {
    }

    public final boolean tryAcquire(String destinationKey, Object owner) {
        Intrinsics.checkNotNullParameter(destinationKey, "destinationKey");
        Intrinsics.checkNotNullParameter(owner, "owner");
        return owners.putIfAbsent(destinationKey, owner) == null;
    }

    public final void release(String destinationKey, Object owner) {
        Intrinsics.checkNotNullParameter(destinationKey, "destinationKey");
        Intrinsics.checkNotNullParameter(owner, "owner");
        owners.remove(destinationKey, owner);
    }
}
