package ru.mrlargha.commonui.elements.radial_menu;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$checkModelType$3;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RadialMenuScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$checkModelType$3", f = "RadialMenuScreen.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class RadialMenuScreen$checkModelType$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RadialMenuScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadialMenuScreen$checkModelType$3(RadialMenuScreen radialMenuScreen, Continuation<? super RadialMenuScreen$checkModelType$3> continuation) {
        super(2, continuation);
        this.this$0 = radialMenuScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RadialMenuScreen$checkModelType$3(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RadialMenuScreen$checkModelType$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.showListSize;
            final RadialMenuScreen radialMenuScreen = this.this$0;
            this.label = 1;
            if (mutableStateFlow.collect(new FlowCollector() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$checkModelType$3.1

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: RadialMenuScreen.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$checkModelType$3$1$1", f = "RadialMenuScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$checkModelType$3$1$1  reason: invalid class name and collision with other inner class name */
                /* loaded from: classes5.dex */
                public static final class C01131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ int $listSize;
                    int label;
                    final /* synthetic */ RadialMenuScreen this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C01131(RadialMenuScreen radialMenuScreen, int i, Continuation<? super C01131> continuation) {
                        super(2, continuation);
                        this.this$0 = radialMenuScreen;
                        this.$listSize = i;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01131(this.this$0, this.$listSize, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C01131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        final RadialMenuScreen radialMenuScreen = this.this$0;
                        int i = this.$listSize;
                        Function0 function0 = new Function0() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$checkModelType$3$1$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = RadialMenuScreen$checkModelType$3.AnonymousClass1.C01131.invokeSuspend$lambda$1(RadialMenuScreen.this);
                                return invokeSuspend$lambda$1;
                            }
                        };
                        final RadialMenuScreen radialMenuScreen2 = this.this$0;
                        radialMenuScreen.setOnBottomBtnListener(i, function0, new Function0() { // from class: ru.mrlargha.commonui.elements.radial_menu.RadialMenuScreen$checkModelType$3$1$1$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit invokeSuspend$lambda$3;
                                invokeSuspend$lambda$3 = RadialMenuScreen$checkModelType$3.AnonymousClass1.C01131.invokeSuspend$lambda$3(RadialMenuScreen.this);
                                return invokeSuspend$lambda$3;
                            }
                        });
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invokeSuspend$lambda$1(RadialMenuScreen radialMenuScreen) {
                        CoroutineScope coroutineScope;
                        List list;
                        List list2;
                        coroutineScope = radialMenuScreen.scope;
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new RadialMenuScreen$checkModelType$3$1$1$1$1(radialMenuScreen, null), 3, null);
                        list = radialMenuScreen.actionList;
                        if (list != null) {
                            radialMenuScreen.setItems(list);
                        } else {
                            list2 = radialMenuScreen.itemList;
                            radialMenuScreen.setItems(list2);
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invokeSuspend$lambda$3(RadialMenuScreen radialMenuScreen) {
                        CoroutineScope coroutineScope;
                        List list;
                        List list2;
                        coroutineScope = radialMenuScreen.scope;
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new RadialMenuScreen$checkModelType$3$1$1$2$1(radialMenuScreen, null), 3, null);
                        list = radialMenuScreen.actionList;
                        if (list != null) {
                            radialMenuScreen.setItems(list);
                        } else {
                            list2 = radialMenuScreen.itemList;
                            radialMenuScreen.setItems(list2);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Number) obj2).intValue(), continuation);
                }

                public final Object emit(int i2, Continuation<? super Unit> continuation) {
                    Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new C01131(RadialMenuScreen.this, i2, null), continuation);
                    return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
