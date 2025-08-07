package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzjw extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjw(zzjy zzjyVar, Handler handler) {
        super(null);
        Objects.requireNonNull(zzjyVar);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzkm.zzc();
    }
}
