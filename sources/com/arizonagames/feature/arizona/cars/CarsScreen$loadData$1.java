package com.arizonagames.feature.arizona.cars;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.arizona.cars.CarsApi;
import ru.mrlargha.arizona.cars.QualityType;
import ru.mrlargha.commonui.core.SAMPUIElement;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.cars.CarsScreen$loadData$1", f = "CarsScreen.kt", i = {}, l = {232, 233, 234}, m = "invokeSuspend", n = {}, nl = {233, 234, 239}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class CarsScreen$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ CarsScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CarsScreen$loadData$1(CarsScreen carsScreen, Continuation<? super CarsScreen$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = carsScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CarsScreen$loadData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CarsScreen$loadData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r8 == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
        if (r8 == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007d, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.arizonagames.feature.arizona.cars.CarsScreen$loadData$1.AnonymousClass1(r7.this$0, null), r7) == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CarsScreen carsScreen;
        CarsApi carsApi;
        CarsScreen carsScreen2;
        CarsApi carsApi2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            carsScreen = this.this$0;
            carsApi = carsScreen.api;
            this.L$0 = carsScreen;
            this.label = 1;
            obj = CarsApi.getQualityTypesCars$default(carsApi, null, this, 1, null);
        } else if (i == 1) {
            carsScreen = (CarsScreen) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i != 2) {
            if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            carsScreen2 = (CarsScreen) this.L$0;
            ResultKt.throwOnFailure(obj);
            carsScreen2.bonusType = (List) obj;
            this.L$0 = null;
            this.label = 3;
        }
        carsScreen.qualityTypeList = (List) obj;
        carsScreen2 = this.this$0;
        carsApi2 = carsScreen2.api;
        this.L$0 = carsScreen2;
        this.label = 2;
        obj = CarsApi.getQualityBonusesCars$default(carsApi2, null, this, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CarsScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizonagames.feature.arizona.cars.CarsScreen$loadData$1$1", f = "CarsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: com.arizonagames.feature.arizona.cars.CarsScreen$loadData$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CarsScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CarsScreen carsScreen, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = carsScreen;
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
            CarInfoSecondScreenListAdapter carInfoSecondScreenListAdapter;
            List<QualityType> list;
            CarInfoListAdapter carInfoListAdapter;
            List<QualityType> list2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SAMPUIElement.notifyClick$default(this.this$0, 6, 6, null, 4, null);
            carInfoSecondScreenListAdapter = this.this$0.carInfoSecondScreenListAdapter;
            list = this.this$0.qualityTypeList;
            carInfoSecondScreenListAdapter.addQualities(list);
            carInfoListAdapter = this.this$0.carInfoListAdapter;
            list2 = this.this$0.qualityTypeList;
            carInfoListAdapter.addQualities(list2);
            return Unit.INSTANCE;
        }
    }
}
