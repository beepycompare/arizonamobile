package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0110a8;
import io.appmetrica.analytics.impl.C0136b8;
import io.appmetrica.analytics.impl.C0589t4;
import io.appmetrica.analytics.impl.C0616u6;
import io.appmetrica.analytics.impl.C0756zl;
import io.appmetrica.analytics.impl.Ci;
import io.appmetrica.analytics.impl.InterfaceC0255fo;
import io.appmetrica.analytics.impl.Yk;
import io.appmetrica.analytics.impl.Zm;
/* loaded from: classes5.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0616u6 f1321a = new C0616u6("appmetrica_gender", new C0136b8(), new C0756zl());

    /* loaded from: classes5.dex */
    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1322a;

        Gender(String str) {
            this.f1322a = str;
        }

        public String getStringValue() {
            return this.f1322a;
        }
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withValue(Gender gender) {
        String str = this.f1321a.c;
        String stringValue = gender.getStringValue();
        C0110a8 c0110a8 = new C0110a8();
        C0616u6 c0616u6 = this.f1321a;
        return new UserProfileUpdate<>(new Zm(str, stringValue, c0110a8, c0616u6.f1144a, new C0589t4(c0616u6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withValueIfUndefined(Gender gender) {
        String str = this.f1321a.c;
        String stringValue = gender.getStringValue();
        C0110a8 c0110a8 = new C0110a8();
        C0616u6 c0616u6 = this.f1321a;
        return new UserProfileUpdate<>(new Zm(str, stringValue, c0110a8, c0616u6.f1144a, new Yk(c0616u6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0255fo> withValueReset() {
        C0616u6 c0616u6 = this.f1321a;
        return new UserProfileUpdate<>(new Ci(0, c0616u6.c, c0616u6.f1144a, c0616u6.b));
    }
}
