package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0136b8;
import io.appmetrica.analytics.impl.C0440n4;
import io.appmetrica.analytics.impl.C0589t4;
import io.appmetrica.analytics.impl.C0616u6;
import io.appmetrica.analytics.impl.Hb;
import io.appmetrica.analytics.impl.InterfaceC0255fo;
import io.appmetrica.analytics.impl.Xm;
import io.appmetrica.analytics.impl.Ym;
import io.appmetrica.analytics.impl.Zk;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class FirstPartyDataPhoneSha256Attribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0616u6 f1319a = new C0616u6("appmetrica_1pd_phone_sha256", new C0136b8(), new Hb(new C0440n4(100)));
    private final Zk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirstPartyDataPhoneSha256Attribute(Zk zk) {
        this.b = zk;
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withPhoneValues(String... strArr) {
        return withPhoneValues(Arrays.asList(strArr));
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withPhoneValues(Iterable<String> iterable) {
        String str = this.f1319a.c;
        ArrayList a2 = this.b.a(iterable);
        Ym ym = new Ym(200, "First party data phones attribute", PublicLogger.getAnonymousInstance());
        C0616u6 c0616u6 = this.f1319a;
        return new UserProfileUpdate<>(new Xm(str, a2, 10, ym, c0616u6.f1144a, new C0589t4(c0616u6.b)));
    }
}
