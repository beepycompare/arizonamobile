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
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.messaging.Constants;
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
import kotlin.UByte$$ExternalSyntheticBackport0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzav extends zzor {
    private final zzau zzm;
    private final zzof zzn;
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    static final String[] zza = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzj = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzk = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzl = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(zzpf zzpfVar) {
        super(zzpfVar);
        this.zzn = new zzof(this.zzu.zzaZ());
        this.zzu.zzc();
        this.zzm = new zzau(this, this.zzu.zzaY(), "google_app_measurement.db");
    }

    private final long zzaA(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = zze().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zzaB(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = zze().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    j = cursor.getLong(0);
                }
                return j;
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final String zzaC(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            try {
                cursor = zze().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getString(0);
                }
                if (cursor != null) {
                    cursor.close();
                    return "";
                }
                return "";
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final void zzaD(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase zze2 = zze();
            String asString = contentValues.getAsString("app_id");
            if (asString != null) {
                StringBuilder sb = new StringBuilder(10);
                sb.append("app_id = ?");
                if (zze2.update("consent_settings", contentValues, sb.toString(), new String[]{asString}) == 0 && zze2.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                    this.zzu.zzaV().zzb().zzc("Failed to insert/update table (got -1). key", zzgt.zzl("consent_settings"), zzgt.zzl("app_id"));
                    return;
                }
                return;
            }
            this.zzu.zzaV().zzd().zzb("Value of the primary key is not set.", zzgt.zzl("app_id"));
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzd("Error storing into table. key", zzgt.zzl("consent_settings"), zzgt.zzl("app_id"), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzbc zzaE(String str, String str2, String str3) {
        String str4;
        Cursor cursor;
        Cursor cursor2;
        Boolean bool;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        zzg();
        zzay();
        Cursor cursor3 = null;
        try {
            cursor = zze().query(str, (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str2, str3}, null, null, null);
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
                zzbc zzbcVar = new zzbc(str2, str4, j, j2, cursor.isNull(8) ? 0L : cursor.getLong(8), j3, j4, valueOf, l, valueOf3, bool);
                if (cursor2.moveToNext()) {
                    this.zzu.zzaV().zzb().zzb("Got multiple records for event aggregates, expected one. appId", zzgt.zzl(str2));
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                return zzbcVar;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = cursor2;
                try {
                    zzib zzibVar = this.zzu;
                    zzibVar.zzaV().zzb().zzd("Error querying events. appId", zzgt.zzl(str2), zzibVar.zzl().zza(str4), e);
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

    private final void zzaF(String str, zzbc zzbcVar) {
        Preconditions.checkNotNull(zzbcVar);
        zzg();
        zzay();
        ContentValues contentValues = new ContentValues();
        String str2 = zzbcVar.zza;
        contentValues.put("app_id", str2);
        contentValues.put("name", zzbcVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbcVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbcVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbcVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbcVar.zzg));
        contentValues.put("last_bundled_day", zzbcVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbcVar.zzi);
        contentValues.put("last_sampling_rate", zzbcVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbcVar.zze));
        Boolean bool = zzbcVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (zze().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                this.zzu.zzaV().zzb().zzb("Failed to insert/update event aggregates (got -1). appId", zzgt.zzl(str2));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing event aggregates. appId", zzgt.zzl(zzbcVar.zza), e);
        }
    }

    private final void zzaG(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            zze().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error deleting snapshot. appId", zzgt.zzl(str2), e);
        }
    }

    private final zzpi zzaH(String str, long j, byte[] bArr, String str2, String str3, int i, int i2, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str2)) {
            this.zzu.zzaV().zzj().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzpj.zzw(com.google.android.gms.internal.measurement.zzib.zzh(), bArr);
            zzlr zzb2 = zzlr.zzb(i);
            if (zzb2 != zzlr.GOOGLE_SIGNAL && zzb2 != zzlr.GOOGLE_SIGNAL_PENDING && i2 > 0) {
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzid zzidVar : zzhzVar.zza()) {
                    com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) zzidVar.zzcl();
                    zzicVar.zzao(i2);
                    arrayList.add((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc());
                }
                zzhzVar.zzg();
                zzhzVar.zzf(arrayList);
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
                        this.zzu.zzaV().zzb().zzb("Invalid upload header: ", str4);
                        break;
                    }
                }
            }
            zzph zzphVar = new zzph();
            zzphVar.zzb(j);
            zzphVar.zzc((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc());
            zzphVar.zzd(str2);
            zzphVar.zze(hashMap);
            zzphVar.zzf(zzb2);
            zzphVar.zzg(j2);
            zzphVar.zzh(j3);
            zzphVar.zzi(j4);
            zzphVar.zzj(i2);
            return zzphVar.zza();
        } catch (IOException e) {
            this.zzu.zzaV().zzb().zzc("Failed to queued MeasurementBatch from upload_queue. appId", str, e);
            return null;
        }
    }

    private final String zzaI() {
        zzib zzibVar = this.zzu;
        long currentTimeMillis = zzibVar.zzaZ().currentTimeMillis();
        Locale locale = Locale.US;
        zzlr zzlrVar = zzlr.GOOGLE_SIGNAL;
        Integer valueOf = Integer.valueOf(zzlrVar.zza());
        Long valueOf2 = Long.valueOf(currentTimeMillis);
        zzibVar.zzc();
        String format = String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", valueOf, valueOf2, Long.valueOf(((Long) zzfx.zzS.zzb(null)).longValue()));
        Locale locale2 = Locale.US;
        Integer valueOf3 = Integer.valueOf(zzlrVar.zza());
        zzibVar.zzc();
        String format2 = String.format(locale2, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", valueOf3, valueOf2, Long.valueOf(zzal.zzI()));
        StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 5 + String.valueOf(format2).length() + 1);
        sb.append("(");
        sb.append(format);
        sb.append(" OR ");
        sb.append(format2);
        sb.append(")");
        return sb.toString();
    }

    private static final String zzaJ(List list) {
        return list.isEmpty() ? "" : String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    static final void zzaw(ContentValues contentValues, String str, Object obj) {
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

    public final long zzA(String str, com.google.android.gms.internal.measurement.zzib zzibVar, String str2, Map map, zzlr zzlrVar, Long l) {
        int delete;
        zzg();
        zzay();
        Preconditions.checkNotNull(zzibVar);
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        if (zzai()) {
            zzpf zzpfVar = this.zzg;
            long zza2 = zzpfVar.zzq().zzb.zza();
            zzib zzibVar2 = this.zzu;
            long elapsedRealtime = zzibVar2.zzaZ().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            zzibVar2.zzc();
            if (abs > zzal.zzJ()) {
                zzpfVar.zzq().zzb.zzb(elapsedRealtime);
                zzg();
                zzay();
                if (zzai() && (delete = zze().delete("upload_queue", zzaI(), new String[0])) > 0) {
                    zzibVar2.zzaV().zzk().zzb("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(delete));
                }
                Preconditions.checkNotEmpty(str);
                zzg();
                zzay();
                try {
                    int zzm = zzibVar2.zzc().zzm(str, zzfx.zzz);
                    if (zzm > 0) {
                        zze().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(zzm)});
                    }
                } catch (SQLiteException e) {
                    this.zzu.zzaV().zzb().zzc("Error deleting over the limit queued batches. appId", zzgt.zzl(str), e);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
            sb.append(str3);
            sb.append("=");
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] zzcc = zzibVar.zzcc();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", zzcc);
        contentValues.put("upload_uri", str2);
        contentValues.put("upload_headers", UByte$$ExternalSyntheticBackport0.m((CharSequence) "\r\n", (Iterable) arrayList));
        contentValues.put("upload_type", Integer.valueOf(zzlrVar.zza()));
        zzib zzibVar3 = this.zzu;
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzibVar3.zzaZ().currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l != null) {
            contentValues.put("associated_row_id", l);
        }
        try {
            long insert = zze().insert("upload_queue", null, contentValues);
            if (insert == -1) {
                zzibVar3.zzaV().zzb().zzb("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
                return -1L;
            }
            return insert;
        } catch (SQLiteException e2) {
            this.zzu.zzaV().zzb().zzc("Error storing MeasurementBatch to upload_queue. appId", str, e2);
            return -1L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzpi zzB(long j) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        zzpi zzpiVar;
        zzg();
        zzay();
        try {
            cursor = null;
            zzpiVar = 0;
            cursor2 = null;
            cursor2 = null;
            try {
                cursor3 = zze().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"}, "rowId=?", new String[]{String.valueOf(j)}, null, null, null, "1");
            } catch (SQLiteException e) {
                e = e;
                cursor3 = cursor2;
                try {
                    this.zzu.zzaV().zzb().zzc("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j), e);
                    zzpiVar = cursor2;
                    if (cursor3 != null) {
                    }
                    return zzpiVar;
                } catch (Throwable th) {
                    th = th;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor3 = cursor;
                if (cursor3 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        try {
        } catch (SQLiteException e3) {
            e = e3;
            this.zzu.zzaV().zzb().zzc("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j), e);
            zzpiVar = cursor2;
            if (cursor3 != null) {
            }
            return zzpiVar;
        } catch (Throwable th4) {
            th = th4;
            if (cursor3 != null) {
            }
            throw th;
        }
        if (!cursor3.moveToFirst()) {
            if (cursor3 != null) {
                cursor3.close();
            }
            return zzpiVar;
        }
        zzpi zzaH = zzaH((String) Preconditions.checkNotNull(cursor3.getString(1)), j, cursor3.getBlob(2), cursor3.getString(3), cursor3.getString(4), cursor3.getInt(5), cursor3.getInt(6), cursor3.getLong(7), cursor3.getLong(8), cursor3.getLong(9));
        if (cursor3 != null) {
            cursor3.close();
        }
        return zzaH;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzC(String str, zzon zzonVar, int i) {
        Cursor cursor;
        String str2;
        Cursor cursor2;
        List list;
        Cursor cursor3;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        try {
            SQLiteDatabase zze2 = zze();
            int i2 = 0;
            int i3 = 2;
            int i4 = 3;
            String[] strArr = {"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"};
            String zzaJ = zzaJ(zzonVar.zza);
            String zzaI = zzaI();
            StringBuilder sb = new StringBuilder(String.valueOf(zzaJ).length() + 17 + zzaI.length());
            sb.append("app_id=?");
            sb.append(zzaJ);
            sb.append(" AND NOT ");
            sb.append(zzaI);
            int i5 = 7;
            int i6 = 8;
            int i7 = 6;
            int i8 = 5;
            cursor3 = zze2.query("upload_queue", strArr, sb.toString(), new String[]{str}, null, null, "creation_timestamp ASC", i > 0 ? String.valueOf(i) : null);
            try {
                list = new ArrayList();
                while (cursor3.moveToNext()) {
                    long j = cursor3.getLong(i2);
                    byte[] blob = cursor3.getBlob(i3);
                    String string = cursor3.getString(i4);
                    String string2 = cursor3.getString(4);
                    int i9 = cursor3.getInt(i8);
                    int i10 = cursor3.getInt(i7);
                    long j2 = cursor3.getLong(i5);
                    int i11 = i2;
                    int i12 = i3;
                    long j3 = cursor3.getLong(i6);
                    int i13 = i4;
                    int i14 = i8;
                    int i15 = i5;
                    cursor2 = cursor3;
                    int i16 = i7;
                    str2 = str;
                    List list2 = list;
                    try {
                        zzpi zzaH = zzaH(str2, j, blob, string, string2, i9, i10, j2, j3, cursor3.getLong(9));
                        if (zzaH != null) {
                            list2.add(zzaH);
                        }
                        list = list2;
                        cursor3 = cursor2;
                        i5 = i15;
                        i7 = i16;
                        i8 = i14;
                        i4 = i13;
                        i3 = i12;
                        i2 = i11;
                        i6 = 8;
                    } catch (SQLiteException e) {
                        e = e;
                        try {
                            this.zzu.zzaV().zzb().zzc("Error to querying MeasurementBatch from upload_queue. appId", str2, e);
                            list = Collections.emptyList();
                            cursor3 = cursor2;
                            if (cursor3 != null) {
                            }
                            return list;
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursor2;
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
                }
            } catch (SQLiteException e2) {
                e = e2;
                str2 = str;
                cursor2 = cursor3;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor3;
            }
        } catch (SQLiteException e3) {
            e = e3;
            str2 = str;
            cursor2 = null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        if (cursor3 != null) {
            cursor3.close();
        }
        return list;
    }

    public final boolean zzD(String str) {
        zzlr[] zzlrVarArr = {zzlr.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(zzlrVarArr[0].zza()));
        String zzaJ = zzaJ(arrayList);
        String zzaI = zzaI();
        StringBuilder sb = new StringBuilder(String.valueOf(zzaJ).length() + 61 + zzaI.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(zzaJ);
        sb.append(" AND NOT ");
        sb.append(zzaI);
        return zzaA(sb.toString(), new String[]{str}) != 0;
    }

    public final void zzE(Long l) {
        zzg();
        zzay();
        Preconditions.checkNotNull(l);
        try {
            if (zze().delete("upload_queue", "rowid=?", new String[]{l.toString()}) != 1) {
                this.zzu.zzaV().zze().zza("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Failed to delete a MeasurementBatch in a upload_queue table", e);
            throw e;
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
    public final String zzF() {
        SQLiteException e;
        Cursor cursor;
        SQLiteDatabase zze2 = zze();
        ?? r1 = 0;
        try {
            try {
                cursor = zze2.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
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
                    this.zzu.zzaV().zzb().zzb("Database error getting next bundle app id", e);
                    if (cursor != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                r1 = zze2;
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

    public final boolean zzG() {
        return zzaA("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final void zzH(long j) {
        zzg();
        zzay();
        try {
            if (zze().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) == 1) {
                return;
            }
            throw new SQLiteException("Deleted fewer rows from queue than expected");
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Failed to delete a bundle in a queue table", e);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI() {
        zzg();
        zzay();
        if (zzai()) {
            zzpf zzpfVar = this.zzg;
            long zza2 = zzpfVar.zzq().zza.zza();
            zzib zzibVar = this.zzu;
            long elapsedRealtime = zzibVar.zzaZ().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            zzibVar.zzc();
            if (abs > zzal.zzJ()) {
                zzpfVar.zzq().zza.zzb(elapsedRealtime);
                zzg();
                zzay();
                if (zzai()) {
                    SQLiteDatabase zze2 = zze();
                    zzibVar.zzc();
                    int delete = zze2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzibVar.zzaZ().currentTimeMillis()), String.valueOf(zzal.zzI())});
                    if (delete > 0) {
                        zzibVar.zzaV().zzk().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzJ(List list) {
        zzg();
        zzay();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzai()) {
            String join = TextUtils.join(StringUtils.COMMA, list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(sb2.length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzaA(sb3.toString(), null) > 0) {
                this.zzu.zzaV().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase zze2 = zze();
                StringBuilder sb4 = new StringBuilder(sb2.length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                zze2.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzK(Long l) {
        zzg();
        zzay();
        Preconditions.checkNotNull(l);
        if (zzai()) {
            StringBuilder sb = new StringBuilder(l.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzaA(sb.toString(), null) > 0) {
                this.zzu.zzaV().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase zze2 = zze();
                long currentTimeMillis = this.zzu.zzaZ().currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(currentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(currentTimeMillis);
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder(sb3.length() + 34 + l.toString().length() + 29);
                sb4.append("UPDATE upload_queue");
                sb4.append(sb3);
                sb4.append(" WHERE rowid = ");
                sb4.append(l);
                sb4.append(" AND retry_count < 2147483647");
                zze2.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    final Object zzL(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            this.zzu.zzaV().zzb().zza("Loaded invalid null value from database");
            return null;
        } else if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        this.zzu.zzaV().zzb().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                        return null;
                    }
                    this.zzu.zzaV().zzb().zza("Loaded invalid blob type value, ignoring it");
                    return null;
                }
                return cursor.getString(i);
            }
            return Double.valueOf(cursor.getDouble(i));
        } else {
            return Long.valueOf(cursor.getLong(i));
        }
    }

    public final long zzM() {
        return zzaB("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(3:2|3|4)|(2:6|(3:8|9|10)(1:14))|15|16|(1:18)(2:21|22)|19|9|10|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a8, code lost:
        r15 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a9, code lost:
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ae, code lost:
        r13.zzu.zzaV().zzb().zzd("Error inserting column. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r14), "first_open_count", r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c1, code lost:
        r7 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long zzN(String str, String str2) {
        long j;
        long zzaB;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzay();
        SQLiteDatabase zze2 = zze();
        zze2.beginTransaction();
        long j2 = 0;
        try {
            try {
                StringBuilder sb = new StringBuilder(48);
                sb.append("select first_open_count from app2 where app_id=?");
                j = -1;
                zzaB = zzaB(sb.toString(), new String[]{str}, -1L);
            } finally {
                zze2.endTransaction();
            }
        } catch (SQLiteException e) {
            e = e;
        }
        if (zzaB == -1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("first_open_count", (Integer) 0);
            contentValues.put("previous_install_count", (Integer) 0);
            if (zze2.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                this.zzu.zzaV().zzb().zzc("Failed to insert column (got -1). appId", zzgt.zzl(str), "first_open_count");
                return j;
            }
            zzaB = 0;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("app_id", str);
        contentValues2.put("first_open_count", Long.valueOf(1 + zzaB));
        if (zze2.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
            this.zzu.zzaV().zzb().zzc("Failed to update column (got 0). appId", zzgt.zzl(str), "first_open_count");
        } else {
            zze2.setTransactionSuccessful();
            j = zzaB;
        }
        return j;
    }

    public final long zzO() {
        return zzaB("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean zzP() {
        return zzaA("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzQ(String str, String str2) {
        return zzaA("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final boolean zzR() {
        return zzaA("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final void zzS(List list) {
        Preconditions.checkNotNull(list);
        zzg();
        zzay();
        StringBuilder sb = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append(StringUtils.COMMA);
            }
            sb.append(((Long) list.get(i)).longValue());
        }
        sb.append(")");
        int delete = zze().delete("raw_events", sb.toString(), null);
        if (delete != list.size()) {
            this.zzu.zzaV().zzb().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public final void zzT(String str) {
        try {
            zze().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Failed to remove unused event metadata. appId", zzgt.zzl(str), e);
        }
    }

    public final long zzU(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaB("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final boolean zzV(String str, Long l, long j, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzhsVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        zzib zzibVar = this.zzu;
        byte[] zzcc = zzhsVar.zzcc();
        zzibVar.zzaV().zzk().zzc("Saving complex main event, appId, data size", zzibVar.zzl().zza(str), Integer.valueOf(zzcc.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzcc);
        try {
            if (zze().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                zzibVar.zzaV().zzb().zzb("Failed to insert complex main event (got -1). appId", zzgt.zzl(str));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing complex main event. appId", zzgt.zzl(str), e);
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0085: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x0085 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle zzW(String str) {
        Cursor cursor;
        Cursor cursor2;
        zzg();
        zzay();
        Cursor cursor3 = null;
        try {
            try {
                cursor = zze().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (!cursor.moveToFirst()) {
                        this.zzu.zzaV().zzk().zza("Default event parameters not found");
                    } else {
                        try {
                            com.google.android.gms.internal.measurement.zzhs zzhsVar = (com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpj.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursor.getBlob(0))).zzbc();
                            this.zzg.zzp();
                            Bundle zzE = zzpj.zzE(zzhsVar.zza());
                            if (cursor != null) {
                                cursor.close();
                            }
                            return zzE;
                        } catch (IOException e) {
                            this.zzu.zzaV().zzb().zzc("Failed to retrieve default event parameters. appId", zzgt.zzl(str), e);
                        }
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaV().zzb().zzb("Error selecting default event parameters", e);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzX(String str, long j) {
        try {
            if (zzaB("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0) {
                return false;
            }
            return zzaB("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0;
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Error checking backfill conditions", e);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0087, code lost:
        if (r3 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0089, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00db, code lost:
        if (r3 == null) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x012c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02bb A[Catch: SQLiteException -> 0x02d1, TRY_LEAVE, TryCatch #4 {SQLiteException -> 0x02d1, blocks: (B:93:0x029f, B:95:0x02bb), top: B:108:0x029f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzY(String str, Long l, String str2, Bundle bundle) {
        String string;
        String str3;
        Bundle bundle2;
        long update;
        zzpj zzpjVar;
        com.google.android.gms.internal.measurement.zzid zzidVar;
        Cursor query;
        String str4 = str;
        Preconditions.checkNotNull(bundle);
        zzg();
        zzay();
        zzat zzatVar = l != null ? new zzat(this, str4, l.longValue()) : new zzat(this, str4);
        List<zzas> zza2 = zzatVar.zza();
        while (!zza2.isEmpty()) {
            for (zzas zzasVar : zza2) {
                if (!TextUtils.isEmpty(str2)) {
                    Cursor cursor = null;
                    r6 = null;
                    r6 = null;
                    com.google.android.gms.internal.measurement.zzid zzidVar2 = null;
                    Cursor cursor2 = null;
                    try {
                        try {
                            query = zze().query("raw_events_metadata", new String[]{TtmlNode.TAG_METADATA}, "app_id = ? and metadata_fingerprint = ?", new String[]{str4, Long.toString(zzasVar.zzb)}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                        } catch (SQLiteException e) {
                            e = e;
                            zzidVar = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        try {
                        } catch (SQLiteException e2) {
                            e = e2;
                            zzidVar = null;
                        }
                        if (query.moveToFirst()) {
                            try {
                                zzidVar = (com.google.android.gms.internal.measurement.zzid) ((com.google.android.gms.internal.measurement.zzic) zzpj.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), query.getBlob(0))).zzbc();
                            } catch (IOException e3) {
                                this.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event metadata. appId", zzgt.zzl(str4), e3);
                            }
                            try {
                                if (query.moveToNext()) {
                                    this.zzu.zzaV().zze().zzb("Get multiple raw event metadata records, expected one. appId", zzgt.zzl(str4));
                                }
                                query.close();
                                if (query != null) {
                                    query.close();
                                }
                            } catch (SQLiteException e4) {
                                e = e4;
                                cursor2 = query;
                                this.zzu.zzaV().zzb().zzc("Data loss. Error selecting raw event. appId", zzgt.zzl(str4), e);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                zzidVar2 = zzidVar;
                                if (zzidVar2 == null) {
                                }
                                zzpf zzpfVar = this.zzg;
                                zzpj zzp = zzpfVar.zzp();
                                com.google.android.gms.internal.measurement.zzhs zzhsVar = zzasVar.zzd;
                                Bundle bundle3 = new Bundle();
                                while (r8.hasNext()) {
                                }
                                string = bundle3.getString("_o");
                                bundle3.remove("_o");
                                String zzd2 = zzhsVar.zzd();
                                if (string == null) {
                                }
                                zzgu zzguVar = new zzgu(zzd2, string, bundle3, zzhsVar.zzf());
                                zzib zzibVar = this.zzu;
                                Bundle bundle4 = zzguVar.zzd;
                                str3 = zzguVar.zza;
                                zzpo zzk2 = zzibVar.zzk();
                                if (str3.equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                                }
                                zzpf zzpfVar2 = zzpfVar;
                                zzk2.zzI(bundle4, bundle2);
                                zzbb zzbbVar = new zzbb(this.zzu, zzguVar.zzb, str4, zzhsVar.zzd(), zzhsVar.zzf(), zzhsVar.zzh(), bundle4);
                                long j = zzasVar.zza;
                                long j2 = zzasVar.zzb;
                                boolean z = zzasVar.zzc;
                                zzg();
                                zzay();
                                Preconditions.checkNotNull(zzbbVar);
                                String str5 = zzbbVar.zza;
                                Preconditions.checkNotEmpty(str5);
                                byte[] zzcc = zzpfVar2.zzp().zzh(zzbbVar).zzcc();
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("app_id", str5);
                                contentValues.put("name", zzbbVar.zzb);
                                contentValues.put("timestamp", Long.valueOf(zzbbVar.zzd));
                                contentValues.put("metadata_fingerprint", Long.valueOf(j2));
                                contentValues.put("data", zzcc);
                                contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
                                update = zze().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
                                if (update != 1) {
                                }
                                str4 = str;
                            }
                            zzidVar2 = zzidVar;
                            if (zzidVar2 == null) {
                                for (com.google.android.gms.internal.measurement.zziu zziuVar : zzidVar2.zzf()) {
                                    if (zziuVar.zzc().equals(str2)) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            this.zzu.zzaV().zzb().zzb("Raw event metadata record is missing. appId", zzgt.zzl(str4));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                zzpf zzpfVar3 = this.zzg;
                zzpj zzp2 = zzpfVar3.zzp();
                com.google.android.gms.internal.measurement.zzhs zzhsVar2 = zzasVar.zzd;
                Bundle bundle32 = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar2.zza()) {
                    if (zzhwVar.zzi()) {
                        zzpjVar = zzp2;
                        bundle32.putDouble(zzhwVar.zzb(), zzhwVar.zzj());
                    } else {
                        zzpjVar = zzp2;
                        if (zzhwVar.zzg()) {
                            bundle32.putFloat(zzhwVar.zzb(), zzhwVar.zzh());
                        } else if (zzhwVar.zze()) {
                            bundle32.putLong(zzhwVar.zzb(), zzhwVar.zzf());
                        } else if (zzhwVar.zzc()) {
                            bundle32.putString(zzhwVar.zzb(), zzhwVar.zzd());
                        } else if (zzhwVar.zzk().isEmpty()) {
                            zzpjVar.zzu.zzaV().zzb().zzb("Unexpected parameter type for parameter", zzhwVar);
                        } else {
                            bundle32.putParcelableArray(zzhwVar.zzb(), zzpj.zzy(zzhwVar.zzk()));
                        }
                    }
                    zzp2 = zzpjVar;
                }
                string = bundle32.getString("_o");
                bundle32.remove("_o");
                String zzd22 = zzhsVar2.zzd();
                if (string == null) {
                    string = "";
                }
                zzgu zzguVar2 = new zzgu(zzd22, string, bundle32, zzhsVar2.zzf());
                zzib zzibVar2 = this.zzu;
                Bundle bundle42 = zzguVar2.zzd;
                str3 = zzguVar2.zza;
                zzpo zzk22 = zzibVar2.zzk();
                if (str3.equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                    bundle2 = bundle;
                } else {
                    bundle2 = new Bundle(bundle);
                    for (String str6 : bundle.keySet()) {
                        zzpf zzpfVar4 = zzpfVar3;
                        if (str6.startsWith("gad_")) {
                            bundle2.remove(str6);
                        }
                        zzpfVar3 = zzpfVar4;
                    }
                }
                zzpf zzpfVar22 = zzpfVar3;
                zzk22.zzI(bundle42, bundle2);
                zzbb zzbbVar2 = new zzbb(this.zzu, zzguVar2.zzb, str4, zzhsVar2.zzd(), zzhsVar2.zzf(), zzhsVar2.zzh(), bundle42);
                long j3 = zzasVar.zza;
                long j22 = zzasVar.zzb;
                boolean z2 = zzasVar.zzc;
                zzg();
                zzay();
                Preconditions.checkNotNull(zzbbVar2);
                String str52 = zzbbVar2.zza;
                Preconditions.checkNotEmpty(str52);
                byte[] zzcc2 = zzpfVar22.zzp().zzh(zzbbVar2).zzcc();
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str52);
                contentValues2.put("name", zzbbVar2.zzb);
                contentValues2.put("timestamp", Long.valueOf(zzbbVar2.zzd));
                contentValues2.put("metadata_fingerprint", Long.valueOf(j22));
                contentValues2.put("data", zzcc2);
                contentValues2.put("realtime", Integer.valueOf(z2 ? 1 : 0));
                try {
                    update = zze().update("raw_events", contentValues2, "rowid = ?", new String[]{String.valueOf(j3)});
                    if (update != 1) {
                        zzibVar2.zzaV().zzb().zzc("Failed to update raw event. appId, updatedRows", zzgt.zzl(str52), Long.valueOf(update));
                    }
                } catch (SQLiteException e5) {
                    this.zzu.zzaV().zzb().zzc("Error updating raw event. appId", zzgt.zzl(zzbbVar2.zza), e5);
                }
                str4 = str;
            }
            zza2 = zzatVar.zza();
            str4 = str;
        }
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
    public final zzjk zzZ(String str) {
        Throwable th;
        SQLiteException e;
        Cursor cursor;
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        Cursor cursor2 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        zzjk zzjkVar = null;
        try {
            try {
                cursor = zze().rawQuery("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str});
                try {
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaV().zzb().zzb("Error querying database.", e);
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
            zzjkVar = zzjk.zzf(cursor.getString(0), cursor.getInt(1));
        } else {
            this.zzu.zzaV().zzk().zza("No data found");
            if (cursor != null) {
                cursor.close();
            }
            return zzjkVar == null ? zzjk.zza : zzjkVar;
        }
    }

    public final boolean zzaa(String str, zzog zzogVar) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzogVar);
        Preconditions.checkNotEmpty(str);
        zzib zzibVar = this.zzu;
        long currentTimeMillis = zzibVar.zzaZ().currentTimeMillis();
        zzfw zzfwVar = zzfx.zzav;
        long j = zzogVar.zzb;
        if (j < currentTimeMillis - ((Long) zzfwVar.zzb(null)).longValue() || j > ((Long) zzfwVar.zzb(null)).longValue() + currentTimeMillis) {
            zzibVar.zzaV().zze().zzd("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgt.zzl(str), Long.valueOf(currentTimeMillis), Long.valueOf(j));
        }
        zzibVar.zzaV().zzk().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzogVar.zza);
        contentValues.put("source", Integer.valueOf(zzogVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(j));
        try {
            if (zze().insert("trigger_uris", null, contentValues) == -1) {
                zzibVar.zzaV().zzb().zzb("Failed to insert trigger URI (got -1). appId", zzgt.zzl(str));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing trigger URI. appId", zzgt.zzl(str), e);
            return false;
        }
    }

    public final void zzab(String str, zzjk zzjkVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjkVar);
        zzg();
        zzay();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjkVar.zzl());
        contentValues.put("consent_source", Integer.valueOf(zzjkVar.zzb()));
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final zzaz zzac(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        return zzaz.zzg(zzaC("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final void zzad(String str, zzaz zzazVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzazVar);
        zzg();
        zzay();
        zzjk zzZ = zzZ(str);
        zzjk zzjkVar = zzjk.zza;
        if (zzZ == zzjkVar) {
            zzab(str, zzjkVar);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzazVar.zze());
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final void zzae(String str, zzjk zzjkVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjkVar);
        zzg();
        zzay();
        zzab(str, zzZ(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjkVar.zzl());
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final zzjk zzaf(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        return zzjk.zzf(zzaC("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""), 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0345, code lost:
        if (zze().insertWithOnConflict("property_filters", null, r13, 5) != (-1)) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0347, code lost:
        r25.zzu.zzaV().zzb().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzgt.zzl(r26));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x035b, code lost:
        r0 = r22;
        r3 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0361, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0362, code lost:
        r25.zzu.zzaV().zzb().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r26), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0375, code lost:
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26);
        r0 = zze();
        r0.delete("property_filters", "app_id=? and audience_id=?", new java.lang.String[]{r26, java.lang.String.valueOf(r11)});
        r0.delete("event_filters", "app_id=? and audience_id=?", new java.lang.String[]{r26, java.lang.String.valueOf(r11)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x039f, code lost:
        r7 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x049e, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x04a3, code lost:
        r23.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x04a6, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0174, code lost:
        r12 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0180, code lost:
        if (r12.hasNext() == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x018c, code lost:
        if (((com.google.android.gms.internal.measurement.zzfn) r12.next()).zza() != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x018e, code lost:
        r25.zzu.zzaV().zze().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzgt.zzl(r26), java.lang.Integer.valueOf(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01a7, code lost:
        r12 = r0.zzf().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01b3, code lost:
        r22 = r0;
        r0 = "app_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01c1, code lost:
        if (r12.hasNext() == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01c3, code lost:
        r13 = (com.google.android.gms.internal.measurement.zzff) r12.next();
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01dd, code lost:
        if (r13.zzc().isEmpty() == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01df, code lost:
        r0 = r25.zzu.zzaV().zze();
        r10 = com.google.android.gms.measurement.internal.zzgt.zzl(r26);
        r12 = java.lang.Integer.valueOf(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01f7, code lost:
        if (r13.zza() == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01f9, code lost:
        r13 = java.lang.Integer.valueOf(r13.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0202, code lost:
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0203, code lost:
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r10, r12, java.lang.String.valueOf(r13));
        r23 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x020e, code lost:
        r3 = r13.zzcc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0212, code lost:
        r23 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0214, code lost:
        r7 = new android.content.ContentValues();
        r7.put("app_id", r26);
        r7.put("audience_id", java.lang.Integer.valueOf(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0227, code lost:
        if (r13.zza() == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0229, code lost:
        r0 = java.lang.Integer.valueOf(r13.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0232, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0233, code lost:
        r7.put("filter_id", r0);
        r7.put("event_name", r13.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0243, code lost:
        if (r13.zzk() == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0245, code lost:
        r0 = java.lang.Boolean.valueOf(r13.zzm());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x024e, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x024f, code lost:
        r7.put("session_scoped", r0);
        r7.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0261, code lost:
        if (zze().insertWithOnConflict("event_filters", null, r7, 5) != (-1)) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0263, code lost:
        r25.zzu.zzaV().zzb().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzgt.zzl(r26));
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0276, code lost:
        r0 = r22;
        r7 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x027e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x027f, code lost:
        r25.zzu.zzaV().zzb().zzc("Error storing event filter. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r26), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0294, code lost:
        r23 = r7;
        r3 = r22.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02a2, code lost:
        if (r3.hasNext() == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02a4, code lost:
        r7 = (com.google.android.gms.internal.measurement.zzfn) r3.next();
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02be, code lost:
        if (r7.zzc().isEmpty() == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02c0, code lost:
        r0 = r25.zzu.zzaV().zze();
        r9 = com.google.android.gms.measurement.internal.zzgt.zzl(r26);
        r10 = java.lang.Integer.valueOf(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02d8, code lost:
        if (r7.zza() == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02da, code lost:
        r21 = java.lang.Integer.valueOf(r7.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02e5, code lost:
        r21 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02e7, code lost:
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r9, r10, java.lang.String.valueOf(r21));
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02f0, code lost:
        r12 = r7.zzcc();
        r13 = new android.content.ContentValues();
        r13.put(r0, r26);
        r22 = r0;
        r13.put("audience_id", java.lang.Integer.valueOf(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0309, code lost:
        if (r7.zza() == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x030b, code lost:
        r0 = java.lang.Integer.valueOf(r7.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0314, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0315, code lost:
        r13.put("filter_id", r0);
        r24 = r3;
        r13.put("property_name", r7.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0327, code lost:
        if (r7.zzg() == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0329, code lost:
        r0 = java.lang.Boolean.valueOf(r7.zzh());
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
    public final void zzag(String str, List list) {
        SQLiteDatabase sQLiteDatabase;
        boolean z;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            com.google.android.gms.internal.measurement.zzfc zzfcVar = (com.google.android.gms.internal.measurement.zzfc) ((com.google.android.gms.internal.measurement.zzfd) list.get(i)).zzcl();
            if (zzfcVar.zzd() != 0) {
                for (int i2 = 0; i2 < zzfcVar.zzd(); i2++) {
                    com.google.android.gms.internal.measurement.zzfe zzfeVar = (com.google.android.gms.internal.measurement.zzfe) zzfcVar.zze(i2).zzcl();
                    com.google.android.gms.internal.measurement.zzfe zzfeVar2 = (com.google.android.gms.internal.measurement.zzfe) zzfeVar.zzaR();
                    String zzb2 = zzjl.zzb(zzfeVar.zza());
                    if (zzb2 != null) {
                        zzfeVar2.zzb(zzb2);
                        z = true;
                    } else {
                        z = false;
                    }
                    int i3 = 0;
                    while (i3 < zzfeVar.zzc()) {
                        com.google.android.gms.internal.measurement.zzfh zzd2 = zzfeVar.zzd(i3);
                        com.google.android.gms.internal.measurement.zzfe zzfeVar3 = zzfeVar;
                        String zzc2 = zzls.zzc(zzd2.zzh(), zzjm.zza, zzjm.zzb);
                        if (zzc2 != null) {
                            com.google.android.gms.internal.measurement.zzfg zzfgVar = (com.google.android.gms.internal.measurement.zzfg) zzd2.zzcl();
                            zzfgVar.zza(zzc2);
                            zzfeVar2.zze(i3, (com.google.android.gms.internal.measurement.zzfh) zzfgVar.zzbc());
                            z = true;
                        }
                        i3++;
                        zzfeVar = zzfeVar3;
                    }
                    if (z) {
                        zzfcVar.zzf(i2, zzfeVar2);
                        list.set(i, (com.google.android.gms.internal.measurement.zzfd) zzfcVar.zzbc());
                    }
                }
            }
            if (zzfcVar.zza() != 0) {
                for (int i4 = 0; i4 < zzfcVar.zza(); i4++) {
                    com.google.android.gms.internal.measurement.zzfn zzb3 = zzfcVar.zzb(i4);
                    String zzc3 = zzls.zzc(zzb3.zzc(), zzjn.zza, zzjn.zzb);
                    if (zzc3 != null) {
                        com.google.android.gms.internal.measurement.zzfm zzfmVar = (com.google.android.gms.internal.measurement.zzfm) zzb3.zzcl();
                        zzfmVar.zza(zzc3);
                        zzfcVar.zzc(i4, zzfmVar);
                        list.set(i, (com.google.android.gms.internal.measurement.zzfd) zzfcVar.zzbc());
                    }
                }
            }
        }
        zzay();
        zzg();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase zze2 = zze();
        zze2.beginTransaction();
        try {
            zzay();
            zzg();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase zze3 = zze();
            zze3.delete("property_filters", "app_id=?", new String[]{str});
            zze3.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzfd zzfdVar = (com.google.android.gms.internal.measurement.zzfd) it.next();
                zzay();
                zzg();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfdVar);
                if (!zzfdVar.zza()) {
                    this.zzu.zzaV().zze().zzb("Audience with no ID. appId", zzgt.zzl(str));
                } else {
                    int zzb4 = zzfdVar.zzb();
                    Iterator it2 = zzfdVar.zzf().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!((com.google.android.gms.internal.measurement.zzff) it2.next()).zza()) {
                                this.zzu.zzaV().zze().zzc("Event filter with no ID. Audience definition ignored. appId, audienceId", zzgt.zzl(str), Integer.valueOf(zzb4));
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            sQLiteDatabase = zze2;
            ArrayList arrayList = new ArrayList();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                com.google.android.gms.internal.measurement.zzfd zzfdVar2 = (com.google.android.gms.internal.measurement.zzfd) it3.next();
                arrayList.add(zzfdVar2.zza() ? Integer.valueOf(zzfdVar2.zzb()) : null);
            }
            Preconditions.checkNotEmpty(str);
            zzay();
            zzg();
            SQLiteDatabase zze4 = zze();
            try {
                long zzaA = zzaA("select count(1) from audience_filter_values where app_id=?", new String[]{str});
                int max = Math.max(0, Math.min(2000, this.zzu.zzc().zzm(str, zzfx.zzU)));
                if (zzaA > max) {
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
                            String join = TextUtils.join(StringUtils.COMMA, arrayList2);
                            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
                            sb.append("(");
                            sb.append(join);
                            sb.append(")");
                            String sb2 = sb.toString();
                            StringBuilder sb3 = new StringBuilder(sb2.length() + 140);
                            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
                            sb3.append(sb2);
                            sb3.append(" order by rowid desc limit -1 offset ?)");
                            zze4.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)});
                            break;
                        }
                    }
                }
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Database error querying filters. appId", zzgt.zzl(str), e);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = zze2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbc zzah(String str, com.google.android.gms.internal.measurement.zzhs zzhsVar, String str2) {
        zzbc zzaE = zzaE("events", str, zzhsVar.zzd());
        if (zzaE == null) {
            zzib zzibVar = this.zzu;
            zzibVar.zzaV().zze().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzgt.zzl(str), zzibVar.zzl().zza(str2));
            return new zzbc(str, zzhsVar.zzd(), 1L, 1L, 1L, zzhsVar.zzf(), 0L, null, null, null, null);
        }
        long j = zzaE.zze + 1;
        long j2 = zzaE.zzd + 1;
        return new zzbc(zzaE.zza, zzaE.zzb, zzaE.zzc + 1, j2, j, zzaE.zzf, zzaE.zzg, zzaE.zzh, zzaE.zzi, zzaE.zzj, zzaE.zzk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzai() {
        zzib zzibVar = this.zzu;
        Context zzaY = zzibVar.zzaY();
        zzibVar.zzc();
        return zzaY.getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ long zzaj(String str, String[] strArr, long j) {
        return zzaB("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", strArr, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzof zzau() {
        return this.zzn;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x020d A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzav(String str, long j, long j2, zzpb zzpbVar) {
        String str2;
        SQLiteDatabase zze2;
        String str3;
        String string;
        String str4;
        String[] strArr;
        int i;
        Preconditions.checkNotNull(zzpbVar);
        zzg();
        zzay();
        Cursor cursor = null;
        try {
            try {
                zze2 = zze();
            } catch (SQLiteException e) {
                e = e;
                str2 = str;
            }
            if (TextUtils.isEmpty(str)) {
                int i2 = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
                String[] strArr2 = i2 != 0 ? new String[]{String.valueOf(j2), String.valueOf(j)} : new String[]{String.valueOf(j)};
                str3 = i2 != 0 ? "rowid <= ? and " : "";
                StringBuilder sb = new StringBuilder(str3.length() + 148);
                sb.append("select app_id, metadata_fingerprint from raw_events where ");
                sb.append(str3);
                sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                cursor = zze2.rawQuery(sb.toString(), strArr2);
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
                    this.zzu.zzaV().zzb().zzc("Data loss. Error selecting raw event. appId", zzgt.zzl(str2), e);
                }
            } else {
                int i3 = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
                String[] strArr3 = i3 != 0 ? new String[]{str, String.valueOf(j2)} : new String[]{str};
                str3 = i3 != 0 ? " and rowid <= ?" : "";
                StringBuilder sb2 = new StringBuilder(str3.length() + 84);
                sb2.append("select metadata_fingerprint from raw_events where app_id = ?");
                sb2.append(str3);
                sb2.append(" order by rowid limit 1;");
                cursor = zze2.rawQuery(sb2.toString(), strArr3);
                if (cursor.moveToFirst()) {
                    string = cursor.getString(0);
                    cursor.close();
                    str2 = str;
                }
            }
            int i4 = 1;
            cursor = zze2.query("raw_events_metadata", new String[]{TtmlNode.TAG_METADATA}, "app_id = ? and metadata_fingerprint = ?", new String[]{str2, string}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
            if (!cursor.moveToFirst()) {
                this.zzu.zzaV().zzb().zzb("Raw event metadata record is missing. appId", zzgt.zzl(str2));
            } else {
                try {
                    com.google.android.gms.internal.measurement.zzid zzidVar = (com.google.android.gms.internal.measurement.zzid) ((com.google.android.gms.internal.measurement.zzic) zzpj.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), cursor.getBlob(0))).zzbc();
                    if (cursor.moveToNext()) {
                        this.zzu.zzaV().zze().zzb("Get multiple raw event metadata records, expected one. appId", zzgt.zzl(str2));
                    }
                    cursor.close();
                    Preconditions.checkNotNull(zzidVar);
                    zzpbVar.zza = zzidVar;
                    if (j2 != -1) {
                        str4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                        strArr = new String[]{str2, string, String.valueOf(j2)};
                    } else {
                        str4 = "app_id = ? and metadata_fingerprint = ?";
                        strArr = new String[]{str2, string};
                    }
                    cursor = zze2.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str4, strArr, null, null, "rowid", null);
                    if (cursor.moveToFirst()) {
                        while (true) {
                            long j3 = cursor.getLong(0);
                            try {
                                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpj.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursor.getBlob(3));
                                i = i4;
                                zzhrVar.zzl(cursor.getString(i));
                                zzhrVar.zzo(cursor.getLong(2));
                                if (!zzpbVar.zza(j3, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc())) {
                                    break;
                                }
                            } catch (IOException e3) {
                                i = i4;
                                this.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event. appId", zzgt.zzl(str2), e3);
                            }
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            i4 = i;
                        }
                    } else {
                        this.zzu.zzaV().zze().zzb("Raw event data disappeared while in transaction. appId", zzgt.zzl(str2));
                    }
                } catch (IOException e4) {
                    this.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event metadata. appId", zzgt.zzl(str2), e4);
                }
            }
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    public final void zzb() {
        zzay();
        zze().beginTransaction();
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    protected final boolean zzbb() {
        return false;
    }

    public final void zzc() {
        zzay();
        zze().setTransactionSuccessful();
    }

    public final void zzd() {
        zzay();
        zze().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SQLiteDatabase zze() {
        zzg();
        try {
            return this.zzm.getWritableDatabase();
        } catch (SQLiteException e) {
            this.zzu.zzaV().zze().zzb("Error opening database", e);
            throw e;
        }
    }

    public final zzbc zzf(String str, String str2) {
        return zzaE("events", str, str2);
    }

    public final void zzh(zzbc zzbcVar) {
        zzaF("events", zzbcVar);
    }

    public final void zzi(String str) {
        zzbc zzaE;
        zzaG("events_snapshot", str);
        Cursor cursor = null;
        try {
            try {
                cursor = zze().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(0);
                        if (string != null && (zzaE = zzaE("events", str, string)) != null) {
                            zzaF("events_snapshot", zzaE);
                        }
                    } while (cursor.moveToNext());
                }
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Error creating snapshot. appId", zzgt.zzl(str), e);
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

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c3, code lost:
        if (r10 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c5, code lost:
        zzaF("events", r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x005e, code lost:
        if (r10 != null) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzj(String str) {
        boolean z;
        zzbc zzaE;
        boolean z2 = false;
        ArrayList arrayList = new ArrayList(Arrays.asList("name", "lifetime_count"));
        zzbc zzaE2 = zzaE("events", str, "_f");
        zzbc zzaE3 = zzaE("events", str, "_v");
        zzaG("events", str);
        Cursor cursor = null;
        try {
            cursor = zze().query("events_snapshot", (String[]) arrayList.toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
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
                    if (string != null && (zzaE = zzaE("events_snapshot", str, string)) != null) {
                        zzaF("events", zzaE);
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    z2 = z3;
                    try {
                        this.zzu.zzaV().zzb().zzc("Error querying snapshot. appId", zzgt.zzl(str), e);
                        z3 = z2;
                        if (cursor != null) {
                        }
                        if (!z3) {
                        }
                        if (!z) {
                        }
                        zzaG("events_snapshot", str);
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (z2 && zzaE2 != null) {
                            zzaF("events", zzaE2);
                        } else if (!z && zzaE3 != null) {
                            zzaF("events", zzaE3);
                        }
                        zzaG("events_snapshot", str);
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
                        zzaF("events", zzaE3);
                    }
                    zzaG("events_snapshot", str);
                    throw th;
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            if (!z3 || zzaE2 == null) {
                if (!z) {
                }
                zzaG("events_snapshot", str);
            }
            zzaF("events", zzaE2);
            zzaG("events_snapshot", str);
        }
        if (cursor != null) {
            cursor.close();
        }
        if (zzaE2 == null) {
        }
        zzaF("events", zzaE2);
        zzaG("events_snapshot", str);
    }

    public final void zzk(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            zze().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzib zzibVar = this.zzu;
            zzibVar.zzaV().zzb().zzd("Error deleting user property. appId", zzgt.zzl(str), zzibVar.zzl().zzc(str2), e);
        }
    }

    public final boolean zzl(zzpm zzpmVar) {
        Preconditions.checkNotNull(zzpmVar);
        zzg();
        zzay();
        String str = zzpmVar.zza;
        String str2 = zzpmVar.zzc;
        if (zzm(str, str2) == null) {
            if (zzpo.zzh(str2)) {
                if (zzaA("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= this.zzu.zzc().zzn(str, zzfx.zzV, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long zzaA = zzaA("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, zzpmVar.zzb});
                this.zzu.zzc();
                if (zzaA >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzpmVar.zzb);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(zzpmVar.zzd));
        zzaw(contentValues, "value", zzpmVar.zze);
        try {
            if (zze().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                this.zzu.zzaV().zzb().zzb("Failed to insert/update user property (got -1). appId", zzgt.zzl(str));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing user property. appId", zzgt.zzl(zzpmVar.zza), e);
        }
        return true;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00a3: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:32:0x00a2 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzpm zzm(String str, String str2) {
        Throwable th;
        String str3;
        String str4;
        SQLiteException sQLiteException;
        Cursor cursor;
        Cursor cursor2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        Cursor cursor3 = null;
        try {
            try {
                cursor = zze().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (cursor.moveToFirst()) {
                        long j = cursor.getLong(0);
                        Object zzL = zzL(cursor, 1);
                        if (zzL != null) {
                            str3 = str;
                            str4 = str2;
                            try {
                                zzpm zzpmVar = new zzpm(str3, cursor.getString(2), str4, j, zzL);
                                if (cursor.moveToNext()) {
                                    this.zzu.zzaV().zzb().zzb("Got multiple records for user property, expected one. appId", zzgt.zzl(str3));
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return zzpmVar;
                            } catch (SQLiteException e) {
                                e = e;
                                sQLiteException = e;
                                zzib zzibVar = this.zzu;
                                zzibVar.zzaV().zzb().zzd("Error querying user property. appId", zzgt.zzl(str3), zzibVar.zzl().zzc(str4), sQLiteException);
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

    public final List zzn(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        List arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                zzib zzibVar = this.zzu;
                zzibVar.zzc();
                cursor = zze().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(0);
                        String string2 = cursor.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j = cursor.getLong(2);
                        Object zzL = zzL(cursor, 3);
                        if (zzL != null) {
                            arrayList.add(new zzpm(str, str2, string, j, zzL));
                        } else {
                            zzibVar.zzaV().zzb().zzb("Read invalid user property value, ignoring it. appId", zzgt.zzl(str));
                        }
                    } while (cursor.moveToNext());
                }
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Error querying user properties. appId", zzgt.zzl(str), e);
                arrayList = Collections.emptyList();
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b9, code lost:
        r0 = r13.zzaV().zzb();
        r13.zzc();
        r0.zzb("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzo(String str, String str2, String str3) {
        Cursor cursor;
        String str4;
        Cursor cursor2;
        String str5;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        List arrayList = new ArrayList();
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                String str6 = str;
                arrayList2.add(str6);
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
                            this.zzu.zzaV().zzb().zzd("(2)Error querying user properties", zzgt.zzl(str), str4, e);
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
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 1);
                    sb2.append(str3);
                    sb2.append("*");
                    arrayList2.add(sb2.toString());
                    sb.append(" and name glob ?");
                }
                String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                String sb3 = sb.toString();
                zzib zzibVar = this.zzu;
                zzibVar.zzc();
                cursor2 = zze().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb3, strArr, null, null, "rowid", "1001");
                try {
                    try {
                        if (cursor2.moveToFirst()) {
                            while (true) {
                                int size = arrayList.size();
                                zzibVar.zzc();
                                if (size >= 1000) {
                                    break;
                                }
                                String string = cursor2.getString(0);
                                long j = cursor2.getLong(1);
                                Object zzL = zzL(cursor2, 2);
                                String string2 = cursor2.getString(3);
                                if (zzL != null) {
                                    str5 = string2;
                                    try {
                                        arrayList.add(new zzpm(str6, str5, string, j, zzL));
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        cursor = cursor2;
                                        str4 = str5;
                                        this.zzu.zzaV().zzb().zzd("(2)Error querying user properties", zzgt.zzl(str), str4, e);
                                        arrayList = Collections.emptyList();
                                        cursor2 = cursor;
                                        if (cursor2 != null) {
                                        }
                                        return arrayList;
                                    }
                                } else {
                                    try {
                                        zzibVar.zzaV().zzb().zzd("(2)Read invalid user property value, ignoring it", zzgt.zzl(str6), string2, str3);
                                        str5 = string2;
                                    } catch (SQLiteException e3) {
                                        e = e3;
                                        str5 = string2;
                                        cursor = cursor2;
                                        str4 = str5;
                                        this.zzu.zzaV().zzb().zzd("(2)Error querying user properties", zzgt.zzl(str), str4, e);
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
                                str6 = str;
                                str4 = str5;
                            }
                        }
                    } catch (SQLiteException e4) {
                        e = e4;
                        cursor = cursor2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } catch (SQLiteException e5) {
                e = e5;
                str4 = str2;
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public final boolean zzp(zzah zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        zzg();
        zzay();
        String str = zzahVar.zza;
        Preconditions.checkNotNull(str);
        if (zzm(str, zzahVar.zzc.zzb) == null) {
            long zzaA = zzaA("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzu.zzc();
            if (zzaA >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzahVar.zzb);
        contentValues.put("name", zzahVar.zzc.zzb);
        zzaw(contentValues, "value", Preconditions.checkNotNull(zzahVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzahVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzahVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzahVar.zzh));
        zzib zzibVar = this.zzu;
        contentValues.put("timed_out_event", zzibVar.zzk().zzae(zzahVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzahVar.zzd));
        contentValues.put("triggered_event", zzibVar.zzk().zzae(zzahVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzahVar.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzahVar.zzj));
        contentValues.put("expired_event", zzibVar.zzk().zzae(zzahVar.zzk));
        try {
            if (zze().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzibVar.zzaV().zzb().zzb("Failed to insert/update conditional user property (got -1)", zzgt.zzl(str));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing conditional user property", zzgt.zzl(str), e);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0157: MOVE  (r8 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:43:0x0157 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzah zzq(String str, String str2) {
        Cursor cursor;
        String str3;
        Cursor cursor2;
        Cursor cursor3;
        Cursor cursor4;
        Cursor cursor5;
        zzah zzahVar;
        SQLiteDatabase zze2;
        String[] strArr;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            try {
                zze2 = zze();
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
                zzahVar = 0;
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
                cursor5 = zze2.query("conditional_properties", strArr, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                } catch (SQLiteException e) {
                    e = e;
                    str3 = str2;
                }
            } catch (SQLiteException e2) {
                e = e2;
                str3 = str2;
                cursor5 = cursor2;
                zzib zzibVar = this.zzu;
                zzibVar.zzaV().zzb().zzd("Error querying conditional property", zzgt.zzl(str), zzibVar.zzl().zzc(str3), e);
                zzahVar = cursor2;
                if (cursor5 != null) {
                }
                return zzahVar;
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
            return zzahVar;
        }
        String string = cursor5.getString(0);
        if (string == null) {
            string = "";
        }
        Object zzL = zzL(cursor5, 1);
        boolean z = cursor5.getInt(2) != 0;
        String string2 = cursor5.getString(3);
        long j = cursor5.getLong(4);
        zzpf zzpfVar = this.zzg;
        str3 = str2;
        String str4 = string;
        try {
            zzah zzahVar2 = new zzah(str, str4, new zzpk(str3, cursor5.getLong(8), zzL, str4), cursor5.getLong(6), z, string2, (zzbg) zzpfVar.zzp().zzl(cursor5.getBlob(5), zzbg.CREATOR), j, (zzbg) zzpfVar.zzp().zzl(cursor5.getBlob(7), zzbg.CREATOR), cursor5.getLong(9), (zzbg) zzpfVar.zzp().zzl(cursor5.getBlob(10), zzbg.CREATOR));
            if (cursor5.moveToNext()) {
                zzib zzibVar2 = this.zzu;
                zzibVar2.zzaV().zzb().zzc("Got multiple records for conditional property, expected one", zzgt.zzl(str), zzibVar2.zzl().zzc(str3));
            }
            if (cursor5 != null) {
                cursor5.close();
            }
            return zzahVar2;
        } catch (SQLiteException e4) {
            e = e4;
            zzib zzibVar3 = this.zzu;
            zzibVar3.zzaV().zzb().zzd("Error querying conditional property", zzgt.zzl(str), zzibVar3.zzl().zzc(str3), e);
            zzahVar = cursor2;
            if (cursor5 != null) {
            }
            return zzahVar;
        }
    }

    public final int zzr(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            return zze().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzib zzibVar = this.zzu;
            zzibVar.zzaV().zzb().zzd("Error deleting conditional property", zzgt.zzl(str), zzibVar.zzl().zzc(str2), e);
            return 0;
        }
    }

    public final List zzs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            String.valueOf(str3);
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzt(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0086, code lost:
        r3 = r11.zzaV().zzb();
        r11.zzc();
        r3.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzt(String str, String[] strArr) {
        Cursor cursor;
        Cursor cursor2;
        zzg();
        zzay();
        List arrayList = new ArrayList();
        try {
            SQLiteDatabase zze2 = zze();
            int i = 0;
            int i2 = 1;
            String[] strArr2 = {"app_id", "origin", "name", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"};
            zzib zzibVar = this.zzu;
            zzibVar.zzc();
            cursor2 = zze2.query("conditional_properties", strArr2, str, strArr, null, null, "rowid", "1001");
            try {
                if (cursor2.moveToFirst()) {
                    while (true) {
                        int size = arrayList.size();
                        zzibVar.zzc();
                        if (size >= 1000) {
                            break;
                        }
                        String string = cursor2.getString(i);
                        String string2 = cursor2.getString(i2);
                        String string3 = cursor2.getString(2);
                        Object zzL = zzL(cursor2, 3);
                        boolean z = cursor2.getInt(4) != 0 ? i2 : i;
                        String string4 = cursor2.getString(5);
                        long j = cursor2.getLong(6);
                        zzpf zzpfVar = this.zzg;
                        arrayList.add(new zzah(string, string2, new zzpk(string3, cursor2.getLong(10), zzL, string2), cursor2.getLong(8), z, string4, (zzbg) zzpfVar.zzp().zzl(cursor2.getBlob(7), zzbg.CREATOR), j, (zzbg) zzpfVar.zzp().zzl(cursor2.getBlob(9), zzbg.CREATOR), cursor2.getLong(11), (zzbg) zzpfVar.zzp().zzl(cursor2.getBlob(12), zzbg.CREATOR)));
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
                    this.zzu.zzaV().zzb().zzb("Error querying conditional user property value", e);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0205 A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0251 A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0260 A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x027c A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x028d A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02ce A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02e8 A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02ff A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x032a A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x033f A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0352 A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x036e A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x037e A[Catch: SQLiteException -> 0x0395, all -> 0x03bf, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x0395, blocks: (B:6:0x0137, B:9:0x013f, B:11:0x0156, B:12:0x015d, B:14:0x0170, B:15:0x0177, B:17:0x01b6, B:22:0x01c0, B:26:0x020a, B:28:0x0239, B:33:0x0243, B:37:0x0255, B:39:0x0260, B:40:0x0272, B:42:0x027c, B:43:0x0285, B:45:0x028d, B:49:0x0296, B:51:0x02ce, B:52:0x02e0, B:54:0x02e8, B:58:0x02f1, B:65:0x030a, B:69:0x0334, B:71:0x033f, B:72:0x034a, B:74:0x0352, B:75:0x035d, B:77:0x036e, B:78:0x0375, B:80:0x037e, B:68:0x032a, B:61:0x02ff, B:64:0x0306, B:36:0x0251, B:25:0x0205), top: B:105:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzh zzu(String str) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        Cursor cursor4;
        zzh zzhVar;
        boolean z;
        boolean z2;
        zzib zzibVar;
        Boolean valueOf;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        try {
            SQLiteDatabase zze2 = zze();
            String[] strArr = new String[45];
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
                cursor4 = zze2.query("apps", strArr, "app_id=?", new String[]{str}, null, null, null);
                try {
                    try {
                    } catch (SQLiteException e) {
                        e = e;
                        this.zzu.zzaV().zzb().zzc("Error querying app. appId", zzgt.zzl(str), e);
                        zzhVar = cursor2;
                        if (cursor4 != null) {
                        }
                        return zzhVar;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor3 = cursor4;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor4 = cursor2;
                this.zzu.zzaV().zzb().zzc("Error querying app. appId", zzgt.zzl(str), e);
                zzhVar = cursor2;
                if (cursor4 != null) {
                }
                return zzhVar;
            } catch (Throwable th2) {
                th = th2;
                cursor3 = cursor;
                if (cursor3 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (!cursor4.moveToFirst()) {
            if (cursor4 != null) {
                cursor4.close();
            }
            return zzhVar;
        }
        zzpf zzpfVar = this.zzg;
        zzh zzhVar2 = new zzh(zzpfVar.zzaf(), str);
        zzjk zzB = zzpfVar.zzB(str);
        zzjj zzjjVar = zzjj.ANALYTICS_STORAGE;
        if (zzB.zzo(zzjjVar)) {
            zzhVar2.zze(cursor4.getString(0));
        }
        zzhVar2.zzg(cursor4.getString(1));
        if (zzpfVar.zzB(str).zzo(zzjj.AD_STORAGE)) {
            zzhVar2.zzk(cursor4.getString(2));
        }
        zzhVar2.zzF(cursor4.getLong(3));
        zzhVar2.zzo(cursor4.getLong(4));
        zzhVar2.zzq(cursor4.getLong(5));
        zzhVar2.zzs(cursor4.getString(6));
        zzhVar2.zzw(cursor4.getString(7));
        zzhVar2.zzy(cursor4.getLong(8));
        zzhVar2.zzA(cursor4.getLong(9));
        if (!cursor4.isNull(10) && cursor4.getInt(10) == 0) {
            z = false;
            zzhVar2.zzE(z);
            zzhVar2.zzO(cursor4.getLong(11));
            zzhVar2.zzQ(cursor4.getLong(12));
            zzhVar2.zzS(cursor4.getLong(13));
            zzhVar2.zzU(cursor4.getLong(14));
            zzhVar2.zzI(cursor4.getLong(15));
            zzhVar2.zzK(cursor4.getLong(16));
            zzhVar2.zzu(!cursor4.isNull(17) ? SieveCacheKt.NodeMetaAndPreviousMask : cursor4.getInt(17));
            zzhVar2.zzm(cursor4.getString(18));
            zzhVar2.zzY(cursor4.getLong(19));
            zzhVar2.zzW(cursor4.getLong(20));
            zzhVar2.zzab(cursor4.getString(21));
            if (!cursor4.isNull(23) && cursor4.getInt(23) == 0) {
                z2 = false;
                zzhVar2.zzad(z2);
                zzhVar2.zzC(!cursor4.isNull(25) ? 0L : cursor4.getLong(25));
                if (!cursor4.isNull(26)) {
                    zzhVar2.zzah(Arrays.asList(cursor4.getString(26).split(StringUtils.COMMA, -1)));
                }
                if (zzpfVar.zzB(str).zzo(zzjjVar)) {
                    zzhVar2.zzi(cursor4.getString(28));
                }
                zzhVar2.zzaj(cursor4.isNull(29) && cursor4.getInt(29) != 0);
                zzhVar2.zzaE(cursor4.getLong(39));
                zzhVar2.zzaz(cursor4.getString(36));
                zzhVar2.zzal(cursor4.getLong(30));
                zzhVar2.zzan(cursor4.getLong(31));
                zzql.zza();
                zzibVar = this.zzu;
                if (zzibVar.zzc().zzp(str, zzfx.zzaP)) {
                    zzhVar2.zzap(cursor4.getInt(32));
                    zzhVar2.zzax(cursor4.getLong(35));
                }
                zzhVar2.zzar(cursor4.isNull(33) && cursor4.getInt(33) != 0);
                if (cursor4.isNull(34)) {
                    valueOf = Boolean.valueOf(cursor4.getInt(34) != 0);
                } else {
                    valueOf = null;
                }
                zzhVar2.zzaf(valueOf);
                zzhVar2.zzaB(cursor4.getInt(37));
                zzhVar2.zzaD(cursor4.getInt(38));
                zzhVar2.zzaG(!cursor4.isNull(40) ? "" : (String) Preconditions.checkNotNull(cursor4.getString(40)));
                if (!cursor4.isNull(41)) {
                    zzhVar2.zzat(Long.valueOf(cursor4.getLong(41)));
                }
                if (!cursor4.isNull(42)) {
                    zzhVar2.zzav(Long.valueOf(cursor4.getLong(42)));
                }
                zzhVar2.zzaI(cursor4.getBlob(43));
                if (!cursor4.isNull(44)) {
                    zzhVar2.zzaK(cursor4.getInt(44));
                }
                zzhVar2.zzb();
                if (cursor4.moveToNext()) {
                    zzibVar.zzaV().zzb().zzb("Got multiple records for app, expected one. appId", zzgt.zzl(str));
                }
                if (cursor4 != null) {
                    cursor4.close();
                }
                return zzhVar2;
            }
            z2 = true;
            zzhVar2.zzad(z2);
            zzhVar2.zzC(!cursor4.isNull(25) ? 0L : cursor4.getLong(25));
            if (!cursor4.isNull(26)) {
            }
            if (zzpfVar.zzB(str).zzo(zzjjVar)) {
            }
            zzhVar2.zzaj(cursor4.isNull(29) && cursor4.getInt(29) != 0);
            zzhVar2.zzaE(cursor4.getLong(39));
            zzhVar2.zzaz(cursor4.getString(36));
            zzhVar2.zzal(cursor4.getLong(30));
            zzhVar2.zzan(cursor4.getLong(31));
            zzql.zza();
            zzibVar = this.zzu;
            if (zzibVar.zzc().zzp(str, zzfx.zzaP)) {
            }
            zzhVar2.zzar(cursor4.isNull(33) && cursor4.getInt(33) != 0);
            if (cursor4.isNull(34)) {
            }
            zzhVar2.zzaf(valueOf);
            zzhVar2.zzaB(cursor4.getInt(37));
            zzhVar2.zzaD(cursor4.getInt(38));
            zzhVar2.zzaG(!cursor4.isNull(40) ? "" : (String) Preconditions.checkNotNull(cursor4.getString(40)));
            if (!cursor4.isNull(41)) {
            }
            if (!cursor4.isNull(42)) {
            }
            zzhVar2.zzaI(cursor4.getBlob(43));
            if (!cursor4.isNull(44)) {
            }
            zzhVar2.zzb();
            if (cursor4.moveToNext()) {
            }
            if (cursor4 != null) {
            }
            return zzhVar2;
        }
        z = true;
        zzhVar2.zzE(z);
        zzhVar2.zzO(cursor4.getLong(11));
        zzhVar2.zzQ(cursor4.getLong(12));
        zzhVar2.zzS(cursor4.getLong(13));
        zzhVar2.zzU(cursor4.getLong(14));
        zzhVar2.zzI(cursor4.getLong(15));
        zzhVar2.zzK(cursor4.getLong(16));
        zzhVar2.zzu(!cursor4.isNull(17) ? SieveCacheKt.NodeMetaAndPreviousMask : cursor4.getInt(17));
        zzhVar2.zzm(cursor4.getString(18));
        zzhVar2.zzY(cursor4.getLong(19));
        zzhVar2.zzW(cursor4.getLong(20));
        zzhVar2.zzab(cursor4.getString(21));
        if (!cursor4.isNull(23)) {
            z2 = false;
            zzhVar2.zzad(z2);
            zzhVar2.zzC(!cursor4.isNull(25) ? 0L : cursor4.getLong(25));
            if (!cursor4.isNull(26)) {
            }
            if (zzpfVar.zzB(str).zzo(zzjjVar)) {
            }
            zzhVar2.zzaj(cursor4.isNull(29) && cursor4.getInt(29) != 0);
            zzhVar2.zzaE(cursor4.getLong(39));
            zzhVar2.zzaz(cursor4.getString(36));
            zzhVar2.zzal(cursor4.getLong(30));
            zzhVar2.zzan(cursor4.getLong(31));
            zzql.zza();
            zzibVar = this.zzu;
            if (zzibVar.zzc().zzp(str, zzfx.zzaP)) {
            }
            zzhVar2.zzar(cursor4.isNull(33) && cursor4.getInt(33) != 0);
            if (cursor4.isNull(34)) {
            }
            zzhVar2.zzaf(valueOf);
            zzhVar2.zzaB(cursor4.getInt(37));
            zzhVar2.zzaD(cursor4.getInt(38));
            zzhVar2.zzaG(!cursor4.isNull(40) ? "" : (String) Preconditions.checkNotNull(cursor4.getString(40)));
            if (!cursor4.isNull(41)) {
            }
            if (!cursor4.isNull(42)) {
            }
            zzhVar2.zzaI(cursor4.getBlob(43));
            if (!cursor4.isNull(44)) {
            }
            zzhVar2.zzb();
            if (cursor4.moveToNext()) {
            }
            if (cursor4 != null) {
            }
            return zzhVar2;
        }
        z2 = true;
        zzhVar2.zzad(z2);
        zzhVar2.zzC(!cursor4.isNull(25) ? 0L : cursor4.getLong(25));
        if (!cursor4.isNull(26)) {
        }
        if (zzpfVar.zzB(str).zzo(zzjjVar)) {
        }
        zzhVar2.zzaj(cursor4.isNull(29) && cursor4.getInt(29) != 0);
        zzhVar2.zzaE(cursor4.getLong(39));
        zzhVar2.zzaz(cursor4.getString(36));
        zzhVar2.zzal(cursor4.getLong(30));
        zzhVar2.zzan(cursor4.getLong(31));
        zzql.zza();
        zzibVar = this.zzu;
        if (zzibVar.zzc().zzp(str, zzfx.zzaP)) {
        }
        zzhVar2.zzar(cursor4.isNull(33) && cursor4.getInt(33) != 0);
        if (cursor4.isNull(34)) {
        }
        zzhVar2.zzaf(valueOf);
        zzhVar2.zzaB(cursor4.getInt(37));
        zzhVar2.zzaD(cursor4.getInt(38));
        zzhVar2.zzaG(!cursor4.isNull(40) ? "" : (String) Preconditions.checkNotNull(cursor4.getString(40)));
        if (!cursor4.isNull(41)) {
        }
        if (!cursor4.isNull(42)) {
        }
        zzhVar2.zzaI(cursor4.getBlob(43));
        if (!cursor4.isNull(44)) {
        }
        zzhVar2.zzb();
        if (cursor4.moveToNext()) {
        }
        if (cursor4 != null) {
        }
        return zzhVar2;
    }

    public final void zzv(zzh zzhVar, boolean z, boolean z2) {
        Preconditions.checkNotNull(zzhVar);
        zzg();
        zzay();
        String zzc2 = zzhVar.zzc();
        Preconditions.checkNotNull(zzc2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzc2);
        if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzg.zzB(zzc2).zzo(zzjj.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", zzhVar.zzd());
        }
        contentValues.put("gmp_app_id", zzhVar.zzf());
        zzpf zzpfVar = this.zzg;
        if (zzpfVar.zzB(zzc2).zzo(zzjj.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzhVar.zzj());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzG()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzn()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzp()));
        contentValues.put("app_version", zzhVar.zzr());
        contentValues.put("app_store", zzhVar.zzv());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzx()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzz()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzD()));
        contentValues.put("day", Long.valueOf(zzhVar.zzN()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzP()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzR()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzT()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzH()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzJ()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zzt()));
        contentValues.put("firebase_instance_id", zzhVar.zzl());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zzX()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzV()));
        contentValues.put("health_monitor_sample", zzhVar.zzZ());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzac()));
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzB()));
        if (zzpfVar.zzB(zzc2).zzo(zzjj.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzhVar.zzh());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.zzai()));
        contentValues.put("target_os_version", Long.valueOf(zzhVar.zzak()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.zzam()));
        zzql.zza();
        zzib zzibVar = this.zzu;
        if (zzibVar.zzc().zzp(zzc2, zzfx.zzaP)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzhVar.zzao()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzhVar.zzaw()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzhVar.zzaq()));
        contentValues.put("npa_metadata_value", zzhVar.zzae());
        contentValues.put("bundle_delivery_index", Long.valueOf(zzhVar.zzaF()));
        contentValues.put("sgtm_preview_key", zzhVar.zzay());
        contentValues.put("dma_consent_state", Integer.valueOf(zzhVar.zzaA()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzhVar.zzaC()));
        contentValues.put("serialized_npa_metadata", zzhVar.zzaH());
        contentValues.put("client_upload_eligibility", Integer.valueOf(zzhVar.zzaL()));
        List zzag = zzhVar.zzag();
        if (zzag != null) {
            if (zzag.isEmpty()) {
                zzibVar.zzaV().zze().zzb("Safelisted events should not be an empty list. appId", zzc2);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(StringUtils.COMMA, zzag));
            }
        }
        com.google.android.gms.internal.measurement.zzpn.zza();
        if (zzibVar.zzc().zzp(null, zzfx.zzaK) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", zzhVar.zzas());
        contentValues.put("unmatched_uwa", zzhVar.zzau());
        contentValues.put("ad_campaign_info", zzhVar.zzaJ());
        try {
            SQLiteDatabase zze2 = zze();
            if (zze2.update("apps", contentValues, "app_id = ?", new String[]{zzc2}) == 0 && zze2.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzibVar.zzaV().zzb().zzb("Failed to insert/update app (got -1). appId", zzgt.zzl(zzc2));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing app. appId", zzgt.zzl(zzc2), e);
        }
    }

    public final zzar zzw(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return zzx(j, str, 1L, false, false, z3, false, z5, z6, z7);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzar zzx(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Cursor cursor;
        Cursor cursor2;
        String[] strArr;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        String[] strArr2 = {str};
        zzar zzarVar = new zzar();
        try {
            try {
                SQLiteDatabase zze2 = zze();
                cursor2 = zze2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursor2.moveToFirst()) {
                        this.zzu.zzaV().zze().zzb("Not updating daily counts, app is not known. appId", zzgt.zzl(str));
                    } else {
                        if (cursor2.getLong(0) == j) {
                            strArr = strArr2;
                            zzarVar.zzb = cursor2.getLong(1);
                            zzarVar.zza = cursor2.getLong(2);
                            zzarVar.zzc = cursor2.getLong(3);
                            zzarVar.zzd = cursor2.getLong(4);
                            zzarVar.zze = cursor2.getLong(5);
                            zzarVar.zzf = cursor2.getLong(6);
                            zzarVar.zzg = cursor2.getLong(7);
                        } else {
                            strArr = strArr2;
                        }
                        if (z) {
                            zzarVar.zzb += j2;
                        }
                        if (z2) {
                            zzarVar.zza += j2;
                        }
                        if (z3) {
                            zzarVar.zzc += j2;
                        }
                        if (z4) {
                            zzarVar.zzd += j2;
                        }
                        if (z5) {
                            zzarVar.zze += j2;
                        }
                        if (z6) {
                            zzarVar.zzf += j2;
                        }
                        if (z7) {
                            zzarVar.zzg += j2;
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("day", Long.valueOf(j));
                        contentValues.put("daily_public_events_count", Long.valueOf(zzarVar.zza));
                        contentValues.put("daily_events_count", Long.valueOf(zzarVar.zzb));
                        contentValues.put("daily_conversions_count", Long.valueOf(zzarVar.zzc));
                        contentValues.put("daily_error_events_count", Long.valueOf(zzarVar.zzd));
                        contentValues.put("daily_realtime_events_count", Long.valueOf(zzarVar.zze));
                        contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzarVar.zzf));
                        contentValues.put("daily_registered_triggers_count", Long.valueOf(zzarVar.zzg));
                        zze2.update("apps", contentValues, "app_id=?", strArr);
                    }
                } catch (SQLiteException e) {
                    e = e;
                    this.zzu.zzaV().zzb().zzc("Error updating daily counts. appId", zzgt.zzl(str), e);
                    if (cursor2 != null) {
                    }
                    return zzarVar;
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
        return zzarVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzaq zzy(String str) {
        Throwable th;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        Cursor cursor2 = null;
        try {
            cursor = zze().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (cursor.moveToFirst()) {
                        byte[] blob = cursor.getBlob(0);
                        String string = cursor.getString(1);
                        String string2 = cursor.getString(2);
                        if (cursor.moveToNext()) {
                            this.zzu.zzaV().zzb().zzb("Got multiple records for app config, expected one. appId", zzgt.zzl(str));
                        }
                        if (blob != null) {
                            zzaq zzaqVar = new zzaq(blob, string, string2);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return zzaqVar;
                        }
                    }
                } catch (SQLiteException e) {
                    e = e;
                    this.zzu.zzaV().zzb().zzc("Error querying remote config. appId", zzgt.zzl(str), e);
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

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0043, code lost:
        if (r3 > (com.google.android.gms.measurement.internal.zzal.zzI() + r1)) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzz(com.google.android.gms.internal.measurement.zzid zzidVar, boolean z) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzidVar);
        Preconditions.checkNotEmpty(zzidVar.zzA());
        Preconditions.checkState(zzidVar.zzn());
        zzI();
        zzib zzibVar = this.zzu;
        long currentTimeMillis = zzibVar.zzaZ().currentTimeMillis();
        long zzo = zzidVar.zzo();
        zzibVar.zzc();
        if (zzo >= currentTimeMillis - zzal.zzI()) {
            long zzo2 = zzidVar.zzo();
            zzibVar.zzc();
        }
        zzibVar.zzaV().zze().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgt.zzl(zzidVar.zzA()), Long.valueOf(currentTimeMillis), Long.valueOf(zzidVar.zzo()));
        try {
            byte[] zzv = this.zzg.zzp().zzv(zzidVar.zzcc());
            zzib zzibVar2 = this.zzu;
            zzibVar2.zzaV().zzk().zzb("Saving bundle, size", Integer.valueOf(zzv.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzidVar.zzA());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzidVar.zzo()));
            contentValues.put("data", zzv);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzidVar.zzaa()) {
                contentValues.put("retry_count", Integer.valueOf(zzidVar.zzab()));
            }
            try {
                if (zze().insert("queue", null, contentValues) == -1) {
                    zzibVar2.zzaV().zzb().zzb("Failed to insert bundle (got -1). appId", zzgt.zzl(zzidVar.zzA()));
                    return false;
                }
                return true;
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzc("Error storing bundle. appId", zzgt.zzl(zzidVar.zzA()), e);
                return false;
            }
        } catch (IOException e2) {
            this.zzu.zzaV().zzb().zzc("Data loss. Failed to serialize bundle. appId", zzgt.zzl(zzidVar.zzA()), e2);
            return false;
        }
    }
}
