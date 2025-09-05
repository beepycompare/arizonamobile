package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.im  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0337im extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f923a;
    public final String b;
    public final Map<String, String> c;
    public final boolean d;
    public final List<String> e;

    public C0337im(C0268g4 c0268g4) {
        this(c0268g4.a().c(), c0268g4.a().d(), c0268g4.a().a(), c0268g4.a().h(), c0268g4.a().b());
    }

    public final boolean a(C0337im c0337im) {
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final C0337im mergeFrom(C0337im c0337im) {
        return new C0337im((String) WrapUtils.getOrDefaultNullable(this.f923a, c0337im.f923a), (String) WrapUtils.getOrDefaultNullable(this.b, c0337im.b), (Map) WrapUtils.getOrDefaultNullable(this.c, c0337im.c), this.d || c0337im.d, c0337im.d ? c0337im.e : this.e);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        C0337im c0337im = (C0337im) obj;
        return false;
    }

    public final String toString() {
        return "Arguments{distributionReferrer='" + this.f923a + "', installReferrerSource='" + this.b + "', clientClids=" + this.c + ", hasNewCustomHosts=" + this.d + ", newCustomHosts=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public C0337im(String str, String str2, Map<String, String> map, boolean z, List<String> list) {
        this.f923a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
        this.e = list;
    }

    public C0337im() {
        this(null, null, null, false, null);
    }
}
