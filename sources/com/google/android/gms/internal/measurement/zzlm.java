package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
final class zzlm implements zzou {
    private final zzll zza;

    private zzlm(zzll zzllVar) {
        byte[] bArr = zzmo.zzb;
        this.zza = zzllVar;
        zzllVar.zza = this;
    }

    public static zzlm zza(zzll zzllVar) {
        zzlm zzlmVar = zzllVar.zza;
        return zzlmVar != null ? zzlmVar : new zzlm(zzllVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzG(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzi(i, (zzlg) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzM(int i, zznd zzndVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            zzllVar.zzr(zzne.zzc(zzndVar, entry.getKey(), entry.getValue()));
            zzne.zzb(zzllVar, zzndVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzc(int i, long j) throws IOException {
        this.zza.zze(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzd(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zze(int i, float f) throws IOException {
        this.zza.zzd(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzf(int i, double d) throws IOException {
        this.zza.zzf(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzg(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzh(int i, long j) throws IOException {
        this.zza.zze(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzj(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzl(int i, boolean z) throws IOException {
        this.zza.zzg(i, z);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzm(int i, String str) throws IOException {
        this.zza.zzh(i, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzn(int i, zzlg zzlgVar) throws IOException {
        this.zza.zzi(i, zzlgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzo(int i, int i2) throws IOException {
        this.zza.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzp(int i, int i2) throws IOException {
        this.zza.zzc(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzq(int i, long j) throws IOException {
        this.zza.zze(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzr(int i, Object obj, zznw zznwVar) throws IOException {
        this.zza.zzl(i, (zznl) obj, zznwVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzs(int i, Object obj, zznw zznwVar) throws IOException {
        zzll zzllVar = this.zza;
        zzllVar.zza(i, 3);
        zznwVar.zzf((zznl) obj, zzllVar.zza);
        zzllVar.zza(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    @Deprecated
    public final void zzt(int i) throws IOException {
        this.zza.zza(i, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    @Deprecated
    public final void zzu(int i) throws IOException {
        this.zza.zza(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzv(int i, Object obj) throws IOException {
        if (obj instanceof zzlg) {
            this.zza.zzn(i, (zzlg) obj);
        } else {
            this.zza.zzm(i, (zznl) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzF(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmw)) {
            while (i2 < list.size()) {
                this.zza.zzh(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzmw zzmwVar = (zzmw) list;
        while (i2 < list.size()) {
            Object zzc = zzmwVar.zzc();
            if (zzc instanceof String) {
                this.zza.zzh(i, (String) zzc);
            } else {
                this.zza.zzi(i, (zzlg) zzc);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzllVar.zzr(i3);
            while (i2 < list.size()) {
                zzllVar.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z) {
            while (i2 < zzmzVar.size()) {
                this.zza.zzf(i, zzmzVar.zzc(i2));
                i2++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmzVar.size(); i6++) {
            zzmzVar.zzc(i6);
            i5 += 8;
        }
        zzllVar2.zzr(i5);
        while (i2 < zzmzVar.size()) {
            zzllVar2.zzu(zzmzVar.zzc(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzH(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmf)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzc(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzll.zzz(((Integer) list.get(i4)).intValue());
            }
            zzllVar.zzr(i3);
            while (i2 < list.size()) {
                zzllVar.zzr(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z) {
            while (i2 < zzmfVar.size()) {
                this.zza.zzc(i, zzmfVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmfVar.size(); i6++) {
            i5 += zzll.zzz(zzmfVar.zzf(i6));
        }
        zzllVar2.zzr(i5);
        while (i2 < zzmfVar.size()) {
            zzllVar2.zzr(zzmfVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzx(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmf)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzllVar.zzr(i3);
            while (i2 < list.size()) {
                zzllVar.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z) {
            while (i2 < zzmfVar.size()) {
                this.zza.zzd(i, zzmfVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmfVar.size(); i6++) {
            zzmfVar.zzf(i6);
            i5 += 4;
        }
        zzllVar2.zzr(i5);
        while (i2 < zzmfVar.size()) {
            zzllVar2.zzs(zzmfVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzz(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zze(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzll.zzA(((Long) list.get(i4)).longValue());
            }
            zzllVar.zzr(i3);
            while (i2 < list.size()) {
                zzllVar.zzt(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z) {
            while (i2 < zzmzVar.size()) {
                this.zza.zze(i, zzmzVar.zzc(i2));
                i2++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmzVar.size(); i6++) {
            i5 += zzll.zzA(zzmzVar.zzc(i6));
        }
        zzllVar2.zzr(i5);
        while (i2 < zzmzVar.size()) {
            zzllVar2.zzt(zzmzVar.zzc(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkx)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzg(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            zzllVar.zzr(i3);
            while (i2 < list.size()) {
                zzllVar.zzp(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzkx zzkxVar = (zzkx) list;
        if (!z) {
            while (i2 < zzkxVar.size()) {
                this.zza.zzg(i, zzkxVar.zze(i2));
                i2++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzkxVar.size(); i6++) {
            zzkxVar.zze(i6);
            i5++;
        }
        zzllVar2.zzr(i5);
        while (i2 < zzkxVar.size()) {
            zzllVar2.zzp(zzkxVar.zze(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzw(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmf)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzb(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzll.zzA(((Integer) list.get(i4)).intValue());
            }
            zzllVar.zzr(i3);
            while (i2 < list.size()) {
                zzllVar.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z) {
            while (i2 < zzmfVar.size()) {
                this.zza.zzb(i, zzmfVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmfVar.size(); i6++) {
            i5 += zzll.zzA(zzmfVar.zzf(i6));
        }
        zzllVar2.zzr(i5);
        while (i2 < zzmfVar.size()) {
            zzllVar2.zzq(zzmfVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzB(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzlx)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            zzllVar.zzr(i3);
            while (i2 < list.size()) {
                zzllVar.zzs(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzlx zzlxVar = (zzlx) list;
        if (!z) {
            while (i2 < zzlxVar.size()) {
                this.zza.zzd(i, Float.floatToRawIntBits(zzlxVar.zze(i2)));
                i2++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzlxVar.size(); i6++) {
            zzlxVar.zze(i6);
            i5 += 4;
        }
        zzllVar2.zzr(i5);
        while (i2 < zzlxVar.size()) {
            zzllVar2.zzs(Float.floatToRawIntBits(zzlxVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzln)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            zzllVar.zzr(i3);
            while (i2 < list.size()) {
                zzllVar.zzu(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzln zzlnVar = (zzln) list;
        if (!z) {
            while (i2 < zzlnVar.size()) {
                this.zza.zzf(i, Double.doubleToRawLongBits(zzlnVar.zze(i2)));
                i2++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzlnVar.size(); i6++) {
            zzlnVar.zze(i6);
            i5 += 8;
        }
        zzllVar2.zzr(i5);
        while (i2 < zzlnVar.size()) {
            zzllVar2.zzu(Double.doubleToRawLongBits(zzlnVar.zze(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzI(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmf)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzllVar.zzr(i3);
            while (i2 < list.size()) {
                zzllVar.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z) {
            while (i2 < zzmfVar.size()) {
                this.zza.zzd(i, zzmfVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmfVar.size(); i6++) {
            zzmfVar.zzf(i6);
            i5 += 4;
        }
        zzllVar2.zzr(i5);
        while (i2 < zzmfVar.size()) {
            zzllVar2.zzs(zzmfVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzllVar.zzr(i3);
            while (i2 < list.size()) {
                zzllVar.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z) {
            while (i2 < zzmzVar.size()) {
                this.zza.zzf(i, zzmzVar.zzc(i2));
                i2++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmzVar.size(); i6++) {
            zzmzVar.zzc(i6);
            i5 += 8;
        }
        zzllVar2.zzr(i5);
        while (i2 < zzmzVar.size()) {
            zzllVar2.zzu(zzmzVar.zzc(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzD(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmf)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzb(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzll.zzA(((Integer) list.get(i4)).intValue());
            }
            zzllVar.zzr(i3);
            while (i2 < list.size()) {
                zzllVar.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z) {
            while (i2 < zzmfVar.size()) {
                this.zza.zzb(i, zzmfVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmfVar.size(); i6++) {
            i5 += zzll.zzA(zzmfVar.zzf(i6));
        }
        zzllVar2.zzr(i5);
        while (i2 < zzmfVar.size()) {
            zzllVar2.zzq(zzmfVar.zzf(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzK(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmf)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzll zzllVar = this.zza;
                    int intValue = ((Integer) list.get(i2)).intValue();
                    zzllVar.zzc(i, (intValue >> 31) ^ (intValue + intValue));
                    i2++;
                }
                return;
            }
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                int intValue2 = ((Integer) list.get(i4)).intValue();
                i3 += zzll.zzz((intValue2 >> 31) ^ (intValue2 + intValue2));
            }
            zzllVar2.zzr(i3);
            while (i2 < list.size()) {
                int intValue3 = ((Integer) list.get(i2)).intValue();
                zzllVar2.zzr((intValue3 >> 31) ^ (intValue3 + intValue3));
                i2++;
            }
            return;
        }
        zzmf zzmfVar = (zzmf) list;
        if (!z) {
            while (i2 < zzmfVar.size()) {
                zzll zzllVar3 = this.zza;
                int zzf = zzmfVar.zzf(i2);
                zzllVar3.zzc(i, (zzf >> 31) ^ (zzf + zzf));
                i2++;
            }
            return;
        }
        zzll zzllVar4 = this.zza;
        zzllVar4.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmfVar.size(); i6++) {
            int zzf2 = zzmfVar.zzf(i6);
            i5 += zzll.zzz((zzf2 >> 31) ^ (zzf2 + zzf2));
        }
        zzllVar4.zzr(i5);
        while (i2 < zzmfVar.size()) {
            int zzf3 = zzmfVar.zzf(i2);
            zzllVar4.zzr((zzf3 >> 31) ^ (zzf3 + zzf3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmz)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzll zzllVar = this.zza;
                    long longValue = ((Long) list.get(i2)).longValue();
                    zzllVar.zze(i, (longValue >> 63) ^ (longValue + longValue));
                    i2++;
                }
                return;
            }
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                long longValue2 = ((Long) list.get(i4)).longValue();
                i3 += zzll.zzA((longValue2 >> 63) ^ (longValue2 + longValue2));
            }
            zzllVar2.zzr(i3);
            while (i2 < list.size()) {
                long longValue3 = ((Long) list.get(i2)).longValue();
                zzllVar2.zzt((longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z) {
            while (i2 < zzmzVar.size()) {
                zzll zzllVar3 = this.zza;
                long zzc = zzmzVar.zzc(i2);
                zzllVar3.zze(i, (zzc >> 63) ^ (zzc + zzc));
                i2++;
            }
            return;
        }
        zzll zzllVar4 = this.zza;
        zzllVar4.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmzVar.size(); i6++) {
            long zzc2 = zzmzVar.zzc(i6);
            i5 += zzll.zzA((zzc2 >> 63) ^ (zzc2 + zzc2));
        }
        zzllVar4.zzr(i5);
        while (i2 < zzmzVar.size()) {
            long zzc3 = zzmzVar.zzc(i2);
            zzllVar4.zzt((zzc3 >> 63) ^ (zzc3 + zzc3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzmz)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zze(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzll zzllVar = this.zza;
            zzllVar.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzll.zzA(((Long) list.get(i4)).longValue());
            }
            zzllVar.zzr(i3);
            while (i2 < list.size()) {
                zzllVar.zzt(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzmz zzmzVar = (zzmz) list;
        if (!z) {
            while (i2 < zzmzVar.size()) {
                this.zza.zze(i, zzmzVar.zzc(i2));
                i2++;
            }
            return;
        }
        zzll zzllVar2 = this.zza;
        zzllVar2.zza(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzmzVar.size(); i6++) {
            i5 += zzll.zzA(zzmzVar.zzc(i6));
        }
        zzllVar2.zzr(i5);
        while (i2 < zzmzVar.size()) {
            zzllVar2.zzt(zzmzVar.zzc(i2));
            i2++;
        }
    }
}
