package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class B7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0726y7 f352a;

    public B7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(A7 a7) {
        ContentValues contentValues = new ContentValues();
        Long l = a7.f333a;
        if (l != null) {
            contentValues.put("session_id", Long.valueOf(l.longValue()));
        }
        Wk wk = a7.b;
        if (wk != null) {
            contentValues.put("session_type", Integer.valueOf(wk.f706a));
        }
        Long l2 = a7.c;
        if (l2 != null) {
            contentValues.put("number_in_session", Long.valueOf(l2.longValue()));
        }
        EnumC0680wb enumC0680wb = a7.d;
        if (enumC0680wb != null) {
            contentValues.put("type", Integer.valueOf(enumC0680wb.f1119a));
        }
        Long l3 = a7.e;
        if (l3 != null) {
            contentValues.put("global_number", Long.valueOf(l3.longValue()));
        }
        Long l4 = a7.f;
        if (l4 != null) {
            contentValues.put("time", Long.valueOf(l4.longValue()));
        }
        C0726y7 c0726y7 = this.f352a;
        contentValues.put("event_description", MessageNano.toByteArray(c0726y7.f1149a.fromModel(a7.g)));
        return contentValues;
    }

    public B7(C0726y7 c0726y7) {
        this.f352a = c0726y7;
    }

    public /* synthetic */ B7(C0726y7 c0726y7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0726y7(null, 1, null) : c0726y7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final A7 toModel(ContentValues contentValues) {
        Wk wk;
        int intValue;
        Long asLong = contentValues.getAsLong("session_id");
        Integer asInteger = contentValues.getAsInteger("session_type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            wk = Wk.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                wk = Wk.BACKGROUND;
            }
        } else {
            wk = null;
        }
        Long asLong2 = contentValues.getAsLong("number_in_session");
        Integer asInteger2 = contentValues.getAsInteger("type");
        return new A7(asLong, wk, asLong2, asInteger2 != null ? EnumC0680wb.a(asInteger2.intValue()) : null, contentValues.getAsLong("global_number"), contentValues.getAsLong("time"), this.f352a.toModel(contentValues.getAsByteArray("event_description")));
    }
}
