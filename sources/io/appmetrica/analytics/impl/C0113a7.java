package io.appmetrica.analytics.impl;

import java.io.File;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.a7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0113a7 {

    /* renamed from: a  reason: collision with root package name */
    public final I6 f901a;
    public final ArrayList b;

    public C0113a7(File file) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        if (file != null) {
            this.f901a = new C0528qe(file, new N6());
            arrayList.add(new C0528qe(file, new C0352je()));
        } else {
            this.f901a = new J6(new N6());
        }
        arrayList.add(new J6(new C0352je()));
    }
}
