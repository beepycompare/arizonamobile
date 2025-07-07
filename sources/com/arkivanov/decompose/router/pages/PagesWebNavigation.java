package com.arkivanov.decompose.router.pages;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.router.webhistory.WebNavigation;
import com.arkivanov.decompose.router.webhistory.WebNavigationOwner;
import com.arkivanov.decompose.value.Value;
import com.arkivanov.decompose.value.operator.MapKt;
import java.util.ArrayList;
import java.util.Iterator;
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
/* compiled from: PagesWebNavigation.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00050\u0004B½\u0001\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012 \u0010\r\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u0012,\u0010\u0010\u001a(\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00110\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012 \u0010\u0015\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0012\u001a\u00020\u0014H\u0016J\u001c\u0010!\u001a\u00020\"2\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u001dH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0010\u001a(\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR,\u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u001e0\u001d0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/arkivanov/decompose/router/pages/PagesWebNavigation;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/decompose/router/webhistory/WebNavigation;", "Lcom/arkivanov/decompose/router/pages/Pages;", "navigator", "Lcom/arkivanov/decompose/router/pages/PagesNavigator;", "pages", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/pages/ChildPages;", "serializer", "Lkotlinx/serialization/KSerializer;", "pathMapper", "Lkotlin/Function1;", "", "parametersMapper", "", "onBeforeNavigate", "Lkotlin/Function0;", "", "childSelector", "Lcom/arkivanov/decompose/Child$Created;", "Lcom/arkivanov/decompose/router/webhistory/WebNavigationOwner;", "<init>", "(Lcom/arkivanov/decompose/router/pages/PagesNavigator;Lcom/arkivanov/decompose/value/Value;Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getSerializer", "()Lkotlinx/serialization/KSerializer;", "history", "", "Lcom/arkivanov/decompose/router/webhistory/WebNavigation$HistoryItem;", "getHistory", "()Lcom/arkivanov/decompose/value/Value;", "navigate", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PagesWebNavigation<C, T> implements WebNavigation<Pages<? extends C>> {
    private final Function1<Child.Created<? extends C, ? extends T>, WebNavigationOwner> childSelector;
    private final Value<List<WebNavigation.HistoryItem<Pages<C>>>> history;
    private final PagesNavigator<C> navigator;
    private final Function0<Boolean> onBeforeNavigate;
    private final Function1<ChildPages<? extends C, ? extends T>, Map<String, String>> parametersMapper;
    private final Function1<ChildPages<? extends C, ? extends T>, String> pathMapper;
    private final KSerializer<Pages<C>> serializer;

    /* JADX WARN: Multi-variable type inference failed */
    public PagesWebNavigation(PagesNavigator<C> navigator, Value<? extends ChildPages<? extends C, ? extends T>> pages, KSerializer<C> serializer, Function1<? super ChildPages<? extends C, ? extends T>, String> pathMapper, Function1<? super ChildPages<? extends C, ? extends T>, ? extends Map<String, String>> parametersMapper, Function0<Boolean> onBeforeNavigate, Function1<? super Child.Created<? extends C, ? extends T>, ? extends WebNavigationOwner> childSelector) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(pathMapper, "pathMapper");
        Intrinsics.checkNotNullParameter(parametersMapper, "parametersMapper");
        Intrinsics.checkNotNullParameter(onBeforeNavigate, "onBeforeNavigate");
        Intrinsics.checkNotNullParameter(childSelector, "childSelector");
        this.navigator = navigator;
        this.pathMapper = pathMapper;
        this.parametersMapper = parametersMapper;
        this.onBeforeNavigate = onBeforeNavigate;
        this.childSelector = childSelector;
        this.serializer = Pages.Companion.serializer(serializer);
        this.history = MapKt.map(pages, new Function1() { // from class: com.arkivanov.decompose.router.pages.PagesWebNavigation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List history$lambda$1;
                history$lambda$1 = PagesWebNavigation.history$lambda$1(PagesWebNavigation.this, (ChildPages) obj);
                return history$lambda$1;
            }
        });
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public KSerializer<Pages<C>> getSerializer() {
        return this.serializer;
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public Value<List<WebNavigation.HistoryItem<Pages<C>>>> getHistory() {
        return this.history;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List history$lambda$1(PagesWebNavigation pagesWebNavigation, ChildPages pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        String invoke = pagesWebNavigation.pathMapper.invoke(pages);
        if (invoke == null) {
            invoke = "";
        }
        Map<String, String> invoke2 = pagesWebNavigation.parametersMapper.invoke(pages);
        if (invoke2 == null) {
            invoke2 = MapsKt.emptyMap();
        }
        List<Child<C, T>> items = pages.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(((Child) it.next()).getConfiguration());
        }
        Pages pages2 = new Pages(arrayList, pages.getSelectedIndex());
        Object orNull = CollectionsKt.getOrNull(pages.getItems(), pages.getSelectedIndex());
        Child.Created<? extends C, ? extends T> created = orNull instanceof Child.Created ? (Child.Created) orNull : null;
        return CollectionsKt.listOf(new WebNavigation.HistoryItem(pages2, invoke, invoke2, created != null ? pagesWebNavigation.childSelector.invoke(created) : null));
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public boolean onBeforeNavigate() {
        return this.onBeforeNavigate.invoke().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pages navigate$lambda$2(List list, Pages it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (Pages) CollectionsKt.first((List<? extends Object>) list);
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public void navigate(final List<? extends Pages<? extends C>> history) {
        Intrinsics.checkNotNullParameter(history, "history");
        PagesNavigatorExtKt.navigate(this.navigator, new Function1() { // from class: com.arkivanov.decompose.router.pages.PagesWebNavigation$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Pages navigate$lambda$2;
                navigate$lambda$2 = PagesWebNavigation.navigate$lambda$2(history, (Pages) obj);
                return navigate$lambda$2;
            }
        });
    }
}
