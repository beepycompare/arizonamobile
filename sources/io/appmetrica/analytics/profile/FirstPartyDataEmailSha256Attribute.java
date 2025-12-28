package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0135b8;
import io.appmetrica.analytics.impl.C0439n4;
import io.appmetrica.analytics.impl.C0588t4;
import io.appmetrica.analytics.impl.C0615u6;
import io.appmetrica.analytics.impl.Hb;
import io.appmetrica.analytics.impl.InterfaceC0254fo;
import io.appmetrica.analytics.impl.Xm;
import io.appmetrica.analytics.impl.Ym;
import io.appmetrica.analytics.impl.Zk;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class FirstPartyDataEmailSha256Attribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0615u6 f1416a = new C0615u6("appmetrica_1pd_email_sha256", new C0135b8(), new Hb(new C0439n4(100)));
    private final Zk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirstPartyDataEmailSha256Attribute(Zk zk) {
        this.b = zk;
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withEmailValues(String... strArr) {
        return withEmailValues(Arrays.asList(strArr));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withEmailValues(Iterable<String> iterable) {
        String str = this.f1416a.c;
        ArrayList a2 = this.b.a(iterable);
        Ym ym = new Ym(200, "First party data emails attribute", PublicLogger.getAnonymousInstance());
        C0615u6 c0615u6 = this.f1416a;
        return new UserProfileUpdate<>(new Xm(str, a2, 10, ym, c0615u6.f1242a, new C0588t4(c0615u6.b)));
    }
}
