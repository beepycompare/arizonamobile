package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class Wl extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f692a;
    public final String b;
    public final Map<String, String> c;
    public final boolean d;
    public final List<String> e;

    public Wl(C0206d4 c0206d4) {
        this(c0206d4.a().c(), c0206d4.a().d(), c0206d4.a().a(), c0206d4.a().h(), c0206d4.a().b());
    }

    public final boolean a(Wl wl) {
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final Wl mergeFrom(Wl wl) {
        return new Wl((String) WrapUtils.getOrDefaultNullable(this.f692a, wl.f692a), (String) WrapUtils.getOrDefaultNullable(this.b, wl.b), (Map) WrapUtils.getOrDefaultNullable(this.c, wl.c), this.d || wl.d, wl.d ? wl.e : this.e);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        Wl wl = (Wl) obj;
        return false;
    }

    public final String toString() {
        return "Arguments{distributionReferrer='" + this.f692a + "', installReferrerSource='" + this.b + "', clientClids=" + this.c + ", hasNewCustomHosts=" + this.d + ", newCustomHosts=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public Wl(String str, String str2, Map<String, String> map, boolean z, List<String> list) {
        this.f692a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
        this.e = list;
    }

    public Wl() {
        this(null, null, null, false, null);
    }
}
