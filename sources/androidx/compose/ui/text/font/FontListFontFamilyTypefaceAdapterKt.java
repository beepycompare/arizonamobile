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
        Object m9904constructorimpl;
        Object obj2;
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            Font font = list.get(i);
            int mo7515getLoadingStrategyPKNRLFQ = font.mo7515getLoadingStrategyPKNRLFQ();
            if (!FontLoadingStrategy.m7558equalsimpl0(mo7515getLoadingStrategyPKNRLFQ, FontLoadingStrategy.Companion.m7563getBlockingPKNRLFQ())) {
                if (!FontLoadingStrategy.m7558equalsimpl0(mo7515getLoadingStrategyPKNRLFQ, FontLoadingStrategy.Companion.m7564getOptionalLocalPKNRLFQ())) {
                    if (FontLoadingStrategy.m7558equalsimpl0(mo7515getLoadingStrategyPKNRLFQ, FontLoadingStrategy.Companion.m7562getAsyncPKNRLFQ())) {
                        AsyncTypefaceCache.AsyncTypefaceResult m7524get1ASDuI8 = asyncTypefaceCache.m7524get1ASDuI8(font, platformFontLoader);
                        if (m7524get1ASDuI8 == null) {
                            if (list2 == null) {
                                list2 = CollectionsKt.mutableListOf(font);
                            } else {
                                list2.add(font);
                            }
                        } else if (!AsyncTypefaceCache.AsyncTypefaceResult.m7530isPermanentFailureimpl(m7524get1ASDuI8.m7532unboximpl()) && m7524get1ASDuI8.m7532unboximpl() != null) {
                            return TuplesKt.to(list2, FontSynthesis_androidKt.m7592synthesizeTypefaceFxwP2eA(typefaceRequest.m7618getFontSynthesisGVVA2EU(), m7524get1ASDuI8.m7532unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m7617getFontStyle_LCdwA()));
                        }
                    } else {
                        throw new IllegalStateException("Unknown font type " + font);
                    }
                } else {
                    synchronized (asyncTypefaceCache.cacheLock) {
                        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                        if (asyncTypefaceResult == null) {
                            asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                        }
                        if (asyncTypefaceResult != null) {
                            obj2 = asyncTypefaceResult.m7532unboximpl();
                        } else {
                            Unit unit = Unit.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                m9904constructorimpl = Result.m9904constructorimpl(platformFontLoader.loadBlocking(font));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                m9904constructorimpl = Result.m9904constructorimpl(ResultKt.createFailure(th));
                            }
                            Object obj3 = Result.m9910isFailureimpl(m9904constructorimpl) ? null : m9904constructorimpl;
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, obj3, false, 8, null);
                            obj2 = obj3;
                        }
                    }
                    if (obj2 != null) {
                        return TuplesKt.to(list2, FontSynthesis_androidKt.m7592synthesizeTypefaceFxwP2eA(typefaceRequest.m7618getFontSynthesisGVVA2EU(), obj2, font, typefaceRequest.getFontWeight(), typefaceRequest.m7617getFontStyle_LCdwA()));
                    }
                }
            } else {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                    if (asyncTypefaceResult2 == null) {
                        asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                    }
                    if (asyncTypefaceResult2 != null) {
                        obj = asyncTypefaceResult2.m7532unboximpl();
                    } else {
                        Unit unit2 = Unit.INSTANCE;
                        try {
                            invoke = platformFontLoader.loadBlocking(font);
                        } catch (Exception unused) {
                            invoke = function1.invoke(typefaceRequest);
                        }
                        Object obj4 = invoke;
                        AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, obj4, false, 8, null);
                        obj = obj4;
                    }
                }
                if (obj == null) {
                    obj = function1.invoke(typefaceRequest);
                }
                return TuplesKt.to(list2, FontSynthesis_androidKt.m7592synthesizeTypefaceFxwP2eA(typefaceRequest.m7618getFontSynthesisGVVA2EU(), obj, font, typefaceRequest.getFontWeight(), typefaceRequest.m7617getFontStyle_LCdwA()));
            }
        }
        return TuplesKt.to(list2, function1.invoke(typefaceRequest));
    }
}
