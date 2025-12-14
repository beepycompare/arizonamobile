package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0109a8;
import io.appmetrica.analytics.impl.C0135b8;
import io.appmetrica.analytics.impl.C0588t4;
import io.appmetrica.analytics.impl.C0615u6;
import io.appmetrica.analytics.impl.C0755zl;
import io.appmetrica.analytics.impl.Ci;
import io.appmetrica.analytics.impl.InterfaceC0254fo;
import io.appmetrica.analytics.impl.K2;
import io.appmetrica.analytics.impl.Yk;
import io.appmetrica.analytics.impl.Zm;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
/* loaded from: classes5.dex */
public class BirthDateAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final C0615u6 f1412a = new C0615u6("appmetrica_birth_date", new C0135b8(), new C0755zl());

    final UserProfileUpdate a(Calendar calendar, String str, K2 k2) {
        return new UserProfileUpdate(new Zm(this.f1412a.c, new SimpleDateFormat(str).format(calendar.getTime()), new C0109a8(), new C0135b8(), k2));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withAge(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new C0588t4(this.f1412a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withAgeIfUndefined(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new Yk(this.f1412a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withBirthDate(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new C0588t4(this.f1412a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withBirthDateIfUndefined(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new Yk(this.f1412a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withValueReset() {
        return new UserProfileUpdate<>(new Ci(0, this.f1412a.c, new C0135b8(), new C0755zl()));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withBirthDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new C0588t4(this.f1412a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withBirthDateIfUndefined(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new Yk(this.f1412a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withBirthDate(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new C0588t4(this.f1412a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withBirthDateIfUndefined(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new Yk(this.f1412a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withBirthDate(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new C0588t4(this.f1412a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0254fo> withBirthDateIfUndefined(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new Yk(this.f1412a.b));
    }
}
