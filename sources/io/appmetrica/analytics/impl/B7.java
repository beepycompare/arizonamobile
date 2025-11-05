package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes3.dex */
public final class B7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0717y7 f409a;

    public B7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(A7 a7) {
        ContentValues contentValues = new ContentValues();
        Long l = a7.f392a;
        if (l != null) {
            contentValues.put("id", Long.valueOf(l.longValue()));
        }
        EnumC0123al enumC0123al = a7.b;
        if (enumC0123al != null) {
            contentValues.put("type", Integer.valueOf(enumC0123al.f805a));
        }
        String str = a7.c;
        if (str != null) {
            contentValues.put("report_request_parameters", str);
        }
        C0717y7 c0717y7 = this.f409a;
        contentValues.put("session_description", MessageNano.toByteArray(c0717y7.f1211a.fromModel(a7.d)));
        return contentValues;
    }

    public B7(C0717y7 c0717y7) {
        this.f409a = c0717y7;
    }

    public /* synthetic */ B7(C0717y7 c0717y7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0717y7(null, 1, null) : c0717y7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final A7 toModel(ContentValues contentValues) {
        EnumC0123al enumC0123al;
        int intValue;
        Long asLong = contentValues.getAsLong("id");
        Integer asInteger = contentValues.getAsInteger("type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            enumC0123al = EnumC0123al.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                enumC0123al = EnumC0123al.BACKGROUND;
            }
        } else {
            enumC0123al = null;
        }
        return new A7(asLong, enumC0123al, contentValues.getAsString("report_request_parameters"), this.f409a.toModel(contentValues.getAsByteArray("session_description")));
    }
}
