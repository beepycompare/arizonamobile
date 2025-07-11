package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzae {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(Context context) {
    }

    public static final boolean zza() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
