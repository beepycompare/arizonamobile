package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzz {
    final /* synthetic */ zzad zza;
    private com.google.android.gms.internal.measurement.zzhs zzb;
    private Long zzc;
    private long zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzz(zzad zzadVar, byte[] bArr) {
        Objects.requireNonNull(zzadVar);
        this.zza = zzadVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:10|(2:14|(9:16|17|(3:19|20|21)(1:41)|22|(4:25|(3:27|28|29)(1:31)|30|23)|32|33|(1:35)(1:37)|36))|42|43|44|45|46|(3:48|(1:50)|51)(6:59|60|61|62|63|(1:65))|52|(2:57|58)(9:56|17|(0)(0)|22|(1:23)|32|33|(0)(0)|36)) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ea, code lost:
        if (r14 == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ef, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f5, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f6, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fc, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fd, code lost:
        r16 = null;
        r17 = 0;
        r14 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0112, code lost:
        if (r14 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0114, code lost:
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0117, code lost:
        r0 = r16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01fa  */
    /* JADX WARN: Type inference failed for: r14v6, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.google.android.gms.internal.measurement.zzhs zza(String str, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        zzav zzj;
        com.google.android.gms.internal.measurement.zzhs zzhsVar2;
        long j;
        Pair pair;
        long j2;
        ArrayList arrayList;
        ?? longValue;
        String zzd = zzhsVar.zzd();
        List zza = zzhsVar.zza();
        zzad zzadVar = this.zza;
        zzpf zzpfVar = zzadVar.zzg;
        zzpfVar.zzp();
        Long l = (Long) zzpj.zzI(zzhsVar, "_eid");
        if (l != null) {
            if (zzd.equals("_ep")) {
                Preconditions.checkNotNull(l);
                zzpfVar.zzp();
                String str2 = (String) zzpj.zzI(zzhsVar, "_en");
                if (TextUtils.isEmpty(str2)) {
                    zzadVar.zzu.zzaV().zzc().zzb("Extra parameter without an event name. eventId", l);
                    return null;
                }
                try {
                    if (this.zzb != null && this.zzc != null) {
                        longValue = l.longValue();
                        if (longValue == this.zzc.longValue()) {
                            j = 0;
                            j2 = this.zzd - 1;
                            this.zzd = j2;
                            if (j2 > j) {
                                zzav zzj2 = this.zza.zzg.zzj();
                                zzj2.zzg();
                                zzj2.zzu.zzaV().zzk().zzb("Clearing complex main event info. appId", str);
                                try {
                                    zzj2.zze().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                                } catch (SQLiteException e) {
                                    zzj2.zzu.zzaV().zzb().zzb("Error clearing complex main event", e);
                                }
                            } else {
                                this.zza.zzg.zzj().zzV(str, l, this.zzd, this.zzb);
                            }
                            arrayList = new ArrayList();
                            for (com.google.android.gms.internal.measurement.zzhw zzhwVar : this.zzb.zza()) {
                                this.zza.zzg.zzp();
                                if (zzpj.zzF(zzhsVar, zzhwVar.zzb()) == null) {
                                    arrayList.add(zzhwVar);
                                }
                            }
                            if (arrayList.isEmpty()) {
                                arrayList.addAll(zza);
                                zza = arrayList;
                            } else {
                                this.zza.zzu.zzaV().zzc().zzb("No unique parameters in main event. eventName", str2);
                            }
                            zzd = str2;
                        }
                    }
                    Cursor cursor = zzj.zze().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l.toString()});
                    if (cursor.moveToFirst()) {
                        zzhsVar2 = null;
                        try {
                            try {
                                Pair create = Pair.create((com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpj.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursor.getBlob(0))).zzbc(), Long.valueOf(cursor.getLong(1)));
                                pair = create;
                                if (cursor != null) {
                                    cursor.close();
                                    pair = create;
                                }
                            } catch (IOException e2) {
                                j = 0;
                                try {
                                    zzj.zzu.zzaV().zzb().zzd("Failed to merge main event. appId, eventId", zzgt.zzl(str), l, e2);
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    zzj.zzu.zzaV().zzb().zzb("Error selecting main event", e);
                                }
                            }
                        } catch (SQLiteException e4) {
                            e = e4;
                            j = 0;
                            zzj.zzu.zzaV().zzb().zzb("Error selecting main event", e);
                        }
                    } else {
                        zzj.zzu.zzaV().zzk().zza("Main event not found");
                        if (cursor != null) {
                            cursor.close();
                        }
                        pair = null;
                        zzhsVar2 = null;
                    }
                    j = 0;
                    Pair pair2 = pair;
                    if (pair2 == 0 || pair2.first == null) {
                        this.zza.zzu.zzaV().zzc().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                        return zzhsVar2;
                    }
                    this.zzb = (com.google.android.gms.internal.measurement.zzhs) pair2.first;
                    this.zzd = ((Long) pair2.second).longValue();
                    this.zza.zzg.zzp();
                    this.zzc = (Long) zzpj.zzI(this.zzb, "_eid");
                    j2 = this.zzd - 1;
                    this.zzd = j2;
                    if (j2 > j) {
                    }
                    arrayList = new ArrayList();
                    while (r2.hasNext()) {
                    }
                    if (arrayList.isEmpty()) {
                    }
                    zzd = str2;
                } catch (Throwable th) {
                    th = th;
                    Cursor cursor2 = longValue;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
                zzj = zzpfVar.zzj();
                zzj.zzg();
                zzj.zzay();
            } else {
                this.zzc = l;
                this.zzb = zzhsVar;
                zzpfVar.zzp();
                long longValue2 = ((Long) zzpj.zzJ(zzhsVar, "_epc", 0L)).longValue();
                this.zzd = longValue2;
                if (longValue2 <= 0) {
                    zzadVar.zzu.zzaV().zzc().zzb("Complex event with zero extra param count. eventName", zzd);
                } else {
                    zzpfVar.zzj().zzV(str, (Long) Preconditions.checkNotNull(l), this.zzd, zzhsVar);
                }
            }
        }
        com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVar.zzcl();
        zzhrVar.zzl(zzd);
        zzhrVar.zzi();
        zzhrVar.zzh(zza);
        return (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc();
    }
}
