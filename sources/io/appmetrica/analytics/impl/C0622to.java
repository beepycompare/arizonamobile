package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.to  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0622to {

    /* renamed from: a  reason: collision with root package name */
    public final C0363jo f1223a;
    public final X b;
    public final List c;
    public final String d;
    public final String e;
    public final Map f;
    public final String g;
    public final Boolean h;

    public C0622to(C0363jo c0363jo, X x, ArrayList arrayList, String str, String str2, Map map, String str3, Boolean bool) {
        this.f1223a = c0363jo;
        this.b = x;
        this.c = arrayList;
        this.d = str;
        this.e = str2;
        this.f = map;
        this.g = str3;
        this.h = bool;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        C0363jo c0363jo = this.f1223a;
        if (c0363jo != null) {
            for (C0258fm c0258fm : c0363jo.c) {
                sb.append("at " + c0258fm.f987a + "." + c0258fm.e + "(" + c0258fm.b + StringUtils.PROCESS_POSTFIX_DELIMITER + c0258fm.c + StringUtils.PROCESS_POSTFIX_DELIMITER + c0258fm.d + ")\n");
            }
        }
        return "UnhandledException{exception=" + this.f1223a + "\n" + sb.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
