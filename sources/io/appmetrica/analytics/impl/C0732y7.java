package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.y7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0732y7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0657v7 f1140a;

    public C0732y7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(C0707x7 c0707x7) {
        ContentValues contentValues = new ContentValues();
        Long l = c0707x7.f1119a;
        if (l != null) {
            contentValues.put("session_id", Long.valueOf(l.longValue()));
        }
        Tk tk = c0707x7.b;
        if (tk != null) {
            contentValues.put("session_type", Integer.valueOf(tk.f646a));
        }
        Long l2 = c0707x7.c;
        if (l2 != null) {
            contentValues.put("number_in_session", Long.valueOf(l2.longValue()));
        }
        EnumC0636ub enumC0636ub = c0707x7.d;
        if (enumC0636ub != null) {
            contentValues.put("type", Integer.valueOf(enumC0636ub.f1073a));
        }
        Long l3 = c0707x7.e;
        if (l3 != null) {
            contentValues.put("global_number", Long.valueOf(l3.longValue()));
        }
        Long l4 = c0707x7.f;
        if (l4 != null) {
            contentValues.put("time", Long.valueOf(l4.longValue()));
        }
        C0657v7 c0657v7 = this.f1140a;
        contentValues.put("event_description", MessageNano.toByteArray(c0657v7.f1086a.fromModel(c0707x7.g)));
        return contentValues;
    }

    public C0732y7(C0657v7 c0657v7) {
        this.f1140a = c0657v7;
    }

    public /* synthetic */ C0732y7(C0657v7 c0657v7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0657v7(null, 1, null) : c0657v7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0707x7 toModel(ContentValues contentValues) {
        Tk tk;
        int intValue;
        Long asLong = contentValues.getAsLong("session_id");
        Integer asInteger = contentValues.getAsInteger("session_type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            tk = Tk.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                tk = Tk.BACKGROUND;
            }
        } else {
            tk = null;
        }
        Long asLong2 = contentValues.getAsLong("number_in_session");
        Integer asInteger2 = contentValues.getAsInteger("type");
        return new C0707x7(asLong, tk, asLong2, asInteger2 != null ? EnumC0636ub.a(asInteger2.intValue()) : null, contentValues.getAsLong("global_number"), contentValues.getAsLong("time"), this.f1140a.toModel(contentValues.getAsByteArray("event_description")));
    }
}
