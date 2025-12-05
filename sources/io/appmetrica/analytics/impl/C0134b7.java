package io.appmetrica.analytics.impl;

import java.io.File;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.b7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0134b7 {

    /* renamed from: a  reason: collision with root package name */
    public final J6 f896a;
    public final ArrayList b;

    public C0134b7(File file) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        if (file != null) {
            this.f896a = new C0548re(file, new O6());
            arrayList.add(new C0548re(file, new C0373ke()));
        } else {
            this.f896a = new K6(new O6());
        }
        arrayList.add(new K6(new C0373ke()));
    }
}
