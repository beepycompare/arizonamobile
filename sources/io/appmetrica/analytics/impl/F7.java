package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class F7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C7 f436a;

    public F7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(E7 e7) {
        ContentValues contentValues = new ContentValues();
        Long l = e7.f419a;
        if (l != null) {
            contentValues.put("session_id", Long.valueOf(l.longValue()));
        }
        EnumC0259fl enumC0259fl = e7.b;
        if (enumC0259fl != null) {
            contentValues.put("session_type", Integer.valueOf(enumC0259fl.f879a));
        }
        Long l2 = e7.c;
        if (l2 != null) {
            contentValues.put("number_in_session", Long.valueOf(l2.longValue()));
        }
        Bb bb = e7.d;
        if (bb != null) {
            contentValues.put("type", Integer.valueOf(bb.f364a));
        }
        Long l3 = e7.e;
        if (l3 != null) {
            contentValues.put("global_number", Long.valueOf(l3.longValue()));
        }
        Long l4 = e7.f;
        if (l4 != null) {
            contentValues.put("time", Long.valueOf(l4.longValue()));
        }
        C7 c7 = this.f436a;
        contentValues.put("event_description", MessageNano.toByteArray(c7.f380a.fromModel(e7.g)));
        return contentValues;
    }

    public F7(C7 c7) {
        this.f436a = c7;
    }

    public /* synthetic */ F7(C7 c7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C7(null, 1, null) : c7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final E7 toModel(ContentValues contentValues) {
        EnumC0259fl enumC0259fl;
        int intValue;
        Long asLong = contentValues.getAsLong("session_id");
        Integer asInteger = contentValues.getAsInteger("session_type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            enumC0259fl = EnumC0259fl.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                enumC0259fl = EnumC0259fl.BACKGROUND;
            }
        } else {
            enumC0259fl = null;
        }
        Long asLong2 = contentValues.getAsLong("number_in_session");
        Integer asInteger2 = contentValues.getAsInteger("type");
        return new E7(asLong, enumC0259fl, asLong2, asInteger2 != null ? Bb.a(asInteger2.intValue()) : null, contentValues.getAsLong("global_number"), contentValues.getAsLong("time"), this.f436a.toModel(contentValues.getAsByteArray("event_description")));
    }
}
