package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0326ic;
import io.appmetrica.analytics.impl.C0606t8;
import io.appmetrica.analytics.impl.C0751yn;
import io.appmetrica.analytics.impl.C0777zn;
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
    private final L6 f1413a = new L6("appmetrica_1pd_telegram_sha256", new C0606t8(), new C0326ic(new D4(100)));
    private final Dl b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirstPartyDataTelegramLoginSha256Attribute(Dl dl) {
        this.b = dl;
    }

    public UserProfileUpdate<? extends Ho> withTelegramLoginValues(String... strArr) {
        return withTelegramLoginValues(Arrays.asList(strArr));
    }

    public UserProfileUpdate<? extends Ho> withTelegramLoginValues(Iterable<String> iterable) {
        String str = this.f1413a.c;
        ArrayList a2 = this.b.a(iterable);
        C0777zn c0777zn = new C0777zn(200, "First party data telegram logins attribute", PublicLogger.getAnonymousInstance());
        L6 l6 = this.f1413a;
        return new UserProfileUpdate<>(new C0751yn(str, a2, 10, c0777zn, l6.f641a, new J4(l6.b)));
    }
}
