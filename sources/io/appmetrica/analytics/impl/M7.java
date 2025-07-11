package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class M7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final J7 f532a;

    public M7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(L7 l7) {
        ContentValues contentValues = new ContentValues();
        Long l = l7.f515a;
        if (l != null) {
            contentValues.put("id", Long.valueOf(l.longValue()));
        }
        Tk tk = l7.b;
        if (tk != null) {
            contentValues.put("type", Integer.valueOf(tk.f647a));
        }
        String str = l7.c;
        if (str != null) {
            contentValues.put("report_request_parameters", str);
        }
        J7 j7 = this.f532a;
        contentValues.put("session_description", MessageNano.toByteArray(j7.f489a.fromModel(l7.d)));
        return contentValues;
    }

    public M7(J7 j7) {
        this.f532a = j7;
    }

    public /* synthetic */ M7(J7 j7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new J7(null, 1, null) : j7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final L7 toModel(ContentValues contentValues) {
        Tk tk;
        int intValue;
        Long asLong = contentValues.getAsLong("id");
        Integer asInteger = contentValues.getAsInteger("type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            tk = Tk.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                tk = Tk.BACKGROUND;
            }
        } else {
            tk = null;
        }
        return new L7(asLong, tk, contentValues.getAsString("report_request_parameters"), this.f532a.toModel(contentValues.getAsByteArray("session_description")));
    }
}
