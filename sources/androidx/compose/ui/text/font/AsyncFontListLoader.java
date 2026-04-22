package androidx.compose.ui.text.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.TypefaceResult;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010!\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u0004\u0018\u00010\u0002*\u00020\u0005H\u0080@¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", "", "fontList", "", "Landroidx/compose/ui/text/font/Font;", "initialType", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "onCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "<init>", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "cacheable", "", "getCacheable$ui_text", "()Z", "setCacheable$ui_text", "(Z)V", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "loadWithTimeoutOrNull$ui_text", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsyncFontListLoader implements State<Object> {
    public static final int $stable = 0;
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable;
    private final List<Font> fontList;
    private final Function1<TypefaceResult.Immutable, Unit> onCompletion;
    private final PlatformFontLoader platformFontLoader;
    private final TypefaceRequest typefaceRequest;
    private final MutableState value$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFontListLoader(List<? extends Font> list, Object obj, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, Function1<? super TypefaceResult.Immutable, Unit> function1, PlatformFontLoader platformFontLoader) {
        MutableState mutableStateOf$default;
        this.fontList = list;
        this.typefaceRequest = typefaceRequest;
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.onCompletion = function1;
        this.platformFontLoader = platformFontLoader;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
        this.value$delegate = mutableStateOf$default;
        this.cacheable = true;
    }

    private void setValue(Object obj) {
        this.value$delegate.setValue(obj);
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        return this.value$delegate.getValue();
    }

    public final boolean getCacheable$ui_text() {
        return this.cacheable;
    }

    public final void setCacheable$ui_text(boolean z) {
        this.cacheable = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e2, code lost:
        if (kotlinx.coroutines.YieldKt.yield(r15) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0 A[Catch: all -> 0x0109, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0109, blocks: (B:13:0x0034, B:31:0x00a0, B:34:0x00d4, B:18:0x004d, B:21:0x0057), top: B:46:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d4 A[Catch: all -> 0x0109, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0109, blocks: (B:13:0x0034, B:31:0x00a0, B:34:0x00d4, B:18:0x004d, B:21:0x0057), top: B:46:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0079 -> B:38:0x00e8). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00e2 -> B:37:0x00e5). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object load(Continuation<? super Unit> continuation) {
        AsyncFontListLoader$load$1 asyncFontListLoader$load$1;
        int i;
        List<Font> list;
        int size;
        AsyncFontListLoader$load$1 asyncFontListLoader$load$12;
        int i2;
        Font font;
        List<Font> list2;
        int i3;
        try {
            if (continuation instanceof AsyncFontListLoader$load$1) {
                asyncFontListLoader$load$1 = (AsyncFontListLoader$load$1) continuation;
                if ((asyncFontListLoader$load$1.label & Integer.MIN_VALUE) != 0) {
                    asyncFontListLoader$load$1.label -= Integer.MIN_VALUE;
                    AsyncFontListLoader$load$1 asyncFontListLoader$load$13 = asyncFontListLoader$load$1;
                    Object obj = asyncFontListLoader$load$13.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = asyncFontListLoader$load$13.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        list = this.fontList;
                        size = list.size();
                        asyncFontListLoader$load$12 = asyncFontListLoader$load$13;
                        i2 = 0;
                        if (i2 < size) {
                        }
                    } else if (i == 1) {
                        size = asyncFontListLoader$load$13.I$1;
                        i3 = asyncFontListLoader$load$13.I$0;
                        Font font2 = (Font) asyncFontListLoader$load$13.L$1;
                        List<Font> list3 = (List) asyncFontListLoader$load$13.L$0;
                        ResultKt.throwOnFailure(obj);
                        font = font2;
                        list2 = list3;
                        if (obj == null) {
                        }
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        size = asyncFontListLoader$load$13.I$1;
                        i3 = asyncFontListLoader$load$13.I$0;
                        list2 = (List) asyncFontListLoader$load$13.L$0;
                        ResultKt.throwOnFailure(obj);
                        asyncFontListLoader$load$12 = asyncFontListLoader$load$13;
                        i2 = i3;
                        list = list2;
                        i2++;
                        if (i2 < size) {
                            try {
                                Font font3 = list.get(i2);
                                if (FontLoadingStrategy.m7102equalsimpl0(font3.mo7060getLoadingStrategyPKNRLFQ(), FontLoadingStrategy.Companion.m7106getAsyncPKNRLFQ())) {
                                    asyncFontListLoader$load$12.L$0 = list;
                                    asyncFontListLoader$load$12.L$1 = font3;
                                    asyncFontListLoader$load$12.I$0 = i2;
                                    asyncFontListLoader$load$12.I$1 = size;
                                    asyncFontListLoader$load$12.label = 1;
                                    Object runCached = this.asyncTypefaceCache.runCached(font3, this.platformFontLoader, false, new AsyncFontListLoader$load$2$typeface$1(this, font3, null), asyncFontListLoader$load$12);
                                    if (runCached != coroutine_suspended) {
                                        font = font3;
                                        list2 = list;
                                        obj = runCached;
                                        i3 = i2;
                                        asyncFontListLoader$load$13 = asyncFontListLoader$load$12;
                                        if (obj == null) {
                                            setValue(FontSynthesis_androidKt.m7137synthesizeTypefaceFxwP2eA(this.typefaceRequest.m7162getFontSynthesisGVVA2EU(), obj, font, this.typefaceRequest.getFontWeight(), this.typefaceRequest.m7161getFontStyle_LCdwA()));
                                            Unit unit = Unit.INSTANCE;
                                            boolean isActive = JobKt.isActive(asyncFontListLoader$load$13.getContext());
                                            this.cacheable = false;
                                            this.onCompletion.invoke(new TypefaceResult.Immutable(getValue(), isActive));
                                            return unit;
                                        }
                                        asyncFontListLoader$load$13.L$0 = list2;
                                        asyncFontListLoader$load$13.L$1 = null;
                                        asyncFontListLoader$load$13.I$0 = i3;
                                        asyncFontListLoader$load$13.I$1 = size;
                                        asyncFontListLoader$load$13.label = 2;
                                    }
                                    return coroutine_suspended;
                                }
                                i2++;
                                if (i2 < size) {
                                    boolean isActive2 = JobKt.isActive(asyncFontListLoader$load$12.getContext());
                                    this.cacheable = false;
                                    this.onCompletion.invoke(new TypefaceResult.Immutable(getValue(), isActive2));
                                    return Unit.INSTANCE;
                                }
                            } catch (Throwable th) {
                                th = th;
                                asyncFontListLoader$load$13 = asyncFontListLoader$load$12;
                                boolean isActive3 = JobKt.isActive(asyncFontListLoader$load$13.getContext());
                                this.cacheable = false;
                                this.onCompletion.invoke(new TypefaceResult.Immutable(getValue(), isActive3));
                                throw th;
                            }
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        asyncFontListLoader$load$1 = new AsyncFontListLoader$load$1(this, continuation);
        AsyncFontListLoader$load$1 asyncFontListLoader$load$132 = asyncFontListLoader$load$1;
        Object obj2 = asyncFontListLoader$load$132.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = asyncFontListLoader$load$132.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadWithTimeoutOrNull$ui_text(Font font, Continuation<Object> continuation) {
        AsyncFontListLoader$loadWithTimeoutOrNull$1 asyncFontListLoader$loadWithTimeoutOrNull$1;
        int i;
        try {
            if (continuation instanceof AsyncFontListLoader$loadWithTimeoutOrNull$1) {
                asyncFontListLoader$loadWithTimeoutOrNull$1 = (AsyncFontListLoader$loadWithTimeoutOrNull$1) continuation;
                if ((asyncFontListLoader$loadWithTimeoutOrNull$1.label & Integer.MIN_VALUE) != 0) {
                    asyncFontListLoader$loadWithTimeoutOrNull$1.label -= Integer.MIN_VALUE;
                    Object obj = asyncFontListLoader$loadWithTimeoutOrNull$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = asyncFontListLoader$loadWithTimeoutOrNull$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            Font font2 = (Font) asyncFontListLoader$loadWithTimeoutOrNull$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    asyncFontListLoader$loadWithTimeoutOrNull$1.L$0 = font;
                    asyncFontListLoader$loadWithTimeoutOrNull$1.label = 1;
                    Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(15000L, new AsyncFontListLoader$loadWithTimeoutOrNull$2(this, font, null), asyncFontListLoader$loadWithTimeoutOrNull$1);
                    return withTimeoutOrNull == coroutine_suspended ? coroutine_suspended : withTimeoutOrNull;
                }
            }
            if (i == 0) {
            }
        } catch (CancellationException e) {
            if (!JobKt.isActive(asyncFontListLoader$loadWithTimeoutOrNull$1.getContext())) {
                throw e;
            }
            return null;
        } catch (Exception e2) {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) asyncFontListLoader$loadWithTimeoutOrNull$1.getContext().get(CoroutineExceptionHandler.Key);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(asyncFontListLoader$loadWithTimeoutOrNull$1.getContext(), new IllegalStateException("Unable to load font " + font, e2));
            }
            return null;
        }
        asyncFontListLoader$loadWithTimeoutOrNull$1 = new AsyncFontListLoader$loadWithTimeoutOrNull$1(this, continuation);
        Object obj2 = asyncFontListLoader$loadWithTimeoutOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = asyncFontListLoader$loadWithTimeoutOrNull$1.label;
    }
}
