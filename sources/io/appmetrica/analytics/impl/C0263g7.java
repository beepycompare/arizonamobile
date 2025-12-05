package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.g7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0263g7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0186d7 f984a;

    public C0263g7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(C0237f7 c0237f7) {
        ContentValues contentValues = new ContentValues();
        Long l = c0237f7.f969a;
        if (l != null) {
            contentValues.put("session_id", Long.valueOf(l.longValue()));
        }
        Wk wk = c0237f7.b;
        if (wk != null) {
            contentValues.put("session_type", Integer.valueOf(wk.f825a));
        }
        Long l2 = c0237f7.c;
        if (l2 != null) {
            contentValues.put("number_in_session", Long.valueOf(l2.longValue()));
        }
        EnumC0164cb enumC0164cb = c0237f7.d;
        if (enumC0164cb != null) {
            contentValues.put("type", Integer.valueOf(enumC0164cb.f912a));
        }
        Long l3 = c0237f7.e;
        if (l3 != null) {
            contentValues.put("global_number", Long.valueOf(l3.longValue()));
        }
        Long l4 = c0237f7.f;
        if (l4 != null) {
            contentValues.put("time", Long.valueOf(l4.longValue()));
        }
        C0186d7 c0186d7 = this.f984a;
        contentValues.put("event_description", MessageNano.toByteArray(c0186d7.f927a.fromModel(c0237f7.g)));
        return contentValues;
    }

    public C0263g7(C0186d7 c0186d7) {
        this.f984a = c0186d7;
    }

    public /* synthetic */ C0263g7(C0186d7 c0186d7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0186d7(null, 1, null) : c0186d7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0237f7 toModel(ContentValues contentValues) {
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
        return new C0237f7(asLong, wk, asLong2, asInteger2 != null ? EnumC0164cb.a(asInteger2.intValue()) : null, contentValues.getAsLong("global_number"), contentValues.getAsLong("time"), this.f984a.toModel(contentValues.getAsByteArray("event_description")));
    }
}
