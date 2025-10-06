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
import io.appmetrica.analytics.impl.Z2;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
/* loaded from: classes4.dex */
public class BirthDateAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final S6 f1275a = new S6("appmetrica_birth_date", new C0755z8(), new Hl());

    final UserProfileUpdate a(Calendar calendar, String str, Z2 z2) {
        return new UserProfileUpdate(new C0288gn(this.f1275a.c, new SimpleDateFormat(str).format(calendar.getTime()), new C0730y8(), new C0755z8(), z2));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withAge(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new Q4(this.f1275a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withAgeIfUndefined(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new C0312hl(this.f1275a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withBirthDate(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new Q4(this.f1275a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withBirthDateIfUndefined(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new C0312hl(this.f1275a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withValueReset() {
        return new UserProfileUpdate<>(new Xi(0, this.f1275a.c, new C0755z8(), new Hl()));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withBirthDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new Q4(this.f1275a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withBirthDateIfUndefined(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new C0312hl(this.f1275a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withBirthDate(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new Q4(this.f1275a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withBirthDateIfUndefined(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new C0312hl(this.f1275a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withBirthDate(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new Q4(this.f1275a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0392ko> withBirthDateIfUndefined(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new C0312hl(this.f1275a.b));
    }
}
