package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0526q8;
import io.appmetrica.analytics.impl.C0550r8;
import io.appmetrica.analytics.impl.C0663vl;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Li;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.Um;
import io.appmetrica.analytics.impl.Vk;
import io.appmetrica.analytics.impl.W2;
import io.appmetrica.analytics.impl.Yn;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
/* loaded from: classes4.dex */
public class BirthDateAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1252a = new L6("appmetrica_birth_date", new C0550r8(), new C0663vl());

    final UserProfileUpdate a(Calendar calendar, String str, W2 w2) {
        return new UserProfileUpdate(new Um(this.f1252a.c, new SimpleDateFormat(str).format(calendar.getTime()), new C0526q8(), new C0550r8(), w2));
    }

    public UserProfileUpdate<? extends Yn> withAge(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new N4(this.f1252a.b));
    }

    public UserProfileUpdate<? extends Yn> withAgeIfUndefined(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new Vk(this.f1252a.b));
    }

    public UserProfileUpdate<? extends Yn> withBirthDate(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new N4(this.f1252a.b));
    }

    public UserProfileUpdate<? extends Yn> withBirthDateIfUndefined(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new Vk(this.f1252a.b));
    }

    public UserProfileUpdate<? extends Yn> withValueReset() {
        return new UserProfileUpdate<>(new Li(0, this.f1252a.c, new C0550r8(), new C0663vl()));
    }

    public UserProfileUpdate<? extends Yn> withBirthDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new N4(this.f1252a.b));
    }

    public UserProfileUpdate<? extends Yn> withBirthDateIfUndefined(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new Vk(this.f1252a.b));
    }

    public UserProfileUpdate<? extends Yn> withBirthDate(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new N4(this.f1252a.b));
    }

    public UserProfileUpdate<? extends Yn> withBirthDateIfUndefined(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new Vk(this.f1252a.b));
    }

    public UserProfileUpdate<? extends Yn> withBirthDate(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new N4(this.f1252a.b));
    }

    public UserProfileUpdate<? extends Yn> withBirthDateIfUndefined(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new Vk(this.f1252a.b));
    }
}
