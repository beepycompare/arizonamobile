package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.n7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0443n7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0367k7 f1021a;

    public C0443n7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(C0418m7 c0418m7) {
        ContentValues contentValues = new ContentValues();
        Long l = c0418m7.f1004a;
        if (l != null) {
            contentValues.put("session_id", Long.valueOf(l.longValue()));
        }
        EnumC0123al enumC0123al = c0418m7.b;
        if (enumC0123al != null) {
            contentValues.put("session_type", Integer.valueOf(enumC0123al.f805a));
        }
        Long l2 = c0418m7.c;
        if (l2 != null) {
            contentValues.put("number_in_session", Long.valueOf(l2.longValue()));
        }
        EnumC0320ib enumC0320ib = c0418m7.d;
        if (enumC0320ib != null) {
            contentValues.put("type", Integer.valueOf(enumC0320ib.f931a));
        }
        Long l3 = c0418m7.e;
        if (l3 != null) {
            contentValues.put("global_number", Long.valueOf(l3.longValue()));
        }
        Long l4 = c0418m7.f;
        if (l4 != null) {
            contentValues.put("time", Long.valueOf(l4.longValue()));
        }
        C0367k7 c0367k7 = this.f1021a;
        contentValues.put("event_description", MessageNano.toByteArray(c0367k7.f968a.fromModel(c0418m7.g)));
        return contentValues;
    }

    public C0443n7(C0367k7 c0367k7) {
        this.f1021a = c0367k7;
    }

    public /* synthetic */ C0443n7(C0367k7 c0367k7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0367k7(null, 1, null) : c0367k7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0418m7 toModel(ContentValues contentValues) {
        EnumC0123al enumC0123al;
        int intValue;
        Long asLong = contentValues.getAsLong("session_id");
        Integer asInteger = contentValues.getAsInteger("session_type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            enumC0123al = EnumC0123al.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                enumC0123al = EnumC0123al.BACKGROUND;
            }
        } else {
            enumC0123al = null;
        }
        Long asLong2 = contentValues.getAsLong("number_in_session");
        Integer asInteger2 = contentValues.getAsInteger("type");
        return new C0418m7(asLong, enumC0123al, asLong2, asInteger2 != null ? EnumC0320ib.a(asInteger2.intValue()) : null, contentValues.getAsLong("global_number"), contentValues.getAsLong("time"), this.f1021a.toModel(contentValues.getAsByteArray("event_description")));
    }
}
