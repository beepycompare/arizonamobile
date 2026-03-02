package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0113a8;
import io.appmetrica.analytics.impl.C0417m4;
import io.appmetrica.analytics.impl.C0566s4;
import io.appmetrica.analytics.impl.C0593t6;
import io.appmetrica.analytics.impl.Gb;
import io.appmetrica.analytics.impl.InterfaceC0232eo;
import io.appmetrica.analytics.impl.Wm;
import io.appmetrica.analytics.impl.Xm;
import io.appmetrica.analytics.impl.Yk;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class FirstPartyDataEmailSha256Attribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0593t6 f1424a = new C0593t6("appmetrica_1pd_email_sha256", new C0113a8(), new Gb(new C0417m4(100)));
    private final Yk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirstPartyDataEmailSha256Attribute(Yk yk) {
        this.b = yk;
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withEmailValues(String... strArr) {
        return withEmailValues(Arrays.asList(strArr));
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withEmailValues(Iterable<String> iterable) {
        String str = this.f1424a.c;
        ArrayList a2 = this.b.a(iterable);
        Xm xm = new Xm(200, "First party data emails attribute", PublicLogger.getAnonymousInstance());
        C0593t6 c0593t6 = this.f1424a;
        return new UserProfileUpdate<>(new Wm(str, a2, 10, xm, c0593t6.f1231a, new C0566s4(c0593t6.b)));
    }
}
