package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0324ic;
import io.appmetrica.analytics.impl.C0604t8;
import io.appmetrica.analytics.impl.C0749yn;
import io.appmetrica.analytics.impl.C0775zn;
import io.appmetrica.analytics.impl.D4;
import io.appmetrica.analytics.impl.Dl;
import io.appmetrica.analytics.impl.Ho;
import io.appmetrica.analytics.impl.J4;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class FirstPartyDataPhoneSha256Attribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1415a = new L6("appmetrica_1pd_phone_sha256", new C0604t8(), new C0324ic(new D4(100)));
    private final Dl b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirstPartyDataPhoneSha256Attribute(Dl dl) {
        this.b = dl;
    }

    public UserProfileUpdate<? extends Ho> withPhoneValues(String... strArr) {
        return withPhoneValues(Arrays.asList(strArr));
    }

    public UserProfileUpdate<? extends Ho> withPhoneValues(Iterable<String> iterable) {
        String str = this.f1415a.c;
        ArrayList a2 = this.b.a(iterable);
        C0775zn c0775zn = new C0775zn(200, "First party data phones attribute", PublicLogger.getAnonymousInstance());
        L6 l6 = this.f1415a;
        return new UserProfileUpdate<>(new C0749yn(str, a2, 10, c0775zn, l6.f644a, new J4(l6.b)));
    }
}
