package com.google.android.gms.internal.measurement;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmu implements Closeable {
    private final Inflater zza = new Inflater(true);

    private zzmu() {
    }

    public static zzmu zza() {
        return new zzmu();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.zza.end();
    }

    public final Object zzb(byte[] bArr, zzmt zzmtVar) throws IOException {
        this.zza.setInput(bArr);
        try {
            return zzmw.zzd(zzacv.zzM(new zzmr(this), 4096));
        } finally {
            this.zza.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Inflater zzd() {
        return this.zza;
    }

    public final Object zzc(zzacv zzacvVar, zzmt zzmtVar) throws IOException {
        int zzF = zzacvVar.zzF();
        try {
            return zzmw.zzd(zzacv.zzM(new InflaterInputStream(new zzms(this, zzacvVar), this.zza, zzF < 0 ? 4096 : Math.min(zzF, 4096)), 4096));
        } finally {
            this.zza.reset();
        }
    }
}
