package ru.rustore.sdk.metrics.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public abstract class W {

    /* loaded from: classes4.dex */
    public static final class a extends W {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1438a = new a();
    }

    /* loaded from: classes4.dex */
    public static final class b extends W {

        /* renamed from: a  reason: collision with root package name */
        public final List<D> f1439a;

        public b(ArrayList values) {
            Intrinsics.checkNotNullParameter(values, "values");
            this.f1439a = values;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f1439a, ((b) obj).f1439a);
        }

        public final int hashCode() {
            return this.f1439a.hashCode();
        }

        public final String toString() {
            return "Sent(values=" + this.f1439a + ')';
        }
    }
}
