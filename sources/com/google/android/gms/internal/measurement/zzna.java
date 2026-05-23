package com.google.android.gms.internal.measurement;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.InputStream;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzna implements zzrt {
    private final boolean zza;

    public zzna(boolean z) {
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzrt
    public final /* bridge */ /* synthetic */ Object zza(zzrs openContext) {
        zznd zzb;
        Intrinsics.checkNotNullParameter(openContext, "openContext");
        InputStream zzc = zzst.zzc(openContext);
        try {
            InputStream inputStream = zzc;
            int i = 4096;
            if (this.zza) {
                if (inputStream instanceof zzsf) {
                    long length = ((zzsf) inputStream).zza().length();
                    if (length == 0) {
                        i = 512;
                    } else if (length < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
                        i = (int) length;
                    }
                }
                zzb = zznd.zzb(zzacv.zzM(inputStream, i), true);
                Intrinsics.checkNotNullExpressionValue(zzb, "parseFrom(...)");
            } else {
                zzb = zznd.zzb(zzacv.zzM(inputStream, 4096), false);
                Intrinsics.checkNotNullExpressionValue(zzb, "parseFrom(...)");
            }
            CloseableKt.closeFinally(zzc, null);
            return zzb;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(zzc, th);
                throw th2;
            }
        }
    }
}
