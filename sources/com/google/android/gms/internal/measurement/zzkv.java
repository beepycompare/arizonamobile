package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
final class zzkv {
    public int zza;
    public long zzb;
    public Object zzc;
    public final zzlq zzd;
    public int zze;

    zzkv() {
        int i = zzlq.zzb;
        int i2 = zznt.zza;
        this.zzd = zzlq.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String zza(int i, int i2, byte b, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + b + String.valueOf(i).length());
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkv(zzlq zzlqVar) {
        zzlqVar.getClass();
        this.zzd = zzlqVar;
    }
}
