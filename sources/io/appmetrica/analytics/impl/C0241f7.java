package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.f7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0241f7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0164c7 f994a;

    public C0241f7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(C0215e7 c0215e7) {
        ContentValues contentValues = new ContentValues();
        Long l = c0215e7.f978a;
        if (l != null) {
            contentValues.put("session_id", Long.valueOf(l.longValue()));
        }
        Vk vk = c0215e7.b;
        if (vk != null) {
            contentValues.put("session_type", Integer.valueOf(vk.f835a));
        }
        Long l2 = c0215e7.c;
        if (l2 != null) {
            contentValues.put("number_in_session", Long.valueOf(l2.longValue()));
        }
        EnumC0142bb enumC0142bb = c0215e7.d;
        if (enumC0142bb != null) {
            contentValues.put("type", Integer.valueOf(enumC0142bb.f922a));
        }
        Long l3 = c0215e7.e;
        if (l3 != null) {
            contentValues.put("global_number", Long.valueOf(l3.longValue()));
        }
        Long l4 = c0215e7.f;
        if (l4 != null) {
            contentValues.put("time", Long.valueOf(l4.longValue()));
        }
        C0164c7 c0164c7 = this.f994a;
        contentValues.put("event_description", MessageNano.toByteArray(c0164c7.f936a.fromModel(c0215e7.g)));
        return contentValues;
    }

    public C0241f7(C0164c7 c0164c7) {
        this.f994a = c0164c7;
    }

    public /* synthetic */ C0241f7(C0164c7 c0164c7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0164c7(null, 1, null) : c0164c7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0215e7 toModel(ContentValues contentValues) {
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
        return new C0215e7(asLong, vk, asLong2, asInteger2 != null ? EnumC0142bb.a(asInteger2.intValue()) : null, contentValues.getAsLong("global_number"), contentValues.getAsLong("time"), this.f994a.toModel(contentValues.getAsByteArray("event_description")));
    }
}
