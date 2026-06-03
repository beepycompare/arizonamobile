package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: PageEvent.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0004\u0010\u0011\u0012\u0013B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004JB\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0000\"\b\b\u0001\u0010\u0006*\u00020\u00022\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0096@¢\u0006\u0002\u0010\nJH\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0000\"\b\b\u0001\u0010\u0006*\u00020\u00022(\u0010\u0007\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\f0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0096@¢\u0006\u0002\u0010\nJ8\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0096@¢\u0006\u0002\u0010\n\u0082\u0001\u0004\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Landroidx/paging/PageEvent;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "map", "R", "transform", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flatMap", "", "filter", "predicate", "", "StaticList", "Insert", "Drop", "LoadStateUpdate", "Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/PageEvent$Insert;", "Landroidx/paging/PageEvent$LoadStateUpdate;", "Landroidx/paging/PageEvent$StaticList;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PageEvent<T> {
    public /* synthetic */ PageEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    static /* synthetic */ <T> Object filter$suspendImpl(PageEvent<T> pageEvent, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super PageEvent<T>> continuation) {
        return pageEvent;
    }

    public Object filter(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super PageEvent<T>> continuation) {
        return filter$suspendImpl(this, function2, continuation);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.paging.PageEvent.flatMap$suspendImpl(androidx.paging.PageEvent<T>, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Iterable<? extends R>>, ? extends java.lang.Object>, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>>):java.lang.Object
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
        	... 1 more
        */
    public <R> java.lang.Object flatMap(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Iterable<? extends R>>, ? extends java.lang.Object> r1, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r2) {
        /*
            r0 = this;
            java.lang.Object r0 = flatMap$suspendImpl(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.flatMap(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.paging.PageEvent.map$suspendImpl(androidx.paging.PageEvent<T>, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object>, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>>):java.lang.Object
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
        	... 1 more
        */
    public <R> java.lang.Object map(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r1, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r2) {
        /*
            r0 = this;
            java.lang.Object r0 = map$suspendImpl(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.map(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private PageEvent() {
    }

    /* compiled from: PageEvent.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BA\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJB\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\b\b\u0002\u0010\u0017*\u00020\u00022\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001bJH\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\b\b\u0002\u0010\u0017*\u00020\u00022(\u0010\u0018\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001d0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001bJ8\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\u001f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001bJ\b\u0010!\u001a\u00020\"H\u0016J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003JK\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0014\u0010)\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010+\u001a\u00020\nHÖ\u0081\u0004R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006,"}, d2 = {"Landroidx/paging/PageEvent$StaticList;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PageEvent;", "data", "", "sourceLoadStates", "Landroidx/paging/LoadStates;", "mediatorLoadStates", "placeholdersBefore", "", "placeholdersAfter", "<init>", "(Ljava/util/List;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;II)V", "getData", "()Ljava/util/List;", "getSourceLoadStates", "()Landroidx/paging/LoadStates;", "getMediatorLoadStates", "getPlaceholdersBefore", "()I", "getPlaceholdersAfter", "map", "R", "transform", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flatMap", "", "filter", "predicate", "", "toString", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class StaticList<T> extends PageEvent<T> {
        private final List<T> data;
        private final LoadStates mediatorLoadStates;
        private final int placeholdersAfter;
        private final int placeholdersBefore;
        private final LoadStates sourceLoadStates;

        public static /* synthetic */ StaticList copy$default(StaticList staticList, List list, LoadStates loadStates, LoadStates loadStates2, int i, int i2, int i3, Object obj) {
            List<T> list2 = list;
            if ((i3 & 1) != 0) {
                list2 = staticList.data;
            }
            if ((i3 & 2) != 0) {
                loadStates = staticList.sourceLoadStates;
            }
            if ((i3 & 4) != 0) {
                loadStates2 = staticList.mediatorLoadStates;
            }
            if ((i3 & 8) != 0) {
                i = staticList.placeholdersBefore;
            }
            if ((i3 & 16) != 0) {
                i2 = staticList.placeholdersAfter;
            }
            int i4 = i2;
            LoadStates loadStates3 = loadStates2;
            return staticList.copy(list2, loadStates, loadStates3, i, i4);
        }

        public final List<T> component1() {
            return this.data;
        }

        public final LoadStates component2() {
            return this.sourceLoadStates;
        }

        public final LoadStates component3() {
            return this.mediatorLoadStates;
        }

        public final int component4() {
            return this.placeholdersBefore;
        }

        public final int component5() {
            return this.placeholdersAfter;
        }

        public final StaticList<T> copy(List<? extends T> data, LoadStates loadStates, LoadStates loadStates2, int i, int i2) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new StaticList<>(data, loadStates, loadStates2, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StaticList) {
                StaticList staticList = (StaticList) obj;
                return Intrinsics.areEqual(this.data, staticList.data) && Intrinsics.areEqual(this.sourceLoadStates, staticList.sourceLoadStates) && Intrinsics.areEqual(this.mediatorLoadStates, staticList.mediatorLoadStates) && this.placeholdersBefore == staticList.placeholdersBefore && this.placeholdersAfter == staticList.placeholdersAfter;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.data.hashCode() * 31;
            LoadStates loadStates = this.sourceLoadStates;
            int hashCode2 = (hashCode + (loadStates == null ? 0 : loadStates.hashCode())) * 31;
            LoadStates loadStates2 = this.mediatorLoadStates;
            return ((((hashCode2 + (loadStates2 != null ? loadStates2.hashCode() : 0)) * 31) + Integer.hashCode(this.placeholdersBefore)) * 31) + Integer.hashCode(this.placeholdersAfter);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public StaticList(List<? extends T> data, LoadStates loadStates, LoadStates loadStates2, int i, int i2) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.sourceLoadStates = loadStates;
            this.mediatorLoadStates = loadStates2;
            this.placeholdersBefore = i;
            this.placeholdersAfter = i2;
        }

        public /* synthetic */ StaticList(List list, LoadStates loadStates, LoadStates loadStates2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i3 & 2) != 0 ? null : loadStates, (i3 & 4) != 0 ? null : loadStates2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2);
        }

        public final List<T> getData() {
            return this.data;
        }

        public final LoadStates getSourceLoadStates() {
            return this.sourceLoadStates;
        }

        public final LoadStates getMediatorLoadStates() {
            return this.mediatorLoadStates;
        }

        public final int getPlaceholdersBefore() {
            return this.placeholdersBefore;
        }

        public final int getPlaceholdersAfter() {
            return this.placeholdersAfter;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
        /* JADX WARN: Type inference failed for: r14v7, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r4v5 */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v8, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0079 -> B:21:0x007c). Please submit an issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public <R> Object map(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super PageEvent<R>> continuation) {
            PageEvent$StaticList$map$1 pageEvent$StaticList$map$1;
            int i;
            Function2<? super T, ? super Continuation<? super R>, ? extends Object> function22;
            ArrayList arrayList;
            Iterator<T> it;
            if (continuation instanceof PageEvent$StaticList$map$1) {
                pageEvent$StaticList$map$1 = (PageEvent$StaticList$map$1) continuation;
                if ((pageEvent$StaticList$map$1.label & Integer.MIN_VALUE) != 0) {
                    pageEvent$StaticList$map$1.label -= Integer.MIN_VALUE;
                    Object obj = pageEvent$StaticList$map$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pageEvent$StaticList$map$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        List<T> list = this.data;
                        Iterator<T> it2 = list.iterator();
                        function22 = function2;
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        it = it2;
                        if (it.hasNext()) {
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        it = (Iterator) pageEvent$StaticList$map$1.L$2;
                        ?? r4 = (Collection) pageEvent$StaticList$map$1.L$1;
                        Function2<? super T, ? super Continuation<? super R>, ? extends Object> function23 = (Function2) pageEvent$StaticList$map$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ArrayList arrayList2 = (Collection) pageEvent$StaticList$map$1.L$3;
                        arrayList2.add(obj);
                        arrayList = r4;
                        function22 = function23;
                        if (it.hasNext()) {
                            pageEvent$StaticList$map$1.L$0 = function22;
                            pageEvent$StaticList$map$1.L$1 = arrayList;
                            pageEvent$StaticList$map$1.L$2 = it;
                            pageEvent$StaticList$map$1.L$3 = arrayList;
                            pageEvent$StaticList$map$1.label = 1;
                            Object invoke = function22.invoke((T) it.next(), pageEvent$StaticList$map$1);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function23 = function22;
                            obj = invoke;
                            r4 = arrayList;
                            arrayList2 = arrayList;
                            arrayList2.add(obj);
                            arrayList = r4;
                            function22 = function23;
                            if (it.hasNext()) {
                                return new StaticList(arrayList, this.sourceLoadStates, this.mediatorLoadStates, this.placeholdersBefore, this.placeholdersAfter);
                            }
                        }
                    }
                }
            }
            pageEvent$StaticList$map$1 = new PageEvent$StaticList$map$1(this, continuation);
            Object obj2 = pageEvent$StaticList$map$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = pageEvent$StaticList$map$1.label;
            if (i != 0) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006c -> B:21:0x006f). Please submit an issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public <R> Object flatMap(Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> function2, Continuation<? super PageEvent<R>> continuation) {
            PageEvent$StaticList$flatMap$1 pageEvent$StaticList$flatMap$1;
            int i;
            ArrayList arrayList;
            Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> function22;
            Iterator<T> it;
            if (continuation instanceof PageEvent$StaticList$flatMap$1) {
                pageEvent$StaticList$flatMap$1 = (PageEvent$StaticList$flatMap$1) continuation;
                if ((pageEvent$StaticList$flatMap$1.label & Integer.MIN_VALUE) != 0) {
                    pageEvent$StaticList$flatMap$1.label -= Integer.MIN_VALUE;
                    Object obj = pageEvent$StaticList$flatMap$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pageEvent$StaticList$flatMap$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        arrayList = new ArrayList();
                        function22 = function2;
                        it = this.data.iterator();
                        if (it.hasNext()) {
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        it = (Iterator) pageEvent$StaticList$flatMap$1.L$2;
                        arrayList = (Collection) pageEvent$StaticList$flatMap$1.L$1;
                        Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> function23 = (Function2) pageEvent$StaticList$flatMap$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        CollectionsKt.addAll(arrayList, (Iterable) obj);
                        function22 = function23;
                        if (it.hasNext()) {
                            pageEvent$StaticList$flatMap$1.L$0 = function22;
                            pageEvent$StaticList$flatMap$1.L$1 = arrayList;
                            pageEvent$StaticList$flatMap$1.L$2 = it;
                            pageEvent$StaticList$flatMap$1.label = 1;
                            Object invoke = function22.invoke((T) it.next(), pageEvent$StaticList$flatMap$1);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function23 = function22;
                            obj = invoke;
                            CollectionsKt.addAll(arrayList, (Iterable) obj);
                            function22 = function23;
                            if (it.hasNext()) {
                                return new StaticList((List) arrayList, this.sourceLoadStates, this.mediatorLoadStates, this.placeholdersBefore, this.placeholdersAfter);
                            }
                        }
                    }
                }
            }
            pageEvent$StaticList$flatMap$1 = new PageEvent$StaticList$flatMap$1(this, continuation);
            Object obj2 = pageEvent$StaticList$flatMap$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = pageEvent$StaticList$flatMap$1.label;
            if (i != 0) {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
        /* JADX WARN: Type inference failed for: r4v4, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006f -> B:21:0x0073). Please submit an issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object filter(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super PageEvent<T>> continuation) {
            PageEvent$StaticList$filter$1 pageEvent$StaticList$filter$1;
            int i;
            ArrayList arrayList;
            Iterator<T> it;
            if (continuation instanceof PageEvent$StaticList$filter$1) {
                pageEvent$StaticList$filter$1 = (PageEvent$StaticList$filter$1) continuation;
                if ((pageEvent$StaticList$filter$1.label & Integer.MIN_VALUE) != 0) {
                    pageEvent$StaticList$filter$1.label -= Integer.MIN_VALUE;
                    Object obj = pageEvent$StaticList$filter$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pageEvent$StaticList$filter$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        arrayList = new ArrayList();
                        it = this.data.iterator();
                        if (it.hasNext()) {
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object obj2 = pageEvent$StaticList$filter$1.L$3;
                        it = (Iterator) pageEvent$StaticList$filter$1.L$2;
                        Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function22 = (Function2) pageEvent$StaticList$filter$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        ArrayList arrayList2 = (Collection) pageEvent$StaticList$filter$1.L$1;
                        if (((Boolean) obj).booleanValue()) {
                            arrayList2.add(obj2);
                        }
                        function2 = function22;
                        arrayList = arrayList2;
                        if (it.hasNext()) {
                            Object next = it.next();
                            pageEvent$StaticList$filter$1.L$0 = function2;
                            pageEvent$StaticList$filter$1.L$1 = arrayList;
                            pageEvent$StaticList$filter$1.L$2 = it;
                            pageEvent$StaticList$filter$1.L$3 = next;
                            pageEvent$StaticList$filter$1.label = 1;
                            Object invoke = function2.invoke(next, pageEvent$StaticList$filter$1);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function22 = function2;
                            obj2 = next;
                            obj = invoke;
                            arrayList2 = arrayList;
                            if (((Boolean) obj).booleanValue()) {
                            }
                            function2 = function22;
                            arrayList = arrayList2;
                            if (it.hasNext()) {
                                return new StaticList(arrayList, this.sourceLoadStates, this.mediatorLoadStates, this.placeholdersBefore, this.placeholdersAfter);
                            }
                        }
                    }
                }
            }
            pageEvent$StaticList$filter$1 = new PageEvent$StaticList$filter$1(this, continuation);
            Object obj3 = pageEvent$StaticList$filter$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = pageEvent$StaticList$filter$1.label;
            if (i != 0) {
            }
        }

        public String toString() {
            LoadStates loadStates = this.mediatorLoadStates;
            String str = "PageEvent.StaticList with " + this.data.size() + " items (\n                    |   first item: " + CollectionsKt.firstOrNull((List<? extends Object>) this.data) + "\n                    |   last item: " + CollectionsKt.lastOrNull((List<? extends Object>) this.data) + "\n                    |   sourceLoadStates: " + this.sourceLoadStates + ",\n                    |   placeholdersBefore: " + this.placeholdersBefore + ",\n                    |   placeholdersAfter: " + this.placeholdersAfter + ",\n                    ";
            if (loadStates != null) {
                str = str + "|   mediatorLoadStates: " + loadStates + '\n';
            }
            return StringsKt.trimMargin$default(str + "|)", null, 1, null);
        }
    }

    /* compiled from: PageEvent.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u0000 6*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00016BI\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0000\"\b\b\u0002\u0010\u001c*\u00020\u00022\u001e\u0010\u001d\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\b0\u001eH\u0082\bJM\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0000\"\b\b\u0002\u0010\u001c*\u00020\u00022*\u0010\u001d\u001a&\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\b0\u00070\u001eH\u0080\bø\u0001\u0000¢\u0006\u0002\b JB\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0003\"\b\b\u0002\u0010\u001c*\u00020\u00022\"\u0010\u001d\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0#\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"H\u0096@¢\u0006\u0002\u0010$JH\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0003\"\b\b\u0002\u0010\u001c*\u00020\u00022(\u0010\u001d\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0&0#\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"H\u0096@¢\u0006\u0002\u0010$J8\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0#\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"H\u0096@¢\u0006\u0002\u0010$J\b\u0010*\u001a\u00020+H\u0016J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u0015\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007HÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\rHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003JY\u00102\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0014\u00103\u001a\u00020)2\b\u00104\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u00105\u001a\u00020\nHÖ\u0081\u0004R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, d2 = {"Landroidx/paging/PageEvent$Insert;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PageEvent;", "loadType", "Landroidx/paging/LoadType;", "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersBefore", "", "placeholdersAfter", "sourceLoadStates", "Landroidx/paging/LoadStates;", "mediatorLoadStates", "<init>", "(Landroidx/paging/LoadType;Ljava/util/List;IILandroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "getLoadType", "()Landroidx/paging/LoadType;", "getPages", "()Ljava/util/List;", "getPlaceholdersBefore", "()I", "getPlaceholdersAfter", "getSourceLoadStates", "()Landroidx/paging/LoadStates;", "getMediatorLoadStates", "mapPages", "R", "transform", "Lkotlin/Function1;", "transformPages", "transformPages$paging_common", "map", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flatMap", "", "filter", "predicate", "", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "Companion", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Insert<T> extends PageEvent<T> {
        public static final Companion Companion = new Companion(null);
        private final LoadType loadType;
        private final LoadStates mediatorLoadStates;
        private final List<TransformablePage<T>> pages;
        private final int placeholdersAfter;
        private final int placeholdersBefore;
        private final LoadStates sourceLoadStates;

        public /* synthetic */ Insert(LoadType loadType, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadType, list, i, i2, loadStates, loadStates2);
        }

        public static /* synthetic */ Insert copy$default(Insert insert, LoadType loadType, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                loadType = insert.loadType;
            }
            List<TransformablePage<T>> list2 = list;
            if ((i3 & 2) != 0) {
                list2 = insert.pages;
            }
            if ((i3 & 4) != 0) {
                i = insert.placeholdersBefore;
            }
            if ((i3 & 8) != 0) {
                i2 = insert.placeholdersAfter;
            }
            if ((i3 & 16) != 0) {
                loadStates = insert.sourceLoadStates;
            }
            if ((i3 & 32) != 0) {
                loadStates2 = insert.mediatorLoadStates;
            }
            LoadStates loadStates3 = loadStates;
            LoadStates loadStates4 = loadStates2;
            return insert.copy(loadType, list2, i, i2, loadStates3, loadStates4);
        }

        public final LoadType component1() {
            return this.loadType;
        }

        public final List<TransformablePage<T>> component2() {
            return this.pages;
        }

        public final int component3() {
            return this.placeholdersBefore;
        }

        public final int component4() {
            return this.placeholdersAfter;
        }

        public final LoadStates component5() {
            return this.sourceLoadStates;
        }

        public final LoadStates component6() {
            return this.mediatorLoadStates;
        }

        public final Insert<T> copy(LoadType loadType, List<TransformablePage<T>> pages, int i, int i2, LoadStates sourceLoadStates, LoadStates loadStates) {
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            Intrinsics.checkNotNullParameter(pages, "pages");
            Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
            return new Insert<>(loadType, pages, i, i2, sourceLoadStates, loadStates);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Insert) {
                Insert insert = (Insert) obj;
                return this.loadType == insert.loadType && Intrinsics.areEqual(this.pages, insert.pages) && this.placeholdersBefore == insert.placeholdersBefore && this.placeholdersAfter == insert.placeholdersAfter && Intrinsics.areEqual(this.sourceLoadStates, insert.sourceLoadStates) && Intrinsics.areEqual(this.mediatorLoadStates, insert.mediatorLoadStates);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((((((this.loadType.hashCode() * 31) + this.pages.hashCode()) * 31) + Integer.hashCode(this.placeholdersBefore)) * 31) + Integer.hashCode(this.placeholdersAfter)) * 31) + this.sourceLoadStates.hashCode()) * 31;
            LoadStates loadStates = this.mediatorLoadStates;
            return hashCode + (loadStates == null ? 0 : loadStates.hashCode());
        }

        private Insert(LoadType loadType, List<TransformablePage<T>> list, int i, int i2, LoadStates loadStates, LoadStates loadStates2) {
            super(null);
            this.loadType = loadType;
            this.pages = list;
            this.placeholdersBefore = i;
            this.placeholdersAfter = i2;
            this.sourceLoadStates = loadStates;
            this.mediatorLoadStates = loadStates2;
            if (loadType != LoadType.APPEND && i < 0) {
                throw new IllegalArgumentException(("Prepend insert defining placeholdersBefore must be > 0, but was " + i).toString());
            }
            if (loadType != LoadType.PREPEND && i2 < 0) {
                throw new IllegalArgumentException(("Append insert defining placeholdersAfter must be > 0, but was " + i2).toString());
            }
            if (loadType == LoadType.REFRESH && list.isEmpty()) {
                throw new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.".toString());
            }
        }

        /* synthetic */ Insert(LoadType loadType, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadType, list, i, i2, loadStates, (i3 & 32) != 0 ? null : loadStates2);
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final List<TransformablePage<T>> getPages() {
            return this.pages;
        }

        public final int getPlaceholdersBefore() {
            return this.placeholdersBefore;
        }

        public final int getPlaceholdersAfter() {
            return this.placeholdersAfter;
        }

        public final LoadStates getSourceLoadStates() {
            return this.sourceLoadStates;
        }

        public final LoadStates getMediatorLoadStates() {
            return this.mediatorLoadStates;
        }

        public final <R> Insert<R> transformPages$paging_common(Function1<? super List<TransformablePage<T>>, ? extends List<TransformablePage<R>>> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            return new Insert<>(getLoadType(), transform.invoke(getPages()), getPlaceholdersBefore(), getPlaceholdersAfter(), getSourceLoadStates(), getMediatorLoadStates(), null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00f4  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x010b  */
        /* JADX WARN: Type inference failed for: r12v7, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r2v8, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r8v8, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x009c -> B:18:0x00c1). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ea -> B:24:0x00ee). Please submit an issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public <R> Object map(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super PageEvent<R>> continuation) {
            PageEvent$Insert$map$1 pageEvent$Insert$map$1;
            Insert<T> insert;
            int i;
            ArrayList arrayList;
            Iterator<T> it;
            LoadType loadType;
            Function2<? super T, ? super Continuation<? super R>, ? extends Object> function22;
            if (continuation instanceof PageEvent$Insert$map$1) {
                pageEvent$Insert$map$1 = (PageEvent$Insert$map$1) continuation;
                if ((pageEvent$Insert$map$1.label & Integer.MIN_VALUE) != 0) {
                    pageEvent$Insert$map$1.label -= Integer.MIN_VALUE;
                    insert = this;
                    Object obj = pageEvent$Insert$map$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pageEvent$Insert$map$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        LoadType loadType2 = insert.getLoadType();
                        List<TransformablePage<T>> pages = insert.getPages();
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages, 10));
                        it = pages.iterator();
                        loadType = loadType2;
                        function22 = function2;
                        if (it.hasNext()) {
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Collection collection = (Collection) pageEvent$Insert$map$1.L$9;
                        TransformablePage transformablePage = (TransformablePage) pageEvent$Insert$map$1.L$5;
                        Iterator<T> it2 = (Iterator) pageEvent$Insert$map$1.L$4;
                        ?? r12 = (Collection) pageEvent$Insert$map$1.L$3;
                        Insert<T> insert2 = (Insert) pageEvent$Insert$map$1.L$1;
                        Function2<? super T, ? super Continuation<? super R>, ? extends Object> function23 = (Function2) pageEvent$Insert$map$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        Iterator<T> it3 = (Iterator) pageEvent$Insert$map$1.L$8;
                        Iterator<T> it4 = it2;
                        ArrayList arrayList2 = (Collection) pageEvent$Insert$map$1.L$7;
                        ArrayList arrayList3 = r12;
                        int[] originalPageOffsets = (int[]) pageEvent$Insert$map$1.L$6;
                        LoadType loadType3 = (LoadType) pageEvent$Insert$map$1.L$2;
                        TransformablePage transformablePage2 = transformablePage;
                        ArrayList arrayList4 = (Collection) pageEvent$Insert$map$1.L$10;
                        collection.add(obj);
                        Insert<T> insert3 = insert2;
                        function22 = function23;
                        ArrayList arrayList5 = arrayList4;
                        if (it3.hasNext()) {
                            pageEvent$Insert$map$1.L$0 = function22;
                            pageEvent$Insert$map$1.L$1 = insert3;
                            pageEvent$Insert$map$1.L$2 = loadType3;
                            pageEvent$Insert$map$1.L$3 = arrayList3;
                            pageEvent$Insert$map$1.L$4 = it4;
                            pageEvent$Insert$map$1.L$5 = transformablePage2;
                            pageEvent$Insert$map$1.L$6 = originalPageOffsets;
                            pageEvent$Insert$map$1.L$7 = arrayList2;
                            pageEvent$Insert$map$1.L$8 = it3;
                            pageEvent$Insert$map$1.L$9 = arrayList2;
                            pageEvent$Insert$map$1.L$10 = arrayList5;
                            pageEvent$Insert$map$1.label = 1;
                            Object invoke = function22.invoke((T) it3.next(), pageEvent$Insert$map$1);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function23 = function22;
                            obj = invoke;
                            insert2 = insert3;
                            collection = arrayList2;
                            arrayList4 = arrayList5;
                            collection.add(obj);
                            Insert<T> insert32 = insert2;
                            function22 = function23;
                            ArrayList arrayList52 = arrayList4;
                            if (it3.hasNext()) {
                                arrayList52.add(new TransformablePage(originalPageOffsets, arrayList2, transformablePage2.getHintOriginalPageOffset(), transformablePage2.getHintOriginalIndices()));
                                insert = insert32;
                                it = it4;
                                arrayList = arrayList3;
                                loadType = loadType3;
                                if (it.hasNext()) {
                                    return new Insert(loadType, arrayList, insert.getPlaceholdersBefore(), insert.getPlaceholdersAfter(), insert.getSourceLoadStates(), insert.getMediatorLoadStates(), null);
                                }
                                TransformablePage transformablePage3 = (TransformablePage) it.next();
                                originalPageOffsets = transformablePage3.getOriginalPageOffsets();
                                List<T> data = transformablePage3.getData();
                                arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(data, 10));
                                it3 = data.iterator();
                                transformablePage2 = transformablePage3;
                                loadType3 = loadType;
                                arrayList3 = arrayList;
                                it4 = it;
                                insert32 = insert;
                                arrayList52 = arrayList3;
                                if (it3.hasNext()) {
                                }
                            }
                        }
                    }
                }
            }
            insert = this;
            pageEvent$Insert$map$1 = new PageEvent$Insert$map$1(insert, continuation);
            Object obj2 = pageEvent$Insert$map$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = pageEvent$Insert$map$1.label;
            if (i != 0) {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0121 A[LOOP:0: B:30:0x0117->B:32:0x0121, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0149  */
        /* JADX WARN: Type inference failed for: r10v8, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r6v9, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x009a -> B:18:0x00be). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00f8 -> B:27:0x0102). Please submit an issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public <R> Object flatMap(Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> function2, Continuation<? super PageEvent<R>> continuation) {
            PageEvent$Insert$flatMap$1 pageEvent$Insert$flatMap$1;
            Insert<T> insert;
            int i;
            Iterator<T> it;
            Object obj;
            LoadType loadType;
            Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> function22;
            if (continuation instanceof PageEvent$Insert$flatMap$1) {
                pageEvent$Insert$flatMap$1 = (PageEvent$Insert$flatMap$1) continuation;
                if ((pageEvent$Insert$flatMap$1.label & Integer.MIN_VALUE) != 0) {
                    pageEvent$Insert$flatMap$1.label -= Integer.MIN_VALUE;
                    insert = this;
                    Object obj2 = pageEvent$Insert$flatMap$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pageEvent$Insert$flatMap$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        LoadType loadType2 = insert.getLoadType();
                        List<TransformablePage<T>> pages = insert.getPages();
                        it = pages.iterator();
                        obj = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(pages, 10));
                        loadType = loadType2;
                        function22 = function2;
                        if (it.hasNext()) {
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i2 = pageEvent$Insert$flatMap$1.I$1;
                        int i3 = pageEvent$Insert$flatMap$1.I$0;
                        Collection collection = (Collection) pageEvent$Insert$flatMap$1.L$9;
                        Iterator<T> it2 = (Iterator) pageEvent$Insert$flatMap$1.L$8;
                        ArrayList arrayList = (List) pageEvent$Insert$flatMap$1.L$7;
                        Iterator<T> it3 = (Iterator) pageEvent$Insert$flatMap$1.L$4;
                        LoadType loadType3 = (LoadType) pageEvent$Insert$flatMap$1.L$2;
                        Insert<T> insert2 = (Insert) pageEvent$Insert$flatMap$1.L$1;
                        Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> function23 = (Function2) pageEvent$Insert$flatMap$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        int i4 = i3;
                        it = it3;
                        TransformablePage transformablePage = (TransformablePage) pageEvent$Insert$flatMap$1.L$5;
                        int i5 = i2;
                        ArrayList arrayList2 = (Collection) pageEvent$Insert$flatMap$1.L$10;
                        ArrayList arrayList3 = (List) pageEvent$Insert$flatMap$1.L$6;
                        Object obj3 = (Collection) pageEvent$Insert$flatMap$1.L$3;
                        CollectionsKt.addAll(collection, (Iterable) obj2);
                        List<Integer> hintOriginalIndices = transformablePage.getHintOriginalIndices();
                        if (hintOriginalIndices != null) {
                            i5 = hintOriginalIndices.get(i5).intValue();
                        }
                        while (arrayList.size() < arrayList3.size()) {
                            arrayList.add(Boxing.boxInt(i5));
                        }
                        function22 = function23;
                        i5 = i4;
                        Object obj4 = obj3;
                        loadType = loadType3;
                        insert = insert2;
                        TransformablePage transformablePage2 = transformablePage;
                        ArrayList arrayList4 = arrayList2;
                        ArrayList arrayList5 = arrayList3;
                        if (it2.hasNext()) {
                            Object obj5 = (T) it2.next();
                            int i6 = i5 + 1;
                            if (i5 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            ArrayList arrayList6 = arrayList5;
                            pageEvent$Insert$flatMap$1.L$0 = function22;
                            pageEvent$Insert$flatMap$1.L$1 = insert;
                            pageEvent$Insert$flatMap$1.L$2 = loadType;
                            pageEvent$Insert$flatMap$1.L$3 = obj4;
                            pageEvent$Insert$flatMap$1.L$4 = it;
                            pageEvent$Insert$flatMap$1.L$5 = transformablePage2;
                            pageEvent$Insert$flatMap$1.L$6 = arrayList5;
                            pageEvent$Insert$flatMap$1.L$7 = arrayList;
                            pageEvent$Insert$flatMap$1.L$8 = it2;
                            pageEvent$Insert$flatMap$1.L$9 = arrayList6;
                            pageEvent$Insert$flatMap$1.L$10 = arrayList4;
                            pageEvent$Insert$flatMap$1.I$0 = i6;
                            pageEvent$Insert$flatMap$1.I$1 = i5;
                            Insert<T> insert3 = insert;
                            pageEvent$Insert$flatMap$1.label = 1;
                            Object invoke = function22.invoke(obj5, pageEvent$Insert$flatMap$1);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            transformablePage = transformablePage2;
                            i4 = i6;
                            loadType3 = loadType;
                            function23 = function22;
                            obj2 = invoke;
                            obj3 = obj4;
                            collection = arrayList6;
                            insert2 = insert3;
                            arrayList2 = arrayList4;
                            arrayList3 = arrayList5;
                            CollectionsKt.addAll(collection, (Iterable) obj2);
                            List<Integer> hintOriginalIndices2 = transformablePage.getHintOriginalIndices();
                            if (hintOriginalIndices2 != null) {
                            }
                            while (arrayList.size() < arrayList3.size()) {
                            }
                            function22 = function23;
                            i5 = i4;
                            Object obj42 = obj3;
                            loadType = loadType3;
                            insert = insert2;
                            TransformablePage transformablePage22 = transformablePage;
                            ArrayList arrayList42 = arrayList2;
                            ArrayList arrayList52 = arrayList3;
                            if (it2.hasNext()) {
                                arrayList42.add(new TransformablePage(transformablePage22.getOriginalPageOffsets(), arrayList52, transformablePage22.getHintOriginalPageOffset(), arrayList));
                                insert = insert;
                                obj = obj42;
                                if (it.hasNext()) {
                                    Insert<T> insert4 = insert;
                                    return new Insert(loadType, (List) obj, insert4.getPlaceholdersBefore(), insert4.getPlaceholdersAfter(), insert4.getSourceLoadStates(), insert4.getMediatorLoadStates(), null);
                                }
                                TransformablePage transformablePage3 = (TransformablePage) it.next();
                                arrayList = new ArrayList();
                                Iterator<T> it4 = transformablePage3.getData().iterator();
                                i5 = 0;
                                arrayList52 = new ArrayList();
                                it2 = it4;
                                transformablePage22 = transformablePage3;
                                obj42 = obj;
                                arrayList42 = obj;
                                if (it2.hasNext()) {
                                }
                            }
                        }
                    }
                }
            }
            insert = this;
            pageEvent$Insert$flatMap$1 = new PageEvent$Insert$flatMap$1(insert, continuation);
            Object obj22 = pageEvent$Insert$flatMap$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = pageEvent$Insert$flatMap$1.label;
            if (i != 0) {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0104  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0136  */
        /* JADX WARN: Type inference failed for: r10v8, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r6v9, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0095 -> B:18:0x00b9). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ee -> B:27:0x00fc). Please submit an issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object filter(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super PageEvent<T>> continuation) {
            PageEvent$Insert$filter$1 pageEvent$Insert$filter$1;
            Insert<T> insert;
            int i;
            Iterator<T> it;
            Object obj;
            LoadType loadType;
            Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function22;
            if (continuation instanceof PageEvent$Insert$filter$1) {
                pageEvent$Insert$filter$1 = (PageEvent$Insert$filter$1) continuation;
                if ((pageEvent$Insert$filter$1.label & Integer.MIN_VALUE) != 0) {
                    pageEvent$Insert$filter$1.label -= Integer.MIN_VALUE;
                    insert = this;
                    Object obj2 = pageEvent$Insert$filter$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pageEvent$Insert$filter$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        LoadType loadType2 = insert.getLoadType();
                        List<TransformablePage<T>> pages = insert.getPages();
                        it = pages.iterator();
                        obj = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(pages, 10));
                        loadType = loadType2;
                        function22 = function2;
                        if (it.hasNext()) {
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i2 = pageEvent$Insert$filter$1.I$1;
                        int i3 = pageEvent$Insert$filter$1.I$0;
                        Object obj3 = pageEvent$Insert$filter$1.L$9;
                        Iterator<T> it2 = (Iterator) pageEvent$Insert$filter$1.L$8;
                        ArrayList arrayList = (List) pageEvent$Insert$filter$1.L$7;
                        TransformablePage transformablePage = (TransformablePage) pageEvent$Insert$filter$1.L$5;
                        LoadType loadType3 = (LoadType) pageEvent$Insert$filter$1.L$2;
                        Insert<T> insert2 = (Insert) pageEvent$Insert$filter$1.L$1;
                        Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function23 = (Function2) pageEvent$Insert$filter$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        int i4 = i3;
                        it = (Iterator) pageEvent$Insert$filter$1.L$4;
                        TransformablePage transformablePage2 = transformablePage;
                        ArrayList arrayList2 = (Collection) pageEvent$Insert$filter$1.L$10;
                        ArrayList arrayList3 = (List) pageEvent$Insert$filter$1.L$6;
                        Object obj4 = (Collection) pageEvent$Insert$filter$1.L$3;
                        if (((Boolean) obj2).booleanValue()) {
                            arrayList3.add(obj3);
                            List<Integer> hintOriginalIndices = transformablePage2.getHintOriginalIndices();
                            if (hintOriginalIndices != null) {
                                i2 = hintOriginalIndices.get(i2).intValue();
                            }
                            arrayList.add(Boxing.boxInt(i2));
                        }
                        function22 = function23;
                        Object obj5 = obj4;
                        loadType = loadType3;
                        insert = insert2;
                        ArrayList arrayList4 = arrayList2;
                        ArrayList arrayList5 = arrayList3;
                        if (it2.hasNext()) {
                            Object next = it2.next();
                            int i5 = i4 + 1;
                            if (i4 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            pageEvent$Insert$filter$1.L$0 = function22;
                            pageEvent$Insert$filter$1.L$1 = insert;
                            pageEvent$Insert$filter$1.L$2 = loadType;
                            pageEvent$Insert$filter$1.L$3 = obj5;
                            pageEvent$Insert$filter$1.L$4 = it;
                            pageEvent$Insert$filter$1.L$5 = transformablePage2;
                            pageEvent$Insert$filter$1.L$6 = arrayList5;
                            pageEvent$Insert$filter$1.L$7 = arrayList;
                            pageEvent$Insert$filter$1.L$8 = it2;
                            pageEvent$Insert$filter$1.L$9 = next;
                            pageEvent$Insert$filter$1.L$10 = arrayList4;
                            pageEvent$Insert$filter$1.I$0 = i5;
                            pageEvent$Insert$filter$1.I$1 = i4;
                            pageEvent$Insert$filter$1.label = 1;
                            Object invoke = function22.invoke(next, pageEvent$Insert$filter$1);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            LoadType loadType4 = loadType;
                            function23 = function22;
                            obj2 = invoke;
                            insert2 = insert;
                            i2 = i4;
                            i4 = i5;
                            loadType3 = loadType4;
                            obj4 = obj5;
                            obj3 = next;
                            arrayList2 = arrayList4;
                            arrayList3 = arrayList5;
                            if (((Boolean) obj2).booleanValue()) {
                            }
                            function22 = function23;
                            Object obj52 = obj4;
                            loadType = loadType3;
                            insert = insert2;
                            ArrayList arrayList42 = arrayList2;
                            ArrayList arrayList52 = arrayList3;
                            if (it2.hasNext()) {
                                arrayList42.add(new TransformablePage(transformablePage2.getOriginalPageOffsets(), arrayList52, transformablePage2.getHintOriginalPageOffset(), arrayList));
                                obj = obj52;
                                if (it.hasNext()) {
                                    return new Insert(loadType, (List) obj, insert.getPlaceholdersBefore(), insert.getPlaceholdersAfter(), insert.getSourceLoadStates(), insert.getMediatorLoadStates(), null);
                                }
                                TransformablePage transformablePage3 = (TransformablePage) it.next();
                                arrayList = new ArrayList();
                                Iterator<T> it3 = transformablePage3.getData().iterator();
                                i4 = 0;
                                arrayList52 = new ArrayList();
                                it2 = it3;
                                transformablePage2 = transformablePage3;
                                obj52 = obj;
                                arrayList42 = obj;
                                if (it2.hasNext()) {
                                }
                            }
                        }
                    }
                }
            }
            insert = this;
            pageEvent$Insert$filter$1 = new PageEvent$Insert$filter$1(insert, continuation);
            Object obj22 = pageEvent$Insert$filter$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = pageEvent$Insert$filter$1.label;
            if (i != 0) {
            }
        }

        /* compiled from: PageEvent.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0002\u0010\u0006*\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eJF\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0002\u0010\u0006*\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eJF\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0002\u0010\u0006*\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t0\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¨\u0006\u0012"}, d2 = {"Landroidx/paging/PageEvent$Insert$Companion;", "", "<init>", "()V", HttpHeaders.REFRESH, "Landroidx/paging/PageEvent$Insert;", ExifInterface.GPS_DIRECTION_TRUE, "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersBefore", "", "placeholdersAfter", "sourceLoadStates", "Landroidx/paging/LoadStates;", "mediatorLoadStates", "Prepend", "Append", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Insert Refresh$default(Companion companion, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2, int i3, Object obj) {
                if ((i3 & 16) != 0) {
                    loadStates2 = null;
                }
                return companion.Refresh(list, i, i2, loadStates, loadStates2);
            }

            public final <T> Insert<T> Refresh(List<TransformablePage<T>> pages, int i, int i2, LoadStates sourceLoadStates, LoadStates loadStates) {
                Intrinsics.checkNotNullParameter(pages, "pages");
                Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
                return new Insert<>(LoadType.REFRESH, pages, i, i2, sourceLoadStates, loadStates, null);
            }

            public static /* synthetic */ Insert Prepend$default(Companion companion, List list, int i, LoadStates loadStates, LoadStates loadStates2, int i2, Object obj) {
                if ((i2 & 8) != 0) {
                    loadStates2 = null;
                }
                return companion.Prepend(list, i, loadStates, loadStates2);
            }

            public final <T> Insert<T> Prepend(List<TransformablePage<T>> pages, int i, LoadStates sourceLoadStates, LoadStates loadStates) {
                Intrinsics.checkNotNullParameter(pages, "pages");
                Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
                return new Insert<>(LoadType.PREPEND, pages, i, -1, sourceLoadStates, loadStates, null);
            }

            public static /* synthetic */ Insert Append$default(Companion companion, List list, int i, LoadStates loadStates, LoadStates loadStates2, int i2, Object obj) {
                if ((i2 & 8) != 0) {
                    loadStates2 = null;
                }
                return companion.Append(list, i, loadStates, loadStates2);
            }

            public final <T> Insert<T> Append(List<TransformablePage<T>> pages, int i, LoadStates sourceLoadStates, LoadStates loadStates) {
                Intrinsics.checkNotNullParameter(pages, "pages");
                Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
                return new Insert<>(LoadType.APPEND, pages, -1, i, sourceLoadStates, loadStates, null);
            }
        }

        public String toString() {
            List<T> data;
            List<T> data2;
            Iterator<T> it = this.pages.iterator();
            int i = 0;
            while (it.hasNext()) {
                i += ((TransformablePage) it.next()).getData().size();
            }
            int i2 = this.placeholdersBefore;
            String valueOf = i2 != -1 ? String.valueOf(i2) : "none";
            int i3 = this.placeholdersAfter;
            String valueOf2 = i3 != -1 ? String.valueOf(i3) : "none";
            LoadStates loadStates = this.mediatorLoadStates;
            StringBuilder append = new StringBuilder("PageEvent.Insert for ").append(this.loadType).append(", with ").append(i).append(" items (\n                    |   first item: ");
            TransformablePage transformablePage = (TransformablePage) CollectionsKt.firstOrNull((List<? extends Object>) this.pages);
            StringBuilder append2 = append.append((transformablePage == null || (data2 = transformablePage.getData()) == null) ? null : CollectionsKt.firstOrNull((List<? extends Object>) data2)).append("\n                    |   last item: ");
            TransformablePage transformablePage2 = (TransformablePage) CollectionsKt.lastOrNull((List<? extends Object>) this.pages);
            String sb = append2.append((transformablePage2 == null || (data = transformablePage2.getData()) == null) ? null : CollectionsKt.lastOrNull((List<? extends Object>) data)).append("\n                    |   placeholdersBefore: ").append(valueOf).append("\n                    |   placeholdersAfter: ").append(valueOf2).append("\n                    |   sourceLoadStates: ").append(this.sourceLoadStates).append("\n                    ").toString();
            if (loadStates != null) {
                sb = sb + "|   mediatorLoadStates: " + loadStates + '\n';
            }
            return StringsKt.trimMargin$default(sb + "|)", null, 1, null);
        }

        private final <R> Insert<R> mapPages(Function1<? super TransformablePage<T>, TransformablePage<R>> function1) {
            LoadType loadType = getLoadType();
            List<TransformablePage<T>> pages = getPages();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages, 10));
            for (Object obj : pages) {
                arrayList.add(function1.invoke(obj));
            }
            return new Insert<>(loadType, arrayList, getPlaceholdersBefore(), getPlaceholdersAfter(), getSourceLoadStates(), getMediatorLoadStates(), null);
        }
    }

    /* compiled from: PageEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J7\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Landroidx/paging/PageEvent$Drop;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PageEvent;", "loadType", "Landroidx/paging/LoadType;", "minPageOffset", "", "maxPageOffset", "placeholdersRemaining", "<init>", "(Landroidx/paging/LoadType;III)V", "getLoadType", "()Landroidx/paging/LoadType;", "getMinPageOffset", "()I", "getMaxPageOffset", "getPlaceholdersRemaining", "pageCount", "getPageCount", "toString", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Drop<T> extends PageEvent<T> {
        private final LoadType loadType;
        private final int maxPageOffset;
        private final int minPageOffset;
        private final int placeholdersRemaining;

        /* compiled from: PageEvent.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LoadType.values().length];
                try {
                    iArr[LoadType.APPEND.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LoadType.PREPEND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public static /* synthetic */ Drop copy$default(Drop drop, LoadType loadType, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                loadType = drop.loadType;
            }
            if ((i4 & 2) != 0) {
                i = drop.minPageOffset;
            }
            if ((i4 & 4) != 0) {
                i2 = drop.maxPageOffset;
            }
            if ((i4 & 8) != 0) {
                i3 = drop.placeholdersRemaining;
            }
            return drop.copy(loadType, i, i2, i3);
        }

        public final LoadType component1() {
            return this.loadType;
        }

        public final int component2() {
            return this.minPageOffset;
        }

        public final int component3() {
            return this.maxPageOffset;
        }

        public final int component4() {
            return this.placeholdersRemaining;
        }

        public final Drop<T> copy(LoadType loadType, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            return new Drop<>(loadType, i, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Drop) {
                Drop drop = (Drop) obj;
                return this.loadType == drop.loadType && this.minPageOffset == drop.minPageOffset && this.maxPageOffset == drop.maxPageOffset && this.placeholdersRemaining == drop.placeholdersRemaining;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.loadType.hashCode() * 31) + Integer.hashCode(this.minPageOffset)) * 31) + Integer.hashCode(this.maxPageOffset)) * 31) + Integer.hashCode(this.placeholdersRemaining);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Drop(LoadType loadType, int i, int i2, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            this.loadType = loadType;
            this.minPageOffset = i;
            this.maxPageOffset = i2;
            this.placeholdersRemaining = i3;
            if (loadType == LoadType.REFRESH) {
                throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND".toString());
            }
            if (getPageCount() <= 0) {
                throw new IllegalArgumentException(("Drop count must be > 0, but was " + getPageCount()).toString());
            }
            if (i3 < 0) {
                throw new IllegalArgumentException(("Invalid placeholdersRemaining " + i3).toString());
            }
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final int getMinPageOffset() {
            return this.minPageOffset;
        }

        public final int getMaxPageOffset() {
            return this.maxPageOffset;
        }

        public final int getPlaceholdersRemaining() {
            return this.placeholdersRemaining;
        }

        public final int getPageCount() {
            return (this.maxPageOffset - this.minPageOffset) + 1;
        }

        public String toString() {
            String str;
            int i = WhenMappings.$EnumSwitchMapping$0[this.loadType.ordinal()];
            if (i == 1) {
                str = TtmlNode.END;
            } else if (i != 2) {
                throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND");
            } else {
                str = "front";
            }
            return StringsKt.trimMargin$default("PageEvent.Drop from the " + str + " (\n                    |   minPageOffset: " + this.minPageOffset + "\n                    |   maxPageOffset: " + this.maxPageOffset + "\n                    |   placeholdersRemaining: " + this.placeholdersRemaining + "\n                    |)", null, 1, null);
        }
    }

    /* compiled from: PageEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Landroidx/paging/PageEvent$LoadStateUpdate;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PageEvent;", "source", "Landroidx/paging/LoadStates;", "mediator", "<init>", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "getSource", "()Landroidx/paging/LoadStates;", "getMediator", "toString", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class LoadStateUpdate<T> extends PageEvent<T> {
        private final LoadStates mediator;
        private final LoadStates source;

        public static /* synthetic */ LoadStateUpdate copy$default(LoadStateUpdate loadStateUpdate, LoadStates loadStates, LoadStates loadStates2, int i, Object obj) {
            if ((i & 1) != 0) {
                loadStates = loadStateUpdate.source;
            }
            if ((i & 2) != 0) {
                loadStates2 = loadStateUpdate.mediator;
            }
            return loadStateUpdate.copy(loadStates, loadStates2);
        }

        public final LoadStates component1() {
            return this.source;
        }

        public final LoadStates component2() {
            return this.mediator;
        }

        public final LoadStateUpdate<T> copy(LoadStates source, LoadStates loadStates) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new LoadStateUpdate<>(source, loadStates);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadStateUpdate) {
                LoadStateUpdate loadStateUpdate = (LoadStateUpdate) obj;
                return Intrinsics.areEqual(this.source, loadStateUpdate.source) && Intrinsics.areEqual(this.mediator, loadStateUpdate.mediator);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.source.hashCode() * 31;
            LoadStates loadStates = this.mediator;
            return hashCode + (loadStates == null ? 0 : loadStates.hashCode());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadStateUpdate(LoadStates source, LoadStates loadStates) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.mediator = loadStates;
        }

        public /* synthetic */ LoadStateUpdate(LoadStates loadStates, LoadStates loadStates2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadStates, (i & 2) != 0 ? null : loadStates2);
        }

        public final LoadStates getMediator() {
            return this.mediator;
        }

        public final LoadStates getSource() {
            return this.source;
        }

        public String toString() {
            LoadStates loadStates = this.mediator;
            String str = "PageEvent.LoadStateUpdate (\n                    |   sourceLoadStates: " + this.source + "\n                    ";
            if (loadStates != null) {
                str = str + "|   mediatorLoadStates: " + loadStates + '\n';
            }
            return StringsKt.trimMargin$default(str + "|)", null, 1, null);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    static /* synthetic */ <T, R> java.lang.Object map$suspendImpl(androidx.paging.PageEvent<T> r0, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r1, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r2) {
        /*
            java.lang.String r1 = "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.PageEvent.map>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.map$suspendImpl(androidx.paging.PageEvent, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    static /* synthetic */ <T, R> java.lang.Object flatMap$suspendImpl(androidx.paging.PageEvent<T> r0, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Iterable<? extends R>>, ? extends java.lang.Object> r1, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r2) {
        /*
            java.lang.String r1 = "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.PageEvent.flatMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.flatMap$suspendImpl(androidx.paging.PageEvent, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
