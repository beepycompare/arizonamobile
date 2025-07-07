package com.arkivanov.decompose.router.pages;

import com.arkivanov.decompose.router.children.ChildNavState;
import com.arkivanov.decompose.router.children.NavState;
import com.arkivanov.decompose.router.children.SimpleChildNavState;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChildPagesFactory.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BD\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012-\u0010\u0006\u001a)\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005HÆ\u0003J0\u0010\u0017\u001a)\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\f0\u0007HÂ\u0003JP\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052/\b\u0002\u0010\u0006\u001a)\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R5\u0010\u0006\u001a)\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/arkivanov/decompose/router/pages/PagesNavState;", "C", "", "Lcom/arkivanov/decompose/router/children/NavState;", "pages", "Lcom/arkivanov/decompose/router/pages/Pages;", "pageStatus", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "Lcom/arkivanov/decompose/router/children/ChildNavState$Status;", "<init>", "(Lcom/arkivanov/decompose/router/pages/Pages;Lkotlin/jvm/functions/Function2;)V", "getPages", "()Lcom/arkivanov/decompose/router/pages/Pages;", "children", "", "Lcom/arkivanov/decompose/router/children/ChildNavState;", "getChildren", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PagesNavState<C> implements NavState<C> {
    private final List<ChildNavState<C>> children;
    private final Function2<Integer, Pages<? extends C>, ChildNavState.Status> pageStatus;
    private final Pages<C> pages;

    private final Function2<Integer, Pages<? extends C>, ChildNavState.Status> component2() {
        return this.pageStatus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PagesNavState copy$default(PagesNavState pagesNavState, Pages pages, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            pages = pagesNavState.pages;
        }
        if ((i & 2) != 0) {
            function2 = pagesNavState.pageStatus;
        }
        return pagesNavState.copy(pages, function2);
    }

    public final Pages<C> component1() {
        return this.pages;
    }

    public final PagesNavState<C> copy(Pages<? extends C> pages, Function2<? super Integer, ? super Pages<? extends C>, ? extends ChildNavState.Status> pageStatus) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        return new PagesNavState<>(pages, pageStatus);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PagesNavState) {
            PagesNavState pagesNavState = (PagesNavState) obj;
            return Intrinsics.areEqual(this.pages, pagesNavState.pages) && Intrinsics.areEqual(this.pageStatus, pagesNavState.pageStatus);
        }
        return false;
    }

    public int hashCode() {
        return (this.pages.hashCode() * 31) + this.pageStatus.hashCode();
    }

    public String toString() {
        return "PagesNavState(pages=" + this.pages + ", pageStatus=" + this.pageStatus + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PagesNavState(Pages<? extends C> pages, Function2<? super Integer, ? super Pages<? extends C>, ? extends ChildNavState.Status> pageStatus) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        this.pages = pages;
        this.pageStatus = pageStatus;
        int size = pages.getItems().size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new SimpleChildNavState(this.pages.getItems().get(i), this.pageStatus.invoke(Integer.valueOf(i), this.pages)));
        }
        this.children = arrayList;
    }

    public final Pages<C> getPages() {
        return this.pages;
    }

    @Override // com.arkivanov.decompose.router.children.NavState
    public List<ChildNavState<C>> getChildren() {
        return this.children;
    }
}
