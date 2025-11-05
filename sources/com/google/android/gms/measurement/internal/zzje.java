package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes4.dex */
public class zzje implements zzjg {
    protected final zzic zzu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzje(zzic zzicVar) {
        Preconditions.checkNotNull(zzicVar);
        this.zzu = zzicVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final zzae zzaU() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final zzgu zzaV() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final zzhz zzaW() {
        throw null;
    }

    public void zzaX() {
        this.zzu.zzaW().zzaX();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final Context zzaY() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final Clock zzaZ() {
        throw null;
    }

    public void zzg() {
        this.zzu.zzaW().zzg();
    }
}
