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
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
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
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00eb, code lost:
        if (r14 == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0113, code lost:
        if (r14 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0115, code lost:
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0118, code lost:
        r0 = r16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.google.android.gms.internal.measurement.zzhs zza(String str, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        Cursor cursor;
        com.google.android.gms.internal.measurement.zzhs zzhsVar2;
        long j;
        Cursor cursor2;
        Pair pair;
        Pair pair2;
        String zzd = zzhsVar.zzd();
        List zza = zzhsVar.zza();
        zzad zzadVar = this.zza;
        zzpg zzpgVar = zzadVar.zzg;
        zzpgVar.zzp();
        Long l = (Long) zzpk.zzI(zzhsVar, "_eid");
        if (l != null) {
            if (zzd.equals("_ep")) {
                Preconditions.checkNotNull(l);
                zzpgVar.zzp();
                String str2 = (String) zzpk.zzI(zzhsVar, "_en");
                if (TextUtils.isEmpty(str2)) {
                    zzadVar.zzu.zzaV().zzc().zzb("Extra parameter without an event name. eventId", l);
                    return null;
                }
                if (this.zzb == null || this.zzc == null || l.longValue() != this.zzc.longValue()) {
                    zzav zzj = zzpgVar.zzj();
                    zzj.zzg();
                    zzj.zzaw();
                    try {
                        cursor2 = zzj.zze().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l.toString()});
                        try {
                            try {
                                if (cursor2.moveToFirst()) {
                                    zzhsVar2 = null;
                                    try {
                                        try {
                                            Pair create = Pair.create((com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursor2.getBlob(0))).zzbc(), Long.valueOf(cursor2.getLong(1)));
                                            pair2 = create;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                                pair2 = create;
                                            }
                                        } catch (IOException e) {
                                            j = 0;
                                            try {
                                                zzj.zzu.zzaV().zzb().zzd("Failed to merge main event. appId, eventId", zzgu.zzl(str), l, e);
                                            } catch (SQLiteException e2) {
                                                e = e2;
                                                zzj.zzu.zzaV().zzb().zzb("Error selecting main event", e);
                                            }
                                        }
                                    } catch (SQLiteException e3) {
                                        e = e3;
                                        j = 0;
                                        zzj.zzu.zzaV().zzb().zzb("Error selecting main event", e);
                                    }
                                } else {
                                    zzj.zzu.zzaV().zzk().zza("Main event not found");
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    pair2 = null;
                                    zzhsVar2 = null;
                                }
                                j = 0;
                                pair = pair2;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e4) {
                            e = e4;
                            zzhsVar2 = null;
                        }
                    } catch (SQLiteException e5) {
                        e = e5;
                        zzhsVar2 = null;
                        j = 0;
                        cursor2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = null;
                    }
                    if (pair == 0 || pair.first == null) {
                        this.zza.zzu.zzaV().zzc().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                        return zzhsVar2;
                    }
                    this.zzb = (com.google.android.gms.internal.measurement.zzhs) pair.first;
                    this.zzd = ((Long) pair.second).longValue();
                    this.zza.zzg.zzp();
                    this.zzc = (Long) zzpk.zzI(this.zzb, "_eid");
                } else {
                    j = 0;
                }
                long j2 = this.zzd - 1;
                this.zzd = j2;
                if (j2 <= j) {
                    zzav zzj2 = this.zza.zzg.zzj();
                    zzj2.zzg();
                    zzj2.zzu.zzaV().zzk().zzb("Clearing complex main event info. appId", str);
                    try {
                        zzj2.zze().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                    } catch (SQLiteException e6) {
                        zzj2.zzu.zzaV().zzb().zzb("Error clearing complex main event", e6);
                    }
                } else {
                    this.zza.zzg.zzj().zzT(str, l, this.zzd, this.zzb);
                }
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzhw zzhwVar : this.zzb.zza()) {
                    this.zza.zzg.zzp();
                    if (zzpk.zzF(zzhsVar, zzhwVar.zzb()) == null) {
                        arrayList.add(zzhwVar);
                    }
                }
                if (arrayList.isEmpty()) {
                    this.zza.zzu.zzaV().zzc().zzb("No unique parameters in main event. eventName", str2);
                } else {
                    arrayList.addAll(zza);
                    zza = arrayList;
                }
                zzd = str2;
            } else {
                this.zzc = l;
                this.zzb = zzhsVar;
                zzpgVar.zzp();
                long longValue = ((Long) zzpk.zzJ(zzhsVar, "_epc", 0L)).longValue();
                this.zzd = longValue;
                if (longValue <= 0) {
                    zzadVar.zzu.zzaV().zzc().zzb("Complex event with zero extra param count. eventName", zzd);
                } else {
                    zzpgVar.zzj().zzT(str, (Long) Preconditions.checkNotNull(l), this.zzd, zzhsVar);
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
