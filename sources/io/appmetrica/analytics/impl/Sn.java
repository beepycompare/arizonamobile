package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Sn {

    /* renamed from: a  reason: collision with root package name */
    public final In f652a;
    public final U b;
    public final List c;
    public final String d;
    public final String e;
    public final Map f;
    public final String g;
    public final Boolean h;

    public Sn(In in, U u, ArrayList arrayList, String str, String str2, Map map, String str3, Boolean bool) {
        this.f652a = in;
        this.b = u;
        this.c = arrayList;
        this.d = str;
        this.e = str2;
        this.f = map;
        this.g = str3;
        this.h = bool;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        In in = this.f652a;
        if (in != null) {
            for (Il il : in.c) {
                sb.append("at " + il.f501a + "." + il.e + "(" + il.b + StringUtils.PROCESS_POSTFIX_DELIMITER + il.c + StringUtils.PROCESS_POSTFIX_DELIMITER + il.d + ")\n");
            }
        }
        return "UnhandledException{exception=" + this.f652a + "\n" + sb.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
