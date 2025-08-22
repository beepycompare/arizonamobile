package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CompositionLocal.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00028\u0000H ¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0002\u0010\u000bJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0002\u0010\u000bJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0002\b\u0012H\u0086\u0004J1\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0014H\u0010¢\u0006\u0002\b\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/ProvidableCompositionLocal;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/CompositionLocal;", "defaultFactory", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "defaultProvidedValue", "Landroidx/compose/runtime/ProvidedValue;", "value", "defaultProvidedValue$runtime", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "provides", "providesDefault", "providesComputed", "compute", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "updatedStateOf", "Landroidx/compose/runtime/ValueHolder;", "previous", "updatedStateOf$runtime", "valueHolderOf", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ProvidableCompositionLocal<T> extends CompositionLocal<T> {
    public static final int $stable = 0;

    public abstract ProvidedValue<T> defaultProvidedValue$runtime(T t);

    public ProvidableCompositionLocal(Function0<? extends T> function0) {
        super(function0, null);
    }

    public final ProvidedValue<T> provides(T t) {
        return defaultProvidedValue$runtime(t);
    }

    public final ProvidedValue<T> providesDefault(T t) {
        return defaultProvidedValue$runtime(t).ifNotAlreadyProvided$runtime();
    }

    public final ProvidedValue<T> providesComputed(Function1<? super CompositionLocalAccessorScope, ? extends T> function1) {
        return new ProvidedValue<>(this, null, false, null, null, function1, false);
    }

    @Override // androidx.compose.runtime.CompositionLocal
    public ValueHolder<T> updatedStateOf$runtime(ProvidedValue<T> providedValue, ValueHolder<T> valueHolder) {
        ValueHolder<T> valueHolder2;
        ValueHolder<T> valueHolder3 = (ValueHolder<T>) false;
        if (valueHolder instanceof DynamicValueHolder) {
            DynamicValueHolder dynamicValueHolder = valueHolder3;
            if (providedValue.isDynamic$runtime()) {
                DynamicValueHolder dynamicValueHolder2 = (DynamicValueHolder) valueHolder;
                dynamicValueHolder2.getState().setValue(providedValue.getEffectiveValue$runtime());
                dynamicValueHolder = dynamicValueHolder2;
            }
            valueHolder2 = dynamicValueHolder;
        } else if (valueHolder instanceof StaticValueHolder) {
            StaticValueHolder staticValueHolder = valueHolder3;
            if (providedValue.isStatic$runtime()) {
                StaticValueHolder staticValueHolder2 = (StaticValueHolder) valueHolder;
                staticValueHolder = valueHolder3;
                if (Intrinsics.areEqual(providedValue.getEffectiveValue$runtime(), staticValueHolder2.getValue())) {
                    staticValueHolder = staticValueHolder2;
                }
            }
            valueHolder2 = staticValueHolder;
        } else {
            valueHolder2 = valueHolder3;
            if (valueHolder instanceof ComputedValueHolder) {
                ComputedValueHolder computedValueHolder = (ComputedValueHolder) valueHolder;
                ComputedValueHolder computedValueHolder2 = valueHolder3;
                if (providedValue.getCompute$runtime() == computedValueHolder.getCompute()) {
                    computedValueHolder2 = computedValueHolder;
                }
                valueHolder2 = computedValueHolder2;
            }
        }
        return valueHolder2 == null ? valueHolderOf(providedValue) : valueHolder2;
    }

    private final ValueHolder<T> valueHolderOf(ProvidedValue<T> providedValue) {
        if (!providedValue.isDynamic$runtime()) {
            return providedValue.getCompute$runtime() != null ? new ComputedValueHolder(providedValue.getCompute$runtime()) : providedValue.getState$runtime() != null ? new DynamicValueHolder(providedValue.getState$runtime()) : new StaticValueHolder(providedValue.getEffectiveValue$runtime());
        }
        MutableState<T> state$runtime = providedValue.getState$runtime();
        if (state$runtime == null) {
            T value = providedValue.getValue();
            SnapshotMutationPolicy<T> mutationPolicy$runtime = providedValue.getMutationPolicy$runtime();
            if (mutationPolicy$runtime == null) {
                mutationPolicy$runtime = SnapshotStateKt.structuralEqualityPolicy();
            }
            state$runtime = SnapshotStateKt.mutableStateOf(value, mutationPolicy$runtime);
        }
        return new DynamicValueHolder(state$runtime);
    }
}
