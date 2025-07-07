package com.arkivanov.decompose.router.stack;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.router.webhistory.WebNavigation;
import com.arkivanov.decompose.router.webhistory.WebNavigationOwner;
import com.arkivanov.decompose.value.Value;
import com.arkivanov.decompose.value.operator.MapKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StackWebNavigation.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004BÅ\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012 \u0010\u000e\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0012,\u0010\u0012\u001a(\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00130\u000f\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015\u0012 \u0010\u0016\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001d*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0016\u0010\"\u001a\u00020#2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0012\u001a(\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00130\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001d0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/arkivanov/decompose/router/stack/StackWebNavigation;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/decompose/router/webhistory/WebNavigation;", "navigator", "Lcom/arkivanov/decompose/router/stack/StackNavigator;", "stack", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/stack/ChildStack;", "serializer", "Lkotlinx/serialization/KSerializer;", "enableHistory", "", "pathMapper", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/Child$Created;", "", "parametersMapper", "", "onBeforeNavigate", "Lkotlin/Function0;", "childSelector", "Lcom/arkivanov/decompose/router/webhistory/WebNavigationOwner;", "<init>", "(Lcom/arkivanov/decompose/router/stack/StackNavigator;Lcom/arkivanov/decompose/value/Value;Lkotlinx/serialization/KSerializer;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getSerializer", "()Lkotlinx/serialization/KSerializer;", "history", "", "Lcom/arkivanov/decompose/router/webhistory/WebNavigation$HistoryItem;", "getHistory", "()Lcom/arkivanov/decompose/value/Value;", "toHistory", "navigate", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StackWebNavigation<C, T> implements WebNavigation<C> {
    private final Function1<Child.Created<? extends C, ? extends T>, WebNavigationOwner> childSelector;
    private final boolean enableHistory;
    private final Value<List<WebNavigation.HistoryItem<C>>> history;
    private final StackNavigator<C> navigator;
    private final Function0<Boolean> onBeforeNavigate;
    private final Function1<Child.Created<? extends C, ? extends T>, Map<String, String>> parametersMapper;
    private final Function1<Child.Created<? extends C, ? extends T>, String> pathMapper;
    private final KSerializer<C> serializer;

    /* JADX INFO: Access modifiers changed from: private */
    public static final List navigate$lambda$2(List list, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StackWebNavigation(StackNavigator<C> navigator, Value<? extends ChildStack<? extends C, ? extends T>> stack, KSerializer<C> serializer, boolean z, Function1<? super Child.Created<? extends C, ? extends T>, String> pathMapper, Function1<? super Child.Created<? extends C, ? extends T>, ? extends Map<String, String>> parametersMapper, Function0<Boolean> onBeforeNavigate, Function1<? super Child.Created<? extends C, ? extends T>, ? extends WebNavigationOwner> childSelector) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(pathMapper, "pathMapper");
        Intrinsics.checkNotNullParameter(parametersMapper, "parametersMapper");
        Intrinsics.checkNotNullParameter(onBeforeNavigate, "onBeforeNavigate");
        Intrinsics.checkNotNullParameter(childSelector, "childSelector");
        this.navigator = navigator;
        this.serializer = serializer;
        this.enableHistory = z;
        this.pathMapper = pathMapper;
        this.parametersMapper = parametersMapper;
        this.onBeforeNavigate = onBeforeNavigate;
        this.childSelector = childSelector;
        this.history = MapKt.map(stack, new Function1() { // from class: com.arkivanov.decompose.router.stack.StackWebNavigation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List history$lambda$0;
                history$lambda$0 = StackWebNavigation.history$lambda$0(StackWebNavigation.this, (ChildStack) obj);
                return history$lambda$0;
            }
        });
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public KSerializer<C> getSerializer() {
        return this.serializer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List history$lambda$0(StackWebNavigation stackWebNavigation, ChildStack it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return stackWebNavigation.toHistory(it);
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public Value<List<WebNavigation.HistoryItem<C>>> getHistory() {
        return this.history;
    }

    private final List<WebNavigation.HistoryItem<C>> toHistory(ChildStack<? extends C, ? extends T> childStack) {
        boolean z = this.enableHistory;
        List<Child.Created<? extends C, ? extends T>> items = childStack.getItems();
        if (!z) {
            items = CollectionsKt.takeLast(items, 1);
        }
        List<Child.Created<? extends C, ? extends T>> list = items;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Child.Created<? extends C, ? extends T> created : list) {
            String invoke = this.pathMapper.invoke(created);
            if (invoke == null) {
                invoke = "";
            }
            Map<String, String> invoke2 = this.parametersMapper.invoke(created);
            if (invoke2 == null) {
                invoke2 = MapsKt.emptyMap();
            }
            arrayList.add(new WebNavigation.HistoryItem(created.getConfiguration(), invoke, invoke2, this.childSelector.invoke(created)));
        }
        return arrayList;
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public boolean onBeforeNavigate() {
        return this.onBeforeNavigate.invoke().booleanValue();
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public void navigate(final List<? extends C> history) {
        Intrinsics.checkNotNullParameter(history, "history");
        StackNavigatorExtKt.navigate(this.navigator, new Function1() { // from class: com.arkivanov.decompose.router.stack.StackWebNavigation$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List navigate$lambda$2;
                navigate$lambda$2 = StackWebNavigation.navigate$lambda$2(history, (List) obj);
                return navigate$lambda$2;
            }
        });
    }
}
