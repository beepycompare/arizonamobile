package androidx.core.os;

import android.os.PersistableBundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PersistableBundle.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u000b"}, d2 = {"Landroidx/core/os/PersistableBundleApi21ImplKt;", "", "<init>", "()V", "putValue", "", "persistableBundle", "Landroid/os/PersistableBundle;", "key", "", "value", "core-ktx"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class PersistableBundleApi21ImplKt {
    public static final PersistableBundleApi21ImplKt INSTANCE = new PersistableBundleApi21ImplKt();

    private PersistableBundleApi21ImplKt() {
    }

    @JvmStatic
    public static final void putValue(PersistableBundle persistableBundle, String str, Object obj) {
        if (obj == null) {
            persistableBundle.putString(str, null);
        } else if (obj instanceof Boolean) {
            persistableBundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            persistableBundle.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Integer) {
            persistableBundle.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof Long) {
            persistableBundle.putLong(str, ((Number) obj).longValue());
        } else if (obj instanceof String) {
            persistableBundle.putString(str, (String) obj);
        } else if (obj instanceof PersistableBundle) {
            persistableBundle.putPersistableBundle(str, (PersistableBundle) obj);
        } else if (obj instanceof boolean[]) {
            persistableBundle.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof double[]) {
            persistableBundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof int[]) {
            persistableBundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof long[]) {
            persistableBundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof Object[]) {
            Class<?> componentType = obj.getClass().getComponentType();
            Intrinsics.checkNotNull(componentType);
            if (String.class.isAssignableFrom(componentType)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                persistableBundle.putStringArray(str, (String[]) obj);
                return;
            }
            throw new IllegalArgumentException("Unsupported value array type " + componentType.getCanonicalName() + " for key \"" + str + '\"');
        } else {
            throw new IllegalArgumentException("Unsupported value type " + obj.getClass().getCanonicalName() + " for key \"" + str + '\"');
        }
    }
}
