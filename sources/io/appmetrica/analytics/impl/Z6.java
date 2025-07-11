package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.ResultReceiver;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Z6 {

    /* renamed from: a  reason: collision with root package name */
    public final CounterConfigurationReporterType f733a;
    public final C0686wj b;

    public Z6(CounterConfigurationReporterType counterConfigurationReporterType) {
        this(counterConfigurationReporterType, Ga.j().v());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|2|3|(3:63|64|(9:66|(2:69|67)|70|6|7|8|(8:18|78|26|27|(4:30|(5:34|35|(1:37)(1:41)|38|39)|40|28)|44|45|(2:49|50))|59|60))|5|6|7|8|(5:10|12|16|18|78)|59|60|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        r10 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final X6 a(SQLiteDatabase sQLiteDatabase, String str, int i, String str2, boolean z) {
        Cursor cursor;
        ArrayList<ContentValues> arrayList;
        C0686wj c0686wj;
        C0636uj c0636uj;
        C0323i4 c0323i4;
        Integer num;
        try {
            cursor = sQLiteDatabase.rawQuery(String.format("SELECT %s, %s, %s FROM %s WHERE %s", "global_number", "type", "event_description", "events", str), null);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor != null) {
            try {
            } catch (Throwable th2) {
                th = th2;
                try {
                    Zj zj = AbstractC0736yj.f1149a;
                    zj.getClass();
                    zj.a(new C0761zj("select_rows_to_delete_exception", th));
                    fo.a(cursor);
                    arrayList = null;
                    int i2 = sQLiteDatabase.delete("events", str, null);
                    if (arrayList != null) {
                    }
                    return new X6(arrayList, i2);
                } finally {
                    fo.a(cursor);
                }
            }
            if (cursor.getCount() > 0) {
                arrayList = new ArrayList(cursor.getCount());
                while (cursor.moveToNext()) {
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursor, contentValues);
                    arrayList.add(contentValues);
                }
                int i22 = sQLiteDatabase.delete("events", str, null);
                if (arrayList != null && arrayList.size() != 0 && i22 == arrayList.size() && z && str2 != null && (c0686wj = this.b) != null) {
                    CounterConfigurationReporterType counterConfigurationReporterType = this.f733a;
                    synchronized (c0686wj) {
                        c0636uj = (C0636uj) c0686wj.c.get(str2);
                        if (c0636uj == null) {
                            c0636uj = new C0636uj(str2, c0686wj.b, counterConfigurationReporterType, c0686wj.f1110a);
                            c0686wj.c.put(str2, c0636uj);
                        }
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        JSONArray jSONArray2 = new JSONArray();
                        for (ContentValues contentValues2 : arrayList) {
                            Integer asInteger = contentValues2.getAsInteger("global_number");
                            Integer asInteger2 = contentValues2.getAsInteger("type");
                            if (asInteger != null && asInteger2 != null) {
                                jSONArray.put(asInteger);
                                EnumC0628ub a2 = EnumC0628ub.a(asInteger2.intValue());
                                if (a2 == null) {
                                    Map map = AbstractC0132ag.f755a;
                                    num = null;
                                } else {
                                    num = (Integer) AbstractC0132ag.c.get(a2);
                                }
                                jSONArray2.put(num);
                            }
                        }
                        jSONObject.put("global_number", jSONArray).put("event_type", jSONArray2);
                        JSONObject put = new JSONObject().put("details", new JSONObject().put("reason", Y6.a(i)).put("cleared", jSONObject).put("actual_deleted_number", i22));
                        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str2);
                        String jSONObject2 = put.toString();
                        Set set = O9.f565a;
                        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
                        c0323i4 = new C0323i4(jSONObject2, "", 12290, 0, orCreatePublicLogger);
                    } catch (Throwable unused) {
                        c0323i4 = null;
                    }
                    if (c0323i4 != null && c0636uj.c != null) {
                        try {
                            CounterConfiguration counterConfiguration = new CounterConfiguration(c0636uj.f1079a);
                            counterConfiguration.setReporterType(c0636uj.c);
                            c0636uj.d.f1129a.reportData(1, c0323i4.d(new Qh(new Nf(c0636uj.b, (ResultReceiver) null), counterConfiguration, new T8(new C0489ol(LoggerStorage.getOrCreatePublicLogger(c0636uj.f1079a), "Crash Environment")), null).c()));
                        } catch (Throwable unused2) {
                        }
                    }
                }
                return new X6(arrayList, i22);
            }
        }
        arrayList = null;
        int i222 = sQLiteDatabase.delete("events", str, null);
        if (arrayList != null) {
            CounterConfigurationReporterType counterConfigurationReporterType2 = this.f733a;
            synchronized (c0686wj) {
            }
        }
        return new X6(arrayList, i222);
    }

    public Z6(CounterConfigurationReporterType counterConfigurationReporterType, C0686wj c0686wj) {
        this.f733a = counterConfigurationReporterType;
        this.b = c0686wj;
    }
}
