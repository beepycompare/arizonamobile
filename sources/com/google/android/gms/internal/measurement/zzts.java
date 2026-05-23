package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final /* synthetic */ class zzts implements AsyncFunction {
    static final /* synthetic */ zzts zza = new zzts();

    private /* synthetic */ zzts() {
    }

    @Override // com.google.common.util.concurrent.AsyncFunction
    public final /* synthetic */ ListenableFuture apply(Object obj) {
        Uri uri = (Uri) obj;
        return Futures.immediateFuture("");
    }
}
