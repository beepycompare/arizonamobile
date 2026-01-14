package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.t7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0595t7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0521q7 f1233a;

    public C0595t7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(C0570s7 c0570s7) {
        ContentValues contentValues = new ContentValues();
        Long l = c0570s7.f1219a;
        if (l != null) {
            contentValues.put("id", Long.valueOf(l.longValue()));
        }
        Vk vk = c0570s7.b;
        if (vk != null) {
            contentValues.put("type", Integer.valueOf(vk.f831a));
        }
        String str = c0570s7.c;
        if (str != null) {
            contentValues.put("report_request_parameters", str);
        }
        C0521q7 c0521q7 = this.f1233a;
        contentValues.put("session_description", MessageNano.toByteArray(c0521q7.f1186a.fromModel(c0570s7.d)));
        return contentValues;
    }

    public C0595t7(C0521q7 c0521q7) {
        this.f1233a = c0521q7;
    }

    public /* synthetic */ C0595t7(C0521q7 c0521q7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0521q7(null, 1, null) : c0521q7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0570s7 toModel(ContentValues contentValues) {
        Vk vk;
        int intValue;
        Long asLong = contentValues.getAsLong("id");
        Integer asInteger = contentValues.getAsInteger("type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            vk = Vk.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                vk = Vk.BACKGROUND;
            }
        } else {
            vk = null;
        }
        return new C0570s7(asLong, vk, contentValues.getAsString("report_request_parameters"), this.f1233a.toModel(contentValues.getAsByteArray("session_description")));
    }
}
