package androidx.compose.ui.text.font;

import androidx.collection.MutableScatterSet;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.DispatcherKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJB\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00190\u0016H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "Landroidx/compose/ui/text/font/FontFamilyTypefaceAdapter;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "injectedContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/coroutines/CoroutineContext;)V", "asyncLoadScope", "Lkotlinx/coroutines/CoroutineScope;", "preload", "", "family", "Landroidx/compose/ui/text/font/FontFamily;", "resourceLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/PlatformFontLoader;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/ui/text/font/TypefaceResult;", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "platformFontLoader", "onAsyncCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "createDefaultTypeface", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FontListFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {
    private CoroutineScope asyncLoadScope;
    private final AsyncTypefaceCache asyncTypefaceCache;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final FontMatcher fontMatcher = new FontMatcher();
    private static final CoroutineExceptionHandler DropExceptionHandler = new FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);

    public FontListFontFamilyTypefaceAdapter() {
        this(null, null, 3, null);
    }

    public FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache, CoroutineContext coroutineContext) {
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.asyncLoadScope = CoroutineScopeKt.CoroutineScope(DropExceptionHandler.plus(DispatcherKt.getFontCacheManagementDispatcher()).plus(coroutineContext).plus(SupervisorKt.SupervisorJob((Job) coroutineContext.get(Job.Key))));
    }

    public /* synthetic */ FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache, EmptyCoroutineContext emptyCoroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AsyncTypefaceCache() : asyncTypefaceCache, (i & 2) != 0 ? EmptyCoroutineContext.INSTANCE : emptyCoroutineContext);
    }

    public final Object preload(FontFamily fontFamily, PlatformFontLoader platformFontLoader, Continuation<? super Unit> continuation) {
        FontFamily fontFamily2 = fontFamily;
        if (fontFamily2 instanceof FontListFontFamily) {
            FontListFontFamily fontListFontFamily = (FontListFontFamily) fontFamily2;
            List<Font> fonts = fontListFontFamily.getFonts();
            List<Font> fonts2 = fontListFontFamily.getFonts();
            ArrayList arrayList = new ArrayList(fonts2.size());
            int size = fonts2.size();
            for (int i = 0; i < size; i++) {
                Font font = fonts2.get(i);
                if (FontLoadingStrategy.m6246equalsimpl0(font.mo6204getLoadingStrategyPKNRLFQ(), FontLoadingStrategy.Companion.m6250getAsyncPKNRLFQ())) {
                    arrayList.add(TuplesKt.to(font.getWeight(), FontStyle.m6256boximpl(font.mo6212getStyle_LCdwA())));
                }
            }
            ArrayList arrayList2 = arrayList;
            MutableScatterSet mutableScatterSet = new MutableScatterSet(arrayList2.size());
            ArrayList arrayList3 = new ArrayList(arrayList2.size());
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Object obj = arrayList2.get(i2);
                if (mutableScatterSet.add((Pair) obj)) {
                    arrayList3.add(obj);
                }
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList();
            int size3 = arrayList4.size();
            int i3 = 0;
            while (i3 < size3) {
                Pair pair = (Pair) arrayList4.get(i3);
                FontWeight fontWeight = (FontWeight) pair.component1();
                int m6262unboximpl = ((FontStyle) pair.component2()).m6262unboximpl();
                List list = (List) FontListFontFamilyTypefaceAdapterKt.access$firstImmediatelyAvailable(fontMatcher.m6255matchFontRetOiIg(fonts, fontWeight, m6262unboximpl), new TypefaceRequest(fontFamily2, fontWeight, m6262unboximpl, FontSynthesis.Companion.m6276getAllGVVA2EU(), platformFontLoader.getCacheKey(), null), this.asyncTypefaceCache, platformFontLoader, new Function1<TypefaceRequest, Unit>() { // from class: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$2$1
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(TypefaceRequest typefaceRequest) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TypefaceRequest typefaceRequest) {
                        invoke2(typefaceRequest);
                        return Unit.INSTANCE;
                    }
                }).component1();
                if (list != null) {
                    arrayList5.add(CollectionsKt.first((List<? extends Object>) list));
                }
                i3++;
                fontFamily2 = fontFamily;
            }
            Object coroutineScope = CoroutineScopeKt.coroutineScope(new FontListFontFamilyTypefaceAdapter$preload$3(arrayList5, this, platformFontLoader, null), continuation);
            return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.text.font.FontFamilyTypefaceAdapter
    public TypefaceResult resolve(TypefaceRequest typefaceRequest, PlatformFontLoader platformFontLoader, Function1<? super TypefaceResult.Immutable, Unit> function1, Function1<? super TypefaceRequest, ? extends Object> function12) {
        if (typefaceRequest.getFontFamily() instanceof FontListFontFamily) {
            Pair access$firstImmediatelyAvailable = FontListFontFamilyTypefaceAdapterKt.access$firstImmediatelyAvailable(fontMatcher.m6255matchFontRetOiIg(((FontListFontFamily) typefaceRequest.getFontFamily()).getFonts(), typefaceRequest.getFontWeight(), typefaceRequest.m6304getFontStyle_LCdwA()), typefaceRequest, this.asyncTypefaceCache, platformFontLoader, function12);
            List list = (List) access$firstImmediatelyAvailable.component1();
            Object component2 = access$firstImmediatelyAvailable.component2();
            if (list == null) {
                return new TypefaceResult.Immutable(component2, false, 2, null);
            }
            AsyncFontListLoader asyncFontListLoader = new AsyncFontListLoader(list, component2, typefaceRequest, this.asyncTypefaceCache, function1, platformFontLoader);
            BuildersKt__Builders_commonKt.launch$default(this.asyncLoadScope, null, CoroutineStart.UNDISPATCHED, new FontListFontFamilyTypefaceAdapter$resolve$1(asyncFontListLoader, null), 1, null);
            return new TypefaceResult.Async(asyncFontListLoader);
        }
        return null;
    }

    /* compiled from: FontListFontFamilyTypefaceAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter$Companion;", "", "()V", "DropExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getDropExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FontMatcher getFontMatcher() {
            return FontListFontFamilyTypefaceAdapter.fontMatcher;
        }

        public final CoroutineExceptionHandler getDropExceptionHandler() {
            return FontListFontFamilyTypefaceAdapter.DropExceptionHandler;
        }
    }
}
