package ru.rustore.sdk.metrics.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class B {

    /* renamed from: a  reason: collision with root package name */
    public final C0834w f1572a;
    public final C0835x b;
    public final C0837z c;
    public final A d;

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function1<String, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1573a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(String str) {
            String it = str;
            Intrinsics.checkNotNullParameter(it, "it");
            return "'" + it + '\'';
        }
    }

    public B(C0834w migrationDtoVer1Factory, C0835x migrationDtoVer1Serializer, C0837z migrationDtoVer2Mapper, A migrationDtoVer2Serializer) {
        Intrinsics.checkNotNullParameter(migrationDtoVer1Factory, "migrationDtoVer1Factory");
        Intrinsics.checkNotNullParameter(migrationDtoVer1Serializer, "migrationDtoVer1Serializer");
        Intrinsics.checkNotNullParameter(migrationDtoVer2Mapper, "migrationDtoVer2Mapper");
        Intrinsics.checkNotNullParameter(migrationDtoVer2Serializer, "migrationDtoVer2Serializer");
        this.f1572a = migrationDtoVer1Factory;
        this.b = migrationDtoVer1Serializer;
        this.c = migrationDtoVer2Mapper;
        this.d = migrationDtoVer2Serializer;
    }

    public final void a(SQLiteDatabase db) {
        B b = this;
        Intrinsics.checkNotNullParameter(db, "db");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        Cursor rawQuery = db.rawQuery("\n                SELECT * FROM metrics_event_table\n                ", new String[0]);
        try {
            int columnIndexOrThrow = rawQuery.getColumnIndexOrThrow(CommonUrlParts.UUID);
            int columnIndexOrThrow2 = rawQuery.getColumnIndexOrThrow("metrics_event");
            while (rawQuery.moveToNext()) {
                C0834w c0834w = b.f1572a;
                String value = rawQuery.getString(columnIndexOrThrow);
                Intrinsics.checkNotNullExpressionValue(value, "cursor.getString(uuidColumnIndex)");
                Intrinsics.checkNotNullParameter(value, "value");
                byte[] blob = rawQuery.getBlob(columnIndexOrThrow2);
                Intrinsics.checkNotNullExpressionValue(blob, "cursor.getBlob(serializedMetricsEventColumnIndex)");
                String decodeToString = StringsKt.decodeToString(blob);
                c0834w.getClass();
                arrayList.add(C0834w.a(value, decodeToString));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(rawQuery, null);
            if (arrayList.isEmpty()) {
                return;
            }
            StringBuilder sb = new StringBuilder("\n                UPDATE metrics_event_table\n                SET metrics_event = CASE\n             ");
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0833v dto = (C0833v) it.next();
                C0837z c0837z = b.c;
                c0837z.getClass();
                Intrinsics.checkNotNullParameter(dto, "dto");
                String str = dto.f1627a;
                String str2 = dto.b;
                Map<String, String> map = dto.c;
                c0837z.f1629a.getClass();
                C0836y dto2 = new C0836y(str, str2, map, System.currentTimeMillis());
                b.b.getClass();
                Intrinsics.checkNotNullParameter(dto, "dto");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", dto.b);
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : dto.c.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("data", jSONObject2);
                String jSONObject3 = jSONObject.toString(i);
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObject.toString(0)");
                byte[] bytes = jSONObject3.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                Intrinsics.checkNotNullParameter(bytes, "<this>");
                String joinToString$default = ArraysKt.joinToString$default(bytes, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) C0813a.f1600a, 30, (Object) null);
                b.d.getClass();
                Intrinsics.checkNotNullParameter(dto2, "dto");
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("name", dto2.b);
                JSONObject jSONObject5 = new JSONObject();
                for (Map.Entry<String, String> entry2 : dto2.c.entrySet()) {
                    jSONObject5.put(entry2.getKey(), entry2.getValue());
                }
                jSONObject4.put("data", jSONObject5);
                jSONObject4.put("time", dto2.d);
                String jSONObject6 = jSONObject4.toString(0);
                Intrinsics.checkNotNullExpressionValue(jSONObject6, "jsonObject.toString(0)");
                byte[] bytes2 = jSONObject6.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                Intrinsics.checkNotNullParameter(bytes2, "<this>");
                arrayList2.add(dto.f1627a);
                sb.append("\n                WHEN metrics_event = x'" + joinToString$default + "' THEN x'" + ArraysKt.joinToString$default(bytes2, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) C0813a.f1600a, 30, (Object) null) + "'\n            ");
                i = 0;
                b = this;
            }
            sb.append("\n                END\n                WHERE uuid IN (" + CollectionsKt.joinToString$default(arrayList2, null, null, null, 0, null, a.f1573a, 31, null) + ")\n            ");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "updateQuery.toString()");
            db.execSQL(StringsKt.trimIndent(sb2));
        } finally {
        }
    }
}
