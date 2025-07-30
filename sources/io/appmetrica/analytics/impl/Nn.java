package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Nn {

    /* renamed from: a  reason: collision with root package name */
    public final Dn f569a;
    public final U b;
    public final List c;
    public final String d;
    public final String e;
    public final Map f;
    public final String g;
    public final Boolean h;

    public Nn(Dn dn, U u, ArrayList arrayList, String str, String str2, Map map, String str3, Boolean bool) {
        this.f569a = dn;
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
        Dn dn = this.f569a;
        if (dn != null) {
            for (Dl dl : dn.c) {
                sb.append("at " + dl.f402a + "." + dl.e + "(" + dl.b + StringUtils.PROCESS_POSTFIX_DELIMITER + dl.c + StringUtils.PROCESS_POSTFIX_DELIMITER + dl.d + ")\n");
            }
        }
        return "UnhandledException{exception=" + this.f569a + "\n" + sb.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
