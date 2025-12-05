package io.appmetrica.analytics.logger.common;

import android.util.Log;
import io.appmetrica.analytics.logger.common.impl.a;
import io.appmetrica.analytics.logger.common.impl.b;
import io.appmetrica.analytics.logger.common.impl.c;
import io.appmetrica.analytics.logger.common.impl.d;
import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class BaseImportantLogger {

    /* renamed from: a  reason: collision with root package name */
    private final c f1348a;

    public BaseImportantLogger(String str) {
        this.f1348a = new c(new d(str), new a(), new b());
    }

    public void info(String str, String str2, Object... objArr) {
        c cVar = this.f1348a;
        cVar.b.getClass();
        Iterator it = cVar.c.a(a.a(str, str2, objArr)).iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            String str4 = cVar.f1351a.f1352a;
            if (str3 == null) {
                str3 = "";
            }
            Log.println(4, str4, str3);
        }
    }
}
