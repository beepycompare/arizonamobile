package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public class zzjd implements zzjf {
    protected final zzib zzu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjd(zzib zzibVar) {
        Preconditions.checkNotNull(zzibVar);
        this.zzu = zzibVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final zzae zzaU() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final zzgt zzaV() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final zzhy zzaW() {
        throw null;
    }

    public void zzaX() {
        this.zzu.zzaW().zzaX();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final Context zzaY() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final Clock zzaZ() {
        throw null;
    }

    public void zzg() {
        this.zzu.zzaW().zzg();
    }
}
