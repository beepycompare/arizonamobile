package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.g7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0264g7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0187d7 f901a;

    public C0264g7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(C0238f7 c0238f7) {
        ContentValues contentValues = new ContentValues();
        Long l = c0238f7.f886a;
        if (l != null) {
            contentValues.put("session_id", Long.valueOf(l.longValue()));
        }
        Wk wk = c0238f7.b;
        if (wk != null) {
            contentValues.put("session_type", Integer.valueOf(wk.f742a));
        }
        Long l2 = c0238f7.c;
        if (l2 != null) {
            contentValues.put("number_in_session", Long.valueOf(l2.longValue()));
        }
        EnumC0165cb enumC0165cb = c0238f7.d;
        if (enumC0165cb != null) {
            contentValues.put("type", Integer.valueOf(enumC0165cb.f829a));
        }
        Long l3 = c0238f7.e;
        if (l3 != null) {
            contentValues.put("global_number", Long.valueOf(l3.longValue()));
        }
        Long l4 = c0238f7.f;
        if (l4 != null) {
            contentValues.put("time", Long.valueOf(l4.longValue()));
        }
        C0187d7 c0187d7 = this.f901a;
        contentValues.put("event_description", MessageNano.toByteArray(c0187d7.f844a.fromModel(c0238f7.g)));
        return contentValues;
    }

    public C0264g7(C0187d7 c0187d7) {
        this.f901a = c0187d7;
    }

    public /* synthetic */ C0264g7(C0187d7 c0187d7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0187d7(null, 1, null) : c0187d7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0238f7 toModel(ContentValues contentValues) {
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
        return new C0238f7(asLong, wk, asLong2, asInteger2 != null ? EnumC0165cb.a(asInteger2.intValue()) : null, contentValues.getAsLong("global_number"), contentValues.getAsLong("time"), this.f901a.toModel(contentValues.getAsByteArray("event_description")));
    }
}
