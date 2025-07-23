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
public final class C0175c7 {

    /* renamed from: a  reason: collision with root package name */
    public final CounterConfigurationReporterType f795a;
    public final C0763zj b;

    public C0175c7(CounterConfigurationReporterType counterConfigurationReporterType) {
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
    public final C0123a7 a(SQLiteDatabase sQLiteDatabase, String str, int i, String str2, boolean z) {
        Cursor cursor;
        ArrayList<ContentValues> arrayList;
        C0763zj c0763zj;
        C0713xj c0713xj;
        C0325i4 c0325i4;
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
                    C0188ck c0188ck = Bj.f361a;
                    c0188ck.getClass();
                    c0188ck.a(new Cj("select_rows_to_delete_exception", th));
                    io.a(cursor);
                    arrayList = null;
                    int i2 = sQLiteDatabase.delete("events", str, null);
                    if (arrayList != null) {
                    }
                    return new C0123a7(arrayList, i2);
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
                if (arrayList != null && arrayList.size() != 0 && i22 == arrayList.size() && z && str2 != null && (c0763zj = this.b) != null) {
                    CounterConfigurationReporterType counterConfigurationReporterType = this.f795a;
                    synchronized (c0763zj) {
                        c0713xj = (C0713xj) c0763zj.c.get(str2);
                        if (c0713xj == null) {
                            c0713xj = new C0713xj(str2, c0763zj.b, counterConfigurationReporterType, c0763zj.f1174a);
                            c0763zj.c.put(str2, c0713xj);
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
                                EnumC0680wb a2 = EnumC0680wb.a(asInteger2.intValue());
                                if (a2 == null) {
                                    Map map = AbstractC0184cg.f798a;
                                    num = null;
                                } else {
                                    num = (Integer) AbstractC0184cg.c.get(a2);
                                }
                                jSONArray2.put(num);
                            }
                        }
                        jSONObject.put("global_number", jSONArray).put("event_type", jSONArray2);
                        JSONObject put = new JSONObject().put("details", new JSONObject().put("reason", AbstractC0149b7.a(i)).put("cleared", jSONObject).put("actual_deleted_number", i22));
                        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str2);
                        String jSONObject2 = put.toString();
                        Set set = R9.f620a;
                        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
                        c0325i4 = new C0325i4(jSONObject2, "", 12290, 0, orCreatePublicLogger);
                    } catch (Throwable unused) {
                        c0325i4 = null;
                    }
                    if (c0325i4 != null && c0713xj.c != null) {
                        try {
                            CounterConfiguration counterConfiguration = new CounterConfiguration(c0713xj.f1139a);
                            counterConfiguration.setReporterType(c0713xj.c);
                            c0713xj.d.f341a.reportData(1, c0325i4.d(new Sh(new Pf(c0713xj.b, (ResultReceiver) null), counterConfiguration, new W8(new C0565rl(LoggerStorage.getOrCreatePublicLogger(c0713xj.f1139a), "Crash Environment")), null).c()));
                        } catch (Throwable unused2) {
                        }
                    }
                }
                return new C0123a7(arrayList, i22);
            }
        }
        arrayList = null;
        int i222 = sQLiteDatabase.delete("events", str, null);
        if (arrayList != null) {
            CounterConfigurationReporterType counterConfigurationReporterType2 = this.f795a;
            synchronized (c0763zj) {
            }
        }
        return new C0123a7(arrayList, i222);
    }

    public C0175c7(CounterConfigurationReporterType counterConfigurationReporterType, C0763zj c0763zj) {
        this.f795a = counterConfigurationReporterType;
        this.b = c0763zj;
    }
}
