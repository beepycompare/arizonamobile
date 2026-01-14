package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Bi;
import io.appmetrica.analytics.impl.C0114a8;
import io.appmetrica.analytics.impl.C0567s4;
import io.appmetrica.analytics.impl.C0594t6;
import io.appmetrica.analytics.impl.C0734yl;
import io.appmetrica.analytics.impl.InterfaceC0233eo;
import io.appmetrica.analytics.impl.Xk;
import io.appmetrica.analytics.impl.Ym;
import io.appmetrica.analytics.impl.Z7;
/* loaded from: classes5.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0594t6 f1428a = new C0594t6("appmetrica_gender", new C0114a8(), new C0734yl());

    /* loaded from: classes5.dex */
    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1429a;

        Gender(String str) {
            this.f1429a = str;
        }

        public String getStringValue() {
            return this.f1429a;
        }
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValue(Gender gender) {
        String str = this.f1428a.c;
        String stringValue = gender.getStringValue();
        Z7 z7 = new Z7();
        C0594t6 c0594t6 = this.f1428a;
        return new UserProfileUpdate<>(new Ym(str, stringValue, z7, c0594t6.f1232a, new C0567s4(c0594t6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValueIfUndefined(Gender gender) {
        String str = this.f1428a.c;
        String stringValue = gender.getStringValue();
        Z7 z7 = new Z7();
        C0594t6 c0594t6 = this.f1428a;
        return new UserProfileUpdate<>(new Ym(str, stringValue, z7, c0594t6.f1232a, new Xk(c0594t6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValueReset() {
        C0594t6 c0594t6 = this.f1428a;
        return new UserProfileUpdate<>(new Bi(0, c0594t6.c, c0594t6.f1232a, c0594t6.b));
    }
}
