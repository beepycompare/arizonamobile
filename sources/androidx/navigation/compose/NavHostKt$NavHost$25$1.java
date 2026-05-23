package androidx.navigation.compose;

import androidx.activity.BackEventCompat;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NavHost.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "backEvent", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Landroidx/navigation/compose/internal/BackEventCompat;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$25$1", f = "NavHost.kt", i = {1}, l = {524, 534}, m = "invokeSuspend", n = {"currentBackStackEntry"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class NavHostKt$NavHost$25$1 extends SuspendLambda implements Function2<Flow<? extends BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComposeNavigator $composeNavigator;
    final /* synthetic */ State<List<NavBackStackEntry>> $currentBackStack$delegate;
    final /* synthetic */ MutableState<Boolean> $inPredictiveBack$delegate;
    final /* synthetic */ MutableFloatState $progress$delegate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavHostKt$NavHost$25$1(ComposeNavigator composeNavigator, State<? extends List<NavBackStackEntry>> state, MutableFloatState mutableFloatState, MutableState<Boolean> mutableState, Continuation<? super NavHostKt$NavHost$25$1> continuation) {
        super(2, continuation);
        this.$composeNavigator = composeNavigator;
        this.$currentBackStack$delegate = state;
        this.$progress$delegate = mutableFloatState;
        this.$inPredictiveBack$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NavHostKt$NavHost$25$1 navHostKt$NavHost$25$1 = new NavHostKt$NavHost$25$1(this.$composeNavigator, this.$currentBackStack$delegate, this.$progress$delegate, this.$inPredictiveBack$delegate, continuation);
        navHostKt$NavHost$25$1.L$0 = obj;
        return navHostKt$NavHost$25$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Flow<? extends BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return invoke2((Flow<BackEventCompat>) flow, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Flow<BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return ((NavHostKt$NavHost$25$1) create(flow, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
        if (r8.collect(androidx.navigation.compose.NavHostKt$NavHost$25$1.AnonymousClass1.INSTANCE, r7) == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List NavHost$lambda$38;
        List NavHost$lambda$382;
        List NavHost$lambda$383;
        List NavHost$lambda$384;
        NavBackStackEntry navBackStackEntry;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                } else if (i == 2) {
                    navBackStackEntry = (NavBackStackEntry) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.$composeNavigator.popBackStack(navBackStackEntry, false);
                    NavHostKt.NavHost$lambda$44(this.$inPredictiveBack$delegate, false);
                    return Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            ResultKt.throwOnFailure(obj);
            Flow flow = (Flow) this.L$0;
            NavHost$lambda$38 = NavHostKt.NavHost$lambda$38(this.$currentBackStack$delegate);
            if (NavHost$lambda$38.size() < 2) {
                this.label = 1;
            } else {
                this.$progress$delegate.setFloatValue(0.0f);
                NavHost$lambda$382 = NavHostKt.NavHost$lambda$38(this.$currentBackStack$delegate);
                NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.last((List<? extends Object>) NavHost$lambda$382);
                this.$composeNavigator.prepareForTransition(navBackStackEntry2);
                NavHost$lambda$383 = NavHostKt.NavHost$lambda$38(this.$currentBackStack$delegate);
                NavHost$lambda$384 = NavHostKt.NavHost$lambda$38(this.$currentBackStack$delegate);
                this.$composeNavigator.prepareForTransition((NavBackStackEntry) NavHost$lambda$383.get(NavHost$lambda$384.size() - 2));
                final MutableState<Boolean> mutableState = this.$inPredictiveBack$delegate;
                final MutableFloatState mutableFloatState = this.$progress$delegate;
                this.L$0 = navBackStackEntry2;
                this.label = 2;
                if (flow.collect(new FlowCollector() { // from class: androidx.navigation.compose.NavHostKt$NavHost$25$1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((BackEventCompat) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(BackEventCompat backEventCompat, Continuation<? super Unit> continuation) {
                        NavHostKt.NavHost$lambda$44(mutableState, true);
                        mutableFloatState.setFloatValue(backEventCompat.getProgress());
                        return Unit.INSTANCE;
                    }
                }, this) != coroutine_suspended) {
                    navBackStackEntry = navBackStackEntry2;
                    this.$composeNavigator.popBackStack(navBackStackEntry, false);
                    NavHostKt.NavHost$lambda$44(this.$inPredictiveBack$delegate, false);
                    return Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            NavHostKt.NavHost$lambda$44(this.$inPredictiveBack$delegate, false);
            throw th;
        }
        NavHostKt.NavHost$lambda$44(this.$inPredictiveBack$delegate, false);
        throw th;
    }
}
