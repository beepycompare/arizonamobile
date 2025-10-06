package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.im  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0338im extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f928a;
    public final String b;
    public final Map<String, String> c;
    public final boolean d;
    public final List<String> e;

    public C0338im(C0269g4 c0269g4) {
        this(c0269g4.a().c(), c0269g4.a().d(), c0269g4.a().a(), c0269g4.a().h(), c0269g4.a().b());
    }

    public final boolean a(C0338im c0338im) {
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final C0338im mergeFrom(C0338im c0338im) {
        return new C0338im((String) WrapUtils.getOrDefaultNullable(this.f928a, c0338im.f928a), (String) WrapUtils.getOrDefaultNullable(this.b, c0338im.b), (Map) WrapUtils.getOrDefaultNullable(this.c, c0338im.c), this.d || c0338im.d, c0338im.d ? c0338im.e : this.e);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        C0338im c0338im = (C0338im) obj;
        return false;
    }

    public final String toString() {
        return "Arguments{distributionReferrer='" + this.f928a + "', installReferrerSource='" + this.b + "', clientClids=" + this.c + ", hasNewCustomHosts=" + this.d + ", newCustomHosts=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public C0338im(String str, String str2, Map<String, String> map, boolean z, List<String> list) {
        this.f928a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
        this.e = list;
    }

    public C0338im() {
        this(null, null, null, false, null);
    }
}
