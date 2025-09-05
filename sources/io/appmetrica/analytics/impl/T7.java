package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class T7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Q7 f677a;

    public T7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(S7 s7) {
        ContentValues contentValues = new ContentValues();
        Long l = s7.f663a;
        if (l != null) {
            contentValues.put("id", Long.valueOf(l.longValue()));
        }
        EnumC0259fl enumC0259fl = s7.b;
        if (enumC0259fl != null) {
            contentValues.put("type", Integer.valueOf(enumC0259fl.f879a));
        }
        String str = s7.c;
        if (str != null) {
            contentValues.put("report_request_parameters", str);
        }
        Q7 q7 = this.f677a;
        contentValues.put("session_description", MessageNano.toByteArray(q7.f633a.fromModel(s7.d)));
        return contentValues;
    }

    public T7(Q7 q7) {
        this.f677a = q7;
    }

    public /* synthetic */ T7(Q7 q7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Q7(null, 1, null) : q7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final S7 toModel(ContentValues contentValues) {
        EnumC0259fl enumC0259fl;
        int intValue;
        Long asLong = contentValues.getAsLong("id");
        Integer asInteger = contentValues.getAsInteger("type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            enumC0259fl = EnumC0259fl.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                enumC0259fl = EnumC0259fl.BACKGROUND;
            }
        } else {
            enumC0259fl = null;
        }
        return new S7(asLong, enumC0259fl, contentValues.getAsString("report_request_parameters"), this.f677a.toModel(contentValues.getAsByteArray("session_description")));
    }
}
