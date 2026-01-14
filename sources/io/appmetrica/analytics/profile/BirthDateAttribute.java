package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Bi;
import io.appmetrica.analytics.impl.C0114a8;
import io.appmetrica.analytics.impl.C0567s4;
import io.appmetrica.analytics.impl.C0594t6;
import io.appmetrica.analytics.impl.C0734yl;
import io.appmetrica.analytics.impl.InterfaceC0233eo;
import io.appmetrica.analytics.impl.J2;
import io.appmetrica.analytics.impl.Xk;
import io.appmetrica.analytics.impl.Ym;
import io.appmetrica.analytics.impl.Z7;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
/* loaded from: classes5.dex */
public class BirthDateAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0594t6 f1422a = new C0594t6("appmetrica_birth_date", new C0114a8(), new C0734yl());

    final UserProfileUpdate a(Calendar calendar, String str, J2 j2) {
        return new UserProfileUpdate(new Ym(this.f1422a.c, new SimpleDateFormat(str).format(calendar.getTime()), new Z7(), new C0114a8(), j2));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withAge(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new C0567s4(this.f1422a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withAgeIfUndefined(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new Xk(this.f1422a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withBirthDate(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new C0567s4(this.f1422a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withBirthDateIfUndefined(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new Xk(this.f1422a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withValueReset() {
        return new UserProfileUpdate<>(new Bi(0, this.f1422a.c, new C0114a8(), new C0734yl()));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withBirthDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new C0567s4(this.f1422a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withBirthDateIfUndefined(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new Xk(this.f1422a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withBirthDate(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new C0567s4(this.f1422a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withBirthDateIfUndefined(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new Xk(this.f1422a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withBirthDate(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new C0567s4(this.f1422a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0233eo> withBirthDateIfUndefined(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new Xk(this.f1422a.b));
    }
}
