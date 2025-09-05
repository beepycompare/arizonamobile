package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0287gn;
import io.appmetrica.analytics.impl.C0311hl;
import io.appmetrica.analytics.impl.C0729y8;
import io.appmetrica.analytics.impl.C0754z8;
import io.appmetrica.analytics.impl.Hl;
import io.appmetrica.analytics.impl.InterfaceC0391ko;
import io.appmetrica.analytics.impl.Q4;
import io.appmetrica.analytics.impl.S6;
import io.appmetrica.analytics.impl.Xi;
/* loaded from: classes4.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final S6 f1273a = new S6("appmetrica_gender", new C0754z8(), new Hl());

    /* loaded from: classes4.dex */
    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1274a;

        Gender(String str) {
            this.f1274a = str;
        }

        public String getStringValue() {
            return this.f1274a;
        }
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withValue(Gender gender) {
        String str = this.f1273a.c;
        String stringValue = gender.getStringValue();
        C0729y8 c0729y8 = new C0729y8();
        S6 s6 = this.f1273a;
        return new UserProfileUpdate<>(new C0287gn(str, stringValue, c0729y8, s6.f662a, new Q4(s6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withValueIfUndefined(Gender gender) {
        String str = this.f1273a.c;
        String stringValue = gender.getStringValue();
        C0729y8 c0729y8 = new C0729y8();
        S6 s6 = this.f1273a;
        return new UserProfileUpdate<>(new C0287gn(str, stringValue, c0729y8, s6.f662a, new C0311hl(s6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0391ko> withValueReset() {
        S6 s6 = this.f1273a;
        return new UserProfileUpdate<>(new Xi(0, s6.c, s6.f662a, s6.b));
    }
}
