package com.arkivanov.decompose.router.pages;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
/* compiled from: PagesNavigatorExt.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\u001a:\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001e\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00070\u0006\u001aj\u0010\b\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2D\b\u0002\u0010\u000b\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\f\u001aj\u0010\u0011\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2D\b\u0002\u0010\u000b\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\f\u001a`\u0010\u0012\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042D\b\u0002\u0010\u000b\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\f\u001a`\u0010\u0013\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042D\b\u0002\u0010\u000b\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\f\u001ah\u0010\u0014\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162D\b\u0002\u0010\u000b\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\f\u001a`\u0010\u0017\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042D\b\u0002\u0010\u000b\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\f\u001aA\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0006H\u0082\b¨\u0006\u001a"}, d2 = {"navigate", "", "C", "", "Lcom/arkivanov/decompose/router/pages/PagesNavigator;", "transformer", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/router/pages/Pages;", "selectNext", "circular", "", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "newPages", "oldPages", "selectPrev", "selectFirst", "selectLast", "select", FirebaseAnalytics.Param.INDEX, "", "clear", "coerceSelectedIndex", "update", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PagesNavigatorExtKt {
    public static final <C> void navigate(PagesNavigator<C> pagesNavigator, Function1<? super Pages<? extends C>, ? extends Pages<? extends C>> transformer) {
        Intrinsics.checkNotNullParameter(pagesNavigator, "<this>");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        pagesNavigator.navigate(transformer, new Function2() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit navigate$lambda$0;
                navigate$lambda$0 = PagesNavigatorExtKt.navigate$lambda$0((Pages) obj, (Pages) obj2);
                return navigate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigate$lambda$0(Pages pages, Pages pages2) {
        Intrinsics.checkNotNullParameter(pages, "<unused var>");
        Intrinsics.checkNotNullParameter(pages2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void selectNext$default(PagesNavigator pagesNavigator, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit selectNext$lambda$1;
                    selectNext$lambda$1 = PagesNavigatorExtKt.selectNext$lambda$1((Pages) obj2, (Pages) obj3);
                    return selectNext$lambda$1;
                }
            };
        }
        selectNext(pagesNavigator, z, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectNext$lambda$1(Pages pages, Pages pages2) {
        Intrinsics.checkNotNullParameter(pages, "<unused var>");
        Intrinsics.checkNotNullParameter(pages2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <C> void selectNext(PagesNavigator<C> pagesNavigator, final boolean z, Function2<? super Pages<? extends C>, ? super Pages<? extends C>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(pagesNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        pagesNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Pages selectNext$lambda$3;
                selectNext$lambda$3 = PagesNavigatorExtKt.selectNext$lambda$3(z, (Pages) obj);
                return selectNext$lambda$3;
            }
        }, onComplete);
    }

    public static /* synthetic */ void selectPrev$default(PagesNavigator pagesNavigator, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit selectPrev$lambda$4;
                    selectPrev$lambda$4 = PagesNavigatorExtKt.selectPrev$lambda$4((Pages) obj2, (Pages) obj3);
                    return selectPrev$lambda$4;
                }
            };
        }
        selectPrev(pagesNavigator, z, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectPrev$lambda$4(Pages pages, Pages pages2) {
        Intrinsics.checkNotNullParameter(pages, "<unused var>");
        Intrinsics.checkNotNullParameter(pages2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <C> void selectPrev(PagesNavigator<C> pagesNavigator, final boolean z, Function2<? super Pages<? extends C>, ? super Pages<? extends C>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(pagesNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        pagesNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Pages selectPrev$lambda$6;
                selectPrev$lambda$6 = PagesNavigatorExtKt.selectPrev$lambda$6(z, (Pages) obj);
                return selectPrev$lambda$6;
            }
        }, onComplete);
    }

    public static /* synthetic */ void selectFirst$default(PagesNavigator pagesNavigator, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit selectFirst$lambda$7;
                    selectFirst$lambda$7 = PagesNavigatorExtKt.selectFirst$lambda$7((Pages) obj2, (Pages) obj3);
                    return selectFirst$lambda$7;
                }
            };
        }
        selectFirst(pagesNavigator, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectFirst$lambda$7(Pages pages, Pages pages2) {
        Intrinsics.checkNotNullParameter(pages, "<unused var>");
        Intrinsics.checkNotNullParameter(pages2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <C> void selectFirst(PagesNavigator<C> pagesNavigator, Function2<? super Pages<? extends C>, ? super Pages<? extends C>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(pagesNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        pagesNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Pages selectFirst$lambda$9;
                selectFirst$lambda$9 = PagesNavigatorExtKt.selectFirst$lambda$9((Pages) obj);
                return selectFirst$lambda$9;
            }
        }, onComplete);
    }

    public static /* synthetic */ void selectLast$default(PagesNavigator pagesNavigator, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit selectLast$lambda$10;
                    selectLast$lambda$10 = PagesNavigatorExtKt.selectLast$lambda$10((Pages) obj2, (Pages) obj3);
                    return selectLast$lambda$10;
                }
            };
        }
        selectLast(pagesNavigator, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectLast$lambda$10(Pages pages, Pages pages2) {
        Intrinsics.checkNotNullParameter(pages, "<unused var>");
        Intrinsics.checkNotNullParameter(pages2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <C> void selectLast(PagesNavigator<C> pagesNavigator, Function2<? super Pages<? extends C>, ? super Pages<? extends C>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(pagesNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        pagesNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Pages selectLast$lambda$12;
                selectLast$lambda$12 = PagesNavigatorExtKt.selectLast$lambda$12((Pages) obj);
                return selectLast$lambda$12;
            }
        }, onComplete);
    }

    public static /* synthetic */ void select$default(PagesNavigator pagesNavigator, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit select$lambda$13;
                    select$lambda$13 = PagesNavigatorExtKt.select$lambda$13((Pages) obj2, (Pages) obj3);
                    return select$lambda$13;
                }
            };
        }
        select(pagesNavigator, i, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit select$lambda$13(Pages pages, Pages pages2) {
        Intrinsics.checkNotNullParameter(pages, "<unused var>");
        Intrinsics.checkNotNullParameter(pages2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <C> void select(PagesNavigator<C> pagesNavigator, final int i, Function2<? super Pages<? extends C>, ? super Pages<? extends C>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(pagesNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        pagesNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Pages select$lambda$14;
                select$lambda$14 = PagesNavigatorExtKt.select$lambda$14(i, (Pages) obj);
                return select$lambda$14;
            }
        }, onComplete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pages select$lambda$14(int i, Pages it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Pages.copy$default(it, null, i, 1, null);
    }

    public static /* synthetic */ void clear$default(PagesNavigator pagesNavigator, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit clear$lambda$15;
                    clear$lambda$15 = PagesNavigatorExtKt.clear$lambda$15((Pages) obj2, (Pages) obj3);
                    return clear$lambda$15;
                }
            };
        }
        clear(pagesNavigator, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clear$lambda$15(Pages pages, Pages pages2) {
        Intrinsics.checkNotNullParameter(pages, "<unused var>");
        Intrinsics.checkNotNullParameter(pages2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <C> void clear(PagesNavigator<C> pagesNavigator, Function2<? super Pages<? extends C>, ? super Pages<? extends C>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(pagesNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        pagesNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.pages.PagesNavigatorExtKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Pages clear$lambda$16;
                clear$lambda$16 = PagesNavigatorExtKt.clear$lambda$16((Pages) obj);
                return clear$lambda$16;
            }
        }, onComplete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pages clear$lambda$16(Pages it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new Pages();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <C> Pages<C> coerceSelectedIndex(Pages<? extends C> pages, boolean z, Function1<? super Integer, Integer> function1) {
        if (pages.getItems().isEmpty()) {
            return pages;
        }
        int intValue = function1.invoke(Integer.valueOf(pages.getSelectedIndex())).intValue();
        if (z) {
            if (intValue < 0) {
                intValue += pages.getItems().size();
            } else if (intValue > CollectionsKt.getLastIndex(pages.getItems())) {
                intValue -= pages.getItems().size();
            }
        }
        return Pages.copy$default(pages, null, RangesKt.coerceIn(intValue, (ClosedRange<Integer>) CollectionsKt.getIndices(pages.getItems())), 1, null);
    }

    static /* synthetic */ Pages coerceSelectedIndex$default(Pages pages, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (pages.getItems().isEmpty()) {
            return pages;
        }
        int intValue = ((Number) function1.invoke(Integer.valueOf(pages.getSelectedIndex()))).intValue();
        if (z) {
            if (intValue < 0) {
                intValue += pages.getItems().size();
            } else if (intValue > CollectionsKt.getLastIndex(pages.getItems())) {
                intValue -= pages.getItems().size();
            }
        }
        return Pages.copy$default(pages, null, RangesKt.coerceIn(intValue, (ClosedRange<Integer>) CollectionsKt.getIndices(pages.getItems())), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pages selectNext$lambda$3(boolean z, Pages pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        if (pages.getItems().isEmpty()) {
            return pages;
        }
        int selectedIndex = pages.getSelectedIndex() + 1;
        if (z) {
            if (selectedIndex < 0) {
                selectedIndex += pages.getItems().size();
            } else if (selectedIndex > CollectionsKt.getLastIndex(pages.getItems())) {
                selectedIndex -= pages.getItems().size();
            }
        }
        return Pages.copy$default(pages, null, RangesKt.coerceIn(selectedIndex, (ClosedRange<Integer>) CollectionsKt.getIndices(pages.getItems())), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pages selectPrev$lambda$6(boolean z, Pages pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        if (pages.getItems().isEmpty()) {
            return pages;
        }
        int selectedIndex = pages.getSelectedIndex() - 1;
        if (z) {
            if (selectedIndex < 0) {
                selectedIndex += pages.getItems().size();
            } else if (selectedIndex > CollectionsKt.getLastIndex(pages.getItems())) {
                selectedIndex -= pages.getItems().size();
            }
        }
        return Pages.copy$default(pages, null, RangesKt.coerceIn(selectedIndex, (ClosedRange<Integer>) CollectionsKt.getIndices(pages.getItems())), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pages selectFirst$lambda$9(Pages pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        if (pages.getItems().isEmpty()) {
            return pages;
        }
        pages.getSelectedIndex();
        return Pages.copy$default(pages, null, RangesKt.coerceIn(0, (ClosedRange<Integer>) CollectionsKt.getIndices(pages.getItems())), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pages selectLast$lambda$12(Pages pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        if (pages.getItems().isEmpty()) {
            return pages;
        }
        pages.getSelectedIndex();
        return Pages.copy$default(pages, null, RangesKt.coerceIn(CollectionsKt.getLastIndex(pages.getItems()), (ClosedRange<Integer>) CollectionsKt.getIndices(pages.getItems())), 1, null);
    }
}
