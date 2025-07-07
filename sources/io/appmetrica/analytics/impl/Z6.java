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
    public final CounterConfigurationReporterType f732a;
    public final C0694wj b;

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
        C0694wj c0694wj;
        C0644uj c0644uj;
        C0331i4 c0331i4;
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
                    Zj zj = AbstractC0744yj.f1148a;
                    zj.getClass();
                    zj.a(new C0769zj("select_rows_to_delete_exception", th));
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
                if (arrayList != null && arrayList.size() != 0 && i22 == arrayList.size() && z && str2 != null && (c0694wj = this.b) != null) {
                    CounterConfigurationReporterType counterConfigurationReporterType = this.f732a;
                    synchronized (c0694wj) {
                        c0644uj = (C0644uj) c0694wj.c.get(str2);
                        if (c0644uj == null) {
                            c0644uj = new C0644uj(str2, c0694wj.b, counterConfigurationReporterType, c0694wj.f1109a);
                            c0694wj.c.put(str2, c0644uj);
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
                                EnumC0636ub a2 = EnumC0636ub.a(asInteger2.intValue());
                                if (a2 == null) {
                                    Map map = AbstractC0140ag.f754a;
                                    num = null;
                                } else {
                                    num = (Integer) AbstractC0140ag.c.get(a2);
                                }
                                jSONArray2.put(num);
                            }
                        }
                        jSONObject.put("global_number", jSONArray).put("event_type", jSONArray2);
                        JSONObject put = new JSONObject().put("details", new JSONObject().put("reason", Y6.a(i)).put("cleared", jSONObject).put("actual_deleted_number", i22));
                        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str2);
                        String jSONObject2 = put.toString();
                        Set set = O9.f564a;
                        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
                        c0331i4 = new C0331i4(jSONObject2, "", 12290, 0, orCreatePublicLogger);
                    } catch (Throwable unused) {
                        c0331i4 = null;
                    }
                    if (c0331i4 != null && c0644uj.c != null) {
                        try {
                            CounterConfiguration counterConfiguration = new CounterConfiguration(c0644uj.f1078a);
                            counterConfiguration.setReporterType(c0644uj.c);
                            c0644uj.d.f1128a.reportData(1, c0331i4.d(new Qh(new Nf(c0644uj.b, (ResultReceiver) null), counterConfiguration, new T8(new C0497ol(LoggerStorage.getOrCreatePublicLogger(c0644uj.f1078a), "Crash Environment")), null).c()));
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
            CounterConfigurationReporterType counterConfigurationReporterType2 = this.f732a;
            synchronized (c0694wj) {
            }
        }
        return new X6(arrayList, i222);
    }

    public Z6(CounterConfigurationReporterType counterConfigurationReporterType, C0694wj c0694wj) {
        this.f732a = counterConfigurationReporterType;
        this.b = c0694wj;
    }
}
