package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzlj;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-api@@22.5.0 */
/* loaded from: classes4.dex */
final class zzd implements zzlj {
    final /* synthetic */ zzfb zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(zzfb zzfbVar) {
        this.zza = zzfbVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zzi(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void zzb(String str, String str2, Bundle bundle, long j) {
        this.zza.zzj(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final Map zzd(String str, String str2, boolean z) {
        return this.zza.zzC(str, str2, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void zze(zzjo zzjoVar) {
        this.zza.zzd(zzjoVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void zzf(zzjp zzjpVar) {
        this.zza.zzf(zzjpVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void zzg(zzjp zzjpVar) {
        this.zza.zzg(zzjpVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzh() {
        return this.zza.zzA();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzi() {
        return this.zza.zzB();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzj() {
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzk() {
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final long zzl() {
        return this.zza.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void zzm(String str) {
        this.zza.zzu(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void zzn(String str) {
        this.zza.zzv(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void zzo(Bundle bundle) {
        this.zza.zzl(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void zzp(String str, String str2, Bundle bundle) {
        this.zza.zzm(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final List zzq(String str, String str2) {
        return this.zza.zzn(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final int zzr(String str) {
        return this.zza.zzF(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final Object zzx(int i) {
        return this.zza.zzJ(i);
    }
}
