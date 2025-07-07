package androidx.lifecycle.serialization;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.serialization.SavedStateConfiguration;
import androidx.savedstate.serialization.SavedStateDecoderKt;
import androidx.savedstate.serialization.SavedStateEncoderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.serialization.KSerializer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SavedStateHandleDelegate.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0002J$\u0010\u001a\u001a\u00028\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0096\u0002¢\u0006\u0002\u0010\u001bJ,\u0010\u001c\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/serialization/SavedStateHandleDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/properties/ReadWriteProperty;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "serializer", "Lkotlinx/serialization/KSerializer;", "key", "", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "init", "Lkotlin/Function0;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Lkotlinx/serialization/KSerializer;Ljava/lang/String;Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlin/jvm/functions/Function0;)V", "value", "Ljava/lang/Object;", "loadValue", "(Ljava/lang/String;)Ljava/lang/Object;", "registerSave", "", "createDefaultKey", "thisRef", "property", "Lkotlin/reflect/KProperty;", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateHandleDelegate<T> implements ReadWriteProperty<Object, T> {
    private final SavedStateConfiguration configuration;
    private final Function0<T> init;
    private final String key;
    private final SavedStateHandle savedStateHandle;
    private final KSerializer<T> serializer;
    private T value;

    /* JADX WARN: Multi-variable type inference failed */
    public SavedStateHandleDelegate(SavedStateHandle savedStateHandle, KSerializer<T> serializer, String str, SavedStateConfiguration configuration, Function0<? extends T> init) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(init, "init");
        this.savedStateHandle = savedStateHandle;
        this.serializer = serializer;
        this.key = str;
        this.configuration = configuration;
        this.init = init;
    }

    private final T loadValue(String str) {
        Bundle bundle = (Bundle) this.savedStateHandle.get(str);
        if (bundle != null) {
            return (T) SavedStateDecoderKt.decodeFromSavedState(this.serializer, bundle, this.configuration);
        }
        return null;
    }

    private final void registerSave(String str) {
        this.savedStateHandle.setSavedStateProvider(str, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.serialization.SavedStateHandleDelegate$$ExternalSyntheticLambda0
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                Bundle registerSave$lambda$1;
                registerSave$lambda$1 = SavedStateHandleDelegate.registerSave$lambda$1(SavedStateHandleDelegate.this);
                return registerSave$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle registerSave$lambda$1(SavedStateHandleDelegate savedStateHandleDelegate) {
        KSerializer<T> kSerializer = savedStateHandleDelegate.serializer;
        Object obj = savedStateHandleDelegate.value;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("value");
            obj = Unit.INSTANCE;
        }
        return SavedStateEncoderKt.encodeToSavedState(kSerializer, obj, savedStateHandleDelegate.configuration);
    }

    private final String createDefaultKey(Object obj, KProperty<?> kProperty) {
        return (obj != null ? Reflection.getOrCreateKotlinClass(obj.getClass()).getQualifiedName() + '.' : "") + kProperty.getName();
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public T getValue(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (this.value == null) {
            String str = this.key;
            if (str == null) {
                str = createDefaultKey(obj, property);
            }
            registerSave(str);
            T loadValue = loadValue(str);
            if (loadValue == null) {
                loadValue = this.init.invoke();
            }
            this.value = loadValue;
        }
        T t = this.value;
        if (t == null) {
            Intrinsics.throwUninitializedPropertyAccessException("value");
            return (T) Unit.INSTANCE;
        }
        return t;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object obj, KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.value == null) {
            String str = this.key;
            if (str == null) {
                str = createDefaultKey(obj, property);
            }
            registerSave(str);
        }
        this.value = value;
    }
}
