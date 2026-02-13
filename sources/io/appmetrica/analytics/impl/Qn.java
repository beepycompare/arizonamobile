package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Qn {

    /* renamed from: a  reason: collision with root package name */
    public final Gn f755a;
    public final V b;
    public final List c;
    public final String d;
    public final String e;
    public final Map f;
    public final String g;
    public final Boolean h;

    public Qn(Gn gn, V v, ArrayList arrayList, String str, String str2, Map map, String str3, Boolean bool) {
        this.f755a = gn;
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
        Gn gn = this.f755a;
        if (gn != null) {
            for (Dl dl : gn.c) {
                sb.append("at " + dl.f555a + "." + dl.e + "(" + dl.b + StringUtils.PROCESS_POSTFIX_DELIMITER + dl.c + StringUtils.PROCESS_POSTFIX_DELIMITER + dl.d + ")\n");
            }
        }
        return "UnhandledException{exception=" + this.f755a + "\n" + sb.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
