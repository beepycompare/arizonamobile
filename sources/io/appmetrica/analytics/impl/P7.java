package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class P7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final M7 f592a;

    public P7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(O7 o7) {
        ContentValues contentValues = new ContentValues();
        Long l = o7.f575a;
        if (l != null) {
            contentValues.put("id", Long.valueOf(l.longValue()));
        }
        Wk wk = o7.b;
        if (wk != null) {
            contentValues.put("type", Integer.valueOf(wk.f707a));
        }
        String str = o7.c;
        if (str != null) {
            contentValues.put("report_request_parameters", str);
        }
        M7 m7 = this.f592a;
        contentValues.put("session_description", MessageNano.toByteArray(m7.f546a.fromModel(o7.d)));
        return contentValues;
    }

    public P7(M7 m7) {
        this.f592a = m7;
    }

    public /* synthetic */ P7(M7 m7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new M7(null, 1, null) : m7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O7 toModel(ContentValues contentValues) {
        Wk wk;
        int intValue;
        Long asLong = contentValues.getAsLong("id");
        Integer asInteger = contentValues.getAsInteger("type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            wk = Wk.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                wk = Wk.BACKGROUND;
            }
        } else {
            wk = null;
        }
        return new O7(asLong, wk, contentValues.getAsString("report_request_parameters"), this.f592a.toModel(contentValues.getAsByteArray("session_description")));
    }
}
