package ru.mrlargha.commonui.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FirebaseServerHandler.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lru/mrlargha/commonui/utils/FirebaseConfigLinks;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.utils.FirebaseConfigHelper$fetchAll$2", f = "FirebaseServerHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class FirebaseConfigHelper$fetchAll$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<FirebaseConfigLinks, ? extends String>>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseConfigHelper$fetchAll$2(Continuation<? super FirebaseConfigHelper$fetchAll$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FirebaseConfigHelper$fetchAll$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<FirebaseConfigLinks, ? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Map<FirebaseConfigLinks, String>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Map<FirebaseConfigLinks, String>> continuation) {
        return ((FirebaseConfigHelper$fetchAll$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Map map;
        String fetchLink;
        boolean hasReserve;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : FirebaseConfigLinks.getEntries()) {
            hasReserve = FirebaseConfigHelper.INSTANCE.hasReserve((FirebaseConfigLinks) obj2);
            if (hasReserve) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj3 : arrayList2) {
            fetchLink = FirebaseConfigHelper.INSTANCE.fetchLink((FirebaseConfigLinks) obj3);
            linkedHashMap.put(obj3, fetchLink);
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        map = FirebaseConfigHelper.linkCache;
        map.putAll(linkedHashMap2);
        return linkedHashMap2;
    }
}
