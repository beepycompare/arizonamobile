package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class Q7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final N7 f616a;

    public Q7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(P7 p7) {
        ContentValues contentValues = new ContentValues();
        Long l = p7.f601a;
        if (l != null) {
            contentValues.put("id", Long.valueOf(l.longValue()));
        }
        EnumC0156bl enumC0156bl = p7.b;
        if (enumC0156bl != null) {
            contentValues.put("type", Integer.valueOf(enumC0156bl.f799a));
        }
        String str = p7.c;
        if (str != null) {
            contentValues.put("report_request_parameters", str);
        }
        N7 n7 = this.f616a;
        contentValues.put("session_description", MessageNano.toByteArray(n7.f575a.fromModel(p7.d)));
        return contentValues;
    }

    public Q7(N7 n7) {
        this.f616a = n7;
    }

    public /* synthetic */ Q7(N7 n7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new N7(null, 1, null) : n7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final P7 toModel(ContentValues contentValues) {
        EnumC0156bl enumC0156bl;
        int intValue;
        Long asLong = contentValues.getAsLong("id");
        Integer asInteger = contentValues.getAsInteger("type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            enumC0156bl = EnumC0156bl.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                enumC0156bl = EnumC0156bl.BACKGROUND;
            }
        } else {
            enumC0156bl = null;
        }
        return new P7(asLong, enumC0156bl, contentValues.getAsString("report_request_parameters"), this.f616a.toModel(contentValues.getAsByteArray("session_description")));
    }
}
