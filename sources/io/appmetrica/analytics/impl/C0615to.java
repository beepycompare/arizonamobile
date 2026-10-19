package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.to  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0615to {

    /* renamed from: a  reason: collision with root package name */
    public final C0356jo f1226a;
    public final X b;
    public final List c;
    public final String d;
    public final String e;
    public final Map f;
    public final String g;
    public final Boolean h;

    public C0615to(C0356jo c0356jo, X x, ArrayList arrayList, String str, String str2, Map map, String str3, Boolean bool) {
        this.f1226a = c0356jo;
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
        C0356jo c0356jo = this.f1226a;
        if (c0356jo != null) {
            for (C0251fm c0251fm : c0356jo.c) {
                sb.append("at " + c0251fm.f990a + "." + c0251fm.e + "(" + c0251fm.b + StringUtils.PROCESS_POSTFIX_DELIMITER + c0251fm.c + StringUtils.PROCESS_POSTFIX_DELIMITER + c0251fm.d + ")\n");
            }
        }
        return "UnhandledException{exception=" + this.f1226a + "\n" + sb.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
