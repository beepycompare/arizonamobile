package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CompositionLocal.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00028\u0000H ¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0002\u0010\nJ(\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0002\b\u0010H\u0086\u0004J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0002\u0010\nJ1\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013H\u0010¢\u0006\u0002\b\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/ProvidableCompositionLocal;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/CompositionLocal;", "defaultFactory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "defaultProvidedValue", "Landroidx/compose/runtime/ProvidedValue;", "value", "defaultProvidedValue$runtime_release", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "provides", "providesComputed", "compute", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "providesDefault", "updatedStateOf", "Landroidx/compose/runtime/ValueHolder;", "previous", "updatedStateOf$runtime_release", "valueHolderOf", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ProvidableCompositionLocal<T> extends CompositionLocal<T> {
    public static final int $stable = 0;

    public abstract ProvidedValue<T> defaultProvidedValue$runtime_release(T t);

    public ProvidableCompositionLocal(Function0<? extends T> function0) {
        super(function0, null);
    }

    public final ProvidedValue<T> provides(T t) {
        return defaultProvidedValue$runtime_release(t);
    }

    public final ProvidedValue<T> providesDefault(T t) {
        return defaultProvidedValue$runtime_release(t).ifNotAlreadyProvided$runtime_release();
    }

    public final ProvidedValue<T> providesComputed(Function1<? super CompositionLocalAccessorScope, ? extends T> function1) {
        return new ProvidedValue<>(this, null, false, null, null, function1, false);
    }

    @Override // androidx.compose.runtime.CompositionLocal
    public ValueHolder<T> updatedStateOf$runtime_release(ProvidedValue<T> providedValue, ValueHolder<T> valueHolder) {
        ValueHolder<T> valueHolder2;
        ValueHolder<T> valueHolder3 = (ValueHolder<T>) false;
        if (valueHolder instanceof DynamicValueHolder) {
            DynamicValueHolder dynamicValueHolder = valueHolder3;
            if (providedValue.isDynamic$runtime_release()) {
                DynamicValueHolder dynamicValueHolder2 = (DynamicValueHolder) valueHolder;
                dynamicValueHolder2.getState().setValue(providedValue.getEffectiveValue$runtime_release());
                dynamicValueHolder = dynamicValueHolder2;
            }
            valueHolder2 = dynamicValueHolder;
        } else if (valueHolder instanceof StaticValueHolder) {
            StaticValueHolder staticValueHolder = valueHolder3;
            if (providedValue.isStatic$runtime_release()) {
                StaticValueHolder staticValueHolder2 = (StaticValueHolder) valueHolder;
                staticValueHolder = valueHolder3;
                if (Intrinsics.areEqual(providedValue.getEffectiveValue$runtime_release(), staticValueHolder2.getValue())) {
                    staticValueHolder = staticValueHolder2;
                }
            }
            valueHolder2 = staticValueHolder;
        } else {
            valueHolder2 = valueHolder3;
            if (valueHolder instanceof ComputedValueHolder) {
                ComputedValueHolder computedValueHolder = (ComputedValueHolder) valueHolder;
                ComputedValueHolder computedValueHolder2 = valueHolder3;
                if (providedValue.getCompute$runtime_release() == computedValueHolder.getCompute()) {
                    computedValueHolder2 = computedValueHolder;
                }
                valueHolder2 = computedValueHolder2;
            }
        }
        return valueHolder2 == null ? valueHolderOf(providedValue) : valueHolder2;
    }

    private final ValueHolder<T> valueHolderOf(ProvidedValue<T> providedValue) {
        if (!providedValue.isDynamic$runtime_release()) {
            return providedValue.getCompute$runtime_release() != null ? new ComputedValueHolder(providedValue.getCompute$runtime_release()) : providedValue.getState$runtime_release() != null ? new DynamicValueHolder(providedValue.getState$runtime_release()) : new StaticValueHolder(providedValue.getEffectiveValue$runtime_release());
        }
        MutableState<T> state$runtime_release = providedValue.getState$runtime_release();
        if (state$runtime_release == null) {
            T value = providedValue.getValue();
            SnapshotMutationPolicy<T> mutationPolicy$runtime_release = providedValue.getMutationPolicy$runtime_release();
            if (mutationPolicy$runtime_release == null) {
                mutationPolicy$runtime_release = SnapshotStateKt.structuralEqualityPolicy();
            }
            state$runtime_release = SnapshotStateKt.mutableStateOf(value, mutationPolicy$runtime_release);
        }
        return new DynamicValueHolder(state$runtime_release);
    }
}
