package com.google.android.gms.internal.common;
/* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
/* loaded from: classes4.dex */
abstract class zzv extends zzk {
    final CharSequence zzb;
    final zzp zzc;
    final boolean zzd;
    int zze = 0;
    int zzf = Integer.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(zzw zzwVar, CharSequence charSequence) {
        this.zzc = zzwVar.zzf();
        this.zzd = zzwVar.zzg();
        this.zzb = charSequence;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        r3 = r5.zzf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r3 != 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        r1 = r5.zzb;
        r3 = r1.length();
        r5.zze = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r3 <= r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        r1.charAt(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
        r5.zzf = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006a, code lost:
        return r5.zzb.subSequence(r0, r1).toString();
     */
    @Override // com.google.android.gms.internal.common.zzk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final /* bridge */ /* synthetic */ Object zza() {
        int zzd;
        int i = this.zze;
        while (true) {
            int i2 = this.zze;
            if (i2 == -1) {
                zzb();
                return null;
            }
            int zzc = zzc(i2);
            if (zzc == -1) {
                zzc = this.zzb.length();
                this.zze = -1;
                zzd = -1;
            } else {
                zzd = zzd(zzc);
                this.zze = zzd;
            }
            if (zzd == i) {
                int i3 = zzd + 1;
                this.zze = i3;
                if (i3 > this.zzb.length()) {
                    this.zze = -1;
                }
            } else {
                if (i < zzc) {
                    this.zzb.charAt(i);
                }
                if (i < zzc) {
                    this.zzb.charAt(zzc - 1);
                }
                if (!this.zzd || i != zzc) {
                    break;
                }
                i = this.zze;
            }
        }
    }

    abstract int zzc(int i);

    abstract int zzd(int i);
}
