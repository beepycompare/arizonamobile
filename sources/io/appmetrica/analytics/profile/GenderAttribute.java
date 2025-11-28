package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.A6;
import io.appmetrica.analytics.impl.C0151bn;
import io.appmetrica.analytics.impl.C0175cl;
import io.appmetrica.analytics.impl.C0239f8;
import io.appmetrica.analytics.impl.C0265g8;
import io.appmetrica.analytics.impl.C0739z4;
import io.appmetrica.analytics.impl.Cl;
import io.appmetrica.analytics.impl.Gi;
import io.appmetrica.analytics.impl.InterfaceC0281go;
/* loaded from: classes5.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final A6 f1319a = new A6("appmetrica_gender", new C0265g8(), new Cl());

    /* loaded from: classes5.dex */
    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1320a;

        Gender(String str) {
            this.f1320a = str;
        }

        public String getStringValue() {
            return this.f1320a;
        }
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValue(Gender gender) {
        String str = this.f1319a.c;
        String stringValue = gender.getStringValue();
        C0239f8 c0239f8 = new C0239f8();
        A6 a6 = this.f1319a;
        return new UserProfileUpdate<>(new C0151bn(str, stringValue, c0239f8, a6.f391a, new C0739z4(a6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValueIfUndefined(Gender gender) {
        String str = this.f1319a.c;
        String stringValue = gender.getStringValue();
        C0239f8 c0239f8 = new C0239f8();
        A6 a6 = this.f1319a;
        return new UserProfileUpdate<>(new C0151bn(str, stringValue, c0239f8, a6.f391a, new C0175cl(a6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValueReset() {
        A6 a6 = this.f1319a;
        return new UserProfileUpdate<>(new Gi(0, a6.c, a6.f391a, a6.b));
    }
}
