package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class Rn {

    /* renamed from: a  reason: collision with root package name */
    public final Hn f749a;
    public final V b;
    public final List c;
    public final String d;
    public final String e;
    public final Map f;
    public final String g;
    public final Boolean h;

    public Rn(Hn hn, V v, ArrayList arrayList, String str, String str2, Map map, String str3, Boolean bool) {
        this.f749a = hn;
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
        Hn hn = this.f749a;
        if (hn != null) {
            for (El el : hn.c) {
                sb.append("at " + el.f549a + "." + el.e + "(" + el.b + StringUtils.PROCESS_POSTFIX_DELIMITER + el.c + StringUtils.PROCESS_POSTFIX_DELIMITER + el.d + ")\n");
            }
        }
        return "UnhandledException{exception=" + this.f749a + "\n" + sb.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
