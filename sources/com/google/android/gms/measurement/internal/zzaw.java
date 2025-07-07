package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzaw extends zzpg {
    private final zzav zzm;
    private final zzou zzn;
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    static final String[] zza = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzj = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzk = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzl = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaw(zzpv zzpvVar) {
        super(zzpvVar);
        this.zzn = new zzou(this.zzu.zzaU());
        this.zzu.zzf();
        this.zzm = new zzav(this, this.zzu.zzaT(), "google_app_measurement.db");
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzbd zzaA(String str, String str2, String str3) {
        String str4;
        Cursor cursor;
        Cursor cursor2;
        Boolean bool;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        zzg();
        zzav();
        Cursor cursor3 = null;
        try {
            cursor = zzj().query(str, (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str2, str3}, null, null, null);
            try {
            } catch (SQLiteException e) {
                e = e;
                str4 = str3;
                cursor2 = cursor;
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
            }
        } catch (SQLiteException e2) {
            e = e2;
            str4 = str3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (!cursor.moveToFirst()) {
            if (cursor != null) {
                cursor.close();
            }
            return null;
        }
        long j = cursor.getLong(0);
        long j2 = cursor.getLong(1);
        long j3 = cursor.getLong(2);
        long j4 = cursor.isNull(3) ? 0L : cursor.getLong(3);
        Long valueOf = cursor.isNull(4) ? null : Long.valueOf(cursor.getLong(4));
        Long valueOf2 = cursor.isNull(5) ? null : Long.valueOf(cursor.getLong(5));
        Long valueOf3 = cursor.isNull(6) ? null : Long.valueOf(cursor.getLong(6));
        if (cursor.isNull(7)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getLong(7) == 1);
        }
        try {
            cursor2 = cursor;
            Long l = valueOf2;
            str4 = str3;
            try {
                zzbd zzbdVar = new zzbd(str2, str4, j, j2, cursor.isNull(8) ? 0L : cursor.getLong(8), j3, j4, valueOf, l, valueOf3, bool);
                if (cursor2.moveToNext()) {
                    this.zzu.zzaW().zze().zzb("Got multiple records for event aggregates, expected one. appId", zzhe.zzn(str2));
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                return zzbdVar;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = cursor2;
                try {
                    zzio zzioVar = this.zzu;
                    zzioVar.zzaW().zze().zzd("Error querying events. appId", zzhe.zzn(str2), zzioVar.zzj().zzd(str4), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    cursor3 = cursor;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                cursor3 = cursor2;
                if (cursor3 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            str4 = str3;
            cursor2 = cursor;
        } catch (Throwable th5) {
            th = th5;
            cursor2 = cursor;
        }
    }

    private final zzpz zzaB(String str, long j, byte[] bArr, String str2, String str3, int i, int i2, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str2)) {
            this.zzu.zzaW().zzd().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.zzht zzhtVar = (com.google.android.gms.internal.measurement.zzht) zzqa.zzp(com.google.android.gms.internal.measurement.zzhv.zzb(), bArr);
            zzmf zzb2 = zzmf.zzb(i);
            if (zzb2 != zzmf.GOOGLE_SIGNAL && zzb2 != zzmf.GOOGLE_SIGNAL_PENDING && i2 > 0) {
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzhx zzhxVar : zzhtVar.zzj()) {
                    com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzhxVar.zzch();
                    zzhwVar.zzat(i2);
                    arrayList.add((com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba());
                }
                zzhtVar.zzd();
                zzhtVar.zzb(arrayList);
            }
            HashMap hashMap = new HashMap();
            if (str3 != null) {
                String[] split = str3.split("\r\n");
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    String str4 = split[i3];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] split2 = str4.split("=", 2);
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                        i3++;
                    } else {
                        this.zzu.zzaW().zze().zzb("Invalid upload header: ", str4);
                        break;
                    }
                }
            }
            zzpx zzpxVar = new zzpx();
            zzpxVar.zzf(j);
            zzpxVar.zzd((com.google.android.gms.internal.measurement.zzhv) zzhtVar.zzba());
            zzpxVar.zzi(str2);
            zzpxVar.zzg(hashMap);
            zzpxVar.zzh(zzb2);
            zzpxVar.zzb(j2);
            zzpxVar.zza(j3);
            zzpxVar.zzc(j4);
            zzpxVar.zze(i2);
            return zzpxVar.zzj();
        } catch (IOException e) {
            this.zzu.zzaW().zze().zzc("Failed to queued MeasurementBatch from upload_queue. appId", str, e);
            return null;
        }
    }

    private final String zzaC() {
        zzio zzioVar = this.zzu;
        long currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
        Locale locale = Locale.US;
        zzmf zzmfVar = zzmf.GOOGLE_SIGNAL;
        Integer valueOf = Integer.valueOf(zzmfVar.zza());
        Long valueOf2 = Long.valueOf(currentTimeMillis);
        zzioVar.zzf();
        String format = String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", valueOf, valueOf2, Long.valueOf(((Long) zzgi.zzR.zza(null)).longValue()));
        Locale locale2 = Locale.US;
        Integer valueOf3 = Integer.valueOf(zzmfVar.zza());
        zzioVar.zzf();
        String format2 = String.format(locale2, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", valueOf3, valueOf2, Long.valueOf(zzam.zzI()));
        return "(" + format + " OR " + format2 + ")";
    }

    private final String zzaD(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            try {
                cursor = zzj().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getString(0);
                }
                if (cursor != null) {
                    cursor.close();
                    return "";
                }
                return "";
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final void zzaE(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        try {
            zzj().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error deleting snapshot. appId", zzhe.zzn(str2), e);
        }
    }

    private final void zzaF(String str, zzbd zzbdVar) {
        Preconditions.checkNotNull(zzbdVar);
        zzg();
        zzav();
        ContentValues contentValues = new ContentValues();
        String str2 = zzbdVar.zza;
        contentValues.put("app_id", str2);
        contentValues.put("name", zzbdVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbdVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbdVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbdVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbdVar.zzg));
        contentValues.put("last_bundled_day", zzbdVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbdVar.zzi);
        contentValues.put("last_sampling_rate", zzbdVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbdVar.zze));
        Boolean bool = zzbdVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (zzj().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                this.zzu.zzaW().zze().zzb("Failed to insert/update event aggregates (got -1). appId", zzhe.zzn(str2));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing event aggregates. appId", zzhe.zzn(zzbdVar.zza), e);
        }
    }

    private final void zzaG(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase zzj2 = zzj();
            String asString = contentValues.getAsString("app_id");
            if (asString == null) {
                this.zzu.zzaW().zzf().zzb("Value of the primary key is not set.", zzhe.zzn("app_id"));
            } else if (zzj2.update("consent_settings", contentValues, "app_id = ?", new String[]{asString}) == 0 && zzj2.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                this.zzu.zzaW().zze().zzc("Failed to insert/update table (got -1). key", zzhe.zzn("consent_settings"), zzhe.zzn("app_id"));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzd("Error storing into table. key", zzhe.zzn("consent_settings"), zzhe.zzn("app_id"), e);
        }
    }

    private static final String zzaH(List list) {
        return list.isEmpty() ? "" : String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    static final void zzau(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final long zzay(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = zzj().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzaz(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = zzj().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    j = cursor.getLong(0);
                }
                return j;
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String zzA() {
        SQLiteException e;
        Cursor cursor;
        SQLiteDatabase zzj2 = zzj();
        ?? r1 = 0;
        try {
            try {
                cursor = zzj2.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(0);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zze().zzb("Database error getting next bundle app id", e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                r1 = zzj2;
                th = th;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public final List zzB(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzC(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0086, code lost:
        r3 = r11.zzaW().zze();
        r11.zzf();
        r3.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzC(String str, String[] strArr) {
        Cursor cursor;
        Cursor cursor2;
        zzg();
        zzav();
        List arrayList = new ArrayList();
        try {
            SQLiteDatabase zzj2 = zzj();
            int i = 0;
            int i2 = 1;
            String[] strArr2 = {"app_id", "origin", "name", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"};
            zzio zzioVar = this.zzu;
            zzioVar.zzf();
            cursor2 = zzj2.query("conditional_properties", strArr2, str, strArr, null, null, "rowid", "1001");
            try {
                if (cursor2.moveToFirst()) {
                    while (true) {
                        int size = arrayList.size();
                        zzioVar.zzf();
                        if (size >= 1000) {
                            break;
                        }
                        String string = cursor2.getString(i);
                        String string2 = cursor2.getString(i2);
                        String string3 = cursor2.getString(2);
                        Object zzz = zzz(cursor2, 3);
                        boolean z = cursor2.getInt(4) != 0 ? i2 : i;
                        String string4 = cursor2.getString(5);
                        long j = cursor2.getLong(6);
                        zzpv zzpvVar = this.zzg;
                        arrayList.add(new zzai(string, string2, new zzqb(string3, cursor2.getLong(10), zzz, string2), cursor2.getLong(8), z, string4, (zzbh) zzpvVar.zzA().zzi(cursor2.getBlob(7), zzbh.CREATOR), j, (zzbh) zzpvVar.zzA().zzi(cursor2.getBlob(9), zzbh.CREATOR), cursor2.getLong(11), (zzbh) zzpvVar.zzA().zzi(cursor2.getBlob(12), zzbh.CREATOR)));
                        if (!cursor2.moveToNext()) {
                            break;
                        }
                        i = 0;
                        i2 = 1;
                    }
                }
            } catch (SQLiteException e) {
                e = e;
                cursor = cursor2;
                try {
                    this.zzu.zzaW().zze().zzb("Error querying conditional user property value", e);
                    arrayList = Collections.emptyList();
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursor2;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (cursor2 != null) {
            cursor2.close();
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzD(String str, zzpc zzpcVar, int i) {
        Cursor cursor;
        String str2;
        List list;
        Cursor cursor2;
        Cursor cursor3;
        if (!this.zzu.zzf().zzx(null, zzgi.zzaP)) {
            return Collections.emptyList();
        }
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        try {
            int i2 = 0;
            int i3 = 2;
            int i4 = 7;
            int i5 = 5;
            int i6 = 6;
            int i7 = 4;
            cursor2 = zzj().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"}, "app_id=?" + zzaH(zzpcVar.zza) + " AND NOT " + zzaC(), new String[]{str}, null, null, "creation_timestamp ASC", i > 0 ? String.valueOf(i) : null);
            try {
                list = new ArrayList();
                while (cursor2.moveToNext()) {
                    long j = cursor2.getLong(i2);
                    byte[] blob = cursor2.getBlob(i3);
                    List list2 = list;
                    String string = cursor2.getString(3);
                    String string2 = cursor2.getString(i7);
                    int i8 = cursor2.getInt(i5);
                    int i9 = cursor2.getInt(i6);
                    long j2 = cursor2.getLong(i4);
                    int i10 = i2;
                    int i11 = i6;
                    int i12 = i3;
                    int i13 = i5;
                    cursor3 = cursor2;
                    int i14 = i4;
                    str2 = str;
                    try {
                        zzpz zzaB = zzaB(str2, j, blob, string, string2, i8, i9, j2, cursor2.getLong(8), cursor2.getLong(9));
                        if (zzaB != null) {
                            list2.add(zzaB);
                        }
                        list = list2;
                        cursor2 = cursor3;
                        i4 = i14;
                        i6 = i11;
                        i5 = i13;
                        i3 = i12;
                        i2 = i10;
                        i7 = 4;
                    } catch (SQLiteException e) {
                        e = e;
                        cursor = cursor3;
                        try {
                            this.zzu.zzaW().zze().zzc("Error to querying MeasurementBatch from upload_queue. appId", str2, e);
                            list = Collections.emptyList();
                            cursor2 = cursor;
                            if (cursor2 != null) {
                            }
                            return list;
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursor3;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                str2 = str;
                cursor3 = cursor2;
            } catch (Throwable th3) {
                th = th3;
                cursor3 = cursor2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            str2 = str;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        if (cursor2 != null) {
            cursor2.close();
        }
        return list;
    }

    public final List zzE(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        List arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                zzio zzioVar = this.zzu;
                zzioVar.zzf();
                cursor = zzj().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(0);
                        String string2 = cursor.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j = cursor.getLong(2);
                        Object zzz = zzz(cursor, 3);
                        if (zzz != null) {
                            arrayList.add(new zzqd(str, str2, string, j, zzz));
                        } else {
                            zzioVar.zzaW().zze().zzb("Read invalid user property value, ignoring it. appId", zzhe.zzn(str));
                        }
                    } while (cursor.moveToNext());
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Error querying user properties. appId", zzhe.zzn(str), e);
                arrayList = Collections.emptyList();
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b0, code lost:
        r0 = r13.zzaW().zze();
        r13.zzf();
        r0.zzb("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzF(String str, String str2, String str3) {
        Cursor cursor;
        String str4;
        Cursor cursor2;
        String str5;
        zzio zzioVar;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        List arrayList = new ArrayList();
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                str5 = str;
                arrayList2.add(str5);
                StringBuilder sb = new StringBuilder("app_id=?");
                if (TextUtils.isEmpty(str2)) {
                    str4 = str2;
                } else {
                    str4 = str2;
                    try {
                        arrayList2.add(str4);
                        sb.append(" and origin=?");
                    } catch (SQLiteException e) {
                        e = e;
                        cursor = null;
                        try {
                            this.zzu.zzaW().zze().zzd("(2)Error querying user properties", zzhe.zzn(str), str4, e);
                            arrayList = Collections.emptyList();
                            cursor2 = cursor;
                            if (cursor2 != null) {
                            }
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    arrayList2.add(str3 + "*");
                    sb.append(" and name glob ?");
                }
                String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                String sb2 = sb.toString();
                zzioVar = this.zzu;
                zzioVar.zzf();
                cursor2 = zzj().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb2, strArr, null, null, "rowid", "1001");
            } catch (SQLiteException e2) {
                e = e2;
                str4 = str2;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        try {
            try {
                if (cursor2.moveToFirst()) {
                    while (true) {
                        int size = arrayList.size();
                        zzioVar.zzf();
                        if (size >= 1000) {
                            break;
                        }
                        String string = cursor2.getString(0);
                        long j = cursor2.getLong(1);
                        Object zzz = zzz(cursor2, 2);
                        String string2 = cursor2.getString(3);
                        if (zzz != null) {
                            arrayList.add(new zzqd(str5, string2, string, j, zzz));
                        } else {
                            try {
                                zzioVar.zzaW().zze().zzd("(2)Read invalid user property value, ignoring it", zzhe.zzn(str5), string2, str3);
                            } catch (SQLiteException e3) {
                                e = e3;
                                cursor = cursor2;
                                str4 = string2;
                                this.zzu.zzaW().zze().zzd("(2)Error querying user properties", zzhe.zzn(str), str4, e);
                                arrayList = Collections.emptyList();
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                }
                                return arrayList;
                            }
                        }
                        if (!cursor2.moveToNext()) {
                            break;
                        }
                        str5 = str;
                        str4 = string2;
                    }
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = cursor2;
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            cursor = cursor2;
            if (cursor != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
        if (r6 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0095, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0098, code lost:
        r7 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00cc, code lost:
        if (r6 != null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ce, code lost:
        r6.close();
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e8, code lost:
        if (r6 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0106, code lost:
        if (r6 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0109, code lost:
        if (r7 == 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010b, code lost:
        r0 = r7.zzY().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0117, code lost:
        if (r0.hasNext() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0129, code lost:
        if (((com.google.android.gms.internal.measurement.zzio) r0.next()).zzg().equals(r28) == false) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzG(String str, Long l, String str2, Bundle bundle) {
        Cursor cursor;
        Object obj;
        Object obj2;
        com.google.android.gms.internal.measurement.zzhx zzhxVar;
        String str3 = str;
        Preconditions.checkNotNull(bundle);
        zzg();
        zzav();
        zzio zzioVar = this.zzu;
        Cursor cursor2 = null;
        zzau zzauVar = (!zzioVar.zzf().zzx(null, zzgi.zzbe) || l == null) ? new zzau(this, str3) : new zzau(this, str3, l.longValue());
        List<zzat> zza2 = zzauVar.zza();
        while (!zza2.isEmpty()) {
            for (zzat zzatVar : zza2) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        cursor = zzj().query("raw_events_metadata", new String[]{TtmlNode.TAG_METADATA}, "app_id = ? and metadata_fingerprint = ?", new String[]{str3, Long.toString(zzatVar.zzb)}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                        try {
                            try {
                                if (cursor.moveToFirst()) {
                                    try {
                                        obj = (com.google.android.gms.internal.measurement.zzhx) ((com.google.android.gms.internal.measurement.zzhw) zzqa.zzp(com.google.android.gms.internal.measurement.zzhx.zzz(), cursor.getBlob(0))).zzba();
                                        try {
                                            if (cursor.moveToNext()) {
                                                this.zzu.zzaW().zzk().zzb("Get multiple raw event metadata records, expected one. appId", zzhe.zzn(str3));
                                            }
                                            cursor.close();
                                            zzhxVar = obj;
                                            obj2 = obj;
                                        } catch (SQLiteException e) {
                                            e = e;
                                            this.zzu.zzaW().zze().zzc("Data loss. Error selecting raw event. appId", zzhe.zzn(str3), e);
                                            zzhxVar = obj;
                                            obj2 = obj;
                                        }
                                    } catch (IOException e2) {
                                        this.zzu.zzaW().zze().zzc("Data loss. Failed to merge raw event metadata. appId", zzhe.zzn(str3), e2);
                                    }
                                } else {
                                    zzioVar.zzaW().zze().zzb("Raw event metadata record is missing. appId", zzhe.zzn(str3));
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            obj = cursor2;
                        }
                    } catch (SQLiteException e4) {
                        e = e4;
                        cursor = cursor2;
                        obj = cursor;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                zzpv zzpvVar = this.zzg;
                zzqa zzA = zzpvVar.zzA();
                com.google.android.gms.internal.measurement.zzhm zzhmVar = zzatVar.zzd;
                Bundle bundle2 = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zzhmVar.zzi()) {
                    if (zzhqVar.zzu()) {
                        bundle2.putDouble(zzhqVar.zzg(), zzhqVar.zza());
                    } else if (zzhqVar.zzv()) {
                        bundle2.putFloat(zzhqVar.zzg(), zzhqVar.zzb());
                    } else if (zzhqVar.zzw()) {
                        bundle2.putLong(zzhqVar.zzg(), zzhqVar.zzd());
                    } else if (zzhqVar.zzy()) {
                        bundle2.putString(zzhqVar.zzg(), zzhqVar.zzh());
                    } else if (zzhqVar.zzi().isEmpty()) {
                        zzA.zzu.zzaW().zze().zzb("Unexpected parameter type for parameter", zzhqVar);
                    } else {
                        bundle2.putParcelableArray(zzhqVar.zzg(), zzqa.zzC(zzhqVar.zzi()));
                    }
                }
                String string = bundle2.getString("_o");
                bundle2.remove("_o");
                String zzh2 = zzhmVar.zzh();
                if (string == null) {
                    string = "";
                }
                zzhf zzhfVar = new zzhf(zzh2, string, bundle2, zzhmVar.zzd());
                zzio zzioVar2 = this.zzu;
                Bundle bundle3 = zzhfVar.zzd;
                zzioVar2.zzw().zzO(bundle3, bundle);
                zzio zzioVar3 = zzioVar;
                zzbc zzbcVar = new zzbc(this.zzu, zzhfVar.zzb, str, zzhmVar.zzh(), zzhmVar.zzd(), zzhmVar.zzc(), bundle3);
                long j = zzatVar.zza;
                long j2 = zzatVar.zzb;
                boolean z = zzatVar.zzc;
                zzg();
                zzav();
                Preconditions.checkNotNull(zzbcVar);
                String str4 = zzbcVar.zza;
                Preconditions.checkNotEmpty(str4);
                byte[] zzcd = zzpvVar.zzA().zzm(zzbcVar).zzcd();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str4);
                contentValues.put("name", zzbcVar.zzb);
                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                contentValues.put("metadata_fingerprint", Long.valueOf(j2));
                contentValues.put("data", zzcd);
                contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
                try {
                    long update = zzj().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
                    if (update != 1) {
                        zzioVar2.zzaW().zze().zzc("Failed to update raw event. appId, updatedRows", zzhe.zzn(str4), Long.valueOf(update));
                    }
                } catch (SQLiteException e5) {
                    this.zzu.zzaW().zze().zzc("Error updating raw event. appId", zzhe.zzn(zzbcVar.zza), e5);
                }
                str3 = str;
                zzioVar = zzioVar3;
                cursor2 = null;
            }
            zza2 = zzauVar.zza();
            str3 = str;
            cursor2 = null;
        }
    }

    public final void zzH() {
        zzav();
        zzj().beginTransaction();
    }

    public final void zzI(String str) {
        zzbd zzaA;
        zzaE("events_snapshot", str);
        Cursor cursor = null;
        try {
            try {
                cursor = zzj().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(0);
                        if (string != null && (zzaA = zzaA("events", str, string)) != null) {
                            zzaF("events_snapshot", zzaA);
                        }
                    } while (cursor.moveToNext());
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Error creating snapshot. appId", zzhe.zzn(str), e);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzJ(List list) {
        Preconditions.checkNotNull(list);
        zzg();
        zzav();
        StringBuilder sb = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append(StringUtils.COMMA);
            }
            sb.append(((Long) list.get(i)).longValue());
        }
        sb.append(")");
        int delete = zzj().delete("raw_events", sb.toString(), null);
        if (delete != list.size()) {
            this.zzu.zzaW().zze().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public final void zzK(Long l) {
        zzg();
        zzav();
        Preconditions.checkNotNull(l);
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM)) {
            try {
                if (zzj().delete("upload_queue", "rowid=?", new String[]{l.toString()}) != 1) {
                    zzioVar.zzaW().zzk().zza("Deleted fewer rows from upload_queue than expected");
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzb("Failed to delete a MeasurementBatch in a upload_queue table", e);
                throw e;
            }
        }
    }

    public final void zzL() {
        zzav();
        zzj().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzM(List list) {
        zzg();
        zzav();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzae()) {
            String str = "(" + TextUtils.join(StringUtils.COMMA, list) + ")";
            if (zzay("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                this.zzu.zzaW().zzk().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                zzj().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzN(Long l) {
        String str;
        zzg();
        zzav();
        Preconditions.checkNotNull(l);
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM) && zzae()) {
            if (zzay("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                zzioVar.zzaW().zzk().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase zzj2 = zzj();
                if (zzioVar.zzf().zzx(null, zzgi.zzaP)) {
                    str = " SET retry_count = retry_count + 1, last_upload_timestamp = " + zzioVar.zzaU().currentTimeMillis();
                } else {
                    str = " SET retry_count = retry_count + 1 ";
                }
                zzj2.execSQL("UPDATE upload_queue" + str + " WHERE rowid = " + l + " AND retry_count < 2147483647");
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzO() {
        zzg();
        zzav();
        if (zzae()) {
            zzpv zzpvVar = this.zzg;
            long zza2 = zzpvVar.zzw().zza.zza();
            zzio zzioVar = this.zzu;
            long elapsedRealtime = zzioVar.zzaU().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            zzioVar.zzf();
            if (abs > zzam.zzJ()) {
                zzpvVar.zzw().zza.zzb(elapsedRealtime);
                zzg();
                zzav();
                if (zzae()) {
                    SQLiteDatabase zzj2 = zzj();
                    zzioVar.zzf();
                    int delete = zzj2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzioVar.zzaU().currentTimeMillis()), String.valueOf(zzam.zzI())});
                    if (delete > 0) {
                        zzioVar.zzaW().zzj().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    public final void zzP(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        try {
            zzj().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zze().zzd("Error deleting user property. appId", zzhe.zzn(str), zzioVar.zzj().zzf(str2), e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c1, code lost:
        if (r10 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c3, code lost:
        zzaF("events", r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x005e, code lost:
        if (r10 != null) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzQ(String str) {
        boolean z;
        zzbd zzaA;
        boolean z2 = false;
        ArrayList arrayList = new ArrayList(Arrays.asList("name", "lifetime_count"));
        zzbd zzaA2 = zzaA("events", str, "_f");
        zzbd zzaA3 = zzaA("events", str, "_v");
        zzaE("events", str);
        Cursor cursor = null;
        try {
            cursor = zzj().query("events_snapshot", (String[]) arrayList.toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
        } catch (SQLiteException e) {
            e = e;
            z = false;
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        if (cursor.moveToFirst()) {
            boolean z3 = false;
            z = false;
            do {
                try {
                    String string = cursor.getString(0);
                    if (cursor.getLong(1) >= 1) {
                        if ("_f".equals(string)) {
                            z3 = true;
                        } else if ("_v".equals(string)) {
                            z = true;
                        }
                    }
                    if (string != null && (zzaA = zzaA("events_snapshot", str, string)) != null) {
                        zzaF("events", zzaA);
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    z2 = z3;
                    try {
                        this.zzu.zzaW().zze().zzc("Error querying snapshot. appId", zzhe.zzn(str), e);
                        z3 = z2;
                        if (cursor != null) {
                        }
                        if (!z3) {
                        }
                        if (!z) {
                        }
                        zzaE("events_snapshot", str);
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (z2 && zzaA2 != null) {
                            zzaF("events", zzaA2);
                        } else if (!z && zzaA3 != null) {
                            zzaF("events", zzaA3);
                        }
                        zzaE("events_snapshot", str);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z2 = z3;
                    if (cursor != null) {
                    }
                    if (z2) {
                    }
                    if (!z) {
                        zzaF("events", zzaA3);
                    }
                    zzaE("events_snapshot", str);
                    throw th;
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            if (!z3 || zzaA2 == null) {
                if (!z) {
                }
                zzaE("events_snapshot", str);
            }
            zzaF("events", zzaA2);
            zzaE("events_snapshot", str);
        }
        if (cursor != null) {
            cursor.close();
        }
        if (zzaA2 == null) {
        }
        zzaF("events", zzaA2);
        zzaE("events_snapshot", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0345, code lost:
        if (zzj().insertWithOnConflict("property_filters", null, r13, 5) != (-1)) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0347, code lost:
        r24.zzu.zzaW().zze().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzhe.zzn(r25));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x035b, code lost:
        r0 = r21;
        r3 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0361, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0362, code lost:
        r24.zzu.zzaW().zze().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r25), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0375, code lost:
        zzav();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r25);
        r0 = zzj();
        r0.delete("property_filters", "app_id=? and audience_id=?", new java.lang.String[]{r25, java.lang.String.valueOf(r11)});
        r0.delete("event_filters", "app_id=? and audience_id=?", new java.lang.String[]{r25, java.lang.String.valueOf(r11)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x039f, code lost:
        r7 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x048c, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0491, code lost:
        r22.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0494, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0174, code lost:
        r12 = r0.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0180, code lost:
        if (r12.hasNext() == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x018c, code lost:
        if (((com.google.android.gms.internal.measurement.zzfr) r12.next()).zzj() != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x018e, code lost:
        r24.zzu.zzaW().zzk().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzhe.zzn(r25), java.lang.Integer.valueOf(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01a7, code lost:
        r12 = r0.zzg().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01b3, code lost:
        r21 = r0;
        r0 = "app_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01c1, code lost:
        if (r12.hasNext() == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01c3, code lost:
        r13 = (com.google.android.gms.internal.measurement.zzfj) r12.next();
        zzav();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r25);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01dd, code lost:
        if (r13.zzg().isEmpty() == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01df, code lost:
        r0 = r24.zzu.zzaW().zzk();
        r10 = com.google.android.gms.measurement.internal.zzhe.zzn(r25);
        r12 = java.lang.Integer.valueOf(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01f7, code lost:
        if (r13.zzp() == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01f9, code lost:
        r13 = java.lang.Integer.valueOf(r13.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0202, code lost:
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0203, code lost:
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r10, r12, java.lang.String.valueOf(r13));
        r22 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x020e, code lost:
        r3 = r13.zzcd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0212, code lost:
        r22 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0214, code lost:
        r7 = new android.content.ContentValues();
        r7.put("app_id", r25);
        r7.put("audience_id", java.lang.Integer.valueOf(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0227, code lost:
        if (r13.zzp() == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0229, code lost:
        r0 = java.lang.Integer.valueOf(r13.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0232, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0233, code lost:
        r7.put("filter_id", r0);
        r7.put("event_name", r13.zzg());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0243, code lost:
        if (r13.zzq() == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0245, code lost:
        r0 = java.lang.Boolean.valueOf(r13.zzn());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x024e, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x024f, code lost:
        r7.put("session_scoped", r0);
        r7.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0261, code lost:
        if (zzj().insertWithOnConflict("event_filters", null, r7, 5) != (-1)) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0263, code lost:
        r24.zzu.zzaW().zze().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzhe.zzn(r25));
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0276, code lost:
        r0 = r21;
        r7 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x027e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x027f, code lost:
        r24.zzu.zzaW().zze().zzc("Error storing event filter. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r25), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0294, code lost:
        r22 = r7;
        r3 = r21.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02a2, code lost:
        if (r3.hasNext() == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02a4, code lost:
        r7 = (com.google.android.gms.internal.measurement.zzfr) r3.next();
        zzav();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r25);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02be, code lost:
        if (r7.zze().isEmpty() == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02c0, code lost:
        r0 = r24.zzu.zzaW().zzk();
        r9 = com.google.android.gms.measurement.internal.zzhe.zzn(r25);
        r10 = java.lang.Integer.valueOf(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02d8, code lost:
        if (r7.zzj() == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02da, code lost:
        r20 = java.lang.Integer.valueOf(r7.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02e5, code lost:
        r20 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02e7, code lost:
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r9, r10, java.lang.String.valueOf(r20));
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02f0, code lost:
        r12 = r7.zzcd();
        r13 = new android.content.ContentValues();
        r13.put(r0, r25);
        r21 = r0;
        r13.put("audience_id", java.lang.Integer.valueOf(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0309, code lost:
        if (r7.zzj() == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x030b, code lost:
        r0 = java.lang.Integer.valueOf(r7.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0314, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0315, code lost:
        r13.put("filter_id", r0);
        r23 = r3;
        r13.put("property_name", r7.zze());
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0327, code lost:
        if (r7.zzk() == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0329, code lost:
        r0 = java.lang.Boolean.valueOf(r7.zzi());
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0332, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0333, code lost:
        r13.put("session_scoped", r0);
        r13.put("data", r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzR(String str, List list) {
        SQLiteDatabase sQLiteDatabase;
        boolean z;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            com.google.android.gms.internal.measurement.zzfg zzfgVar = (com.google.android.gms.internal.measurement.zzfg) ((com.google.android.gms.internal.measurement.zzfh) list.get(i)).zzch();
            if (zzfgVar.zza() != 0) {
                for (int i2 = 0; i2 < zzfgVar.zza(); i2++) {
                    com.google.android.gms.internal.measurement.zzfi zzfiVar = (com.google.android.gms.internal.measurement.zzfi) zzfgVar.zze(i2).zzch();
                    com.google.android.gms.internal.measurement.zzfi zzfiVar2 = (com.google.android.gms.internal.measurement.zzfi) zzfiVar.zzaR();
                    String zzb2 = zzjy.zzb(zzfiVar.zze());
                    if (zzb2 != null) {
                        zzfiVar2.zzb(zzb2);
                        z = true;
                    } else {
                        z = false;
                    }
                    int i3 = 0;
                    while (i3 < zzfiVar.zza()) {
                        com.google.android.gms.internal.measurement.zzfl zzd2 = zzfiVar.zzd(i3);
                        com.google.android.gms.internal.measurement.zzfi zzfiVar3 = zzfiVar;
                        String zzb3 = zzmg.zzb(zzd2.zze(), zzjz.zza, zzjz.zzb);
                        if (zzb3 != null) {
                            com.google.android.gms.internal.measurement.zzfk zzfkVar = (com.google.android.gms.internal.measurement.zzfk) zzd2.zzch();
                            zzfkVar.zza(zzb3);
                            zzfiVar2.zzc(i3, (com.google.android.gms.internal.measurement.zzfl) zzfkVar.zzba());
                            z = true;
                        }
                        i3++;
                        zzfiVar = zzfiVar3;
                    }
                    if (z) {
                        zzfgVar.zzc(i2, zzfiVar2);
                        list.set(i, (com.google.android.gms.internal.measurement.zzfh) zzfgVar.zzba());
                    }
                }
            }
            if (zzfgVar.zzb() != 0) {
                for (int i4 = 0; i4 < zzfgVar.zzb(); i4++) {
                    com.google.android.gms.internal.measurement.zzfr zzf2 = zzfgVar.zzf(i4);
                    String zzb4 = zzmg.zzb(zzf2.zze(), zzka.zza, zzka.zzb);
                    if (zzb4 != null) {
                        com.google.android.gms.internal.measurement.zzfq zzfqVar = (com.google.android.gms.internal.measurement.zzfq) zzf2.zzch();
                        zzfqVar.zza(zzb4);
                        zzfgVar.zzd(i4, zzfqVar);
                        list.set(i, (com.google.android.gms.internal.measurement.zzfh) zzfgVar.zzba());
                    }
                }
            }
        }
        zzav();
        zzg();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase zzj2 = zzj();
        zzj2.beginTransaction();
        try {
            zzav();
            zzg();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase zzj3 = zzj();
            zzj3.delete("property_filters", "app_id=?", new String[]{str});
            zzj3.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzfh zzfhVar = (com.google.android.gms.internal.measurement.zzfh) it.next();
                zzav();
                zzg();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfhVar);
                if (!zzfhVar.zzk()) {
                    this.zzu.zzaW().zzk().zzb("Audience with no ID. appId", zzhe.zzn(str));
                } else {
                    int zza2 = zzfhVar.zza();
                    Iterator it2 = zzfhVar.zzg().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!((com.google.android.gms.internal.measurement.zzfj) it2.next()).zzp()) {
                                this.zzu.zzaW().zzk().zzc("Event filter with no ID. Audience definition ignored. appId, audienceId", zzhe.zzn(str), Integer.valueOf(zza2));
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            sQLiteDatabase = zzj2;
            ArrayList arrayList = new ArrayList();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                com.google.android.gms.internal.measurement.zzfh zzfhVar2 = (com.google.android.gms.internal.measurement.zzfh) it3.next();
                arrayList.add(zzfhVar2.zzk() ? Integer.valueOf(zzfhVar2.zza()) : null);
            }
            Preconditions.checkNotEmpty(str);
            zzav();
            zzg();
            SQLiteDatabase zzj4 = zzj();
            try {
                long zzay = zzay("select count(1) from audience_filter_values where app_id=?", new String[]{str});
                int max = Math.max(0, Math.min(2000, this.zzu.zzf().zzh(str, zzgi.zzT)));
                if (zzay > max) {
                    ArrayList arrayList2 = new ArrayList();
                    int i5 = 0;
                    while (true) {
                        if (i5 < arrayList.size()) {
                            Integer num = (Integer) arrayList.get(i5);
                            if (num == null) {
                                break;
                            }
                            arrayList2.add(Integer.toString(num.intValue()));
                            i5++;
                        } else {
                            zzj4.delete("audience_filter_values", "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in " + ("(" + TextUtils.join(StringUtils.COMMA, arrayList2) + ")") + " order by rowid desc limit -1 offset ?)", new String[]{str, Integer.toString(max)});
                            break;
                        }
                    }
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Database error querying filters. appId", zzhe.zzn(str), e);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = zzj2;
        }
    }

    public final void zzS() {
        zzav();
        zzj().setTransactionSuccessful();
    }

    public final void zzT(zzh zzhVar, boolean z, boolean z2) {
        Preconditions.checkNotNull(zzhVar);
        zzg();
        zzav();
        String zzC = zzhVar.zzC();
        Preconditions.checkNotNull(zzC);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzC);
        if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzg.zzu(zzC).zzr(zzjw.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", zzhVar.zzD());
        }
        contentValues.put("gmp_app_id", zzhVar.zzH());
        zzpv zzpvVar = this.zzg;
        if (zzpvVar.zzu(zzC).zzr(zzjw.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzhVar.zzJ());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzt()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzu()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzs()));
        contentValues.put("app_version", zzhVar.zzF());
        contentValues.put("app_store", zzhVar.zzE());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzq()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzn()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzaJ()));
        contentValues.put("day", Long.valueOf(zzhVar.zzm()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzk()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzj()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzh()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzg()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzp()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zze()));
        contentValues.put("firebase_instance_id", zzhVar.zzG());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zzi()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzl()));
        contentValues.put("health_monitor_sample", zzhVar.zzI());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzaI()));
        contentValues.put("admob_app_id", zzhVar.zzA());
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzo()));
        if (zzpvVar.zzu(zzC).zzr(zzjw.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzhVar.zzL());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.zzaL()));
        contentValues.put("target_os_version", Long.valueOf(zzhVar.zzw()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.zzv()));
        zzqr.zzb();
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(zzC, zzgi.zzaV)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzhVar.zza()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzhVar.zzf()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzhVar.zzaM()));
        contentValues.put("npa_metadata_value", zzhVar.zzx());
        contentValues.put("bundle_delivery_index", Long.valueOf(zzhVar.zzr()));
        contentValues.put("sgtm_preview_key", zzhVar.zzM());
        contentValues.put("dma_consent_state", Integer.valueOf(zzhVar.zzd()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzhVar.zzc()));
        contentValues.put("serialized_npa_metadata", zzhVar.zzK());
        if (zzioVar.zzf().zzx(zzC, zzgi.zzaP)) {
            contentValues.put("client_upload_eligibility", Integer.valueOf(zzhVar.zzb()));
        }
        List zzN = zzhVar.zzN();
        if (zzN != null) {
            if (zzN.isEmpty()) {
                zzioVar.zzaW().zzk().zzb("Safelisted events should not be an empty list. appId", zzC);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(StringUtils.COMMA, zzN));
            }
        }
        com.google.android.gms.internal.measurement.zzpn.zzb();
        if (zzioVar.zzf().zzx(null, zzgi.zzaJ) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", zzhVar.zzy());
        contentValues.put("unmatched_uwa", zzhVar.zzz());
        contentValues.put("ad_campaign_info", zzhVar.zzaN());
        try {
            SQLiteDatabase zzj2 = zzj();
            if (zzj2.update("apps", contentValues, "app_id = ?", new String[]{zzC}) == 0 && zzj2.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzioVar.zzaW().zze().zzb("Failed to insert/update app (got -1). appId", zzhe.zzn(zzC));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing app. appId", zzhe.zzn(zzC), e);
        }
    }

    public final void zzU(String str, zzba zzbaVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzbaVar);
        zzg();
        zzav();
        if (zzu(str) == zzjx.zza) {
            zzX(str, zzjx.zza);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzbaVar.zzj());
        zzaG("consent_settings", "app_id", contentValues);
    }

    public final void zzV(zzbd zzbdVar) {
        zzaF("events", zzbdVar);
    }

    public final void zzW(String str, zzjx zzjxVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjxVar);
        zzg();
        zzav();
        zzX(str, zzu(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjxVar.zzq());
        zzaG("consent_settings", "app_id", contentValues);
    }

    public final void zzX(String str, zzjx zzjxVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjxVar);
        zzg();
        zzav();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjxVar.zzq());
        contentValues.put("consent_source", Integer.valueOf(zzjxVar.zzb()));
        zzaG("consent_settings", "app_id", contentValues);
    }

    public final boolean zzY(String str) {
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM)) {
            if (zzioVar.zzf().zzx(null, zzgi.zzaP)) {
                zzmf[] zzmfVarArr = {zzmf.GOOGLE_SIGNAL};
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(Integer.valueOf(zzmfVarArr[0].zza()));
                String zzaH = zzaH(arrayList);
                String zzaC = zzaC();
                StringBuilder sb = new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
                sb.append(zzaH);
                sb.append(" AND NOT ");
                sb.append(zzaC);
                return zzay(sb.toString(), new String[]{str}) != 0;
            } else if (zzay("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT ".concat(zzaC()), new String[]{str}) != 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzZ(String str, String str2) {
        return zzay("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        try {
            return zzj().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zze().zzd("Error deleting conditional property", zzhe.zzn(str), zzioVar.zzj().zzf(str2), e);
            return 0;
        }
    }

    public final boolean zzaa() {
        return zzay("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzab() {
        return zzay("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final boolean zzac() {
        return zzay("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final boolean zzad(String str, zzov zzovVar) {
        zzg();
        zzav();
        Preconditions.checkNotNull(zzovVar);
        Preconditions.checkNotEmpty(str);
        zzio zzioVar = this.zzu;
        long currentTimeMillis = zzioVar.zzaU().currentTimeMillis();
        long j = zzovVar.zzb;
        if (j < currentTimeMillis - ((Long) zzgi.zzau.zza(null)).longValue() || j > ((Long) zzgi.zzau.zza(null)).longValue() + currentTimeMillis) {
            zzioVar.zzaW().zzk().zzd("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzhe.zzn(str), Long.valueOf(currentTimeMillis), Long.valueOf(j));
        }
        zzioVar.zzaW().zzj().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzovVar.zza);
        contentValues.put("source", Integer.valueOf(zzovVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(j));
        try {
            if (zzj().insert("trigger_uris", null, contentValues) == -1) {
                zzioVar.zzaW().zze().zzb("Failed to insert trigger URI (got -1). appId", zzhe.zzn(str));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing trigger URI. appId", zzhe.zzn(str), e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzae() {
        zzio zzioVar = this.zzu;
        Context zzaT = zzioVar.zzaT();
        zzioVar.zzf();
        return zzaT.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zzaf(String str, Long l, long j, com.google.android.gms.internal.measurement.zzhm zzhmVar) {
        zzg();
        zzav();
        Preconditions.checkNotNull(zzhmVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        zzio zzioVar = this.zzu;
        byte[] zzcd = zzhmVar.zzcd();
        zzioVar.zzaW().zzj().zzc("Saving complex main event, appId, data size", zzioVar.zzj().zzd(str), Integer.valueOf(zzcd.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzcd);
        try {
            if (zzj().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                zzioVar.zzaW().zze().zzb("Failed to insert complex main event (got -1). appId", zzhe.zzn(str));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing complex main event. appId", zzhe.zzn(str), e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzag(String str, long j) {
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzbe) || zzioVar.zzaU().currentTimeMillis() <= 15000 + j) {
            try {
                if (zzaz("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0) {
                    return false;
                }
                return zzaz("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0;
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzb("Error checking backfill conditions", e);
                return false;
            }
        }
        return false;
    }

    public final boolean zzah(zzai zzaiVar) {
        Preconditions.checkNotNull(zzaiVar);
        zzg();
        zzav();
        String str = zzaiVar.zza;
        Preconditions.checkNotNull(str);
        if (zzy(str, zzaiVar.zzc.zzb) == null) {
            long zzay = zzay("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzu.zzf();
            if (zzay >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzaiVar.zzb);
        contentValues.put("name", zzaiVar.zzc.zzb);
        zzau(contentValues, "value", Preconditions.checkNotNull(zzaiVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzaiVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzaiVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzaiVar.zzh));
        zzio zzioVar = this.zzu;
        contentValues.put("timed_out_event", zzioVar.zzw().zzay(zzaiVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzaiVar.zzd));
        contentValues.put("triggered_event", zzioVar.zzw().zzay(zzaiVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzaiVar.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzaiVar.zzj));
        contentValues.put("expired_event", zzioVar.zzw().zzay(zzaiVar.zzk));
        try {
            if (zzj().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzioVar.zzaW().zze().zzb("Failed to insert/update conditional user property (got -1)", zzhe.zzn(str));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing conditional user property", zzhe.zzn(str), e);
        }
        return true;
    }

    public final boolean zzai(zzqd zzqdVar) {
        Preconditions.checkNotNull(zzqdVar);
        zzg();
        zzav();
        String str = zzqdVar.zza;
        String str2 = zzqdVar.zzc;
        if (zzy(str, str2) == null) {
            if (zzqf.zzaq(str2)) {
                if (zzay("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= this.zzu.zzf().zzi(str, zzgi.zzU, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long zzay = zzay("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, zzqdVar.zzb});
                this.zzu.zzf();
                if (zzay >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzqdVar.zzb);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(zzqdVar.zzd));
        zzau(contentValues, "value", zzqdVar.zze);
        try {
            if (zzj().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                this.zzu.zzaW().zze().zzb("Failed to insert/update user property (got -1). appId", zzhe.zzn(str));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing user property. appId", zzhe.zzn(zzqdVar.zza), e);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x01fd A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzat(String str, long j, long j2, zzpr zzprVar) {
        String str2;
        SQLiteDatabase zzj2;
        String string;
        String str3;
        String[] strArr;
        int i;
        Preconditions.checkNotNull(zzprVar);
        zzg();
        zzav();
        Cursor cursor = null;
        try {
            try {
                zzj2 = zzj();
            } catch (SQLiteException e) {
                e = e;
                str2 = str;
            }
            if (TextUtils.isEmpty(str)) {
                int i2 = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
                cursor = zzj2.rawQuery("select app_id, metadata_fingerprint from raw_events where " + (i2 != 0 ? "rowid <= ? and " : "") + "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", i2 != 0 ? new String[]{String.valueOf(j2), String.valueOf(j)} : new String[]{String.valueOf(j)});
                if (!cursor.moveToFirst()) {
                    if (cursor == null) {
                        return;
                    }
                    return;
                }
                str2 = cursor.getString(0);
                try {
                    string = cursor.getString(1);
                    cursor.close();
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zze().zzc("Data loss. Error selecting raw event. appId", zzhe.zzn(str2), e);
                }
            } else {
                int i3 = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
                cursor = zzj2.rawQuery("select metadata_fingerprint from raw_events where app_id = ?" + (i3 != 0 ? " and rowid <= ?" : "") + " order by rowid limit 1;", i3 != 0 ? new String[]{str, String.valueOf(j2)} : new String[]{str});
                if (cursor.moveToFirst()) {
                    string = cursor.getString(0);
                    cursor.close();
                    str2 = str;
                }
            }
            int i4 = 1;
            cursor = zzj2.query("raw_events_metadata", new String[]{TtmlNode.TAG_METADATA}, "app_id = ? and metadata_fingerprint = ?", new String[]{str2, string}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
            if (!cursor.moveToFirst()) {
                this.zzu.zzaW().zze().zzb("Raw event metadata record is missing. appId", zzhe.zzn(str2));
            } else {
                try {
                    com.google.android.gms.internal.measurement.zzhx zzhxVar = (com.google.android.gms.internal.measurement.zzhx) ((com.google.android.gms.internal.measurement.zzhw) zzqa.zzp(com.google.android.gms.internal.measurement.zzhx.zzz(), cursor.getBlob(0))).zzba();
                    if (cursor.moveToNext()) {
                        this.zzu.zzaW().zzk().zzb("Get multiple raw event metadata records, expected one. appId", zzhe.zzn(str2));
                    }
                    cursor.close();
                    Preconditions.checkNotNull(zzhxVar);
                    zzprVar.zza = zzhxVar;
                    if (j2 != -1) {
                        str3 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                        strArr = new String[]{str2, string, String.valueOf(j2)};
                    } else {
                        str3 = "app_id = ? and metadata_fingerprint = ?";
                        strArr = new String[]{str2, string};
                    }
                    cursor = zzj2.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str3, strArr, null, null, "rowid", null);
                    if (cursor.moveToFirst()) {
                        while (true) {
                            long j3 = cursor.getLong(0);
                            try {
                                com.google.android.gms.internal.measurement.zzhl zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzqa.zzp(com.google.android.gms.internal.measurement.zzhm.zze(), cursor.getBlob(3));
                                i = i4;
                                zzhlVar.zzi(cursor.getString(i));
                                zzhlVar.zzm(cursor.getLong(2));
                                if (!zzprVar.zza(j3, (com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba())) {
                                    break;
                                }
                            } catch (IOException e3) {
                                i = i4;
                                this.zzu.zzaW().zze().zzc("Data loss. Failed to merge raw event. appId", zzhe.zzn(str2), e3);
                            }
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            i4 = i;
                        }
                    } else {
                        this.zzu.zzaW().zzk().zzb("Raw event data disappeared while in transaction. appId", zzhe.zzn(str2));
                    }
                } catch (IOException e4) {
                    this.zzu.zzaW().zze().zzc("Data loss. Failed to merge raw event metadata. appId", zzhe.zzn(str2), e4);
                }
            }
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzpg
    protected final boolean zzb() {
        return false;
    }

    public final long zzd(String str, com.google.android.gms.internal.measurement.zzhv zzhvVar, String str2, Map map, zzmf zzmfVar, Long l) {
        int delete;
        zzg();
        zzav();
        Preconditions.checkNotNull(zzhvVar);
        Preconditions.checkNotEmpty(str);
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM)) {
            zzg();
            zzav();
            if (zzae()) {
                zzpv zzpvVar = this.zzg;
                long zza2 = zzpvVar.zzw().zzb.zza();
                long elapsedRealtime = zzioVar.zzaU().elapsedRealtime();
                long abs = Math.abs(elapsedRealtime - zza2);
                zzioVar.zzf();
                if (abs > zzam.zzJ()) {
                    zzpvVar.zzw().zzb.zzb(elapsedRealtime);
                    zzg();
                    zzav();
                    if (zzae() && (delete = zzj().delete("upload_queue", zzaC(), new String[0])) > 0) {
                        zzioVar.zzaW().zzj().zzb("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(delete));
                    }
                    if (zzioVar.zzf().zzx(null, zzgi.zzaP)) {
                        Preconditions.checkNotEmpty(str);
                        zzg();
                        zzav();
                        try {
                            int zzh2 = zzioVar.zzf().zzh(str, zzgi.zzz);
                            if (zzh2 > 0) {
                                zzj().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(zzh2)});
                            }
                        } catch (SQLiteException e) {
                            this.zzu.zzaW().zze().zzc("Error deleting over the limit queued batches. appId", zzhe.zzn(str), e);
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
            }
            byte[] zzcd = zzhvVar.zzcd();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("measurement_batch", zzcd);
            contentValues.put("upload_uri", str2);
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                while (true) {
                    sb.append((CharSequence) it.next());
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append((CharSequence) "\r\n");
                }
            }
            contentValues.put("upload_headers", sb.toString());
            contentValues.put("upload_type", Integer.valueOf(zzmfVar.zza()));
            zzio zzioVar2 = this.zzu;
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzioVar2.zzaU().currentTimeMillis()));
            contentValues.put("retry_count", (Integer) 0);
            if (l != null) {
                contentValues.put("associated_row_id", l);
            }
            try {
                long insert = zzj().insert("upload_queue", null, contentValues);
                if (insert == -1) {
                    zzioVar2.zzaW().zze().zzb("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
                    return -1L;
                }
                return insert;
            } catch (SQLiteException e2) {
                this.zzu.zzaW().zze().zzc("Error storing MeasurementBatch to upload_queue. appId", str, e2);
            }
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(3:2|3|4)|(2:6|(3:8|9|10)(1:13))|14|15|(3:17|9|10)(4:18|19|9|10)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0099, code lost:
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009e, code lost:
        r13.zzu.zzaW().zze().zzd("Error inserting column. appId", com.google.android.gms.measurement.internal.zzhe.zzn(r14), "first_open_count", r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long zze(String str, String str2) {
        long j;
        long j2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzav();
        SQLiteDatabase zzj2 = zzj();
        zzj2.beginTransaction();
        try {
            try {
                j2 = -1;
                j = zzaz("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
            } finally {
                zzj2.endTransaction();
            }
        } catch (SQLiteException e) {
            j = 0;
            SQLiteException e2 = e;
        }
        if (j == -1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("first_open_count", (Integer) 0);
            contentValues.put("previous_install_count", (Integer) 0);
            if (zzj2.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                this.zzu.zzaW().zze().zzc("Failed to insert column (got -1). appId", zzhe.zzn(str), "first_open_count");
                return j2;
            }
            j = 0;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("app_id", str);
        contentValues2.put("first_open_count", Long.valueOf(1 + j));
        if (zzj2.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
            this.zzu.zzaW().zze().zzc("Failed to update column (got 0). appId", zzhe.zzn(str), "first_open_count");
            return j2;
        }
        zzj2.setTransactionSuccessful();
        j2 = j;
        return j2;
    }

    public final long zzf() {
        return zzaz("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final long zzh() {
        return zzaz("select max(timestamp) from raw_events", null, 0L);
    }

    public final long zzi(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaz("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SQLiteDatabase zzj() {
        zzg();
        try {
            return this.zzm.getWritableDatabase();
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzk().zzb("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0085: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x0085 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle zzk(String str) {
        Cursor cursor;
        Cursor cursor2;
        zzg();
        zzav();
        Cursor cursor3 = null;
        try {
            try {
                cursor = zzj().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (!cursor.moveToFirst()) {
                        this.zzu.zzaW().zzj().zza("Default event parameters not found");
                    } else {
                        try {
                            com.google.android.gms.internal.measurement.zzhm zzhmVar = (com.google.android.gms.internal.measurement.zzhm) ((com.google.android.gms.internal.measurement.zzhl) zzqa.zzp(com.google.android.gms.internal.measurement.zzhm.zze(), cursor.getBlob(0))).zzba();
                            this.zzg.zzA();
                            Bundle zzF = zzqa.zzF(zzhmVar.zzi());
                            if (cursor != null) {
                                cursor.close();
                            }
                            return zzF;
                        } catch (IOException e) {
                            this.zzu.zzaW().zze().zzc("Failed to retrieve default event parameters. appId", zzhe.zzn(str), e);
                        }
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zze().zzb("Error selecting default event parameters", e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0205 A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x025a A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0269 A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0285 A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0296 A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02d7 A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02f1 A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0308 A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0333 A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0348 A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x035b A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x037b A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0393 A[Catch: SQLiteException -> 0x03aa, all -> 0x03d4, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x03aa, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x025e, B:39:0x0269, B:40:0x027b, B:42:0x0285, B:43:0x028e, B:45:0x0296, B:49:0x029f, B:51:0x02d7, B:52:0x02e9, B:54:0x02f1, B:58:0x02fa, B:65:0x0313, B:69:0x033d, B:71:0x0348, B:72:0x0353, B:74:0x035b, B:75:0x0366, B:77:0x037b, B:79:0x0383, B:80:0x038a, B:82:0x0393, B:68:0x0333, B:61:0x0308, B:64:0x030f, B:36:0x025a, B:25:0x0205), top: B:107:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzh zzl(String str) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        Cursor cursor4;
        zzh zzhVar;
        SQLiteDatabase zzj2;
        String[] strArr;
        boolean z;
        boolean z2;
        zzio zzioVar;
        Boolean valueOf;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        try {
            zzj2 = zzj();
            strArr = new String[45];
            strArr[0] = "app_instance_id";
            strArr[1] = "gmp_app_id";
            strArr[2] = "resettable_device_id_hash";
            strArr[3] = "last_bundle_index";
            strArr[4] = "last_bundle_start_timestamp";
            strArr[5] = "last_bundle_end_timestamp";
            strArr[6] = "app_version";
            strArr[7] = "app_store";
            strArr[8] = "gmp_version";
            strArr[9] = "dev_cert_hash";
            cursor = null;
            zzhVar = 0;
            cursor2 = null;
            cursor2 = null;
        } catch (SQLiteException e) {
            e = e;
            cursor2 = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            strArr[10] = "measurement_enabled";
            strArr[11] = "day";
            strArr[12] = "daily_public_events_count";
            strArr[13] = "daily_events_count";
            strArr[14] = "daily_conversions_count";
            strArr[15] = "config_fetched_time";
            strArr[16] = "failed_config_fetch_time";
            strArr[17] = "app_version_int";
            strArr[18] = "firebase_instance_id";
            strArr[19] = "daily_error_events_count";
            strArr[20] = "daily_realtime_events_count";
            strArr[21] = "health_monitor_sample";
            strArr[22] = "android_id";
            strArr[23] = "adid_reporting_enabled";
            strArr[24] = "admob_app_id";
            strArr[25] = "dynamite_version";
            strArr[26] = "safelisted_events";
            strArr[27] = "ga_app_id";
            strArr[28] = "session_stitching_token";
            strArr[29] = "sgtm_upload_enabled";
            strArr[30] = "target_os_version";
            strArr[31] = "session_stitching_token_hash";
            strArr[32] = "ad_services_version";
            strArr[33] = "unmatched_first_open_without_ad_id";
            strArr[34] = "npa_metadata_value";
            strArr[35] = "attribution_eligibility_status";
            strArr[36] = "sgtm_preview_key";
            strArr[37] = "dma_consent_state";
            strArr[38] = "daily_realtime_dcu_count";
            strArr[39] = "bundle_delivery_index";
            strArr[40] = "serialized_npa_metadata";
            strArr[41] = "unmatched_pfo";
            strArr[42] = "unmatched_uwa";
            strArr[43] = "ad_campaign_info";
            strArr[44] = "client_upload_eligibility";
            cursor4 = zzj2.query("apps", strArr, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zze().zzc("Error querying app. appId", zzhe.zzn(str), e);
                    zzhVar = cursor2;
                    if (cursor4 != null) {
                    }
                    return zzhVar;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor3 = cursor4;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor4 = cursor2;
            this.zzu.zzaW().zze().zzc("Error querying app. appId", zzhe.zzn(str), e);
            zzhVar = cursor2;
            if (cursor4 != null) {
            }
            return zzhVar;
        } catch (Throwable th3) {
            th = th3;
            cursor3 = cursor;
            if (cursor3 != null) {
            }
            throw th;
        }
        if (!cursor4.moveToFirst()) {
            if (cursor4 != null) {
                cursor4.close();
            }
            return zzhVar;
        }
        zzpv zzpvVar = this.zzg;
        zzh zzhVar2 = new zzh(zzpvVar.zzt(), str);
        zzjx zzu = zzpvVar.zzu(str);
        zzjw zzjwVar = zzjw.ANALYTICS_STORAGE;
        if (zzu.zzr(zzjwVar)) {
            zzhVar2.zzV(cursor4.getString(0));
        }
        zzhVar2.zzao(cursor4.getString(1));
        if (zzpvVar.zzu(str).zzr(zzjw.AD_STORAGE)) {
            zzhVar2.zzax(cursor4.getString(2));
        }
        zzhVar2.zzat(cursor4.getLong(3));
        zzhVar2.zzau(cursor4.getLong(4));
        zzhVar2.zzas(cursor4.getLong(5));
        zzhVar2.zzX(cursor4.getString(6));
        zzhVar2.zzW(cursor4.getString(7));
        zzhVar2.zzap(cursor4.getLong(8));
        zzhVar2.zzaj(cursor4.getLong(9));
        if (!cursor4.isNull(10) && cursor4.getInt(10) == 0) {
            z = false;
            zzhVar2.zzav(z);
            zzhVar2.zzai(cursor4.getLong(11));
            zzhVar2.zzaf(cursor4.getLong(12));
            zzhVar2.zzae(cursor4.getLong(13));
            zzhVar2.zzac(cursor4.getLong(14));
            zzhVar2.zzab(cursor4.getLong(15));
            zzhVar2.zzam(cursor4.getLong(16));
            zzhVar2.zzY(!cursor4.isNull(17) ? SieveCacheKt.NodeMetaAndPreviousMask : cursor4.getInt(17));
            zzhVar2.zzan(cursor4.getString(18));
            zzhVar2.zzad(cursor4.getLong(19));
            zzhVar2.zzah(cursor4.getLong(20));
            zzhVar2.zzaq(cursor4.getString(21));
            if (!cursor4.isNull(23) && cursor4.getInt(23) == 0) {
                z2 = false;
                zzhVar2.zzU(z2);
                zzhVar2.zzS(cursor4.getString(24));
                zzhVar2.zzal(!cursor4.isNull(25) ? 0L : cursor4.getLong(25));
                if (!cursor4.isNull(26)) {
                    zzhVar2.zzay(Arrays.asList(cursor4.getString(26).split(StringUtils.COMMA, -1)));
                }
                if (zzpvVar.zzu(str).zzr(zzjwVar)) {
                    zzhVar2.zzaA(cursor4.getString(28));
                }
                zzhVar2.zzaD(cursor4.isNull(29) && cursor4.getInt(29) != 0);
                zzhVar2.zzar(cursor4.getLong(39));
                zzhVar2.zzaC(cursor4.getString(36));
                zzhVar2.zzaE(cursor4.getLong(30));
                zzhVar2.zzaB(cursor4.getLong(31));
                zzqr.zzb();
                zzioVar = this.zzu;
                if (zzioVar.zzf().zzx(str, zzgi.zzaV)) {
                    zzhVar2.zzT(cursor4.getInt(32));
                    zzhVar2.zzZ(cursor4.getLong(35));
                }
                zzhVar2.zzaF(cursor4.isNull(33) && cursor4.getInt(33) != 0);
                if (cursor4.isNull(34)) {
                    valueOf = Boolean.valueOf(cursor4.getInt(34) != 0);
                } else {
                    valueOf = null;
                }
                zzhVar2.zzaw(valueOf);
                zzhVar2.zzak(cursor4.getInt(37));
                zzhVar2.zzag(cursor4.getInt(38));
                zzhVar2.zzaz(!cursor4.isNull(40) ? "" : (String) Preconditions.checkNotNull(cursor4.getString(40)));
                if (!cursor4.isNull(41)) {
                    zzhVar2.zzaG(Long.valueOf(cursor4.getLong(41)));
                }
                if (!cursor4.isNull(42)) {
                    zzhVar2.zzaH(Long.valueOf(cursor4.getLong(42)));
                }
                zzhVar2.zzR(cursor4.getBlob(43));
                if (zzioVar.zzf().zzx(str, zzgi.zzaP) && !cursor4.isNull(44)) {
                    zzhVar2.zzaa(cursor4.getInt(44));
                }
                zzhVar2.zzO();
                if (cursor4.moveToNext()) {
                    zzioVar.zzaW().zze().zzb("Got multiple records for app, expected one. appId", zzhe.zzn(str));
                }
                if (cursor4 != null) {
                    cursor4.close();
                }
                return zzhVar2;
            }
            z2 = true;
            zzhVar2.zzU(z2);
            zzhVar2.zzS(cursor4.getString(24));
            zzhVar2.zzal(!cursor4.isNull(25) ? 0L : cursor4.getLong(25));
            if (!cursor4.isNull(26)) {
            }
            if (zzpvVar.zzu(str).zzr(zzjwVar)) {
            }
            zzhVar2.zzaD(cursor4.isNull(29) && cursor4.getInt(29) != 0);
            zzhVar2.zzar(cursor4.getLong(39));
            zzhVar2.zzaC(cursor4.getString(36));
            zzhVar2.zzaE(cursor4.getLong(30));
            zzhVar2.zzaB(cursor4.getLong(31));
            zzqr.zzb();
            zzioVar = this.zzu;
            if (zzioVar.zzf().zzx(str, zzgi.zzaV)) {
            }
            zzhVar2.zzaF(cursor4.isNull(33) && cursor4.getInt(33) != 0);
            if (cursor4.isNull(34)) {
            }
            zzhVar2.zzaw(valueOf);
            zzhVar2.zzak(cursor4.getInt(37));
            zzhVar2.zzag(cursor4.getInt(38));
            zzhVar2.zzaz(!cursor4.isNull(40) ? "" : (String) Preconditions.checkNotNull(cursor4.getString(40)));
            if (!cursor4.isNull(41)) {
            }
            if (!cursor4.isNull(42)) {
            }
            zzhVar2.zzR(cursor4.getBlob(43));
            if (zzioVar.zzf().zzx(str, zzgi.zzaP)) {
                zzhVar2.zzaa(cursor4.getInt(44));
            }
            zzhVar2.zzO();
            if (cursor4.moveToNext()) {
            }
            if (cursor4 != null) {
            }
            return zzhVar2;
        }
        z = true;
        zzhVar2.zzav(z);
        zzhVar2.zzai(cursor4.getLong(11));
        zzhVar2.zzaf(cursor4.getLong(12));
        zzhVar2.zzae(cursor4.getLong(13));
        zzhVar2.zzac(cursor4.getLong(14));
        zzhVar2.zzab(cursor4.getLong(15));
        zzhVar2.zzam(cursor4.getLong(16));
        zzhVar2.zzY(!cursor4.isNull(17) ? SieveCacheKt.NodeMetaAndPreviousMask : cursor4.getInt(17));
        zzhVar2.zzan(cursor4.getString(18));
        zzhVar2.zzad(cursor4.getLong(19));
        zzhVar2.zzah(cursor4.getLong(20));
        zzhVar2.zzaq(cursor4.getString(21));
        if (!cursor4.isNull(23)) {
            z2 = false;
            zzhVar2.zzU(z2);
            zzhVar2.zzS(cursor4.getString(24));
            zzhVar2.zzal(!cursor4.isNull(25) ? 0L : cursor4.getLong(25));
            if (!cursor4.isNull(26)) {
            }
            if (zzpvVar.zzu(str).zzr(zzjwVar)) {
            }
            zzhVar2.zzaD(cursor4.isNull(29) && cursor4.getInt(29) != 0);
            zzhVar2.zzar(cursor4.getLong(39));
            zzhVar2.zzaC(cursor4.getString(36));
            zzhVar2.zzaE(cursor4.getLong(30));
            zzhVar2.zzaB(cursor4.getLong(31));
            zzqr.zzb();
            zzioVar = this.zzu;
            if (zzioVar.zzf().zzx(str, zzgi.zzaV)) {
            }
            zzhVar2.zzaF(cursor4.isNull(33) && cursor4.getInt(33) != 0);
            if (cursor4.isNull(34)) {
            }
            zzhVar2.zzaw(valueOf);
            zzhVar2.zzak(cursor4.getInt(37));
            zzhVar2.zzag(cursor4.getInt(38));
            zzhVar2.zzaz(!cursor4.isNull(40) ? "" : (String) Preconditions.checkNotNull(cursor4.getString(40)));
            if (!cursor4.isNull(41)) {
            }
            if (!cursor4.isNull(42)) {
            }
            zzhVar2.zzR(cursor4.getBlob(43));
            if (zzioVar.zzf().zzx(str, zzgi.zzaP)) {
            }
            zzhVar2.zzO();
            if (cursor4.moveToNext()) {
            }
            if (cursor4 != null) {
            }
            return zzhVar2;
        }
        z2 = true;
        zzhVar2.zzU(z2);
        zzhVar2.zzS(cursor4.getString(24));
        zzhVar2.zzal(!cursor4.isNull(25) ? 0L : cursor4.getLong(25));
        if (!cursor4.isNull(26)) {
        }
        if (zzpvVar.zzu(str).zzr(zzjwVar)) {
        }
        zzhVar2.zzaD(cursor4.isNull(29) && cursor4.getInt(29) != 0);
        zzhVar2.zzar(cursor4.getLong(39));
        zzhVar2.zzaC(cursor4.getString(36));
        zzhVar2.zzaE(cursor4.getLong(30));
        zzhVar2.zzaB(cursor4.getLong(31));
        zzqr.zzb();
        zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(str, zzgi.zzaV)) {
        }
        zzhVar2.zzaF(cursor4.isNull(33) && cursor4.getInt(33) != 0);
        if (cursor4.isNull(34)) {
        }
        zzhVar2.zzaw(valueOf);
        zzhVar2.zzak(cursor4.getInt(37));
        zzhVar2.zzag(cursor4.getInt(38));
        zzhVar2.zzaz(!cursor4.isNull(40) ? "" : (String) Preconditions.checkNotNull(cursor4.getString(40)));
        if (!cursor4.isNull(41)) {
        }
        if (!cursor4.isNull(42)) {
        }
        zzhVar2.zzR(cursor4.getBlob(43));
        if (zzioVar.zzf().zzx(str, zzgi.zzaP)) {
        }
        zzhVar2.zzO();
        if (cursor4.moveToNext()) {
        }
        if (cursor4 != null) {
        }
        return zzhVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0157: MOVE  (r8 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:43:0x0157 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzai zzm(String str, String str2) {
        Cursor cursor;
        String str3;
        Cursor cursor2;
        Cursor cursor3;
        Cursor cursor4;
        Cursor cursor5;
        zzai zzaiVar;
        SQLiteDatabase zzj2;
        String[] strArr;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        try {
            try {
                zzj2 = zzj();
                strArr = new String[11];
                strArr[0] = "origin";
                strArr[1] = "value";
                strArr[2] = AppMeasurementSdk.ConditionalUserProperty.ACTIVE;
                strArr[3] = AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME;
                strArr[4] = AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT;
                strArr[5] = "timed_out_event";
                strArr[6] = AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP;
                strArr[7] = "triggered_event";
                strArr[8] = AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP;
                strArr[9] = AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE;
                cursor = null;
                zzaiVar = 0;
                cursor2 = null;
                cursor2 = null;
                cursor2 = null;
            } catch (Throwable th) {
                th = th;
                cursor4 = cursor3;
                if (cursor4 != null) {
                    cursor4.close();
                }
                throw th;
            }
            try {
                strArr[10] = "expired_event";
                cursor5 = zzj2.query("conditional_properties", strArr, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                } catch (SQLiteException e) {
                    e = e;
                    str3 = str2;
                }
            } catch (SQLiteException e2) {
                e = e2;
                str3 = str2;
                cursor5 = cursor2;
                zzio zzioVar = this.zzu;
                zzioVar.zzaW().zze().zzd("Error querying conditional property", zzhe.zzn(str), zzioVar.zzj().zzf(str3), e);
                zzaiVar = cursor2;
                if (cursor5 != null) {
                }
                return zzaiVar;
            } catch (Throwable th2) {
                th = th2;
                cursor4 = cursor;
                if (cursor4 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            str3 = str2;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (!cursor5.moveToFirst()) {
            if (cursor5 != null) {
                cursor5.close();
            }
            return zzaiVar;
        }
        String string = cursor5.getString(0);
        if (string == null) {
            string = "";
        }
        Object zzz = zzz(cursor5, 1);
        boolean z = cursor5.getInt(2) != 0;
        String string2 = cursor5.getString(3);
        long j = cursor5.getLong(4);
        zzpv zzpvVar = this.zzg;
        str3 = str2;
        String str4 = string;
        try {
            zzai zzaiVar2 = new zzai(str, str4, new zzqb(str3, cursor5.getLong(8), zzz, str4), cursor5.getLong(6), z, string2, (zzbh) zzpvVar.zzA().zzi(cursor5.getBlob(5), zzbh.CREATOR), j, (zzbh) zzpvVar.zzA().zzi(cursor5.getBlob(7), zzbh.CREATOR), cursor5.getLong(9), (zzbh) zzpvVar.zzA().zzi(cursor5.getBlob(10), zzbh.CREATOR));
            if (cursor5.moveToNext()) {
                zzio zzioVar2 = this.zzu;
                zzioVar2.zzaW().zze().zzc("Got multiple records for conditional property, expected one", zzhe.zzn(str), zzioVar2.zzj().zzf(str3));
            }
            if (cursor5 != null) {
                cursor5.close();
            }
            return zzaiVar2;
        } catch (SQLiteException e4) {
            e = e4;
            zzio zzioVar3 = this.zzu;
            zzioVar3.zzaW().zze().zzd("Error querying conditional property", zzhe.zzn(str), zzioVar3.zzj().zzf(str3), e);
            zzaiVar = cursor2;
            if (cursor5 != null) {
            }
            return zzaiVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzar zzn(String str) {
        Throwable th;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        Cursor cursor2 = null;
        try {
            cursor = zzj().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (cursor.moveToFirst()) {
                        byte[] blob = cursor.getBlob(0);
                        String string = cursor.getString(1);
                        String string2 = cursor.getString(2);
                        if (cursor.moveToNext()) {
                            this.zzu.zzaW().zze().zzb("Got multiple records for app config, expected one. appId", zzhe.zzn(str));
                        }
                        if (blob != null) {
                            zzar zzarVar = new zzar(blob, string, string2);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return zzarVar;
                        }
                    }
                } catch (SQLiteException e) {
                    e = e;
                    this.zzu.zzaW().zze().zzc("Error querying remote config. appId", zzhe.zzn(str), e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public final zzas zzo(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return zzp(j, str, 1L, false, false, z3, false, z5, z6, z7);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzas zzp(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Cursor cursor;
        Cursor cursor2;
        String[] strArr;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        String[] strArr2 = {str};
        zzas zzasVar = new zzas();
        try {
            try {
                SQLiteDatabase zzj2 = zzj();
                cursor2 = zzj2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursor2.moveToFirst()) {
                        this.zzu.zzaW().zzk().zzb("Not updating daily counts, app is not known. appId", zzhe.zzn(str));
                    } else {
                        if (cursor2.getLong(0) == j) {
                            strArr = strArr2;
                            zzasVar.zzb = cursor2.getLong(1);
                            zzasVar.zza = cursor2.getLong(2);
                            zzasVar.zzc = cursor2.getLong(3);
                            zzasVar.zzd = cursor2.getLong(4);
                            zzasVar.zze = cursor2.getLong(5);
                            zzasVar.zzf = cursor2.getLong(6);
                            zzasVar.zzg = cursor2.getLong(7);
                        } else {
                            strArr = strArr2;
                        }
                        if (z) {
                            zzasVar.zzb += j2;
                        }
                        if (z2) {
                            zzasVar.zza += j2;
                        }
                        if (z3) {
                            zzasVar.zzc += j2;
                        }
                        if (z4) {
                            zzasVar.zzd += j2;
                        }
                        if (z5) {
                            zzasVar.zze += j2;
                        }
                        if (z6) {
                            zzasVar.zzf += j2;
                        }
                        if (z7) {
                            zzasVar.zzg += j2;
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("day", Long.valueOf(j));
                        contentValues.put("daily_public_events_count", Long.valueOf(zzasVar.zza));
                        contentValues.put("daily_events_count", Long.valueOf(zzasVar.zzb));
                        contentValues.put("daily_conversions_count", Long.valueOf(zzasVar.zzc));
                        contentValues.put("daily_error_events_count", Long.valueOf(zzasVar.zzd));
                        contentValues.put("daily_realtime_events_count", Long.valueOf(zzasVar.zze));
                        contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzasVar.zzf));
                        contentValues.put("daily_registered_triggers_count", Long.valueOf(zzasVar.zzg));
                        zzj2.update("apps", contentValues, "app_id=?", strArr);
                    }
                } catch (SQLiteException e) {
                    e = e;
                    this.zzu.zzaW().zze().zzc("Error updating daily counts. appId", zzhe.zzn(str), e);
                    if (cursor2 != null) {
                    }
                    return zzasVar;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (0 != 0) {
            }
            throw th;
        }
        if (cursor2 != null) {
            cursor2.close();
        }
        return zzasVar;
    }

    public final zzba zzq(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzav();
        return zzba.zze(zzaD("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbd zzr(String str, com.google.android.gms.internal.measurement.zzhm zzhmVar, String str2) {
        zzbd zzaA = zzaA("events", str, zzhmVar.zzh());
        if (zzaA == null) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzhe.zzn(str), zzioVar.zzj().zzd(str2));
            return new zzbd(str, zzhmVar.zzh(), 1L, 1L, 1L, zzhmVar.zzd(), 0L, null, null, null, null);
        }
        long j = zzaA.zze + 1;
        long j2 = zzaA.zzd + 1;
        return new zzbd(zzaA.zza, zzaA.zzb, zzaA.zzc + 1, j2, j, zzaA.zzf, zzaA.zzg, zzaA.zzh, zzaA.zzi, zzaA.zzj, zzaA.zzk);
    }

    public final zzbd zzs(String str, String str2) {
        return zzaA("events", str, str2);
    }

    public final zzjx zzt(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzav();
        return zzjx.zzk(zzaD("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""), 100);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003e, code lost:
        if (r6 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
        if (r6 == null) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzjx zzu(String str) {
        Throwable th;
        SQLiteException e;
        Cursor cursor;
        Preconditions.checkNotNull(str);
        zzg();
        zzav();
        Cursor cursor2 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        zzjx zzjxVar = null;
        try {
            try {
                cursor = zzj().rawQuery("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str});
                try {
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zze().zzb("Error querying database.", e);
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;";
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursor.moveToFirst()) {
            zzjxVar = zzjx.zzk(cursor.getString(0), cursor.getInt(1));
        } else {
            this.zzu.zzaW().zzj().zza("No data found");
            if (cursor != null) {
                cursor.close();
            }
            return zzjxVar == null ? zzjx.zza : zzjxVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzpz zzw(String str) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        Cursor cursor4;
        Cursor cursor5;
        zzpz zzpzVar;
        SQLiteDatabase zzj2;
        String[] strArr;
        Cursor cursor6;
        Cursor cursor7;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM)) {
            if (!zzioVar.zzf().zzx(null, zzgi.zzaP)) {
                try {
                    zzj2 = zzj();
                    strArr = new String[10];
                    strArr[0] = "rowId";
                    strArr[1] = "app_id";
                    strArr[2] = "measurement_batch";
                    strArr[3] = "upload_uri";
                    strArr[4] = "upload_headers";
                    strArr[5] = "upload_type";
                    strArr[6] = "retry_count";
                    strArr[7] = AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP;
                } catch (SQLiteException e) {
                    e = e;
                    cursor2 = null;
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                }
                try {
                    strArr[8] = "associated_row_id";
                    strArr[9] = "last_upload_timestamp";
                    cursor5 = zzj2.query("upload_queue", strArr, "app_id=? AND NOT " + zzaC(), new String[]{str}, null, null, "creation_timestamp ASC", "1");
                    try {
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor6 = cursor5;
                        cursor7 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor6 = cursor5;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    cursor2 = null;
                    cursor3 = cursor2;
                    cursor4 = cursor2;
                    try {
                        this.zzu.zzaW().zze().zzc("Error to querying MeasurementBatch from upload_queue. appId", str, e);
                        cursor5 = cursor3;
                        zzpzVar = cursor4;
                        if (cursor5 != null) {
                        }
                        return zzpzVar;
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor = null;
                    cursor3 = cursor;
                    if (cursor3 != null) {
                    }
                    throw th;
                }
                if (!cursor5.moveToFirst()) {
                    zzpzVar = 0;
                    if (cursor5 != null) {
                        cursor5.close();
                    }
                    return zzpzVar;
                }
                cursor6 = cursor5;
                cursor7 = null;
                try {
                    zzpz zzaB = zzaB(str, cursor5.getLong(0), cursor5.getBlob(2), cursor5.getString(3), cursor5.getString(4), cursor5.getInt(5), cursor5.getInt(6), cursor5.getLong(7), cursor5.getLong(8), cursor5.getLong(9));
                    if (cursor6 != null) {
                        cursor6.close();
                    }
                    return zzaB;
                } catch (SQLiteException e4) {
                    e = e4;
                    cursor3 = cursor6;
                    cursor4 = cursor7;
                    this.zzu.zzaW().zze().zzc("Error to querying MeasurementBatch from upload_queue. appId", str, e);
                    cursor5 = cursor3;
                    zzpzVar = cursor4;
                    if (cursor5 != null) {
                    }
                    return zzpzVar;
                } catch (Throwable th5) {
                    th = th5;
                    cursor3 = cursor6;
                    if (cursor3 != null) {
                    }
                    throw th;
                }
            }
            List zzD = zzD(str, zzpc.zza(zzmf.GOOGLE_SIGNAL), 1);
            if (zzD.isEmpty()) {
                return null;
            }
            return (zzpz) zzD.get(0);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzpz zzx(long j) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        Cursor cursor4;
        Cursor cursor5;
        zzpz zzpzVar;
        Cursor cursor6;
        Cursor cursor7;
        if (this.zzu.zzf().zzx(null, zzgi.zzaP)) {
            zzg();
            zzav();
            try {
                try {
                    cursor5 = zzj().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"}, "rowId=?", new String[]{String.valueOf(j)}, null, null, null, "1");
                    try {
                    } catch (SQLiteException e) {
                        e = e;
                        cursor6 = cursor5;
                        cursor7 = null;
                    } catch (Throwable th) {
                        th = th;
                        cursor6 = cursor5;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    cursor2 = null;
                    cursor3 = cursor2;
                    cursor4 = cursor2;
                    try {
                        this.zzu.zzaW().zze().zzc("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j), e);
                        cursor5 = cursor3;
                        zzpzVar = cursor4;
                        if (cursor5 != null) {
                        }
                        return zzpzVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                    cursor3 = cursor;
                    if (cursor3 != null) {
                    }
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor2 = null;
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
            }
            if (!cursor5.moveToFirst()) {
                zzpzVar = 0;
                if (cursor5 != null) {
                    cursor5.close();
                }
                return zzpzVar;
            }
            cursor6 = cursor5;
            cursor7 = null;
            try {
                zzpz zzaB = zzaB((String) Preconditions.checkNotNull(cursor5.getString(1)), j, cursor5.getBlob(2), cursor5.getString(3), cursor5.getString(4), cursor5.getInt(5), cursor5.getInt(6), cursor5.getLong(7), cursor5.getLong(8), cursor5.getLong(9));
                if (cursor6 != null) {
                    cursor6.close();
                }
                return zzaB;
            } catch (SQLiteException e4) {
                e = e4;
                cursor3 = cursor6;
                cursor4 = cursor7;
                this.zzu.zzaW().zze().zzc("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j), e);
                cursor5 = cursor3;
                zzpzVar = cursor4;
                if (cursor5 != null) {
                }
                return zzpzVar;
            } catch (Throwable th5) {
                th = th5;
                cursor3 = cursor6;
                if (cursor3 != null) {
                }
                throw th;
            }
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00a3: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:32:0x00a2 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzqd zzy(String str, String str2) {
        Throwable th;
        String str3;
        String str4;
        SQLiteException sQLiteException;
        Cursor cursor;
        Cursor cursor2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        Cursor cursor3 = null;
        try {
            try {
                cursor = zzj().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (cursor.moveToFirst()) {
                        long j = cursor.getLong(0);
                        Object zzz = zzz(cursor, 1);
                        if (zzz != null) {
                            str3 = str;
                            str4 = str2;
                            try {
                                zzqd zzqdVar = new zzqd(str3, cursor.getString(2), str4, j, zzz);
                                if (cursor.moveToNext()) {
                                    this.zzu.zzaW().zze().zzb("Got multiple records for user property, expected one. appId", zzhe.zzn(str3));
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return zzqdVar;
                            } catch (SQLiteException e) {
                                e = e;
                                sQLiteException = e;
                                zzio zzioVar = this.zzu;
                                zzioVar.zzaW().zze().zzd("Error querying user property. appId", zzhe.zzn(str3), zzioVar.zzj().zzf(str4), sQLiteException);
                                if (cursor != null) {
                                }
                                return null;
                            }
                        }
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    str3 = str;
                    str4 = str2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            str3 = str;
            str4 = str2;
            sQLiteException = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor3 != null) {
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    final Object zzz(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            this.zzu.zzaW().zze().zza("Loaded invalid null value from database");
            return null;
        } else if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        this.zzu.zzaW().zze().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                        return null;
                    }
                    this.zzu.zzaW().zze().zza("Loaded invalid blob type value, ignoring it");
                    return null;
                }
                return cursor.getString(i);
            }
            return Double.valueOf(cursor.getDouble(i));
        } else {
            return Long.valueOf(cursor.getLong(i));
        }
    }
}
