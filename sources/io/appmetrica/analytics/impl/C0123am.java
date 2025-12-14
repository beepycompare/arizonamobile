package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.am  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0123am extends BaseRequestConfig.BaseRequestArguments {

    /* renamed from: a  reason: collision with root package name */
    public final String f901a;
    public final String b;
    public final Map<String, String> c;
    public final boolean d;
    public final List<String> e;

    public C0123am(I3 i3) {
        this(i3.a().c(), i3.a().d(), i3.a().a(), i3.a().h(), i3.a().b());
    }

    public final boolean a(C0123am c0123am) {
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b */
    public final C0123am mergeFrom(C0123am c0123am) {
        return new C0123am((String) WrapUtils.getOrDefaultNullable(this.f901a, c0123am.f901a), (String) WrapUtils.getOrDefaultNullable(this.b, c0123am.b), (Map) WrapUtils.getOrDefaultNullable(this.c, c0123am.c), this.d || c0123am.d, c0123am.d ? c0123am.e : this.e);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        C0123am c0123am = (C0123am) obj;
        return false;
    }

    public final String toString() {
        return "Arguments{distributionReferrer='" + this.f901a + "', installReferrerSource='" + this.b + "', clientClids=" + this.c + ", hasNewCustomHosts=" + this.d + ", newCustomHosts=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public C0123am(String str, String str2, Map<String, String> map, boolean z, List<String> list) {
        this.f901a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
        this.e = list;
    }

    public C0123am() {
        this(null, null, null, false, null);
    }
}
