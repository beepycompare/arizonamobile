package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class C7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0749z7 f376a;

    public C7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(B7 b7) {
        ContentValues contentValues = new ContentValues();
        Long l = b7.f358a;
        if (l != null) {
            contentValues.put("session_id", Long.valueOf(l.longValue()));
        }
        EnumC0156bl enumC0156bl = b7.b;
        if (enumC0156bl != null) {
            contentValues.put("session_type", Integer.valueOf(enumC0156bl.f799a));
        }
        Long l2 = b7.c;
        if (l2 != null) {
            contentValues.put("number_in_session", Long.valueOf(l2.longValue()));
        }
        EnumC0728yb enumC0728yb = b7.d;
        if (enumC0728yb != null) {
            contentValues.put("type", Integer.valueOf(enumC0728yb.f1157a));
        }
        Long l3 = b7.e;
        if (l3 != null) {
            contentValues.put("global_number", Long.valueOf(l3.longValue()));
        }
        Long l4 = b7.f;
        if (l4 != null) {
            contentValues.put("time", Long.valueOf(l4.longValue()));
        }
        C0749z7 c0749z7 = this.f376a;
        contentValues.put("event_description", MessageNano.toByteArray(c0749z7.f1174a.fromModel(b7.g)));
        return contentValues;
    }

    public C7(C0749z7 c0749z7) {
        this.f376a = c0749z7;
    }

    public /* synthetic */ C7(C0749z7 c0749z7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0749z7(null, 1, null) : c0749z7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final B7 toModel(ContentValues contentValues) {
        EnumC0156bl enumC0156bl;
        int intValue;
        Long asLong = contentValues.getAsLong("session_id");
        Integer asInteger = contentValues.getAsInteger("session_type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            enumC0156bl = EnumC0156bl.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                enumC0156bl = EnumC0156bl.BACKGROUND;
            }
        } else {
            enumC0156bl = null;
        }
        Long asLong2 = contentValues.getAsLong("number_in_session");
        Integer asInteger2 = contentValues.getAsInteger("type");
        return new B7(asLong, enumC0156bl, asLong2, asInteger2 != null ? EnumC0728yb.a(asInteger2.intValue()) : null, contentValues.getAsLong("global_number"), contentValues.getAsLong("time"), this.f376a.toModel(contentValues.getAsByteArray("event_description")));
    }
}
