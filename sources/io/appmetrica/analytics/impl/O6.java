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
public final class O6 {

    /* renamed from: a  reason: collision with root package name */
    public final CounterConfigurationReporterType f617a;
    public final C0554rj b;

    public O6(CounterConfigurationReporterType counterConfigurationReporterType) {
        this(counterConfigurationReporterType, C0620ua.k().w());
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
    public final M6 a(SQLiteDatabase sQLiteDatabase, String str, int i, String str2, boolean z) {
        Cursor cursor;
        ArrayList<ContentValues> arrayList;
        C0554rj c0554rj;
        C0505pj c0505pj;
        U3 u3;
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
                    Vj vj = AbstractC0604tj.f1136a;
                    vj.getClass();
                    vj.a(new C0629uj("select_rows_to_delete_exception", th));
                    no.a(cursor);
                    arrayList = null;
                    int i2 = sQLiteDatabase.delete("events", str, null);
                    if (arrayList != null) {
                    }
                    return new M6(arrayList, i2);
                } finally {
                    no.a(cursor);
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
                if (arrayList != null && arrayList.size() != 0 && i22 == arrayList.size() && z && str2 != null && (c0554rj = this.b) != null) {
                    CounterConfigurationReporterType counterConfigurationReporterType = this.f617a;
                    synchronized (c0554rj) {
                        c0505pj = (C0505pj) c0554rj.c.get(str2);
                        if (c0505pj == null) {
                            c0505pj = new C0505pj(str2, c0554rj.b, counterConfigurationReporterType, c0554rj.f1098a);
                            c0554rj.c.put(str2, c0505pj);
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
                                EnumC0320ib a2 = EnumC0320ib.a(asInteger2.intValue());
                                if (a2 == null) {
                                    Map map = Uf.f719a;
                                    num = null;
                                } else {
                                    num = (Integer) Uf.c.get(a2);
                                }
                                jSONArray2.put(num);
                            }
                        }
                        jSONObject.put("global_number", jSONArray).put("event_type", jSONArray2);
                        JSONObject put = new JSONObject().put("details", new JSONObject().put("reason", N6.a(i)).put("cleared", jSONObject).put("actual_deleted_number", i22));
                        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str2);
                        String jSONObject2 = put.toString();
                        Set set = D9.f438a;
                        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
                        u3 = new U3(jSONObject2, "", 12290, 0, orCreatePublicLogger);
                    } catch (Throwable unused) {
                        u3 = null;
                    }
                    if (u3 != null && c0505pj.c != null) {
                        try {
                            CounterConfiguration counterConfiguration = new CounterConfiguration(c0505pj.f1058a);
                            counterConfiguration.setReporterType(c0505pj.c);
                            c0505pj.d.f1116a.reportData(1, u3.d(new Kh(new Gf(c0505pj.b, (ResultReceiver) null), counterConfiguration, new I8(new C0656vl(LoggerStorage.getOrCreatePublicLogger(c0505pj.f1058a), "Crash Environment")), null).c()));
                        } catch (Throwable unused2) {
                        }
                    }
                }
                return new M6(arrayList, i22);
            }
        }
        arrayList = null;
        int i222 = sQLiteDatabase.delete("events", str, null);
        if (arrayList != null) {
            CounterConfigurationReporterType counterConfigurationReporterType2 = this.f617a;
            synchronized (c0554rj) {
            }
        }
        return new M6(arrayList, i222);
    }

    public O6(CounterConfigurationReporterType counterConfigurationReporterType, C0554rj c0554rj) {
        this.f617a = counterConfigurationReporterType;
        this.b = c0554rj;
    }
}
