package com.google.android.gms.internal.measurement;

import android.os.SystemClock;
import com.google.common.base.Ticker;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzxf extends Ticker {
    @Override // com.google.common.base.Ticker
    public final long read() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
