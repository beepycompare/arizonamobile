package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0114a8;
import io.appmetrica.analytics.impl.C0418m4;
import io.appmetrica.analytics.impl.C0567s4;
import io.appmetrica.analytics.impl.C0594t6;
import io.appmetrica.analytics.impl.Gb;
import io.appmetrica.analytics.impl.InterfaceC0233eo;
import io.appmetrica.analytics.impl.Wm;
import io.appmetrica.analytics.impl.Xm;
import io.appmetrica.analytics.impl.Yk;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class FirstPartyDataTelegramLoginSha256Attribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0594t6 f1427a = new C0594t6("appmetrica_1pd_telegram_sha256", new C0114a8(), new Gb(new C0418m4(100)));
    private final Yk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirstPartyDataTelegramLoginSha256Attribute(Yk yk) {
        this.b = yk;
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withTelegramLoginValues(String... strArr) {
        return withTelegramLoginValues(Arrays.asList(strArr));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withTelegramLoginValues(Iterable<String> iterable) {
        String str = this.f1427a.c;
        ArrayList a2 = this.b.a(iterable);
        Xm xm = new Xm(200, "First party data telegram logins attribute", PublicLogger.getAnonymousInstance());
        C0594t6 c0594t6 = this.f1427a;
        return new UserProfileUpdate<>(new Wm(str, a2, 10, xm, c0594t6.f1232a, new C0567s4(c0594t6.b)));
    }
}
