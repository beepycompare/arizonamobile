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
import io.appmetrica.analytics.impl.R2;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
/* loaded from: classes3.dex */
public class BirthDateAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final A6 f1316a = new A6("appmetrica_birth_date", new C0265g8(), new Cl());

    final UserProfileUpdate a(Calendar calendar, String str, R2 r2) {
        return new UserProfileUpdate(new C0151bn(this.f1316a.c, new SimpleDateFormat(str).format(calendar.getTime()), new C0239f8(), new C0265g8(), r2));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withAge(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new C0739z4(this.f1316a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withAgeIfUndefined(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new C0175cl(this.f1316a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withBirthDate(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new C0739z4(this.f1316a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withBirthDateIfUndefined(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new C0175cl(this.f1316a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withValueReset() {
        return new UserProfileUpdate<>(new Gi(0, this.f1316a.c, new C0265g8(), new Cl()));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withBirthDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new C0739z4(this.f1316a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withBirthDateIfUndefined(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new C0175cl(this.f1316a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withBirthDate(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new C0739z4(this.f1316a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withBirthDateIfUndefined(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new C0175cl(this.f1316a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withBirthDate(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new C0739z4(this.f1316a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0281go> withBirthDateIfUndefined(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new C0175cl(this.f1316a.b));
    }
}
