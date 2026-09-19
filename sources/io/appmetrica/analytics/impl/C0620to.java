package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.to  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0620to {

    /* renamed from: a  reason: collision with root package name */
    public final C0361jo f1223a;
    public final X b;
    public final List c;
    public final String d;
    public final String e;
    public final Map f;
    public final String g;
    public final Boolean h;

    public C0620to(C0361jo c0361jo, X x, ArrayList arrayList, String str, String str2, Map map, String str3, Boolean bool) {
        this.f1223a = c0361jo;
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
        C0361jo c0361jo = this.f1223a;
        if (c0361jo != null) {
            for (C0256fm c0256fm : c0361jo.c) {
                sb.append("at " + c0256fm.f987a + "." + c0256fm.e + "(" + c0256fm.b + StringUtils.PROCESS_POSTFIX_DELIMITER + c0256fm.c + StringUtils.PROCESS_POSTFIX_DELIMITER + c0256fm.d + ")\n");
            }
        }
        return "UnhandledException{exception=" + this.f1223a + "\n" + sb.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
