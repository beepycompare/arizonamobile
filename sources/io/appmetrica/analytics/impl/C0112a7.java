package io.appmetrica.analytics.impl;

import java.io.File;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.a7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0112a7 {

    /* renamed from: a  reason: collision with root package name */
    public final I6 f905a;
    public final ArrayList b;

    public C0112a7(File file) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        if (file != null) {
            this.f905a = new C0527qe(file, new N6());
            arrayList.add(new C0527qe(file, new C0351je()));
        } else {
            this.f905a = new J6(new N6());
        }
        arrayList.add(new J6(new C0351je()));
    }
}
