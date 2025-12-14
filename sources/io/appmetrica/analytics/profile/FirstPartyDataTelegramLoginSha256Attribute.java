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
public class FirstPartyDataTelegramLoginSha256Attribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0615u6 f1417a = new C0615u6("appmetrica_1pd_telegram_sha256", new C0135b8(), new Hb(new C0439n4(100)));
    private final Zk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirstPartyDataTelegramLoginSha256Attribute(Zk zk) {
        this.b = zk;
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withTelegramLoginValues(String... strArr) {
        return withTelegramLoginValues(Arrays.asList(strArr));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withTelegramLoginValues(Iterable<String> iterable) {
        String str = this.f1417a.c;
        ArrayList a2 = this.b.a(iterable);
        Ym ym = new Ym(200, "First party data telegram logins attribute", PublicLogger.getAnonymousInstance());
        C0615u6 c0615u6 = this.f1417a;
        return new UserProfileUpdate<>(new Xm(str, a2, 10, ym, c0615u6.f1241a, new C0588t4(c0615u6.b)));
    }
}
