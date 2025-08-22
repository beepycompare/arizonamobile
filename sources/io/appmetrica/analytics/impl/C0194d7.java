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
/* renamed from: io.appmetrica.analytics.impl.d7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0194d7 {

    /* renamed from: a  reason: collision with root package name */
    public final CounterConfigurationReporterType f825a;
    public final Ej b;

    public C0194d7(CounterConfigurationReporterType counterConfigurationReporterType) {
        this(counterConfigurationReporterType, Ka.j().v());
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
    public final C0142b7 a(SQLiteDatabase sQLiteDatabase, String str, int i, String str2, boolean z) {
        Cursor cursor;
        ArrayList<ContentValues> arrayList;
        Ej ej;
        Cj cj;
        C0320i4 c0320i4;
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
                    C0310hk c0310hk = Gj.f460a;
                    c0310hk.getClass();
                    c0310hk.a(new Hj("select_rows_to_delete_exception", th));
                    no.a(cursor);
                    arrayList = null;
                    int i2 = sQLiteDatabase.delete("events", str, null);
                    if (arrayList != null) {
                    }
                    return new C0142b7(arrayList, i2);
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
                if (arrayList != null && arrayList.size() != 0 && i22 == arrayList.size() && z && str2 != null && (ej = this.b) != null) {
                    CounterConfigurationReporterType counterConfigurationReporterType = this.f825a;
                    synchronized (ej) {
                        cj = (Cj) ej.c.get(str2);
                        if (cj == null) {
                            cj = new Cj(str2, ej.b, counterConfigurationReporterType, ej.f417a);
                            ej.c.put(str2, cj);
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
                                EnumC0728yb a2 = EnumC0728yb.a(asInteger2.intValue());
                                if (a2 == null) {
                                    Map map = AbstractC0306hg.f889a;
                                    num = null;
                                } else {
                                    num = (Integer) AbstractC0306hg.c.get(a2);
                                }
                                jSONArray2.put(num);
                            }
                        }
                        jSONObject.put("global_number", jSONArray).put("event_type", jSONArray2);
                        JSONObject put = new JSONObject().put("details", new JSONObject().put("reason", AbstractC0168c7.a(i)).put("cleared", jSONObject).put("actual_deleted_number", i22));
                        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str2);
                        String jSONObject2 = put.toString();
                        Set set = T9.f659a;
                        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
                        c0320i4 = new C0320i4(jSONObject2, "", 12290, 0, orCreatePublicLogger);
                    } catch (Throwable unused) {
                        c0320i4 = null;
                    }
                    if (c0320i4 != null && cj.c != null) {
                        try {
                            CounterConfiguration counterConfiguration = new CounterConfiguration(cj.f382a);
                            counterConfiguration.setReporterType(cj.c);
                            cj.d.f438a.reportData(1, c0320i4.d(new Xh(new Rf(cj.b, (ResultReceiver) null), counterConfiguration, new Y8(new C0688wl(LoggerStorage.getOrCreatePublicLogger(cj.f382a), "Crash Environment")), null).c()));
                        } catch (Throwable unused2) {
                        }
                    }
                }
                return new C0142b7(arrayList, i22);
            }
        }
        arrayList = null;
        int i222 = sQLiteDatabase.delete("events", str, null);
        if (arrayList != null) {
            CounterConfigurationReporterType counterConfigurationReporterType2 = this.f825a;
            synchronized (ej) {
            }
        }
        return new C0142b7(arrayList, i222);
    }

    public C0194d7(CounterConfigurationReporterType counterConfigurationReporterType, Ej ej) {
        this.f825a = counterConfigurationReporterType;
        this.b = ej;
    }
}
