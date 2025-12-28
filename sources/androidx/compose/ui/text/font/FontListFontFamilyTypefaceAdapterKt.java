package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.AsyncTypefaceCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0002¨\u0006\r"}, d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FontListFontFamilyTypefaceAdapterKt {
    public static final /* synthetic */ Pair access$firstImmediatelyAvailable(List list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1 function1) {
        return firstImmediatelyAvailable(list, typefaceRequest, asyncTypefaceCache, platformFontLoader, function1);
    }

    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1<? super TypefaceRequest, ? extends Object> function1) {
        Object invoke;
        Object obj;
        Object m10244constructorimpl;
        Object obj2;
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            Font font = list.get(i);
            int mo7759getLoadingStrategyPKNRLFQ = font.mo7759getLoadingStrategyPKNRLFQ();
            if (FontLoadingStrategy.m7802equalsimpl0(mo7759getLoadingStrategyPKNRLFQ, FontLoadingStrategy.Companion.m7807getBlockingPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                    if (asyncTypefaceResult == null) {
                        asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                    }
                    if (asyncTypefaceResult != null) {
                        obj = asyncTypefaceResult.m7776unboximpl();
                    } else {
                        Unit unit = Unit.INSTANCE;
                        try {
                            invoke = platformFontLoader.loadBlocking(font);
                        } catch (Exception unused) {
                            invoke = function1.invoke(typefaceRequest);
                        }
                        Object obj3 = invoke;
                        AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, obj3, false, 8, null);
                        obj = obj3;
                    }
                }
                if (obj == null) {
                    obj = function1.invoke(typefaceRequest);
                }
                return TuplesKt.to(list2, FontSynthesis_androidKt.m7837synthesizeTypefaceFxwP2eA(typefaceRequest.m7863getFontSynthesisGVVA2EU(), obj, font, typefaceRequest.getFontWeight(), typefaceRequest.m7862getFontStyle_LCdwA()));
            }
            if (FontLoadingStrategy.m7802equalsimpl0(mo7759getLoadingStrategyPKNRLFQ, FontLoadingStrategy.Companion.m7808getOptionalLocalPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                    if (asyncTypefaceResult2 == null) {
                        asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                    }
                    if (asyncTypefaceResult2 != null) {
                        obj2 = asyncTypefaceResult2.m7776unboximpl();
                    } else {
                        Unit unit2 = Unit.INSTANCE;
                        try {
                            Result.Companion companion = Result.Companion;
                            m10244constructorimpl = Result.m10244constructorimpl(platformFontLoader.loadBlocking(font));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            m10244constructorimpl = Result.m10244constructorimpl(ResultKt.createFailure(th));
                        }
                        Object obj4 = Result.m10250isFailureimpl(m10244constructorimpl) ? null : m10244constructorimpl;
                        AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, obj4, false, 8, null);
                        obj2 = obj4;
                    }
                }
                if (obj2 != null) {
                    return TuplesKt.to(list2, FontSynthesis_androidKt.m7837synthesizeTypefaceFxwP2eA(typefaceRequest.m7863getFontSynthesisGVVA2EU(), obj2, font, typefaceRequest.getFontWeight(), typefaceRequest.m7862getFontStyle_LCdwA()));
                }
            } else if (!FontLoadingStrategy.m7802equalsimpl0(mo7759getLoadingStrategyPKNRLFQ, FontLoadingStrategy.Companion.m7806getAsyncPKNRLFQ())) {
                throw new IllegalStateException("Unknown font type " + font);
            } else {
                AsyncTypefaceCache.AsyncTypefaceResult m7768get1ASDuI8 = asyncTypefaceCache.m7768get1ASDuI8(font, platformFontLoader);
                if (m7768get1ASDuI8 == null) {
                    if (list2 == null) {
                        list2 = CollectionsKt.mutableListOf(font);
                    } else {
                        list2.add(font);
                    }
                } else if (!AsyncTypefaceCache.AsyncTypefaceResult.m7774isPermanentFailureimpl(m7768get1ASDuI8.m7776unboximpl()) && m7768get1ASDuI8.m7776unboximpl() != null) {
                    return TuplesKt.to(list2, FontSynthesis_androidKt.m7837synthesizeTypefaceFxwP2eA(typefaceRequest.m7863getFontSynthesisGVVA2EU(), m7768get1ASDuI8.m7776unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m7862getFontStyle_LCdwA()));
                }
            }
        }
        return TuplesKt.to(list2, function1.invoke(typefaceRequest));
    }
}
