package io.appmetrica.analytics.impl;

import java.io.File;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.r7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0551r7 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0112a7 f1181a;
    public final ArrayList b;

    public C0551r7(File file) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        if (file != null) {
            this.f1181a = new Re(file, new C0215e7());
            arrayList.add(new Re(file, new Le()));
        } else {
            this.f1181a = new C0138b7(new C0215e7());
        }
        arrayList.add(new C0138b7(new Le()));
    }
}
