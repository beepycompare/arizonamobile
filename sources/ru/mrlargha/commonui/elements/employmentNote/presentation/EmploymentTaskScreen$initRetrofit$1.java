package ru.mrlargha.commonui.elements.employmentNote.presentation;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen;
import ru.mrlargha.commonui.elements.employmentNote.presentation.adapter.TaskAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EmploymentTaskScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$initRetrofit$1", f = "EmploymentTaskScreen.kt", i = {}, l = {157, 158}, m = "invokeSuspend", n = {}, nl = {158, 161}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class EmploymentTaskScreen$initRetrofit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ EmploymentTaskScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmploymentTaskScreen$initRetrofit$1(EmploymentTaskScreen employmentTaskScreen, Continuation<? super EmploymentTaskScreen$initRetrofit$1> continuation) {
        super(2, continuation);
        this.this$0 = employmentTaskScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EmploymentTaskScreen$initRetrofit$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EmploymentTaskScreen$initRetrofit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
        if (r7 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$initRetrofit$1.AnonymousClass1(r6.this$0, null), r6) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        EmploymentTaskScreen.Companion companion;
        TaskApi taskApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            companion = EmploymentTaskScreen.Companion;
            taskApi = this.this$0.api;
            this.L$0 = companion;
            this.label = 1;
            obj = TaskApi.get$default(taskApi, null, this, 1, null);
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            companion = (EmploymentTaskScreen.Companion) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        companion.setFractionTasks((List) obj);
        this.L$0 = null;
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmploymentTaskScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$initRetrofit$1$1", f = "EmploymentTaskScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.commonui.elements.employmentNote.presentation.EmploymentTaskScreen$initRetrofit$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ EmploymentTaskScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EmploymentTaskScreen employmentTaskScreen, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = employmentTaskScreen;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            TaskAdapter taskAdapter;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                taskAdapter = this.this$0.taskAdapter;
                if (taskAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("taskAdapter");
                    taskAdapter = null;
                }
                taskAdapter.notifyDataSetChanged();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
