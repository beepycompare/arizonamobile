package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.u7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0616u7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0541r7 f1242a;

    public C0616u7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(C0591t7 c0591t7) {
        ContentValues contentValues = new ContentValues();
        Long l = c0591t7.f1227a;
        if (l != null) {
            contentValues.put("id", Long.valueOf(l.longValue()));
        }
        Wk wk = c0591t7.b;
        if (wk != null) {
            contentValues.put("type", Integer.valueOf(wk.f839a));
        }
        String str = c0591t7.c;
        if (str != null) {
            contentValues.put("report_request_parameters", str);
        }
        C0541r7 c0541r7 = this.f1242a;
        contentValues.put("session_description", MessageNano.toByteArray(c0541r7.f1195a.fromModel(c0591t7.d)));
        return contentValues;
    }

    public C0616u7(C0541r7 c0541r7) {
        this.f1242a = c0541r7;
    }

    public /* synthetic */ C0616u7(C0541r7 c0541r7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0541r7(null, 1, null) : c0541r7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0591t7 toModel(ContentValues contentValues) {
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
        return new C0591t7(asLong, wk, contentValues.getAsString("report_request_parameters"), this.f1242a.toModel(contentValues.getAsByteArray("session_description")));
    }
}
