package com.arkivanov.decompose.router.slot;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.GenericComponentContext;
import com.arkivanov.decompose.router.children.ChildrenFactoryKt;
import com.arkivanov.decompose.router.children.NavigationSource;
import com.arkivanov.decompose.router.slot.SlotNavigation;
import com.arkivanov.decompose.value.Value;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.SerializableContainerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
/* compiled from: ChildSlotFactory.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¸\u0001\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00020\u0001\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u0006\"\b\b\u0001\u0010\u0003*\u00020\u0007\"\b\b\u0002\u0010\u0004*\u00020\u0007*\u0002H\u00052\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\u0013\u001a#\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00040\u0014¢\u0006\u0002\u0010\u0018\u001aÖ\u0001\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00020\u0001\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u0006\"\b\b\u0001\u0010\u0003*\u00020\u0007\"\b\b\u0002\u0010\u0004*\u00020\u0007*\u0002H\u00052\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\n0\t2\u0016\u0010\u0019\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u001a2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\u0013\u001a#\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00040\u0014¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"childSlot", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/slot/ChildSlot;", "C", ExifInterface.GPS_DIRECTION_TRUE, "Ctx", "Lcom/arkivanov/decompose/GenericComponentContext;", "", "source", "Lcom/arkivanov/decompose/router/children/NavigationSource;", "Lcom/arkivanov/decompose/router/slot/SlotNavigation$Event;", "serializer", "Lkotlinx/serialization/KSerializer;", "initialConfiguration", "Lkotlin/Function0;", "key", "", "handleBackButton", "", "childFactory", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "configuration", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function0;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "saveConfiguration", "Lkotlin/Function1;", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "restoreConfiguration", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildSlotFactoryKt {
    public static /* synthetic */ Value childSlot$default(GenericComponentContext genericComponentContext, NavigationSource navigationSource, KSerializer kSerializer, Function0 function0, String str, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.decompose.router.slot.ChildSlotFactoryKt$childSlot$1
                @Override // kotlin.jvm.functions.Function0
                public final Void invoke() {
                    return null;
                }
            };
        }
        Function0 function02 = function0;
        if ((i & 8) != 0) {
            str = "DefaultChildSlot";
        }
        String str2 = str;
        if ((i & 16) != 0) {
            z = false;
        }
        return childSlot(genericComponentContext, navigationSource, kSerializer, function02, str2, z, function2);
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, C, T> Value<ChildSlot<C, T>> childSlot(Ctx ctx, NavigationSource<SlotNavigation.Event<C>> source, final KSerializer<C> kSerializer, Function0<? extends C> initialConfiguration, String key, boolean z, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialConfiguration, "initialConfiguration");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        return childSlot(ctx, source, new Function1() { // from class: com.arkivanov.decompose.router.slot.ChildSlotFactoryKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SerializableContainer childSlot$lambda$0;
                childSlot$lambda$0 = ChildSlotFactoryKt.childSlot$lambda$0(KSerializer.this, obj);
                return childSlot$lambda$0;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.slot.ChildSlotFactoryKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object childSlot$lambda$1;
                childSlot$lambda$1 = ChildSlotFactoryKt.childSlot$lambda$1(KSerializer.this, (SerializableContainer) obj);
                return childSlot$lambda$1;
            }
        }, key, initialConfiguration, z, childFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerializableContainer childSlot$lambda$0(KSerializer kSerializer, Object obj) {
        if (kSerializer == null || obj == null) {
            return null;
        }
        return SerializableContainerKt.SerializableContainer(obj, kSerializer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object childSlot$lambda$1(KSerializer kSerializer, SerializableContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (kSerializer != null) {
            return SerializableContainerKt.consumeRequired(container, kSerializer);
        }
        return null;
    }

    public static /* synthetic */ Value childSlot$default(GenericComponentContext genericComponentContext, NavigationSource navigationSource, Function1 function1, Function1 function12, String str, Function0 function0, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            str = "DefaultChildSlot";
        }
        String str2 = str;
        if ((i & 16) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.decompose.router.slot.ChildSlotFactoryKt$childSlot$4
                @Override // kotlin.jvm.functions.Function0
                public final Void invoke() {
                    return null;
                }
            };
        }
        Function0 function02 = function0;
        if ((i & 32) != 0) {
            z = false;
        }
        return childSlot(genericComponentContext, navigationSource, function1, function12, str2, function02, z, function2);
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, C, T> Value<ChildSlot<C, T>> childSlot(Ctx ctx, NavigationSource<SlotNavigation.Event<C>> source, final Function1<? super C, SerializableContainer> saveConfiguration, final Function1<? super SerializableContainer, ? extends C> restoreConfiguration, String key, final Function0<? extends C> initialConfiguration, final boolean z, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Value<ChildSlot<C, T>> children;
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(saveConfiguration, "saveConfiguration");
        Intrinsics.checkNotNullParameter(restoreConfiguration, "restoreConfiguration");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(initialConfiguration, "initialConfiguration");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        children = ChildrenFactoryKt.children(ctx, source, key, new Function0() { // from class: com.arkivanov.decompose.router.slot.ChildSlotFactoryKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SlotNavState childSlot$lambda$2;
                childSlot$lambda$2 = ChildSlotFactoryKt.childSlot$lambda$2(Function0.this);
                return childSlot$lambda$2;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.slot.ChildSlotFactoryKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SerializableContainer childSlot$lambda$3;
                childSlot$lambda$3 = ChildSlotFactoryKt.childSlot$lambda$3(Function1.this, (SlotNavState) obj);
                return childSlot$lambda$3;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.slot.ChildSlotFactoryKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SlotNavState childSlot$lambda$4;
                childSlot$lambda$4 = ChildSlotFactoryKt.childSlot$lambda$4(Function1.this, (SerializableContainer) obj);
                return childSlot$lambda$4;
            }
        }, new Function2() { // from class: com.arkivanov.decompose.router.slot.ChildSlotFactoryKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                SlotNavState childSlot$lambda$5;
                childSlot$lambda$5 = ChildSlotFactoryKt.childSlot$lambda$5((SlotNavState) obj, (SlotNavigation.Event) obj2);
                return childSlot$lambda$5;
            }
        }, new Function2() { // from class: com.arkivanov.decompose.router.slot.ChildSlotFactoryKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                ChildSlot childSlot$lambda$6;
                childSlot$lambda$6 = ChildSlotFactoryKt.childSlot$lambda$6((SlotNavState) obj, (List) obj2);
                return childSlot$lambda$6;
            }
        }, (r26 & 128) != 0 ? new Function2() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit children$lambda$4;
                children$lambda$4 = ChildrenFactoryKt.children$lambda$4((NavState) obj, (NavState) obj2);
                return children$lambda$4;
            }
        } : null, (r26 & 256) != 0 ? new Function3() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit children$lambda$5;
                children$lambda$5 = ChildrenFactoryKt.children$lambda$5(obj, (NavState) obj2, (NavState) obj3);
                return children$lambda$5;
            }
        } : new Function3() { // from class: com.arkivanov.decompose.router.slot.ChildSlotFactoryKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit childSlot$lambda$7;
                childSlot$lambda$7 = ChildSlotFactoryKt.childSlot$lambda$7((SlotNavigation.Event) obj, (SlotNavState) obj2, (SlotNavState) obj3);
                return childSlot$lambda$7;
            }
        }, (r26 & 512) != 0 ? new Function1() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$children$8
            /* JADX WARN: Incorrect types in method signature: (TN;)Ljava/lang/Void; */
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(NavState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        } : new Function1() { // from class: com.arkivanov.decompose.router.slot.ChildSlotFactoryKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Function0 childSlot$lambda$9;
                childSlot$lambda$9 = ChildSlotFactoryKt.childSlot$lambda$9(z, (SlotNavState) obj);
                return childSlot$lambda$9;
            }
        }, childFactory);
        return children;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SlotNavState childSlot$lambda$2(Function0 function0) {
        return new SlotNavState(function0.invoke());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerializableContainer childSlot$lambda$3(Function1 function1, SlotNavState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (SerializableContainer) function1.invoke(it.getConfiguration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SlotNavState childSlot$lambda$4(Function1 function1, SerializableContainer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new SlotNavState(function1.invoke(it));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SlotNavState childSlot$lambda$5(SlotNavState state, SlotNavigation.Event event) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(event, "event");
        return new SlotNavState(event.getTransformer().invoke(state.getConfiguration()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChildSlot childSlot$lambda$6(SlotNavState slotNavState, List children) {
        Intrinsics.checkNotNullParameter(slotNavState, "<unused var>");
        Intrinsics.checkNotNullParameter(children, "children");
        Object firstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) children);
        return new ChildSlot(firstOrNull instanceof Child.Created ? (Child.Created) firstOrNull : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit childSlot$lambda$7(SlotNavigation.Event event, SlotNavState newState, SlotNavState oldState) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        event.getOnComplete().invoke(newState.getConfiguration(), oldState.getConfiguration());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 childSlot$lambda$9(boolean z, SlotNavState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!z || state.getConfiguration() == null) {
            return null;
        }
        return new Function0() { // from class: com.arkivanov.decompose.router.slot.ChildSlotFactoryKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SlotNavState childSlot$lambda$9$lambda$8;
                childSlot$lambda$9$lambda$8 = ChildSlotFactoryKt.childSlot$lambda$9$lambda$8();
                return childSlot$lambda$9$lambda$8;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SlotNavState childSlot$lambda$9$lambda$8() {
        return new SlotNavState(null);
    }
}
