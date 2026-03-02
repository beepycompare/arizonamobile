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
public final class H6 {

    /* renamed from: a  reason: collision with root package name */
    public final CounterConfigurationReporterType f609a;

    public H6(CounterConfigurationReporterType counterConfigurationReporterType) {
        this.f609a = counterConfigurationReporterType;
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
    public final F6 a(SQLiteDatabase sQLiteDatabase, String str, int i, String str2, boolean z) {
        Cursor cursor;
        ArrayList<ContentValues> arrayList;
        C0432mj c0432mj;
        C0382kj c0382kj;
        M3 m3;
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
                    Qj qj = AbstractC0482oj.f1158a;
                    qj.getClass();
                    qj.a(new C0507pj("select_rows_to_delete_exception", th));
                    lo.a(cursor);
                    arrayList = null;
                    int i2 = sQLiteDatabase.delete("events", str, null);
                    if (arrayList != null) {
                    }
                    return new F6(arrayList, i2);
                } finally {
                    lo.a(cursor);
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
                    c0432mj = C0448na.I.f;
                    if (str2 != null && c0432mj != null) {
                        CounterConfigurationReporterType counterConfigurationReporterType = this.f609a;
                        synchronized (c0432mj) {
                            c0382kj = (C0382kj) c0432mj.c.get(str2);
                            if (c0382kj == null) {
                                c0382kj = new C0382kj(str2, c0432mj.b, counterConfigurationReporterType, c0432mj.f1120a);
                                c0432mj.c.put(str2, c0382kj);
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
                                    EnumC0142bb a2 = EnumC0142bb.a(asInteger2.intValue());
                                    if (a2 == null) {
                                        Map map = Pf.f738a;
                                        num = null;
                                    } else {
                                        num = (Integer) Pf.c.get(a2);
                                    }
                                    jSONArray2.put(num);
                                }
                            }
                            jSONObject.put("global_number", jSONArray).put("event_type", jSONArray2);
                            JSONObject put = new JSONObject().put("details", new JSONObject().put("reason", G6.a(i)).put("cleared", jSONObject).put("actual_deleted_number", i22));
                            PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str2);
                            String jSONObject2 = put.toString();
                            Set set = AbstractC0671w9.f1284a;
                            EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
                            m3 = new M3(jSONObject2, "", 12290, 0, orCreatePublicLogger);
                        } catch (Throwable unused) {
                            m3 = null;
                        }
                        if (m3 != null && c0382kj.c != null) {
                            try {
                                CounterConfiguration counterConfiguration = new CounterConfiguration(c0382kj.f1083a);
                                counterConfiguration.setReporterType(c0382kj.c);
                                ((B1) c0382kj.d.f1139a).reportData(1, m3.d(new Fh(new Bf(c0382kj.b, (ResultReceiver) null), counterConfiguration, new D8(new C0558rl(LoggerStorage.getOrCreatePublicLogger(c0382kj.f1083a), "Crash Environment")), null).c()));
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                return new F6(arrayList, i22);
            }
        }
        arrayList = null;
        int i222 = sQLiteDatabase.delete("events", str, null);
        if (arrayList != null) {
            c0432mj = C0448na.I.f;
            if (str2 != null) {
                CounterConfigurationReporterType counterConfigurationReporterType2 = this.f609a;
                synchronized (c0432mj) {
                }
            }
        }
        return new F6(arrayList, i222);
    }
}
