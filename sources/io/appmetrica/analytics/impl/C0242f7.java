package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.f7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0242f7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0165c7 f989a;

    public C0242f7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(C0216e7 c0216e7) {
        ContentValues contentValues = new ContentValues();
        Long l = c0216e7.f973a;
        if (l != null) {
            contentValues.put("session_id", Long.valueOf(l.longValue()));
        }
        Vk vk = c0216e7.b;
        if (vk != null) {
            contentValues.put("session_type", Integer.valueOf(vk.f830a));
        }
        Long l2 = c0216e7.c;
        if (l2 != null) {
            contentValues.put("number_in_session", Long.valueOf(l2.longValue()));
        }
        EnumC0143bb enumC0143bb = c0216e7.d;
        if (enumC0143bb != null) {
            contentValues.put("type", Integer.valueOf(enumC0143bb.f917a));
        }
        Long l3 = c0216e7.e;
        if (l3 != null) {
            contentValues.put("global_number", Long.valueOf(l3.longValue()));
        }
        Long l4 = c0216e7.f;
        if (l4 != null) {
            contentValues.put("time", Long.valueOf(l4.longValue()));
        }
        C0165c7 c0165c7 = this.f989a;
        contentValues.put("event_description", MessageNano.toByteArray(c0165c7.f931a.fromModel(c0216e7.g)));
        return contentValues;
    }

    public C0242f7(C0165c7 c0165c7) {
        this.f989a = c0165c7;
    }

    public /* synthetic */ C0242f7(C0165c7 c0165c7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0165c7(null, 1, null) : c0165c7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0216e7 toModel(ContentValues contentValues) {
        Vk vk;
        int intValue;
        Long asLong = contentValues.getAsLong("session_id");
        Integer asInteger = contentValues.getAsInteger("session_type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            vk = Vk.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                vk = Vk.BACKGROUND;
            }
        } else {
            vk = null;
        }
        Long asLong2 = contentValues.getAsLong("number_in_session");
        Integer asInteger2 = contentValues.getAsInteger("type");
        return new C0216e7(asLong, vk, asLong2, asInteger2 != null ? EnumC0143bb.a(asInteger2.intValue()) : null, contentValues.getAsLong("global_number"), contentValues.getAsLong("time"), this.f989a.toModel(contentValues.getAsByteArray("event_description")));
    }
}
