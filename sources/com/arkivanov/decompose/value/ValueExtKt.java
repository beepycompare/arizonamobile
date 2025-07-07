package com.arkivanov.decompose.value;

import androidx.exifinterface.media.ExifInterface;
import com.arizona.launcher.UpdateActivity;
import com.arkivanov.decompose.Cancellation;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.lifecycle.LifecycleExtKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;
/* compiled from: ValueExt.kt */
@Metadata(d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a@\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\t0\u000f¨\u0006\u0010"}, d2 = {"getValue", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/arkivanov/decompose/value/Value;", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Lcom/arkivanov/decompose/value/Value;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "subscribe", "", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", UpdateActivity.UPDATE_MODE, "Lcom/arkivanov/decompose/value/ObserveLifecycleMode;", "observer", "Lkotlin/Function1;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ValueExtKt {

    /* compiled from: ValueExt.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ObserveLifecycleMode.values().length];
            try {
                iArr[ObserveLifecycleMode.CREATE_DESTROY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ObserveLifecycleMode.START_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ObserveLifecycleMode.RESUME_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final <T> T getValue(Value<? extends T> value, Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(value, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        return value.getValue();
    }

    public static /* synthetic */ void subscribe$default(Value value, Lifecycle lifecycle, ObserveLifecycleMode observeLifecycleMode, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            observeLifecycleMode = ObserveLifecycleMode.START_STOP;
        }
        subscribe(value, lifecycle, observeLifecycleMode, function1);
    }

    public static final <T> void subscribe(final Value<? extends T> value, Lifecycle lifecycle, ObserveLifecycleMode mode, final Function1<? super T, Unit> observer) {
        Intrinsics.checkNotNullParameter(value, "<this>");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(observer, "observer");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            LifecycleExtKt.subscribe$default(lifecycle, new Function0() { // from class: com.arkivanov.decompose.value.ValueExtKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit subscribe$lambda$0;
                    subscribe$lambda$0 = ValueExtKt.subscribe$lambda$0(Ref.ObjectRef.this, value, observer);
                    return subscribe$lambda$0;
                }
            }, null, null, null, null, new Function0() { // from class: com.arkivanov.decompose.value.ValueExtKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit subscribe$lambda$1;
                    subscribe$lambda$1 = ValueExtKt.subscribe$lambda$1(Ref.ObjectRef.this);
                    return subscribe$lambda$1;
                }
            }, 30, null);
        } else if (i == 2) {
            LifecycleExtKt.subscribe$default(lifecycle, null, new Function0() { // from class: com.arkivanov.decompose.value.ValueExtKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit subscribe$lambda$2;
                    subscribe$lambda$2 = ValueExtKt.subscribe$lambda$2(Ref.ObjectRef.this, value, observer);
                    return subscribe$lambda$2;
                }
            }, null, null, new Function0() { // from class: com.arkivanov.decompose.value.ValueExtKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit subscribe$lambda$3;
                    subscribe$lambda$3 = ValueExtKt.subscribe$lambda$3(Ref.ObjectRef.this);
                    return subscribe$lambda$3;
                }
            }, null, 45, null);
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            LifecycleExtKt.subscribe$default(lifecycle, null, null, new Function0() { // from class: com.arkivanov.decompose.value.ValueExtKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit subscribe$lambda$4;
                    subscribe$lambda$4 = ValueExtKt.subscribe$lambda$4(Ref.ObjectRef.this, value, observer);
                    return subscribe$lambda$4;
                }
            }, new Function0() { // from class: com.arkivanov.decompose.value.ValueExtKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit subscribe$lambda$5;
                    subscribe$lambda$5 = ValueExtKt.subscribe$lambda$5(Ref.ObjectRef.this);
                    return subscribe$lambda$5;
                }
            }, null, null, 51, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.arkivanov.decompose.Cancellation, T] */
    public static final Unit subscribe$lambda$0(Ref.ObjectRef objectRef, Value value, Function1 function1) {
        objectRef.element = value.subscribe(function1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subscribe$lambda$1(Ref.ObjectRef objectRef) {
        Cancellation cancellation = (Cancellation) objectRef.element;
        if (cancellation != null) {
            cancellation.cancel();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.arkivanov.decompose.Cancellation, T] */
    public static final Unit subscribe$lambda$2(Ref.ObjectRef objectRef, Value value, Function1 function1) {
        objectRef.element = value.subscribe(function1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subscribe$lambda$3(Ref.ObjectRef objectRef) {
        Cancellation cancellation = (Cancellation) objectRef.element;
        if (cancellation != null) {
            cancellation.cancel();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.arkivanov.decompose.Cancellation, T] */
    public static final Unit subscribe$lambda$4(Ref.ObjectRef objectRef, Value value, Function1 function1) {
        objectRef.element = value.subscribe(function1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subscribe$lambda$5(Ref.ObjectRef objectRef) {
        Cancellation cancellation = (Cancellation) objectRef.element;
        if (cancellation != null) {
            cancellation.cancel();
        }
        return Unit.INSTANCE;
    }
}
