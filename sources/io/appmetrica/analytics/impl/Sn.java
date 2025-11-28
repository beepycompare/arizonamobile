package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Sn {

    /* renamed from: a  reason: collision with root package name */
    public final In f691a;
    public final V b;
    public final List c;
    public final String d;
    public final String e;
    public final Map f;
    public final String g;
    public final Boolean h;

    public Sn(In in, V v, ArrayList arrayList, String str, String str2, Map map, String str3, Boolean bool) {
        this.f691a = in;
        this.b = v;
        this.c = arrayList;
        this.d = str;
        this.e = str2;
        this.f = map;
        this.g = str3;
        this.h = bool;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        In in = this.f691a;
        if (in != null) {
            for (Hl hl : in.c) {
                sb.append("at " + hl.f512a + "." + hl.e + "(" + hl.b + StringUtils.PROCESS_POSTFIX_DELIMITER + hl.c + StringUtils.PROCESS_POSTFIX_DELIMITER + hl.d + ")\n");
            }
        }
        return "UnhandledException{exception=" + this.f691a + "\n" + sb.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
