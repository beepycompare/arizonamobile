package io.appmetrica.analytics.impl;

import java.io.File;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.b7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0135b7 {

    /* renamed from: a  reason: collision with root package name */
    public final J6 f813a;
    public final ArrayList b;

    public C0135b7(File file) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        if (file != null) {
            this.f813a = new C0549re(file, new O6());
            arrayList.add(new C0549re(file, new C0374ke()));
        } else {
            this.f813a = new K6(new O6());
        }
        arrayList.add(new K6(new C0374ke()));
    }
}
