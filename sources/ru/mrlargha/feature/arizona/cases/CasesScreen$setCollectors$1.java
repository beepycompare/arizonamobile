package ru.mrlargha.feature.arizona.cases;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import androidx.compose.runtime.ComposerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.feature.arizona.cases.CasesScreen$setCollectors$1;
import ru.mrlargha.feature.arizona.cases.data.local.CasesSharedPreference;
import ru.mrlargha.feature.arizona.cases.data.remote.apiservices.CasesApiService;
import ru.mrlargha.feature.arizona.cases.data.remote.models.CasesModel;
import ru.mrlargha.feature.arizona.cases.data.remote.models.CasesPrizeModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CasesScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.arizona.cases.CasesScreen$setCollectors$1", f = "CasesScreen.kt", i = {}, l = {ComposerKt.compositionLocalMapKey, ComposerKt.providerKey, 214}, m = "invokeSuspend", n = {}, nl = {ComposerKt.providerKey, ComposerKt.providerMapsKey, 262}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class CasesScreen$setCollectors$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ CasesScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CasesScreen$setCollectors$1(CasesScreen casesScreen, Continuation<? super CasesScreen$setCollectors$1> continuation) {
        super(2, continuation);
        this.this$0 = casesScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CasesScreen$setCollectors$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CasesScreen$setCollectors$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
        if (r1.emit(r8, r7) == r0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b2, code lost:
        if (kotlinx.coroutines.flow.FlowKt.combine(r8, r1, new ru.mrlargha.feature.arizona.cases.CasesScreen$setCollectors$1.AnonymousClass1(null)).collect(new ru.mrlargha.feature.arizona.cases.CasesScreen$setCollectors$1.AnonymousClass2(r7.this$0), r7) == r0) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Activity targetActivity;
        Activity targetActivity2;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        CasesApiService casesApiService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            targetActivity = this.this$0.getTargetActivity();
            targetActivity2 = this.this$0.getTargetActivity();
            Toast.makeText(targetActivity, targetActivity2.getString(R.string.cases_error_load_data), 0).show();
            String message = e.getMessage();
            if (message == null) {
                message = "error with retrofit request";
            }
            Log.e("donate", message);
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow3 = this.this$0.casesState;
            casesApiService = this.this$0.api;
            this.L$0 = mutableStateFlow3;
            this.label = 1;
            obj = CasesApiService.getCases$default(casesApiService, null, this, 1, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            mutableStateFlow3 = (MutableStateFlow) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i != 2) {
            if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.casesState;
            mutableStateFlow2 = this.this$0.infoState;
            this.L$0 = null;
            this.label = 3;
        }
        this.L$0 = null;
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CasesScreen.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesModel;", "Lru/mrlargha/feature/arizona/cases/CasesInfoModel;", "cases", "info"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.arizona.cases.CasesScreen$setCollectors$1$1", f = "CasesScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.feature.arizona.cases.CasesScreen$setCollectors$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<List<? extends CasesModel>, CasesInfoModel, Continuation<? super Pair<? extends List<? extends CasesModel>, ? extends CasesInfoModel>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(List<? extends CasesModel> list, CasesInfoModel casesInfoModel, Continuation<? super Pair<? extends List<? extends CasesModel>, ? extends CasesInfoModel>> continuation) {
            return invoke2((List<CasesModel>) list, casesInfoModel, (Continuation<? super Pair<? extends List<CasesModel>, CasesInfoModel>>) continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(List<CasesModel> list, CasesInfoModel casesInfoModel, Continuation<? super Pair<? extends List<CasesModel>, CasesInfoModel>> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = list;
            anonymousClass1.L$1 = casesInfoModel;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list = (List) this.L$0;
            CasesInfoModel casesInfoModel = (CasesInfoModel) this.L$1;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new Pair(list, casesInfoModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CasesScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: ru.mrlargha.feature.arizona.cases.CasesScreen$setCollectors$1$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ CasesScreen this$0;

        AnonymousClass2(CasesScreen casesScreen) {
            this.this$0 = casesScreen;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((Pair) obj, (Continuation<? super Unit>) continuation);
        }

        public final Object emit(Pair<? extends List<CasesModel>, CasesInfoModel> pair, Continuation<? super Unit> continuation) {
            T t;
            CasesSharedPreference casesSharedPreference;
            CasesSharedPreference casesSharedPreference2;
            List<CasesModel> component1 = pair.component1();
            final CasesInfoModel component2 = pair.component2();
            Log.d("Case", "setCollectors: ");
            if (component2 != null) {
                List<CasesModel> list = component1;
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (((CasesModel) t).getId() == component2.getCaseId()) {
                        break;
                    }
                }
                CasesModel casesModel = (CasesModel) t;
                if (casesModel == null) {
                    return Unit.INSTANCE;
                }
                if (component2.getLegendary() == 0) {
                    casesSharedPreference2 = this.this$0.casesSharedPreference;
                    casesSharedPreference2.setHaveSpecialCase(false);
                }
                CasesScreen casesScreen = this.this$0;
                List<CasesPrizeModel> prizes = casesModel.getPrizes();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(prizes, 10));
                for (CasesPrizeModel casesPrizeModel : prizes) {
                    arrayList.add(casesPrizeModel.toModel());
                }
                casesScreen.prizesList = arrayList;
                this.this$0.setLoadingScreen(false);
                int unix = casesModel.getUnix();
                int price = casesModel.getPrice();
                CasesInfoModel copy$default = CasesInfoModel.copy$default(component2, 0, 0, 0, 0, 0, casesModel.getDiscount(), casesModel.getDiscountCount(), Boxing.boxInt(price), Boxing.boxInt(casesModel.getCurrency()), Boxing.boxInt(unix), 31, null);
                this.this$0.sendEventToPage(StringKt.toStringJson(copy$default), CasesId.MAIN_PAGE_INIT.getSubId(), CasesPages.MAIN);
                this.this$0.initInfo(copy$default);
                casesSharedPreference = this.this$0.casesSharedPreference;
                if (!casesSharedPreference.isHaveSpecialCase()) {
                    CollectionsKt.drop(list, 1);
                }
                List mutableList = CollectionsKt.toMutableList((Collection) component1);
                CollectionsKt.removeAll(mutableList, new Function1() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$setCollectors$1$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CasesScreen$setCollectors$1.AnonymousClass2.emit$lambda$2(CasesInfoModel.this, (CasesModel) obj));
                    }
                });
                CasesScreen casesScreen2 = this.this$0;
                List<CasesModel> list2 = mutableList;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (CasesModel casesModel2 : list2) {
                    arrayList2.add(casesModel2.toModel());
                }
                casesScreen2.sendEventToPage(StringKt.toStringJson(arrayList2), CasesId.SET_SAME_CASES.getSubId(), CasesPages.MAIN);
                List mutableList2 = CollectionsKt.toMutableList((Collection) casesModel.getPrizes());
                CollectionsKt.removeAll(mutableList2, new Function1() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$setCollectors$1$2$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CasesScreen$setCollectors$1.AnonymousClass2.emit$lambda$4((CasesPrizeModel) obj));
                    }
                });
                CasesScreen casesScreen3 = this.this$0;
                List<CasesPrizeModel> list3 = mutableList2;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (CasesPrizeModel casesPrizeModel2 : list3) {
                    arrayList3.add(casesPrizeModel2.toModel());
                }
                CasesScreen.sendEventToPage$default(casesScreen3, StringKt.toStringJson(arrayList3), CasesId.SET_GUARANTEED_LIST.getSubId(), null, 4, null);
                List mutableList3 = CollectionsKt.toMutableList((Collection) casesModel.getPrizes());
                CollectionsKt.removeAll(mutableList3, new Function1() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$setCollectors$1$2$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CasesScreen$setCollectors$1.AnonymousClass2.emit$lambda$6((CasesPrizeModel) obj));
                    }
                });
                CasesScreen casesScreen4 = this.this$0;
                List<CasesPrizeModel> list4 = mutableList3;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                for (CasesPrizeModel casesPrizeModel3 : list4) {
                    arrayList4.add(casesPrizeModel3.toModel());
                }
                CasesScreen.sendEventToPage$default(casesScreen4, StringKt.toStringJson(arrayList4), CasesId.SET_CAN_WIN_LIST.getSubId(), null, 4, null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean emit$lambda$2(CasesInfoModel casesInfoModel, CasesModel it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getId() == casesInfoModel.getCaseId();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean emit$lambda$4(CasesPrizeModel it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getGarante() == 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean emit$lambda$6(CasesPrizeModel it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getGarante() != 0;
        }
    }
}
