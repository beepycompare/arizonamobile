package com.google.android.play.core.splitinstall.internal;

import java.io.File;
import java.util.Set;
/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* loaded from: classes4.dex */
final class zzbd implements zzan {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc(ClassLoader classLoader, Set set) {
        zzay.zzc(classLoader, set, new zzbb());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzd(ClassLoader classLoader, File file, File file2, boolean z) {
        return zzat.zze(classLoader, file, file2, z, new zzav(), "path", new zzbc());
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzan
    public final void zza(ClassLoader classLoader, Set set) {
        zzc(classLoader, set);
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzan
    public final boolean zzb(ClassLoader classLoader, File file, File file2, boolean z) {
        return zzd(classLoader, file, file2, z);
    }
}
