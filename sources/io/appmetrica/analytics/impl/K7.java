package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class K7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final H7 f624a;

    public K7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(J7 j7) {
        ContentValues contentValues = new ContentValues();
        Long l = j7.f607a;
        if (l != null) {
            contentValues.put("id", Long.valueOf(l.longValue()));
        }
        Al al = j7.b;
        if (al != null) {
            contentValues.put("type", Integer.valueOf(al.f462a));
        }
        String str = j7.c;
        if (str != null) {
            contentValues.put("report_request_parameters", str);
        }
        H7 h7 = this.f624a;
        contentValues.put("session_description", MessageNano.toByteArray(h7.f573a.fromModel(j7.d)));
        return contentValues;
    }

    public K7(H7 h7) {
        this.f624a = h7;
    }

    public /* synthetic */ K7(H7 h7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new H7(null, 1, null) : h7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final J7 toModel(ContentValues contentValues) {
        Al al;
        int intValue;
        Long asLong = contentValues.getAsLong("id");
        Integer asInteger = contentValues.getAsInteger("type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            al = Al.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                al = Al.BACKGROUND;
            }
        } else {
            al = null;
        }
        return new J7(asLong, al, contentValues.getAsString("report_request_parameters"), this.f624a.toModel(contentValues.getAsByteArray("session_description")));
    }
}
