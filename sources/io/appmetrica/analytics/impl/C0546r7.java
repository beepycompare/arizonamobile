package io.appmetrica.analytics.impl;

import java.io.File;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.r7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0546r7 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0107a7 f1184a;
    public final ArrayList b;

    public C0546r7(File file) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        if (file != null) {
            this.f1184a = new Re(file, new C0210e7());
            arrayList.add(new Re(file, new Le()));
        } else {
            this.f1184a = new C0133b7(new C0210e7());
        }
        arrayList.add(new C0133b7(new Le()));
    }
}
