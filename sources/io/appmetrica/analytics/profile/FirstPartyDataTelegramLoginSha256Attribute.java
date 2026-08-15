package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0325ic;
import io.appmetrica.analytics.impl.C0605t8;
import io.appmetrica.analytics.impl.C0750yn;
import io.appmetrica.analytics.impl.C0776zn;
import io.appmetrica.analytics.impl.D4;
import io.appmetrica.analytics.impl.Dl;
import io.appmetrica.analytics.impl.Ho;
import io.appmetrica.analytics.impl.J4;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class FirstPartyDataTelegramLoginSha256Attribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1416a = new L6("appmetrica_1pd_telegram_sha256", new C0605t8(), new C0325ic(new D4(100)));
    private final Dl b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirstPartyDataTelegramLoginSha256Attribute(Dl dl) {
        this.b = dl;
    }

    public UserProfileUpdate<? extends Ho> withTelegramLoginValues(String... strArr) {
        return withTelegramLoginValues(Arrays.asList(strArr));
    }

    public UserProfileUpdate<? extends Ho> withTelegramLoginValues(Iterable<String> iterable) {
        String str = this.f1416a.c;
        ArrayList a2 = this.b.a(iterable);
        C0776zn c0776zn = new C0776zn(200, "First party data telegram logins attribute", PublicLogger.getAnonymousInstance());
        L6 l6 = this.f1416a;
        return new UserProfileUpdate<>(new C0750yn(str, a2, 10, c0776zn, l6.f644a, new J4(l6.b)));
    }
}
