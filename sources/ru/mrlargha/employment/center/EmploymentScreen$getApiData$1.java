package ru.mrlargha.employment.center;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EmploymentScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.employment.center.EmploymentScreen$getApiData$1", f = "EmploymentScreen.kt", i = {1, 1}, l = {113, 116}, m = "invokeSuspend", n = {"data", "list1"}, nl = {114, 120}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes6.dex */
public final class EmploymentScreen$getApiData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ EmploymentScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmploymentScreen$getApiData$1(EmploymentScreen employmentScreen, Continuation<? super EmploymentScreen$getApiData$1> continuation) {
        super(2, continuation);
        this.this$0 = employmentScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EmploymentScreen$getApiData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EmploymentScreen$getApiData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
        if (r8 == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008f, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.employment.center.EmploymentScreen$getApiData$1.AnonymousClass1(r7.this$0, r3, null), r7) == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0091, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        EmploymentApi employmentApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            employmentApi = this.this$0.api;
            this.label = 1;
            obj = employmentApi.getAll(this);
        } else if (i != 1) {
            if (i == 2) {
                List list = (List) this.L$1;
                List list2 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        List list3 = (List) obj;
        this.this$0.apiData = list3;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list3) {
            if (((Job) obj2).getType() == 0) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        this.L$0 = SpillingKt.nullOutSpilledVariable(list3);
        this.L$1 = SpillingKt.nullOutSpilledVariable(arrayList2);
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmploymentScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.employment.center.EmploymentScreen$getApiData$1$1", f = "EmploymentScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.employment.center.EmploymentScreen$getApiData$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Job> $list1;
        int label;
        final /* synthetic */ EmploymentScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EmploymentScreen employmentScreen, List<Job> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = employmentScreen;
            this.$list1 = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$list1, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            JobsAdapter jobsAdapter;
            JobsAdapter jobsAdapter2;
            JobsAdapter jobsAdapter3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                jobsAdapter = this.this$0.jobsAdapter;
                jobsAdapter.addAllItems(this.$list1);
                jobsAdapter2 = this.this$0.jobsAdapter;
                jobsAdapter3 = this.this$0.jobsAdapter;
                jobsAdapter2.select(jobsAdapter3.getSelected(), new Function1() { // from class: ru.mrlargha.employment.center.EmploymentScreen$getApiData$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit unit;
                        ((Integer) obj2).intValue();
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
