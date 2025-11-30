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
/* loaded from: classes5.dex */
public final class I6 {

    /* renamed from: a  reason: collision with root package name */
    public final CounterConfigurationReporterType f520a;

    public I6(CounterConfigurationReporterType counterConfigurationReporterType) {
        this.f520a = counterConfigurationReporterType;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|2|3|(3:63|64|(9:66|(2:69|67)|70|6|7|8|(2:15|(8:18|7a|26|27|(4:30|(5:34|35|(1:37)(1:41)|38|39)|40|28)|44|45|(2:49|50)))|59|60))|5|6|7|8|(4:10|12|15|(2:18|7a))|59|60|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        r10 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final G6 a(SQLiteDatabase sQLiteDatabase, String str, int i, String str2, boolean z) {
        Cursor cursor;
        ArrayList<ContentValues> arrayList;
        C0455nj c0455nj;
        C0405lj c0405lj;
        N3 n3;
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
                    Rj rj = AbstractC0505pj.f1071a;
                    rj.getClass();
                    rj.a(new C0530qj("select_rows_to_delete_exception", th));
                    mo.a(cursor);
                    arrayList = null;
                    int i2 = sQLiteDatabase.delete("events", str, null);
                    if (arrayList != null) {
                    }
                    return new G6(arrayList, i2);
                } finally {
                    mo.a(cursor);
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
                if (arrayList != null && arrayList.size() != 0 && i22 == arrayList.size() && z) {
                    c0455nj = C0471oa.I.f;
                    if (str2 != null && c0455nj != null) {
                        CounterConfigurationReporterType counterConfigurationReporterType = this.f520a;
                        synchronized (c0455nj) {
                            c0405lj = (C0405lj) c0455nj.c.get(str2);
                            if (c0405lj == null) {
                                c0405lj = new C0405lj(str2, c0455nj.b, counterConfigurationReporterType, c0455nj.f1033a);
                                c0455nj.c.put(str2, c0405lj);
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
                                    EnumC0165cb a2 = EnumC0165cb.a(asInteger2.intValue());
                                    if (a2 == null) {
                                        Map map = Qf.f650a;
                                        num = null;
                                    } else {
                                        num = (Integer) Qf.c.get(a2);
                                    }
                                    jSONArray2.put(num);
                                }
                            }
                            jSONObject.put("global_number", jSONArray).put("event_type", jSONArray2);
                            JSONObject put = new JSONObject().put("details", new JSONObject().put("reason", H6.a(i)).put("cleared", jSONObject).put("actual_deleted_number", i22));
                            PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str2);
                            String jSONObject2 = put.toString();
                            Set set = AbstractC0694x9.f1197a;
                            EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_UNDEFINED;
                            n3 = new N3(jSONObject2, "", 12290, 0, orCreatePublicLogger);
                        } catch (Throwable unused) {
                            n3 = null;
                        }
                        if (n3 != null && c0405lj.c != null) {
                            try {
                                CounterConfiguration counterConfiguration = new CounterConfiguration(c0405lj.f995a);
                                counterConfiguration.setReporterType(c0405lj.c);
                                ((C1) c0405lj.d.f1052a).reportData(1, n3.d(new Gh(new Cf(c0405lj.b, (ResultReceiver) null), counterConfiguration, new E8(new C0581sl(LoggerStorage.getOrCreatePublicLogger(c0405lj.f995a), "Crash Environment")), null).c()));
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                return new G6(arrayList, i22);
            }
        }
        arrayList = null;
        int i222 = sQLiteDatabase.delete("events", str, null);
        if (arrayList != null) {
            c0455nj = C0471oa.I.f;
            if (str2 != null) {
                CounterConfigurationReporterType counterConfigurationReporterType2 = this.f520a;
                synchronized (c0455nj) {
                }
            }
        }
        return new G6(arrayList, i222);
    }
}
