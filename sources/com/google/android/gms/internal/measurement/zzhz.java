package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzhz extends zzma implements zznm {
    private zzhz() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ zzhz(byte[] bArr) {
        super(r1);
        zzib zzibVar;
        zzibVar = zzib.zzh;
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzib) this.zza).zza());
    }

    public final int zzb() {
        return ((zzib) this.zza).zzb();
    }

    public final zzid zzc(int i) {
        return ((zzib) this.zza).zzc(i);
    }

    public final zzhz zzd(int i, zzic zzicVar) {
        zzaX();
        ((zzib) this.zza).zzj(i, (zzid) zzicVar.zzbc());
        return this;
    }

    public final zzhz zze(zzic zzicVar) {
        zzaX();
        ((zzib) this.zza).zzk((zzid) zzicVar.zzbc());
        return this;
    }

    public final zzhz zzf(Iterable iterable) {
        zzaX();
        ((zzib) this.zza).zzm(iterable);
        return this;
    }

    public final zzhz zzg() {
        zzaX();
        ((zzib) this.zza).zzn();
        return this;
    }

    public final String zzh() {
        return ((zzib) this.zza).zze();
    }

    public final zzhz zzi(String str) {
        zzaX();
        ((zzib) this.zza).zzo(str);
        return this;
    }

    public final zzhz zzj(String str) {
        zzaX();
        ((zzib) this.zza).zzp(str);
        return this;
    }
}
