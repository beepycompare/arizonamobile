package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* renamed from: io.appmetrica.analytics.impl.w7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0683w7 implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0605t7 f1262a;

    public C0683w7() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final ContentValues fromModel(C0657v7 c0657v7) {
        ContentValues contentValues = new ContentValues();
        Long l = c0657v7.f1246a;
        if (l != null) {
            contentValues.put("session_id", Long.valueOf(l.longValue()));
        }
        Al al = c0657v7.b;
        if (al != null) {
            contentValues.put("session_type", Integer.valueOf(al.f465a));
        }
        Long l2 = c0657v7.c;
        if (l2 != null) {
            contentValues.put("number_in_session", Long.valueOf(l2.longValue()));
        }
        Db db = c0657v7.d;
        if (db != null) {
            contentValues.put("type", Integer.valueOf(db.f513a));
        }
        Long l3 = c0657v7.e;
        if (l3 != null) {
            contentValues.put("global_number", Long.valueOf(l3.longValue()));
        }
        Long l4 = c0657v7.f;
        if (l4 != null) {
            contentValues.put("time", Long.valueOf(l4.longValue()));
        }
        C0605t7 c0605t7 = this.f1262a;
        contentValues.put("event_description", MessageNano.toByteArray(c0605t7.f1213a.fromModel(c0657v7.g)));
        return contentValues;
    }

    public C0683w7(C0605t7 c0605t7) {
        this.f1262a = c0605t7;
    }

    public /* synthetic */ C0683w7(C0605t7 c0605t7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0605t7(null, 1, null) : c0605t7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0657v7 toModel(ContentValues contentValues) {
        Al al;
        int intValue;
        Long asLong = contentValues.getAsLong("session_id");
        Integer asInteger = contentValues.getAsInteger("session_type");
        if (asInteger != null) {
            Integer valueOf = Integer.valueOf(asInteger.intValue());
            al = Al.FOREGROUND;
            if (valueOf != null && (intValue = valueOf.intValue()) != 0 && intValue == 1) {
                al = Al.BACKGROUND;
            }
        } else {
            al = null;
        }
        Long asLong2 = contentValues.getAsLong("number_in_session");
        Integer asInteger2 = contentValues.getAsInteger("type");
        return new C0657v7(asLong, al, asLong2, asInteger2 != null ? Db.a(asInteger2.intValue()) : null, contentValues.getAsLong("global_number"), contentValues.getAsLong("time"), this.f1262a.toModel(contentValues.getAsByteArray("event_description")));
    }
}
