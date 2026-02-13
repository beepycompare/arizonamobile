package ru.rustore.sdk.metrics.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import ru.rustore.sdk.metrics.MetricsException;
import ru.rustore.sdk.metrics.internal.X;
/* loaded from: classes6.dex */
public final class I {

    /* renamed from: a  reason: collision with root package name */
    public final C0828o f1580a;
    public final InterfaceC0820g b;
    public final Lazy c;

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f1581a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(0);
            this.f1581a = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.f1581a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ J f1582a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(J j) {
            super(0);
            this.f1582a = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "Create row in storage " + ((Object) ("MetricsEventUuid(value=" + this.f1582a.f1583a + ')'));
        }
    }

    public I(C0828o metricsEventDataBaseHelper, X.b logger) {
        Intrinsics.checkNotNullParameter(metricsEventDataBaseHelper, "metricsEventDataBaseHelper");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f1580a = metricsEventDataBaseHelper;
        this.b = logger;
        this.c = LazyKt.lazy(new E(this));
    }

    public final void a(ArrayList persistentMetricsEventsDto) {
        Intrinsics.checkNotNullParameter(persistentMetricsEventsDto, "persistentMetricsEventsDto");
        String joinToString$default = CollectionsKt.joinToString$default(persistentMetricsEventsDto, null, null, null, 0, null, G.f1578a, 31, null);
        String trimIndent = StringsKt.trimIndent("\n            DELETE FROM metrics_event_table\n            WHERE _id IN (\n                SELECT _id FROM metrics_event_table\n                WHERE uuid IN (" + joinToString$default + ")\n            )\n        ");
        try {
            ((SQLiteDatabase) this.c.getValue()).beginTransactionNonExclusive();
            ((SQLiteDatabase) this.c.getValue()).execSQL(trimIndent);
            ((SQLiteDatabase) this.c.getValue()).setTransactionSuccessful();
            ((SQLiteDatabase) this.c.getValue()).endTransaction();
            this.b.a(new F(joinToString$default));
        } finally {
        }
    }

    public final void a(J persistentMetricsEventDto) {
        Intrinsics.checkNotNullParameter(persistentMetricsEventDto, "persistentMetricsEventDto");
        ContentValues contentValues = new ContentValues();
        contentValues.put(CommonUrlParts.UUID, persistentMetricsEventDto.f1583a);
        contentValues.put("metrics_event", persistentMetricsEventDto.b);
        try {
            ((SQLiteDatabase) this.c.getValue()).beginTransactionNonExclusive();
            long insert = ((SQLiteDatabase) this.c.getValue()).insert("metrics_event_table", null, contentValues);
            ((SQLiteDatabase) this.c.getValue()).setTransactionSuccessful();
            ((SQLiteDatabase) this.c.getValue()).endTransaction();
            if (insert != -1) {
                this.b.a(new b(persistentMetricsEventDto));
                return;
            }
            String str = "Saving error " + ((Object) ("MetricsEventUuid(value=" + persistentMetricsEventDto.f1583a + ')'));
            this.b.a(new a(str));
            throw new MetricsException.SaveMetricsEventError(str);
        } finally {
        }
    }
}
