package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Wn {

    /* renamed from: a  reason: collision with root package name */
    public final Mn f732a;
    public final U b;
    public final List c;
    public final String d;
    public final String e;
    public final Map f;
    public final String g;
    public final Boolean h;

    public Wn(Mn mn, U u, ArrayList arrayList, String str, String str2, Map map, String str3, Boolean bool) {
        this.f732a = mn;
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
        Mn mn = this.f732a;
        if (mn != null) {
            for (Ml ml : mn.c) {
                sb.append("at " + ml.f582a + "." + ml.e + "(" + ml.b + StringUtils.PROCESS_POSTFIX_DELIMITER + ml.c + StringUtils.PROCESS_POSTFIX_DELIMITER + ml.d + ")\n");
            }
        }
        return "UnhandledException{exception=" + this.f732a + "\n" + sb.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
