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
/* renamed from: io.appmetrica.analytics.impl.c7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0176c7 {

    /* renamed from: a  reason: collision with root package name */
    public final CounterConfigurationReporterType f795a;
    public final C0764zj b;

    public C0176c7(CounterConfigurationReporterType counterConfigurationReporterType) {
        this(counterConfigurationReporterType, Ia.j().v());
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
    public final C0124a7 a(SQLiteDatabase sQLiteDatabase, String str, int i, String str2, boolean z) {
        Cursor cursor;
        ArrayList<ContentValues> arrayList;
        C0764zj c0764zj;
        C0714xj c0714xj;
        C0326i4 c0326i4;
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
                    C0189ck c0189ck = Bj.f361a;
                    c0189ck.getClass();
                    c0189ck.a(new Cj("select_rows_to_delete_exception", th));
                    io.a(cursor);
                    arrayList = null;
                    int i2 = sQLiteDatabase.delete("events", str, null);
                    if (arrayList != null) {
                    }
                    return new C0124a7(arrayList, i2);
                } finally {
                    io.a(cursor);
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
                if (arrayList != null && arrayList.size() != 0 && i22 == arrayList.size() && z && str2 != null && (c0764zj = this.b) != null) {
                    CounterConfigurationReporterType counterConfigurationReporterType = this.f795a;
                    synchronized (c0764zj) {
                        c0714xj = (C0714xj) c0764zj.c.get(str2);
                        if (c0714xj == null) {
                            c0714xj = new C0714xj(str2, c0764zj.b, counterConfigurationReporterType, c0764zj.f1174a);
                            c0764zj.c.put(str2, c0714xj);
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
                                EnumC0681wb a2 = EnumC0681wb.a(asInteger2.intValue());
                                if (a2 == null) {
                                    Map map = AbstractC0185cg.f798a;
                                    num = null;
                                } else {
                                    num = (Integer) AbstractC0185cg.c.get(a2);
                                }
                                jSONArray2.put(num);
                            }
                        }
                        jSONObject.put("global_number", jSONArray).put("event_type", jSONArray2);
                        JSONObject put = new JSONObject().put("details", new JSONObject().put("reason", AbstractC0150b7.a(i)).put("cleared", jSONObject).put("actual_deleted_number", i22));
                        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str2);
                        String jSONObject2 = put.toString();
                        Set set = R9.f620a;
                        EnumC0681wb enumC0681wb = EnumC0681wb.EVENT_TYPE_UNDEFINED;
                        c0326i4 = new C0326i4(jSONObject2, "", 12290, 0, orCreatePublicLogger);
                    } catch (Throwable unused) {
                        c0326i4 = null;
                    }
                    if (c0326i4 != null && c0714xj.c != null) {
                        try {
                            CounterConfiguration counterConfiguration = new CounterConfiguration(c0714xj.f1139a);
                            counterConfiguration.setReporterType(c0714xj.c);
                            c0714xj.d.f341a.reportData(1, c0326i4.d(new Sh(new Pf(c0714xj.b, (ResultReceiver) null), counterConfiguration, new W8(new C0566rl(LoggerStorage.getOrCreatePublicLogger(c0714xj.f1139a), "Crash Environment")), null).c()));
                        } catch (Throwable unused2) {
                        }
                    }
                }
                return new C0124a7(arrayList, i22);
            }
        }
        arrayList = null;
        int i222 = sQLiteDatabase.delete("events", str, null);
        if (arrayList != null) {
            CounterConfigurationReporterType counterConfigurationReporterType2 = this.f795a;
            synchronized (c0764zj) {
            }
        }
        return new C0124a7(arrayList, i222);
    }

    public C0176c7(CounterConfigurationReporterType counterConfigurationReporterType, C0764zj c0764zj) {
        this.f795a = counterConfigurationReporterType;
        this.b = c0764zj;
    }
}
