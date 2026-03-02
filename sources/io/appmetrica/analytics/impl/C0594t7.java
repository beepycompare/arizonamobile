package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.t7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0594t7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0520q7 f1232a;

    public C0594t7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(C0569s7 c0569s7) {
        ContentValues contentValues = new ContentValues();
        Long l = c0569s7.f1218a;
        if (l != null) {
            contentValues.put("id", Long.valueOf(l.longValue()));
        }
        Vk vk = c0569s7.b;
        if (vk != null) {
            contentValues.put("type", Integer.valueOf(vk.f830a));
        }
        String str = c0569s7.c;
        if (str != null) {
            contentValues.put("report_request_parameters", str);
        }
        C0520q7 c0520q7 = this.f1232a;
        contentValues.put("session_description", MessageNano.toByteArray(c0520q7.f1185a.fromModel(c0569s7.d)));
        return contentValues;
    }

    public C0594t7(C0520q7 c0520q7) {
        this.f1232a = c0520q7;
    }

    public /* synthetic */ C0594t7(C0520q7 c0520q7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0520q7(null, 1, null) : c0520q7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0569s7 toModel(ContentValues contentValues) {
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
        return new C0569s7(asLong, vk, contentValues.getAsString("report_request_parameters"), this.f1232a.toModel(contentValues.getAsByteArray("session_description")));
    }
}
