package ru.rustore.sdk.metrics.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public abstract class W {

    /* loaded from: classes6.dex */
    public static final class a extends W {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1488a = new a();
    }

    /* loaded from: classes6.dex */
    public static final class b extends W {

        /* renamed from: a  reason: collision with root package name */
        public final List<D> f1489a;

        public b(ArrayList values) {
            Intrinsics.checkNotNullParameter(values, "values");
            this.f1489a = values;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f1489a, ((b) obj).f1489a);
        }

        public final int hashCode() {
            return this.f1489a.hashCode();
        }

        public final String toString() {
            return "Sent(values=" + this.f1489a + ')';
        }
    }
}
