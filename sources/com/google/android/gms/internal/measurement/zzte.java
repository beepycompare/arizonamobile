package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzte extends zztr {
    private final Uri zza;
    private final zzafc zzb;
    private final Optional zzc;
    private final ImmutableList zzd;
    private final zzuj zze;
    private final boolean zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzte(Uri uri, zzafc zzafcVar, Optional optional, ImmutableList immutableList, zzuj zzujVar, boolean z, boolean z2, byte[] bArr) {
        this.zza = uri;
        this.zzb = zzafcVar;
        this.zzc = optional;
        this.zzd = immutableList;
        this.zze = zzujVar;
        this.zzf = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zztr) {
            zztr zztrVar = (zztr) obj;
            if (this.zza.equals(zztrVar.zza()) && this.zzb.equals(zztrVar.zzb()) && this.zzc.equals(zztrVar.zzc()) && this.zzd.equals(zztrVar.zzd()) && this.zze.equals(zztrVar.zze()) && this.zzf == zztrVar.zzf()) {
                zztrVar.zzg();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((true != this.zzf ? 1237 : 1231) ^ ((((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode()) * 1000003)) * 1000003) ^ 1237;
    }

    public final String toString() {
        String obj = this.zza.toString();
        int length = obj.length();
        String obj2 = this.zzb.toString();
        int length2 = obj2.length();
        zzuj zzujVar = this.zze;
        ImmutableList immutableList = this.zzd;
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(immutableList);
        String obj3 = zzujVar.toString();
        int length3 = String.valueOf(valueOf).length();
        int length4 = String.valueOf(valueOf2).length();
        int length5 = obj3.length();
        boolean z = this.zzf;
        StringBuilder sb = new StringBuilder(length + 34 + length2 + 10 + length3 + 13 + length4 + 16 + length5 + 32 + String.valueOf(z).length() + 22);
        sb.append("ProtoDataStoreConfig{uri=");
        sb.append(obj);
        sb.append(", schema=");
        sb.append(obj2);
        sb.append(", handler=");
        sb.append(valueOf);
        sb.append(", migrations=");
        sb.append(valueOf2);
        sb.append(", variantConfig=");
        sb.append(obj3);
        sb.append(", useGeneratedExtensionRegistry=");
        sb.append(z);
        sb.append(", enableTracing=false}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zztr
    public final Uri zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zztr
    public final zzafc zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zztr
    public final Optional zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zztr
    public final ImmutableList zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zztr
    public final zzuj zze() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zztr
    public final boolean zzf() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zztr
    public final boolean zzg() {
        return false;
    }
}
