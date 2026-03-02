package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Bi;
import io.appmetrica.analytics.impl.C0113a8;
import io.appmetrica.analytics.impl.C0566s4;
import io.appmetrica.analytics.impl.C0593t6;
import io.appmetrica.analytics.impl.C0733yl;
import io.appmetrica.analytics.impl.InterfaceC0232eo;
import io.appmetrica.analytics.impl.Xk;
import io.appmetrica.analytics.impl.Ym;
import io.appmetrica.analytics.impl.Z7;
/* loaded from: classes5.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0593t6 f1427a = new C0593t6("appmetrica_gender", new C0113a8(), new C0733yl());

    /* loaded from: classes5.dex */
    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1428a;

        Gender(String str) {
            this.f1428a = str;
        }

        public String getStringValue() {
            return this.f1428a;
        }
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withValue(Gender gender) {
        String str = this.f1427a.c;
        String stringValue = gender.getStringValue();
        Z7 z7 = new Z7();
        C0593t6 c0593t6 = this.f1427a;
        return new UserProfileUpdate<>(new Ym(str, stringValue, z7, c0593t6.f1231a, new C0566s4(c0593t6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withValueIfUndefined(Gender gender) {
        String str = this.f1427a.c;
        String stringValue = gender.getStringValue();
        Z7 z7 = new Z7();
        C0593t6 c0593t6 = this.f1427a;
        return new UserProfileUpdate<>(new Ym(str, stringValue, z7, c0593t6.f1231a, new Xk(c0593t6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0232eo> withValueReset() {
        C0593t6 c0593t6 = this.f1427a;
        return new UserProfileUpdate<>(new Bi(0, c0593t6.c, c0593t6.f1231a, c0593t6.b));
    }
}
