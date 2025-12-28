package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0109a8;
import io.appmetrica.analytics.impl.C0135b8;
import io.appmetrica.analytics.impl.C0588t4;
import io.appmetrica.analytics.impl.C0615u6;
import io.appmetrica.analytics.impl.C0755zl;
import io.appmetrica.analytics.impl.Ci;
import io.appmetrica.analytics.impl.InterfaceC0254fo;
import io.appmetrica.analytics.impl.Yk;
import io.appmetrica.analytics.impl.Zm;
/* loaded from: classes5.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0615u6 f1419a = new C0615u6("appmetrica_gender", new C0135b8(), new C0755zl());

    /* loaded from: classes5.dex */
    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1420a;

        Gender(String str) {
            this.f1420a = str;
        }

        public String getStringValue() {
            return this.f1420a;
        }
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValue(Gender gender) {
        String str = this.f1419a.c;
        String stringValue = gender.getStringValue();
        C0109a8 c0109a8 = new C0109a8();
        C0615u6 c0615u6 = this.f1419a;
        return new UserProfileUpdate<>(new Zm(str, stringValue, c0109a8, c0615u6.f1242a, new C0588t4(c0615u6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValueIfUndefined(Gender gender) {
        String str = this.f1419a.c;
        String stringValue = gender.getStringValue();
        C0109a8 c0109a8 = new C0109a8();
        C0615u6 c0615u6 = this.f1419a;
        return new UserProfileUpdate<>(new Zm(str, stringValue, c0109a8, c0615u6.f1242a, new Yk(c0615u6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValueReset() {
        C0615u6 c0615u6 = this.f1419a;
        return new UserProfileUpdate<>(new Ci(0, c0615u6.c, c0615u6.f1242a, c0615u6.b));
    }
}
