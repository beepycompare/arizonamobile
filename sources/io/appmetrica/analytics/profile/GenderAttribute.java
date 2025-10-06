package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0288gn;
import io.appmetrica.analytics.impl.C0312hl;
import io.appmetrica.analytics.impl.C0730y8;
import io.appmetrica.analytics.impl.C0755z8;
import io.appmetrica.analytics.impl.Hl;
import io.appmetrica.analytics.impl.InterfaceC0392ko;
import io.appmetrica.analytics.impl.Q4;
import io.appmetrica.analytics.impl.S6;
import io.appmetrica.analytics.impl.Xi;
/* loaded from: classes4.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final S6 f1278a = new S6("appmetrica_gender", new C0755z8(), new Hl());

    /* loaded from: classes4.dex */
    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1279a;

        Gender(String str) {
            this.f1279a = str;
        }

        public String getStringValue() {
            return this.f1279a;
        }
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValue(Gender gender) {
        String str = this.f1278a.c;
        String stringValue = gender.getStringValue();
        C0730y8 c0730y8 = new C0730y8();
        S6 s6 = this.f1278a;
        return new UserProfileUpdate<>(new C0288gn(str, stringValue, c0730y8, s6.f667a, new Q4(s6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValueIfUndefined(Gender gender) {
        String str = this.f1278a.c;
        String stringValue = gender.getStringValue();
        C0730y8 c0730y8 = new C0730y8();
        S6 s6 = this.f1278a;
        return new UserProfileUpdate<>(new C0288gn(str, stringValue, c0730y8, s6.f667a, new C0312hl(s6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValueReset() {
        S6 s6 = this.f1278a;
        return new UserProfileUpdate<>(new Xi(0, s6.c, s6.f667a, s6.b));
    }
}
