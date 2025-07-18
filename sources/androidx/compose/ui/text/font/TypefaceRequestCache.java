package androidx.compose.ui.text.font;

import androidx.collection.LruCache;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: FontFamilyResolver.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0011J(\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0017J4\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\u0010\u001a\u00020\t2\u001e\u0010\u0016\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0017\u0012\u0004\u0012\u00020\n0\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/font/TypefaceRequestCache;", "", "()V", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "getLock$ui_text_release", "()Landroidx/compose/ui/text/platform/SynchronizedObject;", "resultCache", "Landroidx/collection/LruCache;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "Landroidx/compose/ui/text/font/TypefaceResult;", "size", "", "getSize$ui_text_release", "()I", "get", "typefaceRequest", "get$ui_text_release", "preWarmCache", "", "typefaceRequests", "", "resolveTypeface", "Lkotlin/Function1;", "runCached", "Landroidx/compose/runtime/State;", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TypefaceRequestCache {
    public static final int $stable = 8;
    private final SynchronizedObject lock = new SynchronizedObject();
    private final LruCache<TypefaceRequest, TypefaceResult> resultCache = new LruCache<>(16);

    public final SynchronizedObject getLock$ui_text_release() {
        return this.lock;
    }

    public final State<Object> runCached(final TypefaceRequest typefaceRequest, Function1<? super Function1<? super TypefaceResult, Unit>, ? extends TypefaceResult> function1) {
        synchronized (this.lock) {
            TypefaceResult typefaceResult = this.resultCache.get(typefaceRequest);
            if (typefaceResult != null) {
                if (typefaceResult.getCacheable()) {
                    return typefaceResult;
                }
                this.resultCache.remove(typefaceRequest);
            }
            try {
                TypefaceResult invoke = function1.invoke(new Function1<TypefaceResult, Unit>() { // from class: androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TypefaceResult typefaceResult2) {
                        invoke2(typefaceResult2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(TypefaceResult typefaceResult2) {
                        LruCache lruCache;
                        LruCache lruCache2;
                        SynchronizedObject lock$ui_text_release = TypefaceRequestCache.this.getLock$ui_text_release();
                        TypefaceRequestCache typefaceRequestCache = TypefaceRequestCache.this;
                        TypefaceRequest typefaceRequest2 = typefaceRequest;
                        synchronized (lock$ui_text_release) {
                            if (typefaceResult2.getCacheable()) {
                                lruCache2 = typefaceRequestCache.resultCache;
                                lruCache2.put(typefaceRequest2, typefaceResult2);
                            } else {
                                lruCache = typefaceRequestCache.resultCache;
                                lruCache.remove(typefaceRequest2);
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                });
                synchronized (this.lock) {
                    if (this.resultCache.get(typefaceRequest) == null && invoke.getCacheable()) {
                        this.resultCache.put(typefaceRequest, invoke);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                return invoke;
            } catch (Exception e) {
                throw new IllegalStateException("Could not load font", e);
            }
        }
    }

    public final void preWarmCache(List<TypefaceRequest> list, Function1<? super TypefaceRequest, ? extends TypefaceResult> function1) {
        TypefaceResult typefaceResult;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TypefaceRequest typefaceRequest = list.get(i);
            synchronized (this.lock) {
                typefaceResult = this.resultCache.get(typefaceRequest);
            }
            if (typefaceResult == null) {
                try {
                    TypefaceResult invoke = function1.invoke(typefaceRequest);
                    if (invoke instanceof TypefaceResult.Async) {
                        continue;
                    } else {
                        synchronized (this.lock) {
                            this.resultCache.put(typefaceRequest, invoke);
                        }
                    }
                } catch (Exception e) {
                    throw new IllegalStateException("Could not load font", e);
                }
            }
        }
    }

    public final TypefaceResult get$ui_text_release(TypefaceRequest typefaceRequest) {
        TypefaceResult typefaceResult;
        synchronized (this.lock) {
            typefaceResult = this.resultCache.get(typefaceRequest);
        }
        return typefaceResult;
    }

    public final int getSize$ui_text_release() {
        int size;
        synchronized (this.lock) {
            size = this.resultCache.size();
        }
        return size;
    }
}
