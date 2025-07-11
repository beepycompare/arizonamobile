package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Kn {

    /* renamed from: a  reason: collision with root package name */
    public final An f510a;
    public final U b;
    public final List c;
    public final String d;
    public final String e;
    public final Map f;
    public final String g;
    public final Boolean h;

    public Kn(An an, U u, ArrayList arrayList, String str, String str2, Map map, String str3, Boolean bool) {
        this.f510a = an;
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
        An an = this.f510a;
        if (an != null) {
            for (Al al : an.c) {
                sb.append("at " + al.f341a + "." + al.e + "(" + al.b + StringUtils.PROCESS_POSTFIX_DELIMITER + al.c + StringUtils.PROCESS_POSTFIX_DELIMITER + al.d + ")\n");
            }
        }
        return "UnhandledException{exception=" + this.f510a + "\n" + sb.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
