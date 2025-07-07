package ru.mrlargha.arizonaui.family;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.arizonaui.databinding.FamilyMainBinding;
import ru.mrlargha.arizonaui.databinding.FamilyTerritoriesBinding;
import ru.mrlargha.arizonaui.family.adapters.TerritoryAdapter;
import ru.mrlargha.arizonaui.family.data.FamilyData;
import ru.mrlargha.arizonaui.family.data.GangZoneItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FamilyScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.arizonaui.family.FamilyScreen$requestTerritories$1$1", f = "FamilyScreen.kt", i = {}, l = {588}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class FamilyScreen$requestTerritories$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FamilyScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyScreen$requestTerritories$1$1(FamilyScreen familyScreen, Continuation<? super FamilyScreen$requestTerritories$1$1> continuation) {
        super(2, continuation);
        this.this$0 = familyScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FamilyScreen$requestTerritories$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FamilyScreen$requestTerritories$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FamilyMainBinding familyMainBinding;
        TerritoryAdapter territoryAdapter;
        FamilyData familyData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new FamilyScreen$requestTerritories$1$1$contextList$1(this.this$0, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        FamilyScreen familyScreen = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (List) obj) {
            int family_id = ((GangZoneItem) obj2).getFamily_id();
            familyData = familyScreen.familyData;
            if (family_id == (familyData != null ? familyData.getId() : -99)) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        familyMainBinding = this.this$0.binding;
        FamilyTerritoriesBinding familyTerritoriesBinding = familyMainBinding.territories;
        familyTerritoriesBinding.loaderBar.setVisibility(8);
        if (arrayList2.isEmpty()) {
            familyTerritoriesBinding.empty.setVisibility(0);
        } else {
            familyTerritoriesBinding.empty.setVisibility(8);
        }
        territoryAdapter = this.this$0.territoryAdapter;
        territoryAdapter.addAllItems(arrayList2);
        return Unit.INSTANCE;
    }
}
