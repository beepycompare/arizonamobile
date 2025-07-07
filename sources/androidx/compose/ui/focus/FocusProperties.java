package androidx.compose.ui.focus;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: FocusProperties.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eRB\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u00132\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u00138W@WX\u0097\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRB\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u00132\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u00138W@WX\u0097\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR$\u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR$\u0010#\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eRF\u0010)\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0\u0013¢\u0006\u0002\b(2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0\u0013¢\u0006\u0002\b(8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bRF\u0010,\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0\u0013¢\u0006\u0002\b(2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0\u0013¢\u0006\u0002\b(8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR$\u0010/\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u0010\f\"\u0004\b1\u0010\u000eR$\u00102\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b3\u0010\f\"\u0004\b4\u0010\u000eR$\u00105\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b6\u0010\f\"\u0004\b7\u0010\u000eR$\u00108\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b9\u0010\f\"\u0004\b:\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006;À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/focus/FocusProperties;", "", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "<anonymous parameter 0>", "Landroidx/compose/ui/focus/FocusRequester;", "down", "getDown", "()Landroidx/compose/ui/focus/FocusRequester;", "setDown", "(Landroidx/compose/ui/focus/FocusRequester;)V", TtmlNode.END, "getEnd", "setEnd", "value", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "enter", "getEnter$annotations", "()V", "getEnter", "()Lkotlin/jvm/functions/Function1;", "setEnter", "(Lkotlin/jvm/functions/Function1;)V", "exit", "getExit$annotations", "getExit", "setExit", TtmlNode.LEFT, "getLeft", "setLeft", "next", "getNext", "setNext", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "onEnter", "getOnEnter", "setOnEnter", "onExit", "getOnExit", "setOnExit", "previous", "getPrevious", "setPrevious", TtmlNode.RIGHT, "getRight", "setRight", TtmlNode.START, "getStart", "setStart", "up", "getUp", "setUp", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface FocusProperties {
    static /* synthetic */ void getEnter$annotations() {
    }

    static /* synthetic */ void getExit$annotations() {
    }

    boolean getCanFocus();

    void setCanFocus(boolean z);

    default void setDown(FocusRequester focusRequester) {
    }

    default void setEnd(FocusRequester focusRequester) {
    }

    default void setLeft(FocusRequester focusRequester) {
    }

    default void setNext(FocusRequester focusRequester) {
    }

    default void setOnEnter(Function1<? super FocusEnterExitScope, Unit> function1) {
    }

    default void setOnExit(Function1<? super FocusEnterExitScope, Unit> function1) {
    }

    default void setPrevious(FocusRequester focusRequester) {
    }

    default void setRight(FocusRequester focusRequester) {
    }

    default void setStart(FocusRequester focusRequester) {
    }

    default void setUp(FocusRequester focusRequester) {
    }

    default FocusRequester getNext() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getPrevious() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getUp() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getDown() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getLeft() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getRight() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getStart() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getEnd() {
        return FocusRequester.Companion.getDefault();
    }

    default Function1<FocusDirection, FocusRequester> getEnter() {
        return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$enter$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m3746invoke3ESFkO8(focusDirection.m3724unboximpl());
            }

            /* renamed from: invoke-3ESFkO8  reason: not valid java name */
            public final FocusRequester m3746invoke3ESFkO8(int i) {
                return FocusRequester.Companion.getDefault();
            }
        };
    }

    @Deprecated(message = "Use onEnter instead", replaceWith = @ReplaceWith(expression = "onEnter", imports = {}))
    default void setEnter(Function1<? super FocusDirection, FocusRequester> function1) {
        Function1<? super FocusEnterExitScope, Unit> usingEnterExitScope;
        usingEnterExitScope = FocusPropertiesKt.toUsingEnterExitScope(function1);
        setOnEnter(usingEnterExitScope);
    }

    default Function1<FocusEnterExitScope, Unit> getOnEnter() {
        return new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.focus.FocusProperties$onEnter$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FocusEnterExitScope focusEnterExitScope) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusEnterExitScope focusEnterExitScope) {
                invoke2(focusEnterExitScope);
                return Unit.INSTANCE;
            }
        };
    }

    default Function1<FocusDirection, FocusRequester> getExit() {
        return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$exit$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
                return m3747invoke3ESFkO8(focusDirection.m3724unboximpl());
            }

            /* renamed from: invoke-3ESFkO8  reason: not valid java name */
            public final FocusRequester m3747invoke3ESFkO8(int i) {
                return FocusRequester.Companion.getDefault();
            }
        };
    }

    @Deprecated(message = "Use onExit instead", replaceWith = @ReplaceWith(expression = "onExit", imports = {}))
    default void setExit(Function1<? super FocusDirection, FocusRequester> function1) {
        Function1<? super FocusEnterExitScope, Unit> usingEnterExitScope;
        usingEnterExitScope = FocusPropertiesKt.toUsingEnterExitScope(function1);
        setOnExit(usingEnterExitScope);
    }

    default Function1<FocusEnterExitScope, Unit> getOnExit() {
        return new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.focus.FocusProperties$onExit$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FocusEnterExitScope focusEnterExitScope) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusEnterExitScope focusEnterExitScope) {
                invoke2(focusEnterExitScope);
                return Unit.INSTANCE;
            }
        };
    }
}
