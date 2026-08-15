package ru.rustore.sdk.metrics.internal;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ru.rustore.sdk.metrics.MetricsEvent;
import ru.rustore.sdk.metrics.internal.W;
/* loaded from: classes6.dex */
public final class T {

    /* renamed from: a  reason: collision with root package name */
    public final N f1526a;
    public final S b;

    public T(N persistentMetricsEventRepository, S remoteMetricsEventRepository) {
        Intrinsics.checkNotNullParameter(persistentMetricsEventRepository, "persistentMetricsEventRepository");
        Intrinsics.checkNotNullParameter(remoteMetricsEventRepository, "remoteMetricsEventRepository");
        this.f1526a = persistentMetricsEventRepository;
        this.b = remoteMetricsEventRepository;
    }

    public final W a() {
        String str;
        String a2;
        N n = this.f1526a;
        I i = n.f1522a;
        i.getClass();
        String trimIndent = StringsKt.trimIndent("\n            SELECT * FROM metrics_event_table\n            LIMIT 10\n        ");
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = ((SQLiteDatabase) i.c.getValue()).rawQuery(trimIndent, new String[0]);
        try {
            int columnIndexOrThrow = rawQuery.getColumnIndexOrThrow(CommonUrlParts.UUID);
            int columnIndexOrThrow2 = rawQuery.getColumnIndexOrThrow("metrics_event");
            while (rawQuery.moveToNext()) {
                String value = rawQuery.getString(columnIndexOrThrow);
                Intrinsics.checkNotNullExpressionValue(value, "cursor.getString(uuidColumnIndex)");
                Intrinsics.checkNotNullParameter(value, "value");
                byte[] blob = rawQuery.getBlob(columnIndexOrThrow2);
                Intrinsics.checkNotNullExpressionValue(blob, "cursor.getBlob(serializedMetricsEventColumnIndex)");
                arrayList.add(new J(value, blob));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(rawQuery, null);
            List<J> list = CollectionsKt.toList(arrayList);
            i.b.a(new H(list));
            L l = n.c;
            ArrayList values = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (J dto : list) {
                l.getClass();
                Intrinsics.checkNotNullParameter(dto, "dto");
                String str2 = dto.f1518a;
                C0823t c0823t = l.f1520a;
                String jsonString = StringsKt.decodeToString(dto.b);
                c0823t.getClass();
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                JSONObject jSONObject = new JSONObject(jsonString);
                String string = jSONObject.getString("name");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(NAME_KEY)");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.getJSONObject(DATA_KEY)");
                Intrinsics.checkNotNullParameter(jSONObject2, "<this>");
                ArrayList arrayList2 = new ArrayList();
                Iterator<String> keys = jSONObject2.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "keys()");
                while (keys.hasNext()) {
                    String next = keys.next();
                    arrayList2.add(TuplesKt.to(next, jSONObject2.get(next).toString()));
                }
                values.add(new D(str2, new MetricsEvent(string, MapsKt.toMap(arrayList2), jSONObject.getLong("time"))));
            }
            if (values.isEmpty()) {
                return W.a.f1529a;
            }
            S s = this.b;
            s.getClass();
            Intrinsics.checkNotNullParameter(values, "values");
            String value2 = s.b.f1509a.getPackageName();
            Intrinsics.checkNotNullExpressionValue(value2, "context.packageName");
            Intrinsics.checkNotNullParameter(value2, "value");
            b0 b0Var = s.f1525a;
            SharedPreferences sharedPreferences = b0Var.f1536a.f1532a;
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
            String value3 = sharedPreferences.getString("USER_ID_KEY", null);
            if (value3 != null) {
                Intrinsics.checkNotNullParameter(value3, "value");
            } else {
                value3 = null;
            }
            if (value3 == null) {
                synchronized (b0.c) {
                    SharedPreferences sharedPreferences2 = b0Var.f1536a.f1532a;
                    Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "sharedPreferences");
                    String value4 = sharedPreferences2.getString("USER_ID_KEY", null);
                    if (value4 != null) {
                        Intrinsics.checkNotNullParameter(value4, "value");
                    } else {
                        value4 = null;
                    }
                    a2 = value4 == null ? b0Var.a() : value4;
                }
                str = a2;
            } else {
                str = value3;
            }
            d0 d0Var = (d0) s.d.b.getValue();
            String str3 = d0Var != null ? d0Var.f1539a : null;
            ArrayList values2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
            Iterator it = values.iterator();
            while (it.hasNext()) {
                D d = (D) it.next();
                values2.add(new P(value2, d.f1510a, str, str3, d.b));
            }
            O o = s.c;
            o.getClass();
            Intrinsics.checkNotNullParameter(values2, "values");
            o.f1523a.b(values2);
            return new W.b(values);
        } finally {
        }
    }
}
