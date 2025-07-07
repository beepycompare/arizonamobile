package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzz {
    final /* synthetic */ zzae zza;
    private com.google.android.gms.internal.measurement.zzhm zzb;
    private Long zzc;
    private long zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzz(zzae zzaeVar, zzad zzadVar) {
        this.zza = zzaeVar;
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
    public final com.google.android.gms.internal.measurement.zzhm zza(String str, com.google.android.gms.internal.measurement.zzhm zzhmVar) {
        zzaw zzj;
        com.google.android.gms.internal.measurement.zzhm zzhmVar2;
        long j;
        Pair pair;
        long j2;
        ArrayList arrayList;
        ?? longValue;
        String zzh = zzhmVar.zzh();
        List zzi = zzhmVar.zzi();
        zzae zzaeVar = this.zza;
        zzpv zzpvVar = zzaeVar.zzg;
        zzpvVar.zzA();
        Long l = (Long) zzqa.zzH(zzhmVar, "_eid");
        if (l != null) {
            if (zzh.equals("_ep")) {
                Preconditions.checkNotNull(l);
                zzpvVar.zzA();
                String str2 = (String) zzqa.zzH(zzhmVar, "_en");
                if (TextUtils.isEmpty(str2)) {
                    zzaeVar.zzu.zzaW().zzh().zzb("Extra parameter without an event name. eventId", l);
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
                                zzaw zzj2 = this.zza.zzg.zzj();
                                zzj2.zzg();
                                zzj2.zzu.zzaW().zzj().zzb("Clearing complex main event info. appId", str);
                                try {
                                    zzj2.zzj().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                                } catch (SQLiteException e) {
                                    zzj2.zzu.zzaW().zze().zzb("Error clearing complex main event", e);
                                }
                            } else {
                                this.zza.zzg.zzj().zzaf(str, l, this.zzd, this.zzb);
                            }
                            arrayList = new ArrayList();
                            for (com.google.android.gms.internal.measurement.zzhq zzhqVar : this.zzb.zzi()) {
                                this.zza.zzg.zzA();
                                if (zzqa.zzG(zzhmVar, zzhqVar.zzg()) == null) {
                                    arrayList.add(zzhqVar);
                                }
                            }
                            if (arrayList.isEmpty()) {
                                arrayList.addAll(zzi);
                                zzi = arrayList;
                            } else {
                                this.zza.zzu.zzaW().zzh().zzb("No unique parameters in main event. eventName", str2);
                            }
                            zzh = str2;
                        }
                    }
                    Cursor cursor = zzj.zzj().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l.toString()});
                    if (cursor.moveToFirst()) {
                        zzhmVar2 = null;
                        try {
                            try {
                                Pair create = Pair.create((com.google.android.gms.internal.measurement.zzhm) ((com.google.android.gms.internal.measurement.zzhl) zzqa.zzp(com.google.android.gms.internal.measurement.zzhm.zze(), cursor.getBlob(0))).zzba(), Long.valueOf(cursor.getLong(1)));
                                pair = create;
                                if (cursor != null) {
                                    cursor.close();
                                    pair = create;
                                }
                            } catch (IOException e2) {
                                j = 0;
                                try {
                                    zzj.zzu.zzaW().zze().zzd("Failed to merge main event. appId, eventId", zzhe.zzn(str), l, e2);
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    zzj.zzu.zzaW().zze().zzb("Error selecting main event", e);
                                }
                            }
                        } catch (SQLiteException e4) {
                            e = e4;
                            j = 0;
                            zzj.zzu.zzaW().zze().zzb("Error selecting main event", e);
                        }
                    } else {
                        zzj.zzu.zzaW().zzj().zza("Main event not found");
                        if (cursor != null) {
                            cursor.close();
                        }
                        pair = null;
                        zzhmVar2 = null;
                    }
                    j = 0;
                    Pair pair2 = pair;
                    if (pair2 == 0 || pair2.first == null) {
                        this.zza.zzu.zzaW().zzh().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                        return zzhmVar2;
                    }
                    this.zzb = (com.google.android.gms.internal.measurement.zzhm) pair2.first;
                    this.zzd = ((Long) pair2.second).longValue();
                    this.zza.zzg.zzA();
                    this.zzc = (Long) zzqa.zzH(this.zzb, "_eid");
                    j2 = this.zzd - 1;
                    this.zzd = j2;
                    if (j2 > j) {
                    }
                    arrayList = new ArrayList();
                    while (r2.hasNext()) {
                    }
                    if (arrayList.isEmpty()) {
                    }
                    zzh = str2;
                } catch (Throwable th) {
                    th = th;
                    Cursor cursor2 = longValue;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
                zzj = zzpvVar.zzj();
                zzj.zzg();
                zzj.zzav();
            } else {
                this.zzc = l;
                this.zzb = zzhmVar;
                zzpvVar.zzA();
                long longValue2 = ((Long) zzqa.zzI(zzhmVar, "_epc", 0L)).longValue();
                this.zzd = longValue2;
                if (longValue2 <= 0) {
                    zzaeVar.zzu.zzaW().zzh().zzb("Complex event with zero extra param count. eventName", zzh);
                } else {
                    zzpvVar.zzj().zzaf(str, (Long) Preconditions.checkNotNull(l), this.zzd, zzhmVar);
                }
            }
        }
        com.google.android.gms.internal.measurement.zzhl zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzhmVar.zzch();
        zzhlVar.zzi(zzh);
        zzhlVar.zzg();
        zzhlVar.zzd(zzi);
        return (com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba();
    }
}
