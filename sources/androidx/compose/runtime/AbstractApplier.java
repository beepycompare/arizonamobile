package androidx.compose.runtime;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
/* compiled from: Applier.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0010H$J\b\u0010\u0014\u001a\u00020\u0010H\u0016J*\u0010\u0015\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0004J\"\u0010\u001b\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0004R&\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000@TX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/AbstractApplier;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/Applier;", "root", "(Ljava/lang/Object;)V", "<set-?>", "current", "getCurrent", "()Ljava/lang/Object;", "setCurrent", "Ljava/lang/Object;", "getRoot", "stack", "Landroidx/compose/runtime/Stack;", "Ljava/util/ArrayList;", "clear", "", "down", "node", "onClear", "up", "move", "", "from", "", TypedValues.TransitionType.S_TO, "count", "remove", FirebaseAnalytics.Param.INDEX, "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AbstractApplier<T> implements Applier<T> {
    public static final int $stable = 8;
    private T current;
    private final T root;
    private final ArrayList<T> stack = Stack.m3505constructorimpl$default(null, 1, null);

    protected abstract void onClear();

    public AbstractApplier(T t) {
        this.root = t;
        this.current = t;
    }

    public final T getRoot() {
        return this.root;
    }

    @Override // androidx.compose.runtime.Applier
    public T getCurrent() {
        return this.current;
    }

    protected void setCurrent(T t) {
        this.current = t;
    }

    @Override // androidx.compose.runtime.Applier
    public void down(T t) {
        Stack.m3515pushimpl(this.stack, getCurrent());
        setCurrent(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.Applier
    public void up() {
        setCurrent(Stack.m3514popimpl(this.stack));
    }

    @Override // androidx.compose.runtime.Applier
    public final void clear() {
        Stack.m3503clearimpl(this.stack);
        setCurrent(this.root);
        onClear();
    }

    protected final void remove(List<T> list, int i, int i2) {
        if (i2 == 1) {
            list.remove(i);
        } else {
            list.subList(i, i2 + i).clear();
        }
    }

    protected final void move(List<T> list, int i, int i2, int i3) {
        int i4 = i > i2 ? i2 : i2 - i3;
        if (i3 != 1) {
            List<T> subList = list.subList(i, i3 + i);
            List mutableList = CollectionsKt.toMutableList((Collection) subList);
            subList.clear();
            list.addAll(i4, mutableList);
        } else if (i == i2 + 1 || i == i2 - 1) {
            list.set(i, list.set(i2, list.get(i)));
        } else {
            list.add(i4, list.remove(i));
        }
    }
}
