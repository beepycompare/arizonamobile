package com.arkivanov.essenty.statekeeper;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.PropertyDelegateProvider;
import kotlin.properties.ReadOnlyProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.serialization.KSerializer;
/* compiled from: StateKeeperExt.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0087\u0001\u0010\u0000\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u0001H\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00040\nH\u0007\u001a\u0087\u0001\u0010\u0000\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0005*\u00020\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u0001H\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00040\nH\u0007\u001aV\u0010\u0000\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00040\u00120\u0001\"\u0004\b\u0000\u0010\u0004*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0013H\u0007\u001aV\u0010\u0000\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00040\u00120\u0001\"\u0004\b\u0000\u0010\u0004*\u00020\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0013H\u0007¨\u0006\u0014"}, d2 = {"saveable", "Lkotlin/properties/PropertyDelegateProvider;", "", "Lkotlin/properties/ReadOnlyProperty;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "serializer", "Lkotlinx/serialization/KSerializer;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlin/Function1;", "key", "", "init", "Lkotlin/ParameterName;", "name", "savedState", "Lcom/arkivanov/essenty/statekeeper/StateKeeperOwner;", "Lkotlin/properties/ReadWriteProperty;", "Lkotlin/Function0;", "state-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StateKeeperExtKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object saveable$lambda$2$lambda$1(Object obj, Object obj2, KProperty kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "<unused var>");
        return obj;
    }

    public static /* synthetic */ PropertyDelegateProvider saveable$default(StateKeeper stateKeeper, KSerializer kSerializer, Function1 function1, String str, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return saveable(stateKeeper, kSerializer, function1, str, function12);
    }

    public static final <T, S> PropertyDelegateProvider<Object, ReadOnlyProperty<Object, T>> saveable(final StateKeeper stateKeeper, final KSerializer<S> serializer, final Function1<? super T, ? extends S> state, final String str, final Function1<? super S, ? extends T> init) {
        Intrinsics.checkNotNullParameter(stateKeeper, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(init, "init");
        return new PropertyDelegateProvider() { // from class: com.arkivanov.essenty.statekeeper.StateKeeperExtKt$$ExternalSyntheticLambda4
            @Override // kotlin.properties.PropertyDelegateProvider
            public final Object provideDelegate(Object obj, KProperty kProperty) {
                ReadOnlyProperty saveable$lambda$2;
                saveable$lambda$2 = StateKeeperExtKt.saveable$lambda$2(str, serializer, init, stateKeeper, state, obj, kProperty);
                return saveable$lambda$2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReadOnlyProperty saveable$lambda$2(String str, KSerializer kSerializer, Function1 function1, StateKeeper stateKeeper, final Function1 function12, Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (str == null) {
            str = "SAVEABLE_HOLDER_" + property.getName();
        }
        KSerializer serializer = Holder.Companion.serializer(kSerializer);
        Holder holder = (Holder) stateKeeper.consume(str, serializer);
        final Object invoke = function1.invoke(holder != null ? holder.getValue() : null);
        stateKeeper.register(str, serializer, new Function0() { // from class: com.arkivanov.essenty.statekeeper.StateKeeperExtKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Holder saveable$lambda$2$lambda$0;
                saveable$lambda$2$lambda$0 = StateKeeperExtKt.saveable$lambda$2$lambda$0(Function1.this, invoke);
                return saveable$lambda$2$lambda$0;
            }
        });
        return new ReadOnlyProperty() { // from class: com.arkivanov.essenty.statekeeper.StateKeeperExtKt$$ExternalSyntheticLambda1
            @Override // kotlin.properties.ReadOnlyProperty
            public final Object getValue(Object obj2, KProperty kProperty) {
                Object saveable$lambda$2$lambda$1;
                saveable$lambda$2$lambda$1 = StateKeeperExtKt.saveable$lambda$2$lambda$1(invoke, obj2, kProperty);
                return saveable$lambda$2$lambda$1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Holder saveable$lambda$2$lambda$0(Function1 function1, Object obj) {
        return new Holder(function1.invoke(obj));
    }

    public static /* synthetic */ PropertyDelegateProvider saveable$default(StateKeeperOwner stateKeeperOwner, KSerializer kSerializer, Function1 function1, String str, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return saveable(stateKeeperOwner, kSerializer, function1, str, function12);
    }

    public static final <T, S> PropertyDelegateProvider<Object, ReadOnlyProperty<Object, T>> saveable(StateKeeperOwner stateKeeperOwner, KSerializer<S> serializer, Function1<? super T, ? extends S> state, String str, Function1<? super S, ? extends T> init) {
        Intrinsics.checkNotNullParameter(stateKeeperOwner, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(init, "init");
        return saveable(stateKeeperOwner.getStateKeeper(), serializer, state, str, init);
    }

    public static /* synthetic */ PropertyDelegateProvider saveable$default(StateKeeper stateKeeper, KSerializer kSerializer, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return saveable(stateKeeper, kSerializer, str, function0);
    }

    public static final <T> PropertyDelegateProvider<Object, ReadWriteProperty<Object, T>> saveable(final StateKeeper stateKeeper, final KSerializer<T> serializer, final String str, final Function0<? extends T> init) {
        Intrinsics.checkNotNullParameter(stateKeeper, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(init, "init");
        return new PropertyDelegateProvider() { // from class: com.arkivanov.essenty.statekeeper.StateKeeperExtKt$$ExternalSyntheticLambda3
            @Override // kotlin.properties.PropertyDelegateProvider
            public final Object provideDelegate(Object obj, KProperty kProperty) {
                Holder saveable$lambda$4;
                saveable$lambda$4 = StateKeeperExtKt.saveable$lambda$4(str, serializer, stateKeeper, init, obj, kProperty);
                return saveable$lambda$4;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Holder saveable$lambda$4(String str, KSerializer kSerializer, StateKeeper stateKeeper, Function0 function0, Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (str == null) {
            str = "SAVEABLE_" + property.getName();
        }
        KSerializer serializer = Holder.Companion.serializer(kSerializer);
        final Holder holder = (Holder) stateKeeper.consume(str, serializer);
        if (holder == null) {
            holder = new Holder(function0.invoke());
        }
        stateKeeper.register(str, serializer, new Function0() { // from class: com.arkivanov.essenty.statekeeper.StateKeeperExtKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Holder saveable$lambda$4$lambda$3;
                saveable$lambda$4$lambda$3 = StateKeeperExtKt.saveable$lambda$4$lambda$3(Holder.this);
                return saveable$lambda$4$lambda$3;
            }
        });
        return holder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Holder saveable$lambda$4$lambda$3(Holder holder) {
        return new Holder(holder.getValue());
    }

    public static /* synthetic */ PropertyDelegateProvider saveable$default(StateKeeperOwner stateKeeperOwner, KSerializer kSerializer, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return saveable(stateKeeperOwner, kSerializer, str, function0);
    }

    public static final <T> PropertyDelegateProvider<Object, ReadWriteProperty<Object, T>> saveable(StateKeeperOwner stateKeeperOwner, KSerializer<T> serializer, String str, Function0<? extends T> init) {
        Intrinsics.checkNotNullParameter(stateKeeperOwner, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(init, "init");
        return saveable(stateKeeperOwner.getStateKeeper(), serializer, str, init);
    }
}
